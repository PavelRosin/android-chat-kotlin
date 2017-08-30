# MessageApi

All URIs are relative to *https://api.edu.chat*

Method | HTTP request | Description
------------- | ------------- | -------------
[**messageCreate**](MessageApi.md#messageCreate) | **POST** /v1/message/ | Paginated;
[**messageList**](MessageApi.md#messageList) | **GET** /v1/message/ | Paginated;
[**messagePartialUpdate**](MessageApi.md#messagePartialUpdate) | **PATCH** /v1/message/{id}/ | No documentation beyond REST Standards;
[**messageUpvoteCreate**](MessageApi.md#messageUpvoteCreate) | **POST** /v1/message/upvote/ | Paginated;
[**messageUpvoteList**](MessageApi.md#messageUpvoteList) | **GET** /v1/message/upvote/ | Paginated;


<a name="messageCreate"></a>
# **messageCreate**
> messageCreate(data)

Paginated;

Paginated; Filter by Mandatory({chat}) and Optional( {parent} and { &#39;id&#39;             : [&#39;exact&#39;], &#39;created&#39;        : [&#39;gte&#39;], &#39;text&#39;           : [&#39;exact&#39;, &#39;icontains&#39;], &#39;user_id&#39;        : [&#39;exact&#39;], &#39;file__name&#39;     : [&#39;exact&#39;], } );

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MessageApi;


MessageApi apiInstance = new MessageApi();
Data7 data = new Data7(); // Data7 | 
try {
    apiInstance.messageCreate(data);
} catch (ApiException e) {
    System.err.println("Exception when calling MessageApi#messageCreate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **data** | [**Data7**](Data7.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="messageList"></a>
# **messageList**
> messageList(limit, offset, id, createdGte, text, textIcontains, userId, fileName)

Paginated;

Paginated; Filter by Mandatory({chat}) and Optional( {parent} and { &#39;id&#39;             : [&#39;exact&#39;], &#39;created&#39;        : [&#39;gte&#39;], &#39;text&#39;           : [&#39;exact&#39;, &#39;icontains&#39;], &#39;user_id&#39;        : [&#39;exact&#39;], &#39;file__name&#39;     : [&#39;exact&#39;], } );

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MessageApi;


MessageApi apiInstance = new MessageApi();
Integer limit = 56; // Integer | Number of results to return per page.
Integer offset = 56; // Integer | The initial index from which to return the results.
String id = "id_example"; // String | 
String createdGte = "createdGte_example"; // String | 
String text = "text_example"; // String | 
String textIcontains = "textIcontains_example"; // String | 
String userId = "userId_example"; // String | 
String fileName = "fileName_example"; // String | 
try {
    apiInstance.messageList(limit, offset, id, createdGte, text, textIcontains, userId, fileName);
} catch (ApiException e) {
    System.err.println("Exception when calling MessageApi#messageList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
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

<a name="messagePartialUpdate"></a>
# **messagePartialUpdate**
> messagePartialUpdate(id, data)

No documentation beyond REST Standards;

No documentation beyond REST Standards;

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MessageApi;


MessageApi apiInstance = new MessageApi();
String id = "id_example"; // String | 
Data9 data = new Data9(); // Data9 | 
try {
    apiInstance.messagePartialUpdate(id, data);
} catch (ApiException e) {
    System.err.println("Exception when calling MessageApi#messagePartialUpdate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **data** | [**Data9**](Data9.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="messageUpvoteCreate"></a>
# **messageUpvoteCreate**
> messageUpvoteCreate(data)

Paginated;

Paginated; filter by {message};

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MessageApi;


MessageApi apiInstance = new MessageApi();
Data8 data = new Data8(); // Data8 | 
try {
    apiInstance.messageUpvoteCreate(data);
} catch (ApiException e) {
    System.err.println("Exception when calling MessageApi#messageUpvoteCreate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **data** | [**Data8**](Data8.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="messageUpvoteList"></a>
# **messageUpvoteList**
> messageUpvoteList(limit, offset, id, firstName, firstNameIcontains, lastName, lastNameIcontains)

Paginated;

Paginated; filter by {message};

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MessageApi;


MessageApi apiInstance = new MessageApi();
Integer limit = 56; // Integer | Number of results to return per page.
Integer offset = 56; // Integer | The initial index from which to return the results.
String id = "id_example"; // String | 
String firstName = "firstName_example"; // String | 
String firstNameIcontains = "firstNameIcontains_example"; // String | 
String lastName = "lastName_example"; // String | 
String lastNameIcontains = "lastNameIcontains_example"; // String | 
try {
    apiInstance.messageUpvoteList(limit, offset, id, firstName, firstNameIcontains, lastName, lastNameIcontains);
} catch (ApiException e) {
    System.err.println("Exception when calling MessageApi#messageUpvoteList");
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

