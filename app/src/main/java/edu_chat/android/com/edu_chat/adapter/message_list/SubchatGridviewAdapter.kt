package edu_chat.android.com.edu_chat.adapter.message_list

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import chat.edu.edu_chat.R
import com.google.gson.Gson
import edu_chat.android.com.edu_chat.controller.message_list.MessageListActivity
import io.swagger.client.model.ChatSerializer
import org.jetbrains.anko.activityManager

/**
 * Created by Billy Yang on 2017/7/20.
 */
class SubchatGridviewAdapter(private val parentChat: ChatSerializer,
							 private val context: Context,
							 private val currChat: ChatSerializer,
//							 private val subChatList: ArrayList<ChatSerializer>?,
							 private val elements: ArrayList<ChatSerializer>?) : RecyclerView.Adapter<SubchatGridviewAdapter.SimpleViewHolder>() {


	override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SimpleViewHolder {
		val view = LayoutInflater.from(this.context).inflate(
				R.layout.subchat_gridview_item,
				parent,
				false
		)
		Log.d("Test Adapter", "Created")
		return SimpleViewHolder(view)
	}

	override fun onBindViewHolder(holder: SimpleViewHolder, position: Int) {
		if (elements!![position].unreadCount == 0) {
			holder.notification.visibility = View.GONE
		}
		holder.notification.text = elements[position].unreadCount.toString()
		if (elements[position].isClass) {
			holder.name.text = context.resources.getString(R.string.announcement)
		} else {
			holder.name.text = elements[position].name.toString()
		}
		if (position == elements.size - 1) holder.divider.visibility = View.GONE
//		if (currChat.parent != null) elements.add(currChat)
		holder.item.setOnClickListener {
			Log.d("Button CLicked",
					elements[position].id!!.toString() + " " + position)
			val intent = Intent(context, MessageListActivity::class.java)
			intent.putExtra("CurrentChat", Gson().toJson(elements[position]))
			intent.putExtra("ParentChat", Gson().toJson(parentChat))
			intent.putExtra("isBot", elements[position].isBot)
//			intent.putExtra("SubChatsList", Gson().toJson(subChatList))
//            intent.putExtra("IsClass", isClass)
			(context as Activity).finish()
			context.startActivity(intent)
		}
		Log.d("Test Adapter", "Binded")

	}

	override fun getItemCount(): Int = elements?.size ?: 0

	inner class SimpleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
		val item: RelativeLayout = view.findViewById(R.id.subchat_item)
		val notification: TextView = view.findViewById(R.id.subchat_notification)
		val name: TextView = view.findViewById(R.id.subchat_name)
		val divider: TextView = view.findViewById(R.id.subchat_divider)
	}
}