package edu_chat.android.com.edu_chat.controller;

import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;
import android.view.View;

import chat.edu.edu_chat.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import edu_chat.android.com.edu_chat.controller.chat_list.ChatListActivity;
import edu_chat.android.com.edu_chat.controller.signup.SignUpActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;


/**
 * Created by pallakanand on 6/22/17.
 */

@RunWith(AndroidJUnit4.class)

@LargeTest

public class LoginActivityTest {
    @Rule
    public ActivityTestRule<LoginActivity> loginActivityTestRule = new ActivityTestRule<LoginActivity>(LoginActivity.class);
    private LoginActivity loginActivity = null;

    @Mock


    private UiDevice mDevice;
    private static final int LAUNCH_TIMEOUT = 5000;
    String email = "email";
    String password = "password";
    private ChatListActivity chatListActivity;
    private SignUpActivity signUpActivity;

    @Before
    public void setUp() {

        loginActivity = loginActivityTestRule.getActivity();
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mDevice.pressHome();

        final String launchPackage = mDevice.getLauncherPackageName();
        assertThat(launchPackage, notNullValue());
        mDevice.wait(Until.hasObject(By.pkg(launchPackage).depth(0)), LAUNCH_TIMEOUT);
        UiObject2 appsButton = mDevice.findObject(By.desc("Apps"));
        appsButton.click();
        mDevice.wait(Until.hasObject(By.text("Edu.Chat")), LAUNCH_TIMEOUT);
        UiObject2 eduChatApp = mDevice.findObject(By.desc("Edu.Chat"));
        eduChatApp.click();

    }

    @Test
    public void onCreate() throws Exception {
        // when login in clicked is when onCreate is working

        // making sure the email is not null
        View emailView = loginActivity.findViewById(R.id.email_textview);
        assertNotNull(emailView);

        //making sure email is not empty and password are not null
        if (!(email.isEmpty())){
            View passwordView = loginActivity.findViewById(R.id.password_textview);
            assertNotNull(passwordView);
        }

        // making sure login button is working
        onView(withId(R.id.login_button)).check(matches(isClickable()));

        //check if login button opens main activity


        //making sure that the correct activity is launched when signup button is clicked
        testSignUpButton();

        //making sure that the correct activity is launched when forgot password is clicked
        testForgotPasswordButton();
    }

    @Test
    public void testSignUpButton() {
        // tests that sign up button goes to fragment one sign up
//        if (onView(withId(R.id.sign_up_textview)).check(matches(isClickable()))){

//        }
    }


    @Test
    public void testForgotPasswordButton(){
        // tests that forgot password button goes to forgot password layout
//        when(onView(withId(R.id.forgot_textview))).then(onData(withId(R.layout.activity_forgot_pass)));

    }

    @After
    public void tearDown() throws Exception{
        loginActivity = null;
    }


}