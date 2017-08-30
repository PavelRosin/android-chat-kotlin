package edu_chat.android.com.edu_chat.adapter.chat_list

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import chat.edu.edu_chat.R
import com.google.android.gms.internal.al
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import edu_chat.android.com.edu_chat.controller.chat_list.SearchViewFragment
import edu_chat.android.com.edu_chat.controller.message_list.MessageListActivity
import edu_chat.android.com.edu_chat.model.Constants
import edu_chat.android.com.edu_chat.model.CurrentUser
import edu_chat.android.com.edu_chat.view.CircleTransform
import io.swagger.client.ApiCallback
import io.swagger.client.ApiException
import io.swagger.client.api.Chat_userApi
import io.swagger.client.model.ChatSerializer
import io.swagger.client.model.ChatUserListCreateView
import io.swagger.client.model.ChatUserPostSerializer
import io.swagger.client.model.UserSerializer

/**
* Created by mingdimao on 7/21/17.
* Edu.Chat Inc.
*/

class SearchViewAdapter(private val mfragment:SearchViewFragment, private var tag: Int): RecyclerView.Adapter<SearchViewAdapter.ViewHolder>() {
    var chatList: MutableList<ChatSerializer> = ArrayList()
    var joinList: MutableList<ChatSerializer> = ArrayList()
    var userList: MutableList<UserSerializer> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_search_view_main, parent, false)
        val viewHolder = ViewHolder(v)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (tag) {
            0 -> {
                holder.chats=chatList[position]
                holder.setPicture(tag)
                holder.setChatname()
            }
            1 -> {
                holder.joins=joinList[position]
                holder.setPicture(tag)
                holder.setJoinname()
            }
            2 -> {
                holder.users=userList[position]
                holder.setPicture(tag)
                holder.setSearchUserName()
                holder.setSearchUserEmail()
            }
        }

    }

    override fun getItemCount(): Int {
        when (tag){
            0 -> return chatList.size
            1 -> return joinList.size
            2 -> return userList.size
        }
        return 0
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) , View.OnClickListener {
        private val mResultTextView: TextView = itemView.findViewById(R.id.textview_for_result)
        private val mEmailTextView: TextView = itemView.findViewById(R.id.search_user_email)
        private val mPictureImageView: ImageView = itemView.findViewById(R.id.pictureImageView)
        var chats: ChatSerializer? = null
        var joins: ChatSerializer? = null
        var users: UserSerializer? = null
        init {
            itemView.setOnClickListener(this)
        }
        fun setSearchUserName() {
            mResultTextView.text = "${this.users!!.firstName} ${this.users!!.lastName}"
        }

        fun setSearchUserEmail() {
            this.mEmailTextView.text = this.users!!.email
        }

        fun setPicture(tag: Int) {
            this.mPictureImageView.background = null
            when (tag){
                0 -> Picasso.with(this@SearchViewAdapter.mfragment.activity.baseContext)
                        .load(this.chats!!.pictureFile.url)
                        .resize(
                                Constants.GLOBAL_IMAGE_SIZE,
                                Constants.GLOBAL_IMAGE_SIZE
                        )
                        .centerInside()
                        .transform(CircleTransform(null))
                        .into(this.mPictureImageView)
                1 -> Picasso.with(this@SearchViewAdapter.mfragment.activity.baseContext)
                        .load(this.joins!!.pictureFile.url)
                        .resize(
                                Constants.GLOBAL_IMAGE_SIZE,
                                Constants.GLOBAL_IMAGE_SIZE
                        )
                        .centerInside()
                        .transform(CircleTransform(null))
                        .into(this.mPictureImageView)
                2 -> Picasso.with(this@SearchViewAdapter.mfragment.activity.baseContext)
                        .load(this.users!!.pictureFile.url)
                        .resize(
                                Constants.GLOBAL_IMAGE_SIZE,
                                Constants.GLOBAL_IMAGE_SIZE
                        )
                        .centerInside()
                        .transform(CircleTransform(null))
                        .into(this.mPictureImageView)
            }

        }

        fun setChatname() {
            mResultTextView.text = this.chats!!.name
            mEmailTextView.visibility=View.GONE
        }

        fun setJoinname() {
            mResultTextView.text = this.joins!!.name
            mEmailTextView.visibility=View.GONE
        }


        @Throws(ApiException::class)
        override fun onClick(p0: View?) {
            Log.i("test","clicked")
            when (tag){
                0 -> {
                    val intent = Intent(mfragment.activity, MessageListActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    intent.putExtra("CurrentChat", Gson().toJson(chats))
                    intent.putExtra("ParentChat", Gson().toJson(chats))
                    mfragment.activity.startActivity(intent)
                }
                1 -> {
                    val data = ChatUserPostSerializer()
                    data.chat.add(this.joins!!.id.toString())
                    data.user.add(CurrentUser.currentUser!!.id.toString())
                    Chat_userApi().chatUserCreateAsync(data, object: ApiCallback<ChatUserListCreateView>{
                        override fun onFailure(e: ApiException?, statusCode: Int, responseHeaders: MutableMap<String, MutableList<String>>?) {
                        }

                        override fun onSuccess(result: ChatUserListCreateView?, statusCode: Int, responseHeaders: MutableMap<String, MutableList<String>>?) {
                            val intent = Intent(mfragment.activity, MessageListActivity::class.java)
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                            intent.putExtra("CurrentChat", Gson().toJson(joins))
                            intent.putExtra("ParentChat", Gson().toJson(joins))
                            mfragment.activity.startActivity(intent)
                        }

                        override fun onDownloadProgress(bytesRead: Long, contentLength: Long, done: Boolean) {
                        }

                        override fun onUploadProgress(bytesWritten: Long, contentLength: Long, done: Boolean) {
                        }
                    } )
                }
            }

        }
    }
}
