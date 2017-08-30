package edu_chat.android.com.edu_chat.controller;

import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import edu_chat.android.com.edu_chat.controller.chat_list.ChatListActivity;

import static org.junit.Assert.assertFalse;


/**
 * Created by pallakanand on 6/19/17.
 */


//@RunWith(AndroidJUnit4.class)

@RunWith(MockitoJUnitRunner.class)

@LargeTest

public class ChatListActivityTest {
    // creating UI device that will connect to emulator
    private UiDevice mDevice;
    // created global variable with timeout time
    private static final int LAUNCH_TIMEOUT = 5000;

    // created my mock object which will be used to ensure that the sign in was lauched successfully
    @Mock
    private LoginActivity loginActivity;

    @Mock
    LoginActivity mockLoginObject;

    @Rule
    // created main activity instance
    public ActivityTestRule<ChatListActivity> mainActivity = new ActivityTestRule <ChatListActivity> (
            ChatListActivity.class);

    // my onCreate function

    @Before
    public void setUp(){
        mainActivity.getActivity();
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mDevice.pressHome();

        final String launchPackage = mDevice.getLauncherPackageName();
        //assertThat(launchPackage,notNullValue() );
        mDevice.wait(Until.hasObject(By.pkg(launchPackage).depth(0)),LAUNCH_TIMEOUT);
        UiObject2 appsButton = mDevice.findObject(By.desc("Apps"));
        appsButton.click();
        mDevice.wait(Until.hasObject(By.text("Edu.Chat")), LAUNCH_TIMEOUT);
        UiObject2 eduChatApp = mDevice.findObject(By.desc("Edu.Chat"));
        eduChatApp.click();
    }


    @Test
    public void onCreate() throws Exception{


    }

    @Test
    public void onPostResume() throws Exception {

    }

    @Test
    public void onRestart() throws Exception {
        assertFalse("restart not working", true);

    }

    @Test
    public void onCreateOptionsMenu() throws Exception {
        assertFalse("onCreate Options menu not working ", true);
    }

    @Test
    public void onBackPressed() throws Exception {

    }

    @Test
    public void onResume() throws Exception {


    }

    @Test
    public void closeFAB() throws Exception {

    }

    @Test
    public void isFABopen() throws Exception {

    }


}