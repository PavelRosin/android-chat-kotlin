

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

import io.swagger.client.model.APIViewChatSerializer;
import io.swagger.client.model.ChatAllListView;
import io.swagger.client.model.ChatJoinListView;
import io.swagger.client.model.ChatListCreateView;
import io.swagger.client.model.ChatListCreateView1;
import io.swagger.client.model.ChatResourceListView;
import io.swagger.client.model.ChatUpdateDestroyView;
import io.swagger.client.model.LogoutView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatApi {
    private ApiClient apiClient;

    public ChatApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ChatApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for chatAllList */
    private com.squareup.okhttp.Call chatAllListCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        

        // create path and map variables
        String localVarPath = "/v1/chat/all/".replaceAll("\\{format\\}","json");

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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * 
     * 
     * @return ChatAllListView
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ChatAllListView chatAllList() throws ApiException {
        ApiResponse<ChatAllListView> resp = chatAllListWithHttpInfo();
        return resp.getData();
    }

    /**
     * 
     * 
     * @return ApiResponse&lt;ChatAllListView&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ChatAllListView> chatAllListWithHttpInfo() throws ApiException {
        com.squareup.okhttp.Call call = chatAllListCall(null, null);
        Type localVarReturnType = new TypeToken<ChatAllListView>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call chatAllListAsync(final ApiCallback<ChatAllListView> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = chatAllListCall(progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ChatAllListView>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for chatCreate */
    private com.squareup.okhttp.Call chatCreateCall(APIViewChatSerializer apIViewChatSerializer, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = apIViewChatSerializer;
        

        // create path and map variables
        String localVarPath = "/v1/chat/".replaceAll("\\{format\\}","json");

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
     * 
     * 
     * @param apIViewChatSerializer  (optional)
     * @return ChatListCreateView1
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ChatListCreateView1 chatCreate(APIViewChatSerializer apIViewChatSerializer) throws ApiException {
        ApiResponse<ChatListCreateView1> resp = chatCreateWithHttpInfo(apIViewChatSerializer);
        return resp.getData();
    }

    /**
     * 
     * 
     * @param apIViewChatSerializer  (optional)
     * @return ApiResponse&lt;ChatListCreateView1&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ChatListCreateView1> chatCreateWithHttpInfo(APIViewChatSerializer apIViewChatSerializer) throws ApiException {
        com.squareup.okhttp.Call call = chatCreateCall(apIViewChatSerializer, null, null);
        Type localVarReturnType = new TypeToken<ChatListCreateView1>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * 
     * @param apIViewChatSerializer  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call chatCreateAsync(APIViewChatSerializer apIViewChatSerializer, final ApiCallback<ChatListCreateView1> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = chatCreateCall(apIViewChatSerializer, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ChatListCreateView1>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for chatDelete */
    private com.squareup.okhttp.Call chatDeleteCall(String id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling chatDelete(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/v1/chat/{id}/".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

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
     * @param id  (required)
     * @return LogoutView
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public LogoutView chatDelete(String id) throws ApiException {
        ApiResponse<LogoutView> resp = chatDeleteWithHttpInfo(id);
        return resp.getData();
    }

    /**
     * No documentation beyond REST Standards;
     * No documentation beyond REST Standards;
     * @param id  (required)
     * @return ApiResponse&lt;LogoutView&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<LogoutView> chatDeleteWithHttpInfo(String id) throws ApiException {
        com.squareup.okhttp.Call call = chatDeleteCall(id, null, null);
        Type localVarReturnType = new TypeToken<LogoutView>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * No documentation beyond REST Standards; (asynchronously)
     * No documentation beyond REST Standards;
     * @param id  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call chatDeleteAsync(String id, final ApiCallback<LogoutView> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = chatDeleteCall(id, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<LogoutView>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for chatJoinlistList */
    private com.squareup.okhttp.Call chatJoinlistListCall(Integer id, String name, String nameIcontains, String desc, String descIcontains, Boolean isClass, Boolean isAdminChat, Integer parent, Integer offset, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        

        // create path and map variables
        String localVarPath = "/v1/chat/joinlist/".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (id != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "id", id));
        if (name != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "name", name));
        if (nameIcontains != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "name__icontains", nameIcontains));
        if (desc != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "desc", desc));
        if (descIcontains != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "desc__icontains", descIcontains));
        if (isClass != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "is_class", isClass));
        if (isAdminChat != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "is_admin_chat", isAdminChat));
        if (parent != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "parent", parent));
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
     * 
     * 
     * @param id  (optional)
     * @param name  (optional)
     * @param nameIcontains  (optional)
     * @param desc  (optional)
     * @param descIcontains  (optional)
     * @param isClass  (optional)
     * @param isAdminChat  (optional)
     * @param parent  (optional)
     * @param offset  (optional)
     * @param limit  (optional)
     * @return ChatJoinListView
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ChatJoinListView chatJoinlistList(Integer id, String name, String nameIcontains, String desc, String descIcontains, Boolean isClass, Boolean isAdminChat, Integer parent, Integer offset, Integer limit) throws ApiException {
        ApiResponse<ChatJoinListView> resp = chatJoinlistListWithHttpInfo(id, name, nameIcontains, desc, descIcontains, isClass, isAdminChat, parent, offset, limit);
        return resp.getData();
    }

    /**
     * 
     * 
     * @param id  (optional)
     * @param name  (optional)
     * @param nameIcontains  (optional)
     * @param desc  (optional)
     * @param descIcontains  (optional)
     * @param isClass  (optional)
     * @param isAdminChat  (optional)
     * @param parent  (optional)
     * @param offset  (optional)
     * @param limit  (optional)
     * @return ApiResponse&lt;ChatJoinListView&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ChatJoinListView> chatJoinlistListWithHttpInfo(Integer id, String name, String nameIcontains, String desc, String descIcontains, Boolean isClass, Boolean isAdminChat, Integer parent, Integer offset, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = chatJoinlistListCall(id, name, nameIcontains, desc, descIcontains, isClass, isAdminChat, parent, offset, limit, null, null);
        Type localVarReturnType = new TypeToken<ChatJoinListView>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * 
     * @param id  (optional)
     * @param name  (optional)
     * @param nameIcontains  (optional)
     * @param desc  (optional)
     * @param descIcontains  (optional)
     * @param isClass  (optional)
     * @param isAdminChat  (optional)
     * @param parent  (optional)
     * @param offset  (optional)
     * @param limit  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call chatJoinlistListAsync(Integer id, String name, String nameIcontains, String desc, String descIcontains, Boolean isClass, Boolean isAdminChat, Integer parent, Integer offset, Integer limit, final ApiCallback<ChatJoinListView> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = chatJoinlistListCall(id, name, nameIcontains, desc, descIcontains, isClass, isAdminChat, parent, offset, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ChatJoinListView>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for chatList */
    private com.squareup.okhttp.Call chatListCall(Integer id, String name, String nameIcontains, String desc, String descIcontains, Boolean isClass, Boolean isAdminChat, Integer parent, Integer offset, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        

        // create path and map variables
        String localVarPath = "/v1/chat/".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (id != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "id", id));
        if (name != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "name", name));
        if (nameIcontains != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "name__icontains", nameIcontains));
        if (desc != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "desc", desc));
        if (descIcontains != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "desc__icontains", descIcontains));
        if (isClass != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "is_class", isClass));
        if (isAdminChat != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "is_admin_chat", isAdminChat));
        if (parent != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "parent", parent));
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
     * 
     * 
     * @param id  (optional)
     * @param name  (optional)
     * @param nameIcontains  (optional)
     * @param desc  (optional)
     * @param descIcontains  (optional)
     * @param isClass  (optional)
     * @param isAdminChat  (optional)
     * @param parent  (optional)
     * @param offset  (optional)
     * @param limit  (optional)
     * @return ChatListCreateView
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ChatListCreateView chatList(Integer id, String name, String nameIcontains, String desc, String descIcontains, Boolean isClass, Boolean isAdminChat, Integer parent, Integer offset, Integer limit) throws ApiException {
        ApiResponse<ChatListCreateView> resp = chatListWithHttpInfo(id, name, nameIcontains, desc, descIcontains, isClass, isAdminChat, parent, offset, limit);
        return resp.getData();
    }

    /**
     * 
     * 
     * @param id  (optional)
     * @param name  (optional)
     * @param nameIcontains  (optional)
     * @param desc  (optional)
     * @param descIcontains  (optional)
     * @param isClass  (optional)
     * @param isAdminChat  (optional)
     * @param parent  (optional)
     * @param offset  (optional)
     * @param limit  (optional)
     * @return ApiResponse&lt;ChatListCreateView&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ChatListCreateView> chatListWithHttpInfo(Integer id, String name, String nameIcontains, String desc, String descIcontains, Boolean isClass, Boolean isAdminChat, Integer parent, Integer offset, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = chatListCall(id, name, nameIcontains, desc, descIcontains, isClass, isAdminChat, parent, offset, limit, null, null);
        Type localVarReturnType = new TypeToken<ChatListCreateView>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * 
     * @param id  (optional)
     * @param name  (optional)
     * @param nameIcontains  (optional)
     * @param desc  (optional)
     * @param descIcontains  (optional)
     * @param isClass  (optional)
     * @param isAdminChat  (optional)
     * @param parent  (optional)
     * @param offset  (optional)
     * @param limit  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call chatListAsync(Integer id, String name, String nameIcontains, String desc, String descIcontains, Boolean isClass, Boolean isAdminChat, Integer parent, Integer offset, Integer limit, final ApiCallback<ChatListCreateView> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = chatListCall(id, name, nameIcontains, desc, descIcontains, isClass, isAdminChat, parent, offset, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ChatListCreateView>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for chatPartialUpdate */
    private com.squareup.okhttp.Call chatPartialUpdateCall(String id, APIViewChatSerializer apIViewChatSerializer, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = apIViewChatSerializer;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling chatPartialUpdate(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/v1/chat/{id}/".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

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
     * @param id  (required)
     * @param apIViewChatSerializer  (optional)
     * @return ChatUpdateDestroyView
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ChatUpdateDestroyView chatPartialUpdate(String id, APIViewChatSerializer apIViewChatSerializer) throws ApiException {
        ApiResponse<ChatUpdateDestroyView> resp = chatPartialUpdateWithHttpInfo(id, apIViewChatSerializer);
        return resp.getData();
    }

    /**
     * No documentation beyond REST Standards;
     * No documentation beyond REST Standards;
     * @param id  (required)
     * @param apIViewChatSerializer  (optional)
     * @return ApiResponse&lt;ChatUpdateDestroyView&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ChatUpdateDestroyView> chatPartialUpdateWithHttpInfo(String id, APIViewChatSerializer apIViewChatSerializer) throws ApiException {
        com.squareup.okhttp.Call call = chatPartialUpdateCall(id, apIViewChatSerializer, null, null);
        Type localVarReturnType = new TypeToken<ChatUpdateDestroyView>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * No documentation beyond REST Standards; (asynchronously)
     * No documentation beyond REST Standards;
     * @param id  (required)
     * @param apIViewChatSerializer  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call chatPartialUpdateAsync(String id, APIViewChatSerializer apIViewChatSerializer, final ApiCallback<ChatUpdateDestroyView> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = chatPartialUpdateCall(id, apIViewChatSerializer, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ChatUpdateDestroyView>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for chatResourcesList */
    private com.squareup.okhttp.Call chatResourcesListCall(String chat, Integer chat2, Integer id, String createdGte, String text, String textIcontains, String fileName, Boolean fileIsnull, String parent, Integer userId, Integer offset, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'chat' is set
        if (chat == null) {
            throw new ApiException("Missing the required parameter 'chat' when calling chatResourcesList(Async)");
        }
        
        // verify the required parameter 'chat2' is set
        if (chat2 == null) {
            throw new ApiException("Missing the required parameter 'chat2' when calling chatResourcesList(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/v1/chat/{chat}/resources/".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "chat" + "\\}", apiClient.escapeString(chat.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (id != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "id", id));
        if (createdGte != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "created__gte", createdGte));
        if (text != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "text", text));
        if (textIcontains != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "text__icontains", textIcontains));
        if (fileName != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "file__name", fileName));
        if (fileIsnull != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "file__isnull", fileIsnull));
        if (parent != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "parent", parent));
        if (chat2 != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "chat", chat2));
        if (userId != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_id", userId));
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
     * 
     * 
     * @param chat  (required)
     * @param chat2  (required)
     * @param id  (optional)
     * @param createdGte  (optional)
     * @param text  (optional)
     * @param textIcontains  (optional)
     * @param fileName  (optional)
     * @param fileIsnull  (optional)
     * @param parent  (optional)
     * @param userId  (optional)
     * @param offset  (optional)
     * @param limit  (optional)
     * @return ChatResourceListView
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ChatResourceListView chatResourcesList(String chat, Integer chat2, Integer id, String createdGte, String text, String textIcontains, String fileName, Boolean fileIsnull, String parent, Integer userId, Integer offset, Integer limit) throws ApiException {
        ApiResponse<ChatResourceListView> resp = chatResourcesListWithHttpInfo(chat, chat2, id, createdGte, text, textIcontains, fileName, fileIsnull, parent, userId, offset, limit);
        return resp.getData();
    }

    /**
     * 
     * 
     * @param chat  (required)
     * @param chat2  (required)
     * @param id  (optional)
     * @param createdGte  (optional)
     * @param text  (optional)
     * @param textIcontains  (optional)
     * @param fileName  (optional)
     * @param fileIsnull  (optional)
     * @param parent  (optional)
     * @param userId  (optional)
     * @param offset  (optional)
     * @param limit  (optional)
     * @return ApiResponse&lt;ChatResourceListView&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ChatResourceListView> chatResourcesListWithHttpInfo(String chat, Integer chat2, Integer id, String createdGte, String text, String textIcontains, String fileName, Boolean fileIsnull, String parent, Integer userId, Integer offset, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = chatResourcesListCall(chat, chat2, id, createdGte, text, textIcontains, fileName, fileIsnull, parent, userId, offset, limit, null, null);
        Type localVarReturnType = new TypeToken<ChatResourceListView>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * 
     * @param chat  (required)
     * @param chat2  (required)
     * @param id  (optional)
     * @param createdGte  (optional)
     * @param text  (optional)
     * @param textIcontains  (optional)
     * @param fileName  (optional)
     * @param fileIsnull  (optional)
     * @param parent  (optional)
     * @param userId  (optional)
     * @param offset  (optional)
     * @param limit  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call chatResourcesListAsync(String chat, Integer chat2, Integer id, String createdGte, String text, String textIcontains, String fileName, Boolean fileIsnull, String parent, Integer userId, Integer offset, Integer limit, final ApiCallback<ChatResourceListView> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = chatResourcesListCall(chat, chat2, id, createdGte, text, textIcontains, fileName, fileIsnull, parent, userId, offset, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ChatResourceListView>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
