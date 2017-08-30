package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.FileSerializer;
import java.util.ArrayList;
import java.util.List;
import android.os.Parcelable;
import android.os.Parcel;

/**
 * MessageSerializer
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-08-09T16:18:16.327Z")
public class MessageSerializer implements Parcelable {
  @SerializedName("file")
  private FileSerializer file = null;

  @SerializedName("text")
  private String text = null;

  @SerializedName("is_question")
  private Boolean isQuestion = null;

  @SerializedName("type")
  private String type = null;

  @SerializedName("is_starred")
  private Boolean isStarred = null;

  @SerializedName("is_best_answer")
  private Boolean isBestAnswer = null;

  @SerializedName("chat")
  private Integer chat = null;

  @SerializedName("user")
  private Integer user = null;

  @SerializedName("parent")
  private Integer parent = null;

  @SerializedName("id")
  private Integer id = null;

  @SerializedName("created")
  private String created = null;

  @SerializedName("event")
  private Integer event = null;

  @SerializedName("comment_count")
  private Integer commentCount = null;

  @SerializedName("unread_count")
  private Integer unreadCount = null;

  @SerializedName("user_read_point")
  private List<Integer> userReadPoint = new ArrayList<Integer>();

  @SerializedName("is_resolved")
  private Boolean isResolved = null;

  public MessageSerializer file(FileSerializer file) {
    this.file = file;
    return this;
  }

   /**
   * Get file
   * @return file
  **/
  @ApiModelProperty(value = "")
  public FileSerializer getFile() {
    return file;
  }

  public void setFile(FileSerializer file) {
    this.file = file;
  }

  public MessageSerializer text(String text) {
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

  public MessageSerializer isQuestion(Boolean isQuestion) {
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

  public MessageSerializer type(String type) {
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

  public MessageSerializer isStarred(Boolean isStarred) {
    this.isStarred = isStarred;
    return this;
  }

   /**
   * 
   * @return isStarred
  **/
  @ApiModelProperty(value = "")
  public Boolean getIsStarred() {
    return isStarred;
  }

  public void setIsStarred(Boolean isStarred) {
    this.isStarred = isStarred;
  }

  public MessageSerializer isBestAnswer(Boolean isBestAnswer) {
    this.isBestAnswer = isBestAnswer;
    return this;
  }

   /**
   * 
   * @return isBestAnswer
  **/
  @ApiModelProperty(value = "")
  public Boolean getIsBestAnswer() {
    return isBestAnswer;
  }

  public void setIsBestAnswer(Boolean isBestAnswer) {
    this.isBestAnswer = isBestAnswer;
  }

  public MessageSerializer chat(Integer chat) {
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

  public MessageSerializer user(Integer user) {
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

  public MessageSerializer parent(Integer parent) {
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

  public MessageSerializer id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * 
   * @return id
  **/
  @ApiModelProperty(value = "")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public MessageSerializer created(String created) {
    this.created = created;
    return this;
  }

   /**
   * 
   * @return created
  **/
  @ApiModelProperty(value = "")
  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public MessageSerializer event(Integer event) {
    this.event = event;
    return this;
  }

   /**
   * 
   * @return event
  **/
  @ApiModelProperty(value = "")
  public Integer getEvent() {
    return event;
  }

  public void setEvent(Integer event) {
    this.event = event;
  }

  public MessageSerializer commentCount(Integer commentCount) {
    this.commentCount = commentCount;
    return this;
  }

   /**
   * 
   * @return commentCount
  **/
  @ApiModelProperty(value = "")
  public Integer getCommentCount() {
    return commentCount;
  }

  public void setCommentCount(Integer commentCount) {
    this.commentCount = commentCount;
  }

  public MessageSerializer unreadCount(Integer unreadCount) {
    this.unreadCount = unreadCount;
    return this;
  }

   /**
   * 
   * @return unreadCount
  **/
  @ApiModelProperty(value = "")
  public Integer getUnreadCount() {
    return unreadCount;
  }

  public void setUnreadCount(Integer unreadCount) {
    this.unreadCount = unreadCount;
  }

  public MessageSerializer userReadPoint(List<Integer> userReadPoint) {
    this.userReadPoint = userReadPoint;
    return this;
  }

  public MessageSerializer addUserReadPointItem(Integer userReadPointItem) {
    this.userReadPoint.add(userReadPointItem);
    return this;
  }

   /**
   * 
   * @return userReadPoint
  **/
  @ApiModelProperty(value = "")
  public List<Integer> getUserReadPoint() {
    return userReadPoint;
  }

  public void setUserReadPoint(List<Integer> userReadPoint) {
    this.userReadPoint = userReadPoint;
  }

  public MessageSerializer isResolved(Boolean isResolved) {
    this.isResolved = isResolved;
    return this;
  }

   /**
   * 
   * @return isResolved
  **/
  @ApiModelProperty(value = "")
  public Boolean getIsResolved() {
    return isResolved;
  }

  public void setIsResolved(Boolean isResolved) {
    this.isResolved = isResolved;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MessageSerializer messageSerializer = (MessageSerializer) o;
    return Objects.equals(this.file, messageSerializer.file) &&
        Objects.equals(this.text, messageSerializer.text) &&
        Objects.equals(this.isQuestion, messageSerializer.isQuestion) &&
        Objects.equals(this.type, messageSerializer.type) &&
        Objects.equals(this.isStarred, messageSerializer.isStarred) &&
        Objects.equals(this.isBestAnswer, messageSerializer.isBestAnswer) &&
        Objects.equals(this.chat, messageSerializer.chat) &&
        Objects.equals(this.user, messageSerializer.user) &&
        Objects.equals(this.parent, messageSerializer.parent) &&
        Objects.equals(this.id, messageSerializer.id) &&
        Objects.equals(this.created, messageSerializer.created) &&
        Objects.equals(this.event, messageSerializer.event) &&
        Objects.equals(this.commentCount, messageSerializer.commentCount) &&
        Objects.equals(this.unreadCount, messageSerializer.unreadCount) &&
        Objects.equals(this.userReadPoint, messageSerializer.userReadPoint) &&
        Objects.equals(this.isResolved, messageSerializer.isResolved);
  }

  @Override
  public int hashCode() {
    return Objects.hash(file, text, isQuestion, type, isStarred, isBestAnswer, chat, user, parent, id, created, event, commentCount, unreadCount, userReadPoint, isResolved);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MessageSerializer {\n");
    
    sb.append("    file: ").append(toIndentedString(file)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    isQuestion: ").append(toIndentedString(isQuestion)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    isStarred: ").append(toIndentedString(isStarred)).append("\n");
    sb.append("    isBestAnswer: ").append(toIndentedString(isBestAnswer)).append("\n");
    sb.append("    chat: ").append(toIndentedString(chat)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    parent: ").append(toIndentedString(parent)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
    sb.append("    commentCount: ").append(toIndentedString(commentCount)).append("\n");
    sb.append("    unreadCount: ").append(toIndentedString(unreadCount)).append("\n");
    sb.append("    userReadPoint: ").append(toIndentedString(userReadPoint)).append("\n");
    sb.append("    isResolved: ").append(toIndentedString(isResolved)).append("\n");
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

    out.writeValue(isStarred);

    out.writeValue(isBestAnswer);

    out.writeValue(chat);

    out.writeValue(user);

    out.writeValue(parent);

    out.writeValue(id);

    out.writeValue(created);

    out.writeValue(event);

    out.writeValue(commentCount);

    out.writeValue(unreadCount);

    out.writeValue(userReadPoint);

    out.writeValue(isResolved);
  }

  public MessageSerializer() {
    super();
  }

  MessageSerializer(Parcel in) {
    
    file = (FileSerializer)in.readValue(null);
    text = (String)in.readValue(null);
    isQuestion = (Boolean)in.readValue(null);
    type = (String)in.readValue(null);
    isStarred = (Boolean)in.readValue(null);
    isBestAnswer = (Boolean)in.readValue(null);
    chat = (Integer)in.readValue(null);
    user = (Integer)in.readValue(null);
    parent = (Integer)in.readValue(null);
    id = (Integer)in.readValue(null);
    created = (String)in.readValue(null);
    event = (Integer)in.readValue(null);
    commentCount = (Integer)in.readValue(null);
    unreadCount = (Integer)in.readValue(null);
    userReadPoint = (List<Integer>)in.readValue(null);
    isResolved = (Boolean)in.readValue(null);
  }
  
  public int describeContents() {
    return 0;
  }

  public static final Parcelable.Creator<MessageSerializer> CREATOR = new Parcelable.Creator<MessageSerializer>() {
    public MessageSerializer createFromParcel(Parcel in) {
      return new MessageSerializer(in);
    }
    public MessageSerializer[] newArray(int size) {
      return new MessageSerializer[size];
    }
  };
}

