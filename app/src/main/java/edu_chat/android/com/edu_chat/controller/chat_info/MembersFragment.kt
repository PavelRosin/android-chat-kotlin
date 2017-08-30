package edu_chat.android.com.edu_chat.controller.chat_info

//import edu_chat.android.com.edu_chat.view.DividerItemDecoration
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import chat.edu.edu_chat.R.layout
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import edu_chat.android.com.edu_chat.adapter.chat_info.MemberListAdapter
import edu_chat.android.com.edu_chat.adapter.chat_info.SubchatListAdapter
import edu_chat.android.com.edu_chat.controller.chat_create.CreateChatActivity
import edu_chat.android.com.edu_chat.model.Constants
import edu_chat.android.com.edu_chat.view.CircleTransform
import io.swagger.client.ApiCallback
import io.swagger.client.ApiException
import io.swagger.client.api.ChatApi
import io.swagger.client.api.Chat_userApi
import io.swagger.client.model.ChatListCreateView
import io.swagger.client.model.ChatSerializer
import io.swagger.client.model.ChatUserListCreateView
import io.swagger.client.model.UserSerializer
import kotlinx.android.synthetic.main.fragment_members.*
import kotlinx.android.synthetic.main.fragment_members.view.*
import java.util.*

/**
 * Created by yuandali on 6/20/16.
 * Edu.Chat Inc.
 */
@SuppressLint("ValidFragment")
class MembersFragment
constructor(var chat: ChatSerializer, private val mActivity: ChatinfoActivity, private var users: List<UserSerializer>) : Fragment() {

	var subChats: ArrayList<ChatSerializer>? = null
	private var membersOpen: Boolean = false
	var chatsOpen: Boolean = false

	override fun onAttach(context: Context?) {
		super.onAttach(context)
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
							  savedInstanceState: Bundle?): View? {
		return inflater.inflate(layout.fragment_members, container, false)
	}

	override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		initView()
		if (mActivity.isSubchat) {
			subchatListView!!.visibility = View.GONE
			newSubchat!!.visibility = View.GONE
			subchat_title!!.visibility = View.GONE
			subchatView!!.visibility = View.GONE
		}

		val mLayoutManager = LinearLayoutManager(activity)
		val initialMembers = ArrayList<UserSerializer>(0)
		if (users.size > 3) {
			for (i in 0..2){
				initialMembers.add(users[i])
			}
			view?.seeMore?.visibility = VISIBLE
			view?.seeMore?.text = "${view?.seeMore?.text.toString()} (${users.size})"
		} else {
			initialMembers.addAll(users)
		}
		membersListView!!.layoutManager = mLayoutManager
		val mla = MemberListAdapter(activity, initialMembers)
		Log.d("Members", users.size.toString())
		membersListView!!.adapter = mla

		view?.seeMore?.setOnClickListener {

			if (membersOpen) {
				val oldSize = mla.itemCount
				mla.userList = initialMembers
				mla.notifyItemRangeRemoved(2, oldSize)
				mla.notifyDataSetChanged()
				view.seeMore?.text = "See More (${users.size})"
				membersOpen = false

			} else {
				mla.userList = users as ArrayList<UserSerializer>
				mla.notifyItemRangeInserted(2, mla.itemCount)
				mla.notifyDataSetChanged()
				view.seeMore?.text = "See Less"
				membersOpen = true
			}

		}
		val membersFragment = this

		try {
			ChatApi().chatListAsync(null, null, null, null, null, null,null, chat.id, null, null, object : ApiCallback<ChatListCreateView> {
				override fun onFailure(e: ApiException, statusCode: Int, responseHeaders: Map<String, List<String>>) {

				}

				override fun onSuccess(result: ChatListCreateView, statusCode: Int, responseHeaders: Map<String, List<String>>) {

					subChats = result.results.chats as ArrayList<ChatSerializer>?
					if (subChats!!.isEmpty()) {
						if (activity!=null){
							activity.runOnUiThread {
								if (!mActivity.isSubchat) {
									nosubchats!!.visibility = VISIBLE
								}
							}
						}
					} else{
							val initialChats = ArrayList<ChatSerializer>(0)

							if (subChats!!.size > 3) {
								for (i in 0..2){
									initialChats.add(subChats!![i])
								}
								if (activity!=null) {
									activity.runOnUiThread {
										view?.seeMoreSubchat?.visibility = VISIBLE
										view?.seeMoreSubchat?.text = "${view?.seeMoreSubchat?.text.toString()} (${subChats?.size})"
									}
								}
								} else {
								initialChats.addAll(result.results.chats)
							}

							if (activity!=null) {
								activity.runOnUiThread {
									val mLayoutManager2 = LinearLayoutManager(context)
									subchatListView!!.layoutManager = mLayoutManager2
									val subchatListAdapter = SubchatListAdapter(membersFragment, initialChats, result.results.users)
									activity.runOnUiThread {
										subchatListView!!.adapter = subchatListAdapter
										view?.seeMoreSubchat?.setOnClickListener({

											if (chatsOpen) {
												val oldSize = subchatListAdapter.itemCount
												subchatListAdapter.ChatList = initialChats
												subchatListAdapter.notifyItemRangeChanged(2, oldSize)
												view.seeMoreSubchat?.text = "See More (${subChats?.size})"
												chatsOpen = false
											} else {
												subchatListAdapter.ChatList = subChats!!
												subchatListAdapter.notifyItemRangeChanged(2, subchatListAdapter.itemCount)
												view.seeMoreSubchat?.text = "See Less"
												chatsOpen = true
											}

										})
									}
								}
							}

					}
				}

				override fun onUploadProgress(bytesWritten: Long, contentLength: Long, done: Boolean) {

				}

				override fun onDownloadProgress(bytesRead: Long, contentLength: Long, done: Boolean) {

				}
			})
		} catch (e: ApiException) {
			e.printStackTrace()
		}
	}

	private fun initView() {
		this.chat_title!!.text = chat.name
		Picasso.with(context)
				.load(chat.pictureFile.url)
				.resize(
						Constants.GLOBAL_IMAGE_SIZE,
						Constants.GLOBAL_IMAGE_SIZE
				)
				.centerInside()
				.into(this.chat_image)

		this.membersListView!!.layoutManager = LinearLayoutManager(activity)
//		this.membersListView!!.addItemDecoration(activity)
		val currentUsers = users.map { it.id }
		this.fragmentAddMember!!.setOnClickListener {
			Log.d("AddMember", "Clicked")
			//Start activity passing in parent users if this is a subchat
			if (mActivity.isSubchat) {

				val cuApi = Chat_userApi()
				try {
					cuApi.chatUserListAsync(mActivity.parentId, null, null, null, null, object : ApiCallback<ChatUserListCreateView> {
						override fun onFailure(e: ApiException, statusCode: Int, responseHeaders: Map<String, List<String>>) {
							Log.d("AddMember", e.responseBody)
						}

						override fun onSuccess(result: ChatUserListCreateView, statusCode: Int, responseHeaders: Map<String, List<String>>) {
							val intent = Intent(activity, ChatInfoInviteUser::class.java)
							intent.putExtra("CurrentChat", Gson().toJson(chat))
							intent.putExtra("isSubchat", mActivity.isSubchat)
							intent.putExtra("CurrentUsers", Gson().toJson(currentUsers))
							val parentUsers = (result.results.map { it.user }) as ArrayList<UserSerializer>
							intent.putExtra("ParentUsers", Gson().toJson(parentUsers))
							startActivity(intent)
						}

						override fun onUploadProgress(bytesWritten: Long, contentLength: Long, done: Boolean) {

						}

						override fun onDownloadProgress(bytesRead: Long, contentLength: Long, done: Boolean) {

						}
					})
				} catch (e: ApiException) {
					e.printStackTrace()
				}

			} else {
				//Regular Start Activity
				val intent = Intent(activity, ChatInfoInviteUser::class.java)
				intent.putExtra("CurrentChat", Gson().toJson(chat))
				intent.putExtra("isSubchat", mActivity.isSubchat)
				intent.putExtra("CurrentUsers", Gson().toJson(currentUsers))
				startActivity(intent)

			}
		}

		if (!mActivity.isSubchat) {
			this.newSubchat!!.setOnClickListener {
				val intent = Intent(activity, CreateChatActivity::class.java)
				intent.putExtra("isSubchat", true)
				intent.putExtra("ParentChat", Gson().toJson(chat))
				intent.putExtra("CurrentUsers", Gson().toJson(currentUsers))
				intent.putExtra("ParentUsers", Gson().toJson(users))
				Log.d("ParentUsers", "MembersFragment success")
				startActivity(intent)
			}
		}
	}

	companion object {
		var users: List<UserSerializer> = ArrayList()
	}

}
