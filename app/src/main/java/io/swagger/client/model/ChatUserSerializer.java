package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.ChatSerializer;
import io.swagger.client.model.UserSerializer;
import android.os.Parcelable;
import android.os.Parcel;

/**
 * ChatUserSerializer
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-08-09T16:18:16.327Z")
public class ChatUserSerializer implements Parcelable {
  @SerializedName("chat")
  private ChatSerializer chat = null;

  @SerializedName("user")
  private UserSerializer user = null;

  @SerializedName("is_admin")
  private Boolean isAdmin = null;

  @SerializedName("is_ta")
  private Boolean isTa = null;

  @SerializedName("is_muted")
  private Boolean isMuted = null;

  public ChatUserSerializer chat(ChatSerializer chat) {
    this.chat = chat;
    return this;
  }

   /**
   * Get chat
   * @return chat
  **/
  @ApiModelProperty(value = "")
  public ChatSerializer getChat() {
    return chat;
  }

  public void setChat(ChatSerializer chat) {
    this.chat = chat;
  }

  public ChatUserSerializer user(UserSerializer user) {
    this.user = user;
    return this;
  }

   /**
   * Get user
   * @return user
  **/
  @ApiModelProperty(value = "")
  public UserSerializer getUser() {
    return user;
  }

  public void setUser(UserSerializer user) {
    this.user = user;
  }

  public ChatUserSerializer isAdmin(Boolean isAdmin) {
    this.isAdmin = isAdmin;
    return this;
  }

   /**
   * 
   * @return isAdmin
  **/
  @ApiModelProperty(value = "")
  public Boolean getIsAdmin() {
    return isAdmin;
  }

  public void setIsAdmin(Boolean isAdmin) {
    this.isAdmin = isAdmin;
  }

  public ChatUserSerializer isTa(Boolean isTa) {
    this.isTa = isTa;
    return this;
  }

   /**
   * 
   * @return isTa
  **/
  @ApiModelProperty(value = "")
  public Boolean getIsTa() {
    return isTa;
  }

  public void setIsTa(Boolean isTa) {
    this.isTa = isTa;
  }

  public ChatUserSerializer isMuted(Boolean isMuted) {
    this.isMuted = isMuted;
    return this;
  }

   /**
   * 
   * @return isMuted
  **/
  @ApiModelProperty(value = "")
  public Boolean getIsMuted() {
    return isMuted;
  }

  public void setIsMuted(Boolean isMuted) {
    this.isMuted = isMuted;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChatUserSerializer chatUserSerializer = (ChatUserSerializer) o;
    return Objects.equals(this.chat, chatUserSerializer.chat) &&
        Objects.equals(this.user, chatUserSerializer.user) &&
        Objects.equals(this.isAdmin, chatUserSerializer.isAdmin) &&
        Objects.equals(this.isTa, chatUserSerializer.isTa) &&
        Objects.equals(this.isMuted, chatUserSerializer.isMuted);
  }

  @Override
  public int hashCode() {
    return Objects.hash(chat, user, isAdmin, isTa, isMuted);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChatUserSerializer {\n");
    
    sb.append("    chat: ").append(toIndentedString(chat)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    isAdmin: ").append(toIndentedString(isAdmin)).append("\n");
    sb.append("    isTa: ").append(toIndentedString(isTa)).append("\n");
    sb.append("    isMuted: ").append(toIndentedString(isMuted)).append("\n");
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

    out.writeValue(isAdmin);

    out.writeValue(isTa);

    out.writeValue(isMuted);
  }

  public ChatUserSerializer() {
    super();
  }

  ChatUserSerializer(Parcel in) {
    
    chat = (ChatSerializer)in.readValue(null);
    user = (UserSerializer)in.readValue(null);
    isAdmin = (Boolean)in.readValue(null);
    isTa = (Boolean)in.readValue(null);
    isMuted = (Boolean)in.readValue(null);
  }
  
  public int describeContents() {
    return 0;
  }

  public static final Parcelable.Creator<ChatUserSerializer> CREATOR = new Parcelable.Creator<ChatUserSerializer>() {
    public ChatUserSerializer createFromParcel(Parcel in) {
      return new ChatUserSerializer(in);
    }
    public ChatUserSerializer[] newArray(int size) {
      return new ChatUserSerializer[size];
    }
  };
}

