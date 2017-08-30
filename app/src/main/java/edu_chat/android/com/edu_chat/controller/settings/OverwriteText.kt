package edu_chat.android.com.edu_chat.controller.settings

import android.app.Activity
import android.content.Context
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import chat.edu.edu_chat.R


internal class OverwriteText {

	fun overrideFont(v: View) {

		val activity = v.context as Activity
		val sp = activity.getSharedPreferences(
				"text_size.conf",
				Context.MODE_PRIVATE
		)
		val ts = sp.getFloat(
				activity.getString(R.string.saved_textSize),
				activity.resources.getDimension(R.dimen.text_size_16)
		)
		//   float ts = sp.getFloat(activity.getString(R.string.saved_textSize), activity
		// .getResources().getDimension(R.dimen.text_size_16));
		try {
			if (v is ViewGroup) {
				val vg = v
				(0 until vg.childCount)
						.map { vg.getChildAt(it) }
						.forEach { overrideFont(it) }
			} else (v as? TextView)?.setTextSize(TypedValue.COMPLEX_UNIT_PX, ts)
		} catch (ignored: Exception) {
		}

	}

	private fun overrideFontWithActivity(a: Activity, v: View) {
		val sp = a.getSharedPreferences("text_size.conf", Context.MODE_PRIVATE)
		val ts = sp.getFloat(
				a.getString(R.string.saved_textSize),
				a.resources.getDimension(R.dimen.text_size_16)
		)
		try {
			if (v is ViewGroup) {
				val vg = v
				(0 until vg.childCount)
						.map { vg.getChildAt(it) }
						.forEach { overrideFont(it) }
			} else (v as? TextView)?.setTextSize(TypedValue.COMPLEX_UNIT_PX, ts)
		} catch (ignored: Exception) {
		}

	}


	//    }


}//constructor
