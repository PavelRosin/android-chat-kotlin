# ApiApi

All URIs are relative to *https://api.edu.chat*

Method | HTTP request | Description
------------- | ------------- | -------------
[**apiLoginCreate**](ApiApi.md#apiLoginCreate) | **POST** /v1/api/login/ | No documentation beyond REST Standards;
[**apiLogoutCreate**](ApiApi.md#apiLogoutCreate) | **POST** /v1/api/logout/ | No documentation beyond REST Standards;


<a name="apiLoginCreate"></a>
# **apiLoginCreate**
> apiLoginCreate(data)

No documentation beyond REST Standards;

No documentation beyond REST Standards;

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ApiApi;


ApiApi apiInstance = new ApiApi();
Data data = new Data(); // Data | 
try {
    apiInstance.apiLoginCreate(data);
} catch (ApiException e) {
    System.err.println("Exception when calling ApiApi#apiLoginCreate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **data** | [**Data**](Data.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="apiLogoutCreate"></a>
# **apiLogoutCreate**
> apiLogoutCreate()

No documentation beyond REST Standards;

No documentation beyond REST Standards;

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ApiApi;


ApiApi apiInstance = new ApiApi();
try {
    apiInstance.apiLogoutCreate();
} catch (ApiException e) {
    System.err.println("Exception when calling ApiApi#apiLogoutCreate");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

