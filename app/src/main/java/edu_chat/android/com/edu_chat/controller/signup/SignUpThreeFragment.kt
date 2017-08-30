package edu_chat.android.com.edu_chat.controller.signup

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.Toast
import chat.edu.edu_chat.R.layout
import edu_chat.android.com.edu_chat.controller.LoginActivity
import io.swagger.client.ApiCallback
import io.swagger.client.ApiClient
import io.swagger.client.ApiException
import io.swagger.client.Configuration
import io.swagger.client.api.InstitutionApi
import io.swagger.client.api.UserApi
import io.swagger.client.model.*
import kotlinx.android.synthetic.main.fragment_sign_up_three.*
import java.util.*

/**
 * Created by yuandali on 8/5/16.
 * Edu.Chat Inc.
 */

class SignUpThreeFragment : Fragment(), UpdateParamsInterface {
	internal var type: String? = null
	private var mSchoolArray: ArrayList<SchoolSerializer>? = null
	private var mDepartmentArray: ArrayList<DepartmentSerializer>? = null
	private val mSchoolStringArrayList = ArrayList<String>()

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
							  savedInstanceState: Bundle?): View? {
		val view = inflater.inflate(layout.fragment_sign_up_three, container, false)
		val bundle = this.arguments
		val type = bundle.getString("type")
		val university = bundle.getInt("university")
		val firstName = bundle.getString("first_name")
		val lastName = bundle.getString("last_name")
		val email = bundle.getString("email")
		val password = bundle.getString("password")
		Log.d("Frag 3", type +
				"\n" + university + "\n" + firstName + "\n" + lastName + "\n" + email + "\n" +
				password)

		if (type == "f") {
			this.year_of_graduation!!.visibility = View.GONE
			this.area_of_study!!.visibility = View.GONE
		}


		getSchoolList(university)
		getDepartmentList(getSchoolId(mSchoolStringArrayList))

		skip!!.setOnClickListener {
			//Create a user with just the required parameters
			val user = APIViewUserSerializer()
			user.university = university
			//   user.setType(type);
			user.firstName = firstName
			user.lastName = lastName
			user.email = email
			user.password = password
			attemptSignup(user)
		}

		finish!!.setOnClickListener {
			val user = APIViewUserSerializer()
			user.university = university
			//user.setType(type);
			user.firstName = firstName
			user.lastName = lastName
			user.email = email
			user.password = password


			val year = year_of_graduation!!.text.toString()
			val school_string = school_ac_signUp!!.text.toString()
			val department_string = department_ac_signUp!!.text.toString()
			val areasOfStudy = listOf(area_of_study!!.text
					.toString())
			if (year.isNotEmpty()) {
				user.yearOfGraduation = Integer.parseInt(year)
			}

			if (school_string.isNotEmpty()) {
				user.school = Integer.parseInt(school_string)
			}

			if (department_string.isNotEmpty()) {
				user.department = Integer.parseInt(school_string)
			}

			if (areasOfStudy.isNotEmpty()) {
				user.areasOfStudy = areasOfStudy
			}

			attemptSignup(user)
		}
		frameThreeSU!!.setOnTouchListener { view, event ->
			val IM = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
			IM.hideSoftInputFromWindow(
					view.windowToken,
					InputMethodManager.HIDE_NOT_ALWAYS
			)
			false
		}


		school_ac_signUp!!.onFocusChangeListener = View.OnFocusChangeListener { view, hasFocus ->
			if (!hasFocus) {
				Log.d("Focus", "Here")
				getDepartmentList(getSchoolId(mSchoolStringArrayList))
			}
		}

		department_ac_signUp!!.setOnClickListener {
			Log.d("OnClick", "Refresh Department")
			getDepartmentList(getSchoolId(mSchoolStringArrayList))
		}
		return view
	}

	private fun getSchoolId(mSchoolStringArrayList: ArrayList<*>): Int {
		val schoolString = this@SignUpThreeFragment.school_ac_signUp!!.text.toString()
		val isValidSchool = mSchoolStringArrayList.indices.any { mSchoolStringArrayList[it].toString() == schoolString }
		if (!isValidSchool) {
			Toast.makeText(
					context,
					"Please enter a valid university/school name",
					Toast.LENGTH_LONG
			).show()
			return -1
		}
		val selectedSchoolNum = mSchoolArray!!.indices
				.map { mSchoolArray!![it] }
				.firstOrNull { it.name == schoolString }
				?.let { it.id!! }
				?: -1
		Log.d("School", selectedSchoolNum.toString())
		return selectedSchoolNum
	}

	private fun getSchoolList(university: Int) {
		val apiInstance = InstitutionApi()
		Configuration.setDefaultApiClient(ApiClient())
		try {
			apiInstance.institutionSchoolListAsync(null, null, null, null, null,
					university,
					object : ApiCallback<SchoolView> {
						override fun onFailure(e: ApiException,
											   statusCode: Int,
											   responseHeaders: Map<String, List<String>>) {
							Log.d("School", "Failed")
						}

						override fun onSuccess(result: SchoolView,
											   statusCode: Int,
											   responseHeaders: Map<String, List<String>>) {
							mSchoolArray = ArrayList(result.results)
							//  Iterator<SchoolSerializer> mResultsIterator = mSchoolArray
							// .iterator();
							for (school in mSchoolArray!!) {
								mSchoolStringArrayList.add(school.name)
								Log.d(
										"School",
										"" + school.name
								)
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


			val schoolAdapter = ArrayAdapter(
					context,
					android.R.layout.simple_list_item_1,
					mSchoolStringArrayList
			)
			institutionSearchSuccess(schoolAdapter)

		} catch (e: ApiException) {
			e.printStackTrace()
		}

	}

	private fun institutionSearchSuccess(adapter: ArrayAdapter<String>) {
		this@SignUpThreeFragment.school_ac_signUp!!.threshold = 1
		this@SignUpThreeFragment.school_ac_signUp!!.setAdapter(adapter)
	}

	private fun getDepartmentList(school: Int) {
		val apiInstance = InstitutionApi()
		Configuration.setDefaultApiClient(ApiClient())
		val mDepartmentStringArrayList = ArrayList<String>()
		try {
			apiInstance.institutionDepartmentListAsync(null, null, null, null, null,
					school,
					object : ApiCallback<DepartmentView> {
						override fun onFailure(e: ApiException,
											   statusCode: Int,
											   responseHeaders: Map<String, List<String>>) {
							Log.d("Department", "" + "Failed")
						}

						override fun onSuccess(result: DepartmentView,
											   statusCode: Int,
											   responseHeaders: Map<String, List<String>>) {
							mDepartmentArray = ArrayList(result.results)
							//  Iterator<DepartmentSerializer> mResultsIterator =
							// mDepartmentArray.iterator();
							for (department in mDepartmentArray!!) {
								mDepartmentStringArrayList.add(department.name)
								Log.d(
										"Department",
										"" + department.name
								)
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


			val departmentAdapter = ArrayAdapter(
					context,
					android.R.layout.simple_list_item_1,
					mDepartmentStringArrayList
			)
			departmentSearchSuccess(departmentAdapter)

		} catch (e: ApiException) {
			e.printStackTrace()
		}

	}

	private fun departmentSearchSuccess(adapter: ArrayAdapter<String>) {
		this@SignUpThreeFragment.department_ac_signUp!!.threshold = 1
		this@SignUpThreeFragment.department_ac_signUp!!.setAdapter(adapter)
	}

	private fun attemptSignup(user: APIViewUserSerializer) {
		try {
			Log.d("Signup", user.toString())
			val api = UserApi()
			api.userSignupCreateAsync(user, object : ApiCallback<Login> {
				override fun onFailure(e: ApiException,
									   statusCode: Int,
									   responseHeaders: Map<String, List<String>>) {
					Log.d("SignUp", "Failed" + '\n' + responseHeaders.toString() + statusCode)
					Log.d("Signup", e.message)

				}

				override fun onSuccess(result: Login,
									   statusCode: Int,
									   responseHeaders: Map<String, List<String>>) {
					displayToast("SignUp success!!")
					Log.d("SignUp", "Success" + result.toString())

					val intent = Intent(activity, LoginActivity::class.java)
					startActivity(intent)


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

	private fun displayToast(msg: String) {
		val str = msg
		activity.runOnUiThread { Toast.makeText(context, str, Toast.LENGTH_SHORT).show() }
	}

	companion object {


		fun newInstance(param1: String, param2: String): SignUpThreeFragment {
			val fragment = SignUpThreeFragment()
			val args = Bundle()
			fragment.arguments = args
			return fragment
		}
	}
}