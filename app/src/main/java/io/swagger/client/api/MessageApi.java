

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

import io.swagger.client.model.MessageListCreateView;
import io.swagger.client.model.MessageListCreateView1;
import io.swagger.client.model.MessageSendSerializer;
import io.swagger.client.model.MessageUpVoteListCreateView;
import io.swagger.client.model.MessageUpVoteListCreateView1;
import io.swagger.client.model.MessageUpdateSerializer;
import io.swagger.client.model.MessageUpdateView;
import io.swagger.client.model.UpvoteMessageUserSerializer;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageApi {
    private ApiClient apiClient;

    public MessageApi() {
        this(Configuration.getDefaultApiClient());
    }

    public MessageApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for messageCreate */
    private com.squareup.okhttp.Call messageCreateCall(MessageSendSerializer messageSendSerializer, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = messageSendSerializer;
        

        // create path and map variables
        String localVarPath = "/v1/message/".replaceAll("\\{format\\}","json");

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
     * @param messageSendSerializer  (optional)
     * @return MessageListCreateView1
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public MessageListCreateView1 messageCreate(MessageSendSerializer messageSendSerializer) throws ApiException {
        ApiResponse<MessageListCreateView1> resp = messageCreateWithHttpInfo(messageSendSerializer);
        return resp.getData();
    }

    /**
     * 
     * 
     * @param messageSendSerializer  (optional)
     * @return ApiResponse&lt;MessageListCreateView1&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<MessageListCreateView1> messageCreateWithHttpInfo(MessageSendSerializer messageSendSerializer) throws ApiException {
        com.squareup.okhttp.Call call = messageCreateCall(messageSendSerializer, null, null);
        Type localVarReturnType = new TypeToken<MessageListCreateView1>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * 
     * @param messageSendSerializer  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call messageCreateAsync(MessageSendSerializer messageSendSerializer, final ApiCallback<MessageListCreateView1> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = messageCreateCall(messageSendSerializer, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<MessageListCreateView1>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for messageList */
    private com.squareup.okhttp.Call messageListCall(Integer chat, Integer id, String createdGte, String text, String textIcontains, String fileName, Boolean fileIsnull, Integer parent, Integer userId, Boolean isResolved, Boolean isStarred, Integer offset, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'chat' is set
        if (chat == null) {
            throw new ApiException("Missing the required parameter 'chat' when calling messageList(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/v1/message/".replaceAll("\\{format\\}","json");

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
        if (chat != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "chat", chat));
        if (parent != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "parent", parent));
        if (userId != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_id", userId));
        if (isResolved != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "is_resolved", isResolved));
        if (isStarred != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "is_starred", isStarred));
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
     * @param id  (optional)
     * @param createdGte  (optional)
     * @param text  (optional)
     * @param textIcontains  (optional)
     * @param fileName  (optional)
     * @param fileIsnull  (optional)
     * @param parent  (optional)
     * @param userId  (optional)
     * @param isResolved  (optional)
     * @param isStarred  (optional)
     * @param offset  (optional)
     * @param limit  (optional)
     * @return MessageListCreateView
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public MessageListCreateView messageList(Integer chat, Integer id, String createdGte, String text, String textIcontains, String fileName, Boolean fileIsnull, Integer parent, Integer userId, Boolean isResolved, Boolean isStarred, Integer offset, Integer limit) throws ApiException {
        ApiResponse<MessageListCreateView> resp = messageListWithHttpInfo(chat, id, createdGte, text, textIcontains, fileName, fileIsnull, parent, userId, isResolved, isStarred, offset, limit);
        return resp.getData();
    }

    /**
     * 
     * 
     * @param chat  (required)
     * @param id  (optional)
     * @param createdGte  (optional)
     * @param text  (optional)
     * @param textIcontains  (optional)
     * @param fileName  (optional)
     * @param fileIsnull  (optional)
     * @param parent  (optional)
     * @param userId  (optional)
     * @param isResolved  (optional)
     * @param isStarred  (optional)
     * @param offset  (optional)
     * @param limit  (optional)
     * @return ApiResponse&lt;MessageListCreateView&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<MessageListCreateView> messageListWithHttpInfo(Integer chat, Integer id, String createdGte, String text, String textIcontains, String fileName, Boolean fileIsnull, Integer parent, Integer userId, Boolean isResolved, Boolean isStarred, Integer offset, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = messageListCall(chat, id, createdGte, text, textIcontains, fileName, fileIsnull, parent, userId, isResolved, isStarred, offset, limit, null, null);
        Type localVarReturnType = new TypeToken<MessageListCreateView>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * 
     * @param chat  (required)
     * @param id  (optional)
     * @param createdGte  (optional)
     * @param text  (optional)
     * @param textIcontains  (optional)
     * @param fileName  (optional)
     * @param fileIsnull  (optional)
     * @param parent  (optional)
     * @param userId  (optional)
     * @param isResolved  (optional)
     * @param isStarred  (optional)
     * @param offset  (optional)
     * @param limit  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call messageListAsync(Integer chat, Integer id, String createdGte, String text, String textIcontains, String fileName, Boolean fileIsnull, Integer parent, Integer userId, Boolean isResolved, Boolean isStarred, Integer offset, Integer limit, final ApiCallback<MessageListCreateView> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = messageListCall(chat, id, createdGte, text, textIcontains, fileName, fileIsnull, parent, userId, isResolved, isStarred, offset, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<MessageListCreateView>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for messagePartialUpdate */
    private com.squareup.okhttp.Call messagePartialUpdateCall(String id, MessageUpdateSerializer messageUpdateSerializer, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = messageUpdateSerializer;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling messagePartialUpdate(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/v1/message/{id}/".replaceAll("\\{format\\}","json")
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
     * @param messageUpdateSerializer  (optional)
     * @return MessageUpdateView
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public MessageUpdateView messagePartialUpdate(String id, MessageUpdateSerializer messageUpdateSerializer) throws ApiException {
        ApiResponse<MessageUpdateView> resp = messagePartialUpdateWithHttpInfo(id, messageUpdateSerializer);
        return resp.getData();
    }

    /**
     * No documentation beyond REST Standards;
     * No documentation beyond REST Standards;
     * @param id  (required)
     * @param messageUpdateSerializer  (optional)
     * @return ApiResponse&lt;MessageUpdateView&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<MessageUpdateView> messagePartialUpdateWithHttpInfo(String id, MessageUpdateSerializer messageUpdateSerializer) throws ApiException {
        com.squareup.okhttp.Call call = messagePartialUpdateCall(id, messageUpdateSerializer, null, null);
        Type localVarReturnType = new TypeToken<MessageUpdateView>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * No documentation beyond REST Standards; (asynchronously)
     * No documentation beyond REST Standards;
     * @param id  (required)
     * @param messageUpdateSerializer  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call messagePartialUpdateAsync(String id, MessageUpdateSerializer messageUpdateSerializer, final ApiCallback<MessageUpdateView> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = messagePartialUpdateCall(id, messageUpdateSerializer, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<MessageUpdateView>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for messageUpvoteCreate */
    private com.squareup.okhttp.Call messageUpvoteCreateCall(UpvoteMessageUserSerializer upvoteMessageUserSerializer, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = upvoteMessageUserSerializer;
        

        // create path and map variables
        String localVarPath = "/v1/message/upvote/".replaceAll("\\{format\\}","json");

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
     * @param upvoteMessageUserSerializer  (optional)
     * @return MessageUpVoteListCreateView1
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public MessageUpVoteListCreateView1 messageUpvoteCreate(UpvoteMessageUserSerializer upvoteMessageUserSerializer) throws ApiException {
        ApiResponse<MessageUpVoteListCreateView1> resp = messageUpvoteCreateWithHttpInfo(upvoteMessageUserSerializer);
        return resp.getData();
    }

    /**
     * 
     * 
     * @param upvoteMessageUserSerializer  (optional)
     * @return ApiResponse&lt;MessageUpVoteListCreateView1&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<MessageUpVoteListCreateView1> messageUpvoteCreateWithHttpInfo(UpvoteMessageUserSerializer upvoteMessageUserSerializer) throws ApiException {
        com.squareup.okhttp.Call call = messageUpvoteCreateCall(upvoteMessageUserSerializer, null, null);
        Type localVarReturnType = new TypeToken<MessageUpVoteListCreateView1>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * 
     * @param upvoteMessageUserSerializer  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call messageUpvoteCreateAsync(UpvoteMessageUserSerializer upvoteMessageUserSerializer, final ApiCallback<MessageUpVoteListCreateView1> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = messageUpvoteCreateCall(upvoteMessageUserSerializer, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<MessageUpVoteListCreateView1>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for messageUpvoteList */
    private com.squareup.okhttp.Call messageUpvoteListCall(String message, Integer offset, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        

        // create path and map variables
        String localVarPath = "/v1/message/upvote/".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (message != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "message", message));
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
     * @param message  (optional)
     * @param offset  (optional)
     * @param limit  (optional)
     * @return MessageUpVoteListCreateView
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public MessageUpVoteListCreateView messageUpvoteList(String message, Integer offset, Integer limit) throws ApiException {
        ApiResponse<MessageUpVoteListCreateView> resp = messageUpvoteListWithHttpInfo(message, offset, limit);
        return resp.getData();
    }

    /**
     * 
     * 
     * @param message  (optional)
     * @param offset  (optional)
     * @param limit  (optional)
     * @return ApiResponse&lt;MessageUpVoteListCreateView&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<MessageUpVoteListCreateView> messageUpvoteListWithHttpInfo(String message, Integer offset, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = messageUpvoteListCall(message, offset, limit, null, null);
        Type localVarReturnType = new TypeToken<MessageUpVoteListCreateView>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * 
     * @param message  (optional)
     * @param offset  (optional)
     * @param limit  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call messageUpvoteListAsync(String message, Integer offset, Integer limit, final ApiCallback<MessageUpVoteListCreateView> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = messageUpvoteListCall(message, offset, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<MessageUpVoteListCreateView>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
