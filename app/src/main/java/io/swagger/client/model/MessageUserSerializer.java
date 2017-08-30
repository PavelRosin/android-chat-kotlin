package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.MessageSerializer;
import io.swagger.client.model.UserSerializer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.os.Parcelable;
import android.os.Parcel;

/**
 * MessageUserSerializer
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-08-09T16:18:16.327Z")
public class MessageUserSerializer implements Parcelable {
  @SerializedName("messages")
  private List<MessageSerializer> messages = new ArrayList<MessageSerializer>();

  @SerializedName("users")
  private Map<String, UserSerializer> users = new HashMap<String, UserSerializer>();

  public MessageUserSerializer messages(List<MessageSerializer> messages) {
    this.messages = messages;
    return this;
  }

  public MessageUserSerializer addMessagesItem(MessageSerializer messagesItem) {
    this.messages.add(messagesItem);
    return this;
  }

   /**
   * 
   * @return messages
  **/
  @ApiModelProperty(value = "")
  public List<MessageSerializer> getMessages() {
    return messages;
  }

  public void setMessages(List<MessageSerializer> messages) {
    this.messages = messages;
  }

  public MessageUserSerializer users(Map<String, UserSerializer> users) {
    this.users = users;
    return this;
  }

  public MessageUserSerializer putUsersItem(String key, UserSerializer usersItem) {
    this.users.put(key, usersItem);
    return this;
  }

   /**
   * 
   * @return users
  **/
  @ApiModelProperty(value = "")
  public Map<String, UserSerializer> getUsers() {
    return users;
  }

  public void setUsers(Map<String, UserSerializer> users) {
    this.users = users;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MessageUserSerializer messageUserSerializer = (MessageUserSerializer) o;
    return Objects.equals(this.messages, messageUserSerializer.messages) &&
        Objects.equals(this.users, messageUserSerializer.users);
  }

  @Override
  public int hashCode() {
    return Objects.hash(messages, users);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MessageUserSerializer {\n");
    
    sb.append("    messages: ").append(toIndentedString(messages)).append("\n");
    sb.append("    users: ").append(toIndentedString(users)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
  
  public void writeToParcel(Parcel out, int flags) {
     
    out.writeValue(messages);

    out.writeValue(users);
  }

  public MessageUserSerializer() {
    super();
  }

  MessageUserSerializer(Parcel in) {
    
    messages = (List<MessageSerializer>)in.readValue(MessageSerializer.class.getClassLoader());
    users = (Map<String, UserSerializer>)in.readValue(UserSerializer.class.getClassLoader());
  }
  
  public int describeContents() {
    return 0;
  }

  public static final Parcelable.Creator<MessageUserSerializer> CREATOR = new Parcelable.Creator<MessageUserSerializer>() {
    public MessageUserSerializer createFromParcel(Parcel in) {
      return new MessageUserSerializer(in);
    }
    public MessageUserSerializer[] newArray(int size) {
      return new MessageUserSerializer[size];
    }
  };
}

