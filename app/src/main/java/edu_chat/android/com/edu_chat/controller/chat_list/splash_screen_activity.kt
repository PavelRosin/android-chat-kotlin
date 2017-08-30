package edu_chat.android.com.edu_chat.controller.chat_list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.provider.ContactsContract
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import android.util.Log

import chat.edu.edu_chat.R
import edu_chat.android.com.edu_chat.controller.LoginActivity
import edu_chat.android.com.edu_chat.model.CurrentUser
import io.swagger.client.ApiClient
import io.swagger.client.Configuration
import io.swagger.client.model.Login
import io.swagger.client.model.LoginInput

/**
 * Created by pallakanand on 7/26/17.
 * Edu.Chat Inc.
 */

class splash_screen_activity : AppCompatActivity() {

    private val SPLASH_DISPLAY_LENGTH = 1000
    override fun onCreate(savedInstanceState: Bundle?) {
        val result: Login
        super.onCreate(savedInstanceState)
        var fcm_chat = ""
        setContentView(R.layout.splash_screen_activity_layout)
        if (intent.extras != null) {
            for (key in intent.extras.keySet()) {
                val value = intent.extras.get(key)
                Log.d("FCM", "Key: $key Value: $value")
            }
            if(intent.extras.get("chat")!=null) {
                fcm_chat = intent.extras.get("chat").toString()
            }
            Log.d("FCM_put", fcm_chat)
        }

        val prefs = getSharedPreferences("login.conf", Context.MODE_PRIVATE)
        val prefsString = prefs.getString("pass", "")
        val finalData : LoginInput
        //var apiClient = LoginActivity.gettingCurrentUser(result, finalData, prefs)
        //Configuration.setDefaultApiClient(apiClient)

        Handler().postDelayed({
//            if (prefsString.equals("", ignoreCase = true)){
                //CurrentUser.currentUser = result.results.user
                //CurrentUser.token = result.results.token
                val intent = Intent(this@splash_screen_activity, LoginActivity::class.java)
                intent.putExtra("fcm_chat", fcm_chat)
                this@splash_screen_activity.startActivity(intent)
                this@splash_screen_activity.finish()
//            }
//            else {
//                CurrentUser.currentUser = result.results.user
//                CurrentUser.token = result.results.token
//                val intent = Intent(this@splash_screen_activity, ChatListActivity::class.java)
//                this@splash_screen_activity.startActivity(intent)
//                this@splash_screen_activity.finish()
//            }
        }, SPLASH_DISPLAY_LENGTH.toLong())
    }
}
