# UserApi

All URIs are relative to *https://api.edu.chat*

Method | HTTP request | Description
------------- | ------------- | -------------
[**userList**](UserApi.md#userList) | **GET** /v1/user/ | Paginated;
[**userMeList**](UserApi.md#userMeList) | **GET** /v1/user/me/ | No documentation beyond REST Standards;
[**userPartialUpdate**](UserApi.md#userPartialUpdate) | **PATCH** /v1/user/{id}/ | No documentation beyond REST Standards;
[**userSignupCreate**](UserApi.md#userSignupCreate) | **POST** /v1/user/signup/ | No documentation beyond REST Standards;
[**userVerifyList**](UserApi.md#userVerifyList) | **GET** /v1/user/verify/ | No documentation beyond REST Standards;


<a name="userList"></a>
# **userList**
> userList(limit, offset, id, firstName, firstNameIcontains, lastName, lastNameIcontains)

Paginated;

Paginated; Filter by Optional( { &#39;id&#39;        : [&#39;exact&#39;], &#39;first_name&#39;: [&#39;exact&#39;, &#39;icontains&#39;], &#39;last_name&#39; : [&#39;exact&#39;, &#39;icontains&#39;], } );

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UserApi;


UserApi apiInstance = new UserApi();
Integer limit = 56; // Integer | Number of results to return per page.
Integer offset = 56; // Integer | The initial index from which to return the results.
String id = "id_example"; // String | 
String firstName = "firstName_example"; // String | 
String firstNameIcontains = "firstNameIcontains_example"; // String | 
String lastName = "lastName_example"; // String | 
String lastNameIcontains = "lastNameIcontains_example"; // String | 
try {
    apiInstance.userList(limit, offset, id, firstName, firstNameIcontains, lastName, lastNameIcontains);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#userList");
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

<a name="userMeList"></a>
# **userMeList**
> userMeList(limit, offset)

No documentation beyond REST Standards;

No documentation beyond REST Standards;

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UserApi;


UserApi apiInstance = new UserApi();
Integer limit = 56; // Integer | Number of results to return per page.
Integer offset = 56; // Integer | The initial index from which to return the results.
try {
    apiInstance.userMeList(limit, offset);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#userMeList");
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

<a name="userPartialUpdate"></a>
# **userPartialUpdate**
> userPartialUpdate(id, data)

No documentation beyond REST Standards;

No documentation beyond REST Standards;

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UserApi;


UserApi apiInstance = new UserApi();
String id = "id_example"; // String | 
Data15 data = new Data15(); // Data15 | 
try {
    apiInstance.userPartialUpdate(id, data);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#userPartialUpdate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **data** | [**Data15**](Data15.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="userSignupCreate"></a>
# **userSignupCreate**
> userSignupCreate(data)

No documentation beyond REST Standards;

No documentation beyond REST Standards;

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UserApi;


UserApi apiInstance = new UserApi();
Data14 data = new Data14(); // Data14 | 
try {
    apiInstance.userSignupCreate(data);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#userSignupCreate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **data** | [**Data14**](Data14.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="userVerifyList"></a>
# **userVerifyList**
> userVerifyList(limit, offset)

No documentation beyond REST Standards;

No documentation beyond REST Standards;

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UserApi;


UserApi apiInstance = new UserApi();
Integer limit = 56; // Integer | Number of results to return per page.
Integer offset = 56; // Integer | The initial index from which to return the results.
try {
    apiInstance.userVerifyList(limit, offset);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#userVerifyList");
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

