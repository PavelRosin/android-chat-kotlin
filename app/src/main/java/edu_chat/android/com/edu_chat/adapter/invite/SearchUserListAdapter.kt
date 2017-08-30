package edu_chat.android.com.edu_chat.adapter.invite

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.support.v7.widget.RecyclerView.ViewHolder
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import chat.edu.edu_chat.R
import chat.edu.edu_chat.R.id
import chat.edu.edu_chat.R.layout
import com.squareup.picasso.Picasso
import edu_chat.android.com.edu_chat.controller.invite.InviteActivity
import edu_chat.android.com.edu_chat.model.Constants
import edu_chat.android.com.edu_chat.view.CircleTransform
import io.swagger.client.model.UserSerializer


/**
 * Created by abmuthu on 8/2/16.
 * Edu.Chat Inc.
 */

class SearchUserListAdapter(userListInp: MutableList<UserSerializer>, private val mActivity: InviteActivity) : Adapter<ViewHolder>() {

	var userList: MutableList<UserSerializer> = userListInp
	var testCount: Int = 0
	var checkedUsers: ArrayList<Int>? = ArrayList(0)
	private var mRecyclerView: RecyclerView? = null

	override fun onAttachedToRecyclerView(recyclerView: RecyclerView?) {
		super.onAttachedToRecyclerView(recyclerView)

		mRecyclerView = recyclerView
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		return SearchUserViewHolder(LayoutInflater.from(parent.context).inflate(
				layout.item_search_user,
				parent, false
		))
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {

		Log.d("Binding", "Binding")
		val viewHolder = holder as SearchUserViewHolder
		viewHolder.user = userList[holder.adapterPosition]
		if (checkedUsers!!.contains(viewHolder.user!!.id)){
				viewHolder.setSearchUserName()
				viewHolder.setSearchUserEmail()
				viewHolder.setChecked()
			}

		else{
		viewHolder.setSearchUserName()
		viewHolder.setSearchUserEmail()
		viewHolder.setPicture()
		}
	}

	override fun getItemCount(): Int = userList.size


	fun removeChecked(position: Int, user: UserSerializer) {
		val selected = mRecyclerView!!.findViewHolderForAdapterPosition(position) as SearchUserViewHolder?
		if (selected!= null) {
			selected.setPicture()
		}
		checkedUsers?.remove(user.id)
		if (this@SearchUserListAdapter.mActivity.getUserList().size < 1) {
			mActivity.changeGridViewHeight(0)
		} else if (this@SearchUserListAdapter.mActivity.getUserList().size < 3) {
			mActivity.changeGridViewHeight(150)
		}
	}

	override fun getItemViewType(position: Int): Int {
		return 1
	}


	private inner class SearchUserViewHolder internal constructor(itemView: View) : ViewHolder(itemView), OnClickListener {
		private val mUserNameTextView: TextView = itemView.findViewById<TextView>(id.search_user_name)
		private val mEmailTextView: TextView = itemView.findViewById<TextView>(id.search_user_email)
		private val mPictureImageView: ImageView = itemView.findViewById<ImageView>(id.pictureImageView)
		var user: UserSerializer? = null
		var checked: Boolean = false

		init {
			itemView.setOnClickListener(this)
		}

		fun setSearchUserName() {
			mUserNameTextView.text = this.user!!.firstName + ' ' + this
					.user!!.lastName
		}

		fun setSearchUserEmail() {
			this.mEmailTextView.text = this.user!!.email
		}

		fun setPicture() {
			this.mPictureImageView.background = null
			Picasso.with(this@SearchUserListAdapter.mActivity.baseContext)
					.load(this.user!!.pictureFile.url)
					.resize(
							Constants.GLOBAL_IMAGE_SIZE,
							Constants.GLOBAL_IMAGE_SIZE
					)
					.centerInside()
					.transform(CircleTransform(null))
					.into(this.mPictureImageView)
			checkedUsers!!.remove(this.user!!.id)

		}

		fun setChecked() {
			this.mPictureImageView.background = null
			Picasso.with(this@SearchUserListAdapter.mActivity.baseContext)
					.load(R.drawable.ic_check_circle_black_24dp)
					.resize(
							Constants.GLOBAL_IMAGE_SIZE,
							Constants.GLOBAL_IMAGE_SIZE
					)
					.centerInside()
					.transform(CircleTransform(null))
					.into(this.mPictureImageView)
			if (!checkedUsers!!.contains(user!!.id))checkedUsers!!.add(user!!.id)
			Log.d("CheckedUsers", checkedUsers!!.toString())
		}


		override fun onClick(v: View) {
			val user = userList[this.adapterPosition]

			if (this@SearchUserListAdapter.mActivity.getUserList().contains(user)) {
				Log.d("HI", "inside if")
				mActivity.searchChecked.remove(this.adapterPosition)
				this@SearchUserListAdapter.mActivity.removeSelectedUser(user)
				this.setPicture()
				this@SearchUserListAdapter.mActivity.notifyDataChangeToGridViewAdapter(positionObj)
				positionObj--
				if (this@SearchUserListAdapter.mActivity.getUserList().size < 1) {
					mActivity.changeGridViewHeight(0)
				} else if (this@SearchUserListAdapter.mActivity.getUserList().size < 3) {
					mActivity.changeGridViewHeight(150)
				}

			} else {
				Log.d("HI", "inside else")
				mActivity.searchChecked.add(this.adapterPosition)
				this@SearchUserListAdapter.mActivity.setUserList(user)
				this.setChecked()
				this@SearchUserListAdapter.mActivity.notifyDataChangeToGridViewAdapter(positionObj)
				positionObj++
				if (this@SearchUserListAdapter.mActivity.getUserList().size > 2) {
					this@SearchUserListAdapter.mActivity.changeGridViewHeight(300)
				} else if (this@SearchUserListAdapter.mActivity.getUserList().size > 0) {
					this@SearchUserListAdapter.mActivity.changeGridViewHeight(150)
				}

			}

			//            mGridView.setAdapter(new GridViewAdapter(mActivity.getBaseContext(), mActivity,
			// mGridView));

			//            userlistinterface.idList(mSelectedUserList);

			//            count++;
			//
		}
	}

	companion object {
		var positionObj: Int = 0
	}

}
