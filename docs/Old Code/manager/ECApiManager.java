package edu_chat.android.com.edu_chat.manager;

import android.app.Activity;
import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

//import com.loopj.android.http.AsyncHttpClient;
//import com.loopj.android.http.AsyncHttpResponseHandler;
//import com.loopj.android.http.RequestParams;
//import com.loopj.android.http.SyncHttpClient;

//import cz.msebera.android.httpclient.Header;


/**
 * Created by Jacob Niebloom on 9/21/2015.
 * Edu.Chat Inc.
 */
public final class ECApiManager {

    private static final String loginAPI = "/api/login";
    private static final String signUpAPI = "/onboarding/submit";
    private static final String loadOutAPI = "/message/loadout";
    private static final String sendMessageURL = "/message/send";
    private static final String loadChatRoomURL = "/message/load_chat";
    private static final String logoutURL = "/api/logout";
    private static final String createChatURL = "/chat/create_chat";
    private static final String groupChatDetailsURL = "/message/chat_resource_details";
    private static final String userProfileURL = "/api/user";
    private static final String commentURL = "/message/load_comments";
    private static final String deleteUserURL = "/chat/delete_chat_user";
    private static final String searchUserURL = "/search/search_user";
    private static final String searchUniversityURL = "/search/search_university";
    //    private static final String sendInviteURL = "/invite/send_chat_invite";
    private static final String sendInviteURL = "/chat/add_users";
//    private static final AsyncHttpClient syncHttpClient = new SyncHttpClient();
//    private static final AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
    private static String baseURL;
    private static boolean networkStatus = true;


    public static boolean isTheNetworkGoodNow() {
        return networkStatus;
    }


    public static void checkNetworkConnectivity(final Activity activity) {
        final TelephonyManager myTelephonyManager = (TelephonyManager) activity.getSystemService(
                Context.TELEPHONY_SERVICE);

        final PhoneStateListener callStateListener = new PhoneStateListener() {
            @Override public void onDataConnectionStateChanged(final int state) {
                if (state == TelephonyManager.DATA_CONNECTED) {
                    Log.i("State: ", "connected");
                    networkStatus = true;
                } else if (state == TelephonyManager.DATA_DISCONNECTED) {
                    Log.i("State: ", "Offline");
                    networkStatus = false;
                    Toast.makeText(activity.getApplicationContext(),
                                   "Offline", Toast.LENGTH_LONG
                    ).show();
                } else if (state == TelephonyManager.DATA_SUSPENDED) {
                    Log.i("State: ", "IDLE");
                    networkStatus = false;
                    Toast.makeText(activity.getApplicationContext(),
                                   "IDLE", Toast.LENGTH_LONG
                    ).show();
                }
            }
        };
        myTelephonyManager.listen(
                callStateListener,
                PhoneStateListener.LISTEN_DATA_CONNECTION_STATE
        );

    }
//        TODO: Swaggerfy
//    private static void get(final String url, @NonNull final RequestParams params, final
//    AsyncHttpResponseHandler
//            responseHandler) {
//        Log.d("API_GET", String.format("%s%s", url, params));
//        getClient().get(url, params, responseHandler);
//    }

//    private static void post(final String url, @NonNull final RequestParams params, final
//    AsyncHttpResponseHandler
//            responseHandler) {
//        Log.d("API_POST", String.format("%s%s", url, params));
//        getClient().post(url, params, responseHandler);
//    }

    public static void setBaseURL(final String newBaseURL) {

        baseURL = newBaseURL;

    }

    /**
     * @return an async client when calling from the main thread, otherwise a sync client.
     */
//    @NonNull
            //        TODO: Swaggerfy
//    private static AsyncHttpClient getClient() {
//        return Looper.myLooper() == null ? syncHttpClient : asyncHttpClient;
//    }
//        TODO: Swaggerfy
//    interface AllECApiCallsInterface {
//        void onSuccessGlobal(int statusCode, Header[] headers, byte[] responseBody);
//
//        void onFailureGlobal(int statusCode, Header[] headers, byte[] responseBody, Throwable
//                error);
//
//        void onFinishGlobal();
//    }

    private static class AllECApiCalls {
        //        TODO: Swaggerfy
//
//        private AllECApiCallsInterface adapter;
//        private String url;
//        private RequestParams params;
//        private JSONObject obj;
//        private String userHash;
//
//        String getUserHash() {
//            return this.userHash;
//        }
//
//        void setUserHash(final String userHash) {
//            this.userHash = userHash;
//        }
//
//        void setAdapter(final AllECApiCallsInterface adapter) {
//            this.adapter = adapter;
//        }
//
//        protected JSONObject getObj() {
//            return this.obj;
//        }
//
//        public void setObj(final JSONObject obj) {
//            this.obj = obj;
//        }
//
//
//        public void invokeGet(final Activity activity) {
//            //Log.d("State:", "Connected? " + networkStatus);
//            if (networkStatus) {
//                this.params.put("platform", "android");
//                if (ECUser.getUserToken() != null) {
//                    getClient().addHeader("Authorization", "Token " + ECUser.getUserToken());
//                } else {
//                    Log.d("UserToken status:", "Null user token");
//                }
//                get(this.url, this.params, new MyAsyncHttpResponseHandler());
//            } else {
//                this.alertUserforNoNetworkConnection(activity);
//            }
//        }
//
//        public void invokePost(final Activity activity) {
//            if (networkStatus) {
//                this.params.put("platform", "android");
//                if (ECUser.getUserToken() != null)
//                    getClient().addHeader("Authorization", "Token " + ECUser.getUserToken());
//                post(this.url, this.params, new MyAsyncHttpResponseHandler());
//            } else {
//                this.alertUserforNoNetworkConnection(activity);
//            }
//        }

        private void alertUserforNoNetworkConnection(final Activity activity) {
            Log.d("Status", "alerting user for no network connection");
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(
                            activity.getBaseContext(),
                            "Network Failure, please try again",
                            Toast.LENGTH_LONG
                    ).show();
                }
            });

        }


//        public void setParams(final RequestParams params) {
//            this.params = params;
//        }
//
//        void setUrl(final String url) {
//            this.url = url;
//        }
//
//        public AllECApiCallsInterface getAdapter() {
//            return this.adapter;
//        }
//
//        private class MyAsyncHttpResponseHandler extends AsyncHttpResponseHandler {
//            MyAsyncHttpResponseHandler() {super();}
//
//            @Override
//            public void onFinish() {
//                AllECApiCalls.this.getAdapter().onFinishGlobal();
//            }
//
//            @Override
//            public void onSuccess(final int statusCode, final Header[] headers, final byte[]
//                    responseBody) {
//                AllECApiCalls.this.getAdapter().onSuccessGlobal(statusCode, headers, responseBody);
//
//            }
//
//            @Override
//            public void onFailure(final int statusCode, final Header[] headers, final byte[]
//                    responseBody,
//                                  @NonNull final Throwable error) {
//                AllECApiCalls.this.getAdapter().onFailureGlobal(statusCode, headers, responseBody,
//                                                                error
//                );
//                error.printStackTrace();
//            }
//

        }
    }

    /**
     * This class will load update the chatroom with new messages as soon as the user enters the
     * chat room.
     */
//    public static class LoadChatMessageObject extends AllECApiCalls implements
//            AllECApiCallsInterface {
//
//        protected LoadChatMessageObject(final RequestParams params) {
//            super();
//            super.setAdapter(this);
//            super.setParams(params);
//            super.setUrl(baseURL + loadChatRoomURL);
//            Log.d("State: ", "trying to call loadchat room with " + networkStatus);
//        }
//
//        @Override
//        public void onSuccessGlobal(final int statusCode, final Header[] headers, @NonNull final
//        byte[]
//                responseBody) {
//            super.setUserHash(new String(responseBody));
//            try {
//                super.setObj(new JSONObject(super.getUserHash()));
//            } catch (final JSONException e) {
//                e.printStackTrace();
//            }
//        }
//
//        @Override
//        public void onFailureGlobal(final int statusCode, final Header[] headers, final byte[]
//                responseBody,
//                                    final Throwable error) {
//        }
//
//        @Override
//        public void onFinishGlobal() {
//        }
//    }
//
//    /**
//     * This class will set current user token, school, and will login the current user in.
//     */
//    public static class LoginObject extends AllECApiCalls implements AllECApiCallsInterface {
//
//        protected boolean isConnectSuccessful;
//        protected boolean isLoginSuccessful;
//
//        protected LoginObject(final RequestParams params) {
//            super();
//            Log.d("JACOB", FirebaseInstanceId.getInstance().getToken());
//            params.put("push_token", FirebaseInstanceId.getInstance().getToken());
////            params.put("push_token", "abcd");
//            super.setAdapter(this);
//            super.setParams(params);
//            super.setUrl(baseURL + loginAPI);
//        }
//
//        @Override
//        public void onSuccessGlobal(final int statusCode, final Header[] headers, @NonNull final
//        byte[]
//                responseBody) {
//            super.setUserHash(new String(responseBody));
//            try {
//                super.setObj(new JSONObject(super.getUserHash()));
//            } catch (final JSONException e) {
//                e.printStackTrace();
//            }
//            Log.d("LOGIN", "success " + new String(responseBody));
//        }
//
//        @Override
//        public void onFailureGlobal(final int statusCode, final Header[] headers, @NonNull final
//        byte[]
//                responseBody, final Throwable error) {
//            Log.d("LOGIN", "failure " + new String(responseBody));
//        }
//
//        @Override
//        public void onFinishGlobal() {
//            try {
//                if (this.getObj() != null) {
//                    ECUser.setUserToken(this.getObj().getString("token"));
//                    ECUser.setCurrentUser(new ECUser(this.getObj().getJSONObject("user")));
//                }
//            } catch (@NonNull JSONException | ParseException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
//
//    public static class SignUpObject extends AllECApiCalls implements AllECApiCallsInterface {
//
//        protected SignUpObject(final RequestParams params) {
//            super();
//            super.setAdapter(this);
//            super.setParams(params);
//            super.setUrl(baseURL + signUpAPI);
//        }
//
//        @Override
//        public void onSuccessGlobal(final int statusCode, final Header[] headers, final byte[]
//                responseBody) {
//        }
//
//        @Override
//        public void onFailureGlobal(final int statusCode, final Header[] headers, final byte[]
//                responseBody,
//                                    final Throwable error) {
//        }
//
//        @Override
//        public void onFinishGlobal() {
//        }
//    }
//
//	/*
//    This static class is used for loading the details of a chat
//	 */
//
//    public static class ChatDetailsObject extends AllECApiCalls
//            implements AllECApiCallsInterface {
//
//        protected ChatDetailsObject(final RequestParams params) {
//            super();
//            super.setAdapter(this);
//            super.setParams(params);
//            super.setUrl(baseURL + groupChatDetailsURL);
//        }
//
//        @Override
//        public void onSuccessGlobal(final int statusCode, final Header[] headers, final byte[]
//                responseBody) {
//        }
//
//        @Override
//        public void onFailureGlobal(final int statusCode, final Header[] headers, final byte[]
//                responseBody,
//                                    final Throwable error) {
//        }
//
//        @Override
//        public void onFinishGlobal() {
//        }
//    }
//
//
//    public static class LoadCommentObject extends AllECApiCalls implements
//            AllECApiCallsInterface {
//
//        protected LoadCommentObject(final RequestParams params) {
//            super();
//            super.setAdapter(this);
//            super.setParams(params);
//            super.setUrl(baseURL + commentURL);
//
//        }
//
//        @Override
//        public void onSuccessGlobal(final int statusCode, final Header[] headers, final byte[]
//                responseBody) {
//        }
//
//        @Override
//        public void onFailureGlobal(final int statusCode, final Header[] headers, final byte[]
//                responseBody,
//                                    final Throwable error) {
//        }
//
//        @Override
//        public void onFinishGlobal() {
//        }
//    }
//
//    public static class LoadUsersObject extends AllECApiCalls implements
//            AllECApiCallsInterface {
//
//        protected LoadUsersObject(final RequestParams params) {
//            super();
//            super.setAdapter(this);
//            super.setParams(params);
//            super.setUrl(baseURL + searchUserURL);
//        }
//
//        @Override
//        public void onSuccessGlobal(final int statusCode, final Header[] headers, final byte[]
//                responseBody) {
//        }
//
//        @Override
//        public void onFailureGlobal(final int statusCode, final Header[] headers, final byte[]
//                responseBody,
//                                    final Throwable error) {
//        }
//
//        @Override
//        public void onFinishGlobal() {
//        }
//    }
//
//
//    public static class LoadSchoolNamesObject extends AllECApiCalls implements
//            AllECApiCallsInterface {
//
//        protected LoadSchoolNamesObject(final RequestParams params) {
//            super();
//            super.setAdapter(this);
//            super.setParams(params);
//            super.setUrl(baseURL + searchUniversityURL);
//        }
//
//        @Override
//        public void onSuccessGlobal(final int statusCode, final Header[] headers, final byte[]
//                responseBody) {
//        }
//
//        @Override
//        public void onFailureGlobal(final int statusCode, final Header[] headers, final byte[]
//                responseBody,
//                                    final Throwable error) {
//
//        }
//
//        @Override
//        public void onFinishGlobal() {
//        }
//    }
//
//
//    /**
//     * This class will build and populate each Recyclerview in the application's MainActivity.
//     */
//    public static class MainLoadOutObject extends AllECApiCalls implements
//            AllECApiCallsInterface {
//
//        protected MainLoadOutObject(final RequestParams params) {
//            super();
//            super.setAdapter(this);
//            super.setParams(params);
//            super.setUrl(baseURL + loadOutAPI);
//        }
//
//        @Override
//        public void onSuccessGlobal(final int statusCode, final Header[] headers, @NonNull final
//        byte[]
//                responseBody) {
//            super.setUserHash(new String(responseBody));
//            try {
//                super.setObj(new JSONObject(super.getUserHash()));
//            } catch (final JSONException e) {
//                e.printStackTrace();
//            }
//        }
//
//        @Override
//        public void onFailureGlobal(final int statusCode, final Header[] headers, final byte[]
//                responseBody,
//                                    final Throwable error) {
//        }
//
//        @Override
//        public void onFinishGlobal() {
//        }
//
//    }
//
//    /**
//     * This class will log the user out.
//     */
//    public static class LogoutObject extends AllECApiCalls implements AllECApiCallsInterface {
//
//        protected LogoutObject(final RequestParams params) {
//            super();
//            super.setAdapter(this);
//            super.setParams(params);
//            super.setUrl(baseURL + logoutURL);
//        }
//
//        @Override
//        public void onSuccessGlobal(final int statusCode, final Header[] headers, @NonNull final
//        byte[]
//                responseBody) {
//            super.setUserHash(new String(responseBody));
//            try {
//                super.setObj(new JSONObject(super.getUserHash()));
//            } catch (final JSONException e) {
//                e.printStackTrace();
//            }
//        }
//
//        @Override
//        public void onFailureGlobal(final int statusCode, final Header[] headers, final byte[]
//                responseBody,
//                                    final Throwable error) {
//        }
//
//        @Override
//        public void onFinishGlobal() {
//        }
//
//    }
//
//    /**
//     * This class will send messages for the user.
//     */
//    public static class SendMessageObject extends AllECApiCalls implements
//            AllECApiCallsInterface {
//
//        protected SendMessageObject(final RequestParams params) {
//            super();
//            super.setAdapter(this);
//            super.setParams(params);
//            super.setUrl(baseURL + sendMessageURL);
//        }
//
//        @Override
//        public void onSuccessGlobal(final int statusCode, final Header[] headers, @NonNull final
//        byte[]
//                responseBody) {
//            super.setUserHash(new String(responseBody));
//            try {
//                super.setObj(new JSONObject(super.getUserHash()));
//            } catch (final JSONException e) {
//                e.printStackTrace();
//            }
//        }
//
//        @Override
//        public void onFailureGlobal(final int statusCode, final Header[] headers, final byte[]
//                responseBody,
//                                    final Throwable error) {
//        }
//
//        @Override
//        public void onFinishGlobal() {
//        }
//    }
//
//    /**
//     * This class will create a chat
//     */
//    public static class CreateChatObject extends AllECApiCalls implements
//            AllECApiCallsInterface {
//
//        protected CreateChatObject(final RequestParams params) {
//            super();
//            super.setAdapter(this);
//            super.setParams(params);
//            super.setUrl(baseURL + createChatURL);
//        }
//
//        @Override
//        public void onSuccessGlobal(final int statusCode, final Header[] headers, @NonNull final
//        byte[]
//                responseBody) {
//            final String resp = new String(responseBody);
//            Log.d("CREATE CHAT", resp);
//        }
//
//        @Override
//        public void onFailureGlobal(final int statusCode, final Header[] headers, @NonNull final
//        byte[]
//                responseBody, final Throwable error) {
//            final String resp = new String(responseBody);
//            Log.d("CREATE CHAT", "failure" + resp);
//        }
//
//        @Override
//        public void onFinishGlobal() {
//        }
//    }
//
//    public static class GetUserProfileObject extends AllECApiCalls implements
//            AllECApiCallsInterface {
//
//        protected GetUserProfileObject(final RequestParams params) {
//            super();
//            super.setAdapter(this);
//            super.setParams(params);
//            super.setUrl(baseURL + userProfileURL);
//        }
//
//        @Override
//        public void onSuccessGlobal(final int statusCode, final Header[] headers, final byte[]
//                responseBody) {
//        }
//
//        @Override
//        public void onFailureGlobal(final int statusCode, final Header[] headers, final byte[]
//                responseBody,
//                                    final Throwable error) {
//        }
//
//        @Override
//        public void onFinishGlobal() {
//        }
//    }
//
//    public static class DeleteUserfromChatObject extends AllECApiCalls implements
//            AllECApiCallsInterface {
//
//        protected DeleteUserfromChatObject(final RequestParams params) {
//            super();
//            super.setAdapter(this);
//            super.setParams(params);
//            super.setUrl(baseURL + deleteUserURL);
//        }
//
//        @Override
//        public void onSuccessGlobal(final int statusCode, final Header[] headers, final byte[]
//                responseBody) {
//        }
//
//        @Override
//        public void onFailureGlobal(final int statusCode, final Header[] headers, final byte[]
//                responseBody,
//                                    final Throwable error) {
//        }
//
//        @Override
//        public void onFinishGlobal() {
//        }
//    }
//
//
//    public static class SendInviteObject extends AllECApiCalls implements
//            AllECApiCallsInterface {
//
//        protected SendInviteObject(final RequestParams params) {
//            super();
//            super.setAdapter(this);
//            super.setParams(params);
//            super.setUrl(baseURL + sendInviteURL);
//        }
//
//        @Override
//        public void onSuccessGlobal(final int statusCode, final Header[] headers, final byte[]
//                responseBody) {
//        }
//
//        @Override
//        public void onFailureGlobal(final int statusCode, final Header[] headers, final byte[]
//                responseBody,
//                                    final Throwable error) {
//        }
//
//        @Override
//        public void onFinishGlobal() {
//        }
//    }

//}