package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.ColorSerializer;
import io.swagger.client.model.FileSerializer;
import io.swagger.client.model.MessageSerializer;
import io.swagger.client.model.TagSerializer;
import java.util.ArrayList;
import java.util.List;
import android.os.Parcelable;
import android.os.Parcel;

/**
 * ChatSerializer
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-08-09T16:18:16.327Z")
public class ChatSerializer implements Parcelable {
  @SerializedName("name")
  private String name = null;

  @SerializedName("course_code")
  private String courseCode = null;

  @SerializedName("desc")
  private String desc = null;

  @SerializedName("color")
  private ColorSerializer color = null;

  @SerializedName("picture_file")
  private FileSerializer pictureFile = null;

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

  @SerializedName("id")
  private Integer id = null;

  @SerializedName("creator")
  private Integer creator = null;

  @SerializedName("most_recent_message")
  private MessageSerializer mostRecentMessage = null;

  @SerializedName("member_count")
  private Integer memberCount = null;

  @SerializedName("tags")
  private List<TagSerializer> tags = new ArrayList<TagSerializer>();

  @SerializedName("university")
  private Integer university = null;

  @SerializedName("school")
  private Integer school = null;

  @SerializedName("department")
  private Integer department = null;

  @SerializedName("modified")
  private String modified = null;

  @SerializedName("created")
  private String created = null;

  @SerializedName("unread_count")
  private Integer unreadCount = null;

  @SerializedName("has_children")
  private Boolean hasChildren = null;

  public ChatSerializer name(String name) {
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

  public ChatSerializer courseCode(String courseCode) {
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

  public ChatSerializer desc(String desc) {
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

  public ChatSerializer color(ColorSerializer color) {
    this.color = color;
    return this;
  }

   /**
   * Get color
   * @return color
  **/
  @ApiModelProperty(value = "")
  public ColorSerializer getColor() {
    return color;
  }

  public void setColor(ColorSerializer color) {
    this.color = color;
  }

  public ChatSerializer pictureFile(FileSerializer pictureFile) {
    this.pictureFile = pictureFile;
    return this;
  }

   /**
   * 
   * @return pictureFile
  **/
  @ApiModelProperty(value = "")
  public FileSerializer getPictureFile() {
    return pictureFile;
  }

  public void setPictureFile(FileSerializer pictureFile) {
    this.pictureFile = pictureFile;
  }

  public ChatSerializer parent(Integer parent) {
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

  public ChatSerializer searchable(Boolean searchable) {
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

  public ChatSerializer isClass(Boolean isClass) {
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

  public ChatSerializer isBot(Boolean isBot) {
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

  public ChatSerializer isAnonymous(Boolean isAnonymous) {
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

  public ChatSerializer isReadOnly(Boolean isReadOnly) {
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

  public ChatSerializer addNewUsersFromParent(Boolean addNewUsersFromParent) {
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

  public ChatSerializer isAdminChat(Boolean isAdminChat) {
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

  public ChatSerializer id(Integer id) {
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

  public ChatSerializer creator(Integer creator) {
    this.creator = creator;
    return this;
  }

   /**
   * 
   * @return creator
  **/
  @ApiModelProperty(value = "")
  public Integer getCreator() {
    return creator;
  }

  public void setCreator(Integer creator) {
    this.creator = creator;
  }

  public ChatSerializer mostRecentMessage(MessageSerializer mostRecentMessage) {
    this.mostRecentMessage = mostRecentMessage;
    return this;
  }

   /**
   * Get mostRecentMessage
   * @return mostRecentMessage
  **/
  @ApiModelProperty(value = "")
  public MessageSerializer getMostRecentMessage() {
    return mostRecentMessage;
  }

  public void setMostRecentMessage(MessageSerializer mostRecentMessage) {
    this.mostRecentMessage = mostRecentMessage;
  }

  public ChatSerializer memberCount(Integer memberCount) {
    this.memberCount = memberCount;
    return this;
  }

   /**
   * 
   * @return memberCount
  **/
  @ApiModelProperty(value = "")
  public Integer getMemberCount() {
    return memberCount;
  }

  public void setMemberCount(Integer memberCount) {
    this.memberCount = memberCount;
  }

  public ChatSerializer tags(List<TagSerializer> tags) {
    this.tags = tags;
    return this;
  }

  public ChatSerializer addTagsItem(TagSerializer tagsItem) {
    this.tags.add(tagsItem);
    return this;
  }

   /**
   * 
   * @return tags
  **/
  @ApiModelProperty(value = "")
  public List<TagSerializer> getTags() {
    return tags;
  }

  public void setTags(List<TagSerializer> tags) {
    this.tags = tags;
  }

  public ChatSerializer university(Integer university) {
    this.university = university;
    return this;
  }

   /**
   * 
   * @return university
  **/
  @ApiModelProperty(value = "")
  public Integer getUniversity() {
    return university;
  }

  public void setUniversity(Integer university) {
    this.university = university;
  }

  public ChatSerializer school(Integer school) {
    this.school = school;
    return this;
  }

   /**
   * 
   * @return school
  **/
  @ApiModelProperty(value = "")
  public Integer getSchool() {
    return school;
  }

  public void setSchool(Integer school) {
    this.school = school;
  }

  public ChatSerializer department(Integer department) {
    this.department = department;
    return this;
  }

   /**
   * 
   * @return department
  **/
  @ApiModelProperty(value = "")
  public Integer getDepartment() {
    return department;
  }

  public void setDepartment(Integer department) {
    this.department = department;
  }

  public ChatSerializer modified(String modified) {
    this.modified = modified;
    return this;
  }

   /**
   * 
   * @return modified
  **/
  @ApiModelProperty(value = "")
  public String getModified() {
    return modified;
  }

  public void setModified(String modified) {
    this.modified = modified;
  }

  public ChatSerializer created(String created) {
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

  public ChatSerializer unreadCount(Integer unreadCount) {
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

  public ChatSerializer hasChildren(Boolean hasChildren) {
    this.hasChildren = hasChildren;
    return this;
  }

   /**
   * 
   * @return hasChildren
  **/
  @ApiModelProperty(value = "")
  public Boolean getHasChildren() {
    return hasChildren;
  }

  public void setHasChildren(Boolean hasChildren) {
    this.hasChildren = hasChildren;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChatSerializer chatSerializer = (ChatSerializer) o;
    return Objects.equals(this.name, chatSerializer.name) &&
        Objects.equals(this.courseCode, chatSerializer.courseCode) &&
        Objects.equals(this.desc, chatSerializer.desc) &&
        Objects.equals(this.color, chatSerializer.color) &&
        Objects.equals(this.pictureFile, chatSerializer.pictureFile) &&
        Objects.equals(this.parent, chatSerializer.parent) &&
        Objects.equals(this.searchable, chatSerializer.searchable) &&
        Objects.equals(this.isClass, chatSerializer.isClass) &&
        Objects.equals(this.isBot, chatSerializer.isBot) &&
        Objects.equals(this.isAnonymous, chatSerializer.isAnonymous) &&
        Objects.equals(this.isReadOnly, chatSerializer.isReadOnly) &&
        Objects.equals(this.addNewUsersFromParent, chatSerializer.addNewUsersFromParent) &&
        Objects.equals(this.isAdminChat, chatSerializer.isAdminChat) &&
        Objects.equals(this.id, chatSerializer.id) &&
        Objects.equals(this.creator, chatSerializer.creator) &&
        Objects.equals(this.mostRecentMessage, chatSerializer.mostRecentMessage) &&
        Objects.equals(this.memberCount, chatSerializer.memberCount) &&
        Objects.equals(this.tags, chatSerializer.tags) &&
        Objects.equals(this.university, chatSerializer.university) &&
        Objects.equals(this.school, chatSerializer.school) &&
        Objects.equals(this.department, chatSerializer.department) &&
        Objects.equals(this.modified, chatSerializer.modified) &&
        Objects.equals(this.created, chatSerializer.created) &&
        Objects.equals(this.unreadCount, chatSerializer.unreadCount) &&
        Objects.equals(this.hasChildren, chatSerializer.hasChildren);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, courseCode, desc, color, pictureFile, parent, searchable, isClass, isBot, isAnonymous, isReadOnly, addNewUsersFromParent, isAdminChat, id, creator, mostRecentMessage, memberCount, tags, university, school, department, modified, created, unreadCount, hasChildren);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChatSerializer {\n");
    
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
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    creator: ").append(toIndentedString(creator)).append("\n");
    sb.append("    mostRecentMessage: ").append(toIndentedString(mostRecentMessage)).append("\n");
    sb.append("    memberCount: ").append(toIndentedString(memberCount)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    university: ").append(toIndentedString(university)).append("\n");
    sb.append("    school: ").append(toIndentedString(school)).append("\n");
    sb.append("    department: ").append(toIndentedString(department)).append("\n");
    sb.append("    modified: ").append(toIndentedString(modified)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    unreadCount: ").append(toIndentedString(unreadCount)).append("\n");
    sb.append("    hasChildren: ").append(toIndentedString(hasChildren)).append("\n");
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

    out.writeValue(id);

    out.writeValue(creator);

    out.writeValue(mostRecentMessage);

    out.writeValue(memberCount);

    out.writeValue(tags);

    out.writeValue(university);

    out.writeValue(school);

    out.writeValue(department);

    out.writeValue(modified);

    out.writeValue(created);

    out.writeValue(unreadCount);

    out.writeValue(hasChildren);
  }

  public ChatSerializer() {
    super();
  }

  ChatSerializer(Parcel in) {
    
    name = (String)in.readValue(null);
    courseCode = (String)in.readValue(null);
    desc = (String)in.readValue(null);
    color = (ColorSerializer)in.readValue(null);
    pictureFile = (FileSerializer)in.readValue(null);
    parent = (Integer)in.readValue(null);
    searchable = (Boolean)in.readValue(null);
    isClass = (Boolean)in.readValue(null);
    isBot = (Boolean)in.readValue(null);
    isAnonymous = (Boolean)in.readValue(null);
    isReadOnly = (Boolean)in.readValue(null);
    addNewUsersFromParent = (Boolean)in.readValue(null);
    isAdminChat = (Boolean)in.readValue(null);
    id = (Integer)in.readValue(null);
    creator = (Integer)in.readValue(null);
    mostRecentMessage = (MessageSerializer)in.readValue(null);
    memberCount = (Integer)in.readValue(null);
    tags = (List<TagSerializer>)in.readValue(TagSerializer.class.getClassLoader());
    university = (Integer)in.readValue(null);
    school = (Integer)in.readValue(null);
    department = (Integer)in.readValue(null);
    modified = (String)in.readValue(null);
    created = (String)in.readValue(null);
    unreadCount = (Integer)in.readValue(null);
    hasChildren = (Boolean)in.readValue(null);
  }
  
  public int describeContents() {
    return 0;
  }

  public static final Parcelable.Creator<ChatSerializer> CREATOR = new Parcelable.Creator<ChatSerializer>() {
    public ChatSerializer createFromParcel(Parcel in) {
      return new ChatSerializer(in);
    }
    public ChatSerializer[] newArray(int size) {
      return new ChatSerializer[size];
    }
  };
}

