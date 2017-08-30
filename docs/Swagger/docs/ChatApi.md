# ChatApi

All URIs are relative to *https://api.edu.chat*

Method | HTTP request | Description
------------- | ------------- | -------------
[**chatCreate**](ChatApi.md#chatCreate) | **POST** /v1/chat/ | Paginated;
[**chatDelete**](ChatApi.md#chatDelete) | **DELETE** /v1/chat/{id}/ | No documentation beyond REST Standards;
[**chatList**](ChatApi.md#chatList) | **GET** /v1/chat/ | Paginated;
[**chatPartialUpdate**](ChatApi.md#chatPartialUpdate) | **PATCH** /v1/chat/{id}/ | No documentation beyond REST Standards;
[**chatResourcesList**](ChatApi.md#chatResourcesList) | **GET** /v1/chat/{chat}/resources/ | Paginated;


<a name="chatCreate"></a>
# **chatCreate**
> chatCreate(data)

Paginated;

Paginated; filter by {parent} and { &#39;name&#39;: [&#39;exact&#39;, &#39;icontains&#39;], &#39;description&#39;: [&#39;exact&#39;, &#39;icontains&#39;], &#39;is_class&#39; : [&#39;exact&#39;] };

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ChatApi;


ChatApi apiInstance = new ChatApi();
Data2 data = new Data2(); // Data2 | 
try {
    apiInstance.chatCreate(data);
} catch (ApiException e) {
    System.err.println("Exception when calling ChatApi#chatCreate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **data** | [**Data2**](Data2.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="chatDelete"></a>
# **chatDelete**
> chatDelete(id)

No documentation beyond REST Standards;

No documentation beyond REST Standards;

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ChatApi;


ChatApi apiInstance = new ChatApi();
String id = "id_example"; // String | 
try {
    apiInstance.chatDelete(id);
} catch (ApiException e) {
    System.err.println("Exception when calling ChatApi#chatDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="chatList"></a>
# **chatList**
> chatList(limit, offset, name, nameIcontains, description, descriptionIcontains, isClass)

Paginated;

Paginated; filter by {parent} and { &#39;name&#39;: [&#39;exact&#39;, &#39;icontains&#39;], &#39;description&#39;: [&#39;exact&#39;, &#39;icontains&#39;], &#39;is_class&#39; : [&#39;exact&#39;] };

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ChatApi;


ChatApi apiInstance = new ChatApi();
Integer limit = 56; // Integer | Number of results to return per page.
Integer offset = 56; // Integer | The initial index from which to return the results.
String name = "name_example"; // String | 
String nameIcontains = "nameIcontains_example"; // String | 
String description = "description_example"; // String | 
String descriptionIcontains = "descriptionIcontains_example"; // String | 
String isClass = "isClass_example"; // String | 
try {
    apiInstance.chatList(limit, offset, name, nameIcontains, description, descriptionIcontains, isClass);
} catch (ApiException e) {
    System.err.println("Exception when calling ChatApi#chatList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| Number of results to return per page. | [optional]
 **offset** | **Integer**| The initial index from which to return the results. | [optional]
 **name** | **String**|  | [optional]
 **nameIcontains** | **String**|  | [optional]
 **description** | **String**|  | [optional]
 **descriptionIcontains** | **String**|  | [optional]
 **isClass** | **String**|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="chatPartialUpdate"></a>
# **chatPartialUpdate**
> chatPartialUpdate(id, data)

No documentation beyond REST Standards;

No documentation beyond REST Standards;

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ChatApi;


ChatApi apiInstance = new ChatApi();
String id = "id_example"; // String | 
Data3 data = new Data3(); // Data3 | 
try {
    apiInstance.chatPartialUpdate(id, data);
} catch (ApiException e) {
    System.err.println("Exception when calling ChatApi#chatPartialUpdate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **data** | [**Data3**](Data3.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="chatResourcesList"></a>
# **chatResourcesList**
> chatResourcesList(chat, limit, offset, id, createdGte, text, textIcontains, userId, fileName)

Paginated;

Paginated; Filter by Optional( { &#39;created&#39;        : [&#39;gte&#39;], &#39;text&#39;           : [&#39;exact&#39;, &#39;icontains&#39;], &#39;user_id&#39;        : [&#39;exact&#39;], &#39;file__name&#39;     : [&#39;exact&#39;], } );

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ChatApi;


ChatApi apiInstance = new ChatApi();
String chat = "chat_example"; // String | 
Integer limit = 56; // Integer | Number of results to return per page.
Integer offset = 56; // Integer | The initial index from which to return the results.
String id = "id_example"; // String | 
String createdGte = "createdGte_example"; // String | 
String text = "text_example"; // String | 
String textIcontains = "textIcontains_example"; // String | 
String userId = "userId_example"; // String | 
String fileName = "fileName_example"; // String | 
try {
    apiInstance.chatResourcesList(chat, limit, offset, id, createdGte, text, textIcontains, userId, fileName);
} catch (ApiException e) {
    System.err.println("Exception when calling ChatApi#chatResourcesList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **chat** | **String**|  |
 **limit** | **Integer**| Number of results to return per page. | [optional]
 **offset** | **Integer**| The initial index from which to return the results. | [optional]
 **id** | **String**|  | [optional]
 **createdGte** | **String**|  | [optional]
 **text** | **String**|  | [optional]
 **textIcontains** | **String**|  | [optional]
 **userId** | **String**|  | [optional]
 **fileName** | **String**|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

