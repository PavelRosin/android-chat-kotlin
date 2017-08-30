# swagger-java-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.ApiApi;

import java.io.File;
import java.util.*;

public class ApiApiExample {

    public static void main(String[] args) {
        
        ApiApi apiInstance = new ApiApi();
        Data data = new Data(); // Data | 
        try {
            apiInstance.apiLoginCreate(data);
        } catch (ApiException e) {
            System.err.println("Exception when calling ApiApi#apiLoginCreate");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://api.edu.chat*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*ApiApi* | [**apiLoginCreate**](docs/ApiApi.md#apiLoginCreate) | **POST** /v1/api/login/ | No documentation beyond REST Standards;
*ApiApi* | [**apiLogoutCreate**](docs/ApiApi.md#apiLogoutCreate) | **POST** /v1/api/logout/ | No documentation beyond REST Standards;
*BotApi* | [**botAddQuestionAnswerPairCreate**](docs/BotApi.md#botAddQuestionAnswerPairCreate) | **POST** /v1/bot/add_question_answer_pair/ | 
*BotApi* | [**botCreateChatBotCreate**](docs/BotApi.md#botCreateChatBotCreate) | **POST** /v1/bot/create_chat_bot/ | 
*BotApi* | [**botCrowdsourceAdminsOnlyCreate**](docs/BotApi.md#botCrowdsourceAdminsOnlyCreate) | **POST** /v1/bot/crowdsource_admins_only/ | 
*BotApi* | [**botJoinChatGroupCreate**](docs/BotApi.md#botJoinChatGroupCreate) | **POST** /v1/bot/join_chat_group/ | 
*BotApi* | [**botMakeAdminCreate**](docs/BotApi.md#botMakeAdminCreate) | **POST** /v1/bot/make_admin/ | 
*BotApi* | [**botSendAnswerCreate**](docs/BotApi.md#botSendAnswerCreate) | **POST** /v1/bot/send_answer/ | 
*BotApi* | [**botValidateCreate**](docs/BotApi.md#botValidateCreate) | **POST** /v1/bot/validate/ | 
*BotApi* | [**botViewAnswersList**](docs/BotApi.md#botViewAnswersList) | **GET** /v1/bot/view_answers/ | 
*BotApi* | [**botViewQuestionsAnswersList**](docs/BotApi.md#botViewQuestionsAnswersList) | **GET** /v1/bot/view_questions_answers/ | 
*ChatApi* | [**chatCreate**](docs/ChatApi.md#chatCreate) | **POST** /v1/chat/ | Paginated;
*ChatApi* | [**chatDelete**](docs/ChatApi.md#chatDelete) | **DELETE** /v1/chat/{id}/ | No documentation beyond REST Standards;
*ChatApi* | [**chatList**](docs/ChatApi.md#chatList) | **GET** /v1/chat/ | Paginated;
*ChatApi* | [**chatPartialUpdate**](docs/ChatApi.md#chatPartialUpdate) | **PATCH** /v1/chat/{id}/ | No documentation beyond REST Standards;
*ChatApi* | [**chatResourcesList**](docs/ChatApi.md#chatResourcesList) | **GET** /v1/chat/{chat}/resources/ | Paginated;
*Chat_userApi* | [**chatUserCreate**](docs/Chat_userApi.md#chatUserCreate) | **POST** /v1/chat_user/ | Paginated;
*Chat_userApi* | [**chatUserDelete**](docs/Chat_userApi.md#chatUserDelete) | **DELETE** /v1/chat_user/{chat}/{user}/ | No documentation beyond REST Standards;
*Chat_userApi* | [**chatUserList**](docs/Chat_userApi.md#chatUserList) | **GET** /v1/chat_user/ | Paginated;
*Chat_userApi* | [**chatUserPartialUpdate**](docs/Chat_userApi.md#chatUserPartialUpdate) | **PATCH** /v1/chat_user/{chat}/{user}/ | No documentation beyond REST Standards;
*FileApi* | [**fileCreate**](docs/FileApi.md#fileCreate) | **POST** /v1/file/ | No documentation beyond REST Standards;
*FileApi* | [**filePartialUpdate**](docs/FileApi.md#filePartialUpdate) | **PATCH** /v1/file/{id}/ | No documentation beyond REST Standards;
*InstitutionApi* | [**institutionDepartmentList**](docs/InstitutionApi.md#institutionDepartmentList) | **GET** /v1/institution/department/ | Paginated;
*InstitutionApi* | [**institutionSchoolList**](docs/InstitutionApi.md#institutionSchoolList) | **GET** /v1/institution/school/ | Paginated;
*InstitutionApi* | [**institutionUniversityList**](docs/InstitutionApi.md#institutionUniversityList) | **GET** /v1/institution/university/ | Paginated;
*MessageApi* | [**messageCreate**](docs/MessageApi.md#messageCreate) | **POST** /v1/message/ | Paginated;
*MessageApi* | [**messageList**](docs/MessageApi.md#messageList) | **GET** /v1/message/ | Paginated;
*MessageApi* | [**messagePartialUpdate**](docs/MessageApi.md#messagePartialUpdate) | **PATCH** /v1/message/{id}/ | No documentation beyond REST Standards;
*MessageApi* | [**messageUpvoteCreate**](docs/MessageApi.md#messageUpvoteCreate) | **POST** /v1/message/upvote/ | Paginated;
*MessageApi* | [**messageUpvoteList**](docs/MessageApi.md#messageUpvoteList) | **GET** /v1/message/upvote/ | Paginated;
*PasswordApi* | [**passwordRequestCreate**](docs/PasswordApi.md#passwordRequestCreate) | **POST** /v1/password/request/ | No documentation beyond REST Standards;
*PasswordApi* | [**passwordResetCreate**](docs/PasswordApi.md#passwordResetCreate) | **POST** /v1/password/reset/ | No documentation beyond REST Standards;
*TagApi* | [**tagChatCreate**](docs/TagApi.md#tagChatCreate) | **POST** /v1/tag/chat/ | No documentation beyond REST Standards;
*TagApi* | [**tagList**](docs/TagApi.md#tagList) | **GET** /v1/tag/ | No documentation beyond REST Standards;
*TagApi* | [**tagUserCreate**](docs/TagApi.md#tagUserCreate) | **POST** /v1/tag/user/ | No documentation beyond REST Standards;
*UserApi* | [**userList**](docs/UserApi.md#userList) | **GET** /v1/user/ | Paginated;
*UserApi* | [**userMeList**](docs/UserApi.md#userMeList) | **GET** /v1/user/me/ | No documentation beyond REST Standards;
*UserApi* | [**userPartialUpdate**](docs/UserApi.md#userPartialUpdate) | **PATCH** /v1/user/{id}/ | No documentation beyond REST Standards;
*UserApi* | [**userSignupCreate**](docs/UserApi.md#userSignupCreate) | **POST** /v1/user/signup/ | No documentation beyond REST Standards;
*UserApi* | [**userVerifyList**](docs/UserApi.md#userVerifyList) | **GET** /v1/user/verify/ | No documentation beyond REST Standards;


## Documentation for Models

 - [Data](docs/Data.md)
 - [Data1](docs/Data1.md)
 - [Data10](docs/Data10.md)
 - [Data11](docs/Data11.md)
 - [Data12](docs/Data12.md)
 - [Data13](docs/Data13.md)
 - [Data14](docs/Data14.md)
 - [Data15](docs/Data15.md)
 - [Data2](docs/Data2.md)
 - [Data3](docs/Data3.md)
 - [Data4](docs/Data4.md)
 - [Data5](docs/Data5.md)
 - [Data6](docs/Data6.md)
 - [Data7](docs/Data7.md)
 - [Data8](docs/Data8.md)
 - [Data9](docs/Data9.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### api_key

- **Type**: API key
- **API key parameter name**: Authorization
- **Location**: HTTP header


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



