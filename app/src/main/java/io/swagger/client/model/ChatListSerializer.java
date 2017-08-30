package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.ChatSerializer;
import io.swagger.client.model.UserSerializer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.os.Parcelable;
import android.os.Parcel;

/**
 * ChatListSerializer
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-08-09T16:18:16.327Z")
public class ChatListSerializer implements Parcelable {
  @SerializedName("chats")
  private List<ChatSerializer> chats = new ArrayList<ChatSerializer>();

  @SerializedName("users")
  private Map<String, UserSerializer> users = new HashMap<String, UserSerializer>();

  public ChatListSerializer chats(List<ChatSerializer> chats) {
    this.chats = chats;
    return this;
  }

  public ChatListSerializer addChatsItem(ChatSerializer chatsItem) {
    this.chats.add(chatsItem);
    return this;
  }

   /**
   * 
   * @return chats
  **/
  @ApiModelProperty(value = "")
  public List<ChatSerializer> getChats() {
    return chats;
  }

  public void setChats(List<ChatSerializer> chats) {
    this.chats = chats;
  }

  public ChatListSerializer users(Map<String, UserSerializer> users) {
    this.users = users;
    return this;
  }

  public ChatListSerializer putUsersItem(String key, UserSerializer usersItem) {
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
    ChatListSerializer chatListSerializer = (ChatListSerializer) o;
    return Objects.equals(this.chats, chatListSerializer.chats) &&
        Objects.equals(this.users, chatListSerializer.users);
  }

  @Override
  public int hashCode() {
    return Objects.hash(chats, users);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChatListSerializer {\n");
    
    sb.append("    chats: ").append(toIndentedString(chats)).append("\n");
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
     
    out.writeValue(chats);

    out.writeValue(users);
  }

  public ChatListSerializer() {
    super();
  }

  ChatListSerializer(Parcel in) {
    
    chats = (List<ChatSerializer>)in.readValue(ChatSerializer.class.getClassLoader());
    users = (Map<String, UserSerializer>)in.readValue(UserSerializer.class.getClassLoader());
  }
  
  public int describeContents() {
    return 0;
  }

  public static final Parcelable.Creator<ChatListSerializer> CREATOR = new Parcelable.Creator<ChatListSerializer>() {
    public ChatListSerializer createFromParcel(Parcel in) {
      return new ChatListSerializer(in);
    }
    public ChatListSerializer[] newArray(int size) {
      return new ChatListSerializer[size];
    }
  };
}

