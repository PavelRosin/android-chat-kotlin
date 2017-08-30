package edu_chat.android.com.edu_chat.controller.signup

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import chat.edu.edu_chat.R
import chat.edu.edu_chat.R.drawable
import chat.edu.edu_chat.R.layout
import edu_chat.android.com.edu_chat.model.CurrentUser
import io.swagger.client.model.UserSerializer
import kotlinx.android.synthetic.main.fragment_sign_up_one.*

/**
 * Created by yuandali on 8/5/16.
 * Edu.Chat Inc.
 */

class SignUpOneFragment : Fragment(), UpdateParamsInterface {

	private val options = arrayOfNulls<TextView>(2)
	private var accountType = "S"
	private var user: UserSerializer? = null
	private val userEmail: String? = null

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
							  savedInstanceState: Bundle?): View? {
		val view = inflater.inflate(layout.fragment_sign_up_one, container, false)
		this.options[0] = faculty_textview
		this.options[1] = student_textview

		this.faculty_textview!!.setOnClickListener {
			this@SignUpOneFragment.clearSelectedType()
			this@SignUpOneFragment.faculty_textview!!.setTextColor(Color.parseColor("#000000"))
			this@SignUpOneFragment.faculty_textview!!.setBackgroundResource(drawable
					.sign_up_selected_background)
			this@SignUpOneFragment.accountType = "f"
			this@SignUpOneFragment.goToNextStep()
		}
		student_textview!!.setOnClickListener {
			this@SignUpOneFragment.clearSelectedType()
			this@SignUpOneFragment.student_textview!!.setTextColor(Color.parseColor("#000000"))
			this@SignUpOneFragment.student_textview!!.setBackgroundResource(drawable
					.sign_up_selected_background)
			this@SignUpOneFragment.accountType = "s"
			this@SignUpOneFragment.goToNextStep()
		}
		return view
	}


	override fun onDetach() {
		super.onDetach()
	}


	private fun clearSelectedType() {
		for (option in this.options) {
			option?.setTextColor(Color.parseColor("#FFFFFF"))
			option?.setBackgroundResource(drawable.sign_up_option_border)
		}
	}

	private fun goToNextStep() {
		//        this.updateRequestParams(SignUpActivity.getRequestParams());

		val handler = Handler()
		handler.postDelayed({
			val signUpTwoFragment = SignUpTwoFragment()
			val bundle = Bundle()
			//Pass the account type to the next fragment
			//TODO:Read university from the drop-down
			user = CurrentUser.currentUser
			//userEmail = user.getEmail();
			bundle.putString("type", accountType)
			bundle.putString("email", userEmail)
			signUpTwoFragment.arguments = bundle

			val ft = this@SignUpOneFragment.activity
					.supportFragmentManager
					.beginTransaction()
			ft.replace(R.id.sign_up_framelayout, signUpTwoFragment)
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
			ft.addToBackStack(null)
			ft.commit()
		}, 100L)

	}

	companion object {

		// @Nullable private OnFragmentInteractionListener mListener;

		fun newInstance(): SignUpOneFragment {
			val fragment = SignUpOneFragment()
			val args = Bundle()
			fragment.arguments = args
			return fragment
		}
	}


	//    public interface OnFragmentInteractionListener {
	//        void onFragmentInteraction(Uri uri);
	//    }
	//
}