package edu_chat.android.com.edu_chat.controller.chat_list

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import chat.edu.edu_chat.R
import edu_chat.android.com.edu_chat.adapter.chat_list.ChatListAdapter
import io.swagger.client.ApiCallback
import io.swagger.client.ApiException
import io.swagger.client.api.ChatApi
import io.swagger.client.model.ChatListCreateView
import io.swagger.client.model.ChatSerializer
import io.swagger.client.model.UserSerializer
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.main_activity_layout.*
import org.jetbrains.anko.support.v4.act
import org.jetbrains.anko.support.v4.indeterminateProgressDialog


/**
 * A simple [Fragment] subclass.
 */
class ChatListFragment : Fragment {

	private var ChatList: ArrayList<ChatSerializer>? = null
	private var UserList: Map<String, UserSerializer>? = null
	var isChat: Boolean = false
	var chatsAdapter: ChatListAdapter? = null

	constructor()

	@SuppressLint("ValidFragment")
	constructor(isChat: Boolean) {
		Log.d("ChatListFragment", isChat.toString())
		this.isChat = isChat
	}

	override fun onCreateView(inflater: LayoutInflater?,
							  container: ViewGroup?,
							  savedInstanceState: Bundle?): View? {
		val view: View = inflater!!.inflate(R.layout.fragment_home, container, false)
        Log.d("Created", "Created15")
		when {
			this.isChat -> view.tag = 1
			else -> view.tag = 0
		}
		return view

	}

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)
		this.populateSwipeLayout()
		this.populateChats()
	}


	override fun onResume() {
		super.onResume()
		try {
			this.getChatLoadOut()
		} catch (e: ApiException) {
			e.printStackTrace()
		}

	}

	@Throws(ApiException::class)
	private fun getChatLoadOut() {
		this.swipeContainer!!.isRefreshing = true

		ChatApi().chatListAsync(null, null,
				null, null, null,
				!isChat, null,null, null, 10,
				object : ApiCallback<ChatListCreateView> {
					override fun onFailure(e: ApiException,
										   statusCode: Int,
										   responseHeaders: Map<String, List<String>>?) {
						//System.out.println("Chat load fail");
						if(activity!=null) {
							activity.runOnUiThread { this@ChatListFragment.swipeContainer!!.isRefreshing = false }
						}
						//Log.d("Chat Load", e.responseBody)
					}

					override fun onSuccess(result: ChatListCreateView,
										   statusCode: Int,
										   responseHeaders: Map<String, List<String>>?) {
						this@ChatListFragment.ChatList = result.results.chats as ArrayList<ChatSerializer>?
						if (ChatList!!.size > 9){
							if(activity!=null) {
								activity.runOnUiThread({
									moreChats.visibility = View.VISIBLE
									moreChats.setOnClickListener(View.OnClickListener {
										val progress = indeterminateProgressDialog("Loading More Chats")
										progress.setCanceledOnTouchOutside(false)
										moreChats.visibility = View.GONE
										ChatApi().chatListAsync(null, null,
												null, null, null,
												!isChat, null,null, 10, 20,
												object : ApiCallback<ChatListCreateView> {
													override fun onFailure(e: ApiException?, statusCode: Int, responseHeaders: MutableMap<String, MutableList<String>>?) {

													}

													override fun onSuccess(result: ChatListCreateView?, statusCode: Int, responseHeaders: MutableMap<String, MutableList<String>>?) {
														progress.dismiss()
														if(activity!=null){
															activity.runOnUiThread({
																chatsAdapter!!.ChatList.addAll(result!!.results.chats)
																for (Pair in result.results.users){
																	val newPair = Pair<String, UserSerializer>(Pair.key, Pair.value)
																	UserList = UserList!!.plus(newPair)
																	Log.d("UserList1", UserList!!.size.toString())
																}
																chatsAdapter!!.UserList = UserList!!
																chatsAdapter!!.notifyItemRangeChanged(10, 30)
															})
														}

													}

													override fun onUploadProgress(bytesWritten: Long, contentLength: Long, done: Boolean) {
													}

													override fun onDownloadProgress(bytesRead: Long, contentLength: Long, done: Boolean) {
													}

												})
									})
								})}

						}
						UserList = result.results.users
						//System.out.println("Chat success");
						Log.d("ChatList", "Chat Success")
						activity.runOnUiThread {
							this@ChatListFragment.populateRecyclerView()
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

	private fun populateRecyclerView() {
		if (ChatList!!.isEmpty()) {
			if (isChat) {
				activity!!.main_no_chats.visibility = View.VISIBLE
				activity!!.main_no_classes.visibility = View.INVISIBLE
			} else {
				activity!!.main_no_classes.visibility = View.VISIBLE
				activity!!.main_no_chats.visibility = View.INVISIBLE
			}
		} else {
			if (isChat) activity!!.main_no_chats.visibility = View.INVISIBLE
			else activity!!.main_no_classes.visibility = View.INVISIBLE
			chatsAdapter = ChatListAdapter(this, this.ChatList!!, UserList!!)
			chatsList2!!.layoutManager = LinearLayoutManager(context)
			chatsList2!!.adapter = chatsAdapter
		}

		//        this.searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
		//            @Override
		//            public boolean onQueryTextSubmit(final String query) {
		//                Log.d("SEARCH", "Query: " + query);
		//                //Do some magic
		//                if (ChatList.isEmpty()) {
		//                    Log.d("SEARCH", "No Chats");
		//                    ClassFragment.this.CHATS.setText(getString(R.string.no_chats_yet));
		//                } else {
		//                    Log.d("SEARCH", "Chats");
		//                    Iterator<ChatUnreadSerializer> chatListIterator = ChatList.iterator();
		//                    List<ChatUnreadSerializer> searchedChats = new ArrayList<>();
		//                    do {
		//                        ChatUnreadSerializer currChat = chatListIterator.next();
		//                        if (currChat.getName().toLowerCase().contains(query.toLowerCase())) {
		//                            searchedChats.add(currChat);
		//                        } else {
		//                            Iterator<TagSerializer> tagsIterator = currChat.getTags().iterator();
		//                            if (tagsIterator.hasNext()) {
		//                                do {
		//                                    TagSerializer currTag = tagsIterator.next();
		//                                    if (currTag.getTag().toLowerCase().contains(query
		// .toLowerCase())) {
		//                                        searchedChats.add(currChat);
		//                                    }
		//                                } while (tagsIterator.hasNext());
		//                            }
		//                        }
		//                    } while (chatListIterator.hasNext());
		//                    ClassFragment.this.chatsAdapter = new ChatListAdapter(ClassFragment
		// .this, searchedChats);
		//                    ClassFragment.this.chatsList.setHasFixedSize(false);
		//                    ClassFragment.this.chatsList.setLayoutManager(new LinearLayoutManager
		// (getContext()));
		//                    ClassFragment.this.chatsList.setAdapter(ClassFragment.this.chatsAdapter);
		//                    Toast.makeText(getContext(), "Swipe down to return to all chats", Toast
		// .LENGTH_LONG).show();
		//                }
		//                return false;
		//            }
		//
		//            @Override
		//            public boolean onQueryTextChange(final String newText) {
		//                Log.d("SEARCH", "newText: " + newText);
		//                //Do some magic
		//                if (TextUtils.isEmpty(newText)) {
		//                    if (ClassFragment.this.chatsAdapter != null)
		//                        ClassFragment.this.chatsAdapter.getFilter().filter("");
		//                    if (ClassFragment.this.broadcastsAdapter != null)
		//                        ClassFragment.this.broadcastsAdapter.getFilter().filter("");
		//                } else {
		//                    if (ClassFragment.this.chatsAdapter != null)
		//                        ClassFragment.this.chatsAdapter.getFilter().filter(newText);
		//                    if (ClassFragment.this.broadcastsAdapter != null)
		//                        ClassFragment.this.broadcastsAdapter.getFilter().filter(newText);
		//                }
		//                return true;
		//
		//            }
		//        });
		this.swipeContainer!!.isRefreshing = false
	}

	private fun populateSwipeLayout() {
		this.swipeContainer!!.setOnRefreshListener {
			try {
				this@ChatListFragment.getChatLoadOut()
			} catch (e: ApiException) {
				e.printStackTrace()
			}
		}

		this.swipeContainer!!.setColorSchemeResources(
				android.R.color.holo_blue_bright,
				android.R.color.holo_green_light,
				android.R.color.holo_orange_light,
				android.R.color.holo_red_light
		)
	}

	private fun populateChats() {
		try {
			this.getChatLoadOut()
		} catch (e: ApiException) {
			e.printStackTrace()
		}

		this.swipeContainer!!.setColorSchemeResources(
				android.R.color.holo_blue_bright,
				android.R.color.holo_green_light,
				android.R.color.holo_orange_light,
				android.R.color.holo_red_light
		)

	}
}
