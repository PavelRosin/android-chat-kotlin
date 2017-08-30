package edu_chat.android.com.edu_chat

import android.app.Application

import com.instabug.library.Instabug.Builder
import com.instabug.library.invocation.InstabugInvocationEvent

/**
 * Created by niebloomj on 1/28/16.
 * Edu.Chat Inc.
 */
class App : Application() {

override fun onCreate() {
	super.onCreate()
	Builder(this, "4719bf1a7d10635f7c1520989f084d4c")
			.setInvocationEvent(InstabugInvocationEvent.SHAKE)
			.build()
}

}
