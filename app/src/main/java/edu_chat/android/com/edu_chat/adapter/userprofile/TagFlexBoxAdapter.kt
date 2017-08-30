package edu_chat.android.com.edu_chat.adapter.userprofile

import android.annotation.SuppressLint
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import chat.edu.edu_chat.R
import chat.edu.edu_chat.R.color.*
import edu_chat.android.com.edu_chat.model.CurrentUser
import io.swagger.client.model.TagSerializer

/**
 * Created by Dan on 7/27/17.
 */
class TagFlexBoxAdapter(itemList: MutableList<TagSerializer>, selected: MutableList<TagSerializer>) : RecyclerView.Adapter<TagFlexBoxAdapter.TagViewHolder>() {

    private var items: MutableList<TagSerializer>? = ArrayList()
    private var selectedTags: MutableList<TagSerializer> = ArrayList()
    private var selected: MutableList<TagSerializer> = selected
    private var removedTags: MutableList<TagSerializer> = ArrayList()

    init {
        items = itemList
        Log.d("Tag", "" + items.toString())
        selectedTags = selected
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TagViewHolder {
        val inflater : LayoutInflater = LayoutInflater.from(parent!!.context)
        val view : View = inflater.inflate(R.layout.view_tags_search, parent, false)
        val holder : TagViewHolder = TagViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: TagViewHolder?, position: Int) {

        holder!!.bindItem(items!!.get(position))
        holder.itemView.setOnClickListener {
            if (!selectedTags.contains(holder.tagItem)) {
                selectedTags.add(holder.tagItem!!)
                if (removedTags.contains(holder.tagItem!!)) {
                    removedTags.remove(holder.tagItem!!)
                }
                holder.tagNameTV!!.setBackgroundResource(R.drawable.search_tag_button_selected)
                Log.d("Tag", "Red background, white text")
                Log.d("Tag", "New list: " + selectedTags.toString())
                holder.tagNameTV!!.setTextColor(Color.WHITE)
            } else {
                selectedTags.remove(holder.tagItem!!)
                if (selected.contains(holder.tagItem!!)) {
                    removedTags.add(holder.tagItem!!)
                }
                Log.d("Tag", "Removing: " + holder.tagItem!!.toString())
                holder.tagNameTV!!.setBackgroundResource(R.drawable.search_tag_button)
                holder.tagNameTV!!.setTextColor(holder.itemView.resources.getColor(R.color.tags_red))
                Log.d("Tag", "White background, red text")
                Log.d("Tag", "New list: " + selectedTags.toString())
            }
        }
        if (this.selectedTags.contains(items!!.get(position))) {
            Log.d("Tag", "Red background, white text")
            holder.tagNameTV!!.setBackgroundResource(R.drawable.search_tag_button_selected)
            holder.tagNameTV!!.setTextColor(Color.WHITE)
        }
    }

    fun getSelectedTags() : MutableList<TagSerializer> {
        return selectedTags
    }

    fun getRemovedTags() : MutableList<TagSerializer> {
        return removedTags
    }

    override fun getItemCount(): Int {
        return items!!.size
    }

    class TagViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tagNameTV : TextView? = null
        var tagItem : TagSerializer? = null

        fun bindItem(pItem: TagSerializer) {
            tagItem = pItem
            tagNameTV!!.text = tagItem!!.tag
            Log.d("Tag", "Tag: " + tagItem!!.tag)
        }

        init {
            tagNameTV = itemView.findViewById<TextView>(R.id.tag_name_tv)
        }
    }
}