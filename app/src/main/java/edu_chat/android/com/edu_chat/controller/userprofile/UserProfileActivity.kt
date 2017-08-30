package edu_chat.android.com.edu_chat.controller.userprofile


import android.Manifest
import android.R.id
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Typeface
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityCompat.startActivityForResult
import android.support.v4.content.ContextCompat
import android.support.v4.content.FileProvider
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View.OnClickListener
import android.view.inputmethod.InputMethodManager
import android.widget.*
import chat.edu.edu_chat.R
import chat.edu.edu_chat.R.drawable
import chat.edu.edu_chat.R.id.area_of_study_grid_view
import chat.edu.edu_chat.R.id.profile_tag_grid_view
import chat.edu.edu_chat.R.layout
import com.google.android.gms.internal.nu
import com.instabug.library.InstabugTrackingDelegate
import com.squareup.picasso.Picasso
import edu_chat.android.com.edu_chat.adapter.userprofile.TagsGridViewAdapter
import edu_chat.android.com.edu_chat.model.CurrentUser
import edu_chat.android.com.edu_chat.view.CircleTransform
import edu_chat.android.com.edu_chat.view.SelectPicPopupWindow
import io.swagger.client.ApiCallback
import io.swagger.client.ApiException
import io.swagger.client.api.FileApi
import io.swagger.client.api.TagApi
import io.swagger.client.api.UserApi
import io.swagger.client.model.*
import kotlinx.android.synthetic.main.activity_user_profile_new.*
import kotlinx.coroutines.experimental.delay
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.doAsyncResult
import org.jetbrains.anko.indeterminateProgressDialog
import java.io.File
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by yuandali on 7/7/16.
 * Edu.Chat Inc.
 */
class UserProfileActivity : AppCompatActivity() {
	private var tempimageFile: File? = null
	private var user_id: Int = 0
	private var user: UserSerializer? = null
	private var menuWindow: SelectPicPopupWindow? = null
	private var isDone = false
	private var isDoneTags = false
	private var mUserAOSList: MutableList<String> = ArrayList()
	private var mUserTagList: MutableList<TagSerializer> = ArrayList()
	private var mRemovedTagList: MutableList<TagSerializer> = ArrayList()
    private var REQUEST_EXTERNAL_STORAGE = 1;
    private var REQUEST_CAMERA = 2;
    private var PERMISSIONS_STORAGE = Array(2, {Manifest.permission.READ_EXTERNAL_STORAGE
        Manifest.permission.WRITE_EXTERNAL_STORAGE})
	private var picFile: File? = null

	override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
		InstabugTrackingDelegate.notifyActivityGotTouchEvent(ev, this)
		return super.dispatchTouchEvent(ev)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		this.setContentView(layout.activity_user_profile_new)
		val type = Typeface.createFromAsset(this.assets, "HelveticaNeue.ttf")
		this.user_name_textview!!.typeface = type
		this.setSupportActionBar(user_profile_toolbar)
		if (this.supportActionBar != null) {
			this.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
			this.supportActionBar!!.setTitle(R.string.edit_profile)
		}
		if (intent != null) {
			this.user_id = intent.getIntExtra(
					"user_id",
					CurrentUser.currentUser!!.id!!
			)
			Log.d("Update", "user_id " + this.user_id)
			user = CurrentUser.currentUser
			Log.d("User", "User: " + user!!.firstName + " " + user!!.lastName + " " + user!!.id)
			if (user!!.areasOfStudy != null) {
				mUserAOSList = user!!.areasOfStudy
			} else {
				mUserAOSList = ArrayList()
			}
			if (user!!.tags != null) {
				mUserTagList = user!!.tags
			} else {
				mUserTagList = ArrayList()
			}
			updateUserData()

			this@UserProfileActivity.area_of_study_grid_view!!.adapter = TagsGridViewAdapter(context, user!!, AOS, true)
			area_of_study_grid_view!!.onItemClickListener = AdapterView.OnItemClickListener { _, view, pos, _ ->
				if (view.findViewById<TextView>(R.id.tag_name).text.toString() != getString(R.string.empty_list_grid_view)) {
					mUserAOSList.removeAt(pos)
					area_of_study_grid_view!!.adapter = TagsGridViewAdapter(context, mUserAOSList, true)
				}
			}
			this@UserProfileActivity.areas_of_study_edit_button!!.setOnClickListener {
				Toast.makeText(this@UserProfileActivity, "Adding AoS activty not yet designed", Toast.LENGTH_LONG).show()
			}

//			For testing adding tags
//			val tagUser = UserTagSerializer()
//			tagUser.user = user!!.id
//			tagUser.tagStr = "ComputerScience"
//			TagApi().tagUserCreateAsync(tagUser, object: ApiCallback<UserTagView> {
//				override fun onSuccess(result: UserTagView?, statusCode: Int, responseHeaders: MutableMap<String, MutableList<String>>?) {
//					Log.d("Update", "Update successful " + result.toString())
//					mUserTagList = user!!.tags
//				}
//
//				override fun onFailure(e: ApiException?, statusCode: Int, responseHeaders: MutableMap<String, MutableList<String>>?) {
//					Log.d("Update", "Update failed")
//					Log.d("Update", user!!.toString())
//				}
//
//				override fun onUploadProgress(bytesWritten: Long, contentLength: Long, done: Boolean) {}
//				override fun onDownloadProgress(bytesRead: Long, contentLength: Long, done: Boolean) {}
//			})

			this@UserProfileActivity.profile_tag_grid_view!!.adapter = TagsGridViewAdapter(context, user!!, TAGS, true)
			profile_tag_grid_view!!.onItemClickListener = AdapterView.OnItemClickListener { _, view, pos, _ ->
				if (view.findViewById<TextView>(R.id.tag_name).text.toString() != getString(R.string.empty_list_grid_view)) {
					mRemovedTagList.add(mUserTagList[pos])
					mUserTagList.removeAt(pos)
					val mUserTagListString = ArrayList<String>()
					if (!mUserTagList.isEmpty()) {
						val tagIter = mUserTagList.iterator()
						do {
							val currTag = tagIter.next().tag
							Log.d("Update", "Tag list: " + currTag)
							mUserTagListString.add(currTag)
						} while (tagIter.hasNext())
					}
					profile_tag_grid_view!!.adapter = TagsGridViewAdapter(context, mUserTagListString, true)
				}
			}

		} else {
			user = CurrentUser.currentUser
			this.user_id = user!!.id!!
		}

		val itemOnClick = OnClickListener {
			menuWindow!!.dismiss()
			when (it.id) {
				R.id.btn_take_photo -> takePhoto()
				R.id.btn_pick_photo -> pickphoto()
				else -> {
				}
			}
		}
		this.edit_profile_picture_fab!!.isClickable = true
		this.edit_profile_picture_fab!!.setOnClickListener {
			Log.d("upload picture", "poping up")
			menuWindow = SelectPicPopupWindow(this@UserProfileActivity, itemOnClick)
			menuWindow!!.showAtLocation(
					this@UserProfileActivity.window.decorView,
					Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL,
					0,
					0
			)
		}


		this.tags_edit_button!!.setOnClickListener {
			val intent = Intent(this@UserProfileActivity, AddingTagsActivity::class.java)
			intent.putExtra("type", TAGS)
            val tagChoiceModal = indeterminateProgressDialog(getString(R.string.please_wait), "Loading Tags")
            //tagChoiceModal.show()
			startActivityForResult(intent, 600)
            tagChoiceModal.dismiss()
		}

        this.see_more_AoS_button!!.setOnClickListener {
            Toast.makeText(this, "Seeing More AoS", Toast.LENGTH_SHORT).show()
        }

        this.see_more_tags_button!!.setOnClickListener {
            Toast.makeText(this, "Seeing More Tags", Toast.LENGTH_SHORT).show()
        }

        val currYear = Calendar.getInstance().get(Calendar.YEAR)
		val years = arrayOf(currYear.toString(), (currYear+1).toString(), (currYear+2).toString(), (currYear+3).toString(), (currYear+4).toString(), (currYear+5).toString())
		val yearAdapter = ArrayAdapter<String>(this, R.layout.year_spinner_layout, years)
		this.year_of_graduation.adapter = yearAdapter
		//Finds position in array by subtracting current year
		val arrayPos = (this.user?.yearOfGraduation?.minus(currYear))
		if (arrayPos in 0..5) {
			this.year_of_graduation.setSelection((this.user!!.yearOfGraduation - currYear))
		} else {
			Toast.makeText(this, getString(R.string.expired_grad_year), Toast.LENGTH_LONG).show()
			this.year_of_graduation.setSelection(currYear)
		}
		save_profile_button!!.setOnClickListener {
			Log.d("Update", "Save button selected")
			saveAllChanges()
			finish()
		}
	}

	private fun saveAllChanges() {
		var progress = indeterminateProgressDialog("Saving changes")
		progress.setCanceledOnTouchOutside(false)
		progress.show()

		val update = UserUpdateSerializer()
		val inputManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
		inputManager.hideSoftInputFromWindow(year_of_graduation!!.windowToken, 0)

		if (year_of_graduation!!.selectedItem == null) {
			Toast.makeText(context, getString(R.string.please_enter_grad_year), Toast.LENGTH_LONG).show()
			return
		}
		val newGraduation = Integer.valueOf(this@UserProfileActivity.year_of_graduation!!.selectedItem.toString())
		Log.d("User", "Selected grad year: " + newGraduation)
		if (newGraduation < Calendar.getInstance().get(Calendar.YEAR) || newGraduation > Calendar.getInstance().get(Calendar.YEAR) + 6) {
			Toast.makeText(context, getString(R.string.please_enter_grad_year), Toast.LENGTH_LONG).show()
			return
		}
		update.yearOfGraduation = newGraduation
		update.areasOfStudy = mUserAOSList

		if (!mRemovedTagList.isEmpty()) {
			val tagIterator = mRemovedTagList.iterator()
			do {
				val currTag = tagIterator.next()
				doAsync { TagApi().tagUserDelete(user!!.id.toString(), currTag.id.toString()) }
				Log.d("Tag", "Deleting: " + currTag.toString())
			} while (tagIterator.hasNext())
		}

		doAsync{
			if (tempimageFile!=null){
				val result = FileApi().fileCreate("Test", tempimageFile).results
				update.pictureFile = result.id
				CurrentUser.currentUser = doAsyncResult{
					UserApi().userPartialUpdate(user!!.id.toString(), update)
				}.get().results
				progress.dismiss()
			}

			else{
				CurrentUser.currentUser = doAsyncResult{
					UserApi().userPartialUpdate(user!!.id.toString(), update)
				}.get().results
				progress.dismiss()
			}

		}


		mRemovedTagList.clear()
//		try {
//			TagApi().tagUserCreateAsync(updateTags, object : ApiCallback<UserTagView> {
//				override fun onFailure(e: ApiException, statusCode: Int, responseHeaders: Map<String, List<String>>) {
//					Log.d("Update", "update failed")
//					Log.d("Update", user!!.toString())
//					Log.d("Update", "Update failed " + updateTags.toString())
//					e.printStackTrace()
//					isDoneTags = true
//				}
//
//				override fun onSuccess(result: UserTagView, statusCode: Int, responseHeaders: Map<String, List<String>>) {
//					Log.d("Update", "Update successful " + updateTags.toString())
//					isDoneTags = true
//				}
//
//				override fun onUploadProgress(bytesWritten: Long, contentLength: Long, done: Boolean) {}
//				override fun onDownloadProgress(bytesRead: Long, contentLength: Long, done: Boolean) {}
//			})
//		} catch (e: ApiException) {
//			Log.d("Update", "ApiException")
//			e.printStackTrace()
//			Toast.makeText(context, R.string.update_failed_try_later, Toast.LENGTH_LONG).show()
//			return
//		}
	}

	private fun takePhoto() {

		if (ContextCompat.checkSelfPermission(
				this,
				android.Manifest.permission.CAMERA
		) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(
				this,
				android.Manifest.permission
						.WRITE_EXTERNAL_STORAGE
		) == PackageManager.PERMISSION_GRANTED) {
			Log.i("Checkpermission", "this is a good machine")
			val imageFilePath = File(this.filesDir, "images")
			tempimageFile = File(imageFilePath, System.currentTimeMillis().toString() + ".jpg")

			if (!tempimageFile!!.parentFile.exists()) {
				tempimageFile!!.parentFile.mkdir()
			}
			val imageFileUri = FileProvider.getUriForFile(
					this,
					"chat.edu.android.com.edu_chat" + "" +
							".fileprovider",
					tempimageFile
			)

			val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
			intent.putExtra(MediaStore.EXTRA_OUTPUT, imageFileUri)
			startActivityForResult(intent, 200)
		} else {
			ActivityCompat.requestPermissions(
					this,
					arrayOf(android.Manifest.permission.CAMERA, android.Manifest.permission
							.WRITE_EXTERNAL_STORAGE),
					100
			)
		}

        //val i = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        //verifyStoragePermissionsForPhotoCapture(this, i)

	}

    fun verifyStoragePermissionsForPhotoCapture(activity: Activity, intent: Intent) {
        // Check if we have write permission
        var permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        // We don't have permission so prompt the user
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE
            )
        }

        var permissionCamera = ActivityCompat.checkSelfPermission(activity, Manifest.permission.CAMERA);

        if(permissionCamera != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(
                    this, Array(Manifest.permission.CAMERA.toString().length) {Manifest.permission.CAMERA}, REQUEST_CAMERA
            )
        }

        val ACTIVITY_TAKE_PHOTO = 200
        this@UserProfileActivity.startActivityForResult(intent, ACTIVITY_TAKE_PHOTO)
    }

    fun verifyStoragePermissionsForStoredPhoto(activity: Activity, intent: Intent) {
        // Check if we have write permission
        var permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        // We don't have permission so prompt the user
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE
            )
        }
        val ACTIVITY_SELECT_IMAGE = 300
        this@UserProfileActivity.startActivityForResult(intent, ACTIVITY_SELECT_IMAGE)
    }

	private fun pickphoto() {
        val i = Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.INTERNAL_CONTENT_URI
        )
        verifyStoragePermissionsForStoredPhoto(this, i)
	}

	private fun updateUserData() {
		if (this.user == null) return
		Log.d("UserProfile", this.user!!.toString())
		this.runOnUiThread {
			this@UserProfileActivity.user_name_textview!!.setText("${user!!.firstName} ${user!!.lastName}")
			//Finds the array position by subracting current year
			this@UserProfileActivity.year_of_graduation!!.setSelection(user!!.yearOfGraduation - Calendar.getInstance().get(Calendar.YEAR))
			area_of_study_grid_view!!.adapter = TagsGridViewAdapter(context, CurrentUser.currentUser!!, AOS, true)
			profile_tag_grid_view!!.adapter = TagsGridViewAdapter(context, CurrentUser.currentUser!!, TAGS, true)
			Log.d("picture", "URL " + user!!.pictureFile.url)
			Picasso.with(this@UserProfileActivity.baseContext)
					.load(CurrentUser.currentUser!!.pictureFile.url)
					.error(drawable.educhat)
					.fit()
					.transform(CircleTransform(null))
					.into(this@UserProfileActivity.user_picture_imageview)
		}
	}

	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		if (item.itemId == id.home) {
			Log.d("UpNav", "Up navigation selected. Mimicking back navigation")
			this.onBackPressed()
			finish()
		}
		return super.onOptionsItemSelected(item)
	}

	override fun finish() {
		val editor = this.getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE).edit()
		editor.putString("activity", "Activity")
		editor.apply()
		super.finish()
	}

	//Modified Daniel Cancelmo's code for UserProfile
	private val context: Context
		get() = this

	/*
    Old try for check the permission
     */
	//    private boolean isCameraUseable() {
	//        boolean canUse = true;
	//        Camera camera = null;
	//        try {
	//            camera = Camera.open();
	//            Camera.Parameters mParameters = camera.getParameters();
	//            camera.setParameters(mParameters);
	//        } catch (Exception e) {
	//            canUse = false;
	//        }
	//        if (camera != null) {
	//            camera.release();
	//        }
	//        return canUse;
	//    }

	override fun onActivityResult(requestCode: Int, resultCode: Int, imageintent: Intent?) {
		if (resultCode == Activity.RESULT_OK) {
			when (requestCode) {
                143 -> {
                    val selectedImageUri = imageintent!!.data
                    var result = ""
                    val cursor = contentResolver.query(selectedImageUri, null, null, null, null)
                    if (cursor == null){
                        Log.d("Filezzz", "cursor is null")
                        result = selectedImageUri.path
                    }
                    else{
                        cursor.moveToFirst()
                        val index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA)
                        result = cursor.getString(index)
                        cursor.close()
                    }
                    tempimageFile = File(result)
                    user_picture_imageview!!.setImageURI(imageintent!!.data)
                }
				200 -> {
                    val selectedImageUri = imageintent!!.data
                    var result = ""
                    val cursor = contentResolver.query(selectedImageUri, null, null, null, null)
                    if (cursor == null){
                        Log.d("Filezzz", "cursor is null")
                        result = selectedImageUri.path
                    }
                    else{
                        cursor.moveToFirst()
                        val index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA)
                        result = cursor.getString(index)
                        cursor.close()
                    }
                    tempimageFile = File(result)
                    user_picture_imageview!!.setImageURI(imageintent!!.data)
                }
				300 -> {
                    val selectedImageUri = imageintent!!.data
                    var result = ""
                    val cursor = contentResolver.query(selectedImageUri, null, null, null, null)
                    if (cursor == null){
                        Log.d("Filezzz", "cursor is null")
                        result = selectedImageUri.path
                    }
                    else{
                        cursor.moveToFirst()
                        val index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA)
                        result = cursor.getString(index)
                        cursor.close()
                    }
                    tempimageFile = File(result)
                    user_picture_imageview!!.setImageURI(imageintent!!.data)
                }
				400 -> {
					val profileimage = imageintent!!.getParcelableExtra<Bitmap>("data")
					showToast(profileimage)
					try {
						tempimageFile!!.delete()
					} catch (e: Exception) {
						e.printStackTrace()
					}

				}
			//Adding AoS
				500 -> {
					//TODO
				}
			//Adding tags
				600 -> {
					//TODO
				}
			}
		}
	}

//	override fun onRequestPermissionsResult(requestCode: Int,
//											permissions: Array<String>,
//											grantResults: IntArray) {
//		if (requestCode == 100) {
//			val imageFilePath = File(this.filesDir, "images")
//			val imageFile = File(imageFilePath, System.currentTimeMillis().toString() + ".jpg")
//			if (!imageFile.parentFile.exists()) {
//				imageFile.parentFile.mkdir()
//			}
//			val imageFileUri = FileProvider.getUriForFile(
//					this,
//					"chat.edu.android.com.edu_chat" + "" +
//							".fileprovider",
//					imageFile
//			)
//			val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//			intent.putExtra(MediaStore.EXTRA_OUTPUT, imageFileUri)
//			startActivityForResult(intent, 200)
//		} else {
//			Log.e("permission error", "It was rejected by the user")
//			finish()
//		}
//	}

	private fun crop(uri: Uri) {
		val intent = Intent("com.android.camera.action.CROP")
		intent.setDataAndType(uri, "image/*")
		intent.putExtra("crop", "true")
		intent.putExtra("aspectX", 1)
		intent.putExtra("aspectY", 1)
		intent.putExtra("outputX", 250)
		intent.putExtra("outputFormat", "JPEG")
		intent.putExtra("noFaceDetection", true)
		intent.putExtra("return-data", true)
		startActivityForResult(intent, 400)
	}

	private fun showToast(bitmap: Bitmap) {
		val toast = Toast(this)
		val img = ImageView(this)
		img.setImageBitmap(bitmap)
		toast.view = img
		toast.show()
	}

	private fun updateUserProfile() {
		/*
        final RequestParams params = new RequestParams();
        params.put("id", this.user_id);
        final GetUserProfileObject getUserProfileObject = new GetUserProfileObject(params) {
            @Override
            public void onSuccessGlobal(final int statusCode, final Header[] headers, @NonNull
            final byte[]
                    responseBody) {
                super.onSuccessGlobal(statusCode, headers, responseBody);
                Log.d("User Profile", "success " + new String(responseBody));
                try {
                    final JSONObject obj = new JSONObject(new String(responseBody));
                    UserProfileActivity.this.userDataObj = obj.getJSONObject("user");
                } catch (final JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(UserProfileActivity.this.getBaseContext(), "Cannot get user " +
                            "profile.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailureGlobal(final int statusCode, final Header[] headers, @NonNull
            final byte[] responseBody, final Throwable error) {
                super.onFailureGlobal(statusCode, headers, responseBody, error);
                Log.d("User Profile", "failure " + new String(responseBody));
                Toast.makeText(UserProfileActivity.this.getBaseContext(), "Server has no response"
                        + ". Try again later.", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFinishGlobal() {
                super.onFinishGlobal();
                UserProfileActivity.this.updateUserData();
            }
        };
        getUserProfileObject.invokeGet(UserProfileActivity.this);
        */
	}

	companion object {

		private val MY_PREFS_NAME = "MyPrefsFile"
		private val TAGS = 't'
		private val AOS = 'a'

	}

}