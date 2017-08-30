package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import android.os.Parcelable;
import android.os.Parcel;

/**
 * APIViewChatSerializer
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-08-09T16:18:16.327Z")
public class APIViewChatSerializer implements Parcelable {
  @SerializedName("name")
  private String name = null;

  @SerializedName("course_code")
  private String courseCode = null;

  @SerializedName("desc")
  private String desc = null;

  @SerializedName("color")
  private Integer color = null;

  @SerializedName("picture_file")
  private Integer pictureFile = null;

  @SerializedName("parent")
  private Integer parent = null;

  @SerializedName("searchable")
  private Boolean searchable = null;

  @SerializedName("is_class")
  private Boolean isClass = null;

  @SerializedName("is_bot")
  private Boolean isBot = null;

  @SerializedName("is_anonymous")
  private Boolean isAnonymous = null;

  @SerializedName("is_read_only")
  private Boolean isReadOnly = null;

  @SerializedName("add_new_users_from_parent")
  private Boolean addNewUsersFromParent = null;

  @SerializedName("is_admin_chat")
  private Boolean isAdminChat = null;

  public APIViewChatSerializer name(String name) {
    this.name = name;
    return this;
  }

   /**
   * 
   * @return name
  **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public APIViewChatSerializer courseCode(String courseCode) {
    this.courseCode = courseCode;
    return this;
  }

   /**
   * 
   * @return courseCode
  **/
  @ApiModelProperty(value = "")
  public String getCourseCode() {
    return courseCode;
  }

  public void setCourseCode(String courseCode) {
    this.courseCode = courseCode;
  }

  public APIViewChatSerializer desc(String desc) {
    this.desc = desc;
    return this;
  }

   /**
   * 
   * @return desc
  **/
  @ApiModelProperty(value = "")
  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public APIViewChatSerializer color(Integer color) {
    this.color = color;
    return this;
  }

   /**
   * 
   * @return color
  **/
  @ApiModelProperty(value = "")
  public Integer getColor() {
    return color;
  }

  public void setColor(Integer color) {
    this.color = color;
  }

  public APIViewChatSerializer pictureFile(Integer pictureFile) {
    this.pictureFile = pictureFile;
    return this;
  }

   /**
   * 
   * @return pictureFile
  **/
  @ApiModelProperty(value = "")
  public Integer getPictureFile() {
    return pictureFile;
  }

  public void setPictureFile(Integer pictureFile) {
    this.pictureFile = pictureFile;
  }

  public APIViewChatSerializer parent(Integer parent) {
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

  public APIViewChatSerializer searchable(Boolean searchable) {
    this.searchable = searchable;
    return this;
  }

   /**
   * 
   * @return searchable
  **/
  @ApiModelProperty(value = "")
  public Boolean getSearchable() {
    return searchable;
  }

  public void setSearchable(Boolean searchable) {
    this.searchable = searchable;
  }

  public APIViewChatSerializer isClass(Boolean isClass) {
    this.isClass = isClass;
    return this;
  }

   /**
   * 
   * @return isClass
  **/
  @ApiModelProperty(value = "")
  public Boolean getIsClass() {
    return isClass;
  }

  public void setIsClass(Boolean isClass) {
    this.isClass = isClass;
  }

  public APIViewChatSerializer isBot(Boolean isBot) {
    this.isBot = isBot;
    return this;
  }

   /**
   * 
   * @return isBot
  **/
  @ApiModelProperty(value = "")
  public Boolean getIsBot() {
    return isBot;
  }

  public void setIsBot(Boolean isBot) {
    this.isBot = isBot;
  }

  public APIViewChatSerializer isAnonymous(Boolean isAnonymous) {
    this.isAnonymous = isAnonymous;
    return this;
  }

   /**
   * 
   * @return isAnonymous
  **/
  @ApiModelProperty(value = "")
  public Boolean getIsAnonymous() {
    return isAnonymous;
  }

  public void setIsAnonymous(Boolean isAnonymous) {
    this.isAnonymous = isAnonymous;
  }

  public APIViewChatSerializer isReadOnly(Boolean isReadOnly) {
    this.isReadOnly = isReadOnly;
    return this;
  }

   /**
   * 
   * @return isReadOnly
  **/
  @ApiModelProperty(value = "")
  public Boolean getIsReadOnly() {
    return isReadOnly;
  }

  public void setIsReadOnly(Boolean isReadOnly) {
    this.isReadOnly = isReadOnly;
  }

  public APIViewChatSerializer addNewUsersFromParent(Boolean addNewUsersFromParent) {
    this.addNewUsersFromParent = addNewUsersFromParent;
    return this;
  }

   /**
   * 
   * @return addNewUsersFromParent
  **/
  @ApiModelProperty(value = "")
  public Boolean getAddNewUsersFromParent() {
    return addNewUsersFromParent;
  }

  public void setAddNewUsersFromParent(Boolean addNewUsersFromParent) {
    this.addNewUsersFromParent = addNewUsersFromParent;
  }

  public APIViewChatSerializer isAdminChat(Boolean isAdminChat) {
    this.isAdminChat = isAdminChat;
    return this;
  }

   /**
   * 
   * @return isAdminChat
  **/
  @ApiModelProperty(value = "")
  public Boolean getIsAdminChat() {
    return isAdminChat;
  }

  public void setIsAdminChat(Boolean isAdminChat) {
    this.isAdminChat = isAdminChat;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    APIViewChatSerializer apIViewChatSerializer = (APIViewChatSerializer) o;
    return Objects.equals(this.name, apIViewChatSerializer.name) &&
        Objects.equals(this.courseCode, apIViewChatSerializer.courseCode) &&
        Objects.equals(this.desc, apIViewChatSerializer.desc) &&
        Objects.equals(this.color, apIViewChatSerializer.color) &&
        Objects.equals(this.pictureFile, apIViewChatSerializer.pictureFile) &&
        Objects.equals(this.parent, apIViewChatSerializer.parent) &&
        Objects.equals(this.searchable, apIViewChatSerializer.searchable) &&
        Objects.equals(this.isClass, apIViewChatSerializer.isClass) &&
        Objects.equals(this.isBot, apIViewChatSerializer.isBot) &&
        Objects.equals(this.isAnonymous, apIViewChatSerializer.isAnonymous) &&
        Objects.equals(this.isReadOnly, apIViewChatSerializer.isReadOnly) &&
        Objects.equals(this.addNewUsersFromParent, apIViewChatSerializer.addNewUsersFromParent) &&
        Objects.equals(this.isAdminChat, apIViewChatSerializer.isAdminChat);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, courseCode, desc, color, pictureFile, parent, searchable, isClass, isBot, isAnonymous, isReadOnly, addNewUsersFromParent, isAdminChat);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class APIViewChatSerializer {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    courseCode: ").append(toIndentedString(courseCode)).append("\n");
    sb.append("    desc: ").append(toIndentedString(desc)).append("\n");
    sb.append("    color: ").append(toIndentedString(color)).append("\n");
    sb.append("    pictureFile: ").append(toIndentedString(pictureFile)).append("\n");
    sb.append("    parent: ").append(toIndentedString(parent)).append("\n");
    sb.append("    searchable: ").append(toIndentedString(searchable)).append("\n");
    sb.append("    isClass: ").append(toIndentedString(isClass)).append("\n");
    sb.append("    isBot: ").append(toIndentedString(isBot)).append("\n");
    sb.append("    isAnonymous: ").append(toIndentedString(isAnonymous)).append("\n");
    sb.append("    isReadOnly: ").append(toIndentedString(isReadOnly)).append("\n");
    sb.append("    addNewUsersFromParent: ").append(toIndentedString(addNewUsersFromParent)).append("\n");
    sb.append("    isAdminChat: ").append(toIndentedString(isAdminChat)).append("\n");
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
     
    out.writeValue(name);

    out.writeValue(courseCode);

    out.writeValue(desc);

    out.writeValue(color);

    out.writeValue(pictureFile);

    out.writeValue(parent);

    out.writeValue(searchable);

    out.writeValue(isClass);

    out.writeValue(isBot);

    out.writeValue(isAnonymous);

    out.writeValue(isReadOnly);

    out.writeValue(addNewUsersFromParent);

    out.writeValue(isAdminChat);
  }

  public APIViewChatSerializer() {
    super();
  }

  APIViewChatSerializer(Parcel in) {
    
    name = (String)in.readValue(null);
    courseCode = (String)in.readValue(null);
    desc = (String)in.readValue(null);
    color = (Integer)in.readValue(null);
    pictureFile = (Integer)in.readValue(null);
    parent = (Integer)in.readValue(null);
    searchable = (Boolean)in.readValue(null);
    isClass = (Boolean)in.readValue(null);
    isBot = (Boolean)in.readValue(null);
    isAnonymous = (Boolean)in.readValue(null);
    isReadOnly = (Boolean)in.readValue(null);
    addNewUsersFromParent = (Boolean)in.readValue(null);
    isAdminChat = (Boolean)in.readValue(null);
  }
  
  public int describeContents() {
    return 0;
  }

  public static final Parcelable.Creator<APIViewChatSerializer> CREATOR = new Parcelable.Creator<APIViewChatSerializer>() {
    public APIViewChatSerializer createFromParcel(Parcel in) {
      return new APIViewChatSerializer(in);
    }
    public APIViewChatSerializer[] newArray(int size) {
      return new APIViewChatSerializer[size];
    }
  };
}

