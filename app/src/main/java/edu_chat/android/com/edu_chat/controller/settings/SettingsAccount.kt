package edu_chat.android.com.edu_chat.controller.settings

import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import chat.edu.edu_chat.R
import edu_chat.android.com.edu_chat.model.CurrentUser
import io.swagger.client.ApiCallback
import io.swagger.client.ApiException
import io.swagger.client.api.PasswordApi
import io.swagger.client.model.LogoutView
import io.swagger.client.model.RequestPassword
import kotlinx.android.synthetic.main.fragment_settings_account.*

/**
 * Created by Billy Yang on 06/19/2017
 */
class SettingsAccount : Fragment() {

	private val options = arrayOfNulls<TextView>(1)

	override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
							  savedInstanceState: Bundle?): View? {
		return inflater!!.inflate(R.layout.fragment_settings_account, container, false)
	}

	override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		this.options[0] = settings_account_reset_password
		val user = CurrentUser.currentUser
		val email = user!!.email
		val phoneNumber = user.phoneNum

		// Inflate the layout for this fragment
		val override = OverwriteText()
		override.overrideFont(view!!)
		// Toolbar with title and back button to settings
		(activity as AppCompatActivity).setSupportActionBar(toolbar_settings_account as Toolbar)
		(toolbar_settings_account as Toolbar).setNavigationIcon(R.drawable.instabug_ic_back)
		(toolbar_settings_account as Toolbar).setNavigationOnClickListener {
			val handler = Handler()
			handler.postDelayed({ activity.onBackPressed() }, 100L)
		}
		//Shown user email
		this.settings_account_email!!.text = email
		this.settings_account_phone!!.text = phoneNumber

		this.settings_account_reset_password!!.setOnClickListener { this@SettingsAccount.requestResetPassword() }
		this.settings_account_privacy!!.setOnClickListener { this@SettingsAccount.settingsPrivacy() }
	}

	private fun requestResetPassword() {
		// Get dialog edit text view
		val layoutInflater = LayoutInflater.from(context)
		val view = layoutInflater.inflate(R.layout.settings_account_resetpassword_dialog, null)

		val builder = AlertDialog.Builder(context)
		val dialogTitle = "Reset Password"
		builder.setTitle(dialogTitle)
		builder.setView(view)
		val email = view.findViewById<EditText>(R.id.settings_account_reset_dialog_email)

		email.setOnTouchListener(View.OnTouchListener { _, motionEvent ->
			val DRAWABLE_RIGHT = 2
			if (motionEvent.action == MotionEvent.ACTION_UP) {
				if (motionEvent.rawX >= email.right - email.compoundDrawables[DRAWABLE_RIGHT].bounds.width()) {
					email.setText("")
					return@OnTouchListener true
				}
			}
			false
		})

		val dialogPositiveButton = "Submit"
		builder.setPositiveButton(dialogPositiveButton) { _, _ -> attemptResetPassword(email) }
		val dialogNegativeButton = "Cancel"
		builder.setNegativeButton(dialogNegativeButton) { dialogInterface, _ -> dialogInterface.dismiss() }

		val alertDialog = builder.create()
		alertDialog.show()
	}


	private fun attemptResetPassword(email: EditText) {
		val apiInstance = PasswordApi()
		val requestPassword = RequestPassword()
		requestPassword.email = email.text.toString()

		if (CurrentUser.currentUser!!.email == email.text.toString()) {
			try {
				if (email.text != null)
					apiInstance.passwordRequestCreateAsync(
							requestPassword,
							object : ApiCallback<LogoutView> {
								override fun onFailure(e: ApiException,
													   statusCode: Int,
													   responseHeaders: Map<String, List<String>>) {
									Log.i("resetpassword", "Failed")
									activity.runOnUiThread {
										Toast.makeText(
												activity.applicationContext,
												"Email doesn't exist!",
												Toast.LENGTH_SHORT
										).show()
										email.setText("")
									}
								}

								override fun onSuccess(result: LogoutView,
													   statusCode: Int,
													   responseHeaders: Map<String, List<String>>) {
									Log.i(
											"resetpassword",
											"Success"
									)
									activity.runOnUiThread {
										Toast.makeText(
												activity.applicationContext,
												"A verification email has been sent to your " + "email address!",
												Toast.LENGTH_SHORT
										).show()
										email.setText("")
									}
								}

								override fun onUploadProgress(bytesWritten: Long,
															  contentLength: Long,
															  done: Boolean) {
									Log.i(
											"resetpassword",
											"Uploading"
									)
								}

								override fun onDownloadProgress(bytesRead: Long,
																contentLength: Long,
																done: Boolean) {
									Log.i(
											"resetpassword",
											"Downloading"
									)
								}
							}
					)
			} catch (e: ApiException) {
				e.printStackTrace()
			}

		} else {
			Toast.makeText(
					activity.applicationContext,
					"Type in your correct E-mail address!",
					Toast.LENGTH_SHORT
			).show()
		}
	}

	private fun settingsPrivacy() {
		val handler = Handler()
		handler.postDelayed({
			val settingsAccountPrivacy = SettingsAccountPrivacy()
			val ft = this@SettingsAccount.activity
					.supportFragmentManager
					.beginTransaction()
			ft.replace(R.id.settings_framelayout, settingsAccountPrivacy)
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
			ft.addToBackStack(null)
			ft.commit()
		}, 100L)

	}
	//    private void overrideFont(final View v){
	//        SharedPreferences sp = getActivity().getSharedPreferences("text_size.conf", Context.MODE_PRIVATE);
	//        float ts = sp.getFloat(getString(R.string.saved_textSize), getResources().getDimension(R.dimen.text_size_16));
	//        try {
	//            if (v instanceof ViewGroup) {
	//                ViewGroup vg = (ViewGroup) v;
	//                for (int i = 0; i < vg.getChildCount(); i++) {
	//                    View child = vg.getChildAt(i);
	//                    overrideFont(child);
	//                }
	//            } else if (v instanceof TextView) {
	//                ((TextView) v).setTextSize(TypedValue.COMPLEX_UNIT_PX, ts);
	//            }
	//        } catch (Exception e) {
	//        }
	//    }
}
