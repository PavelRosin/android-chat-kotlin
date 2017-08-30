package edu_chat.android.com.edu_chat.controller.invite

import android.R.id
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.WindowManager
import chat.edu.edu_chat.R.layout
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.instabug.library.InstabugTrackingDelegate
import edu_chat.android.com.edu_chat.adapter.invite.GridViewAdapter
import edu_chat.android.com.edu_chat.adapter.invite.SearchUserListAdapter
import edu_chat.android.com.edu_chat.controller.chat_list.ChatListActivity
import edu_chat.android.com.edu_chat.controller.message_list.MessageListActivity
import edu_chat.android.com.edu_chat.model.CurrentUser
import edu_chat.android.com.edu_chat.model.SearchUser
import io.swagger.client.ApiCallback
import io.swagger.client.ApiException
import io.swagger.client.api.*
import io.swagger.client.model.*
import kotlinx.android.synthetic.main.activity_invite.*
import kotlinx.android.synthetic.main.content_create_chat.*
import kotlinx.android.synthetic.main.invite_toolbar.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.indeterminateProgressDialog
import java.io.File
import java.util.*


open class InviteActivity : AppCompatActivity(), DataTransferfromAdaptertoActivity {
	val selectedUsers = ArrayList<UserSerializer>()
	private var selectedUsersIds: ArrayList<SearchUser>? = null
	private val userList = ArrayList<UserSerializer>()
	private var gridViewAdapter: GridViewAdapter? = null
	private var searchUserListAdapter: SearchUserListAdapter? = null
	var searchChecked = ArrayList<Int>()
	private var chatName: String? = null
	private var courseName: String? = null
	private var courseCode: String? = null
	private var isSubchat: Boolean = false
	private var isClass: Boolean = false
	private var isAnonymous: Boolean = false
	var currentUsers: List<Int>? = null
	private var parentUsers: ArrayList<UserSerializer>? = null
	private var parentChat: ChatSerializer? = null
    private var layoutManager: WrapContentLinearLayoutManager? = null
    private var isl: InfiniteScrollListener? = null

	override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
		InstabugTrackingDelegate.notifyActivityGotTouchEvent(ev, this)
		return super.dispatchTouchEvent(ev)
	}


	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING)
		this.setContentView(layout.activity_invite)

		this.setSupportActionBar(inviteToolBar as Toolbar)
		isSubchat = intent.getBooleanExtra("isSubchat", false)
		isClass = intent.getBooleanExtra("isClass", false)
		isAnonymous = intent.getBooleanExtra("isAnonymous", false)
		if (intent.getStringExtra("CurrentUsers") != ""){
			val listType = object : TypeToken<List<Int>>() {

			}.type
			currentUsers = Gson().fromJson<List<Int>>(intent.getStringExtra("CurrentUsers"), listType)
		}
		Log.d("CurrentUsers", (currentUsers == null).toString())

		if (isSubchat) {
			val listTypeUser = object : TypeToken<List<UserSerializer>>() {

			}.type
			parentUsers = Gson().fromJson<ArrayList<UserSerializer>>(intent.getStringExtra("ParentUsers"), listTypeUser)
			val iterator = parentUsers!!.iterator()
			while(iterator.hasNext()){
				val user = iterator.next()
				if (user.id == CurrentUser.currentUser!!.id){
					iterator.remove()
				}
			}
			this.parentChat = Gson().fromJson(intent.getStringExtra("ParentChat"), ChatSerializer::class.java)
		}

		if (isClass) {
			this.courseName = intent.getStringExtra("Name")
			this.courseCode = intent.getStringExtra("Code")
		} else {
			this.chatName = intent.getStringExtra("Name")
		}
        layoutManager = WrapContentLinearLayoutManager(this.baseContext)
        search_user_view.layoutManager = layoutManager


        initialLoadMembers()

		this.selectedUsersIds = ArrayList()


		//         creator_id = getIntent().getStringExtra("creator_id");
		//         university_id = getIntent().getStringExtra("university_id");
		//         chat_name = getIntent().getStringExtra("chat_name");
		//         chat_desc = getIntent().getStringExtra("chat_desc");
		//         type = getIntent().getStringExtra("type");
		//        if(getIntent().hasExtra("parent_id")) {
		//               parent_id = getIntent().getIntExtra("parent_id", -100);
		//        }


		this.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
		this.supportActionBar!!.setDisplayShowHomeEnabled(true)

		this.changeImageButtonColor()
		this.linkEditText!!.setSelection(this.linkEditText!!.text.length)

		proceed_fun()

		(inviteToolBar as Toolbar).setNavigationOnClickListener { onBackPressed() }


		this.search_bar_invite!!.setOnTouchListener(OnTouchListener { _, event ->
			val DRAWABLE_LEFT = 0
			val DRAWABLE_TOP = 1
			val DRAWABLE_BOTTOM = 3

			if (event.action == MotionEvent.ACTION_UP) {
				val DRAWABLE_RIGHT = 2
				if (event.rawX >= (this@InviteActivity.search_bar_invite!!.right - this@InviteActivity.search_bar_invite!!.compoundDrawables[DRAWABLE_RIGHT].bounds.width()).toFloat()) {
					this@InviteActivity.search_bar_invite!!.setText("")

					return@OnTouchListener true
				}
			}
			false
		})
		this.search_bar_invite!!.addTextChangedListener(object : TextWatcher {
			override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
				Log.d("beforeTExt", (start + count + after).toString())
			}

			override fun onTextChanged(s: CharSequence, start: Int,
									   before: Int, count: Int) {
				//Toast.makeText(InviteActivity.this, "textChanged", Toast.LENGTH_SHORT).show();
				//make api call
				//                userList.clear();
				//                Log.d("length1", i + "");
				//                Log.d("length2", i1 + "");
				//                if(i == 0 && i1 == 1)
				//                    userList.clear();
				//                else
				//                Log.d("length", charSequence.toString().length() + "");
				if (!isSubchat)isl!!.init = false
				this@InviteActivity.populateUsers(s.toString())
                Log.d("Filtering", "Filter String: " + s.toString())
                //updateListChunk(0, s.toString());

			}

			override fun afterTextChanged(s: Editable) {
				if (s.toString() == ""){
					isl!!.init = true
					isl!!.previousTotal = 0
				}
			}
		})
	}

	private fun initialLoadMembers() {

		val inviteActivity = this
		if (isSubchat) {
			Log.d("Subchat", "True")
			searchUserListAdapter = SearchUserListAdapter(parentUsers!!, inviteActivity)
			search_user_view!!.adapter = searchUserListAdapter
			search_user_view!!.visibility = View.VISIBLE
			//TODO: Needs to get parent chat users if its a subchat invite
			gridViewAdapter = GridViewAdapter(inviteActivity, searchUserListAdapter!!)
			invite_grid_view!!.adapter = gridViewAdapter
		}

        else {
			searchUserListAdapter = SearchUserListAdapter(userList, inviteActivity)
			search_user_view!!.adapter = searchUserListAdapter
			search_user_view!!.visibility = View.VISIBLE
            isl = InfiniteScrollListener(layoutManager!!, searchUserListAdapter!!, "")
            search_user_view!!.addOnScrollListener(isl)

			val progress = indeterminateProgressDialog("Fetching users")
			progress.show()
			progress.setCanceledOnTouchOutside(false)
			runOnUiThread { updateListChunk(0, "") }
			gridViewAdapter = GridViewAdapter(inviteActivity, searchUserListAdapter!!)
			invite_grid_view!!.adapter = gridViewAdapter
			progress.dismiss()

		}
	}

	private fun updateListChunk(n: Int, contains: String) {

		if (n==1){
			isl!!.init = true
        }

        else {
            if (n < 1) {
                try {
                    UserApi().userListAsync(null, null, contains, null, contains, null, null, null, null, 10, object : ApiCallback<UserListView> {
                        override fun onFailure(e: ApiException,
                                               statusCode: Int,
                                               responseHeaders: Map<String, List<String>>?) {

                        }

                        override fun onSuccess(result: UserListView,
                                               statusCode: Int,
                                               responseHeaders: Map<String, List<String>>?) {
                            Log.d("UserLoad", "Working")
                            if (result.results.size > 0) {
                                for (i in 0 until result.results.size) {
                                    if (currentUsers != null) {
                                        //If we have current users, we filter out results
                                        if (!(currentUsers as List<Int>).contains(result.results[i].id)) {
                                            searchUserListAdapter!!.userList.add(result.results[i])
                                        } else {
                                            Log.d("CurrentUsers", "User removed " + result.results[i].firstName)
                                        }
                                    } else {
                                        searchUserListAdapter!!.userList.add(result.results[i])
                                    }
                                }
                                runOnUiThread({
                                    searchUserListAdapter!!.notifyItemRangeChanged((n) * 10, (n + 1) * 10)
                                    updateListChunk(n + 1, contains)
                                })

                            }
                        }

                        override fun onUploadProgress(bytesWritten: Long, contentLength: Long, done: Boolean) {

                        }

                        override fun onDownloadProgress(bytesRead: Long, contentLength: Long, done: Boolean) {

                        }
                    })
                } catch (e: ApiException) {
                    e.printStackTrace()
                }

            }
        }
	}

	open fun proceed_fun() {

		chatInfoImageView!!.setOnClickListener {
			var progress = indeterminateProgressDialog("Uploading image")
			progress.setCanceledOnTouchOutside(false)
			progress.show()
			Log.d("CreateChat", "Clicked")
			if (intent.getStringExtra("File") != null) {
				val file = File(intent.getStringExtra("File"))
				FileApi().fileCreateAsync("Test", file, object : ApiCallback<FileCreateView> {
					override fun onFailure(e: ApiException?, statusCode: Int, responseHeaders: MutableMap<String, MutableList<String>>?) {
						Log.d("Filezzz", e!!.responseBody)
					}

					override fun onSuccess(result: FileCreateView?, statusCode: Int, responseHeaders: MutableMap<String, MutableList<String>>?) {
						Log.d("Filezzz", result!!.results.name)
						runOnUiThread{
							progress.hide()
							attemptCreateChat(result.results.id)
						}
					}

					override fun onUploadProgress(bytesWritten: Long, contentLength: Long, done: Boolean) {
					}

					override fun onDownloadProgress(bytesRead: Long, contentLength: Long, done: Boolean) {
					}

				})

			}
			else{
				progress.dismiss()
				attemptCreateChat(0)
			}
		}



	}

	private fun changeImageButtonColor() {
		val color = Color.parseColor("#4A90E2")

	}

	private fun populateUsers(inputString: String) {

		isl!!.init = false

		if (isSubchat) {
			searchUserListAdapter!!.userList = parentUsers!!.toMutableList()
			searchUserListAdapter!!.notifyDataSetChanged()
		} else {

			val userApi = UserApi()
			try {
				userApi.userListAsync(null, null,
						null, null, null, null, null, inputString,null, 10,
						object : ApiCallback<UserListView> {
							override fun onFailure(e: ApiException,
												   statusCode: Int,
												   responseHeaders: Map<String, List<String>>?) {

							}

							override fun onSuccess(result: UserListView,
												   statusCode: Int,
												   responseHeaders: Map<String, List<String>>?) {
								Log.d("Filtering", "Filtering with " + inputString)
								searchUserListAdapter!!.userList.clear()
								if (result.results.size > 0) {
										for (i in 0 until result.results.size) {
											if (currentUsers != null) {
												//If we have current users, we filter out results
												if (!(currentUsers as List<Int>).contains(result.results[i].id)) {
													searchUserListAdapter!!.userList.add(result.results[i])
												}
											} else {
												searchUserListAdapter!!.userList.add(result.results[i])
											}
										}

										this@InviteActivity.runOnUiThread {searchUserListAdapter!!.notifyDataSetChanged()}

                                    }

								else{
									runOnUiThread{searchUserListAdapter!!.notifyDataSetChanged()}
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
			} catch (e: ApiException) {
				e.printStackTrace()
			}

		}

	}

	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		if (item.itemId == id.home) {
			this.finish()
		}
		return super.onOptionsItemSelected(item)
	}

	override fun finish() {
		val editor = this.getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE).edit()
		editor.putString("activity", "Activity")
		editor.apply()
		super.finish()
	}

	fun getUserList(): ArrayList<UserSerializer> {
		return this.selectedUsers
	}

	fun setUserList(user: UserSerializer) {
		this.selectedUsers.add(user)
		Log.d("Add", selectedUsers.size.toString())
		this.gridViewAdapter = GridViewAdapter(this, searchUserListAdapter!!)
		this.invite_grid_view!!.adapter = this.gridViewAdapter
	}

	fun removeSelectedUser(user: UserSerializer) {
		Log.d("GridView", "User removed: " + user.firstName)
		SearchUserListAdapter.positionObj--
		//this.userList.clear();
		if (this.selectedUsers.remove(user)) {
			Log.d("GridViewRemove", "User removed: " + user.firstName)
			for (user2 in this.selectedUsers) {
				Log.d("GridViewRemove", user2.firstName)
			}
		} else {
			Log.d("GridViewRemove", "Could not find user")
		}
		Log.d("GridView", "Size of set after remove: " + selectedUsers.size)
		this.gridViewAdapter!!.notifyDataSetChanged()
		this.gridViewAdapter = GridViewAdapter(this, searchUserListAdapter!!)
		this.invite_grid_view!!.adapter = this.gridViewAdapter
	}

	fun notifyDataChangeToGridViewAdapter(position: Int) {
		//        Toast.makeText(getBaseContext(),"notify data set changed",Toast.LENGTH_LONG).show();
		this.gridViewAdapter!!.updateSelectedUserList(position) // error
		this.gridViewAdapter!!.notifyDataSetChanged()

	}

	fun changeGridViewHeight(height: Int) {
		val layoutParams = this.invite_grid_view!!.layoutParams
		layoutParams.height = height //this is in pixels
		this.invite_grid_view!!.layoutParams = layoutParams
	}

	private fun attemptCreateChat(fileId: Int) {

		val progress = indeterminateProgressDialog("Creating the chat")
		progress.setCanceledOnTouchOutside(false)
		progress.show()

		val adminUser = CurrentUser.currentUser
		val data = APIViewChatSerializer()
		data.searchable = intent.getBooleanExtra("isOpen", false)
		data.isClass = isClass
		if (fileId > 0){
			data.pictureFile = fileId
		}
		if (isClass) {
			data.name = this.courseName
			data.courseCode = this.courseCode
			data.isBot(false)
			data.isAnonymous = isAnonymous
			data.isReadOnly = true
			data.addNewUsersFromParent(false)
		} else {
			data.name = this.chatName
		}
		if (isSubchat) {
			data.parent = parentChat!!.id
			data.isAnonymous = isAnonymous
		}

		val chatApi = ChatApi()
		try {
			chatApi.chatCreateAsync(data, object : ApiCallback<ChatListCreateView1> {
				override fun onFailure(e: ApiException,
									   statusCode: Int,
									   responseHeaders: Map<String, List<String>>?) {
					Log.d("Chat", "Fail")
					Log.d("Chat", e.responseBody)
				}

				override fun onSuccess(result: ChatListCreateView1,
									   statusCode: Int,
									   responseHeaders: Map<String, List<String>>?) {
					Log.d("Chat", "Success")
					Log.d("Status", statusCode.toString())
					Log.d("Status", result.results.name)
					Log.d("Chat", result.results.id!!.toString())

					val currentChat = result.results

					val tagApi = TagApi()

					val data1 = ChatTagSerializer()
					data1.chat = result.results.id
					//                    String[] tags = createChatActivity.subjectEditText.getText().toString()
					//                            .replaceAll(
					//                                    " ",
					//                                    ""
					//                            ).split(",");
					//                    Log.d(
					//                            "Tags",
					//                            createChatActivity.subjectEditText.getText().toString().replaceAll(
					//                                    " ",
					//                                    ""
					//                            )
					//                    );

					try {
						tagApi.tagListAsync(null, null, object : ApiCallback<TagView> {
							override fun onFailure(e: ApiException, statusCode: Int, responseHeaders: Map<String, List<String>>?) {

							}

							override fun onSuccess(result: TagView, statusCode: Int, responseHeaders: Map<String, List<String>>?) {

							}

							override fun onUploadProgress(bytesWritten: Long, contentLength: Long, done: Boolean) {

							}

							override fun onDownloadProgress(bytesRead: Long, contentLength: Long, done: Boolean) {

							}
						})
					} catch (e: ApiException) {
						e.printStackTrace()
					}

					val tagsList = ArrayList<TagSerializer>()
					//                    for (final String current : tags) {
					//                        Log.d("Tags", current);
					//
					//                        //data1.setTag(Integer.valueOf(current));
					//                        try {
					//                            tagApi.tagChatCreateAsync(data1, new ApiCallback<ChatTagView>() {
					//                                @Override
					//                                public void onFailure(ApiException e,
					//                                                      int statusCode,
					//                                                      Map<String, List<String>> responseHeaders) {
					//                                    Log.d("Tags", "Fail");
					//                                    Log.d("Tags", e.getResponseBody());
					//                                }
					//
					//                                @Override
					//                                public void onSuccess(ChatTagView result,
					//                                                      int statusCode,
					//                                                      Map<String, List<String>> responseHeaders) {
					//                                    Log.d("Tags", "success tags");
					//                                    Log.d("Tags", String.valueOf(result.getResults().getChat()));
					//                                }
					//
					//                                @Override
					//                                public void onUploadProgress(long bytesWritten,
					//                                                             long contentLength,
					//                                                             boolean done) {
					//
					//                                }
					//
					//                                @Override
					//                                public void onDownloadProgress(long bytesRead,
					//                                                               long contentLength,
					//                                                               boolean done) {
					//
					//                                }
					//                            });
					//                        } catch (ApiException e) {
					//                            e.printStackTrace();
					//                        }
					//                    }
					val user2 = ChatUserPostSerializer()

					val listchat = ArrayList<String>()
					val listuser = ArrayList<String>()

					for (users in selectedUsers) {
							listuser.add(users.id!!.toString())
							listchat.add(result.results.id!!.toString())
						}

					user2.chat = listchat
					user2.user = listuser

					val chatUserApi = Chat_userApi()
					try {
						Log.d("Test_Chat", "Trying to Link User")
						// chatUserApi.chatUserCreate(user2);
						// Log.d("Test_Chat","Sync Worked");
						chatUserApi.chatUserCreateAsync(
								user2,
								object : ApiCallback<ChatUserListCreateView> {
									override fun onFailure(e: ApiException,
														   statusCode: Int,
														   responseHeaders: Map<String, List<String>>?) {
										Log.d("Test_Chat", "User Failed")
										Log.d(
												"Test_Chat",
												e.responseBody
										)
									}

									override fun onSuccess(result: ChatUserListCreateView,
														   statusCode: Int,
														   responseHeaders: Map<String, List<String>>?) {

										runOnUiThread({ progress.dismiss() })
										if (isSubchat) {
											val intent = Intent(baseContext, MessageListActivity::class.java)
											intent.putExtra("CurrentChat", Gson().toJson(currentChat))
											intent.putExtra("ParentChat", getIntent().getStringExtra("ParentChat"))
											Log.d("SubChat", currentChat.toString())
											finish()
											startActivity(intent)
										} else {
											val intent = Intent(baseContext, ChatListActivity::class.java)
											finish()
											startActivity(intent)
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
					} catch (e: ApiException) {
						e.printStackTrace()
					}

				}

				override fun onUploadProgress(bytesWritten: Long, contentLength: Long, done: Boolean) {

				}

				override fun onDownloadProgress(bytesRead: Long, contentLength: Long, done: Boolean) {

				}
			})
		} catch (e: ApiException) {
			e.printStackTrace()
		}

	}

	override fun idList(userIds: ArrayList<SearchUser>) {
		// We have the id list here
		this.selectedUsersIds!!.clear()
		this.selectedUsersIds!!.addAll(userIds)
	}


	companion object {

		private val MY_PREFS_NAME = "MyPrefsFile"
	}
}

    class InfiniteScrollListener(private val layoutManager: LinearLayoutManager,
								 val adapter: SearchUserListAdapter,
								 var contains: String) : RecyclerView.OnScrollListener() {

		var init = false
        var previousTotal = 0
		private var loading = true
        private val visibleThreshold = 5
        private var firstVisibleItem = 0
        private var visibleItemCount = 0
        private var totalItemCount = layoutManager.itemCount
		private var previousContains = ""

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

			if (!init)return

			totalItemCount = layoutManager.itemCount
            visibleItemCount = recyclerView.childCount
            firstVisibleItem = layoutManager.findFirstVisibleItemPosition()

            Log.d("Filtering", "Total Item Count: " + totalItemCount.toString())
            Log.d("Filtering", "Visible Item Count: " + visibleItemCount.toString())
            Log.d("Filtering", "firstVisible Item: " + firstVisibleItem.toString())

            if (loading) {
                if (totalItemCount > previousTotal) {
                    Log.d("Filtering", "Loading is now False")
                    loading = false
                    previousTotal = totalItemCount
                }
            }

            if (!loading && (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold)) {
                Log.d("Filtering", "Loading is now True")
				previousContains = contains
                loading = true
                val initialSize = adapter.userList.size
				UserApi().userListAsync(null, null,
                        null, null, null, null, null, contains, (totalItemCount/10)*10, 10,
                        object : ApiCallback<UserListView> {
                            override fun onFailure(e: ApiException,
                                                   statusCode: Int,
                                                   responseHeaders: Map<String, List<String>>?) {

                            }

                            override fun onSuccess(result: UserListView,
                                                   statusCode: Int,
                                                   responseHeaders: Map<String, List<String>>?) {
                                Log.d("Filtering", "Loading More with filter string: " + contains)

                                if (!result.results.isEmpty()) {
                                    adapter.userList.addAll(result.results)
                                    val updatedSize = adapter.userList.size
                                    recyclerView.post { adapter.notifyItemRangeChanged(initialSize, updatedSize) }
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
        }

class WrapContentLinearLayoutManager(context: Context) : LinearLayoutManager(context) {

    override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State) {
        try {
            super.onLayoutChildren(recycler, state)
        } catch (e: IndexOutOfBoundsException) {
            Log.e("Error", "IndexOutOfBoundsException in RecyclerView happens")
        }

    }
}

