package edu_chat.android.com.edu_chat.controller.userprofile

import android.R.id
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.widget.Toast
import chat.edu.edu_chat.R
import com.instabug.library.InstabugTrackingDelegate
import com.miguelcatalan.materialsearchview.MaterialSearchView
import edu_chat.android.com.edu_chat.adapter.userprofile.TagFlexBoxAdapter
import edu_chat.android.com.edu_chat.model.CurrentUser
import io.swagger.client.ApiCallback
import io.swagger.client.ApiException
import io.swagger.client.api.TagApi
import io.swagger.client.model.*
import kotlinx.android.synthetic.main.activity_adding_tags.*
import kotlinx.android.synthetic.main.fragment_tags_recycler.*

class AddingTagsActivity : AppCompatActivity() {

	private var searchView: MaterialSearchView? = null
	private var tagsList: MutableList<TagSerializer> = ArrayList()
	private var tagsRecycler: TagsRecyclerFragment? = null
	private var selectedTags: MutableList<TagSerializer> = ArrayList()
	private var isDone = false
	override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
		InstabugTrackingDelegate.notifyActivityGotTouchEvent(ev, this)
		return super.dispatchTouchEvent(ev)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_adding_tags)
		Log.d("Tags", "SearchView")
		searchView = findViewById(R.id.searchview_add_tags)
		isDone = false
		try {
			TagApi().tagListAsync(null, null, object : ApiCallback<TagView> {
				override fun onSuccess(result: TagView?, statusCode: Int, responseHeaders: MutableMap<String, MutableList<String>>?) {
					val foundTag = result!!.results
					Log.d("Tag", "Tags found: " + foundTag.toString())
					Log.d("Tag", "Size: " + foundTag.size)
					tagsList = foundTag
					isDone = true
				}

				override fun onFailure(e: ApiException?, statusCode: Int, responseHeaders: MutableMap<String, MutableList<String>>?) {
					Log.d("Tag", "Tags not found: onFailure")
					isDone = true
					finish()
				}

				override fun onUploadProgress(bytesWritten: Long, contentLength: Long, done: Boolean) {}
				override fun onDownloadProgress(bytesRead: Long, contentLength: Long, done: Boolean) {}
			})
		} catch (e: ApiException) {
			e.printStackTrace()
			Log.d("Tag", "Tags not found: ApiException")
			isDone = true
			finish()
		}
		searchView!!.performClick()
		searchView!!.showSearch(false)
		searchView!!.setBackgroundColor(resources.getColor(R.color.header_new_color))
		searchView!!.setOnSearchViewListener(object : MaterialSearchView.SearchViewListener {
			override fun onSearchViewShown() {}
			override fun onSearchViewClosed() {
				this@AddingTagsActivity.finish()
			}
		})
		while (!isDone) {
			Log.d("Async", "Waiting for async task")
		}
		tagsRecycler = TagsRecyclerFragment()
		supportFragmentManager.beginTransaction().add(R.id.tags_recycler_frame, tagsRecycler).commit()

		searchView!!.setOnQueryTextListener(object : MaterialSearchView.OnQueryTextListener {
			override fun onQueryTextSubmit(query: String): Boolean {
				return false
			}

			override fun onQueryTextChange(newText: String): Boolean {
				if (newText == "") {
					searchView!!.setBackgroundColor(resources.getColor(R.color.header_new_color))
					tagsRecycler!!.updateTags(tagsList)
					return false
				}
				Log.d("Tag", "Query: " + newText)
				searchView!!.setBackgroundColor(0x19ffffff)
				val searchList: MutableList<TagSerializer> = ArrayList()
				if (!tagsList.isEmpty()) {
					val tagIterator: Iterator<TagSerializer> = tagsList.iterator()
					do {
						val currTag: TagSerializer = tagIterator.next()
						//If the current tag iteration contains the query, trimmed of white space and ignoring case
						if ((currTag.tag).toLowerCase().contains(newText.toLowerCase().trim())) {
							Log.d("Tag", "currTag: " + currTag.toString())
							searchList.add(currTag)
						}
					} while (tagIterator.hasNext())
				}
				Log.d("Tag", "" + searchList.toString())
				tagsRecycler!!.updateTags(searchList)
				return false
			}
		})

        save_tag_choices_button!!.setOnClickListener{
            saveTagChoices()
			this@AddingTagsActivity.finish()
		}
	}

	private fun saveTagChoices(){
		selectedTags = (tagsRecycler!!.tags_recycler_view.adapter as TagFlexBoxAdapter).getSelectedTags()
		if (!selectedTags.isEmpty()) {
			val selectedIter = selectedTags.iterator()
			Log.d("TagUpdate", "Size: " + selectedTags.size)
			var count = 0
			do {
				val userTag = UserTagSerializer()
				userTag.user = CurrentUser.currentUser!!.id
				userTag.tagStr = selectedIter.next().tag
				TagApi().tagUserCreateAsync(userTag, object: ApiCallback<UserTagView> {
					override fun onFailure(e: ApiException?, statusCode: Int, responseHeaders: MutableMap<String, MutableList<String>>?) {
						Log.d("Update", "Update failed (Create)")
						Log.d("Update", "Update failed " + userTag.toString())
						e!!.printStackTrace()
						count++
					}

					override fun onSuccess(result: UserTagView?, statusCode: Int, responseHeaders: MutableMap<String, MutableList<String>>?) {
						Log.d("Update", "Update successful (Create)" + result.toString())
						count++
					}

					override fun onUploadProgress(bytesWritten: Long, contentLength: Long, done: Boolean) {}
					override fun onDownloadProgress(bytesRead: Long, contentLength: Long, done: Boolean) {}
				})
			} while (selectedIter.hasNext())
			while(count != selectedTags.size) {
				Log.d("Async", "Waiting for async task...")
			}
		}
		val removedTags = (tagsRecycler!!.tags_recycler_view.adapter as TagFlexBoxAdapter).getRemovedTags()
		if (!removedTags.isEmpty()) {
			val removedIter = removedTags.iterator()
			Log.d("TagUpdate", "Size: " + removedTags.size)
			var count = 0
			do {
				val currTag = removedIter.next()
				TagApi().tagUserDeleteAsync(CurrentUser.currentUser!!.id.toString(), currTag.id.toString(), object : ApiCallback<LogoutView> {
					override fun onFailure(e: ApiException?, statusCode: Int, responseHeaders: MutableMap<String, MutableList<String>>?) {
						Log.d("Update", "Update failed (Delete)")
						Log.d("Update", "Update failed " + currTag.tag.toString())
						e!!.printStackTrace()
						count++
					}

					override fun onSuccess(result: LogoutView?, statusCode: Int, responseHeaders: MutableMap<String, MutableList<String>>?) {
						Log.d("Update", "Update successful (Delete)" + result.toString())
						count++
					}

					override fun onUploadProgress(bytesWritten: Long, contentLength: Long, done: Boolean) {}
					override fun onDownloadProgress(bytesRead: Long, contentLength: Long, done: Boolean) {}
				})
			} while (removedIter.hasNext())
			while(count != removedTags.size) {
				Log.d("Async", "Waiting for async task...")
			}
		}
		Log.d("TagUpdate", "Selected: " + selectedTags.toString())
		Log.d("TagUpdate", "Removed: " + removedTags.toString())
	}

	fun getTagsList(): MutableList<TagSerializer> {
		return tagsList
	}

	override fun onCreateOptionsMenu(menu: Menu): Boolean {
		val inflater = menuInflater
		inflater.inflate(R.menu.tags_search_edit, menu)
		val item = menu.findItem(R.id.search_add_tags)
		searchView!!.setMenuItem(item)
		searchView!!.performClick()
		return true
	}

	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		Log.d("Nav", "Options Item Selected")
		if (item.itemId == id.home) {
			Log.d("Nav", "Up navigation selected")
			setResult(Activity.RESULT_OK)
			finish()
		}
		return super.onOptionsItemSelected(item)
	}

	override fun onBackPressed() {
		Log.d("Nav", "Back navigation selected")
		setResult(Activity.RESULT_OK)
		finish()
	}
}
