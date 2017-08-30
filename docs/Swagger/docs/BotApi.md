# BotApi

All URIs are relative to *https://api.edu.chat*

Method | HTTP request | Description
------------- | ------------- | -------------
[**botAddQuestionAnswerPairCreate**](BotApi.md#botAddQuestionAnswerPairCreate) | **POST** /v1/bot/add_question_answer_pair/ | 
[**botCreateChatBotCreate**](BotApi.md#botCreateChatBotCreate) | **POST** /v1/bot/create_chat_bot/ | 
[**botCrowdsourceAdminsOnlyCreate**](BotApi.md#botCrowdsourceAdminsOnlyCreate) | **POST** /v1/bot/crowdsource_admins_only/ | 
[**botJoinChatGroupCreate**](BotApi.md#botJoinChatGroupCreate) | **POST** /v1/bot/join_chat_group/ | 
[**botMakeAdminCreate**](BotApi.md#botMakeAdminCreate) | **POST** /v1/bot/make_admin/ | 
[**botSendAnswerCreate**](BotApi.md#botSendAnswerCreate) | **POST** /v1/bot/send_answer/ | 
[**botValidateCreate**](BotApi.md#botValidateCreate) | **POST** /v1/bot/validate/ | 
[**botViewAnswersList**](BotApi.md#botViewAnswersList) | **GET** /v1/bot/view_answers/ | 
[**botViewQuestionsAnswersList**](BotApi.md#botViewQuestionsAnswersList) | **GET** /v1/bot/view_questions_answers/ | 


<a name="botAddQuestionAnswerPairCreate"></a>
# **botAddQuestionAnswerPairCreate**
> botAddQuestionAnswerPairCreate()



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.BotApi;


BotApi apiInstance = new BotApi();
try {
    apiInstance.botAddQuestionAnswerPairCreate();
} catch (ApiException e) {
    System.err.println("Exception when calling BotApi#botAddQuestionAnswerPairCreate");
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

<a name="botCreateChatBotCreate"></a>
# **botCreateChatBotCreate**
> botCreateChatBotCreate()



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.BotApi;


BotApi apiInstance = new BotApi();
try {
    apiInstance.botCreateChatBotCreate();
} catch (ApiException e) {
    System.err.println("Exception when calling BotApi#botCreateChatBotCreate");
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

<a name="botCrowdsourceAdminsOnlyCreate"></a>
# **botCrowdsourceAdminsOnlyCreate**
> botCrowdsourceAdminsOnlyCreate()



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.BotApi;


BotApi apiInstance = new BotApi();
try {
    apiInstance.botCrowdsourceAdminsOnlyCreate();
} catch (ApiException e) {
    System.err.println("Exception when calling BotApi#botCrowdsourceAdminsOnlyCreate");
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

<a name="botJoinChatGroupCreate"></a>
# **botJoinChatGroupCreate**
> botJoinChatGroupCreate()



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.BotApi;


BotApi apiInstance = new BotApi();
try {
    apiInstance.botJoinChatGroupCreate();
} catch (ApiException e) {
    System.err.println("Exception when calling BotApi#botJoinChatGroupCreate");
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

<a name="botMakeAdminCreate"></a>
# **botMakeAdminCreate**
> botMakeAdminCreate()



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.BotApi;


BotApi apiInstance = new BotApi();
try {
    apiInstance.botMakeAdminCreate();
} catch (ApiException e) {
    System.err.println("Exception when calling BotApi#botMakeAdminCreate");
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

<a name="botSendAnswerCreate"></a>
# **botSendAnswerCreate**
> botSendAnswerCreate()



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.BotApi;


BotApi apiInstance = new BotApi();
try {
    apiInstance.botSendAnswerCreate();
} catch (ApiException e) {
    System.err.println("Exception when calling BotApi#botSendAnswerCreate");
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

<a name="botValidateCreate"></a>
# **botValidateCreate**
> botValidateCreate(data)



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.BotApi;


BotApi apiInstance = new BotApi();
Data1 data = new Data1(); // Data1 | 
try {
    apiInstance.botValidateCreate(data);
} catch (ApiException e) {
    System.err.println("Exception when calling BotApi#botValidateCreate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **data** | [**Data1**](Data1.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="botViewAnswersList"></a>
# **botViewAnswersList**
> botViewAnswersList()



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.BotApi;


BotApi apiInstance = new BotApi();
try {
    apiInstance.botViewAnswersList();
} catch (ApiException e) {
    System.err.println("Exception when calling BotApi#botViewAnswersList");
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

<a name="botViewQuestionsAnswersList"></a>
# **botViewQuestionsAnswersList**
> botViewQuestionsAnswersList()



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.BotApi;


BotApi apiInstance = new BotApi();
try {
    apiInstance.botViewQuestionsAnswersList();
} catch (ApiException e) {
    System.err.println("Exception when calling BotApi#botViewQuestionsAnswersList");
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

