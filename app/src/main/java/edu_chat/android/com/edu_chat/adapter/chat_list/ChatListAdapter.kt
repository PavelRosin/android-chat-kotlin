package edu_chat.android.com.edu_chat.adapter.chat_list

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.support.v7.widget.RecyclerView.ViewHolder
import android.text.format.Time
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.Transformation
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import chat.edu.edu_chat.R.*
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import edu_chat.android.com.edu_chat.adapter.chat_info.SubchatListAdapter
import edu_chat.android.com.edu_chat.controller.chat_list.ChatListFragment
import edu_chat.android.com.edu_chat.controller.message_list.MessageListActivity
import edu_chat.android.com.edu_chat.model.Constants
import edu_chat.android.com.edu_chat.view.CircleTransform
import io.swagger.client.ApiCallback
import io.swagger.client.ApiException
import io.swagger.client.api.ChatApi
import io.swagger.client.model.ChatListCreateView
import io.swagger.client.model.ChatSerializer
import io.swagger.client.model.UserSerializer
import java.security.Key
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

@Suppress("UNNECESSARY_SAFE_CALL")
/**
 * Created by Kai on 10/28/2015.
 * Edu.Chat Inc.
 */

class ChatListAdapter(private val activity: ChatListFragment,
					  val ChatList: ArrayList<ChatSerializer>,
					  var UserList: Map<String, UserSerializer>) : Adapter<ViewHolder>() {

	private val FLAG: Int = 0
	private var subChatList: ArrayList<ChatSerializer> ?= null
	private var subChats = HashMap<Int, ArrayList<ChatSerializer>>()
	private var gridViewHeight: Int = 0


	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		if (viewType == EMPTY_VIEW) return SubchatListAdapter.EmptyViewHolder(
				LayoutInflater.from(parent.context).inflate(
						if (this.FLAG == 1)
							layout.search_empty_group_layout
						else
							layout.empty_group_view,
						parent, false
				)
		) else return CategoryViewHolder(
				LayoutInflater.from(parent.context).inflate(
						layout.main_list_scroll_item,
						parent, false
				)
		)
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		when (holder.itemViewType) {
			EMPTY_VIEW -> {
			}
			else -> {
				val categoryViewHolder = holder as CategoryViewHolder
				val currChat = this.ChatList[position]
//				var unreadCount: Int? = 0
				categoryViewHolder.setRowHeader(currChat.name)
				categoryViewHolder.setChatObject(currChat)

				if (currChat.mostRecentMessage != null) {
					categoryViewHolder.setLastActivityTextView(
							currChat.mostRecentMessage.created,
							currChat.color.hexcode("#7c7c7c").hexcode)
					if (currChat.memberCount > 2) {
						categoryViewHolder.setMessageText(
								UserList[currChat.mostRecentMessage.user.toString()]?.firstName + ": " + currChat.mostRecentMessage.text
						)
					} else {
						categoryViewHolder.setMessageText(currChat.mostRecentMessage.text)
					}

				} else
					categoryViewHolder.setMessageText("No message yet.")
				Log.d("current chat is", currChat.name!! + currChat.unreadCount.toString())
				categoryViewHolder.setUnreadDot(
						currChat.unreadCount!!,
						"#FE8E38"
				)
//				if (currChat.unreadCount == 0){
				categoryViewHolder.setUserPicture(
						currChat.pictureFile.url,
						"#FFFFFF"
				)
//				} else{
//					categoryViewHolder.setUserPicture(
//							currChat.pictureFile.url,
//							"#FE8E38"
//					)
//				}

				if (!currChat.hasChildren && !currChat.isClass)
					categoryViewHolder.downArrow.visibility = View.INVISIBLE
				else categoryViewHolder.downArrow.visibility = View.VISIBLE
				categoryViewHolder.gridViewFrame?.visibility = View.GONE
//				categoryViewHolder.horizontalRecyclerView?.visibility = View.GONE
				categoryViewHolder.horizontalRecyclerView?.hasFixedSize()
				categoryViewHolder.horizontalRecyclerView?.layoutManager = LinearLayoutManager(
						activity.context,
						LinearLayoutManager.HORIZONTAL,
						false
				)
				categoryViewHolder.horizontalRecyclerView?.isNestedScrollingEnabled = false

				if (!subChats.containsKey(currChat.id))
					try {
						ChatApi().chatListAsync(
								null, null, null, null, null,
								null,null, currChat.id, null, null,
								object : ApiCallback<ChatListCreateView>{
									override fun onSuccess(result: ChatListCreateView?, statusCode: Int, responseHeaders: MutableMap<String, MutableList<String>>?) {
										categoryViewHolder.subChats = result!!.results.chats as ArrayList<ChatSerializer>
										subChatList = categoryViewHolder.subChats
										if (currChat.isClass) categoryViewHolder.subChats!!.add(0, currChat)
										subChats.put(currChat.id, categoryViewHolder.subChats!!)
										setGridView(categoryViewHolder, currChat)
									}

									override fun onFailure(e: ApiException?, statusCode: Int, responseHeaders: MutableMap<String, MutableList<String>>?) = Unit

									override fun onUploadProgress(bytesWritten: Long, contentLength: Long, done: Boolean) = Unit

									override fun onDownloadProgress(bytesRead: Long, contentLength: Long, done: Boolean) = Unit
								})
					} catch (e: ApiException) {
						e.printStackTrace()
					}

				categoryViewHolder.downArrow.setOnClickListener {
					activity.activity.runOnUiThread {
						setDownArrow(categoryViewHolder, currChat)
					}
				}
			}
		}
	}

	private fun setDownArrow(categoryViewHolder: CategoryViewHolder, currChat:ChatSerializer){
		activity.activity.runOnUiThread {
			if (categoryViewHolder.downArrow.rotation == 0f) {
				categoryViewHolder.downArrow.animate().rotation(
						if (categoryViewHolder.downArrow.rotation == 180f) 0f else 180f
				).interpolator = AccelerateDecelerateInterpolator()
				categoryViewHolder.gridViewFrame?.visibility = View.VISIBLE
//				if (!isClickedOnce) {
//					categoryViewHolder.gridViewFrame?.visibility = View.VISIBLE
//					isClickedOnce = true
//				} else {
//					categoryViewHolder.gridViewFrame?.layoutParams?.height = gridViewHeight
//					categoryViewHolder.gridViewFrame?.visibility = View.VISIBLE
//					setGridView(categoryViewHolder, currChat)
//					expand(categoryViewHolder.gridViewFrame)
//				}

			} else if (categoryViewHolder.downArrow.rotation == 180f) {
				categoryViewHolder.downArrow.animate().rotation(
						if (categoryViewHolder.downArrow.rotation == 0f) 180f else 0f
				).interpolator = AccelerateDecelerateInterpolator()
				categoryViewHolder.gridViewFrame?.visibility = View.GONE
//				collapse(categoryViewHolder.gridViewFrame)
			}
		}
	}

	private fun expand(v: LinearLayout?) {
//		v!!.measure(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT)
		val targetHeight = gridViewHeight
		v!!.visibility = View.VISIBLE
		val animation = object : Animation() {
			override
			fun applyTransformation(interpolatedTime: Float, t: Transformation) {
				if (interpolatedTime == 1.toFloat())
					v.layoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT
				else{
					v.layoutParams.height = (targetHeight * interpolatedTime).toInt()
				}
				v.requestLayout()
			}
			override
			fun willChangeBounds(): Boolean {
				return true
			}
		}

		animation.duration = (targetHeight / v.context.resources.displayMetrics.density).toLong()
		v.startAnimation(animation)
	}
	private fun collapse(v: LinearLayout?) {
		v!!.measure(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
		gridViewHeight = v.measuredHeight
		val initialHeight = v.measuredHeight

		val animation = object : Animation() {
			override
			fun applyTransformation(interpolatedTime: Float, t: Transformation) {
				if (interpolatedTime == 1.toFloat())
					v.visibility = View.GONE
				else{
					v.layoutParams.height = (initialHeight - initialHeight * interpolatedTime).toInt()
					v.requestLayout()
				}
			}
			override
			fun willChangeBounds(): Boolean {
				return true
			}
		}

		animation.duration = (initialHeight / v.context.resources.displayMetrics.density).toLong()
		v.startAnimation(animation)
	}

	private fun setGridView(categoryViewHolder: CategoryViewHolder, currChat: ChatSerializer) {
		activity.activity.runOnUiThread {
			categoryViewHolder.horizontalRecyclerView?.adapter = HorizontalScrollAdapter(
					currChat, activity.activity, UserList, categoryViewHolder.subChats
			)
		}
	}

	override fun getItemViewType(position: Int): Int =
			if (this.ChatList.isEmpty()) EMPTY_VIEW else super.getItemViewType(position)

	override fun getItemCount(): Int = if (this.ChatList.isEmpty()) 1 else this.ChatList.size

	inner class CategoryViewHolder(view: View) : ViewHolder(view), OnClickListener {

		private val userPicture: ImageView
		private val messageTextView: TextView
		private val headerTextView: TextView
		private val lastActivityTextView: TextView
		private val unreadDot: TextView
		val gridViewFrame: LinearLayout
		val downArrow: Button
		private var chat: ChatSerializer? = null
		var horizontalRecyclerView: RecyclerView? = null
		var subChats: ArrayList<ChatSerializer>? = null

		init {
			//set the onclick listener in the constructor.
			view.setOnClickListener(this)
			this.userPicture = view.findViewById(id.profilePicture)
			this.messageTextView = view.findViewById(id.messageTextView)
			this.headerTextView = view.findViewById(id.rowHeader)
			this.lastActivityTextView = view.findViewById(id.lastActivityTextView)
			this.unreadDot = view.findViewById(id.unreadDot)
			this.horizontalRecyclerView = view.findViewById(id.gridView)
			this.downArrow = view.findViewById(id.downArrowButton)
			this.gridViewFrame = view.findViewById(id.gridView_frame)
		}

		fun setMessageText(messageTest: String) {
			this.messageTextView.text = messageTest
		}

		fun setRowHeader(rowHeader: String) {
			this.headerTextView.text = rowHeader
		}

		fun setLastActivityTextView(time: String, color: String) {
			this.lastActivityTextView.setTextColor(Color.parseColor(color))
			val timeLastDay = Date(System.currentTimeMillis() - (1000 * 60 * 60 * 24))
			val timeLastYear = Date(System.currentTimeMillis() - (1000.toLong() * 60 * 60 * 24 * 365))

			try {
				val newTime = time.replace("T".toRegex(), " ")
				val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
				val format2 = SimpleDateFormat("h:mm a")
				val format3 = SimpleDateFormat("MM-dd")
				val format4 = SimpleDateFormat("yyyy-MM-dd")

				val strDate = format.parse(newTime)

				if (timeLastYear.after(strDate)){
					this.lastActivityTextView.text = format4.format(format.parse(newTime.substring(0, newTime.length - 1)))
				}else if (timeLastDay.after(strDate)) {
					this.lastActivityTextView.text = format3.format(format.parse(newTime.substring(0, newTime.length - 1)))
				}else{
					this.lastActivityTextView.text = format2.format(format.parse(
							newTime.substring(0, newTime.length - 1)
					))
				}
//				this.lastActivityTextView.text = format2.format(format.parse(
//						newTime.substring(0, newTime.length - 1)
//				))
			} catch (e: ParseException) {
				e.printStackTrace()
			}

		}

		fun setUserPicture(fileURL: String, colorString: String) =
				Picasso.with(this@ChatListAdapter.activity.activity)
						.load(fileURL)
						.error(drawable.educhat)
						.resize(
								Constants.GLOBAL_IMAGE_SIZE,
								Constants.GLOBAL_IMAGE_SIZE
						)
						.centerInside()
						.transform(CircleTransform(colorString))
						.skipMemoryCache()
						.into(this.userPicture)

		fun setUnreadDot(unreadNum: Int, color: String) {
			if (unreadNum == 0) {
				this.unreadDot.visibility = View.GONE
			} else {
				setBold()
				if (unreadNum > 1000) {
					this.unreadDot.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 7.0f)
				} else {
					Log.d("unread number is:", unreadDot.text.toString())
					this.unreadDot.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 10.0f)
				}
				this.unreadDot.text = String.format("%d", unreadNum)
				this.unreadDot.visibility = View.VISIBLE
			}
			// Set dot color
			val bgDrawable = this.unreadDot.background as LayerDrawable
			val shape = bgDrawable.findDrawableByLayerId(id
					.unreadShape) as GradientDrawable
			shape.setColor(Color.parseColor(color))
		}

		fun setChatObject(chat: ChatSerializer) {
			this.chat = chat
		}

		private fun setBold() {
			this.messageTextView.typeface = Typeface.DEFAULT_BOLD
			this.headerTextView.typeface = Typeface.DEFAULT_BOLD
			this.lastActivityTextView.typeface = Typeface.DEFAULT_BOLD
		}


		override fun onClick(v: View) {
			val intent = Intent(this@ChatListAdapter.activity.context, MessageListActivity::class.java)
			if (activity.isChat) {
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
				intent.putExtra("CurrentChat", Gson().toJson(this.chat))
				intent.putExtra("CurrentChat", this.chat)
				intent.putExtra("ParentChat", Gson().toJson(this.chat))
				intent.putExtra("UserList", Gson().toJson(UserList))
				intent.putExtra("isClass", !activity.isChat)
//				intent.putExtra("messageList", Gson().toJson(messageList))
				intent.putExtra("SubChatsList", Gson().toJson(subChatList))
				intent.putExtra("subChatsList", Gson().toJson(this.subChats))
				this@ChatListAdapter.activity.context.startActivity(intent)
			} else {
				downArrow.callOnClick()
			}
		}
	}

	companion object {

		private val EMPTY_VIEW = 10
	}
}
