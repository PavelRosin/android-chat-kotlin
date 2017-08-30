package edu_chat.android.com.edu_chat.controller.chat_list

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import chat.edu.edu_chat.R
import edu_chat.android.com.edu_chat.adapter.chat_list.SearchViewAdapter
import io.swagger.client.ApiCallback
import io.swagger.client.ApiException
import io.swagger.client.api.ChatApi
import io.swagger.client.api.UserApi
import io.swagger.client.model.ChatJoinListView
import io.swagger.client.model.ChatListCreateView
import io.swagger.client.model.UserListView
import kotlinx.android.synthetic.main.fragment_main_search.*
import kotlinx.android.synthetic.main.item_search_view_main.view.*

/**
 * Created by mingdimao on 7/11/17.
 * Edu.Chat Inc.
 */

class SearchViewFragment : Fragment() {
    private var searchAdapter: SearchViewAdapter? = null
    private var searchLayoutmanager: LinearLayoutManager? = null
    private var isl: InfiniteScrollListener? = null

    override fun onCreateView(
            inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = inflater!!.inflate(R.layout.fragment_main_search, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var position: Int = 0
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        searchAdapter = SearchViewAdapter(this@SearchViewFragment, position)
        searchLayoutmanager = LinearLayoutManager(this@SearchViewFragment.context)
        searchResultView.layoutManager = searchLayoutmanager
        searchResultView.adapter = searchAdapter
        isl = InfiniteScrollListener(searchLayoutmanager!!, searchAdapter!!, "")
        searchResultView.addOnScrollListener(isl)
        searchchats(searchTextView.text.toString())
        if(activity!=null){
            this@SearchViewFragment.activity.runOnUiThread { searchAdapter!!.notifyDataSetChanged() }
        }
        tab_bar.addTab(tab_bar.newTab().setText("My Chats"))
        tab_bar.addTab(tab_bar.newTab().setText("Join"))
        tab_bar.addTab(tab_bar.newTab().setText("People"))
        tab_bar.tabGravity = TabLayout.GRAVITY_FILL
        tab_bar.setTabTextColors(Color.parseColor("#A7A7A7"), Color.parseColor("#285b7d"))
        tab_bar.setSelectedTabIndicatorColor(Color.parseColor("#285b7d"))
        tab_bar.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                position = tab.position
                Log.d("Current tag is", position.toString())
                when (position) {
                    0 -> searchchats(searchTextView.text.toString())
                    1 -> searchjoin(searchTextView.text.toString())
                    2 -> searchpeople(searchTextView.text.toString())
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
        searchTextView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                position = tab_bar.selectedTabPosition
                when (position) {
                    0 -> searchchats(s.toString())
                    1 -> searchjoin(s.toString())
                    2 -> searchpeople(s.toString())
                }
                if (!TextUtils.isEmpty(searchTextView.text)) {
                    action_empty_btn.visibility = View.VISIBLE
                } else {
                    action_empty_btn.visibility = View.GONE
                }
            }

            override fun afterTextChanged(s: Editable?) {
                if (s.toString() == ""){
                    isl!!.previousTotal = 0
                }
            }
        })
        action_empty_btn.setOnClickListener {
            searchTextView.text = null
            searchAdapter!!.chatList.clear()
            searchAdapter!!.joinList.clear()
            searchAdapter!!.userList.clear()
            if(activity!=null){
                this@SearchViewFragment.activity.runOnUiThread { searchAdapter!!.notifyDataSetChanged() }
            }
        }
        action_back_btn.setOnClickListener {
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            val mgr = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            mgr.hideSoftInputFromWindow(searchTextView.windowToken, 0)
        }

    }

    @Throws(ApiException::class)
    private fun searchchats(inputString: String) {

        isl!!.init=false

        searchAdapter = SearchViewAdapter(this@SearchViewFragment,0)
        searchResultView.adapter = searchAdapter

        ChatApi().chatListAsync(null, null,
                inputString, null, null,
                null, null, null, null, 10,
                object : ApiCallback<ChatListCreateView> {
                    override fun onFailure(e: ApiException,
                                           statusCode: Int,
                                           responseHeaders: Map<String, List<String>>?) {
                    }

                    override fun onSuccess(result: ChatListCreateView,
                                           statusCode: Int,
                                           responseHeaders: Map<String, List<String>>?) {
                        Log.d("Filtering chats&Classes", "Filtering with " + inputString)
                        searchAdapter!!.chatList.clear()
                        if (result.results.chats.size>0){
                            for (i in 0 until result.results.chats.size){
                                searchAdapter!!.chatList.add(result.results.chats[i])
                            }
                        }
                        if(activity!=null){
                            this@SearchViewFragment.activity.runOnUiThread { searchAdapter!!.notifyDataSetChanged() }
                        }
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
    }

    @Throws(ApiException::class)
    private fun searchjoin(inputString: String) {

        isl!!.init=false

        searchAdapter = SearchViewAdapter(this@SearchViewFragment,1)
        searchResultView.adapter = searchAdapter

        ChatApi().chatJoinlistListAsync(null, null,
                inputString, null, null,
                null, null, null, null, 10,
                object : ApiCallback<ChatJoinListView> {
                    override fun onFailure(e: ApiException,
                                           statusCode: Int,
                                           responseHeaders: Map<String, List<String>>?) {
                    }

                    override fun onSuccess(result: ChatJoinListView,
                                           statusCode: Int,
                                           responseHeaders: Map<String, List<String>>?) {
                        Log.d("Filtering joins", "Filtering with " + inputString)
                        searchAdapter!!.joinList.clear()
                        if (result.results.size > 0) {
                            for (i in 0 until result.results.size) {
                                searchAdapter!!.joinList.add(result.results[i])
                            }
                        }
                        if (activity != null) {
                            this@SearchViewFragment.activity.runOnUiThread { searchAdapter!!.notifyDataSetChanged() }
                        }
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
    }

    @Throws(ApiException::class)
    private fun searchpeople(inputString: String) {

        isl!!.init=false

        searchAdapter = SearchViewAdapter(this@SearchViewFragment,2)
        searchResultView.adapter = searchAdapter

        UserApi().userListAsync(null, null,
                null, null, null, null, null, inputString, null, 10,
                object : ApiCallback<UserListView> {
                    override fun onFailure(e: ApiException,
                                           statusCode: Int,
                                           responseHeaders: Map<String, List<String>>?) {
                    }

                    override fun onSuccess(result: UserListView,
                                           statusCode: Int,
                                           responseHeaders: Map<String, List<String>>?) {
                        Log.d("Filtering people", "Filtering with " + inputString)
                        searchAdapter!!.userList.clear()
                        if (result.results.size > 0) {
                            for (i in 0 until result.results.size) {
                                searchAdapter!!.userList.add(result.results[i])
                            }
                        }
                        if (activity != null) {
                            this@SearchViewFragment.activity.runOnUiThread { searchAdapter!!.notifyDataSetChanged() }
                        }
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
    }
}

class InfiniteScrollListener(private val layoutManager: LinearLayoutManager,
                             val adapter: SearchViewAdapter,
                             var contains: String): RecyclerView.OnScrollListener() {

    var init = true
    var previousTotal = 0
    private val visibleThreshold = 5
    private var loading = true
    private var totalNumbercount = layoutManager.itemCount
    private var visibleItemcount = 0
    private var firstVisiblecount = 0

    override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        totalNumbercount = layoutManager.itemCount
        visibleItemcount = recyclerView!!.childCount
        firstVisiblecount = layoutManager.findFirstVisibleItemPosition()

        Log.d("Filtering", "Total Item Count: " + totalNumbercount.toString())
        Log.d("Filtering", "Visible Item Count: " + visibleItemcount.toString())
        Log.d("Filtering", "firstVisible Item: " + firstVisiblecount.toString())
        if (loading) {
            if (totalNumbercount > previousTotal) {
                loading = false
                previousTotal = totalNumbercount
            }
        }

        if (!loading && (totalNumbercount - visibleItemcount) <= (firstVisiblecount + visibleThreshold)) {
            loading = true
            val initialsize = adapter.userList.size
            UserApi().userListAsync(null,null,null,null,null,null,null,contains,
                    ((totalNumbercount/10))*10, 10, object : ApiCallback<UserListView>{
                override fun onFailure(e: ApiException?, statusCode: Int, responseHeaders: MutableMap<String, MutableList<String>>?) {
                }

                override fun onSuccess(result: UserListView?, statusCode: Int, responseHeaders: MutableMap<String, MutableList<String>>?) {
                    Log.d("update result","updating")
                    if (!result!!.results.isEmpty()){
                        adapter.userList.addAll(result.results)
                        val updatesize = adapter.userList.size
                        Log.d("initialsize equals",initialsize.toString())
                        Log.d("updatesize equals", updatesize.toString())
                        recyclerView.post{adapter.notifyItemChanged(initialsize,updatesize)}
                    }
                }

                override fun onDownloadProgress(bytesRead: Long, contentLength: Long, done: Boolean) {
                }

                override fun onUploadProgress(bytesWritten: Long, contentLength: Long, done: Boolean) {
                }
            } )
        }
    }
}
