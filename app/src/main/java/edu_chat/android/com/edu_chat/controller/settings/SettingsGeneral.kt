package edu_chat.android.com.edu_chat.controller.settings

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import chat.edu.edu_chat.R
import kotlinx.android.synthetic.main.fragment_settings_general.*

/**
 * Created by Billy Yang on 06/22/2017
 */
class SettingsGeneral : Fragment() {

	override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
							  savedInstanceState: Bundle?): View? {
		// Inflate the layout for this fragment
		val view = inflater!!.inflate(R.layout.fragment_settings_general, container, false)

		//        overrideFont(view);
		val override = OverwriteText()
		override.overrideFont(view)


		return view
	}

	override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		(activity as AppCompatActivity).setSupportActionBar(toolbar_settings_general)
		toolbar_settings_general.setNavigationIcon(R.drawable.instabug_ic_back)
		toolbar_settings_general.setNavigationOnClickListener {
			val handler = Handler()
			handler.postDelayed({
				val settingsOneFragment = SettingsOneFragment()
				val ft = this@SettingsGeneral.activity
						.supportFragmentManager
						.beginTransaction()
				ft.replace(R.id.settings_framelayout, settingsOneFragment)
				ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
				ft.addToBackStack(null)
				ft.commit()
			}, 100L)
		}
		settings_general_textSize!!.setOnClickListener { changeTextSize() }
	}

	private fun changeTextSize() {
		val handler = Handler()
		handler.postDelayed({
			val settingsGeneralText = SettingsGeneralText()
			val ft = this@SettingsGeneral.activity
					.supportFragmentManager
					.beginTransaction()
			ft.replace(R.id.settings_framelayout, settingsGeneralText)
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
			ft.addToBackStack(null)
			ft.commit()
		}, 100L)
	}

	fun onResume(inflater: LayoutInflater, container: ViewGroup,
				 savedInstanceState: Bundle) {

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
				val vg = v
				(0 until vg.childCount)
						.map { vg.getChildAt(it) }
						.forEach { overrideFont(it) }
			} else (v as? TextView)?.setTextSize(TypedValue.COMPLEX_UNIT_PX, ts)
		} catch (ignored: Exception) {
		}

	}

}
