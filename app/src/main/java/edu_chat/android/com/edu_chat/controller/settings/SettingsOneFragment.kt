package edu_chat.android.com.edu_chat.controller.settings

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.*
import chat.edu.edu_chat.R
import edu_chat.android.com.edu_chat.controller.LoginActivity
import edu_chat.android.com.edu_chat.controller.chat_list.ChatListActivity
import edu_chat.android.com.edu_chat.model.CurrentUser
import io.swagger.client.ApiCallback
import io.swagger.client.ApiException
import io.swagger.client.api.ApiApi
import io.swagger.client.api.InstitutionApi
import io.swagger.client.api.PasswordApi
import io.swagger.client.api.UserApi
import io.swagger.client.model.*
import kotlinx.android.synthetic.main.fragment_settings_one.*
import kotlinx.android.synthetic.main.settings_fragment_one_account.*
import kotlinx.android.synthetic.main.settings_fragment_one_education.*
import java.util.*

/**
 * Created by Billy Yang on 06/14/2017
 */
class SettingsOneFragment : Fragment() {
	private val options = arrayOfNulls<TextView>(4)
	private var settingsType: String? = null
	private var universityID: Int? = null
	private val userSerializer = CurrentUser.currentUser
	private val updateSerializer = UserUpdateSerializer()


	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
							  savedInstanceState: Bundle?): View? {
		return inflater.inflate(R.layout.fragment_settings_one, container, false)
	}

	override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		(activity as AppCompatActivity).setSupportActionBar(toolbar_settings as Toolbar)
		(toolbar_settings as Toolbar).setNavigationIcon(R.drawable.instabug_ic_back)
		(toolbar_settings as Toolbar).setNavigationOnClickListener {
			val handler = Handler()
			handler.postDelayed({
				val intent = Intent(activity.baseContext, ChatListActivity::class.java)
				activity.finish()
				startActivity(intent)
			}, 100L)
		}


		universityID = userSerializer!!.university

		setEducationInformation()
		editEducationInformation()

		setLogout()

		this.options[0] = this.settings_account_and_security
		this.options[1] = this.settings_notifications
		this.options[2] = this.settings_general
		this.options[3] = this.settings_about

		this.settings_changeDisplayName!!.setOnClickListener { this@SettingsOneFragment.setDisplayName() }

		this.settings_changePassword!!.setOnClickListener { this@SettingsOneFragment.requestResetPassword() }

		this.settings_account_and_security!!.setOnClickListener {
			this@SettingsOneFragment.clearSelectedType()
			this@SettingsOneFragment.settings_account_and_security!!.setTextColor(Color.parseColor(
					"#000000"))
			this@SettingsOneFragment.settings_account_and_security!!.setBackgroundResource(R.drawable
					.sign_up_selected_background)
			this@SettingsOneFragment.settingsType = "as"
			this@SettingsOneFragment.goToNextStep()
		}
		this.settings_account_and_security!!.visibility = View.GONE
		this.settings_notifications!!.setOnClickListener {
			this@SettingsOneFragment.clearSelectedType()
			this@SettingsOneFragment.settings_notifications!!.setTextColor(Color.parseColor(
					"#000000"))
			this@SettingsOneFragment.settings_notifications!!.setBackgroundResource(R.drawable
					.sign_up_selected_background)
			this@SettingsOneFragment.settingsType = "n"
			this@SettingsOneFragment.goToNextStep()
		}
		this.settings_notifications!!.visibility = View.GONE
		this.settings_general!!.setOnClickListener {
			this@SettingsOneFragment.clearSelectedType()
			this@SettingsOneFragment.settings_general!!.setTextColor(Color.parseColor("#000000"))
			this@SettingsOneFragment.settings_general!!.setBackgroundResource(R.drawable
					.sign_up_selected_background)
			this@SettingsOneFragment.settingsType = "g"
			this@SettingsOneFragment.goToNextStep()
		}
		settings_general!!.visibility = View.GONE
		this.settings_about!!.setOnClickListener {
			this@SettingsOneFragment.clearSelectedType()
			this@SettingsOneFragment.settings_about!!.setTextColor(Color.parseColor("#000000"))
			this@SettingsOneFragment.settings_about!!.setBackgroundResource(R.drawable
					.sign_up_selected_background)
			this@SettingsOneFragment.settingsType = "a"
			this@SettingsOneFragment.goToNextStep()
		}
		this.settings_about!!.visibility = View.GONE
	}

	private fun editEducationInformation() {
		settings_education_school!!.setOnClickListener {
			val dataId = ArrayList<Int>()
			val data = ArrayList<String>()
			try {
				InstitutionApi().institutionSchoolListAsync(null, null, null, universityID.toString(), null, null, object : ApiCallback<SchoolView> {

					override fun onFailure(e: ApiException, statusCode: Int, responseHeaders: Map<String, List<String>>) {

					}

					override fun onSuccess(result: SchoolView, statusCode: Int, responseHeaders: Map<String, List<String>>) {
						if (!result.results.isEmpty()) {
							//                                ListIterator iterator = result.getResults().listIterator();
							//                                while (iterator.hasNext()){
							//                                    int i = iterator.nextIndex();
							//                                    data.add(result.getResults().get(i).getName());
							//                                }
							for (i in 0 until result.results.size) {
								data.add(result.results[i].name)
								dataId.add(result.results[i].id)
							}
							activity.runOnUiThread { createRollSelector(data, dataId, true) }

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
		settings_education_department!!.setOnClickListener {
			val dataId = ArrayList<Int>()
			val data = ArrayList<String>()
			try {
				InstitutionApi().institutionDepartmentListAsync(null, null, null, userSerializer!!.school.toString(), null, null, object : ApiCallback<DepartmentView> {
					override fun onFailure(e: ApiException, statusCode: Int, responseHeaders: Map<String, List<String>>) {

					}

					override fun onSuccess(result: DepartmentView, statusCode: Int, responseHeaders: Map<String, List<String>>) {
						if (!result.results.isEmpty()) {
							for (i in 0 until result.results.size) {
								data.add(result.results[i].name)
								dataId.add(result.results[i].id)
							}
							activity.runOnUiThread { createRollSelector(data, dataId, false) }

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

	private fun createRollSelector(data: List<String>, dataId: List<Int>, isSchool: Boolean?) {
		val builder = AlertDialog.Builder(context)
		val layoutInflater = LayoutInflater.from(context)
		val dialogView = layoutInflater.inflate(R.layout.settings_select_dialog, null)
		builder.setView(dialogView)
		val picker = dialogView.findViewById<NumberPicker>(R.id.settings_school_picker)
		val check = dialogView.findViewById<ImageView>(R.id.settings_select_check)
		check.visibility = View.INVISIBLE

		val schoolData = data.toTypedArray()
		picker.minValue = 0
		picker.maxValue = schoolData.size - 1
		if (userSerializer!!.school != null)
			picker.value = dataId.indexOf(userSerializer.school)
		else
			picker.value = 0
		picker.displayedValues = schoolData
		setNumberPickerTextColor(picker, Color.BLACK)
		val alertDialog = builder.create()
		alertDialog.show()

		picker.setOnValueChangedListener { numberPicker, i, i1 -> check.visibility = View.VISIBLE }
		if (isSchool!! && userSerializer.school == null) check.visibility = View.VISIBLE
		if (!isSchool && userSerializer.department == null) check.visibility = View.VISIBLE
		check.setOnClickListener {
			if (isSchool) {
				userSerializer.school = dataId[picker.value]
				updateSerializer.school = dataId[picker.value]
			} else {
				userSerializer.department = dataId[picker.value]
				updateSerializer.department = dataId[picker.value]
			}
			setEducationInformation()
			saveChanges()
			alertDialog.dismiss()
		}

	}

	private fun saveChanges() {
		try {
			UserApi().userPartialUpdateAsync(userSerializer!!.id!!.toString(), updateSerializer, object : ApiCallback<UserTokenRetrieveView> {
				override fun onFailure(e: ApiException, statusCode: Int, responseHeaders: Map<String, List<String>>) {

				}

				override fun onSuccess(result: UserTokenRetrieveView, statusCode: Int, responseHeaders: Map<String, List<String>>) {
					activity.runOnUiThread { Toast.makeText(activity, "Changes Saved", Toast.LENGTH_SHORT).show() }
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

	private fun setNumberPickerTextColor(numberPicker: NumberPicker, color: Int) {
		val count = numberPicker.childCount
		(0 until count)
				.map { numberPicker.getChildAt(it) }
				.filterIsInstance<EditText>()
				.forEach {
					try {
						val selectorWheelPaintField = numberPicker.javaClass
								.getDeclaredField("mSelectorWheelPaint")
						selectorWheelPaintField.isAccessible = true
						(selectorWheelPaintField.get(numberPicker) as Paint).color = color
						it.setTextColor(color)
						numberPicker.invalidate()
					} catch (ignored: NoSuchFieldException) {
					} catch (ignored: IllegalArgumentException) {
					} catch (ignored: IllegalAccessException) {
					}
				}
	}

	private fun setDisplayName() {
		val layoutInflater = LayoutInflater.from(context)
		val view = layoutInflater.inflate(R.layout.fragment_settings_changname, null)
		val builder = AlertDialog.Builder(context)
		builder.setView(view)
		val firstName = view.findViewById<EditText>(R.id.first_name)
		val lastName = view.findViewById<EditText>(R.id.last_name)
		builder.setPositiveButton("Submit"
		) { dialog, whichButton ->
			userSerializer!!.firstName = firstName.text.toString()
			userSerializer.lastName = lastName.text.toString()
			updateSerializer.firstName = firstName.text.toString()
			updateSerializer.lastName = lastName.text.toString()
			saveChanges()
		}
				.setNegativeButton("Cancel"
				) { dialog, whichButton ->
					//do nothing
				}


		val alertDialog = builder.create()
		alertDialog.setOnShowListener {
			alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.parseColor("#0F5C80"))
			alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.parseColor("#0F5C80"))
		}

		alertDialog.show()

		firstName.setOnTouchListener(View.OnTouchListener { view, motionEvent ->
			val DRAWABLE_RIGHT = 2
			if (motionEvent.action == MotionEvent.ACTION_UP) {
				if (motionEvent.rawX >= firstName.right - firstName.compoundDrawables[DRAWABLE_RIGHT].bounds.width()) {
					firstName.setText("")
					return@OnTouchListener true
				}
			}
			false
		})
		lastName.setOnTouchListener(View.OnTouchListener { view, motionEvent ->
			val DRAWABLE_RIGHT = 2
			if (motionEvent.action == MotionEvent.ACTION_UP) {
				if (motionEvent.rawX >= lastName.right - lastName.compoundDrawables[DRAWABLE_RIGHT].bounds.width()) {
					lastName.setText("")
					return@OnTouchListener true
				}
			}
			false
		})
	}


	private fun setLogout() {

		settings_logout!!.setOnClickListener {
			clearUserData()
			val logoutInst = ApiApi()
			try {
				logoutInst.apiLogoutCreateAsync(object : ApiCallback<LogoutView> {
					override fun onFailure(e: ApiException, statusCode: Int, responseHeaders: Map<String, List<String>>) {

					}

					override fun onSuccess(result: LogoutView, statusCode: Int, responseHeaders: Map<String, List<String>>) {
						activity.finish()
						val intent = Intent(activity.applicationContext, LoginActivity::class.java)

						activity.startActivity(intent)
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

	private fun clearUserData() {
		val sharedPreferences = this.activity.getSharedPreferences("login.conf", Context.MODE_PRIVATE)
		val editor = sharedPreferences.edit()
		editor.remove("user")
		editor.remove("pass")
		editor.apply()
	}

	private fun setEducationInformation() {
		try {
			InstitutionApi().institutionUniversityListAsync(universityID, null, null, null, null, object : ApiCallback<UniversityView> {
				override fun onFailure(e: ApiException, statusCode: Int, responseHeaders: Map<String, List<String>>) {

				}

				override fun onSuccess(result: UniversityView, statusCode: Int, responseHeaders: Map<String, List<String>>) {
					//                    try {
					//                        runOnUiThread(new Runnable() {
					//                            @Override
					//                            public void run() {
					if (!result.results.isEmpty()) {
						activity.runOnUiThread { settings_education_university!!.text = result.results[0].name }
					}

					//                            }
					//                        });
					//                        Thread.sleep(300);
					//                    } catch (InterruptedException e) {
					//                        e.printStackTrace();
					//                    }
				}

				override fun onUploadProgress(bytesWritten: Long, contentLength: Long, done: Boolean) {

				}

				override fun onDownloadProgress(bytesRead: Long, contentLength: Long, done: Boolean) {

				}
			})
		} catch (e: ApiException) {
			e.printStackTrace()
		}

		if (userSerializer!!.school != null) {
			try {
				InstitutionApi().institutionSchoolListAsync(userSerializer.school, null, null, universityID.toString(), null, null, object : ApiCallback<SchoolView> {
					override fun onFailure(e: ApiException, statusCode: Int, responseHeaders: Map<String, List<String>>) {

					}

					override fun onSuccess(result: SchoolView, statusCode: Int, responseHeaders: Map<String, List<String>>) {
						activity.runOnUiThread {
							if (!result.results.isEmpty()) {
								settings_education_school!!.text = result.results[0].name
							} else {
								settings_education_school!!.text = "Select Your School"
							}
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

		if (userSerializer.school != null && userSerializer.department != null) {
			try {
				InstitutionApi().institutionDepartmentListAsync(userSerializer.department, null, null, userSerializer.school.toString(), null, null, object : ApiCallback<DepartmentView> {
					override fun onFailure(e: ApiException, statusCode: Int, responseHeaders: Map<String, List<String>>) {

					}

					override fun onSuccess(result: DepartmentView, statusCode: Int, responseHeaders: Map<String, List<String>>) {
						activity.runOnUiThread {
							if (!result.results.isEmpty()) {
								settings_education_department!!.text = result.results[0].name
							} else {
								settings_education_department!!.text = "Select Your Department"
							}
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


	private fun clearSelectedType() {
		for (option in this.options) {
			option?.setTextColor(Color.parseColor("#FFFFFF"))
			option?.setBackgroundResource(R.drawable.sign_up_option_border)
		}
	}

	private fun goToNextStep() {
		val handler = Handler()
		handler.postDelayed({
			val settingsAbout = SettingsAbout()
			val settingsAccount = SettingsAccount()
			val settingsNotifications = SettingsNotifications()
			val settingsGeneral = SettingsGeneral()
			//Pass the account type to the next fragment
			val bundle = Bundle()
			bundle.putString("type", settingsType)
			settingsAbout.arguments = bundle
			var fragment = Fragment()

			val ft = this@SettingsOneFragment.activity
					.supportFragmentManager
					.beginTransaction()
			when (settingsType) {
				"as" -> fragment = settingsAccount
				"n" -> fragment = settingsNotifications
				"g" -> fragment = settingsGeneral
				"a" -> fragment = settingsAbout
			}
			ft.replace(R.id.settings_framelayout, fragment)
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
			ft.addToBackStack(null)
			ft.commit()
		}, 100L)

	}


	private fun requestResetPassword() {
		// Get dialog edit text view
		val layoutInflater = LayoutInflater.from(context)
		val view = layoutInflater.inflate(R.layout.settings_account_resetpassword_dialog, null)

		val builder = AlertDialog.Builder(context)
//		val dialogTitle = "Reset Password"
//		builder.setTitle(dialogTitle)
		builder.setView(view)
		val email = view.findViewById<EditText>(R.id.settings_account_reset_dialog_email)

		email.setOnTouchListener(View.OnTouchListener { view, motionEvent ->
			val DRAWABLE_RIGHT = 2
			if (motionEvent.action == MotionEvent.ACTION_UP) {
				if (motionEvent.rawX >= email.right - email.compoundDrawables[DRAWABLE_RIGHT].bounds.width()) {
					email.setText("")
					return@OnTouchListener true
				}
			}
			false
		})

		val dialogPositiveButton = "Submit"
		builder.setPositiveButton(dialogPositiveButton) { dialogInterface, i -> attemptResetPassword(email) }
		val dialogNegativeButton = "Cancel"
		builder.setNegativeButton(dialogNegativeButton) { dialogInterface, i -> dialogInterface.dismiss() }

		val alertDialog = builder.create()
		alertDialog.setOnShowListener {
			alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.parseColor("#0F5C80"))
			alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.parseColor("#0F5C80"))
		}
		alertDialog.show()
	}


	private fun attemptResetPassword(email: EditText) {
		val apiInstance = PasswordApi()
		val requestPassword = RequestPassword()
		requestPassword.email = email.text.toString()

		if (CurrentUser.currentUser!!.email == email.text.toString()) {
			try {
				if (email.text != null)
					apiInstance.passwordRequestCreateAsync(
							requestPassword,
							object : ApiCallback<LogoutView> {
								override fun onFailure(e: ApiException,
													   statusCode: Int,
													   responseHeaders: Map<String, List<String>>) {
									Log.i("resetpassword", "Failed")
									activity.runOnUiThread {
										Toast.makeText(
												activity.applicationContext,
												"Email doesn't exist!",
												Toast.LENGTH_SHORT
										).show()
										email.setText("")
									}
								}

								override fun onSuccess(result: LogoutView,
													   statusCode: Int,
													   responseHeaders: Map<String, List<String>>) {
									Log.i(
											"resetpassword",
											"Success"
									)
									activity.runOnUiThread {
										Toast.makeText(
												activity.applicationContext,
												"A verification email has been sent to your " + "email address!",
												Toast.LENGTH_SHORT
										).show()
										email.setText("")
									}
								}

								override fun onUploadProgress(bytesWritten: Long,
															  contentLength: Long,
															  done: Boolean) {
									Log.i(
											"resetpassword",
											"Uploading"
									)
								}

								override fun onDownloadProgress(bytesRead: Long,
																contentLength: Long,
																done: Boolean) {
									Log.i(
											"resetpassword",
											"Downloading"
									)
								}
							}
					)
			} catch (e: ApiException) {
				e.printStackTrace()
			}

		} else {
			Toast.makeText(
					activity.applicationContext,
					"Type in your correct E-mail address!",
					Toast.LENGTH_SHORT
			).show()
		}
	}

	//    private void overrideFont(final View v){
	//        SharedPreferences sp = getActivity().getSharedPreferences("text_size.conf", Context
	// .MODE_PRIVATE);
	//        float ts = sp.getFloat(getString(R.string.saved_textSize), getResources().getDimension
	// (R.dimen.text_size_16));
	//        try {
	//            if (v instanceof ViewGroup) {
	//                ViewGroup vg = (ViewGroup) v;
	//                for (int i = 0; i < vg.getChildCount(); i++) {
	//                    View child = vg.getChildAt(i);
	//                    overrideFont(child);
	//                }
	//            } else if (v instanceof TextView) {
	//                ((TextView) v).setTextSize(TypedValue.COMPLEX_UNIT_PX, ts);
	//            }
	//        } catch (Exception e) {
	//        }
	//    }

	//    public interface OnFragmentInteractionListener {
	//        void onFragmentInteraction(Uri uri);
	//    }

}
