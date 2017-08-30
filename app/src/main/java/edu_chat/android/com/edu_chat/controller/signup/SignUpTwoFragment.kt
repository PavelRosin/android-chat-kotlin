package edu_chat.android.com.edu_chat.controller.signup

import android.R.layout
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.Toast
import chat.edu.edu_chat.R
import io.swagger.client.ApiCallback
import io.swagger.client.ApiClient
import io.swagger.client.ApiException
import io.swagger.client.Configuration
import io.swagger.client.api.InstitutionApi
import io.swagger.client.api.UserApi
import io.swagger.client.model.APIViewUserSerializer
import io.swagger.client.model.Login
import io.swagger.client.model.UniversitySerializer
import io.swagger.client.model.UniversityView
import kotlinx.android.synthetic.main.fragment_sign_up_two.*
import java.util.*

/**
 * Created by yuandali on 8/5/16.
 * Edu.Chat Inc.
 */
class SignUpTwoFragment : Fragment(), UpdateParamsInterface {

	private var type: String? = null
	private val mUnivStringArrayList = ArrayList<String>()
	private var mUnivArray: ArrayList<UniversitySerializer>? = null

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
							  savedInstanceState: Bundle?): View? {
		val bundle = arguments
		type = bundle.getString("type")
		val view = inflater.inflate(R.layout.fragment_sign_up_two, container, false)
		if (mUnivArray == null)
			getInstitutionList()


		go_button!!.setOnClickListener {
			//SignUpTwoFragment.this.updateRequestParams(SignUpActivity.getRequestParams());


			val handler = Handler()
			handler.postDelayed(Runnable {
				//Returns null if the input is invalid
				val bundle = validateInput() ?: return@Runnable

				val signUpThreeFragment = SignUpThreeFragment()
				signUpThreeFragment.arguments = bundle
				val ft = this@SignUpTwoFragment.activity
						.supportFragmentManager
						.beginTransaction()
				ft.replace(R.id.sign_up_framelayout, signUpThreeFragment)
				ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
				ft.addToBackStack(null)
				ft.commit()
			}, 100L)
		}
		fragmentTwoSU!!.setOnTouchListener { view, _ ->
			val IM = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
			IM.hideSoftInputFromWindow(
					view.windowToken,
					InputMethodManager.HIDE_NOT_ALWAYS
			)
			false
		}

		return view
	}

	private fun getInstitutionList() {
		val apiInstance = InstitutionApi()
		Configuration.setDefaultApiClient(ApiClient())

		try {
			Configuration.setDefaultApiClient(ApiClient())
			apiInstance.institutionUniversityListAsync(null, null, null, null, null,
					object : ApiCallback<UniversityView> {
						override fun onFailure(e: ApiException,
											   statusCode: Int,
											   responseHeaders: Map<String, List<String>>) {
							Toast.makeText(
									context,
									getString(R.string.failure_to_find_institution),
									Toast.LENGTH_LONG
							).show()
						}

						override fun onSuccess(result: UniversityView,
											   statusCode: Int,
											   responseHeaders: Map<String, List<String>>) {
							mUnivArray = ArrayList(result.results)
							//Iterator<UniversitySerializer> mResultsIterator = result.getResults
							// ().iterator();
							val mResultsIterator = mUnivArray!!.iterator()
							//int i = 0;
							for (univ in mUnivArray!!) {
								mUnivStringArrayList.add(univ.name)
								Log.d(
										"Institution",
										"" + univ.name
								)
							}
							/*do {
                        //ArrayList<UniversitySerializer> mUnivArray = new ArrayList<>();
                        //mUnivArray.add(mResultsIterator.next());
                        mUnivStringArrayList.add(mUnivArray.get(i).getName());
                        Log.d("Institution", "" + mUnivArray.get(i).getName());
                        //SignUpTwoFragment.this.mUnivArray = mUnivArray;
                    } while (mResultsIterator.hasNext());*/
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
			val adapter = ArrayAdapter(
					context,
					layout.simple_list_item_1,
					mUnivStringArrayList
			)
			institutionSearchSuccess(adapter)

		} catch (e: ApiException) {
			e.printStackTrace()
		}

	}

	private fun institutionSearchSuccess(adapter: ArrayAdapter<String>) {
		if (school_auto_complete != null) {
			this@SignUpTwoFragment.school_auto_complete!!.threshold = 1
			this@SignUpTwoFragment.school_auto_complete!!.setAdapter(adapter)
		}
	}

	private fun validateInput(): Bundle? {
		val bundle = Bundle()

		val institutionID = universityId

		val firstName = first_name!!.text.toString()
		val lastName = last_name!!.text.toString()
		val email = school_email!!.text.toString()
		val password = password!!.text.toString()
		if (institutionID == -1) {
			Toast.makeText(context,
					getString(R.string.enter_valid_institution),
					Toast.LENGTH_SHORT).show()
			return null
		} else if (firstName.isEmpty()) {
			Toast.makeText(context,
					getString(R.string.enter_first_name),
					Toast.LENGTH_SHORT).show()
			return null
		} else if (lastName.isEmpty()) {
			Toast.makeText(context,
					getString(R.string.enter_last_name),
					Toast.LENGTH_SHORT).show()
			return null
		} else if (email.isEmpty()) {
			Toast.makeText(context,
					getString(R.string.please_enter_email),
					Toast.LENGTH_SHORT).show()
			return null
		} else if (password.isEmpty()) {
			Toast.makeText(context,
					getString(R.string.please_enter_password),
					Toast.LENGTH_SHORT).show()
			return null
		} else if (confrimpassword!!.text.toString() != password) {
			Toast.makeText(context,
					getString(R.string.passwords_dont_match),
					Toast.LENGTH_SHORT).show()
			return null
		}
		bundle.putString("type", type)
		bundle.putInt("university", institutionID)
		bundle.putString("first_name", firstName)
		bundle.putString("last_name", lastName)
		bundle.putString("email", email)
		bundle.putString("password", password)

		return bundle
	}

	private //Detects if institution is valid (in the API) Only allows continuation if valid
			//Toast.makeText(getContext(), "Please enter a valid university/school name", Toast
			// .LENGTH_LONG).show();
	val universityId: Int
		get() {
			val institutionString = this@SignUpTwoFragment.school_auto_complete!!.text.toString()
			val mStringIterator = mUnivStringArrayList.iterator()
			var isValidInstitution = false
			do {
				if (mStringIterator.next().equals(institutionString, ignoreCase = true)) {
					isValidInstitution = true
					break
				}
			} while (mStringIterator.hasNext())

			if (!isValidInstitution) {
				return -1
			}

			var selectedUnivNum = -1
			val mUnivIterator = mUnivArray!!.iterator()
			do {
				val currUniv = mUnivIterator.next()
				Log.d("Current University", currUniv.name + " " + currUniv.id)
				if (currUniv.name.equals(institutionString, ignoreCase = true)) {
					selectedUnivNum = currUniv.id!!
					break
				}
			} while (mUnivIterator.hasNext())

			return selectedUnivNum
		}

	private fun attemptSignup(user: APIViewUserSerializer) {
		try {

			//TODO: Set the paramters of the user object
			//Required fields

			val api = UserApi()
			api.userSignupCreateAsync(user, object : ApiCallback<Login> {
				override fun onFailure(e: ApiException,
									   statusCode: Int,
									   responseHeaders: Map<String, List<String>>) {
					Log.d("Signup", "Failure")
					Log.d("Signup", "Status Code: " + statusCode)
					for (header in responseHeaders.keys) {
						println(header + ":" + responseHeaders[header])
					}
				}

				override fun onSuccess(result: Login,
									   statusCode: Int,
									   responseHeaders: Map<String, List<String>>) {
					Log.d("Signup", "Success")
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

