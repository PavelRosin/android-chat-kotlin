package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import android.os.Parcelable;
import android.os.Parcel;

/**
 * MessageUpdateSerializer
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-08-09T16:18:16.327Z")
public class MessageUpdateSerializer implements Parcelable {
  @SerializedName("file")
  private String file = null;

  @SerializedName("text")
  private String text = null;

  @SerializedName("is_question")
  private Boolean isQuestion = null;

  @SerializedName("type")
  private String type = null;

  @SerializedName("is_best_answer")
  private Boolean isBestAnswer = null;

  @SerializedName("is_starred")
  private Boolean isStarred = null;

  public MessageUpdateSerializer file(String file) {
    this.file = file;
    return this;
  }

   /**
   * 
   * @return file
  **/
  @ApiModelProperty(value = "")
  public String getFile() {
    return file;
  }

  public void setFile(String file) {
    this.file = file;
  }

  public MessageUpdateSerializer text(String text) {
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

  public MessageUpdateSerializer isQuestion(Boolean isQuestion) {
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

  public MessageUpdateSerializer type(String type) {
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

  public MessageUpdateSerializer isBestAnswer(Boolean isBestAnswer) {
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

  public MessageUpdateSerializer isStarred(Boolean isStarred) {
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
    MessageUpdateSerializer messageUpdateSerializer = (MessageUpdateSerializer) o;
    return Objects.equals(this.file, messageUpdateSerializer.file) &&
        Objects.equals(this.text, messageUpdateSerializer.text) &&
        Objects.equals(this.isQuestion, messageUpdateSerializer.isQuestion) &&
        Objects.equals(this.type, messageUpdateSerializer.type) &&
        Objects.equals(this.isBestAnswer, messageUpdateSerializer.isBestAnswer) &&
        Objects.equals(this.isStarred, messageUpdateSerializer.isStarred);
  }

  @Override
  public int hashCode() {
    return Objects.hash(file, text, isQuestion, type, isBestAnswer, isStarred);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MessageUpdateSerializer {\n");
    
    sb.append("    file: ").append(toIndentedString(file)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    isQuestion: ").append(toIndentedString(isQuestion)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    isBestAnswer: ").append(toIndentedString(isBestAnswer)).append("\n");
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

    out.writeValue(isStarred);
  }

  public MessageUpdateSerializer() {
    super();
  }

  MessageUpdateSerializer(Parcel in) {
    
    file = (String)in.readValue(null);
    text = (String)in.readValue(null);
    isQuestion = (Boolean)in.readValue(null);
    type = (String)in.readValue(null);
    isBestAnswer = (Boolean)in.readValue(null);
    isStarred = (Boolean)in.readValue(null);
  }
  
  public int describeContents() {
    return 0;
  }

  public static final Parcelable.Creator<MessageUpdateSerializer> CREATOR = new Parcelable.Creator<MessageUpdateSerializer>() {
    public MessageUpdateSerializer createFromParcel(Parcel in) {
      return new MessageUpdateSerializer(in);
    }
    public MessageUpdateSerializer[] newArray(int size) {
      return new MessageUpdateSerializer[size];
    }
  };
}

