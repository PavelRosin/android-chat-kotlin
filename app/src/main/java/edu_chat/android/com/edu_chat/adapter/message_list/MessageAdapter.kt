package edu_chat.android.com.edu_chat.adapter.message_list


import android.annotation.SuppressLint
import android.content.Intent
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView.Adapter
import android.support.v7.widget.RecyclerView.ViewHolder
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.*
import chat.edu.edu_chat.R.*
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import edu_chat.android.com.edu_chat.controller.message_list.MessageListActivity
import edu_chat.android.com.edu_chat.controller.userprofile.UserProfileActivity
import edu_chat.android.com.edu_chat.model.Constants
import edu_chat.android.com.edu_chat.model.CurrentUser
import edu_chat.android.com.edu_chat.view.CircleTransform
import io.socket.client.On
import io.swagger.client.ApiCallback
import io.swagger.client.ApiException
import io.swagger.client.api.UserApi
import io.swagger.client.model.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.logging.Handler


/**
 * Created by Kai on 10/26/2015.
 * Edu.Chat Inc.
 */
class MessageAdapter(private val activity: MessageListActivity,
					 var messageList: MessageListCreateView,
					 private val chat: ChatSerializer,
					 private val isComment: Boolean) : Adapter<ViewHolder>(), Filterable {
	private var orig: MessageListCreateView? = null
	var activated = false

	fun addItem(msg: MessageSerializer) {
		this.messageList.results.messages.add(0, msg)
		Log.d("Adding", "" + msg.text + msg.id + " " + messageList.results.messages.size)
		notifyItemInserted(0)
	}

	fun getitematposition(pos: Int): MessageSerializer? {
		return if (pos <= this.messageList.results.messages.size - 1)
			if (this.messageList.results.messages[pos] != null && this
					.messageList.results.messages[pos] is MessageSerializer)
				this.messageList.results.messages[pos]
			else
				null
		else
			null
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//		val RightSwipe = AnimationUtils.loadAnimation(this@MessageAdapter.activity, R.anim.notification_swipe_right_anim )
//		val layoutInflater = LayoutInflater.from(this.activity)

		when (viewType) {
			Constants.MESSAGE_DATE -> {
				return MessageHolder(LayoutInflater.from(parent.context)
						.inflate(layout.chat_message_date, parent, false))
			}
			Constants.MESSAGE_TEXT_SENT -> {
				if(!isComment)
					return MessageHolder(LayoutInflater.from(parent.context)
							.inflate(layout.item_message_right, parent, false))
				else
					return MessageHolder(LayoutInflater.from(parent.context)
							.inflate(layout.item_message_left, parent, false))
			}

			Constants.MESSAGE_TRIAL -> {
				return MessageHolder(LayoutInflater.from(parent.context)
						.inflate(layout.item_message_right_trial, parent, false))
			}

			Constants.MESSAGE_TEXT_RECEIVED -> {
				return MessageHolder(LayoutInflater.from(parent.context)
						.inflate(layout.item_message_left, parent, false))
			}
			Constants.MESSAGE_HYPER_SENT -> {
				return MessageHolder(LayoutInflater.from(parent.context)
						.inflate(layout.item_file_and_text_right, parent, false))
			}
			Constants.MESSAGE_HYPER_RECEIVED -> {
				return MessageHolder(LayoutInflater.from(parent.context)
						.inflate(layout.item_file_and_text_left, parent, false))
			}
			else -> {
				return MessageHolder(LayoutInflater.from(parent.context)
						.inflate(layout.item_message_right, parent, false))
			}
		}
	}


	override fun onBindViewHolder(holder: ViewHolder, position: Int) {

		Log.d("MessageList", "" + messageList.results.messages.size)
		if (this.messageList.results.messages[position] is MessageSerializer) {
			val msg = this.messageList.results.messages[position]
			val messageHolder = holder as MessageHolder

			//If user already has a message in the chat, then no need to do an API call
			if (msg.user == CurrentUser.currentUser!!.id){
				showMessage(
						CurrentUser.currentUser!!, holder,
						messageHolder, msg, chat, position
				)
			}
			else if (messageList.results.users[msg.user.toString()] != null) {
				showMessage(
						messageList.results.users[msg.user.toString()]!!, holder,
						messageHolder, msg, chat, position
				)
			} else {
				UserApi().userListAsync(msg.user, null, null, null, null, null, null, null,
						null, null, object: ApiCallback<UserListView>{
					override fun onFailure(e: ApiException?, statusCode: Int, responseHeaders: MutableMap<String, MutableList<String>>?) {
					}

					override fun onSuccess(result: UserListView?, statusCode: Int, responseHeaders: MutableMap<String, MutableList<String>>?) {

						if (activity!=null){
							activity.runOnUiThread{
								showMessage(
										result!!.results[0], holder,
										messageHolder, msg, chat, position
								)
							}
						}

					}

					override fun onUploadProgress(bytesWritten: Long, contentLength: Long, done: Boolean) {
					}

					override fun onDownloadProgress(bytesRead: Long, contentLength: Long, done: Boolean) {
					}

				})
			}

			Log.d("mnbvc", "position: " + position + "message: " + msg.id)

		}
	}

	private fun showMessage(user: UserSerializer, holder: ViewHolder,
							messageHolder: MessageHolder, msg: MessageSerializer,
							chat: ChatSerializer, position: Int) {
		var dX1: Float = 0.toFloat()
		var dX2: Float = 0.toFloat()

		messageHolder.setMessage(msg)
		messageHolder.setUserID(user.id!!)
		messageHolder.setUser(user)
		messageHolder.setChat(chat)
		if (position == 0 && isComment) {
//			messageHolder.showCommentLine()
		}

		if (msg.text != null) messageHolder.setMessage(msg.text)

		messageHolder.parentcontainer!!.setOnTouchListener(object: View.OnTouchListener {

			override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
				when (p1!!.action) {

					MotionEvent.ACTION_DOWN -> {
						val timer = Timer()
						dX1 = p1.x

//						if (!isComment) {
//							if (!activated) {
//								activated = true
//								if (msg.commentCount == 0) {
//									messageHolder.makeCommentInvisible()
//								} else {
//									messageHolder.setCommentCount(msg.commentCount!!)
//								}
//								messageHolder.commentButtonClick()
//							} else {
//								messageHolder.disableComment()
//								activated = false
//							}


//						}
					}
					MotionEvent.ACTION_UP -> {
						if (!isComment) {
//							activated = false
//							messageHolder.makeCommentInvisible()
						}
						dX2 = p1.x
						var dX3: Float = dX2 - dX1
						if (Math.abs(dX3) > 150)
						{
							// Left to Right swipe action
							if (dX2 > dX1)
							{
								Log.d("boop", "swiped left to right")
								messageHolder.commentTransition()
							}

							// Right to left swipe action
							else
							{
								Log.d("boop", "swiped right to left")

							}

						}
						else
						{
							// consider as something else - a screen tap for example
						}

					}

					MotionEvent.ACTION_MOVE -> {

//						if (p1.rawX > Math.abs(dX) &&
//								Math.abs(p1.rawX - Math.abs(dX)) < 165.0f &&
//								Math.abs(p1.rawX - Math.abs(dX)) > 100.0f) {
//							Log.d("Boop", "comments+ " + messageHolder.itemId)
//							messageHolder.commentTransition()
//						}
					}

				}
				return true
			}

		}
		)

		//parse the time and return the time as a String.
		val string = msg.created
		try {
			var newTime = string.replace("T".toRegex(), " ")
			newTime = newTime.substring(0, newTime.length - 1)
			val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")

			val date = format.parse(newTime)
			val format2 = SimpleDateFormat("h:mm a")
			(holder as MessageHolder).setMessageDateView(format2.format(date))
		} catch (e: ParseException) {
			e.printStackTrace()
		}

		messageHolder.setUserPicture(user.pictureFile.url)
		messageHolder.setUsername(user.firstName)
	}

	override fun getItemViewType(position: Int): Int {
		if (this.messageList.results.messages[position] is MessageSerializer) {
			//final ECMessage message = (ECMessage) this.mMessages.get(position);
			val msg = this.messageList.results.messages[position]
			Log.d("type", msg.type)
			if (msg.user == CurrentUser.currentUser!!.id) {
				// the current user side
				when (msg.type) {
					"t" -> return Constants.MESSAGE_TEXT_SENT
					else -> return 1
				}

			} else {
				when (msg.type) {
					"t" -> return Constants.MESSAGE_TEXT_RECEIVED
					else -> return 2
				}

			}
		} else {
			return 1
		}
	}

	override fun getItemCount(): Int {
		return this.messageList.results.messages.size
	}

	fun updateList(messageList: MessageListCreateView) {

		this.messageList = messageList
		notifyDataSetChanged()

	}

	override fun getFilter(): Filter? {
		return object : Filter() {
			override fun performFiltering(constraint: CharSequence?): Filter.FilterResults {
				val oReturn = Filter.FilterResults()
				val results = ArrayList<Any>()
				if (this@MessageAdapter.orig == null)
					this@MessageAdapter.orig = this@MessageAdapter.messageList
				if (constraint != null) {
					if (this@MessageAdapter.orig != null && !this@MessageAdapter.orig!!.results.messages.isEmpty()) {
						for (g in this@MessageAdapter.orig!!.results.messages) {

						}
					}

					oReturn.values = results
				}
				return oReturn
			}

			override fun publishResults(constraint: CharSequence, results: Filter.FilterResults) {

				this@MessageAdapter.notifyDataSetChanged()

			}
		}
	}

	/*private static class
    DateHolder extends ViewHolder {

        @NonNull private final TextView mDateTextView;

        DateHolder(@NonNull final View itemView) {
            super(itemView);
            this.mDateTextView = (TextView) itemView.findViewById(id.message_date_textview);
        }

        public void setDate(final Date messageDate) {
            final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE, MMMM dd");
            final String dayOfWeek = simpleDateFormat.format(messageDate);
            this.mDateTextView.setText(dayOfWeek);
        }
    }*/


	private inner class MessageHolder internal constructor(itemView: View) : ViewHolder(itemView) {

		private val mUserNameView: TextView? = itemView.findViewById<TextView>(id.username)
		private val mMessageView: TextView? = itemView.findViewById<TextView>(id.message)
		private val mMessageDateView: TextView? = itemView.findViewById<TextView>(id.messageDate)
		private val userProfilePicture: ImageView? = itemView.findViewById<ImageView>(id.userProfilePicture)
		private val mFileNameView: TextView? = itemView.findViewById<TextView>(id.filename)
		private val mFileSizeView: TextView? = itemView.findViewById<TextView>(id.size)
		private val mCommentButton: ImageButton? = itemView.findViewById<ImageButton>(id.comment_button)
		private val mCommentButton2: TextView? = itemView.findViewById<TextView>(id.comment_view)
		private val container: LinearLayout? =itemView.findViewById(id.container_layout)
		val parentcontainer: LinearLayout? = itemView.findViewById(id.parent_layout)
		private val mresendMessage: ImageView? = itemView.findViewById<ImageView>(id.retry)

		private val mLineView: View?
		private val fileIcon: ImageView?
		private var message: MessageSerializer? = null
		private var userIDHolder = -1
		private var chat: ChatSerializer? = null
		private var user: UserSerializer? = null


		init {
			this.mresendMessage?.setOnClickListener {
				Toast.makeText(
						this@MessageAdapter.activity.baseContext,
						"Coming soon!!",
						Toast.LENGTH_SHORT
				).show()
			}
			//this.downArrow = itemView.findViewWithTag(drawable.ic_arrow_drop_down_black_24dp);


			/*            this.mCommentButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(final View v) {
                    Toast.makeText(
                            MessageAdapter.this.activity.getBaseContext(),
                            "clicked on show comment " +
                                    "Message Title",
                            Toast.LENGTH_SHORT
                    ).show();
                    final Intent intent = new Intent(MessageAdapter.this.activity.getBaseContext
                            (), MessageListActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("MSG_PARCEL", MessageHolder.this.ecMessage);
                    intent.putExtra("CHAT_PARCEL", MessageAdapter.this.ecChat);
                    intent.putExtra("ActivityName", "MessageAdapter");
                    MessageAdapter.this.activity.getBaseContext().startActivity(intent);
                }
            });*/
			this.fileIcon = itemView.findViewById<ImageView>(id.file_icon)
			this.mLineView = itemView.findViewById<View>(id.lineView)
			//            if (this.fileIcon != null) {
			//                this.fileIcon.setOnClickListener(new OnClickListener() {
			//                    @Override
			//                    public void onClick(final View v) {
			//                        final Intent intent = new Intent(
			//                                MessageAdapter.this.activity,
			//                                FileViewActivity.class
			//                        );
			//                        MessageAdapter.this.activity.startActivity(intent);
			//                    }
			//                });
			//            }

			userProfilePicture?.setOnClickListener {
				val intent = Intent(it.context, UserProfileActivity::class.java)
				if (userIDHolder != -1) {
					intent.putExtra("user_id", userIDHolder)
					Log.d("ChatUser", "ID: " + userIDHolder)
				} else {
					intent.putExtra("user_id", CurrentUser.currentUser!!.id)
				}
				it.context.startActivity(intent)
			}

		}

		internal fun setUserID(userID: Int) {
			userIDHolder = userID
		}

		internal fun setUser(userVar: UserSerializer){
			user = userVar
		}
		internal fun showCommentLine() {
			this.mLineView!!.visibility = View.VISIBLE
		}

//		internal fun showResendButton() {
//			if (this.mresendMessage != null && this.mresendMessage.visibility == View.GONE) {
//				this.mresendMessage.visibility = View.VISIBLE
//			}
//		}
//
//		internal fun hideResendButton() {
//			if (this.mresendMessage != null && this.mresendMessage.visibility == View
//					.VISIBLE) {
//				this.mresendMessage.visibility = View.GONE
//			} else {
//			}
//		}

		fun setMessageDateView(messageDate: String) {

			this.mMessageDateView!!.text = messageDate
		}

		internal fun setUserPicture(fileURL: String) {
			Picasso.with(this@MessageAdapter.activity)
					.load(fileURL)
					.error(drawable.educhat)
					.resize(
							Constants.GLOBAL_IMAGE_SIZE,
							Constants.GLOBAL_IMAGE_SIZE
					)
					.centerInside()
					.transform(CircleTransform(null))
					.skipMemoryCache()
					.into(this.userProfilePicture)
		}

		fun setUsername(username: String) {
			this.mUserNameView!!.text = username
		}

		fun setMessage(message: String) {
			this.mMessageView!!.text = message
		}

		internal fun makeCommentInvisible() {

			this.mCommentButton!!.visibility = View.VISIBLE
			this.mCommentButton2!!.visibility = View.GONE
		}
		internal fun disableComment(){
			this.mCommentButton!!.visibility = View.GONE
			this.mCommentButton2!!.visibility = View.GONE
		}

		internal fun setCommentCount(commentCount: Int) {
			this.mCommentButton2!!.visibility = View.VISIBLE
			if (commentCount == 1)
				this.mCommentButton2.text = "1 comment"
			else
				this.mCommentButton2.text = commentCount.toString() + " comments"

		}

		internal fun setMessage(message: MessageSerializer) {
			this.message = message
		}
		internal fun commentTransition(){
			val intent = Intent(this@MessageAdapter.activity.baseContext, MessageListActivity::class.java)
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
			intent.putExtra("CurrentChat", Gson().toJson(chat))

			intent.putExtra("ActivityName", "MessageAdapter")
			Log.d("testcomment", this@MessageHolder.message!!.id!!.toString())

			intent.putExtra("messageID", this@MessageHolder.message!!.id)
			intent.putExtra("message",Gson().toJson(this@MessageHolder.message))
			intent.putExtra("messageUser", Gson().toJson(this@MessageHolder.user))
			this@MessageAdapter.activity.baseContext.startActivity(intent)
		}
		internal fun commentButtonClick() {

			this.parentcontainer!!.setOnClickListener {
				Log.d("TestComment", this@MessageHolder.message!!.toString())

				val intent = Intent(this@MessageAdapter.activity.baseContext, MessageListActivity::class.java)
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
				intent.putExtra("CurrentChat", Gson().toJson(chat))

				intent.putExtra("ActivityName", "MessageAdapter")
				Log.d("testcomment", this@MessageHolder.message!!.id!!.toString())

				intent.putExtra("messageID", this@MessageHolder.message!!.id)
				intent.putExtra("message",Gson().toJson(this@MessageHolder.message))
				intent.putExtra("messageUser", Gson().toJson(this@MessageHolder.user))
				this@MessageAdapter.activity.baseContext.startActivity(intent)

			}
			this.parentcontainer!!.setOnClickListener {
				Log.d("TestComment", this@MessageHolder.message!!.toString())

				val intent = Intent(this@MessageAdapter.activity.baseContext, MessageListActivity::class.java)
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
				//                    Log.d("testcomment", chat.toString());
				intent.putExtra("CurrentChat", Gson().toJson(chat))

				intent.putExtra("ActivityName", "MessageAdapter")
				Log.d("testcomment", this@MessageHolder.message!!.id!!.toString())
				intent.putExtra("messageID", this@MessageHolder.message!!.id)
				intent.putExtra("message",Gson().toJson(this@MessageHolder.message))
				intent.putExtra("messageUser", Gson().toJson(this@MessageHolder.user))

				this@MessageAdapter.activity.baseContext.startActivity(intent)
			}
		}


		fun setChat(chat: ChatSerializer) {
			this.chat = chat
		}
	}
}
