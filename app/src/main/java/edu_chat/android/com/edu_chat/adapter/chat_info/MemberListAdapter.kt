package edu_chat.android.com.edu_chat.adapter.chat_info

import android.app.Activity
import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.DialogInterface
import android.support.v7.widget.RecyclerView.Adapter
import android.support.v7.widget.RecyclerView.ViewHolder
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SectionIndexer
import android.widget.TextView
import chat.edu.edu_chat.R.*
import com.squareup.picasso.Picasso
import edu_chat.android.com.edu_chat.controller.chat_info.ChatinfoActivity
import edu_chat.android.com.edu_chat.model.Constants
import edu_chat.android.com.edu_chat.view.CircleTransform
import io.swagger.client.ApiCallback
import io.swagger.client.ApiException
import io.swagger.client.api.Chat_userApi
import io.swagger.client.model.LogoutView
import io.swagger.client.model.UserSerializer
import org.jetbrains.anko.sdk25.coroutines.onLongClick
import java.util.*

/**
 * Created by yuandali on 7/24/16.
 * Edu.Chat Inc.
 */
class MemberListAdapter(private val activity: Activity,
						var userList: ArrayList<UserSerializer>?)
	: Adapter<ViewHolder>(), SectionIndexer {
	private val indexTable: Hashtable<Char, Int>? = null

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
			if (viewType == CATEGORY_VIEW_TYPE) {
				val view: View = LayoutInflater.from(parent.context).inflate(
						layout.item_contact_category, parent, false)
				Log.d("ViewType", viewType.toString())
				CategoryViewHolder(view)
			} else {
				val view: View = LayoutInflater.from(parent.context).inflate(
						layout.item_contact, parent, false)
				Log.d("ViewType", viewType.toString())
				ContactViewHolder(view)
			}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		Log.d("MemberList", "BindViewHolder")
		val user = userList!![position]
		val viewHolder = holder as ContactViewHolder
		viewHolder.setUser(user)
		viewHolder.setNameTextView()
		viewHolder.setPicture()
		viewHolder.setOnlineStatus(user.isOnline!!)
		viewHolder.setAdminStatus(false)
	}


	override fun getItemViewType(position: Int): Int = CONTACT_VIEW_TYPE

	override fun getItemCount(): Int = if (this.userList == null) 0 else this.userList!!.size

	override fun getSections(): Array<Any?> = arrayOfNulls(0)

	override fun getPositionForSection(sectionIndex: Int): Int =
			if (this.indexTable!!.containsKey(sectionIndex.toChar())) {
				this.indexTable[sectionIndex.toChar()]!!
			} else -1

	override fun getSectionForPosition(position: Int): Int = -1

	class CategoryViewHolder(itemView: View) : ViewHolder(itemView) {

//		private val categoryTextView: TextView? = itemView.findViewById(id.category_textview)
//		private var category: Char? = null

//		fun setCategory(category: Char?) {
//			this.category = category
//		}
//
//		fun setCategoryTextView() {
//			if (this.categoryTextView != null) {
//				this.categoryTextView.text = this.category!!.toString()
//			}
//		}
	}

	inner class ContactViewHolder(itemView: View) : ViewHolder(itemView) {

		private val contactNameTextView: TextView? = itemView.findViewById(id.contact_name_textview)
		private val pictureImageView: ImageView? = itemView.findViewById(id.pictureImageView)
		private val isOnlineView: View = itemView.findViewById<View>(id.is_online_view)
		private val isAdminTextView: TextView = itemView.findViewById(id.is_admin_textview)
		private var user: UserSerializer? = null

		init {
			itemView.onLongClick {
				val dialogClickListener = DialogInterface.OnClickListener { _, which ->
					when (which) {
						DialogInterface.BUTTON_POSITIVE -> {
							val progress = ProgressDialog(activity)
							progress.setProgressStyle(ProgressDialog.STYLE_SPINNER)
							progress.setMessage("Deleting User")
							progress.show()
							Chat_userApi().chatUserDeleteAsync(
									user!!.id.toString(),
									(this@MemberListAdapter.activity as ChatinfoActivity).chat!!.id.toString(),
									object : ApiCallback<LogoutView> {
										override fun onSuccess(result: LogoutView?, statusCode: Int, responseHeaders: MutableMap<String, MutableList<String>>?) {
											Log.d("UserDelete", "Deleted Success")
											progress.dismiss()
											AlertDialog.Builder(activity).apply {
												setMessage("User removed")
												setPositiveButton("Ok", null)
												activity.runOnUiThread { show() }
											}
											userList!!.remove(user!!)
											activity.runOnUiThread { notifyDataSetChanged() }
										}

										override fun onFailure(e: ApiException?, statusCode: Int, responseHeaders: MutableMap<String, MutableList<String>>?) {
											Log.d("UserDelete", e!!.responseBody)
											progress.dismiss()
											AlertDialog.Builder(activity).apply {
												setMessage("Failed to delete user")
												setPositiveButton("Ok", null)
												activity.runOnUiThread { show() }
											}


										}

										override fun onUploadProgress(bytesWritten: Long, contentLength: Long, done: Boolean) = Unit

										override fun onDownloadProgress(bytesRead: Long, contentLength: Long, done: Boolean) = Unit
									})

						}

						DialogInterface.BUTTON_NEGATIVE -> Unit
					}

				}
				AlertDialog.Builder(activity).apply {
					setMessage("Would you like to remove this user??")
					setPositiveButton("Yes", dialogClickListener)
					setNegativeButton("No", dialogClickListener)
					show()
				}
			}
		}


		fun setUser(user: UserSerializer) {
			this.user = user
		}

		fun setNameTextView() {
			if (this.user != null && this.contactNameTextView != null)
				this.contactNameTextView.text = "${this.user!!.firstName} ${this.user!!.lastName}"
		}

		fun setOnlineStatus(isOnline: Boolean) = if (isOnline) {
			this.isOnlineView.visibility = View.VISIBLE
		} else {
			this.isOnlineView.visibility = View.INVISIBLE
		}

		fun setPicture() {
			if (this.pictureImageView != null) {
				this.pictureImageView.background = null
				Picasso.with(this@MemberListAdapter.activity.baseContext)
						.load(this.user!!.pictureFile.url)
						.error(drawable.educhat)
						.resize(
								Constants.GLOBAL_IMAGE_SIZE,
								Constants.GLOBAL_IMAGE_SIZE
						)
						.centerInside()
						.transform(CircleTransform(null))
						.into(this.pictureImageView)
			}
		}

		fun setAdminStatus(isAdmin: Boolean) =
				if (isAdmin) {
					this.isAdminTextView.visibility = View.VISIBLE
				} else {
					this.isAdminTextView.visibility = View.INVISIBLE
				}
	}

	companion object {

		private val CATEGORY_VIEW_TYPE = 0
		private val CONTACT_VIEW_TYPE = 1
	}
}

//		@SuppressLint("ResourceAsColor")
//		override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
//
//
//			val run = Runnable {
//				val dialogClickListener = DialogInterface.OnClickListener { _, which ->
//					when (which) {
//						DialogInterface.BUTTON_POSITIVE -> {
//							Chat_userApi().chatUserDeleteAsync(
//									this.user!!.id.toString(),
//									(this@MemberListAdapter.activity as ChatinfoActivity).chat!!.id.toString(),
//									object : ApiCallback<LogoutView> {
//										override fun onSuccess(result: LogoutView?, statusCode: Int, responseHeaders: MutableMap<String, MutableList<String>>?) {
//											Log.d("UserDelete", "Deleted Success")
//										}
//
//										override fun onFailure(e: ApiException?, statusCode: Int, responseHeaders: MutableMap<String, MutableList<String>>?){
//											Log.d("UserDelete", e!!.responseBody)
//										}
//
//										override fun onUploadProgress(bytesWritten: Long, contentLength: Long, done: Boolean) = Unit
//
//										override fun onDownloadProgress(bytesRead: Long, contentLength: Long, done: Boolean) = Unit
//									})
//
//						}
//
//						DialogInterface.BUTTON_NEGATIVE -> Unit
//					}
//
//				}
//				AlertDialog.Builder(activity).apply {
//					setMessage("Are you sure you want to delete?")
//					setPositiveButton("Yes", dialogClickListener)
//					setNegativeButton("No", dialogClickListener)
//					show()
//				}
//
//			}
//
//			val hand = Handler()
//			when (p1!!.action) {
//				MotionEvent.ACTION_DOWN -> {
//					hand.postDelayed(run, 2000)
//				}
//				MotionEvent.ACTION_MOVE->{
//					hand.removeCallbacks(run)
//				}
//				MotionEvent.ACTION_UP -> {
//					hand.removeCallbacks(run)
//					val intent = Intent(
//							this@MemberListAdapter.activity, UserProfileActivity::class.java
//					)
//					if (this.user != null) {
//						intent.putExtra("user_id", this.user!!.id)
//						Log.d("DetailsUsers", "" + this.user!!.firstName + " " + this.user!!.id)
//					} else {
//						intent.putExtra("user_id", CurrentUser.currentUser!!.id)
//					}
//					this@MemberListAdapter.activity.startActivity(intent)
//				}
//			}
//
//			return true
//
//		}
