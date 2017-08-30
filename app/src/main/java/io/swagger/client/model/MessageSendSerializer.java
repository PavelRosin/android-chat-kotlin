package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import android.os.Parcelable;
import android.os.Parcel;

/**
 * MessageSendSerializer
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-08-09T16:18:16.327Z")
public class MessageSendSerializer implements Parcelable {
  @SerializedName("file")
  private Integer file = null;

  @SerializedName("text")
  private String text = null;

  @SerializedName("is_question")
  private Boolean isQuestion = null;

  @SerializedName("type")
  private String type = null;

  @SerializedName("is_best_answer")
  private Boolean isBestAnswer = null;

  @SerializedName("chat")
  private Integer chat = null;

  @SerializedName("user")
  private Integer user = null;

  @SerializedName("parent")
  private Integer parent = null;

  @SerializedName("is_starred")
  private Boolean isStarred = null;

  public MessageSendSerializer file(Integer file) {
    this.file = file;
    return this;
  }

   /**
   * 
   * @return file
  **/
  @ApiModelProperty(value = "")
  public Integer getFile() {
    return file;
  }

  public void setFile(Integer file) {
    this.file = file;
  }

  public MessageSendSerializer text(String text) {
    this.text = text;
    return this;
  }

   /**
   * 
   * @return text
  **/
  @ApiModelProperty(value = "")
  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public MessageSendSerializer isQuestion(Boolean isQuestion) {
    this.isQuestion = isQuestion;
    return this;
  }

   /**
   * 
   * @return isQuestion
  **/
  @ApiModelProperty(value = "")
  public Boolean getIsQuestion() {
    return isQuestion;
  }

  public void setIsQuestion(Boolean isQuestion) {
    this.isQuestion = isQuestion;
  }

  public MessageSendSerializer type(String type) {
    this.type = type;
    return this;
  }

   /**
   * 
   * @return type
  **/
  @ApiModelProperty(value = "")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public MessageSendSerializer isBestAnswer(Boolean isBestAnswer) {
    this.isBestAnswer = isBestAnswer;
    return this;
  }

   /**
   * Get isBestAnswer
   * @return isBestAnswer
  **/
  @ApiModelProperty(value = "")
  public Boolean getIsBestAnswer() {
    return isBestAnswer;
  }

  public void setIsBestAnswer(Boolean isBestAnswer) {
    this.isBestAnswer = isBestAnswer;
  }

  public MessageSendSerializer chat(Integer chat) {
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

  public MessageSendSerializer user(Integer user) {
    this.user = user;
    return this;
  }

   /**
   * 
   * @return user
  **/
  @ApiModelProperty(value = "")
  public Integer getUser() {
    return user;
  }

  public void setUser(Integer user) {
    this.user = user;
  }

  public MessageSendSerializer parent(Integer parent) {
    this.parent = parent;
    return this;
  }

   /**
   * 
   * @return parent
  **/
  @ApiModelProperty(value = "")
  public Integer getParent() {
    return parent;
  }

  public void setParent(Integer parent) {
    this.parent = parent;
  }

  public MessageSendSerializer isStarred(Boolean isStarred) {
    this.isStarred = isStarred;
    return this;
  }

   /**
   * Get isStarred
   * @return isStarred
  **/
  @ApiModelProperty(value = "")
  public Boolean getIsStarred() {
    return isStarred;
  }

  public void setIsStarred(Boolean isStarred) {
    this.isStarred = isStarred;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MessageSendSerializer messageSendSerializer = (MessageSendSerializer) o;
    return Objects.equals(this.file, messageSendSerializer.file) &&
        Objects.equals(this.text, messageSendSerializer.text) &&
        Objects.equals(this.isQuestion, messageSendSerializer.isQuestion) &&
        Objects.equals(this.type, messageSendSerializer.type) &&
        Objects.equals(this.isBestAnswer, messageSendSerializer.isBestAnswer) &&
        Objects.equals(this.chat, messageSendSerializer.chat) &&
        Objects.equals(this.user, messageSendSerializer.user) &&
        Objects.equals(this.parent, messageSendSerializer.parent) &&
        Objects.equals(this.isStarred, messageSendSerializer.isStarred);
  }

  @Override
  public int hashCode() {
    return Objects.hash(file, text, isQuestion, type, isBestAnswer, chat, user, parent, isStarred);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MessageSendSerializer {\n");
    
    sb.append("    file: ").append(toIndentedString(file)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    isQuestion: ").append(toIndentedString(isQuestion)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    isBestAnswer: ").append(toIndentedString(isBestAnswer)).append("\n");
    sb.append("    chat: ").append(toIndentedString(chat)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    parent: ").append(toIndentedString(parent)).append("\n");
    sb.append("    isStarred: ").append(toIndentedString(isStarred)).append("\n");
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
     
    out.writeValue(file);

    out.writeValue(text);

    out.writeValue(isQuestion);

    out.writeValue(type);

    out.writeValue(isBestAnswer);

    out.writeValue(chat);

    out.writeValue(user);

    out.writeValue(parent);

    out.writeValue(isStarred);
  }

  public MessageSendSerializer() {
    super();
  }

  MessageSendSerializer(Parcel in) {
    
    file = (Integer)in.readValue(null);
    text = (String)in.readValue(null);
    isQuestion = (Boolean)in.readValue(null);
    type = (String)in.readValue(null);
    isBestAnswer = (Boolean)in.readValue(null);
    chat = (Integer)in.readValue(null);
    user = (Integer)in.readValue(null);
    parent = (Integer)in.readValue(null);
    isStarred = (Boolean)in.readValue(null);
  }
  
  public int describeContents() {
    return 0;
  }

  public static final Parcelable.Creator<MessageSendSerializer> CREATOR = new Parcelable.Creator<MessageSendSerializer>() {
    public MessageSendSerializer createFromParcel(Parcel in) {
      return new MessageSendSerializer(in);
    }
    public MessageSendSerializer[] newArray(int size) {
      return new MessageSendSerializer[size];
    }
  };
}

