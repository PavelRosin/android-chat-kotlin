package edu_chat.android.com.edu_chat.controller

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
 import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import chat.edu.edu_chat.BuildConfig
import chat.edu.edu_chat.R
import com.github.javiersantos.appupdater.AppUpdater
import com.google.android.gms.gcm.GoogleCloudMessaging
import com.google.android.gms.iid.InstanceID
import com.instabug.library.InstabugTrackingDelegate
import edu_chat.android.com.edu_chat.controller.forgotpassword.Forgotpassword
import edu_chat.android.com.edu_chat.controller.chat_list.ChatListActivity
import edu_chat.android.com.edu_chat.controller.message_list.MessageListActivity
import edu_chat.android.com.edu_chat.controller.message_list.MessageListFragment
import edu_chat.android.com.edu_chat.controller.signup.SignUpActivity
import edu_chat.android.com.edu_chat.model.CurrentUser
import io.swagger.client.ApiCallback
import io.swagger.client.ApiClient
import io.swagger.client.ApiException
import io.swagger.client.Configuration
import io.swagger.client.api.ApiApi
import io.swagger.client.api.UserApi
import io.swagger.client.model.Login
import io.swagger.client.model.LoginInput
import io.swagger.client.model.UserTokenRetrieveView
import kotlinx.android.synthetic.main.activity_new_login.*

/**
 * Created by Niebloomj on 8/6/16.
 * Edu.Chat Inc.
 */
class LoginActivity : AppCompatActivity() {

	override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
		InstabugTrackingDelegate.notifyActivityGotTouchEvent(ev, this)
		return super.dispatchTouchEvent(ev)
	}

	@SuppressLint("ClickableViewAccessibility")
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		this.setContentView(R.layout.activity_new_login)
		val appUpdater = AppUpdater(this)
		appUpdater.start()
		val prefs = getSharedPreferences("login.conf", Context.MODE_PRIVATE)

		if ("user" in prefs!!) {
			val data = LoginInput()
//			if (data.pushToken != null)
//			{
//				this.startActivity(Intent(this, ChatListActivity::class.java))
//			}
			data.username = prefs.getString("user", "")
			data.password = prefs.getString("pass", "")
			attemptLogin(data)
		}

		login_button.setOnClickListener {
			val data = LoginInput()
			data.username = email_textview.text.toString()
			data.password = password_textview.text.toString()
			this@LoginActivity.attemptLogin(data)
		}

		email_textview!!.setOnTouchListener(View.OnTouchListener { _, event ->
			val DRAWABLE_RIGHT = 2
			if (event.action == MotionEvent.ACTION_UP) {
				if (event.rawX >= email_textview!!.right - email_textview!!.compoundDrawables[DRAWABLE_RIGHT].bounds.width()) {
					email_textview!!.setText("")
					email_textview!!.requestFocus()
					return@OnTouchListener true
				}
			}
			false
		})

		password_textview!!.setOnTouchListener(View.OnTouchListener { _, event ->
			val DRAWABLE_RIGHT = 2
			if (event.action == MotionEvent.ACTION_UP) {
				if (event.rawX >= password_textview!!.right - password_textview!!.compoundDrawables[DRAWABLE_RIGHT].bounds.width()) {
					password_textview!!.setText("")
					password_textview!!.requestFocus()
					return@OnTouchListener true
				}
			}
			false
		})

		layout!!.setOnTouchListener { v, _ ->
			(getSystemService(
					Context.INPUT_METHOD_SERVICE
			) as InputMethodManager).hideSoftInputFromWindow(
					v.windowToken, InputMethodManager.HIDE_NOT_ALWAYS
			)
			false
		}
		forgot_textview!!.isClickable = true
		forgot_textview!!.isFocusable = true
		forgot_textview!!.setOnClickListener { this@LoginActivity.createforgotpasswordview() }
		sign_up_textview!!.isClickable = true
		sign_up_textview!!.isFocusable = true
		sign_up_textview!!.setOnClickListener { this@LoginActivity.createSignUpActivity() }
		if (this.build_version_textview != null) {
			val version = BuildConfig.VERSION_CODE
			val versionName = BuildConfig.VERSION_NAME
			this.build_version_textview!!.text = String.format("%s (%d)", versionName, version)
		}

		this.password_textview!!.setOnEditorActionListener(TextView.OnEditorActionListener {
			_, actionId, event ->
			val data = LoginInput()
			data.username = email_textview!!.text.toString()
			data.password = password_textview!!.text.toString()
			if (actionId == EditorInfo.IME_NULL && event.action == KeyEvent.ACTION_DOWN) {
				attemptLogin(data)
				Log.i("Login", "Login attempt by enter key")
				return@OnEditorActionListener true
			} else if (actionId == EditorInfo.IME_ACTION_DONE) {
				attemptLogin(data)
				Log.i("Login", "Login attempt by soft keyboard enter/done key")
				return@OnEditorActionListener true
			}
			false
		})
	}

	companion object {
		fun gettingCurrentUser(result:Login, finalData: LoginInput, prefs: SharedPreferences): ApiClient {
			val editor = prefs!!.edit()
			editor.putString("user", finalData!!.username)
			editor.putString("pass", finalData.password)
			editor.apply()
			Log.d("USER", result!!.results.user.email)
			CurrentUser.currentUser = result.results.user
			CurrentUser.token = result.results.token
			Log.d("USER", result.results.user.toString())
			Log.d("USER", CurrentUser.currentUser!!.userBio + "")
			val apiClient = ApiClient()
			val key = String.format("Token %s", result.results.token)
			Log.d("USER", key)
			apiClient.setApiKey(key)
			Log.d("USER", apiClient.getAuthentication("Token").toString())
			apiClient.addDefaultHeader("Authentication", key)
			return apiClient
		}
	}

	private fun attemptLogin(_data: LoginInput) {
//        if (status!!) {
//            this.progressDialog = ProgressDialog(this)
//            this.progressDialog!!.setMessage("Logging In...")
//            this.progressDialog!!.isIndeterminate = true
//            this.progressDialog!!.show()
//        }

		val data = _data
		data.platform = "android"
		Thread(Runnable {

			Log.d("PushToken", "We got here")
			data.pushToken = InstanceID.getInstance(this).getToken(
					getString(R.string.gcm_defaultSenderId),
					GoogleCloudMessaging.INSTANCE_ID_SCOPE
			)
			Log.d("PushToken", data.pushToken)

			if (data.username == "" || data.password == "") {
				data.username = this.email_textview!!.text.toString()
				data.password = this.password_textview!!.text.toString()
			}

			Log.d("Username", data.username)
			Configuration.setDefaultApiClient(ApiClient())

			try {
				val finalData = data
				Configuration.setDefaultApiClient(ApiClient())
				ApiApi().apiLoginCreateAsync(data, object : ApiCallback<Login> {
					override fun onFailure(e: ApiException,
										   statusCode: Int,
										   responseHeaders: Map<String, List<String>>?) {
//                    this@LoginActivity.progressDialog!!.dismiss()
						Log.d("Login", statusCode.toString())
						Log.d("Login", e.responseBody)
						this@LoginActivity.displayToast(getString(R.string.incorrect_user_or_pass))
					}

					override fun onSuccess(result: Login,
										   statusCode: Int,
										   responseHeaders: Map<String, List<String>>?) {
						val prefs = getSharedPreferences(
								"login.conf", Context.MODE_PRIVATE
						)

						var apiClient = gettingCurrentUser(result, finalData,prefs)
						Configuration.setDefaultApiClient(apiClient)

						val fcm_chat = intent.getStringExtra("fcm_chat")
						if(fcm_chat == "" || fcm_chat == null){
							loginSuccessful(true, Intent(this@LoginActivity, ChatListActivity::class.java))
						}
						else{
							var intent = Intent(this@LoginActivity, MessageListActivity::class.java)
							intent.putExtra("fromFcm", true)
							intent.putExtra("fcm_chat", fcm_chat)
							finish()
							startActivity(intent)
						}

					}

					override fun onUploadProgress(bytesWritten: Long,
												  contentLength: Long,
												  done: Boolean) {
						//System.out.println("Uploading");
						Log.d("Login", "Uploading")

					}

					override fun onDownloadProgress(bytesRead: Long,
													contentLength: Long,
													done: Boolean) {
						//System.out.println("Downloading");
						Log.d("Login", "Downloading")
					}

				})
			} catch (e: ApiException) {
				e.printStackTrace()
			}
		}).start()

	}

	private fun loginSuccessful(success: Boolean, intent: Intent) {
		Log.d("Login", "Called loginSuccessful with " + success)
//		if (CurrentUser.token != null)
//		{
//			Log.d("user already signed in", "user has already signed in")
//			this.startActivity(Intent(this, ChatListActivity::class.java))
//			Log.d("completing line", "completing line")
//		}
		Log.d("working", "checking if token is null")
		if (success) {
			// Think this line is causing the 114 issue on insta bug
			Log.d("going into success", "going into success")
			if (this.applicationContext != null) {
				this.finish()
				this.startActivity(intent)
			}
		} else {
			Toast.makeText(this, getString(R.string.login_failed), Toast.LENGTH_LONG).show()
		}
	}


	private fun createforgotpasswordview() {
		Log.d("ForgotPassword", "jumping the view to forgotpassword")
		val intent = Intent(this, Forgotpassword::class.java)
		intent.putExtra("email", email_textview!!.text.toString())
		this.startActivity(intent)
	}

	private fun createSignUpActivity() {
		Log.d("SignUp", "SignUpActivity created")
		this.startActivity(Intent(this, SignUpActivity::class.java))
	}

	fun displayToast(msg: String) = runOnUiThread {
		Toast.makeText(this@LoginActivity.applicationContext, msg, Toast.LENGTH_SHORT).show()
	}

}
