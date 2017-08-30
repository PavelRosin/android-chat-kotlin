package edu_chat.android.com.edu_chat.controller.userprofile


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import chat.edu.edu_chat.R
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import edu_chat.android.com.edu_chat.adapter.userprofile.TagFlexBoxAdapter
import edu_chat.android.com.edu_chat.model.CurrentUser
import io.swagger.client.model.TagSerializer


/**
 * A simple [Fragment] subclass.
 */
class TagsRecyclerFragment : Fragment() {

    //private var tagsList : MutableList<TagSerializer>? = null

    private var recycler : RecyclerView? = null

//    fun passTagsList(list : MutableList<TagSerializer>) {
//        tagsList = list
//    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = inflater!!.inflate(R.layout.fragment_tags_recycler, container, false)
        recycler = view.findViewById(R.id.tags_recycler_view)
        val layoutManager: FlexboxLayoutManager = FlexboxLayoutManager(context)
        layoutManager.flexDirection = FlexDirection.ROW
        layoutManager.justifyContent = JustifyContent.CENTER
        layoutManager.flexWrap = FlexWrap.WRAP
        recycler!!.layoutManager = layoutManager
        recycler!!.adapter = TagFlexBoxAdapter((activity as AddingTagsActivity).getTagsList(), CurrentUser.currentUser!!.tags)
        Log.d("Tag", "RecyclerFragment added")
        return view
    }

    fun updateTags(newList : MutableList<TagSerializer>) {
        recycler!!.adapter = TagFlexBoxAdapter(newList, (recycler!!.adapter!! as TagFlexBoxAdapter).getSelectedTags())
    }

}// Required empty public constructor
