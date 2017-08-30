package edu_chat.android.com.edu_chat.controller.chat_list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.TabLayout
import android.support.v4.app.FragmentTransaction
import android.support.v4.view.GravityCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import chat.edu.edu_chat.R
import chat.edu.edu_chat.R.id
import chat.edu.edu_chat.R.layout
import com.instabug.library.Instabug
import com.instabug.library.InstabugTrackingDelegate
import com.squareup.picasso.Picasso
import edu_chat.android.com.edu_chat.adapter.chat_list.ViewPagerAdapter
import edu_chat.android.com.edu_chat.controller.chat_create.CreateChatActivity
import edu_chat.android.com.edu_chat.controller.settings.SettingsActivity
import edu_chat.android.com.edu_chat.controller.userprofile.UserProfileActivity
import edu_chat.android.com.edu_chat.model.CurrentUser
import edu_chat.android.com.edu_chat.view.CircleTransform
import io.swagger.client.ApiCallback
import io.swagger.client.ApiException
import io.swagger.client.api.ChatApi
import io.swagger.client.api.InstitutionApi
import io.swagger.client.model.ChatListCreateView
import io.swagger.client.model.UniversityView
import kotlinx.android.synthetic.main.main_activity_layout.*


/**
 * This activity will act as a container for the recycler views for the individual chats and
 * classes.
 * Created by Jacob on 10/16/2015.
 */

class ChatListActivity : AppCompatActivity() {

	override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
		InstabugTrackingDelegate.notifyActivityGotTouchEvent(ev, this)
		return super.dispatchTouchEvent(ev)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		this.setContentView(layout.main_activity_layout)

		tab_layout!!.addTab(tab_layout!!.newTab().setCustomView(tab_classes_view))
		tab_layout!!.addTab(tab_layout!!.newTab().setCustomView(tab_chats_view))
		tab_layout!!.tabGravity = TabLayout.GRAVITY_FILL


		view_pager.adapter = ViewPagerAdapter(supportFragmentManager, tab_layout!!.tabCount)

		this.populateNavDrawer()
		this.searchbutton!!.setOnClickListener {
			Log.d("searchview", "jump to searchview")
			val searchViewFragment: SearchViewFragment = SearchViewFragment()
			val ft: FragmentTransaction = this.supportFragmentManager.beginTransaction()
			ft.replace(id.main_frame, searchViewFragment)
			ft.addToBackStack(null)
			ft.commit()
		}

		notification_one!!.visibility = View.INVISIBLE
		notification_two!!.visibility = View.INVISIBLE
		setNoContentMessage(0)
		populateActionFloatingMenu()
		setNotificationNumber(0)
//		setNotificationNumber(1)
		tab_classes_view!!.alpha = 1.0.toFloat()
		tab_chats_view!!.alpha = 0.6.toFloat()

		view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))
		tab_layout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
			override fun onTabSelected(tab: TabLayout.Tab) {
				view_pager.currentItem = tab.position
				Log.d("ChatListActivity", "tab position is ${tab.position}")
				setNotificationNumber(tab.position)
				setNoContentMessage(tab.position)
			}

			override fun onTabUnselected(tab: TabLayout.Tab) {}

			override fun onTabReselected(tab: TabLayout.Tab) {}
		})

	}

	private fun setNoContentMessage(position: Int) {
		when (position) {
			0 -> {
				main_no_classes_frame.visibility = View.VISIBLE
				main_no_chats_frame.visibility = View.GONE
				if (CurrentUser.currentUser!!.type == "p") main_no_classes_message!!.text = getString(R.string.no_content)
				else main_no_classes_message!!.text = getString(R.string.search_to_join)
			}
			1 -> {
				main_no_classes_frame.visibility = View.GONE
				main_no_chats_frame.visibility = View.VISIBLE
			}
		}
	}

	private fun getNotificationNumber(position: Int) {

		ChatApi().chatListAsync(
				null,
				null,
				null,
				null,
				null,
				position == 1,
				null,
				null,
				null,
				null,
				object : ApiCallback<ChatListCreateView> {
					override fun onFailure(e: ApiException?, statusCode: Int, responseHeaders: MutableMap<String, MutableList<String>>?) = Unit

					override fun onSuccess(
							result: ChatListCreateView?,
							statusCode: Int,
							responseHeaders: MutableMap<String, MutableList<String>>?
					) {
						var hasUnread: Boolean = false

						run breaker@ {
							result!!.results.chats
									.filter { it.unreadCount != 0 && it.unreadCount != null }
									.forEach {
										hasUnread = true
										return@breaker
									}
						}

						when (position) {
							0 -> {
								if (!hasUnread) {
									runOnUiThread({ notification_two!!.visibility = View.GONE })
								} else {
									runOnUiThread({
										notification_two!!.visibility = View.VISIBLE
										notification_two!!.bringToFront()
									})
								}
							}
							1 -> {
								if (!hasUnread) {
									runOnUiThread({ notification_one!!.visibility = View.GONE })
								} else {
									runOnUiThread({
										notification_one!!.visibility = View.VISIBLE
										notification_one!!.bringToFront()
									})
								}
							}
						}

					}

					override fun onUploadProgress(bytesWritten: Long, contentLength: Long, done: Boolean) = Unit

					override fun onDownloadProgress(bytesRead: Long, contentLength: Long, done: Boolean) = Unit

				}
		)
	}


	private fun setNotificationNumber(position: Int) {
		when (position) {
			0 -> {
				tab_classes_view!!.alpha = 1.0.toFloat()
				tab_chats_view!!.alpha = 0.6.toFloat()
				notification_one!!.visibility = View.GONE
				getNotificationNumber(position)
			}
			1 -> {
				tab_classes_view!!.alpha = 0.6.toFloat()
				tab_chats_view!!.alpha = 1.0.toFloat()
				notification_two!!.visibility = View.GONE
				getNotificationNumber(position)
			}
		}

	}

	override fun onPostResume() {
		super.onPostResume()
		Log.d("PKAB", "resume")
	}

	private fun populateNavDrawer() {
		this.hamburger_menu!!.bringToFront()
		this.hamburger_menu!!.setOnClickListener {
			Log.d("Successful", "clickable")
			this@ChatListActivity.drawer_layout_new!!.openDrawer(findViewById<View>(id.drawerPane_new))
		}
		val navigationView = this.findViewById<NavigationView>(id.nav_view_new)
		val headerView = navigationView.getHeaderView(0)
		val navUserPicture = headerView.findViewById<ImageView>(id.nav_user_picture)
		val navUserName = headerView.findViewById<TextView>(id.nav_user_name)
		val navUniversityName = headerView.findViewById<TextView>(id.nav_university_name)
		Picasso.with(this.baseContext)
				.load(CurrentUser.currentUser!!.pictureFile.url)
				.error(R.drawable.educhat)
				.fit()
				.transform(CircleTransform(null))
				.into(navUserPicture)
		navUserName.text = "${CurrentUser.currentUser!!.firstName} ${CurrentUser.currentUser!!.lastName}"
		navUniversityName.text = CurrentUser.currentUser!!.university.toString()
		try {
			InstitutionApi().institutionUniversityListAsync(CurrentUser.currentUser!!.university, null, null, null, null, object : ApiCallback<UniversityView> {
				override fun onFailure(e: ApiException?, statusCode: Int, responseHeaders: MutableMap<String, MutableList<String>>?) {
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
				}

				override fun onSuccess(result: UniversityView?, statusCode: Int, responseHeaders: MutableMap<String, MutableList<String>>?) {
					runOnUiThread({ navUniversityName.text = result!!.results!![0]!!.name })
				}

				override fun onDownloadProgress(bytesRead: Long, contentLength: Long, done: Boolean) {
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
				}

				override fun onUploadProgress(bytesWritten: Long, contentLength: Long, done: Boolean) {
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
				}
			})
		} catch (e: ApiException) {

		}

		nav_view_new!!.setNavigationItemSelectedListener { item: MenuItem ->
			when (item.itemId) {
				id.nav_profile -> {
					val intent = Intent(
							this@ChatListActivity.baseContext, UserProfileActivity::class.java
					)
					intent.putExtra("user_id", CurrentUser.currentUser!!.id)
					this@ChatListActivity.startActivity(intent)
				}
				id.nav_starred -> Toast.makeText(
						this@ChatListActivity, " browse coming soon!!!", Toast.LENGTH_SHORT
				).show()
				id.nav_settings -> {
					val intent = Intent(
							this@ChatListActivity.baseContext,
							SettingsActivity::class.java
					)
					intent.putExtra("user_id", CurrentUser.currentUser!!.id)
					this@ChatListActivity.startActivity(intent)

				}
				id.nav_feedback -> Instabug.invoke()
//				id.nav_logout -> this@ChatListActivity.logOut()
				id.nav_privacy -> {

				}
				id.nav_acknowledgement -> {

				}
			}
			this@ChatListActivity.drawer_layout_new!!.closeDrawer(GravityCompat.START)
			true
		}
	}

	/**
	 * Log the user out and return them back to the loginactivity.
	 */
	//	private fun logOut() {
//		//        this.progressDialog = new ProgressDialog(this);
//		//        this.progressDialog.setMessage(getString(R.string.logging_out_));
//		clearUserData()
//		//        this.progressDialog.setIndeterminate(true);
//		//        this.progressDialog.show();
//		try {
//			ApiApi().apiLogoutCreateAsync(object : ApiCallback<LogoutView> {
//				override fun onFailure(e: ApiException,
//									   statusCode: Int,
//									   responseHeaders: Map<String, List<String>>) {
//					//System.err.println("error, logout not working");
//					Log.d("Logout", "Logout not working")
//					Log.d("Logout", e.responseBody)
//				}
//
//				override fun onSuccess(result: LogoutView,
//									   statusCode: Int,
//									   responseHeaders: Map<String, List<String>>) {
//					//ChatListActivity.this.hideProgressDialog();
//					//                    ChatListActivity.this.progressDialog.dismiss();
//					this@ChatListActivity.finish()
//					Configuration.setDefaultApiClient(ApiClient())
//					val intent = Intent(
//							this@ChatListActivity.applicationContext,
//							LoginActivity::class.java
//					)
//					this@ChatListActivity.startActivity(intent)
//				}
//
//				override fun onUploadProgress(bytesWritten: Long, contentLength: Long, done: Boolean) {
//
//				}
//
//				override fun onDownloadProgress(bytesRead: Long, contentLength: Long, done: Boolean) {
//
//				}
//			})
//		} catch (e: ApiException) {
//			Log.d("Error", "Did not do ApiLogout")
//			e.printStackTrace()
//		}
//	}

	private fun populateActionFloatingMenu() = when (CurrentUser.currentUser!!.type) {
		"p" -> facultyCreate()
		"s" -> studentCreate()
		"a" -> adminCreate()
		else -> Toast.makeText(baseContext, "No user type matched!", Toast.LENGTH_SHORT).show()
	}

	//	private fun facultyCreate() {
//		floatingActionsMenuTest.bringToFront()
//		create_class_fab.setOnClickListener {
//			floatingActionsMenuTest.collapse()
//			val intent = Intent(
//					applicationContext,
//					CreateChatActivity::class.java
//			)
//			intent.putExtra("chatType", "chat")
//			intent.putExtra("isClass", true)
//			closeFAB()
//			this@ChatListActivity.startActivity(intent)
//		}
//
//		create_chat_fab1.setOnClickListener {
//			floatingActionsMenuTest.collapse()
//			val intent = Intent(
//					applicationContext,
//					CreateChatActivity::class.java
//			)
//			intent.putExtra("chatType", "chat")
//			intent.putExtra("isClass", false)
//			closeFAB()
//			this@ChatListActivity.startActivity(intent)
//		}
//
//	}
//
//	private fun studentCreate() {
//		floatingActionsMenuStudentMainTest.bringToFront()
//		create_chat_fab_student.setOnClickListener {
//			floatingActionsMenuStudentMainTest.collapse()
//			val intent = Intent(
//					applicationContext,
//					CreateChatActivity::class.java
//			)
//			intent.putExtra("chatType", "chat")
//			intent.putExtra("isClass", false)
//			closeFAB()
//
//			startActivity(intent)
//		}
//	}
	private fun adminCreate() {
		create_chat_fab_student.visibility = View.GONE
		floatingActionsMenuTest.visibility = View.VISIBLE
		floatingActionsMenuTest.bringToFront()
		create_class_fab.setOnClickListener {
			floatingActionsMenuTest.collapse()
			val intent = Intent(
					applicationContext,
					CreateChatActivity::class.java
			)
			intent.putExtra("chatType", "chat")
			intent.putExtra("isClass", true)
			closeFAB()
			this@ChatListActivity.startActivity(intent)
		}

		create_chat_fab1.setOnClickListener {
			floatingActionsMenuTest.collapse()
			val intent = Intent(
					applicationContext,
					CreateChatActivity::class.java
			)
			intent.putExtra("chatType", "chat")
			intent.putExtra("isClass", false)
			closeFAB()
			this@ChatListActivity.startActivity(intent)
		}

	}
	private fun facultyCreate() {
		create_chat_fab_student.visibility = View.GONE
		floatingActionsMenuTest.visibility = View.VISIBLE
		floatingActionsMenuTest.bringToFront()
		create_class_fab.setOnClickListener {
			floatingActionsMenuTest.collapse()
			val intent = Intent(
					applicationContext,
					CreateChatActivity::class.java
			)
			intent.putExtra("chatType", "chat")
			intent.putExtra("isClass", true)
			closeFAB()
			this@ChatListActivity.startActivity(intent)
		}

		create_chat_fab1.setOnClickListener {
			floatingActionsMenuTest.collapse()
			val intent = Intent(
					applicationContext,
					CreateChatActivity::class.java
			)
			intent.putExtra("chatType", "chat")
			intent.putExtra("isClass", false)
			closeFAB()
			this@ChatListActivity.startActivity(intent)
		}

	}

	private fun studentCreate() {
		floatingActionsMenuTest.visibility = View.GONE
		create_chat_fab_student.visibility = View.VISIBLE
		create_chat_fab_student.bringToFront()
		create_chat_fab_student.setOnClickListener {
			floatingActionsMenuTest.collapse()

			val intent = Intent(
					applicationContext,
					CreateChatActivity::class.java
			)
			intent.putExtra("chatType", "chat")
			intent.putExtra("isClass", false)
			// closeFAB()

			this@ChatListActivity.startActivity(intent)
		}
	}


	private fun closeFAB() {
		floatingActionsMenuTest.collapse()
		//	floatingActionsMenuStudentMainTest.collapse()
	}

	private fun clearUserData() {
		val prefs = getSharedPreferences("login.conf", Context.MODE_PRIVATE)
		val editor = prefs.edit()
		editor.remove("user")
		editor.remove("pass")
		editor.apply()
	}

	override fun onRestart() {
		super.onRestart()
		Log.d("PKAB", "restart")
	}

	override fun onBackPressed() {
		if (this.drawer_layout_new.isDrawerOpen(GravityCompat.START)) {
			this.drawer_layout_new.closeDrawer(GravityCompat.START)
		} else {
			super.onBackPressed()
		}
		Log.d("PKAB", "onback")
	}

	override fun onResume() {
		super.onResume()
		populateNavDrawer()
	}
}

