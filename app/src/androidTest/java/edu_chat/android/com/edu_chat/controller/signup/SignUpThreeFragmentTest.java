package edu_chat.android.com.edu_chat.controller.signup;

import org.junit.Test;

import chat.edu.edu_chat.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by pallakanand on 6/22/17.
 */
public class SignUpThreeFragmentTest {
    String year_of_grad;
    String area_of_study;
    String department;
    String school;

    @Test
    public void newInstance(){
        final SignUpThreeFragment signUpThreeFragment = new SignUpThreeFragment();
    }

    @Test
    public void onCreateView() throws Exception {

        //find the university edit text and autofills in university
        onView(withId(R.id.year_of_graduation)).perform(typeText(year_of_grad),closeSoftKeyboard());
        onView(withId(R.id.area_of_study)).perform(typeText(area_of_study),closeSoftKeyboard());
        onView(withId(R.id.school_auto_complete)).perform(typeText(school),closeSoftKeyboard());

    }

    @Test
    public void displayToast() throws Exception {

    }

}