# Chat_userApi

All URIs are relative to *https://api.edu.chat*

Method | HTTP request | Description
------------- | ------------- | -------------
[**chatUserCreate**](Chat_userApi.md#chatUserCreate) | **POST** /v1/chat_user/ | Paginated;
[**chatUserDelete**](Chat_userApi.md#chatUserDelete) | **DELETE** /v1/chat_user/{chat}/{user}/ | No documentation beyond REST Standards;
[**chatUserList**](Chat_userApi.md#chatUserList) | **GET** /v1/chat_user/ | Paginated;
[**chatUserPartialUpdate**](Chat_userApi.md#chatUserPartialUpdate) | **PATCH** /v1/chat_user/{chat}/{user}/ | No documentation beyond REST Standards;


<a name="chatUserCreate"></a>
# **chatUserCreate**
> chatUserCreate(data)

Paginated;

Paginated; Filter by {

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.Chat_userApi;


Chat_userApi apiInstance = new Chat_userApi();
Data4 data = new Data4(); // Data4 | 
try {
    apiInstance.chatUserCreate(data);
} catch (ApiException e) {
    System.err.println("Exception when calling Chat_userApi#chatUserCreate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **data** | [**Data4**](Data4.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="chatUserDelete"></a>
# **chatUserDelete**
> chatUserDelete(chat, user)

No documentation beyond REST Standards;

No documentation beyond REST Standards;

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.Chat_userApi;


Chat_userApi apiInstance = new Chat_userApi();
String chat = "chat_example"; // String | 
String user = "user_example"; // String | 
try {
    apiInstance.chatUserDelete(chat, user);
} catch (ApiException e) {
    System.err.println("Exception when calling Chat_userApi#chatUserDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **chat** | **String**|  |
 **user** | **String**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="chatUserList"></a>
# **chatUserList**
> chatUserList(limit, offset, id, firstName, firstNameIcontains, lastName, lastNameIcontains)

Paginated;

Paginated; Filter by {

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.Chat_userApi;


Chat_userApi apiInstance = new Chat_userApi();
Integer limit = 56; // Integer | Number of results to return per page.
Integer offset = 56; // Integer | The initial index from which to return the results.
String id = "id_example"; // String | 
String firstName = "firstName_example"; // String | 
String firstNameIcontains = "firstNameIcontains_example"; // String | 
String lastName = "lastName_example"; // String | 
String lastNameIcontains = "lastNameIcontains_example"; // String | 
try {
    apiInstance.chatUserList(limit, offset, id, firstName, firstNameIcontains, lastName, lastNameIcontains);
} catch (ApiException e) {
    System.err.println("Exception when calling Chat_userApi#chatUserList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| Number of results to return per page. | [optional]
 **offset** | **Integer**| The initial index from which to return the results. | [optional]
 **id** | **String**|  | [optional]
 **firstName** | **String**|  | [optional]
 **firstNameIcontains** | **String**|  | [optional]
 **lastName** | **String**|  | [optional]
 **lastNameIcontains** | **String**|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="chatUserPartialUpdate"></a>
# **chatUserPartialUpdate**
> chatUserPartialUpdate(chat, user, data)

No documentation beyond REST Standards;

No documentation beyond REST Standards;

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.Chat_userApi;


Chat_userApi apiInstance = new Chat_userApi();
String chat = "chat_example"; // String | 
String user = "user_example"; // String | 
Data5 data = new Data5(); // Data5 | 
try {
    apiInstance.chatUserPartialUpdate(chat, user, data);
} catch (ApiException e) {
    System.err.println("Exception when calling Chat_userApi#chatUserPartialUpdate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **chat** | **String**|  |
 **user** | **String**|  |
 **data** | [**Data5**](Data5.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

