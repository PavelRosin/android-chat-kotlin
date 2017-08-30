

package io.swagger.client.api;

import io.swagger.client.ApiCallback;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.ProgressRequestBody;
import io.swagger.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import io.swagger.client.model.ChatUserListCreateView;
import io.swagger.client.model.ChatUserPostSerializer;
import io.swagger.client.model.ChatUserPromotionSerializer;
import io.swagger.client.model.ChatUserUpdateDestroyView;
import io.swagger.client.model.LogoutView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chat_userApi {
    private ApiClient apiClient;

    public Chat_userApi() {
        this(Configuration.getDefaultApiClient());
    }

    public Chat_userApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for chatUserCreate */
    private com.squareup.okhttp.Call chatUserCreateCall(ChatUserPostSerializer chatUserPostSerializer, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = chatUserPostSerializer;
        

        // create path and map variables
        String localVarPath = "/v1/chat_user/".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "Token" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Filter by {
     * Filter by {
     * @param chatUserPostSerializer  (optional)
     * @return ChatUserListCreateView
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ChatUserListCreateView chatUserCreate(ChatUserPostSerializer chatUserPostSerializer) throws ApiException {
        ApiResponse<ChatUserListCreateView> resp = chatUserCreateWithHttpInfo(chatUserPostSerializer);
        return resp.getData();
    }

    /**
     * Filter by {
     * Filter by {
     * @param chatUserPostSerializer  (optional)
     * @return ApiResponse&lt;ChatUserListCreateView&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ChatUserListCreateView> chatUserCreateWithHttpInfo(ChatUserPostSerializer chatUserPostSerializer) throws ApiException {
        com.squareup.okhttp.Call call = chatUserCreateCall(chatUserPostSerializer, null, null);
        Type localVarReturnType = new TypeToken<ChatUserListCreateView>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Filter by { (asynchronously)
     * Filter by {
     * @param chatUserPostSerializer  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call chatUserCreateAsync(ChatUserPostSerializer chatUserPostSerializer, final ApiCallback<ChatUserListCreateView> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = chatUserCreateCall(chatUserPostSerializer, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ChatUserListCreateView>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for chatUserDelete */
    private com.squareup.okhttp.Call chatUserDeleteCall(String user, String chat, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'user' is set
        if (user == null) {
            throw new ApiException("Missing the required parameter 'user' when calling chatUserDelete(Async)");
        }
        
        // verify the required parameter 'chat' is set
        if (chat == null) {
            throw new ApiException("Missing the required parameter 'chat' when calling chatUserDelete(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/v1/chat_user/{chat}/{user}/".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "user" + "\\}", apiClient.escapeString(user.toString()))
        .replaceAll("\\{" + "chat" + "\\}", apiClient.escapeString(chat.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "Token" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * No documentation beyond REST Standards;
     * No documentation beyond REST Standards;
     * @param user  (required)
     * @param chat  (required)
     * @return LogoutView
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public LogoutView chatUserDelete(String user, String chat) throws ApiException {
        ApiResponse<LogoutView> resp = chatUserDeleteWithHttpInfo(user, chat);
        return resp.getData();
    }

    /**
     * No documentation beyond REST Standards;
     * No documentation beyond REST Standards;
     * @param user  (required)
     * @param chat  (required)
     * @return ApiResponse&lt;LogoutView&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<LogoutView> chatUserDeleteWithHttpInfo(String user, String chat) throws ApiException {
        com.squareup.okhttp.Call call = chatUserDeleteCall(user, chat, null, null);
        Type localVarReturnType = new TypeToken<LogoutView>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * No documentation beyond REST Standards; (asynchronously)
     * No documentation beyond REST Standards;
     * @param user  (required)
     * @param chat  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call chatUserDeleteAsync(String user, String chat, final ApiCallback<LogoutView> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = chatUserDeleteCall(user, chat, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<LogoutView>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for chatUserList */
    private com.squareup.okhttp.Call chatUserListCall(Integer chat, Integer user, Boolean privileged, Integer offset, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        

        // create path and map variables
        String localVarPath = "/v1/chat_user/".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (chat != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "chat", chat));
        if (user != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user", user));
        if (privileged != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "privileged", privileged));
        if (offset != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "offset", offset));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "Token" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Filter by {
     * Filter by {
     * @param chat  (optional)
     * @param user  (optional)
     * @param privileged  (optional)
     * @param offset  (optional)
     * @param limit  (optional)
     * @return ChatUserListCreateView
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ChatUserListCreateView chatUserList(Integer chat, Integer user, Boolean privileged, Integer offset, Integer limit) throws ApiException {
        ApiResponse<ChatUserListCreateView> resp = chatUserListWithHttpInfo(chat, user, privileged, offset, limit);
        return resp.getData();
    }

    /**
     * Filter by {
     * Filter by {
     * @param chat  (optional)
     * @param user  (optional)
     * @param privileged  (optional)
     * @param offset  (optional)
     * @param limit  (optional)
     * @return ApiResponse&lt;ChatUserListCreateView&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ChatUserListCreateView> chatUserListWithHttpInfo(Integer chat, Integer user, Boolean privileged, Integer offset, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = chatUserListCall(chat, user, privileged, offset, limit, null, null);
        Type localVarReturnType = new TypeToken<ChatUserListCreateView>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Filter by { (asynchronously)
     * Filter by {
     * @param chat  (optional)
     * @param user  (optional)
     * @param privileged  (optional)
     * @param offset  (optional)
     * @param limit  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call chatUserListAsync(Integer chat, Integer user, Boolean privileged, Integer offset, Integer limit, final ApiCallback<ChatUserListCreateView> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = chatUserListCall(chat, user, privileged, offset, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ChatUserListCreateView>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for chatUserPartialUpdate */
    private com.squareup.okhttp.Call chatUserPartialUpdateCall(String user, String chat, ChatUserPromotionSerializer chatUserPromotionSerializer, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = chatUserPromotionSerializer;
        
        // verify the required parameter 'user' is set
        if (user == null) {
            throw new ApiException("Missing the required parameter 'user' when calling chatUserPartialUpdate(Async)");
        }
        
        // verify the required parameter 'chat' is set
        if (chat == null) {
            throw new ApiException("Missing the required parameter 'chat' when calling chatUserPartialUpdate(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/v1/chat_user/{chat}/{user}/".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "user" + "\\}", apiClient.escapeString(user.toString()))
        .replaceAll("\\{" + "chat" + "\\}", apiClient.escapeString(chat.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "Token" };
        return apiClient.buildCall(localVarPath, "PATCH", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * No documentation beyond REST Standards;
     * No documentation beyond REST Standards;
     * @param user  (required)
     * @param chat  (required)
     * @param chatUserPromotionSerializer  (optional)
     * @return ChatUserUpdateDestroyView
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ChatUserUpdateDestroyView chatUserPartialUpdate(String user, String chat, ChatUserPromotionSerializer chatUserPromotionSerializer) throws ApiException {
        ApiResponse<ChatUserUpdateDestroyView> resp = chatUserPartialUpdateWithHttpInfo(user, chat, chatUserPromotionSerializer);
        return resp.getData();
    }

    /**
     * No documentation beyond REST Standards;
     * No documentation beyond REST Standards;
     * @param user  (required)
     * @param chat  (required)
     * @param chatUserPromotionSerializer  (optional)
     * @return ApiResponse&lt;ChatUserUpdateDestroyView&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ChatUserUpdateDestroyView> chatUserPartialUpdateWithHttpInfo(String user, String chat, ChatUserPromotionSerializer chatUserPromotionSerializer) throws ApiException {
        com.squareup.okhttp.Call call = chatUserPartialUpdateCall(user, chat, chatUserPromotionSerializer, null, null);
        Type localVarReturnType = new TypeToken<ChatUserUpdateDestroyView>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * No documentation beyond REST Standards; (asynchronously)
     * No documentation beyond REST Standards;
     * @param user  (required)
     * @param chat  (required)
     * @param chatUserPromotionSerializer  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call chatUserPartialUpdateAsync(String user, String chat, ChatUserPromotionSerializer chatUserPromotionSerializer, final ApiCallback<ChatUserUpdateDestroyView> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = chatUserPartialUpdateCall(user, chat, chatUserPromotionSerializer, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ChatUserUpdateDestroyView>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
