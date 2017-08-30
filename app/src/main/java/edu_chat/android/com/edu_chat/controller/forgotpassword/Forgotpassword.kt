package edu_chat.android.com.edu_chat.controller.forgotpassword

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import chat.edu.edu_chat.R.layout
import com.github.javiersantos.appupdater.AppUpdater
import com.instabug.library.InstabugTrackingDelegate
import io.swagger.client.ApiCallback
import io.swagger.client.ApiException
import io.swagger.client.api.PasswordApi
import io.swagger.client.model.LogoutView
import io.swagger.client.model.RequestPassword
import kotlinx.android.synthetic.main.activity_forgot_pass.*


/**
 * Created by mingdimao on 6/6/17.
 * Edu.Chat Inc.
 */

class Forgotpassword : AppCompatActivity() {

	override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
		InstabugTrackingDelegate.notifyActivityGotTouchEvent(ev, this)
		return super.dispatchTouchEvent(ev)
	}


	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		this.setContentView(layout.activity_forgot_pass)
		val appUpdater = AppUpdater(this)
		appUpdater.start()
		Log.i("view", "successfully enter forgotpassword view")
		if (this.email_textview == null) throw AssertionError()
		if (this.intent.hasExtra("email")) {
			email_textview!!.setText(this.intent.getStringExtra("email"))
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
		this.submit_button!!.setOnClickListener { requestretrieve() }
	}

	private fun requestretrieve() {
		val requestPasswordPacket = RequestPassword()
		requestPasswordPacket.email = this.email_textview!!.text.toString()
		try {
			if (this.email_textview!!.text != null)
				PasswordApi().passwordRequestCreateAsync(
						requestPasswordPacket,
						object : ApiCallback<LogoutView> {
							override fun onFailure(e: ApiException,
												   statusCode: Int,
												   responseHeaders: Map<String, List<String>>) {
								Log.i("forgotpassword", "Failed")
								this@Forgotpassword.runOnUiThread {
									Toast.makeText(
											this@Forgotpassword.applicationContext,
											"Email doesn't exist!",
											Toast.LENGTH_SHORT
									).show()
									email_textview!!.setText("")
								}
							}

							override fun onSuccess(result: LogoutView,
												   statusCode: Int,
												   responseHeaders: Map<String, List<String>>) {
								Log.i("forgotpassword", "Success")
								this@Forgotpassword.runOnUiThread {
									Toast.makeText(
											this@Forgotpassword.applicationContext,
											"Success!",
											Toast.LENGTH_SHORT
									).show()
									email_textview!!.setText("")
								}
							}

							override fun onUploadProgress(bytesWritten: Long,
														  contentLength: Long,
														  done: Boolean) {
								Log.i("forgotpassword", "Uploading")
							}

							override fun onDownloadProgress(bytesRead: Long,
															contentLength: Long,
															done: Boolean) {
								Log.i(
										"forgotpassword",
										"Downloading"
								)
							}
						}
				)
		} catch (e: ApiException) {
			e.printStackTrace()
		}

	}
}
