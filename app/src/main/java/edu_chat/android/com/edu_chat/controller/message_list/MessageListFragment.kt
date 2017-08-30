package edu_chat.android.com.edu_chat.controller.message_list

import android.animation.LayoutTransition
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.*
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView.OnEditorActionListener
import android.widget.Toast
import chat.edu.edu_chat.R
import chat.edu.edu_chat.R.id.finish
import chat.edu.edu_chat.R.menu
import com.google.gson.Gson
import com.miguelcatalan.materialsearchview.MaterialSearchView.OnQueryTextListener
import com.squareup.picasso.Picasso
import edu_chat.android.com.edu_chat.adapter.message_list.MessageAdapter
import edu_chat.android.com.edu_chat.adapter.message_list.SubchatGridviewAdapter
import edu_chat.android.com.edu_chat.controller.chat_create.CreateChatActivity
import edu_chat.android.com.edu_chat.controller.chat_info.ChatinfoActivity
import edu_chat.android.com.edu_chat.controller.chat_list.ChatListActivity
import edu_chat.android.com.edu_chat.model.Constants
import edu_chat.android.com.edu_chat.model.CurrentUser
import edu_chat.android.com.edu_chat.view.CircleTransform
import io.socket.client.IO
import io.socket.client.Socket
import io.socket.emitter.Emitter
import io.swagger.client.ApiCallback
import io.swagger.client.ApiException
import io.swagger.client.api.ChatApi
import io.swagger.client.api.Chat_userApi
import io.swagger.client.api.MessageApi
import io.swagger.client.model.*
import kotlinx.android.synthetic.main.chat_layout.*
import kotlinx.android.synthetic.main.chat_toolbar.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.support.v4.indeterminateProgressDialog
import org.json.JSONException
import org.json.JSONObject
import java.net.URISyntaxException
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by pallakanand on 7/13/17.
 * Edu.Chat Inc.
 */

@SuppressLint("ValidFragment")
class MessageListFragment
constructor(private val mActivity: MessageListActivity, private val messageId: Int?, private val message: MessageSerializer?, private val commentUser: UserSerializer?) : Fragment() {

	private val isTypingListener = Emitter.Listener {
		if(activity!=null){
			activity.runOnUiThread {
				Log.i("WebSocket", "Is Typing Listener")
				println(Arrays.toString(it))
				this@MessageListFragment.isTypingTextView!!.visibility = View.VISIBLE
				this@MessageListFragment.isTypingTextView!!.text = getString(R.string.is_typing)
			}
		}
	}
	private val listener = Emitter.Listener {
		this@MessageListFragment.activity.runOnUiThread {
			Log.i("WebSocket All", it[0].toString())
		}
	}
	private val onUserJoined = Emitter.Listener {
		activity.runOnUiThread(Runnable {
			Log.i("WebSocket", "User Joined Listener")
			val data = it[0] as JSONObject
			val username: String?
			try {
				username = data.getString("username")
			} catch (e: JSONException) {
				Log.e("WebSocket", e.message)
				return@Runnable
			}

			if (username != null) {
				isTypingTextView!!.text = "$username  joined !"
			}
		})
	}
	private val onUserLeft = Emitter.Listener {
		activity.runOnUiThread(Runnable {
			Log.i("WebSocket", "User Left Listener")
			val data = it[0] as JSONObject
			val username: String?
//				val numUsers: Int
			try {
				username = data.getString("username")
//					numUsers = data.getInt("numUsers")
			} catch (e: JSONException) {
				Log.e("WebSocket", e.message)
				return@Runnable
			}

			if (username != null) {
				isTypingTextView!!.text = "$username  left !"
			}
		})
	}
	private val onConnect = Emitter.Listener {
		activity.runOnUiThread {
			Log.i("WebSocket", "Connected")
			Toast.makeText(context, "Connected", Toast.LENGTH_LONG).show()
		}
	}
	private val onDisconnect = Emitter.Listener {
		activity.runOnUiThread {
			Log.i("WebSocket", "disconnected")
			Toast.makeText(context, "Disconnected", Toast.LENGTH_LONG).show()
		}
	}
	private val onConnectError = Emitter.Listener {
		activity.runOnUiThread {
			Log.e("WebSocket", "Error connecting")
			Toast.makeText(context,
					"Connection Error", Toast.LENGTH_LONG).show()
		}
	}
	private val onNewMessage = Emitter.Listener {
		if(activity!=null){
			activity.runOnUiThread {
				Log.i("WebSocket", "onNewMessage")
				val data = it[0] as JSONObject

				try {
					val message = data.getString("message")
					val socketMessage = Gson().fromJson(message, MessageSerializer::class.java)
					mAdapter!!.addItem(socketMessage)
					messages!!.scrollToPosition(0)
					isTypingTextView!!.visibility = View.INVISIBLE
					Log.i("WebSocket message", message)
				} catch (e: JSONException) {
					Log.e("WebSocket", e.message)
				}
			}
		}
	}
	private var recyclerView: RecyclerView? = null
	private var iscomment: Boolean = false
	private var gestureDetector: GestureDetector? = null
	private var mAdapter: MessageAdapter? = null
	private var mSocket: Socket? = null
	private var dX: Float = 0.toFloat()
	private val user = CurrentUser.currentUser
	private val membersList = ArrayList<UserSerializer>()
	private val parentUserList = ArrayList<UserSerializer>()
	private val chat = mActivity.chat
	private val isSubchat = mActivity!!.isSubchat
	private var messageList = mActivity.messageList
	private var subChats : ArrayList<ChatSerializer>?=null
	private var userList = emptyMap<String, UserSerializer>()


	override fun setUserVisibleHint(isVisibleToUser: Boolean) {
		super.setUserVisibleHint(isVisibleToUser)
		if (isVisibleToUser) {
			this.activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
		}
	}

	override fun onAttach(context: Context?) = super.onAttach(context)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		this.gestureDetector = GestureDetector(this.activity, SingleTapConfirm())
		this.gestureDetector!!.setIsLongpressEnabled(true)
		this@MessageListFragment.socketSetup()
		val combined_bundle = this.arguments
		if (combined_bundle.getBoolean("FLAG")) {
			// it means this is comment
			val b_msg = combined_bundle.getBundle("MSG_BUNDLE")
			this.iscomment = true

		} else
			this.iscomment = false
		val b_chat = combined_bundle.getBundle("CHAT_BUNDLE")

		doAsync{
			val results = Chat_userApi().chatUserList(mActivity.chat!!.id,
					null, null, null,null).results

			for (user in results){
				val pair = Pair<String, UserSerializer>(user!!.user.id.toString(), user.user)
				userList = userList.plus(pair)
			}
		}

	}


	// SOCKET SETUP FUNCTION

	private fun socketSetup() {
		val opts = IO.Options()
		opts.query = "token=" + CurrentUser.token + "&user_id=" + user!!.id +
				"&chat_id=" + this.mActivity.chat!!.id
		try {
			this.mSocket = IO.socket("https://socket.edu.chat/", opts)
		} catch (e: URISyntaxException) {
			e.printStackTrace()
		}

		this.mSocket!!.on(Socket.EVENT_DISCONNECT, onDisconnect)
		this.mSocket!!.on(Socket.EVENT_CONNECT_ERROR, onConnectError)
		this.mSocket!!.on(Socket.EVENT_CONNECT_TIMEOUT, onConnectError)
		this.mSocket!!.on("message recived", this.onNewMessage)
		this.mSocket!!.on("user is typing", this.isTypingListener)
		this.mSocket!!.on("join chat", this.onUserJoined)
		this.mSocket!!.on("leave chat", this.onUserLeft)
		this.mSocket!!.on("*", this.listener)
		this.mSocket!!.connect()
		this.mSocket!!.open()
		Log.d("WebSocket", this.mSocket!!.toString())
	}


	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
							  savedInstanceState: Bundle?): View? {
		val v = inflater.inflate(R.layout.chat_layout, container, false)
		v.setBackgroundColor(Color.WHITE)
		this.setHasOptionsMenu(true)
		return v
	}


	override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		(chat_toolbar as Toolbar).inflateMenu(menu.chat_menu)
		if (this.iscomment) {
			this.search_view!!.setHint("Search for Comments")
			this.lineView2.visibility = View.VISIBLE
			this.comment_message.visibility = View.VISIBLE
			this.username.text = commentUser?.firstName
			if (user != null) {
				Picasso.with(this@MessageListFragment.activity)
						.load(commentUser!!.pictureFile.url)
						.error(R.drawable.educhat)
						.resize(
								Constants.GLOBAL_IMAGE_SIZE,
								Constants.GLOBAL_IMAGE_SIZE
						)
						.centerInside()
						.transform(CircleTransform(null))
						.into(this.userProfilePicture)
			}
			this.commentmessage.text = this.message?.text
		}
		else
			this.search_view!!.setHint("Search for Messages")
		if(!this.iscomment) {
			if (isSubchat!!) {
//			try {
//				ChatApi().chatListAsync(mActivity.chat!!.parent, null, null, null, null, null, null, null, null, object : ApiCallback<ChatListCreateView> {
//					override fun onFailure(e: ApiException?, statusCode: Int, responseHeaders: MutableMap<String, MutableList<String>>?) {
//
//					}
//
//					override fun onSuccess(result: ChatListCreateView?, statusCode: Int, responseHeaders: MutableMap<String, MutableList<String>>?) {
//						if (activity!=null){ activity.runOnUiThread {
//								chat_name_text!!.text = result!!.results.chats[0].name
//								setNavigation(result.results.chats[0])
//								setGridView(result.results.chats[0])
//							}
//						}
//					}
//
//					override fun onUploadProgress(bytesWritten: Long, contentLength: Long, done: Boolean) {
//
//					}
//
//					override fun onDownloadProgress(bytesRead: Long, contentLength: Long, done: Boolean) {
//
//					}
//				})
//			}catch ( e: ApiException){
//				e.printStackTrace()
//			}
				chat_name_text!!.text = mActivity.parentChat!!.name
				subchat_name_text!!.visibility = View.VISIBLE
				this.subchat_name_text!!.text = mActivity.chat!!.name
			} else {
				if (chat!!.isClass) {
					this.subchat_name_text!!.visibility = View.VISIBLE
					this.subchat_name_text!!.text = resources.getString(R.string.announcement)
				}
				this.chat_name_text!!.text = chat.name
			}
//			if (chat!!.hasChildren) {
//				setNavigation(mActivity.parentChat!!)
//				setGridView(mActivity.parentChat!!)
//			}
//			else{
//				setNavigation(mActivity.parentChat)
//				setGridView(mActivity.parentChat)
//			}
			setNavigation(mActivity.parentChat)
			setGridView(mActivity.parentChat)
		}
		initMessages()
		initUserList()

		search_view!!.setOnQueryTextListener(SearchViewQueryTextFilter())
		recyclerView = messages
		val initialX = this.recyclerView!!.x
//		this.recyclerView!!.setOnTouchListener(object : View.OnTouchListener {
//			private var isMoved: Boolean = false
//
//			//			@RequiresApi(api = VERSION_CODES.M)
//			override fun onTouch(v: View,
//								 event: MotionEvent): Boolean {
//				// need to do something magical here
//				this@MessageListFragment.gestureDetector!!.onTouchEvent(event)
//
//				val size = this@MessageListFragment.recyclerView!!.childCount
//				when (event.action) {
//					MotionEvent.ACTION_DOWN -> {
//						this.isMoved = false
//						this@MessageListFragment.dX = v.x - event.rawX
//					}
////					MotionEvent.ACTION_MOVE -> {
////
////						if (event.rawX > Math.abs(this@MessageListFragment.dX) &&
////								Math.abs(event.rawX - Math.abs(this@MessageListFragment.dX)) < 165.0f &&
////								Math.abs(event.rawX - Math.abs(this@MessageListFragment.dX)) > 100.0f) {
////								Log.d("Jacob was here", "Comments")
////						}
////
////						if (event.rawX < Math.abs(this@MessageListFragment.dX) &&
////								Math.abs(event.rawX - Math.abs(this@MessageListFragment.dX)) < 165.0f &&
////								Math.abs(event.rawX - Math.abs(this@MessageListFragment.dX)) > 100.0f) {
////							//                         if( Math.abs(event.getRawX() - Math.abs(dX))<120 && Math.abs(event
////							// .getRawX() - Math.abs(dX))>100) {
////							// to restrict the left swipe
////							this.isMoved = true
////							var i = 0
//////							while (i < size && i < this@MessageListFragment.recyclerView!!
//////									.childCount) {
//////								val childView = this@MessageListFragment.recyclerView!!.getChildAt(i)
//////								//                                final ViewHolder holder = ChatListFragment.this.recyclerView
//////								//                                        .findContainingViewHolder(childView);
//////								childView.animate().x(event.rawX + this@MessageListFragment.dX)
//////										.setDuration(0L)
//////										.start()
//////								i++
//////								//                                if(holder.getItemViewType()==1 || holder.getItemViewType()
//////								// ==3||holder.getItemViewType()==6){
//////								////                                    float initialXofChild = childView.getX();
//////								//                                    childView.animate().x((event.getRawX()+dX)).setDuration(0)
//////								// .start();
//////								//                                }
//////							}
////							//                            view.animate()
////							//                                    .x(event.getRawX() + dX)
////							//                                 //   .y(event.getRawY()+ dY) // to restrict the vertical motion
////							//                                    .setDuration(0)
////							//                                    .start();
////						} else {
////							// this is for the natural vertical scroll
////							return false
////						}
////					}
//					MotionEvent.ACTION_UP -> {
//						val childCount = this@MessageListFragment.recyclerView!!.childCount
//						if (this.isMoved) {
//							var i = 0
//							while (i < childCount && i < this@MessageListFragment.recyclerView!!
//									.childCount) {
//								val childView = this@MessageListFragment.recyclerView!!.getChildAt(i)
//								//                                final ViewHolder holder = ChatListFragment.this.recyclerView
//								//                                        .findContainingViewHolder(childView);
//								childView.animate().x(initialX).setDuration(500L).start()
//								i++
//							}
//						}
//						this.isMoved = false
//					}
//					else -> return false
//				}
//				return true
//			}
//
//		})

		(this.activity as AppCompatActivity).setSupportActionBar(chat_toolbar as Toolbar?)
		(this.activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(true)


		this.message_input!!.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
			send_button!!.setImageResource(R.drawable.ic_send_black_24dp)
			if (actionId == EditorInfo.IME_ACTION_SEND || actionId == EditorInfo.IME_NULL) {
				this@MessageListFragment.attemptSend(message_input!!.text.toString())
				val imm = this@MessageListFragment
						.activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
				imm.hideSoftInputFromWindow(
						this@MessageListFragment.activity.currentFocus!!
								.windowToken,
						InputMethodManager.HIDE_NOT_ALWAYS
				)
				return@OnEditorActionListener true
			}
			false
		})

		this.message_input!!.addTextChangedListener(object : TextWatcher {
			override fun beforeTextChanged(s: CharSequence, start: Int, count: Int,
										   after: Int) {
				//                sendButton.setVisibility(View.VISIBLE);
			}

			override fun onTextChanged(s: CharSequence, start: Int, before: Int,
									   count: Int) {
				isTypingTextView!!.visibility = View.VISIBLE
				Log.d("Message", "User is Typing")
				val myMap = HashMap<String, String>()
				myMap.put(mActivity.chat!!.id!!.toString(), user!!.id!!.toString())
				this@MessageListFragment.mSocket!!.emit("is typing", myMap)
				send_button!!.setImageResource(R.drawable.ic_send_black_24dp)
			}

			override fun afterTextChanged(s: Editable) {
				if (this@MessageListFragment.message_input!!.text.toString().trim { it <= ' ' }.isEmpty()) {
					isTypingTextView!!.visibility = View.INVISIBLE
					isTypingTextView!!.text = ""
					// MessageListFragment.this.mSocket.emit("stopTyping", user);
					Log.d("Messaging", "User stopped Typing")
				}
			}
		})
		this.send_button!!.setOnClickListener {
			this@MessageListFragment.attemptSend(message_input!!.text.toString())

		}

		this.bot_icon!!.setOnClickListener {
			if (subChats == null) {
				subChats = ChatApi().chatList(null, null, null, null,
						null, null, null,
						chat!!.id, null, null).results.chats as ArrayList<ChatSerializer>
				initBotChat()
			} else {
				initBotChat()
			}
		}

		this.add_files_imagebutton!!.setOnClickListener {
			val intent = Intent()
			intent.action = Intent.ACTION_GET_CONTENT
			intent.type = "file/*"
			this@MessageListFragment.startActivity(intent)
		}
		/*
        messagingLayout.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(final View v, MotionEvent motionEvent) {
                InputMethodManager IM = (InputMethodManager) getActivity().getSystemService
                (Context.INPUT_METHOD_SERVICE);
                IM.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                return false;
            }
        });

*/
		Log.d("ZZZZZ", "" + (chat_toolbar!=null))
		(chat_toolbar as Toolbar?)!!.setNavigationOnClickListener{
			Log.d("ZZZZZ", "CLICKED " + (chat_toolbar!=null))
			Log.d("FCM_chat", "FCM is " + mActivity.fromFcm.toString())
			if (mActivity.fromFcm) {
				val intent = Intent(context, ChatListActivity::class.java)
				activity.finish()
				startActivity(intent)
			}

			else if ( mActivity.chat!!.parent == null) {
				val intent = Intent(
						this@MessageListFragment.activity,
						ChatListActivity::class.java
				)
				intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
				Log.d("SubChatzzzzz", "We got here")
				this@MessageListFragment.activity.startActivity(intent)
				this@MessageListFragment.activity.finish()

			} else {
				activity.onBackPressed()
			}
		}
	}

	private fun initMessages(){
		val layoutManager = PreCachingLayoutManager(activity)
		layoutManager.reverseLayout = true
		layoutManager.stackFromEnd = true
		layoutManager.setExtraLayoutSpace(1600)
		messages!!.layoutManager = layoutManager
		messages!!.setItemViewCacheSize(100)
		messages!!.isDrawingCacheEnabled = true
		messages!!.drawingCacheQuality = View.DRAWING_CACHE_QUALITY_HIGH

		if (messageList == null){
			doAsync {
				messageList = MessageApi().messageList(chat!!.id, null	,
						null, null, null, null,
						null, messageId, null, null, null, null, null)
				messageList!!.results.messages.reverse()

				if (messageId == -1 || messageId == null)
					mAdapter = MessageAdapter(mActivity, messageList!!, chat!!, false)
				else
					mAdapter = MessageAdapter(mActivity, messageList!!, chat!!, true)

				if(activity!=null){
					activity.runOnUiThread{
						messages!!.adapter = mAdapter
						messages!!.addOnScrollListener(InfiniteScrollListener(layoutManager, mAdapter!!, chat.id, messageId))
						mAdapter!!.notifyDataSetChanged()
						messages!!.scrollToPosition(0)
					}
				}
			}
		}

		else {
			if (messageId == -1 || messageId == null)
				mAdapter = MessageAdapter(mActivity, messageList!!, chat!!, false)
			else
				mAdapter = MessageAdapter(mActivity, messageList!!, chat!!, true)

			messages!!.adapter = mAdapter
			messages!!.addOnScrollListener(InfiniteScrollListener(layoutManager, mAdapter!!, chat!!.id, messageId))
			mAdapter!!.notifyDataSetChanged()
			messages!!.scrollToPosition(0)
		}
	}

	private fun setNavigation(chatSerializer: ChatSerializer?) {
		val isClass = chatSerializer!!.isClass
		Log.d("FCM_chat", "Navigation set")
	}

	private fun initUserList() {

		doAsync{
			val results = Chat_userApi().chatUserList(
					mActivity.chat!!.id,
					null,
					null,
					null,
					null
			).results

			for (user in results){
				membersList.add(user.user)
			}
			if (chatInfoImageView != null) {
				activity.runOnUiThread({
					chatInfoImageView.visibility = View.VISIBLE
					if (!isSubchat!!) bot_icon.visibility = View.VISIBLE
				})
				chatInfoImageView!!.setOnClickListener {

					val intent = Intent(
							activity.baseContext,
							ChatinfoActivity::class.java
					)
					intent.putExtra("CurrentChat", Gson().toJson(mActivity.chat))
					intent.putExtra("Members", Gson().toJson(membersList))
					if (mActivity.parentChat != null) {
						intent.putExtra("ParentChat", Gson().toJson(mActivity.parentChat))
						Log.d("ChatRefresh", "ParentChat sent from Fragment")
					}
					intent.putExtra("isSubchat", isSubchat)
					intent.putExtra("UserList", Gson().toJson(userList))
					Log.d("ChatRefresh", "UserList sent from Fragment")
					intent.putExtra("isBot", mActivity.isBot)
					activity.startActivity(intent)
				}
			}

		}
	}

	private fun initBotChat() {
		var hasBot = false
		var index = 0
		for (subchat in subChats!!) {
			if (subchat.isBot) {
				hasBot = true
				index = subChats!!.indexOf(subchat)
				break
			}
		}
		if (!hasBot) {
			val progress = indeterminateProgressDialog("Entering Bot Chat")
			progress.setCanceledOnTouchOutside(false)
			progress.show()
			val data = APIViewChatSerializer()
			data.isBot = true
			data.name = "Bot Chat"
			data.parent = chat!!.id
			doAsync{
				var result = ChatApi().chatCreate(data).results
				val intent = Intent(context, MessageListActivity::class.java)
				intent.putExtra("CurrentChat", Gson().toJson(result))
				intent.putExtra("ParentChat", Gson().toJson(chat))
				intent.putExtra("UserList", Gson().toJson(userList))
				intent.putExtra("isClass", false)
				intent.putExtra("isBot", true)
				activity.finish()
				startActivity(intent)
			}
		} else {
			val intent = Intent(context, MessageListActivity::class.java)
			intent.putExtra("CurrentChat", Gson().toJson(subChats!![index]))
			intent.putExtra("isClass", false)
			intent.putExtra("isBot", true)
			intent.putExtra("ParentChat", Gson().toJson(chat))
			intent.putExtra("UserList", Gson().toJson(userList))
			finish
			startActivity(intent)
		}
	}

	private fun setGridView(parentChat : ChatSerializer?) {
		gridView_frame.layoutTransition.enableTransitionType(LayoutTransition.DISAPPEARING)

		doAsync {
			val result = ChatApi().chatList(null, null, null, null, null,
					null, null,parentChat!!.id, null, null)
			activity.runOnUiThread {
				create_new_subchat!!.visibility = View.VISIBLE
				if (isSubchat!!) {
					result?.results?.chats?.remove(mActivity.chat!!)
					if (parentChat.isClass) {
						result?.results?.chats?.add(0, parentChat)
					}
				}
				if (result?.results?.chats?.size == 0) divider.visibility = View.GONE
				else divider.visibility = View.VISIBLE
			}

			val subChatList = result?.results?.chats
			val itemListDataAdapter: SubchatGridviewAdapter?
			itemListDataAdapter = SubchatGridviewAdapter(mActivity.parentChat!!, context, chat!!, subChatList as ArrayList<ChatSerializer>)
			val linearlayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

			activity.runOnUiThread{
				if (subChats?.size != 0 || parentChat!!.isClass) {
					arrow_drop_down?.visibility = View.VISIBLE
				} else {
					arrow_drop_down?.visibility = View.GONE
				}
				gridView_frame?.visibility = View.GONE
				gridView?.visibility = View.GONE
				gridView?.hasFixedSize()
				gridView?.layoutManager = linearlayoutManager
				gridView?.adapter = itemListDataAdapter
				gridView?.isNestedScrollingEnabled = false

				create_new_subchat?.setOnClickListener {
					if (!chat.hasChildren) {
						doAsync {
							val result = Chat_userApi().chatUserList(parentChat.id, null,
									null, null, null)
							if (activity != null) {
								activity.runOnUiThread {
									Log.d("ChatUser", result.results.toString())
									for (i in 0 until result.results.size) {
										parentUserList.add(result.results[i].user)
									}
									val intent = Intent(activity, CreateChatActivity::class.java)
									intent.putExtra("isSubchat", true)
									intent.putExtra("ParentChat", Gson().toJson(parentChat))
									intent.putExtra("ParentUsers", Gson().toJson(parentUserList))
									Log.d("ParentUsers", "MembersFragment success")
									startActivity(intent)
								}
							}
						}
					}

					else{
						Log.d("ChatUser", result.results.toString())
						val intent = Intent(activity, CreateChatActivity::class.java)
						intent.putExtra("isSubchat", true)
						intent.putExtra("ParentChat", Gson().toJson(parentChat))
						intent.putExtra("ParentUsers", Gson().toJson(membersList))
						Log.d("ParentUsers", "MembersFragment success")
						startActivity(intent)
					}
				}
			}
		}

		if (arrow_drop_down == null) {
			return
		}
		else {
			toolbar_title.setOnClickListener {
				if (arrow_drop_down.rotation == 0f) {
					arrow_drop_down.animate().rotation(if (arrow_drop_down.rotation == 180f) 0f else 180f).interpolator = AccelerateDecelerateInterpolator()
					activity.runOnUiThread({
						//											class_subchat_gridview?.visibility = View.VISIBLE
						gridView_frame?.visibility = View.VISIBLE
						gridView?.visibility = View.VISIBLE
//											class_subchat_type?.visibility = View.GONE
						messages?.visibility = View.GONE
					})
				}
				if (arrow_drop_down.rotation == 180f) {
					arrow_drop_down.animate().rotation(if (arrow_drop_down.rotation == 0f) 180f else 0f).interpolator = AccelerateDecelerateInterpolator()
					activity.runOnUiThread({
						//											class_subchat_gridview?.visibility = View.GONE
						gridView_frame?.visibility = View.GONE
						gridView?.visibility = View.VISIBLE
//											class_subchat_type?.visibility = View.VISIBLE
						messages?.visibility = View.VISIBLE
					})

				}
			}
		}
	}

	/**
	 * Private method to send message. Make sure to make the HTTP/Socket calls here.
	 */
	private fun attemptSend(message: String) {
		////        TODO: Swaggerfy
		//
		Log.d("ATTEMPT", "attempt to send")
		//final String message = this.message_input.getText().toString().trim();
		if (TextUtils.isEmpty(message)) {
			this.message_input!!.requestFocus()
			return
		}

		this.message_input!!.setText("")

		val msg = MessageSendSerializer()
		msg.text = message
		msg.user = user!!.id
		msg.chat = mActivity.chat!!.id
		msg.parent = messageId
		msg.isQuestion = mActivity.isBot
		doAsync{
			MessageApi().messageCreate(msg)
		}
	}

	override fun onDestroy() {
		super.onDestroy()
		Log.d("MessageListFragment", "onDestroy Called")
		val imm = this.activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
		imm.hideSoftInputFromWindow(View(this.context).windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
		//(this.activity as MessageListActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(false)
		if (this.mSocket == null) return
		this.mSocket!!.off(Socket.EVENT_CONNECT, onConnect)
		this.mSocket!!.off(Socket.EVENT_DISCONNECT, onDisconnect)
		this.mSocket!!.off(Socket.EVENT_CONNECT_ERROR, onConnectError)
		this.mSocket!!.off(Socket.EVENT_CONNECT_TIMEOUT, onConnectError)
		this.mSocket!!.off("*", this.listener)
		this.mSocket!!.off("message recived", this.onNewMessage)
		this.mSocket!!.off("user is typing", this.isTypingListener)
		this.mSocket!!.off("join chat", this.onUserJoined)
		this.mSocket!!.off("leave chat", this.onUserLeft)
		this.mSocket!!.close()
		this.mSocket!!.disconnect()
	}

	override fun onCreateOptionsMenu(menu: Menu,
									 inflater: MenuInflater) {
		super.onCreateOptionsMenu(menu, inflater)
		inflater.inflate(R.menu.main_menu, menu)
		this.search_view!!.setMenuItem(menu.findItem(R.id.action_search))
	}

	private fun getmAdapter(): MessageAdapter? = this.mAdapter

	private inner class SingleTapConfirm : SimpleOnGestureListener() {

		override fun onSingleTapUp(e: MotionEvent): Boolean = true


//		override fun onLongPress(e: MotionEvent) {
//			super.onLongPress(e)
//			// need to extract the message here
//			val child = this@MessageListFragment.recyclerView!!.findChildViewUnder(
//					e.rawX, e.rawY
//			)
//			child.setBackgroundColor(Color.parseColor("#00ff00"))
//			val vg = child as ViewGroup
//
//			val childCount = vg.childCount
//			val pos = this@MessageListFragment.recyclerView!!.getChildAdapterPosition(child)
//			val adp = this@MessageListFragment.recyclerView!!.adapter as MessageAdapter
//			val extract = adp.getitematposition(pos - 1)
//			// don't know why I have to use pos - 1
//
//			val result: StringBuilder? = null
//			(0 until childCount).forEach { result!!.append(vg.getChildAt(it).id) }
//			if (extract != null) {
//				if (CurrentUser.currentUser!!.id === extract.user)
//					Toast.makeText(
//							this@MessageListFragment.activity,
//							"this is yourself",
//							Toast.LENGTH_SHORT
//					).show()
//				else
//					Toast.makeText(
//							this@MessageListFragment.activity,
//							"long pressed on $pos Title \n$result",
//							Toast.LENGTH_SHORT
//					).show()
//			}
//		}
	}

	private inner class SearchViewQueryTextFilter : OnQueryTextListener {
		override fun onQueryTextSubmit(query: String): Boolean {
			Log.d("Search", "Query: " + query)
			//TODO Dan
			//            Log.d("Search", "Message Success");
			//            List<MessageUnreadSerializer> tempMessageList = new ArrayList<>();
			//            Iterator<MessageUnreadSerializer> messageIterator = messageList.iterator();
			//            if (messageIterator.hasNext()) {
			//                do {
			//                    MessageUnreadSerializer currMessage = messageIterator.next();
			//                    if (currMessage.getText().toLowerCase().contains(query.toLowerCase())) {
			//                        Log.d("Search", "Message: " + currMessage.getText());
			//                        tempMessageList.add(currMessage);
			//                    }
			//                } while (messageIterator.hasNext());
			//            }
			//            messageList = tempMessageList;
			//            //CurrentMessageList.setChatResourceListView(messageList);
			//            //CurrentMessageList.setChatResourceListView(new MessageListCreateView(messageList));
			//            giveDataToAdapter(true);
			//            Log.d("Search", "done");
			try {
				MessageApi().messageListAsync(
						mActivity.chat!!.id, null, null, null,
						query, null,
						null, this@MessageListFragment.messageId, null, null, null, null, null,
						object : ApiCallback<MessageListCreateView> {
							override fun onFailure(e: ApiException,
												   statusCode: Int,
												   responseHeaders: Map<String, List<String>>) {
								Log.d("Search", "Message Failure")
							}

							override fun onSuccess(result: MessageListCreateView,
												   statusCode: Int,
												   responseHeaders: Map<String, List<String>>) {
								Log.d("Search", "Message Success")
								//messageList = result.getResults().getMessages();
								//                        List<MessageUnreadSerializer> tempMessageList = new ArrayList<>();
								//                        Iterator<MessageUnreadSerializer> messageIterator = messageList
								// .iterator();
								//                        if (messageIterator.hasNext()) {
								//                            do {
								//                                MessageUnreadSerializer currMessage = messageIterator.next();
								//                                if (currMessage.getText().toLowerCase().contains(query
								// .toLowerCase())) {
								//                                    Log.d("Search", "Message: " + currMessage.getText());
								//                                    tempMessageList.add(currMessage);
								//                                }
								//                            } while (messageIterator.hasNext());
								//                        }
								//                        messageList = tempMessageList;
								mAdapter!!.updateList(result)

								Log.d("Search", "done")
							}

							override fun onUploadProgress(bytesWritten: Long,
														  contentLength: Long,
														  done: Boolean) {
							}

							override fun onDownloadProgress(bytesRead: Long,
															contentLength: Long,
															done: Boolean) {
							}
						}
				)
			} catch (e: ApiException) {
				e.printStackTrace()
			}

			return false
		}

		override fun onQueryTextChange(newText: String): Boolean {
			if (this@MessageListFragment.getmAdapter() != null) {
				if (TextUtils.isEmpty(newText)) {
					this@MessageListFragment.getmAdapter()!!.filter!!.filter("")
				} else {
					this@MessageListFragment.getmAdapter()!!.filter!!.filter(newText)
				}
			}
			return true

		}
	}

	class InfiniteScrollListener(private val layoutManager: LinearLayoutManager,
								 val adapter: MessageAdapter,
								 var contains: Int?,
								 var messageID: Int?) : RecyclerView.OnScrollListener() {

		private var previousTotal = 0
		private var loading = true
		private val visibleThreshold = 0
		private var firstVisibleItem = 0
		private var visibleItemCount = 0
		private var totalItemCount = layoutManager.itemCount

		override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
			super.onScrolled(recyclerView, dx, dy)

			totalItemCount = layoutManager.itemCount
			visibleItemCount = recyclerView.childCount
			firstVisibleItem = layoutManager.findFirstVisibleItemPosition()

			Log.d("Filtering", "Total Item Count: " + totalItemCount.toString())
			Log.d("Filtering", "Visible Item Count: " + visibleItemCount.toString())
			Log.d("Filtering", "firstVisible Item: " + firstVisibleItem.toString())

			if (loading) {
				if (totalItemCount > previousTotal) {
					Log.d("Filtering", "Loading is now False")
					loading = false
					previousTotal = totalItemCount
				}
			}

			if (!loading && (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold)) {
				Log.d("Filtering", "Loading is now True")
				loading = true
				val initialSize = adapter.messageList.results.messages.size
				doAsync{
					val result = MessageApi().messageList(contains, null,null, null, null,
									null, null, messageID, null,
									null, null, adapter.itemCount, null)

					if (!result.results.messages.isEmpty()) {

						adapter.messageList.results.messages.addAll(result.results.messages.reversed())

						val updatedSize = adapter.messageList.results.messages.size
						recyclerView.post { adapter.notifyItemRangeChanged(initialSize, updatedSize) }
					}
				}

			}
		}
	}

	inner class PreCachingLayoutManager : LinearLayoutManager {
		private var extraLayoutSpace = -1
		private var context: Context? = null
		private val DEFAULT_EXTRA_LAYOUT_SPACE = 600

		constructor(context: Context) : super(context) {
			this.context = context
		}

		constructor(context: Context, extraLayoutSpace: Int) : super(context) {
			this.context = context
			this.extraLayoutSpace = extraLayoutSpace
		}

		constructor(context: Context, orientation: Int, reverseLayout: Boolean) : super(context, orientation, reverseLayout) {
			this.context = context
		}

		fun setExtraLayoutSpace(extraLayoutSpace: Int) {
			this.extraLayoutSpace = extraLayoutSpace
		}

		override fun getExtraLayoutSpace(state: RecyclerView.State): Int {
			if (extraLayoutSpace > 0) {
				return extraLayoutSpace
			}
			return DEFAULT_EXTRA_LAYOUT_SPACE
		}
	}
}