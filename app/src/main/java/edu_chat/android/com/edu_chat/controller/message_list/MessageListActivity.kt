package edu_chat.android.com.edu_chat.controller.message_list

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.Parcelable
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MotionEvent
import chat.edu.edu_chat.R.id
import chat.edu.edu_chat.R.layout
import com.google.android.gms.internal.ft
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.instabug.library.InstabugTrackingDelegate
import com.instabug.library.messaging.model.Chat
import edu_chat.android.com.edu_chat.controller.chat_list.ChatListActivity
import io.swagger.client.ApiCallback
import io.swagger.client.ApiException
import io.swagger.client.api.ChatApi
import io.swagger.client.api.MessageApi
import io.swagger.client.model.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.indeterminateProgressDialog


class MessageListActivity : AppCompatActivity() {
	var chat: ChatSerializer? = null
	private var message: MessageSerializer? = null
	var isSubchat: Boolean? = null
	var messageId: kotlin.Int? = null
	var parentChat: ChatSerializer? = null
	private var user: UserSerializer? = null
	private var created  = true
	var messageList: MessageListCreateView? = null
	var isBot = false
	var fromFcm = false
//	var subChatsList: ArrayList<ChatSerializer>? = null
	var userList : Map<String, UserSerializer>? =null
	val combinedBundle = Bundle()

	override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
		InstabugTrackingDelegate.notifyActivityGotTouchEvent(ev, this)
		return super.dispatchTouchEvent(ev)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		this.setContentView(layout.activity_chat)
		fromFcm = intent.getBooleanExtra("fromFcm", false)
		if(fromFcm){
			Log.d("FCM_chat", "Loaded from FCM")
			initFromFcm()
		}

		else {
			created = intent.getBooleanExtra("Created", true)
			chat = Gson().fromJson(intent.getStringExtra("CurrentChat"), ChatSerializer::class.java)
			Log.d("ChatRefresh", "" + (chat == null))
			messageList = Gson().fromJson(intent.getStringExtra("messageList"), MessageListCreateView::class.java)
			Log.d("ChatRefresh", "" + (messageList == null))
			parentChat = Gson().fromJson(intent.getStringExtra("ParentChat"), ChatSerializer::class.java)
			Log.d("ChatRefresh", "" + (parentChat == null))

			message = Gson().fromJson(intent.getStringExtra("message"), MessageSerializer::class.java)
			user = Gson().fromJson(intent.getStringExtra("messageUser"), UserSerializer::class.java)
			isBot = intent.getBooleanExtra("isBot", false)
//		val listType = object : TypeToken<ArrayList<ChatSerializer>>() {}.type
//		subChatsList = Gson().fromJson<ArrayList<ChatSerializer>>(intent.getStringExtra("SubChatsList"), listType)
			val userType = object : TypeToken<Map<String, UserSerializer>>() {}.type
			userList = Gson().fromJson<Map<String, UserSerializer>>(intent.getStringExtra("UserList"), userType)
			Log.d("ChatRefresh", "" + (userList == null))
			Log.d("testcommentt", message.toString())
			isSubchat = chat!!.parent != null
			Log.d("ChatRefresh", "" + (isSubchat == null))
			messageId = intent.getIntExtra("messageID", -1)
			startFragment()

		}
	}

	private fun replaceNewChatFragmentWithBundle(combinedBundle: Bundle) {
		Log.d("TestComment", combinedBundle.toString())
		messageId = combinedBundle.getInt("messageID", -1)
		if (created) {
			if (messageId == -1) {
				initFragment(this, null, null, null)
			} else {
				Log.d("testcomment", "success")
				initFragment(this, messageId, message, user)
			}
		}
	}

	override fun onBackPressed() {

		if (isSubchat!! || isBot || fromFcm){
			super.onBackPressed()
		}

		else{
			val intent = Intent(this, ChatListActivity::class.java)
			finish()
			startActivity(intent)
		}
	}

	fun initFragment(mActivity: MessageListActivity, messageId: Int?, message: MessageSerializer?, commentUser: UserSerializer?){
		val chatFragment = MessageListFragment(mActivity, messageId, message, commentUser)
		chatFragment.arguments = combinedBundle
		this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_NOSENSOR
		val ft = this.supportFragmentManager.beginTransaction()
		ft.add(id.fragment_1, chatFragment)
		ft.commit()
	}

	fun initFromFcm(){

		var progress = indeterminateProgressDialog("Loading messages")
		progress.setCanceledOnTouchOutside(false)
		progress.show()
		chat = Gson().fromJson(intent.getStringExtra("fcm_chat"), ChatSerializer::class.java)
		Log.d("FCM_chat", "Chat is " + (chat!=null))
		isSubchat = chat!!.parent!=null

		if(isSubchat!!){
			doAsync{
				val result = ChatApi().chatList(chat!!.parent, null, null, null, null,
						null, null, null, null, null)
				parentChat = result!!.results.chats[0]
				runOnUiThread{
					progress.dismiss()
				}
				runOnUiThread{startFragment()}
			}
		}
			else{
			parentChat = chat
			progress.dismiss()
			startFragment()
		}

	}

	fun startFragment(){
		combinedBundle.putBundle("CHAT_BUNDLE", intent.extras)

		val intent = this.intent
		var flag = false
		val isClass = intent.getBooleanExtra("isClass", false)
		if (intent.hasExtra("ActivityName")) {
			val activityName = this.intent.getStringExtra("ActivityName")
			if (activityName == "MessageAdapter") {
				val msg_parcelable = this.intent.extras.getParcelable<Parcelable>("MSG_PARCEL")
				val b_msg = Bundle()
				b_msg.putParcelable("MSG_PARCEL", msg_parcelable)

				combinedBundle.putBundle("MSG_BUNDLE", b_msg)
				flag = true
			}
		}
		combinedBundle.putBoolean("FLAG", flag)
		combinedBundle.putBoolean("IS_CLASS", isClass)
		combinedBundle.putInt("messageID", intent.getIntExtra("messageID", -1))
		combinedBundle.putString("parentChat", Gson().toJson(parentChat))
		this.replaceNewChatFragmentWithBundle(combinedBundle)
	}

}