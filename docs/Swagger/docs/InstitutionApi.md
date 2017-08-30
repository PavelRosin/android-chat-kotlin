# InstitutionApi

All URIs are relative to *https://api.edu.chat*

Method | HTTP request | Description
------------- | ------------- | -------------
[**institutionDepartmentList**](InstitutionApi.md#institutionDepartmentList) | **GET** /v1/institution/department/ | Paginated;
[**institutionSchoolList**](InstitutionApi.md#institutionSchoolList) | **GET** /v1/institution/school/ | Paginated;
[**institutionUniversityList**](InstitutionApi.md#institutionUniversityList) | **GET** /v1/institution/university/ | Paginated;


<a name="institutionDepartmentList"></a>
# **institutionDepartmentList**
> institutionDepartmentList(limit, offset, id, name, nameIcontains, schoolId)

Paginated;

Paginated; Filter by Optional( { &#39;id&#39;       : [&#39;exact&#39;], &#39;name&#39;     : [&#39;exact&#39;, &#39;icontains&#39;], &#39;school_id&#39;: [&#39;exact&#39;] } );

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.InstitutionApi;


InstitutionApi apiInstance = new InstitutionApi();
Integer limit = 56; // Integer | Number of results to return per page.
Integer offset = 56; // Integer | The initial index from which to return the results.
String id = "id_example"; // String | 
String name = "name_example"; // String | 
String nameIcontains = "nameIcontains_example"; // String | 
String schoolId = "schoolId_example"; // String | 
try {
    apiInstance.institutionDepartmentList(limit, offset, id, name, nameIcontains, schoolId);
} catch (ApiException e) {
    System.err.println("Exception when calling InstitutionApi#institutionDepartmentList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| Number of results to return per page. | [optional]
 **offset** | **Integer**| The initial index from which to return the results. | [optional]
 **id** | **String**|  | [optional]
 **name** | **String**|  | [optional]
 **nameIcontains** | **String**|  | [optional]
 **schoolId** | **String**|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="institutionSchoolList"></a>
# **institutionSchoolList**
> institutionSchoolList(limit, offset, id, name, nameIcontains, universityId)

Paginated;

Paginated; Filter by Optional( { &#39;id&#39;           : [&#39;exact&#39;], &#39;name&#39;         : [&#39;exact&#39;, &#39;icontains&#39;], &#39;university_id&#39;: [&#39;exact&#39;] } );

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.InstitutionApi;


InstitutionApi apiInstance = new InstitutionApi();
Integer limit = 56; // Integer | Number of results to return per page.
Integer offset = 56; // Integer | The initial index from which to return the results.
String id = "id_example"; // String | 
String name = "name_example"; // String | 
String nameIcontains = "nameIcontains_example"; // String | 
String universityId = "universityId_example"; // String | 
try {
    apiInstance.institutionSchoolList(limit, offset, id, name, nameIcontains, universityId);
} catch (ApiException e) {
    System.err.println("Exception when calling InstitutionApi#institutionSchoolList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| Number of results to return per page. | [optional]
 **offset** | **Integer**| The initial index from which to return the results. | [optional]
 **id** | **String**|  | [optional]
 **name** | **String**|  | [optional]
 **nameIcontains** | **String**|  | [optional]
 **universityId** | **String**|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="institutionUniversityList"></a>
# **institutionUniversityList**
> institutionUniversityList(limit, offset, id, name, nameIcontains)

Paginated;

Paginated; Filter by Optional( { &#39;id&#39;  : [&#39;exact&#39;], &#39;name&#39;: [&#39;exact&#39;, &#39;icontains&#39;], } );

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.InstitutionApi;


InstitutionApi apiInstance = new InstitutionApi();
Integer limit = 56; // Integer | Number of results to return per page.
Integer offset = 56; // Integer | The initial index from which to return the results.
String id = "id_example"; // String | 
String name = "name_example"; // String | 
String nameIcontains = "nameIcontains_example"; // String | 
try {
    apiInstance.institutionUniversityList(limit, offset, id, name, nameIcontains);
} catch (ApiException e) {
    System.err.println("Exception when calling InstitutionApi#institutionUniversityList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| Number of results to return per page. | [optional]
 **offset** | **Integer**| The initial index from which to return the results. | [optional]
 **id** | **String**|  | [optional]
 **name** | **String**|  | [optional]
 **nameIcontains** | **String**|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

