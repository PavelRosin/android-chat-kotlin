package edu_chat.android.com.edu_chat.controller.settings

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import chat.edu.edu_chat.R
import kotlinx.android.synthetic.main.fragment_settings_account_privacy.*


/**
 * Created by Billy Yang on 06/21/2017
 */
class SettingsAccountPrivacy : Fragment() {
	private var statusContent: TextView? = null
	private val privacyItems = arrayOf("Everyone", "My Contacts", "Nobody")
	private val textViewNames = arrayOf("Profile", "Status")

	private var itemsNumber: Int = 0
	private var prefs: SharedPreferences? = null

	override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
							  savedInstanceState: Bundle?): View? {
		return inflater!!.inflate(
				R.layout.fragment_settings_account_privacy,
				container,
				false
		)
	}

	override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		val override = OverwriteText()
		override.overrideFont(view!!)
		(activity as AppCompatActivity).setSupportActionBar(toolbar_settings_general as Toolbar)
		(toolbar_settings_general as Toolbar).setNavigationIcon(R.drawable.instabug_ic_back)
		(toolbar_settings_general as Toolbar).setNavigationOnClickListener {
			val handler = Handler()
			handler.postDelayed({ activity.onBackPressed() }, 100L)
		}
		this.prefs = this.activity.getSharedPreferences("privacy.conf", Context.MODE_PRIVATE)
		val defaultValue = resources.getInteger(R.integer.saved_privacy_default)
		val profileChoice = prefs!!.getInt(getString(R.string.saved_profile_choice), defaultValue)
		val statusChoice = prefs!!.getInt(getString(R.string.saved_status_choice), defaultValue)

		val textViews = arrayOf<TextView>(settings_account_privacy_profile_content, statusContent!!)
		val privacyChoice = intArrayOf(profileChoice, statusChoice)
		val textViewTotalNumber = textViews.size
		for (i in 0 until textViewTotalNumber)
			textViews[i].text = privacyItems[privacyChoice[i]]
		this.settings_account_privacy_profile!!.setOnClickListener {
			itemsNumber = 0
			privacyProfile(privacyChoice, textViews)
		}
		this.settings_account_privacy_status!!.setOnClickListener {
			itemsNumber = 1
			privacyProfile(privacyChoice, textViews)
		}
	}

	private fun privacyProfile(privacyChoice: IntArray, textViews: Array<TextView>) {
		AlertDialog.Builder(context)
				.setTitle(textViewNames[itemsNumber])
				.setSingleChoiceItems(privacyItems, privacyChoice[itemsNumber]
				) { _, i -> privacyChoice[itemsNumber] = i }
				.setPositiveButton("Save") { _, _ ->
					saveChanges(privacyChoice)
					textViews[itemsNumber].text = privacyItems[privacyChoice[itemsNumber]]
				}
				.setNegativeButton("Cancel") { dialogInterface, i -> dialogInterface.dismiss() }
				.show()
	}

	//    private void privacyStatus(){
	//        itemsNumber = 1;
	//        new AlertDialog.Builder(getContext())
	//                .setTitle("Status")
	//                .setSingleChoiceItems(privacyItems, statusChoice,
	//                        new DialogInterface.OnClickListener() {
	//                            @Override
	//                            public void onClick(DialogInterface dialogInterface, int i) {
	//                                statusChoice = i;
	//                            }
	//                        })
	//                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
	//                    @Override
	//                    public void onClick(DialogInterface dialogInterface, int i) {
	//                        saveChanges(itemsNumber);
	//                    }
	//                })
	//                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
	//                    @Override
	//                    public void onClick(DialogInterface dialogInterface, int i) {
	//                        dialogInterface.dismiss();
	//                    }
	//                })
	//                .show();
	//    }

	private fun saveChanges(privacyChoice: IntArray) {
		val editor = prefs!!.edit()
		val items = arrayOf(getString(R.string.saved_profile_choice), getString(R.string.saved_status_choice))
		editor.putInt(items[itemsNumber], privacyChoice[itemsNumber])
		editor.apply()
	}

}
