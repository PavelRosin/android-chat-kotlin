

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

import io.swagger.client.model.APIViewUserSerializer;
import io.swagger.client.model.Login;
import io.swagger.client.model.LogoutView;
import io.swagger.client.model.UserListView;
import io.swagger.client.model.UserPreferenceSerializer;
import io.swagger.client.model.UserPreferencesRetreiveView;
import io.swagger.client.model.UserTokenRetrieveView;
import io.swagger.client.model.UserUpdateSerializer;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserApi {
    private ApiClient apiClient;

    public UserApi() {
        this(Configuration.getDefaultApiClient());
    }

    public UserApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for userList */
    private com.squareup.okhttp.Call userListCall(Integer id, String firstName, String firstNameIcontains, String firstNameIstartswith, String lastName, String lastNameIcontains, String authEmail, String smartSearch, Integer offset, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        

        // create path and map variables
        String localVarPath = "/v1/user/".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (id != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "id", id));
        if (firstName != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "first_name", firstName));
        if (firstNameIcontains != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "first_name__icontains", firstNameIcontains));
        if (firstNameIstartswith != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "first_name__istartswith", firstNameIstartswith));
        if (lastName != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "last_name", lastName));
        if (lastNameIcontains != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "last_name__icontains", lastNameIcontains));
        if (authEmail != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "auth__email", authEmail));
        if (smartSearch != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "smart_search", smartSearch));
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
     * @param firstName  (optional)
     * @param firstNameIcontains  (optional)
     * @param firstNameIstartswith  (optional)
     * @param lastName  (optional)
     * @param lastNameIcontains  (optional)
     * @param authEmail  (optional)
     * @param smartSearch  (optional)
     * @param offset  (optional)
     * @param limit  (optional)
     * @return UserListView
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public UserListView userList(Integer id, String firstName, String firstNameIcontains, String firstNameIstartswith, String lastName, String lastNameIcontains, String authEmail, String smartSearch, Integer offset, Integer limit) throws ApiException {
        ApiResponse<UserListView> resp = userListWithHttpInfo(id, firstName, firstNameIcontains, firstNameIstartswith, lastName, lastNameIcontains, authEmail, smartSearch, offset, limit);
        return resp.getData();
    }

    /**
     * 
     * 
     * @param id  (optional)
     * @param firstName  (optional)
     * @param firstNameIcontains  (optional)
     * @param firstNameIstartswith  (optional)
     * @param lastName  (optional)
     * @param lastNameIcontains  (optional)
     * @param authEmail  (optional)
     * @param smartSearch  (optional)
     * @param offset  (optional)
     * @param limit  (optional)
     * @return ApiResponse&lt;UserListView&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<UserListView> userListWithHttpInfo(Integer id, String firstName, String firstNameIcontains, String firstNameIstartswith, String lastName, String lastNameIcontains, String authEmail, String smartSearch, Integer offset, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = userListCall(id, firstName, firstNameIcontains, firstNameIstartswith, lastName, lastNameIcontains, authEmail, smartSearch, offset, limit, null, null);
        Type localVarReturnType = new TypeToken<UserListView>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * 
     * @param id  (optional)
     * @param firstName  (optional)
     * @param firstNameIcontains  (optional)
     * @param firstNameIstartswith  (optional)
     * @param lastName  (optional)
     * @param lastNameIcontains  (optional)
     * @param authEmail  (optional)
     * @param smartSearch  (optional)
     * @param offset  (optional)
     * @param limit  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call userListAsync(Integer id, String firstName, String firstNameIcontains, String firstNameIstartswith, String lastName, String lastNameIcontains, String authEmail, String smartSearch, Integer offset, Integer limit, final ApiCallback<UserListView> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = userListCall(id, firstName, firstNameIcontains, firstNameIstartswith, lastName, lastNameIcontains, authEmail, smartSearch, offset, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<UserListView>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for userMeList */
    private com.squareup.okhttp.Call userMeListCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        

        // create path and map variables
        String localVarPath = "/v1/user/me/".replaceAll("\\{format\\}","json");

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
     * No documentation beyond REST Standards;
     * No documentation beyond REST Standards;
     * @return UserTokenRetrieveView
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public UserTokenRetrieveView userMeList() throws ApiException {
        ApiResponse<UserTokenRetrieveView> resp = userMeListWithHttpInfo();
        return resp.getData();
    }

    /**
     * No documentation beyond REST Standards;
     * No documentation beyond REST Standards;
     * @return ApiResponse&lt;UserTokenRetrieveView&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<UserTokenRetrieveView> userMeListWithHttpInfo() throws ApiException {
        com.squareup.okhttp.Call call = userMeListCall(null, null);
        Type localVarReturnType = new TypeToken<UserTokenRetrieveView>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * No documentation beyond REST Standards; (asynchronously)
     * No documentation beyond REST Standards;
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call userMeListAsync(final ApiCallback<UserTokenRetrieveView> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = userMeListCall(progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<UserTokenRetrieveView>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for userPartialUpdate */
    private com.squareup.okhttp.Call userPartialUpdateCall(String id, UserUpdateSerializer userUpdateSerializer, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = userUpdateSerializer;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling userPartialUpdate(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/v1/user/{id}/".replaceAll("\\{format\\}","json")
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
     * @param userUpdateSerializer  (optional)
     * @return UserTokenRetrieveView
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public UserTokenRetrieveView userPartialUpdate(String id, UserUpdateSerializer userUpdateSerializer) throws ApiException {
        ApiResponse<UserTokenRetrieveView> resp = userPartialUpdateWithHttpInfo(id, userUpdateSerializer);
        return resp.getData();
    }

    /**
     * No documentation beyond REST Standards;
     * No documentation beyond REST Standards;
     * @param id  (required)
     * @param userUpdateSerializer  (optional)
     * @return ApiResponse&lt;UserTokenRetrieveView&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<UserTokenRetrieveView> userPartialUpdateWithHttpInfo(String id, UserUpdateSerializer userUpdateSerializer) throws ApiException {
        com.squareup.okhttp.Call call = userPartialUpdateCall(id, userUpdateSerializer, null, null);
        Type localVarReturnType = new TypeToken<UserTokenRetrieveView>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * No documentation beyond REST Standards; (asynchronously)
     * No documentation beyond REST Standards;
     * @param id  (required)
     * @param userUpdateSerializer  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call userPartialUpdateAsync(String id, UserUpdateSerializer userUpdateSerializer, final ApiCallback<UserTokenRetrieveView> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = userPartialUpdateCall(id, userUpdateSerializer, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<UserTokenRetrieveView>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for userPreferencesList */
    private com.squareup.okhttp.Call userPreferencesListCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        

        // create path and map variables
        String localVarPath = "/v1/user/preferences/".replaceAll("\\{format\\}","json");

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
     * @return UserPreferencesRetreiveView
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public UserPreferencesRetreiveView userPreferencesList() throws ApiException {
        ApiResponse<UserPreferencesRetreiveView> resp = userPreferencesListWithHttpInfo();
        return resp.getData();
    }

    /**
     * 
     * 
     * @return ApiResponse&lt;UserPreferencesRetreiveView&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<UserPreferencesRetreiveView> userPreferencesListWithHttpInfo() throws ApiException {
        com.squareup.okhttp.Call call = userPreferencesListCall(null, null);
        Type localVarReturnType = new TypeToken<UserPreferencesRetreiveView>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call userPreferencesListAsync(final ApiCallback<UserPreferencesRetreiveView> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = userPreferencesListCall(progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<UserPreferencesRetreiveView>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for userPreferencesPartialUpdate */
    private com.squareup.okhttp.Call userPreferencesPartialUpdateCall(String id, UserPreferenceSerializer userPreferenceSerializer, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = userPreferenceSerializer;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling userPreferencesPartialUpdate(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/v1/user/preferences/{id}".replaceAll("\\{format\\}","json")
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
     * 
     * 
     * @param id  (required)
     * @param userPreferenceSerializer  (optional)
     * @return UserPreferencesRetreiveView
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public UserPreferencesRetreiveView userPreferencesPartialUpdate(String id, UserPreferenceSerializer userPreferenceSerializer) throws ApiException {
        ApiResponse<UserPreferencesRetreiveView> resp = userPreferencesPartialUpdateWithHttpInfo(id, userPreferenceSerializer);
        return resp.getData();
    }

    /**
     * 
     * 
     * @param id  (required)
     * @param userPreferenceSerializer  (optional)
     * @return ApiResponse&lt;UserPreferencesRetreiveView&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<UserPreferencesRetreiveView> userPreferencesPartialUpdateWithHttpInfo(String id, UserPreferenceSerializer userPreferenceSerializer) throws ApiException {
        com.squareup.okhttp.Call call = userPreferencesPartialUpdateCall(id, userPreferenceSerializer, null, null);
        Type localVarReturnType = new TypeToken<UserPreferencesRetreiveView>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * 
     * @param id  (required)
     * @param userPreferenceSerializer  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call userPreferencesPartialUpdateAsync(String id, UserPreferenceSerializer userPreferenceSerializer, final ApiCallback<UserPreferencesRetreiveView> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = userPreferencesPartialUpdateCall(id, userPreferenceSerializer, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<UserPreferencesRetreiveView>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for userSignupCreate */
    private com.squareup.okhttp.Call userSignupCreateCall(APIViewUserSerializer apIViewUserSerializer, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = apIViewUserSerializer;
        

        // create path and map variables
        String localVarPath = "/v1/user/signup/".replaceAll("\\{format\\}","json");

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
     * @param apIViewUserSerializer  (optional)
     * @return Login
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Login userSignupCreate(APIViewUserSerializer apIViewUserSerializer) throws ApiException {
        ApiResponse<Login> resp = userSignupCreateWithHttpInfo(apIViewUserSerializer);
        return resp.getData();
    }

    /**
     * No documentation beyond REST Standards;
     * No documentation beyond REST Standards;
     * @param apIViewUserSerializer  (optional)
     * @return ApiResponse&lt;Login&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Login> userSignupCreateWithHttpInfo(APIViewUserSerializer apIViewUserSerializer) throws ApiException {
        com.squareup.okhttp.Call call = userSignupCreateCall(apIViewUserSerializer, null, null);
        Type localVarReturnType = new TypeToken<Login>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * No documentation beyond REST Standards; (asynchronously)
     * No documentation beyond REST Standards;
     * @param apIViewUserSerializer  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call userSignupCreateAsync(APIViewUserSerializer apIViewUserSerializer, final ApiCallback<Login> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = userSignupCreateCall(apIViewUserSerializer, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Login>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for userVerifyList */
    private com.squareup.okhttp.Call userVerifyListCall(String key, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        

        // create path and map variables
        String localVarPath = "/v1/user/verify/".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (key != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "key", key));

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
     * @param key  (optional)
     * @return LogoutView
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public LogoutView userVerifyList(String key) throws ApiException {
        ApiResponse<LogoutView> resp = userVerifyListWithHttpInfo(key);
        return resp.getData();
    }

    /**
     * No documentation beyond REST Standards;
     * No documentation beyond REST Standards;
     * @param key  (optional)
     * @return ApiResponse&lt;LogoutView&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<LogoutView> userVerifyListWithHttpInfo(String key) throws ApiException {
        com.squareup.okhttp.Call call = userVerifyListCall(key, null, null);
        Type localVarReturnType = new TypeToken<LogoutView>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * No documentation beyond REST Standards; (asynchronously)
     * No documentation beyond REST Standards;
     * @param key  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call userVerifyListAsync(String key, final ApiCallback<LogoutView> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = userVerifyListCall(key, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<LogoutView>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
