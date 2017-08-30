package edu_chat.android.com.edu_chat.adapter.userprofile

//import com.urlinq.edu_chat.R;

//import edu_chat.android.com.edu_chat.model.constants.Constants;
//import edu_chat.android.com.edu_chat.model.enums.CurrentUser;
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import chat.edu.edu_chat.R
import edu_chat.android.com.edu_chat.controller.userprofile.UserProfileActivity
import io.swagger.client.model.UserSerializer
import java.util.*

/**
 * Created by Dan on 6/30/17.
 * Edu.Chat Inc.
 */

class TagsGridViewAdapter : BaseAdapter {
	private val mContext: Context
	private val itemList = ArrayList<String>()
	private val mActivity: UserProfileActivity
	private var isEdit = false

	constructor(context: Context, user: UserSerializer, type: Char, edit: Boolean) : super() {
		isEdit = edit
		this.mContext = context
		this.mActivity = context as UserProfileActivity
		if (type == TAGS) {
			if (!user.tags.isEmpty()) {
				val tagIterator = user.tags.iterator()
				do {
					val currTag = tagIterator.next()
					itemList.add(currTag.tag)
					Log.d("GridView", "CurrTag" + currTag.tag)
				} while (tagIterator.hasNext())
			}
//			itemList.add("Tag Test")
//			itemList.add("Tag Placeholder")
//			itemList.add("Hello")
		} else if (type == AOS) {
			if (user.areasOfStudy != null  && !user.areasOfStudy.isEmpty()) {
				val aosIterator = user.areasOfStudy.iterator()
				do {
					val currAOS = aosIterator.next()
					itemList.add(currAOS)
					Log.d("GridView", "CurrTag " + currAOS)
				} while (aosIterator.hasNext())
			}
		}
		if (itemList.isEmpty()) {
			itemList.add(context.getString(R.string.empty_list_grid_view))
		}
	}

	constructor(context: Context, pAOSList: List<String>, edit: Boolean) : super() {
		this.mContext = context
		this.mActivity = context as UserProfileActivity
		this.isEdit = edit
		itemList.clear()
		itemList.addAll(pAOSList)
	}

	override fun getCount(): Int {
		return this.itemList.size
	}

	override fun getItem(position: Int): Any {
		return this.itemList[position]
	}

	override fun getItemId(position: Int): Long {
		return position.toLong()
	}

	override fun getView(position: Int,
						 convertView: View?,
						 parent: ViewGroup): View? {
		val inflater = this.mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

		val gridView: View
		if (convertView == null) {
			//Is edit profile
			if (!isEdit) {
				gridView = inflater.inflate(R.layout.item_tags_grid_view, null)
				Log.d("GridView", "Position: " + position)
				val tagText = gridView.findViewById<TextView>(R.id.tag_name)
				tagText.text = getItem(position) as String
			} else {
				gridView = inflater.inflate(R.layout.item_tags_edit_grid_view, null)
				Log.d("GridView", "Position: " + position)
				val tagText = gridView.findViewById<TextView>(R.id.tag_name)
				tagText.text = getItem(position) as String
			}
		} else {
			gridView = convertView
		}

		return gridView
	}

	override fun toString(): String {
		return String.format(
				"GridViewAdapter{mContext=%s, mTagsList=%s, mActivity=%s} %s",
				this.mContext,
				this.itemList,
				this.mActivity,
				super.toString()
		)
	}

	companion object {
		private val TAGS = 't'
		private val AOS = 'a'
	}
}
