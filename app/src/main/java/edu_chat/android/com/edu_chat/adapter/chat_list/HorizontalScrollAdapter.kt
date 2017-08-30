package edu_chat.android.com.edu_chat.adapter.chat_list

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import chat.edu.edu_chat.R
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import edu_chat.android.com.edu_chat.controller.message_list.MessageListActivity
import edu_chat.android.com.edu_chat.model.Constants
import edu_chat.android.com.edu_chat.view.CircleTransform
import io.swagger.client.model.ChatSerializer
import io.swagger.client.model.UserSerializer



internal class HorizontalScrollAdapter(private val parentChat: ChatSerializer,
									   private val context: Context,
									   private val UserList: Map<String, UserSerializer>,
//									   private val SubChatList: ArrayList<ChatSerializer>?,
									   private val elements: ArrayList<ChatSerializer>?)
	: RecyclerView.Adapter<HorizontalScrollAdapter.SimpleViewHolder>() {


	init {
		Log.d("Test1", context.toString())
		Log.d("Test1", elements.toString())
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder {
		val view = LayoutInflater.from(this.context).inflate(
				R.layout.horizontal_list_scroll_item,
				parent,
				false
		)
		Log.d("Test Adapter", "Created")
		return SimpleViewHolder(view)
	}


	override fun onBindViewHolder(holder: SimpleViewHolder, position: Int) {
//		if (elements!![position].unreadCount == 0) {
//			holder.notification.visibility = View.GONE
//		}
		if (elements!![position].pictureFile.url != null){
			if (elements[position].unreadCount == 0)
				holder.setPicture(elements[position].pictureFile.url, "#FFFFFF")
//			holder.button.image = context.resources.getDrawable(R.drawable.contact_pic_classmore_than_one)
			else if (elements[position].unreadCount > 0)
				holder.setPicture(elements[position].pictureFile.url, "#FE8E38")
		}

//		holder.notification.text = elements[position].unreadCount.toString()
		if (elements[position].isClass) {
			holder.name.text = context.resources.getString(R.string.announcement)
//			elements.removeAt(position)
		} else {
			holder.name.text = elements[position].name.toString()
		}
		holder.button.setOnClickListener {
			Log.d("Button CLicked",
					elements[position].id!!.toString() + " " + position)
			val intent = Intent(context, MessageListActivity::class.java)
			intent.putExtra("CurrentChat", Gson().toJson(elements[position]))
			intent.putExtra("UserList", Gson().toJson(UserList))
			intent.putExtra("ParentChat", Gson().toJson(parentChat))
//			intent.putExtra("SubChatsList", Gson().toJson(SubChatList))
			context.startActivity(intent)
		}
		Log.d("Test Adapter", "Binded")
	}

	override fun getItemId(position: Int): Long = position.toLong()

	override fun getItemCount(): Int = elements?.size ?: 0

	inner class SimpleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
		val button: ImageView = view.findViewById(R.id.circularButton)
//		val notification: TextView = view.findViewById(R.id.notificationTextView)
		val name: TextView = view.findViewById(R.id.SubChatTextView)


		fun setPicture(fileURL: String, colorString: String) {

			Picasso.with(context)
					.load(fileURL)
					.error(R.drawable.educhat)
					.fetch()

			Picasso.with(context)
					.load(fileURL)
					.error(R.drawable.educhat)
					.resize(
							Constants.GLOBAL_IMAGE_SIZE,
							Constants.GLOBAL_IMAGE_SIZE
					)
					.centerInside()
					.transform(CircleTransform(colorString))
					.skipMemoryCache()
					.into(this.button)
		}


	}
}
