# FileApi

All URIs are relative to *https://api.edu.chat*

Method | HTTP request | Description
------------- | ------------- | -------------
[**fileCreate**](FileApi.md#fileCreate) | **POST** /v1/file/ | No documentation beyond REST Standards;
[**filePartialUpdate**](FileApi.md#filePartialUpdate) | **PATCH** /v1/file/{id}/ | No documentation beyond REST Standards;


<a name="fileCreate"></a>
# **fileCreate**
> fileCreate(name, upload)

No documentation beyond REST Standards;

No documentation beyond REST Standards;

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.FileApi;


FileApi apiInstance = new FileApi();
String name = "name_example"; // String | 
String upload = "upload_example"; // String | 
try {
    apiInstance.fileCreate(name, upload);
} catch (ApiException e) {
    System.err.println("Exception when calling FileApi#fileCreate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**|  |
 **upload** | **String**|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: Not defined

<a name="filePartialUpdate"></a>
# **filePartialUpdate**
> filePartialUpdate(id, data)

No documentation beyond REST Standards;

No documentation beyond REST Standards;

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.FileApi;


FileApi apiInstance = new FileApi();
String id = "id_example"; // String | 
Data6 data = new Data6(); // Data6 | 
try {
    apiInstance.filePartialUpdate(id, data);
} catch (ApiException e) {
    System.err.println("Exception when calling FileApi#filePartialUpdate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **data** | [**Data6**](Data6.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

