package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import android.os.Parcelable;
import android.os.Parcel;

/**
 * ChatUserPostSerializer
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-08-09T16:18:16.327Z")
public class ChatUserPostSerializer implements Parcelable {
  @SerializedName("chat")
  private List<String> chat = new ArrayList<String>();

  @SerializedName("user")
  private List<String> user = new ArrayList<String>();

  public ChatUserPostSerializer chat(List<String> chat) {
    this.chat = chat;
    return this;
  }

  public ChatUserPostSerializer addChatItem(String chatItem) {
    this.chat.add(chatItem);
    return this;
  }

   /**
   * 
   * @return chat
  **/
  @ApiModelProperty(value = "")
  public List<String> getChat() {
    return chat;
  }

  public void setChat(List<String> chat) {
    this.chat = chat;
  }

  public ChatUserPostSerializer user(List<String> user) {
    this.user = user;
    return this;
  }

  public ChatUserPostSerializer addUserItem(String userItem) {
    this.user.add(userItem);
    return this;
  }

   /**
   * 
   * @return user
  **/
  @ApiModelProperty(value = "")
  public List<String> getUser() {
    return user;
  }

  public void setUser(List<String> user) {
    this.user = user;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChatUserPostSerializer chatUserPostSerializer = (ChatUserPostSerializer) o;
    return Objects.equals(this.chat, chatUserPostSerializer.chat) &&
        Objects.equals(this.user, chatUserPostSerializer.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash(chat, user);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChatUserPostSerializer {\n");
    
    sb.append("    chat: ").append(toIndentedString(chat)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
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
     
    out.writeValue(chat);

    out.writeValue(user);
  }

  public ChatUserPostSerializer() {
    super();
  }

  ChatUserPostSerializer(Parcel in) {
    
    chat = (List<String>)in.readValue(null);
    user = (List<String>)in.readValue(null);
  }
  
  public int describeContents() {
    return 0;
  }

  public static final Parcelable.Creator<ChatUserPostSerializer> CREATOR = new Parcelable.Creator<ChatUserPostSerializer>() {
    public ChatUserPostSerializer createFromParcel(Parcel in) {
      return new ChatUserPostSerializer(in);
    }
    public ChatUserPostSerializer[] newArray(int size) {
      return new ChatUserPostSerializer[size];
    }
  };
}

