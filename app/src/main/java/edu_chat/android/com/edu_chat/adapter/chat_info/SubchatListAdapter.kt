package edu_chat.android.com.edu_chat.adapter.chat_info

/**
* Created by Robert Lei on 7/6/2017.
* Edu.Chat Inc.
*/

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.support.v7.widget.RecyclerView.Adapter
import android.support.v7.widget.RecyclerView.ViewHolder
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import chat.edu.edu_chat.R.*
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import edu_chat.android.com.edu_chat.controller.message_list.MessageListActivity
import edu_chat.android.com.edu_chat.controller.chat_info.MembersFragment
import edu_chat.android.com.edu_chat.model.Constants
import edu_chat.android.com.edu_chat.view.CircleTransform
import io.swagger.client.model.ChatSerializer
import io.swagger.client.model.UserSerializer
import java.text.ParseException
import java.text.SimpleDateFormat

class SubchatListAdapter(private val fragment: MembersFragment,
						 var ChatList: List<ChatSerializer>,
						 private var UserList: Map<String, UserSerializer>) : Adapter<ViewHolder>() {

    private val FLAG: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (viewType == EMPTY_VIEW) {
            return EmptyViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                            if (this.FLAG == 1)
                                layout.search_empty_group_layout
                            else
                                layout.empty_group_view,
                            parent, false
                    )
            )
        } else {
            return CategoryViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                            layout.main_list_scroll_item,
                            parent, false
                    )
            )
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder.itemViewType) {
            EMPTY_VIEW -> {
            }
            else -> {
                val categoryViewHolder = holder as CategoryViewHolder
                val currChat = this.ChatList[position]
                categoryViewHolder.setChatObject(currChat)
                categoryViewHolder.setRowHeader(currChat.name)
                if (currChat.mostRecentMessage != null) {
                    categoryViewHolder.setLastActivityTextView(
                            currChat.mostRecentMessage.created,
                            currChat.color.hexcode
                    )

                    categoryViewHolder.setMessageText(
                            UserList[currChat.mostRecentMessage.user.toString()]!!.firstName + ": " + currChat.mostRecentMessage.text
                    )
                } else
                    categoryViewHolder.setMessageText("No message yet.")
                categoryViewHolder.setUnreadDot(
                        currChat.unreadCount!!,
                        "#FE8E38"
                )
                categoryViewHolder.setUserPicture(
                        currChat.pictureFile.url,
                        "#FE8E38"
                )

            }
        }// EmptyViewHolder emptyViewHolder = (EmptyViewHolder) viewHolderCase;
    }

    override fun getItemViewType(position: Int): Int {
        if (this.ChatList.isEmpty()) {
            return EMPTY_VIEW
        }
        return super.getItemViewType(position)
    }

    override fun getItemCount(): Int {
        return if (this.ChatList.isEmpty()) 1 else this.ChatList.size
    }

    //TODO: Swaggerfy the code
    //    public Filter getFilter() {
    //        this.FLAG = 1;
    //        return new Filter() {
    //            @NonNull
    //            @Override
    //            protected FilterResults performFiltering(@Nullable final CharSequence constraint) {
    //                final FilterResults oReturn = new FilterResults();
    //                final List<ECChat> results = new ArrayList<>();
    //                if (ChatListAdapter.this.orig == null)
    //                    ChatListAdapter.this.orig = ChatListAdapter.this.mECChats;
    //                if (constraint != null) {
    //                    if (ChatListAdapter.this.orig != null && !ChatListAdapter.this
    //                            .orig.isEmpty()) {
    //                        for (final ECChat g : ChatListAdapter.this.orig) {
    //                            if (g.getName().toLowerCase().contains(constraint.toString()
    //                                                                           .toLowerCase()))
    //                                results.add(g);
    //                        }
    //                    }
    //                    oReturn.values = results;
    //                }
    //                return oReturn;
    //            }
    //
    //            @SuppressWarnings("unchecked")
    //            @Override
    //            protected void publishResults(final CharSequence constraint,
    //                                          final FilterResults results) {
    //                ChatListAdapter.this.mECChats = (ArrayList) results.values;
    //                ChatListAdapter.this.notifyDataSetChanged();
    //            }
    //
    //        };
    //    }

    class EmptyViewHolder(view: View) : ViewHolder(view)

    inner class CategoryViewHolder(view: View) : ViewHolder(view), OnClickListener {

        private val userPicture: ImageView
        private val messageTextView: TextView
        private val headerTextView: TextView
        private val lastActivityTextView: TextView
        private val unreadDot: TextView

        private var chat: ChatSerializer? = null

        init {
            view.setOnClickListener(this)

            this.userPicture = view.findViewById(id.profilePicture)
            this.messageTextView = view.findViewById(id.messageTextView)
            this.headerTextView = view.findViewById(id.rowHeader)
            this.lastActivityTextView = view.findViewById(id.lastActivityTextView)
            this.unreadDot = view.findViewById(id.unreadDot)
        }

        fun setMessageText(messageTest: String) {
            this.messageTextView.text = messageTest
        }

        fun setRowHeader(rowHeader: String) {
            this.headerTextView.text = rowHeader
        }

        fun setLastActivityTextView(time: String, color: String) {
            this.lastActivityTextView.setTextColor(Color.parseColor(color))

            try {
                var newTime = time.replace("T".toRegex(), " ")
                newTime = newTime.substring(0, newTime.length - 1)
                val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
                val format2 = SimpleDateFormat("h:mm a")
                this.lastActivityTextView.text = format2.format(format.parse(newTime))
            } catch (e: ParseException) {
                e.printStackTrace()
            }

        }

        fun setUserPicture(fileURL: String, colorString: String) {
            Picasso.with(this@SubchatListAdapter.fragment.activity)
                    .load(fileURL)
                    .error(drawable.educhat)
                    .resize(
                            Constants.GLOBAL_IMAGE_SIZE,
                            Constants.GLOBAL_IMAGE_SIZE
                    )
                    .centerInside()
                    .transform(CircleTransform(colorString))
                    .into(this.userPicture)
        }

        fun setUnreadDot(unreadNum: Int, color: String) {
            if (unreadNum == 0) {
                this.unreadDot.visibility = View.GONE
            } else {
                if (unreadNum > 1000) {
                    this.unreadDot.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 7.0f)
                } else {
                    this.unreadDot.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 10.0f)
                }
                this.unreadDot.text = String.format("%d", unreadNum)
            }
            // Set dot color
            val bgDrawable = this.unreadDot.background as LayerDrawable
            val shape = bgDrawable.findDrawableByLayerId(id
                    .unreadShape) as GradientDrawable
            shape.setColor(Color.parseColor(color))
        }


        //		public void setUserText(String username) {
        //			userText.setText(username);
        //		}

        fun setChatObject(chat: ChatSerializer) {
            this.chat = chat
        }


        override fun onClick(v: View) {

            val intent = Intent(this@SubchatListAdapter.fragment.context, MessageListActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            //intent.putExtra("CHAT_PARCEL", this.ecObject)
            intent.putExtra("CurrentChat", Gson().toJson(this.chat))
            intent.putExtra("UserList", Gson().toJson(UserList))
            intent.putExtra("ParentChat", Gson().toJson(fragment.chat))
            fragment.activity.finish()
            this@SubchatListAdapter.fragment.context.startActivity(intent)
        }


    }

    companion object {

        private val EMPTY_VIEW = 10
    }
}