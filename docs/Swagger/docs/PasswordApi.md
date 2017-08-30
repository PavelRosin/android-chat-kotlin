# PasswordApi

All URIs are relative to *https://api.edu.chat*

Method | HTTP request | Description
------------- | ------------- | -------------
[**passwordRequestCreate**](PasswordApi.md#passwordRequestCreate) | **POST** /v1/password/request/ | No documentation beyond REST Standards;
[**passwordResetCreate**](PasswordApi.md#passwordResetCreate) | **POST** /v1/password/reset/ | No documentation beyond REST Standards;


<a name="passwordRequestCreate"></a>
# **passwordRequestCreate**
> passwordRequestCreate(data)

No documentation beyond REST Standards;

No documentation beyond REST Standards;

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PasswordApi;


PasswordApi apiInstance = new PasswordApi();
Data10 data = new Data10(); // Data10 | 
try {
    apiInstance.passwordRequestCreate(data);
} catch (ApiException e) {
    System.err.println("Exception when calling PasswordApi#passwordRequestCreate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **data** | [**Data10**](Data10.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="passwordResetCreate"></a>
# **passwordResetCreate**
> passwordResetCreate(data)

No documentation beyond REST Standards;

No documentation beyond REST Standards;

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PasswordApi;


PasswordApi apiInstance = new PasswordApi();
Data11 data = new Data11(); // Data11 | 
try {
    apiInstance.passwordResetCreate(data);
} catch (ApiException e) {
    System.err.println("Exception when calling PasswordApi#passwordResetCreate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **data** | [**Data11**](Data11.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

