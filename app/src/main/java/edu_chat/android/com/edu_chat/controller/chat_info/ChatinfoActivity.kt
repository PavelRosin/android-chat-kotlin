package edu_chat.android.com.edu_chat.controller.chat_info

import android.annotation.SuppressLint
import android.app.AlertDialog.Builder
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.text.Html
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.widget.Toast
import chat.edu.edu_chat.R
import chat.edu.edu_chat.R.id
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.instabug.library.InstabugTrackingDelegate
import edu_chat.android.com.edu_chat.controller.chat_create.CreateChatActivity
import edu_chat.android.com.edu_chat.controller.chat_list.ChatListActivity
import edu_chat.android.com.edu_chat.controller.message_list.MessageListActivity
import edu_chat.android.com.edu_chat.model.CurrentUser
import io.swagger.client.ApiCallback
import io.swagger.client.ApiException
import io.swagger.client.api.ChatApi
import io.swagger.client.api.Chat_userApi
import io.swagger.client.model.*
import kotlinx.android.synthetic.main.activity_chatinfo.*
import org.jetbrains.anko.*
import java.util.*


/**
 * Created by yuandali on 6/20/16.
 * Edu.Chat Inc.
 */

class ChatinfoActivity : AppCompatActivity() {

	var chat: ChatSerializer? = null
	private var userList = ArrayList<UserSerializer>()
	var isSubchat: Boolean = false
	var parentId: Int = 0
	var chatRefresh = false

	override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
		InstabugTrackingDelegate.notifyActivityGotTouchEvent(ev, this)
		return super.dispatchTouchEvent(ev)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		this.setContentView(R.layout.activity_chatinfo)
		val gson = Gson()
		chat = gson.fromJson(intent.getStringExtra("CurrentChat"), ChatSerializer::class.java)
		isSubchat = chat!!.parent != null
		parentId = intent.getIntExtra("ParentId", 0)
		Log.d("ChatInfo", isSubchat.toString())

		if (intent.getStringExtra("Members") != "") {
			val listTypeUser = object : TypeToken<ArrayList<UserSerializer>>() {

			}.type

			userList = Gson().fromJson<ArrayList<UserSerializer>>(intent.getStringExtra("Members"), listTypeUser)
			getChatDetail()
			updateChatDetail()
		}

		//These values are for passing ONLY.
		var parentChat = intent.getStringExtra("ParentChat")
		var userList = intent.getStringExtra("UserList")
		var isBot = intent.getBooleanExtra("isBot", false)

		this.setSupportActionBar(chatinfo_toolbar as Toolbar)
		if (this.supportActionBar != null) {
			this.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
			this.supportActionBar!!.setDisplayShowHomeEnabled(true)
			this.supportActionBar!!.title = chat!!.name
		}

		(chatinfo_toolbar as Toolbar).setNavigationOnClickListener {
			if(chatRefresh){
				var intent = Intent(applicationContext, MessageListActivity::class.java)
				intent.putExtra("CurrentChat", Gson().toJson(chat))
				intent.putExtra("ParentChat", parentChat)
				Log.d("ChatRefresh", "Chatinfo ParentChat is " + (parentChat==null))
				intent.putExtra("isSubchat", isSubchat)
				intent.putExtra("isBot", isBot)
				intent.putExtra("UserList", userList)
				Log.d("ChatRefresh", "Chatinfo UserList is " + (userList==null))
				this.finish()
				startActivity(intent)
			}
			else{
				this.finish()
				onBackPressed()
			}
		}

	}

	private fun getChatDetail() {
		//        TODO: Swaggerfy
		//        final RequestParams params = new RequestParams();
		//        params.put("chat_id", this.chat.getObjectIdentifier());
		//        params.put("token", ECUser.getUserToken());
		//        params.put("platform", "android");
		//        new ChatDetailsObject(params) {
		//            @Override
		//            public void onSuccessGlobal(final int statusCode, final Header[] headers,
		//                                        final byte[] responseBody) {
		//                super.onSuccessGlobal(statusCode, headers, responseBody);
		//                Log.d("CHAT_INFO_RESP", new String(responseBody));
		//                try {
		//                    ChatinfoActivity.this.jsonResponse = new JSONObject(new String(responseBody));
		//                } catch (final JSONException e) {
		//                    Log.e("CHAT_INFO", "Error in chat info response");
		//                    e.printStackTrace();
		//                }
		//
		//                try {
		//                    ChatinfoActivity.this.usersObject = ChatinfoActivity.this.jsonResponse
		//                            .getJSONObject("users");
		//                } catch (final JSONException e) {
		//                    e.printStackTrace();
		//                }
		//                ChatinfoActivity.this.userTable = ChatinfoActivity.parseUserTable
		// (ChatinfoActivity.this.jsonResponse);
		//                ChatinfoActivity.this.updateChatDetail(ChatinfoActivity.this.jsonResponse);
		this@ChatinfoActivity.updatePages()
		//            }
		//
		//            @Override
		//            public void onFailureGlobal(final int statusCode,
		//                                        final Header[] headers,
		//                                        final byte[] responseBody,
		//                                        final Throwable error) {
		//                super.onFailureGlobal(statusCode, headers, responseBody, error);
		//                Log.e("CHAT_INFO", "Failed.");
		//                Log.d("CHAT_INFO", new String(responseBody));
		//            }
		//
		//            @Override
		//            public void onFinishGlobal() {
		//                super.onFinishGlobal();
		//            }
		////        }.invokeGet();
		//        }.invokeGet(ChatinfoActivity.this);
	}

	private fun updatePages() {
		// Members
		val membersFragment = MembersFragment(chat!!, this, userList)

		val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
		viewPagerAdapter.addFragment(membersFragment, "Members")
		viewpager!!.adapter = viewPagerAdapter
		Log.d("MemberList", "ViewPager set")
	}

	private fun updateChatDetail() {
		//
		//        this.chatNameTextView.setText(CurrentChat.INSTANCE.getCurrentChat().getName());
		//        this.chatDescTextVIew.setText(CurrentChat.INSTANCE.getCurrentChat().getDesc());
	}

	override fun onCreateOptionsMenu(menu: Menu): Boolean {
		this.menuInflater.inflate(R.menu.chatinfo_menu, menu)
		return true
	}

	@SuppressLint("ResourceAsColor")
	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		when (item.itemId) {
			id.home -> super.onBackPressed()
			id.chatInfo_notifications -> Toast.makeText(this, "Notification Settings coming soon!!",
					Toast.LENGTH_SHORT
			).show()
			id.chatInfo_leavechat -> {
				val alertDialogBuilder = Builder(this)
				alertDialogBuilder.setTitle(Html.fromHtml("<font color='#FF7F27'>Are you sure you want to leave?</font>"))
				Log.d("Delete", "we got here")
				alertDialogBuilder.setPositiveButton("Yes") { dialog, which ->
					//                        final RequestParams params = new RequestParams();
					//                        params.put("chat_id", ChatinfoActivity.this.chat.getObjectIdentifier());
					//                        params.put("user_id", ECUser.getCurrentUser().getObjectIdentifier());
					val progress = indeterminateProgressDialog("Leaving Chat")
					progress.show()
					try {
						Chat_userApi().chatUserDeleteAsync(
								CurrentUser.currentUser!!.id!!.toString(),
								chat!!.id!!.toString(),
								object : ApiCallback<LogoutView> {
									override fun onFailure(e: ApiException,
														   statusCode: Int,
														   responseHeaders: Map<String, List<String>>) {
										progress.dismiss()
										Log.d("Delete", CurrentUser.currentUser!!.id!!.toString() + ", " + chat!!.id!!.toString())
										Log.d(
												"Delete",
												"Fail " + e.responseBody
										)

										runOnUiThread({
											alert("You are the last admin", "Failed to leave chat") {
												positiveButton("OK") {
												}
											}.show()
										})
									}

									override fun onSuccess(result: LogoutView?,
														   statusCode: Int,
														   responseHeaders: Map<String, List<String>>) {
										Log.d("Delete", "Success ")
										progress.dismiss()
										runOnUiThread({
											alert("", "You have left the chat") {
												positiveButton("OK") {
													val intent = Intent(baseContext, ChatListActivity::class.java)
													finish()
													startActivity(intent)
												}
											}.show()
										})

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


				alertDialogBuilder.setNegativeButton("No") { dialog, which ->
					Toast.makeText(this@ChatinfoActivity.baseContext, "You are awesome",
							Toast.LENGTH_SHORT
					).show()
				}
				val alertDialog = alertDialogBuilder.create()
				alertDialog.show()
			}

			id.chatInfo_deletechat -> {
				val alertDialogBuilder1 = Builder(this)
				if (CreateChatActivity.adminUser != null && CurrentUser.currentUser!!.firstName != CreateChatActivity.adminUser!!.firstName) {
					alertDialogBuilder1.setTitle(getString(R.string.restricted_access))
					val alertDialog1 = alertDialogBuilder1.create()
					alertDialog1.show()
				} else {
					alertDialogBuilder1.setTitle(Html.fromHtml("<font color='#FF7F27'>Are you sure you want to delete the chat?</font>"))
					Log.d("Delete", "we got here")
					alertDialogBuilder1.setPositiveButton("Yes") { _, _ ->
						val deleteProgress = indeterminateProgressDialog("Deleting chat")
						deleteProgress.show()
						try {
							ChatApi().chatDeleteAsync(
									chat!!.id.toString(),
									object : ApiCallback<LogoutView> {
										override fun onFailure(e: ApiException,
															   statusCode: Int,
															   responseHeaders: Map<String, List<String>>?) {
											deleteProgress.dismiss()
											Log.d(
													"Delete Chat",
													"Fail " + e.responseBody
											)
											runOnUiThread({
												alert(e.responseBody, "Failed to delete chat") {
													positiveButton("OK") {
													}
												}.show()
											})

										}

										override fun onSuccess(result: LogoutView?,
															   statusCode: Int,
															   responseHeaders: Map<String, List<String>>?) {
											deleteProgress.dismiss()
											Log.d("Delete Chat", "Success ")
											runOnUiThread({
												alert("", "Chat Deleted") {
													positiveButton("OK") {
														val intent = Intent(baseContext, ChatListActivity::class.java)
														finish()
														startActivity(intent)
													}
												}.show()
											})

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

					alertDialogBuilder1.setNegativeButton("No") { dialog, which ->
						Toast.makeText(
								this@ChatinfoActivity.baseContext,
								"Chat is not deleted",
								Toast.LENGTH_SHORT
						).show()
					}
					val alertDialog1 = alertDialogBuilder1.create()
					alertDialog1.show()
				}
			}

			id.chatInfo_editname -> {
				alert("", "Enter the new chat name"){
					customView {
						var editText = editText()
						editText.singleLine = true
						editText.setTextColor(R.color.Black)
						positiveButton("Done"){
							chatRefresh = true
							var data = APIViewChatSerializer()
							data.name = editText.text.toString()
							ChatApi().chatPartialUpdateAsync(chat!!.id.toString(), data, object: ApiCallback<ChatUpdateDestroyView>{
								override fun onFailure(e: ApiException?, statusCode: Int, responseHeaders: MutableMap<String, MutableList<String>>?) {
									Log.d("ChatUpdate", e!!.responseBody)
								}

								override fun onSuccess(result: ChatUpdateDestroyView?, statusCode: Int, responseHeaders: MutableMap<String, MutableList<String>>?) {
									chat = result!!.results
									runOnUiThread{
										supportActionBar!!.title = result.results.name
									}
								}

								override fun onUploadProgress(bytesWritten: Long, contentLength: Long, done: Boolean) {
								}

								override fun onDownloadProgress(bytesRead: Long, contentLength: Long, done: Boolean) {
								}

							})
						}

						negativeButton("Cancel"){}
					}

				}.show()
			}
			else -> {
			}
		}

		//super.onOptionsItemSelected(item);
		return super.onOptionsItemSelected(item)
	}

	private class ViewPagerAdapter internal constructor(manager: FragmentManager) : FragmentPagerAdapter(manager) {

		private val mFragmentList = ArrayList<Fragment>()
		private val mFragmentTitleList = ArrayList<String>()

		override fun getItem(position: Int): Fragment {
			return this.mFragmentList[position]
		}

		override fun getCount(): Int {
			return this.mFragmentList.size
		}

		override fun getPageTitle(position: Int): CharSequence {
			return this.mFragmentTitleList[position]
		}

		internal fun addFragment(fragment: Fragment, title: String) {
			this.mFragmentList.add(fragment)
			this.mFragmentTitleList.add(title)
		}
	}
}

//    private List<ChatResource> parseEventList(final JSONObject response) {
//        try {
//            final JSONArray messages = response.getJSONArray("message");
//            for (int i = 0; i < messages.length(); i++) {
//                final JSONObject message = messages.getJSONObject(i);
//                if (!message.isNull("event")) {
//                    final JSONObject eventObj = message.getJSONObject("event");
//                    final ChatResource eventResource = new ChatEventResource(
//                            eventObj.getInt("id"),
//                            eventObj,
//                            this.userTable.get(
//                                    message.getString(
//                                            "user"))
//                    );
//                    if (!message.isNull("comment_count")) {
//                        eventResource.setCommentCount(message.getInt("comment_count"));
//                    }
//                    result.add(eventResource);
//                }
//            }
//        } catch (final JSONException e) {
//            e.printStackTrace();
//        }
//        return new ArrayList<>();
//    }

//    private List<ChatResource> parseFileList(final JSONObject response) {
//        try {
//            final JSONArray messages = response.getJSONArray("message");
//            for (int i = 0; i < messages.length(); i++) {
//                final JSONObject message = messages.getJSONObject(i);
//                if (!message.isNull("file")) {
//                    final JSONObject fileObj = message.getJSONObject("file");
////                    final ChatResource fileResource = new ChatFileResource(
////                            fileObj.getInt("id"),
////                            fileObj,
////                            this.userTable.get(
////                                    message.getString(
////                                            "user"))
////                    );
//                    if (!message.isNull("comment_count")) {
//                        fileResource.setCommentCount(message.getInt("comment_count"));
//                    }
//                    result.add(fileResource);
//                }
//            }
//        } catch (final JSONException e) {
//            e.printStackTrace();
//        }
//        return new ArrayList<>();
//    }


