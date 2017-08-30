package edu_chat.android.com.edu_chat.controller.settings

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import chat.edu.edu_chat.R
import chat.edu.edu_chat.R.layout
import kotlinx.android.synthetic.main.fragment_settings_notifications.*


/**

 */

class SettingsNotifications : Fragment() {
	private var checkid = 1
	private var choice: SharedPreferences? = null
	private var choiceeditor: SharedPreferences.Editor? = null

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
							  savedInstanceState: Bundle?): View? {
		val view = inflater.inflate(
				layout.fragment_settings_notifications,
				container,
				false
		)



		return view
	}

	override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		val override = OverwriteText()
		override.overrideFont(view!!)
		(activity as AppCompatActivity).setSupportActionBar(toolbar_settings_notification)
		toolbar_settings_notification!!.setNavigationIcon(R.drawable.instabug_ic_back)
		toolbar_settings_notification!!.setNavigationOnClickListener { activity.onBackPressed() }
		choice = activity.getSharedPreferences("login.conf", Context.MODE_PRIVATE)
		checkid = choice!!.getInt("notification", 1)
		when (checkid) {
			1 -> setRadio_All(checkid)
			2 -> setRadio_Directly(checkid)
			3 -> setRadio_Never(checkid)
		}
		unit1!!.setOnClickListener {
			checkid = 1
			setRadio_All(checkid)
		}
		unit2!!.setOnClickListener {
			checkid = 2
			setRadio_Directly(checkid)
		}
		unit3!!.setOnClickListener {
			checkid = 3
			setRadio_Never(checkid)
		}
		radioButton1!!.setOnClickListener {
			checkid = 1
			setRadio_All(checkid)
			// Toast.makeText(getBaseContext()," All", Toast.LENGTH_SHORT).show();
		}
		radioButton2!!.setOnClickListener {
			checkid = 2
			setRadio_Directly(checkid)
		}
		radioButton3!!.setOnClickListener {
			checkid = 3
			setRadio_Never(checkid)
			//  Toast.makeText(getBaseContext()," Never", Toast.LENGTH_SHORT).show();
		}
	}

	private fun setRadio_All(checkid: Int) {
		radioButton1!!.isChecked = true
		radioButton3!!.isChecked = false
		radioButton2!!.isChecked = false
		choiceeditor = choice!!.edit()
		choiceeditor!!.putInt("notification", checkid)
		choiceeditor!!.apply()
	}

	private fun setRadio_Directly(checkid: Int) {
		radioButton1!!.isChecked = false
		radioButton3!!.isChecked = false
		radioButton2!!.isChecked = true
		choiceeditor = choice!!.edit()
		choiceeditor!!.putInt("notification", checkid)
		choiceeditor!!.apply()
	}

	private fun setRadio_Never(checkid: Int) {
		radioButton1!!.isChecked = false
		radioButton3!!.isChecked = true
		radioButton2!!.isChecked = false
		choiceeditor = choice!!.edit()
		choiceeditor!!.putInt("notification", checkid)
		choiceeditor!!.apply()
	}

	private fun overrideFont(v: View) {
		val sp = activity.getSharedPreferences(
				"text_size.conf",
				Context.MODE_PRIVATE
		)
		val ts = sp.getFloat(
				getString(R.string.saved_textSize),
				resources.getDimension(R.dimen.text_size_16)
		)
		try {
			if (v is ViewGroup) {
				(0 until v.childCount)
						.map { v.getChildAt(it) }
						.forEach { overrideFont(it) }
			} else (v as? TextView)?.setTextSize(TypedValue.COMPLEX_UNIT_PX, ts)
		} catch (ignored: Exception) {
		}

	}
}