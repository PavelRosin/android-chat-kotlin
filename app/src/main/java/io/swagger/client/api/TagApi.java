

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

import io.swagger.client.model.ChatTagSerializer;
import io.swagger.client.model.ChatTagView;
import io.swagger.client.model.LogoutView;
import io.swagger.client.model.TagView;
import io.swagger.client.model.UserTagSerializer;
import io.swagger.client.model.UserTagView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TagApi {
    private ApiClient apiClient;

    public TagApi() {
        this(Configuration.getDefaultApiClient());
    }

    public TagApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for tagChatCreate */
    private com.squareup.okhttp.Call tagChatCreateCall(ChatTagSerializer chatTagSerializer, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = chatTagSerializer;
        

        // create path and map variables
        String localVarPath = "/v1/tag/chat/".replaceAll("\\{format\\}","json");

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
     * No documentation beyond REST Standards;
     * No documentation beyond REST Standards;
     * @param chatTagSerializer  (optional)
     * @return ChatTagView
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ChatTagView tagChatCreate(ChatTagSerializer chatTagSerializer) throws ApiException {
        ApiResponse<ChatTagView> resp = tagChatCreateWithHttpInfo(chatTagSerializer);
        return resp.getData();
    }

    /**
     * No documentation beyond REST Standards;
     * No documentation beyond REST Standards;
     * @param chatTagSerializer  (optional)
     * @return ApiResponse&lt;ChatTagView&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ChatTagView> tagChatCreateWithHttpInfo(ChatTagSerializer chatTagSerializer) throws ApiException {
        com.squareup.okhttp.Call call = tagChatCreateCall(chatTagSerializer, null, null);
        Type localVarReturnType = new TypeToken<ChatTagView>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * No documentation beyond REST Standards; (asynchronously)
     * No documentation beyond REST Standards;
     * @param chatTagSerializer  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call tagChatCreateAsync(ChatTagSerializer chatTagSerializer, final ApiCallback<ChatTagView> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = tagChatCreateCall(chatTagSerializer, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ChatTagView>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for tagChatDelete */
    private com.squareup.okhttp.Call tagChatDeleteCall(String tag, String chat, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'tag' is set
        if (tag == null) {
            throw new ApiException("Missing the required parameter 'tag' when calling tagChatDelete(Async)");
        }
        
        // verify the required parameter 'chat' is set
        if (chat == null) {
            throw new ApiException("Missing the required parameter 'chat' when calling tagChatDelete(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/v1/tag/{tag}/chat/{chat}/".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "tag" + "\\}", apiClient.escapeString(tag.toString()))
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
     * @param tag  (required)
     * @param chat  (required)
     * @return LogoutView
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public LogoutView tagChatDelete(String tag, String chat) throws ApiException {
        ApiResponse<LogoutView> resp = tagChatDeleteWithHttpInfo(tag, chat);
        return resp.getData();
    }

    /**
     * No documentation beyond REST Standards;
     * No documentation beyond REST Standards;
     * @param tag  (required)
     * @param chat  (required)
     * @return ApiResponse&lt;LogoutView&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<LogoutView> tagChatDeleteWithHttpInfo(String tag, String chat) throws ApiException {
        com.squareup.okhttp.Call call = tagChatDeleteCall(tag, chat, null, null);
        Type localVarReturnType = new TypeToken<LogoutView>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * No documentation beyond REST Standards; (asynchronously)
     * No documentation beyond REST Standards;
     * @param tag  (required)
     * @param chat  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call tagChatDeleteAsync(String tag, String chat, final ApiCallback<LogoutView> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = tagChatDeleteCall(tag, chat, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<LogoutView>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for tagList */
    private com.squareup.okhttp.Call tagListCall(Integer id, String tag, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        

        // create path and map variables
        String localVarPath = "/v1/tag/".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (id != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "id", id));
        if (tag != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "tag", tag));

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
     * No documentation beyond REST Standards;
     * No documentation beyond REST Standards;
     * @param id  (optional)
     * @param tag  (optional)
     * @return TagView
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TagView tagList(Integer id, String tag) throws ApiException {
        ApiResponse<TagView> resp = tagListWithHttpInfo(id, tag);
        return resp.getData();
    }

    /**
     * No documentation beyond REST Standards;
     * No documentation beyond REST Standards;
     * @param id  (optional)
     * @param tag  (optional)
     * @return ApiResponse&lt;TagView&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<TagView> tagListWithHttpInfo(Integer id, String tag) throws ApiException {
        com.squareup.okhttp.Call call = tagListCall(id, tag, null, null);
        Type localVarReturnType = new TypeToken<TagView>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * No documentation beyond REST Standards; (asynchronously)
     * No documentation beyond REST Standards;
     * @param id  (optional)
     * @param tag  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call tagListAsync(Integer id, String tag, final ApiCallback<TagView> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = tagListCall(id, tag, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TagView>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for tagUserCreate */
    private com.squareup.okhttp.Call tagUserCreateCall(UserTagSerializer userTagSerializer, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = userTagSerializer;
        

        // create path and map variables
        String localVarPath = "/v1/tag/user/".replaceAll("\\{format\\}","json");

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
     * No documentation beyond REST Standards;
     * No documentation beyond REST Standards;
     * @param userTagSerializer  (optional)
     * @return UserTagView
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public UserTagView tagUserCreate(UserTagSerializer userTagSerializer) throws ApiException {
        ApiResponse<UserTagView> resp = tagUserCreateWithHttpInfo(userTagSerializer);
        return resp.getData();
    }

    /**
     * No documentation beyond REST Standards;
     * No documentation beyond REST Standards;
     * @param userTagSerializer  (optional)
     * @return ApiResponse&lt;UserTagView&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<UserTagView> tagUserCreateWithHttpInfo(UserTagSerializer userTagSerializer) throws ApiException {
        com.squareup.okhttp.Call call = tagUserCreateCall(userTagSerializer, null, null);
        Type localVarReturnType = new TypeToken<UserTagView>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * No documentation beyond REST Standards; (asynchronously)
     * No documentation beyond REST Standards;
     * @param userTagSerializer  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call tagUserCreateAsync(UserTagSerializer userTagSerializer, final ApiCallback<UserTagView> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = tagUserCreateCall(userTagSerializer, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<UserTagView>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for tagUserDelete */
    private com.squareup.okhttp.Call tagUserDeleteCall(String user, String tag, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'user' is set
        if (user == null) {
            throw new ApiException("Missing the required parameter 'user' when calling tagUserDelete(Async)");
        }
        
        // verify the required parameter 'tag' is set
        if (tag == null) {
            throw new ApiException("Missing the required parameter 'tag' when calling tagUserDelete(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/v1/tag/{tag}/user/{user}/".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "user" + "\\}", apiClient.escapeString(user.toString()))
        .replaceAll("\\{" + "tag" + "\\}", apiClient.escapeString(tag.toString()));

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
     * @param tag  (required)
     * @return LogoutView
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public LogoutView tagUserDelete(String user, String tag) throws ApiException {
        ApiResponse<LogoutView> resp = tagUserDeleteWithHttpInfo(user, tag);
        return resp.getData();
    }

    /**
     * No documentation beyond REST Standards;
     * No documentation beyond REST Standards;
     * @param user  (required)
     * @param tag  (required)
     * @return ApiResponse&lt;LogoutView&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<LogoutView> tagUserDeleteWithHttpInfo(String user, String tag) throws ApiException {
        com.squareup.okhttp.Call call = tagUserDeleteCall(user, tag, null, null);
        Type localVarReturnType = new TypeToken<LogoutView>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * No documentation beyond REST Standards; (asynchronously)
     * No documentation beyond REST Standards;
     * @param user  (required)
     * @param tag  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call tagUserDeleteAsync(String user, String tag, final ApiCallback<LogoutView> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = tagUserDeleteCall(user, tag, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<LogoutView>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
