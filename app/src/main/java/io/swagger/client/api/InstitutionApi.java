

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

import io.swagger.client.model.DepartmentView;
import io.swagger.client.model.SchoolView;
import io.swagger.client.model.UniversityView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InstitutionApi {
    private ApiClient apiClient;

    public InstitutionApi() {
        this(Configuration.getDefaultApiClient());
    }

    public InstitutionApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for institutionDepartmentList */
    private com.squareup.okhttp.Call institutionDepartmentListCall(Integer id, String name, String nameIcontains, String schoolId, Integer offset, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        

        // create path and map variables
        String localVarPath = "/v1/institution/department/".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (id != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "id", id));
        if (name != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "name", name));
        if (nameIcontains != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "name__icontains", nameIcontains));
        if (schoolId != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "school_id", schoolId));
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
     * @param schoolId  (optional)
     * @param offset  (optional)
     * @param limit  (optional)
     * @return DepartmentView
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DepartmentView institutionDepartmentList(Integer id, String name, String nameIcontains, String schoolId, Integer offset, Integer limit) throws ApiException {
        ApiResponse<DepartmentView> resp = institutionDepartmentListWithHttpInfo(id, name, nameIcontains, schoolId, offset, limit);
        return resp.getData();
    }

    /**
     * 
     * 
     * @param id  (optional)
     * @param name  (optional)
     * @param nameIcontains  (optional)
     * @param schoolId  (optional)
     * @param offset  (optional)
     * @param limit  (optional)
     * @return ApiResponse&lt;DepartmentView&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<DepartmentView> institutionDepartmentListWithHttpInfo(Integer id, String name, String nameIcontains, String schoolId, Integer offset, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = institutionDepartmentListCall(id, name, nameIcontains, schoolId, offset, limit, null, null);
        Type localVarReturnType = new TypeToken<DepartmentView>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * 
     * @param id  (optional)
     * @param name  (optional)
     * @param nameIcontains  (optional)
     * @param schoolId  (optional)
     * @param offset  (optional)
     * @param limit  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call institutionDepartmentListAsync(Integer id, String name, String nameIcontains, String schoolId, Integer offset, Integer limit, final ApiCallback<DepartmentView> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = institutionDepartmentListCall(id, name, nameIcontains, schoolId, offset, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DepartmentView>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for institutionSchoolList */
    private com.squareup.okhttp.Call institutionSchoolListCall(Integer id, String name, String nameIcontains, String universityId, Integer offset, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        

        // create path and map variables
        String localVarPath = "/v1/institution/school/".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (id != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "id", id));
        if (name != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "name", name));
        if (nameIcontains != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "name__icontains", nameIcontains));
        if (universityId != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "university_id", universityId));
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
     * @param universityId  (optional)
     * @param offset  (optional)
     * @param limit  (optional)
     * @return SchoolView
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public SchoolView institutionSchoolList(Integer id, String name, String nameIcontains, String universityId, Integer offset, Integer limit) throws ApiException {
        ApiResponse<SchoolView> resp = institutionSchoolListWithHttpInfo(id, name, nameIcontains, universityId, offset, limit);
        return resp.getData();
    }

    /**
     * 
     * 
     * @param id  (optional)
     * @param name  (optional)
     * @param nameIcontains  (optional)
     * @param universityId  (optional)
     * @param offset  (optional)
     * @param limit  (optional)
     * @return ApiResponse&lt;SchoolView&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<SchoolView> institutionSchoolListWithHttpInfo(Integer id, String name, String nameIcontains, String universityId, Integer offset, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = institutionSchoolListCall(id, name, nameIcontains, universityId, offset, limit, null, null);
        Type localVarReturnType = new TypeToken<SchoolView>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * 
     * @param id  (optional)
     * @param name  (optional)
     * @param nameIcontains  (optional)
     * @param universityId  (optional)
     * @param offset  (optional)
     * @param limit  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call institutionSchoolListAsync(Integer id, String name, String nameIcontains, String universityId, Integer offset, Integer limit, final ApiCallback<SchoolView> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = institutionSchoolListCall(id, name, nameIcontains, universityId, offset, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<SchoolView>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for institutionUniversityList */
    private com.squareup.okhttp.Call institutionUniversityListCall(Integer id, String name, String nameIcontains, Integer offset, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        

        // create path and map variables
        String localVarPath = "/v1/institution/university/".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (id != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "id", id));
        if (name != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "name", name));
        if (nameIcontains != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "name__icontains", nameIcontains));
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
     * @param offset  (optional)
     * @param limit  (optional)
     * @return UniversityView
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public UniversityView institutionUniversityList(Integer id, String name, String nameIcontains, Integer offset, Integer limit) throws ApiException {
        ApiResponse<UniversityView> resp = institutionUniversityListWithHttpInfo(id, name, nameIcontains, offset, limit);
        return resp.getData();
    }

    /**
     * 
     * 
     * @param id  (optional)
     * @param name  (optional)
     * @param nameIcontains  (optional)
     * @param offset  (optional)
     * @param limit  (optional)
     * @return ApiResponse&lt;UniversityView&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<UniversityView> institutionUniversityListWithHttpInfo(Integer id, String name, String nameIcontains, Integer offset, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = institutionUniversityListCall(id, name, nameIcontains, offset, limit, null, null);
        Type localVarReturnType = new TypeToken<UniversityView>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * 
     * @param id  (optional)
     * @param name  (optional)
     * @param nameIcontains  (optional)
     * @param offset  (optional)
     * @param limit  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call institutionUniversityListAsync(Integer id, String name, String nameIcontains, Integer offset, Integer limit, final ApiCallback<UniversityView> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = institutionUniversityListCall(id, name, nameIcontains, offset, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<UniversityView>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
