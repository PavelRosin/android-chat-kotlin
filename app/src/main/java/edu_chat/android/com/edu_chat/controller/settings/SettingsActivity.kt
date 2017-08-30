package edu_chat.android.com.edu_chat.controller.settings

import android.R.id
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.MotionEvent
import chat.edu.edu_chat.R
import chat.edu.edu_chat.R.layout
import com.instabug.library.InstabugTrackingDelegate
import kotlinx.android.synthetic.main.activity_settings.*


class SettingsActivity : AppCompatActivity() {

	override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
		InstabugTrackingDelegate.notifyActivityGotTouchEvent(ev, this)
		return super.dispatchTouchEvent(ev)
	}


	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		this.setContentView(layout.activity_settings)
		this.settings_framelayout!!.bringToFront()
		val settingsOneFragment = SettingsOneFragment()
		val ft = this.supportFragmentManager.beginTransaction()
		ft.replace(R.id.settings_framelayout, settingsOneFragment)
		ft.commit()
	}

	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		if (item.itemId == id.home) {
			this.finish()
		}
		return super.onOptionsItemSelected(item)
	}

	override fun finish() {
		val editor = this.getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE).edit()
		editor.putString("activity", "Activity")
		editor.apply()
		super.finish()
	}

	companion object {

		private val MY_PREFS_NAME = "MyPrefsFile"
	}
	//    private void goToNextStep() {
	////        this.updateRequestParams(SignUpActivity.getRequestParams());
	//
	//        final Handler handler = new Handler();
	//        handler.postDelayed(new Runnable() {
	//            @Override
	//            public void run() {
	//                final SettingsAbout settingsAbout = new SettingsAbout();
	//                final FragmentTransaction ft = SettingsActivity.this.getSupportFragmentManager
	// ().beginTransaction();
	//                ft.replace(R.id.settings_about, settingsAbout);
	//                ft.commit();
	//            }
	//        }, 100L);
	//
	//    }

}
