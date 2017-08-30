package edu_chat.android.com.edu_chat.adapter.invite

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import chat.edu.edu_chat.R.id
import chat.edu.edu_chat.R.layout
import edu_chat.android.com.edu_chat.controller.invite.InviteActivity
import io.swagger.client.model.UserSerializer
import java.util.*

/**
 * Created by abmuthu on 8/8/16.
 * Edu.Chat Inc.
 */

class GridViewAdapter
//public static int testPos = 0;

(private val mContext: Context, private val searchUserListAdapter: SearchUserListAdapter) : BaseAdapter() {
	private val mActivity: InviteActivity = mContext as InviteActivity
	private val mSelectedUserList = ArrayList<UserSerializer>()
	private var mPosition: Int = 0

	init {
		this.mSelectedUserList.addAll(this.mActivity.getUserList())
	}

	fun updateSelectedUserList(position: Int) {
		Log.d("GridView", "updateSelectedUserList: " + position)
		mPosition = position
		this.mSelectedUserList.clear()
		this.mSelectedUserList.addAll(this.mActivity.getUserList())
		val name = StringBuilder()
		for (user in this.mSelectedUserList) {
			name.append(user.firstName).append("   ")
		}
		Log.d("INVITEKIRAN", name.toString())
	}

	override fun getCount(): Int {
		return this.mSelectedUserList.size
	}

	override fun getItem(position: Int): Any {
		return this.mSelectedUserList[position]
	}

	override fun getItemId(position: Int): Long {
		return position.toLong()
	}

	override fun getView(position: Int,
						 convertView: View?,
						 parent: ViewGroup): View? {
		Log.d("GridView", "GetView called")
		val inflater = this.mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

		val gridView: View
		Log.d("GridView", "GetView Pos: " + position)
		if (convertView == null) {

			gridView = inflater.inflate(layout.item_grid_view, null)
			val imageView_close = gridView.findViewById<ImageView>(id.imageview)
			Log.d("GridView", "Position: " + position)
			Log.d(
					"GridView",
					"User at Position: " + mSelectedUserList[position].firstName
			)

			val selectedUser = this.mActivity.getUserList()[position]

			val textView = gridView.findViewById<TextView>(id.name_selected_user)
			textView.text = selectedUser.firstName + ' ' + selectedUser
					.lastName
			Log.d("INVITEKIRAN", "index: " + this.mPosition + "adding " + selectedUser
					.firstName
					+ ' ' + selectedUser.lastName + " to the view")

			imageView_close.tag = position

			imageView_close.setOnClickListener { v ->
				Log.d("GridView", "Tag pos" + v.tag.toString())
				var newPos = v.tag as Int
				mActivity.getUserList().remove(v.tag)
				searchUserListAdapter.removeChecked(searchUserListAdapter.userList.indexOf(mSelectedUserList[position]), mSelectedUserList[position])
				val newSelectedUser = mSelectedUserList[newPos]
				Log.d(
						"GridView",
						"SelectedUser in convertView: " + newSelectedUser.firstName
				)
				Log.d("GridView", "Selected User: " + newSelectedUser.firstName)
				newPos = mPosition - 1
				Toast.makeText(this@GridViewAdapter.mContext, "hello_close", Toast
						.LENGTH_SHORT).show()
				this@GridViewAdapter.mActivity.removeSelectedUser(newSelectedUser)
				mSelectedUserList.remove(v.tag)
				this@GridViewAdapter.mActivity.notifyDataChangeToGridViewAdapter(newPos)
			}

			gridView.setOnClickListener {
				Log.d(
						"GridViewOnClick",
						(gridView.findViewById<View>(id.name_selected_user) as TextView).text.toString()
				)
			}

		} else {
			gridView = convertView
		}

		return gridView
	}

}
