package edu_chat.android.com.edu_chat.controller.chat_create

import android.Manifest
import android.R.id
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.Intent.getIntent
import android.content.pm.PackageManager
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.Images.Media
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import chat.edu.edu_chat.R
import chat.edu.edu_chat.R.id.*
import com.google.gson.Gson
import com.instabug.library.InstabugTrackingDelegate
import edu_chat.android.com.edu_chat.controller.invite.InviteActivity
import edu_chat.android.com.edu_chat.model.CurrentUser
import io.swagger.client.ApiCallback
import io.swagger.client.ApiException
import io.swagger.client.api.FileApi
import io.swagger.client.model.ChatSerializer
import io.swagger.client.model.FileCreateView
import io.swagger.client.model.UserSerializer
import kotlinx.android.synthetic.main.activity_create_chat.*
import kotlinx.android.synthetic.main.content_create_chat.*
import org.jetbrains.anko.indeterminateProgressDialog
import org.jetbrains.anko.textColor
import java.io.File
import java.net.URI

/**
 * Created by yuandali on 7/13/16.
 * Edu.Chat Inc.
 */
class CreateChatActivity : AppCompatActivity() {
	private var isSubchat: Boolean = false
	private var isClass: Boolean = false
	private var parentChat: ChatSerializer? = null
	private var isOpen = false
	private var REQUEST_EXTERNAL_STORAGE = 1;
	private var PERMISSIONS_STORAGE = Array(2, {Manifest.permission.READ_EXTERNAL_STORAGE
		Manifest.permission.WRITE_EXTERNAL_STORAGE})
	private var filepath = ""

	override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
		InstabugTrackingDelegate.notifyActivityGotTouchEvent(ev, this)
		return super.dispatchTouchEvent(ev)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		this.setContentView(R.layout.activity_create_chat)
		val toolbar = this.findViewById<Toolbar>(R.id.toolbar)
		this.setSupportActionBar(toolbar)
		this.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
		this.parentChat = Gson().fromJson(
				intent.getStringExtra("ParentChat"),
				ChatSerializer::class.java
		)

		toolbar.setNavigationOnClickListener(View.OnClickListener {
			onBackPressed()
		})

		this.isClass = intent.getBooleanExtra("isClass", false)
		this.isSubchat = intent.getBooleanExtra("isSubchat", false)
		this.setActivityStrings()

		Log.d("Subchat", "CreateChat" + isSubchat)


		if (isClass) {
			this.course_code_editText!!.visibility = View.VISIBLE
			this.checkbox_anonymous!!.visibility = View.GONE
			this.chat_name_editText!!.hint = "Course Name"
			addRedAsterisk(this.course_code_editText)
			addRedAsterisk(this.chat_name_editText)
			addAsteriskToText(this.required_field_text)
		} else if (isSubchat) {
			this.checkbox_anonymous!!.visibility = View.VISIBLE
			this.course_code_editText_frame!!.visibility = View.GONE
			this.chat_name_editText!!.hint = "Subchat Name"
			this.required_field_text!!.visibility = View.GONE
			setCheckBox()
		} else {
			this.course_code_editText_frame!!.visibility = View.GONE
			this.checkbox_anonymous!!.visibility = View.GONE
			this.required_field_text!!.visibility = View.GONE
			this.chat_name_editText!!.hint = "Chat Name"
		}

		setToggle()

		create_chat_layout!!.setOnTouchListener { v, _ ->
			val IM = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
			IM.hideSoftInputFromWindow(v.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
			false
		}
		this.create_chat_check!!.setOnClickListener {
			Log.d("Chat", "Attempting to create chat")
//			adminUser?.firstName(CurrentUser?.currentUser?.firstName)
			adminUser = CurrentUser.currentUser
			val intent = Intent(applicationContext, InviteActivity::class.java)
			intent.putExtra("Name", chat_name_editText!!.text.toString())
			if (!filepath.equals("")){
				intent.putExtra("File", filepath)
			}
			intent.putExtra("isClass", false)
			intent.putExtra("CurrentUsers", getIntent().getStringExtra("CurrentUsers"))
			if (isClass) intent.putExtra("Code", course_code_editText!!.text.toString())
			intent.putExtra("isClass", isClass)
			intent.putExtra("isOpen", isOpen)
			if (isSubchat) {
				intent.putExtra("isSubchat", isSubchat)
				Log.d("ParentUsers", "CreateChat success")
				intent.putExtra("ParentChat", getIntent().getStringExtra("ParentChat"))
				intent.putExtra("ParentUsers", getIntent().getStringExtra("ParentUsers"))
				intent.putExtra("isAnonymous", checkbox_anonymous!!.isChecked)
			}
			startActivity(intent)
		}

		//        this.chat_name_editText.addTextChangedListener(new TextWatcher() {
		//            @Override
		//            public void beforeTextChanged(final CharSequence s, final int start, final int
		//                    count, final int after) {
		//            }
		//
		//            @Override
		//            public void onTextChanged(@NonNull final CharSequence s, final int start,
		//                                      final int before, final int count) {
		//                CreateChatActivity.this.chatNameCountTextView.setText(String.format(
		//                        "%d/21",
		//                        s
		//                                .length()
		//                ));
		//                if (s.length() == 0) {
		//                    CreateChatActivity.this.create_chat_check.setVisibility(View.INVISIBLE);
		//                } else {
		//                    if (CreateChatActivity.this.create_chat_check.getVisibility() == View
		// .INVISIBLE) {
		//                        CreateChatActivity.this.create_chat_check.setVisibility(View.VISIBLE);
		////                        ToggleTickColor((String)create_chat_check.getTag(R.string.checkcolor));
		//                        CreateChatActivity.this.ToggleTickColor();
		//                    }
		//                }
		//            }
		//
		//            @Override
		//            public void afterTextChanged(final Editable s) {
		//            }
		//        });
		//        this.subjectEditText.addTextChangedListener(new TextWatcher() {
		//            @Override
		//            public void beforeTextChanged(final CharSequence s, final int start, final int
		//                    count, final int after) {
		//
		//            }
		//
		//            @Override
		//            public void onTextChanged(final CharSequence s, final int start, final int before,
		//                                      final int count) {
		////                ToggleTickColor((String)create_chat_check.getTag(R.string.checkcolor));
		//                CreateChatActivity.this.ToggleTickColor();
		//            }
		//
		//            @Override
		//            public void afterTextChanged(final Editable s) {
		//
		//            }
		//        });


		//        this.publicSwitch.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		//            @Override
		//            public void onCheckedChanged(final CompoundButton buttonView, final boolean
		// isChecked) {
		//                CreateChatActivity.this.isPublic = CreateChatActivity.this.publicSwitch
		// .isChecked();
		//                CreateChatActivity.this.publicSwitch.setText(CreateChatActivity.this.isPublic ?
		//                                                                     "public" : "private");
		//            }
		//        });

//		Picasso.with(this)
//				.load(R.drawable.ic_group_white_24dp)
//				.into(this.newchat_image)
//		this.photo_button!!.bringToFront()
		this.newchat_image_frame!!.setOnClickListener {
			//                Intent intent = new Intent();
			//                intent.setType("image/*");
			//                intent.setAction(Intent.ACTION_GET_CONTENT);//
			//                startActivityForResult(Intent.createChooser(intent, "Select Picture"),
			// SELECT_IMAGE);
			val i = Intent(
					Intent.ACTION_PICK,
					Media.INTERNAL_CONTENT_URI
			)
			verifyStoragePermissions(this, i)

		}


	}

	private fun setCheckBox() {
		checkbox_anonymous!!.isChecked = false
		checkbox_anonymous!!.setOnClickListener {
			checkbox_anonymous!!.isChecked = !checkbox_anonymous!!.isChecked
		}
	}

	fun verifyStoragePermissions(activity: Activity, intent: Intent) {
    // Check if we have write permission
    var permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
		// We don't have permission so prompt the user
		if (permission != PackageManager.PERMISSION_GRANTED) {
			ActivityCompat.requestPermissions(
				this, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE
			)
        }
		val ACTIVITY_SELECT_IMAGE = 143
		this@CreateChatActivity.startActivityForResult(intent, ACTIVITY_SELECT_IMAGE)
}

	private fun setToggle() {
		switch_open?.background = resources.getDrawable(R.drawable.create_chat_switch_background)
		switch_closed?.setBackgroundColor(Color.parseColor("#549788"))
		switch_open?.textColor = Color.parseColor("#549788")
		switch_closed?.textColor = Color.WHITE
		toggle_open?.visibility = View.GONE
		toggle_closed?.visibility = View.VISIBLE

		switch_open?.setOnClickListener {
			if (isOpen) {
				isOpen = false
				switch_open?.background = resources.getDrawable(R.drawable.create_chat_switch_background)
				switch_closed?.setBackgroundColor(Color.parseColor("#549788"))
				switch_open?.textColor = Color.parseColor("#549788")
				switch_closed?.textColor = Color.WHITE
				toggle_open?.visibility = View.GONE
				toggle_closed?.visibility = View.VISIBLE
			} else {
				isOpen = true
				switch_open?.setBackgroundColor(Color.parseColor("#549788"))
				switch_closed?.background = resources.getDrawable(R.drawable.create_chat_switch_background)
				switch_open?.textColor = Color.WHITE
				switch_closed?.textColor = Color.parseColor("#549788")
				toggle_open?.visibility = View.VISIBLE
				toggle_closed?.visibility = View.GONE
			}
		}
		switch_closed?.setOnClickListener {
			if (isOpen) {
				isOpen = false
				switch_open?.background = resources.getDrawable(R.drawable.create_chat_switch_background)
				switch_closed?.setBackgroundColor(Color.parseColor("#549788"))
				switch_open?.textColor = Color.parseColor("#549788")
				switch_closed?.textColor = Color.WHITE
				toggle_open?.visibility = View.GONE
				toggle_closed?.visibility = View.VISIBLE
			} else {
				isOpen = true
				switch_open?.setBackgroundColor(Color.parseColor("#549788"))
				switch_closed?.background = resources.getDrawable(R.drawable.create_chat_switch_background)
				switch_open?.textColor = Color.WHITE
				switch_closed?.textColor = Color.parseColor("#549788")
				toggle_open?.visibility = View.VISIBLE
				toggle_closed?.visibility = View.GONE
			}
		}
	}

	private fun ToggleTickColor() {
		//        Toast.makeText(getBaseContext(),chat_name_editText.getText().toString().length()+"    "+
		//                descriptionEditText.getText().toString().length()+"  "+
		//               subjectEditText.getText().toString().length()+"  "
		//                ,Toast.LENGTH_LONG).show();
		if (this.chat_name_editText!!.text.toString().isNotEmpty()) {
			this.create_chat_check!!.visibility = View.VISIBLE
		}
//			this.create_chat_check!!.visibility = View.VISIBLE
//			this.create_chat_check!!.setImageResource(R.drawable.ic_check_green_24dp)
//			this.create_chat_check!!.setTag(string.checkcolor, "green")
//		} else {
//			this.create_chat_check!!.setImageResource(R.drawable.ic_check_white_24dp)
//			this.create_chat_check!!.setTag(string.checkcolor, "white")

		//            switch (color) {
		//                case "white": {
		//                    create_chat_check.setImageResource(R.drawable.ic_check_green_24dp);
		//                    create_chat_check.setTag(R.string.checkcolor, "green");
		//                }
		//                break;
		//                case "green": {
		//                    create_chat_check.setImageResource(R.drawable.ic_check_white_24dp);
		//                    create_chat_check.setTag(R.string.checkcolor, "white");
		//                }
		//                break;
		//                default:
		//                    Log.d("TICK", "default color");
		//            }
		//        }
	}

	private fun setActivityStrings() = this.runOnUiThread {
		when {
			isClass -> this@CreateChatActivity.supportActionBar!!.title = "New Class"
			isSubchat -> this@CreateChatActivity.supportActionBar!!.title = "New Subchat"
			else -> this@CreateChatActivity.supportActionBar!!.title = "New Chat"
		}
	}

	//    void SetTickGreen() {
	//        create_chat_check.setImageResource(R.drawable.ic_check_green_24dp);
	//        create_chat_check.setTag(R.string.checkcolor, "green");
	//    }
	//
	//    void SetTickWhite() {
	//        create_chat_check.setImageResource(R.drawable.ic_check_white_24dp);
	//        create_chat_check.setTag(R.string.checkcolor, "white");
	//    }

	override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
		super.onActivityResult(requestCode, resultCode, data)

		when (requestCode) {
			143 -> if (resultCode == Activity.RESULT_OK && data!=null) {

				val selectedImageUri = data.data
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
				filepath = result

				newchat_image!!.setImageURI(data.data)

				//                        Uri selectedImage = data.getData();
				//                        String[] filePathColumn = {MediaStore.Images.Media.DATA};
				//
				//                        Cursor cursor = getContentResolver().query(selectedImage,
				// filePathColumn, null, null, null);
				//                        cursor.moveToFirst();
				//
				//                        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
				//                        String filePath = cursor.getString(columnIndex);
				//                        cursor.close();
				//

				//                        Bitmap yourSelectedImage = BitmapFactory.decodeFile(filePath);
				//                        newchat_image.setImageBitmap(yourSelectedImage);


				/* Now you have choosen image in Bitmap format in object "yourSelectedImage". You can
             use it in way you want! */
			}
		}

	}

	private fun addRedAsterisk(editText: EditText) {
		val text = editText.hint.toString()
		val asterisk = " *"
		val builder = SpannableStringBuilder()
		builder.append(text)
		val start = builder.length
		builder.append(asterisk)
		val end = builder.length
		builder.setSpan(ForegroundColorSpan(Color.RED), start, end,
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
		editText.hint = builder
	}

	private fun addAsteriskToText(textview: TextView) {
		val text = textview.text.toString()
		val asterisk = "* "
		val builder = SpannableStringBuilder()
		builder.append(asterisk)
		builder.length
		builder.append(text)
		val end = builder.length
		builder.setSpan(ForegroundColorSpan(Color.RED), 0, end,
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
		textview.text = builder
	}

	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		if (item.itemId == id.home) this.finish()
		return super.onOptionsItemSelected(item)
	}

	companion object {

		var adminUser: UserSerializer? = null
	}

}