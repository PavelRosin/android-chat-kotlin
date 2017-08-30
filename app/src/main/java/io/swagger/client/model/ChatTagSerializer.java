package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import android.os.Parcelable;
import android.os.Parcel;

/**
 * ChatTagSerializer
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-08-09T16:18:16.327Z")
public class ChatTagSerializer implements Parcelable {
  @SerializedName("chat")
  private Integer chat = null;

  @SerializedName("tag_str")
  private String tagStr = null;

  public ChatTagSerializer chat(Integer chat) {
    this.chat = chat;
    return this;
  }

   /**
   * 
   * @return chat
  **/
  @ApiModelProperty(value = "")
  public Integer getChat() {
    return chat;
  }

  public void setChat(Integer chat) {
    this.chat = chat;
  }

  public ChatTagSerializer tagStr(String tagStr) {
    this.tagStr = tagStr;
    return this;
  }

   /**
   * 
   * @return tagStr
  **/
  @ApiModelProperty(value = "")
  public String getTagStr() {
    return tagStr;
  }

  public void setTagStr(String tagStr) {
    this.tagStr = tagStr;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChatTagSerializer chatTagSerializer = (ChatTagSerializer) o;
    return Objects.equals(this.chat, chatTagSerializer.chat) &&
        Objects.equals(this.tagStr, chatTagSerializer.tagStr);
  }

  @Override
  public int hashCode() {
    return Objects.hash(chat, tagStr);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChatTagSerializer {\n");
    
    sb.append("    chat: ").append(toIndentedString(chat)).append("\n");
    sb.append("    tagStr: ").append(toIndentedString(tagStr)).append("\n");
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

    out.writeValue(tagStr);
  }

  public ChatTagSerializer() {
    super();
  }

  ChatTagSerializer(Parcel in) {
    
    chat = (Integer)in.readValue(null);
    tagStr = (String)in.readValue(null);
  }
  
  public int describeContents() {
    return 0;
  }

  public static final Parcelable.Creator<ChatTagSerializer> CREATOR = new Parcelable.Creator<ChatTagSerializer>() {
    public ChatTagSerializer createFromParcel(Parcel in) {
      return new ChatTagSerializer(in);
    }
    public ChatTagSerializer[] newArray(int size) {
      return new ChatTagSerializer[size];
    }
  };
}

