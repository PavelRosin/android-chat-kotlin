package edu_chat.android.com.edu_chat.controller.settings

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.TextView
import chat.edu.edu_chat.R
import kotlinx.android.synthetic.main.fragment_settings_general_text.*

/**
 * Created by Billy Yang on 06/23/2017
 */
class SettingsGeneralText : Fragment() {
	private var seekBar: SeekBar? = null
	private var lastProgress: Int = 0
	private var newProgress = 0
	private var editor: SharedPreferences.Editor? = null
	private var textSize: Float = 0.toFloat()


	override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
							  savedInstanceState: Bundle?): View? {
		return inflater!!.inflate(R.layout.fragment_settings_general_text, container, false)
	}

	override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		val override = OverwriteText()
		override.overrideFont(view!!)

		var prefs = this.activity.getSharedPreferences(
				"text_size.conf",
				Context.MODE_PRIVATE
		)
		editor = prefs.edit()

		prefs = this.activity.getSharedPreferences(
				"text_size.conf",
				Context.MODE_PRIVATE
		)

		val defaultTextSize = resources.getDimension(R.dimen.text_size_16)
		textSize = prefs.getFloat(getString(R.string.saved_textSize), defaultTextSize)
		val defaultProgress = resources.getInteger(R.integer.text_size_16)
		lastProgress = prefs.getInt(getString(R.string.saved_progress), defaultProgress)
		//        settings_general_textSize_preview.setText(String.valueOf(lastProgress));


		(activity as AppCompatActivity).setSupportActionBar(toolbar_settings_general_text)
		toolbar_settings_general_text.setNavigationIcon(R.drawable.instabug_ic_back)
		toolbar_settings_general_text.setNavigationOnClickListener {
			val handler = Handler()
			handler.postDelayed({ activity.onBackPressed() }, 100L)
		}
		settings_general_textSize_done!!.setOnClickListener { attemptSaveChanges() }
		settings_general_textSize_seekBar!!.progress = lastProgress
		settings_general_textSize_seekBar!!.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
			override fun onProgressChanged(settings_general_textSize_seekBar: SeekBar, progress: Int, fromUser: Boolean) {
				//                if(progress > newProgress + 10 || progress < newProgress - 10){
				//                    newProgress = lastProgress;
				//                    settings_general_textSize_seekBar.setProgress(lastProgress);
				//                    return;
				//                }
				newProgress = progress
			}

			override fun onStartTrackingTouch(settings_general_textSize_seekBar: SeekBar) {

			}

			override fun onStopTrackingTouch(settings_general_textSize_seekBar: SeekBar) {
				if (newProgress < 30) {
					lastProgress = 0
					newProgress = 0
					settings_general_textSize_seekBar.progress = newProgress
					//                    settings_general_textSize_preview.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension
					// (R.dimen.text_size_12));
				} else if (newProgress > 70) {
					lastProgress = 100
					newProgress = 100
					settings_general_textSize_seekBar.progress = newProgress
					//                    settings_general_textSize_preview.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension
					// (R.dimen.text_size_20));
				} else {
					lastProgress = 50
					newProgress = 50
					settings_general_textSize_seekBar.progress = newProgress
					//                    settings_general_textSize_preview.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension
					// (R.dimen.text_size_16));
				}
				//                SharedPreferences.Editor editor = prefs.edit();
				when (settings_general_textSize_seekBar.progress) {
					0 -> settings_general_textSize_preview!!.setTextSize(
							TypedValue.COMPLEX_UNIT_PX,
							resources.getDimension(R.dimen.text_size_12)
					)
					50 -> settings_general_textSize_preview!!.setTextSize(
							TypedValue.COMPLEX_UNIT_PX,
							resources.getDimension(R.dimen.text_size_16)
					)
					100 -> settings_general_textSize_preview!!.setTextSize(
							TypedValue.COMPLEX_UNIT_PX,
							resources.getDimension(R.dimen.text_size_20)
					)
				}//                        editor.putInt(getString(R.string.saved_progress), 0);
				//                        editor.putInt(getString(R.string.saved_progress), 50);
				//                        editor.putInt(getString(R.string.saved_progress), 100);
			}
		})
		settings_general_textSize_seekBar!!.progress = lastProgress
	}

	private fun attemptSaveChanges() {
		//        SharedPreferences.Editor editor = prefs.edit();
		//        editor = prefs.edit();
		AlertDialog.Builder(context)
				.setTitle("Alert")
				.setMessage("Are you sure to save your changes?")
				.setNegativeButton("Cancel") { dialogInterface, i -> dialogInterface.dismiss() }
				.setPositiveButton("Yes") { dialogInterface, i ->
					//                        SharedPreferences.Editor editor = prefs.edit();
					editor!!.putInt(getString(R.string.saved_progress), seekBar!!.progress)
					//                        int test = prefs.getInt(getString(R.string.saved_progress), 0);
					editor!!.commit()
					//                        editor.putInt("abc", 100);
					//                        int test = prefs.getInt("abc", 0);
					//                        settings_general_textSize_preview.setText(String.valueOf(test));
					overrideFonts(context, view!!)
					goBack()
				}
				.show()
	}

	private fun goBack() {
		val handler = Handler()
		handler.postDelayed({
			val settingsGeneral = SettingsGeneral()
			val ft = this@SettingsGeneralText.activity
					.supportFragmentManager
					.beginTransaction()
			ft.replace(R.id.settings_framelayout, settingsGeneral)
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
			ft.addToBackStack(null)
			ft.commit()
		}, 100L)
	}

	private fun overrideFonts(context: Context, v: View) {

		//        textSize = getResources().getDimension(R.dimen.text_size_20);
		when (seekBar!!.progress) {
			0 -> textSize = resources.getDimension(R.dimen.text_size_12)
			50 -> textSize = resources.getDimension(R.dimen.text_size_16)
			100 -> textSize = resources.getDimension(R.dimen.text_size_20)
		}
		editor!!.putFloat(getString(R.string.saved_textSize), textSize)
		editor!!.commit()
		//        try {
		//            if (v instanceof ViewGroup) {
		//                ViewGroup vg = (ViewGroup) v;
		//                for (int i = 0; i < vg.getChildCount(); i++) {
		//                    View child = vg.getChildAt(i);
		//                    overrideFonts(context, child);
		//                }
		//            } else if (v instanceof TextView) {
		//                ((TextView) v).setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
		//            }
		//        } catch (Exception e) {
		//        }
		//        overrideFont(context, "SERIF", "assets/HelveticaNeue.ttf");
	}
	//    private static void overrideFont(Context context, String defaultFontNameToOverride, String
	// customFontFileNameInAssets) {
	//        try {
	//            final Typeface customFontTypeface = Typeface.createFromAsset(context.getAssets(),
	// customFontFileNameInAssets);
	//
	//            final Field defaultFontTypefaceField = Typeface.class.getDeclaredField
	// (defaultFontNameToOverride);
	//            defaultFontTypefaceField.setAccessible(true);
	//            defaultFontTypefaceField.set(null, customFontTypeface);
	//        } catch (Exception e) {
	//            Log.e("TypefaceUtil","Can not set custom font " + customFontFileNameInAssets + "
	// instead of " + defaultFontNameToOverride);
	//        }
	//    }


	//    private void overrideFont(final View v){
	//        SharedPreferences sp = getActivity().getSharedPreferences("text_size.conf", Context
	// .MODE_PRIVATE);
	//        float ts = sp.getFloat(getString(R.string.saved_textSize), getResources().getDimension
	// (R.dimen.text_size_16));
	//            try {
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
