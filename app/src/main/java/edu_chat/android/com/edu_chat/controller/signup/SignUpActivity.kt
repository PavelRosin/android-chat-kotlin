package edu_chat.android.com.edu_chat.controller.signup

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MotionEvent
import chat.edu.edu_chat.R
import chat.edu.edu_chat.R.layout
import com.instabug.library.InstabugTrackingDelegate
import kotlinx.android.synthetic.main.activity_sign_up.*


/**
 * Created by yuandali on 8/5/16.
 * Edu.Chat Inc.
 */

class SignUpActivity : AppCompatActivity() {

	override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
		InstabugTrackingDelegate.notifyActivityGotTouchEvent(ev, this)
		return super.dispatchTouchEvent(ev)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		this.setContentView(layout.activity_sign_up)


		sign_up_framelayout!!.bringToFront()
		val signUpOneFragment = SignUpOneFragment()
		val ft = this.supportFragmentManager.beginTransaction()
		ft.replace(R.id.sign_up_framelayout, signUpOneFragment)
		ft.commit()
	}


//	fun attemptSignUp() {
//		val newUser = UserApi()
//		val apiViewUserSerializerPacket = APIViewUserSerializer()
//
//		try {
//			newUser.userSignupCreateAsync(apiViewUserSerializerPacket, object : ApiCallback<Login> {
//				override fun onFailure(e: ApiException,
//									   statusCode: Int,
//									   responseHeaders: Map<String, List<String>>) {
//					Log.e("error", "Sign Up not working")
//				}
//
//				override fun onSuccess(result: Login,
//									   statusCode: Int,
//									   responseHeaders: Map<String, List<String>>) {
//					Log.d("Successful", "Sign Up working")
//
//				}
//
//				override fun onUploadProgress(bytesWritten: Long, contentLength: Long, done: Boolean) {
//
//				}
//
//				override fun onDownloadProgress(bytesRead: Long, contentLength: Long, done: Boolean) {
//
//				}
//			})
//		} catch (e: ApiException) {
//			e.printStackTrace()
//		}
//
//		run {
//
//		}
//	}
//
//	companion object {
//
//		//    @NonNull private static final RequestParams requestParams = new RequestParams();
//		private var signUpEmail: String? = null
//
//		//
//		// TODO: Swaggerfy
//		//    public static RequestParams getRequestParams() {
//		//        return requestParams;
//		//    }
//		fun setSignUpEmail(signUpEmail: String) {
//			SignUpActivity.signUpEmail = signUpEmail
//		}
//	}
}