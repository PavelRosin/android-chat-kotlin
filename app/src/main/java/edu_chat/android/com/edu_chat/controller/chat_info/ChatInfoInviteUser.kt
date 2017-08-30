package edu_chat.android.com.edu_chat.controller.chat_info

import android.content.Intent
import android.view.MotionEvent
import com.google.gson.Gson
import com.instabug.library.InstabugTrackingDelegate
import edu_chat.android.com.edu_chat.controller.message_list.MessageListActivity
import edu_chat.android.com.edu_chat.controller.invite.InviteActivity
import io.swagger.client.ApiCallback
import io.swagger.client.ApiException
import io.swagger.client.api.Chat_userApi
import io.swagger.client.model.ChatSerializer
import io.swagger.client.model.ChatUserListCreateView
import io.swagger.client.model.ChatUserPostSerializer
import kotlinx.android.synthetic.main.invite_toolbar.*
import org.jetbrains.anko.indeterminateProgressDialog
import java.util.*


class ChatInfoInviteUser : InviteActivity() {
	internal var chat: ChatSerializer? = null

	override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
		InstabugTrackingDelegate.notifyActivityGotTouchEvent(ev, this)
		return super.dispatchTouchEvent(ev)
	}

	override fun proceed_fun() {
		val gson = Gson()
		chat = gson.fromJson(intent.getStringExtra("CurrentChat"), ChatSerializer::class.java)
		chatInfoImageView.setOnClickListener { addUsers() }

	}

	private fun addUsers() {

		val progress = indeterminateProgressDialog("Adding users to chat")
		progress.show()
		val listchat = ArrayList<String>()
		val listuser = ArrayList<String>()

		for (users in selectedUsers) {
			listuser.add(users.id!!.toString())
			listchat.add(chat!!.id!!.toString())
		}

		val data = ChatUserPostSerializer()
		data.chat = listchat
		data.user = listuser
		try {
			Chat_userApi().chatUserCreateAsync(data, object : ApiCallback<ChatUserListCreateView> {
				override fun onFailure(e: ApiException, statusCode: Int, responseHeaders: Map<String, List<String>>) {

				}

				override fun onSuccess(result: ChatUserListCreateView, statusCode: Int, responseHeaders: Map<String, List<String>>) {
					progress.dismiss()
					val intent = Intent(baseContext, MessageListActivity::class.java)
					intent.putExtra("CurrentChat", Gson().toJson(chat))
					finish()
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

	}

}
