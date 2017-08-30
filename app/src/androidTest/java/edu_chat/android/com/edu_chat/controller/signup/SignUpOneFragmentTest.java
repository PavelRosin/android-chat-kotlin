package edu_chat.android.com.edu_chat.controller.signup;

import org.junit.Test;

import chat.edu.edu_chat.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by pallakanand on 6/22/17.
 */
public class SignUpOneFragmentTest {
    @Test
    public void newInstance() throws Exception {
        final SignUpOneFragment signUpOneFragment = new SignUpOneFragment();
    }


    @Test
    public void onCreateView() throws Exception {
        onView(withId(R.id.student_textview)).perform(click());
        onView(withId(R.id.faculty_textview)).perform(click());
    }

}