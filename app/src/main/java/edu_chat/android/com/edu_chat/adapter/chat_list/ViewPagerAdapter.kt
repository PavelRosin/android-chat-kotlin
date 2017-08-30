package edu_chat.android.com.edu_chat.adapter.chat_list

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

import edu_chat.android.com.edu_chat.controller.chat_list.ChatListFragment

/**
 * Created by sgrug on 9/22/2016.
 * Edu.Chat Inc.
 */
class ViewPagerAdapter(fm: FragmentManager,
					   private val mNumOfTabs: Int) : FragmentStatePagerAdapter(fm) {

	override fun getItem(position: Int): Fragment? {
		when (position) {
			0 -> return ChatListFragment(false)
			1 -> return ChatListFragment(true)
			else -> return null
		}
	}

	override fun getCount(): Int {
		return mNumOfTabs
	}


}