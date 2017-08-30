# TagApi

All URIs are relative to *https://api.edu.chat*

Method | HTTP request | Description
------------- | ------------- | -------------
[**tagChatCreate**](TagApi.md#tagChatCreate) | **POST** /v1/tag/chat/ | No documentation beyond REST Standards;
[**tagList**](TagApi.md#tagList) | **GET** /v1/tag/ | No documentation beyond REST Standards;
[**tagUserCreate**](TagApi.md#tagUserCreate) | **POST** /v1/tag/user/ | No documentation beyond REST Standards;


<a name="tagChatCreate"></a>
# **tagChatCreate**
> tagChatCreate(data)

No documentation beyond REST Standards;

No documentation beyond REST Standards;

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TagApi;


TagApi apiInstance = new TagApi();
Data12 data = new Data12(); // Data12 | 
try {
    apiInstance.tagChatCreate(data);
} catch (ApiException e) {
    System.err.println("Exception when calling TagApi#tagChatCreate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **data** | [**Data12**](Data12.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="tagList"></a>
# **tagList**
> tagList(limit, offset)

No documentation beyond REST Standards;

No documentation beyond REST Standards;

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TagApi;


TagApi apiInstance = new TagApi();
Integer limit = 56; // Integer | Number of results to return per page.
Integer offset = 56; // Integer | The initial index from which to return the results.
try {
    apiInstance.tagList(limit, offset);
} catch (ApiException e) {
    System.err.println("Exception when calling TagApi#tagList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| Number of results to return per page. | [optional]
 **offset** | **Integer**| The initial index from which to return the results. | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="tagUserCreate"></a>
# **tagUserCreate**
> tagUserCreate(data)

No documentation beyond REST Standards;

No documentation beyond REST Standards;

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TagApi;


TagApi apiInstance = new TagApi();
Data13 data = new Data13(); // Data13 | 
try {
    apiInstance.tagUserCreate(data);
} catch (ApiException e) {
    System.err.println("Exception when calling TagApi#tagUserCreate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **data** | [**Data13**](Data13.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

