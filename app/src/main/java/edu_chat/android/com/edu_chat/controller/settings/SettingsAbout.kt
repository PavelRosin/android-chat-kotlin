package edu_chat.android.com.edu_chat.controller.settings


import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import chat.edu.edu_chat.BuildConfig
import chat.edu.edu_chat.R
import kotlinx.android.synthetic.main.fragment_settings_about.*

/*
 Created by Billy Yang on
 */

class SettingsAbout : Fragment() {

	override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
							  savedInstanceState: Bundle?): View? {
		return inflater!!.inflate(R.layout.fragment_settings_about, container, false)
	}

	override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		val override = OverwriteText()
		override.overrideFont(view!!)

		val toolbar = view.findViewById<Toolbar>(R.id.toolbar_settings_about)
		(activity as AppCompatActivity).setSupportActionBar(toolbar)
		toolbar.setNavigationIcon(R.drawable.instabug_ic_back)
		toolbar.setNavigationOnClickListener {
			val handler = Handler()
			handler.postDelayed({ activity.onBackPressed() }, 100L)
		}

		if (this.build_version != null) {
			val version = BuildConfig.VERSION_CODE
			val versionName = BuildConfig.VERSION_NAME
			this.build_version!!.text = String.format("%s (%d)", versionName, version)
		}
	}
	//    private void overrideFont(final View v){
	//        SharedPreferences sp = getActivity().getSharedPreferences("text_size.conf", Context
	// .MODE_PRIVATE);
	//        float ts = sp.getFloat(getString(R.string.saved_textSize), getResources().getDimension
	// (R.dimen.text_size_16));
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
