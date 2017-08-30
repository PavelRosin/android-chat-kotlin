package edu_chat.android.com.edu_chat.controller.signup;

import android.support.test.runner.AndroidJUnit4;

import chat.edu.edu_chat.R;

import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by pallakanand on 6/22/17.
 */

@RunWith(AndroidJUnit4.class)
public class SignUpTwoFragmentTest {
    String first_name = "firstname";
    String last_name = "lastname";
    String email = "email";
    String university = "university";


    @Test
    public void newInstance() throws Exception {
        final SignUpOneFragment signUpOneFragment = new SignUpOneFragment();
    }

    @Test
    public void onCreateView() throws Exception {
        //find the university edit text and autofills in university
        onView(withId(R.id.school_auto_complete)).perform(typeText(university),closeSoftKeyboard());
        //find the first name edit text and types in first name
        onView(withId(R.id.first_name)).perform(typeText(first_name),closeSoftKeyboard());
        //find the last name edit text and types in last name
        onView(withId(R.id.last_name)).perform(typeText(last_name),closeSoftKeyboard());
        //find the email edit text and types in email
        onView(withId(R.id.school_email)).perform(typeText(email),closeSoftKeyboard());
        // makes sure that the continue button goes to fragment three
        onView(withId(R.id.go_button)).perform(click());

    }

}