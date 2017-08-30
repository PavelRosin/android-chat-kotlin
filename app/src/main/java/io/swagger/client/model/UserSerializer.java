package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.FileSerializer;
import io.swagger.client.model.TagSerializer;
import java.util.ArrayList;
import java.util.List;
import android.os.Parcelable;
import android.os.Parcel;

/**
 * UserSerializer
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-08-09T16:18:16.327Z")
public class UserSerializer implements Parcelable {
  @SerializedName("type")
  private String type = null;

  @SerializedName("department")
  private Integer department = null;

  @SerializedName("year_of_graduation")
  private Integer yearOfGraduation = null;

  @SerializedName("tags")
  private List<TagSerializer> tags = new ArrayList<TagSerializer>();

  @SerializedName("id")
  private Integer id = null;

  @SerializedName("email")
  private String email = null;

  @SerializedName("school")
  private Integer school = null;

  @SerializedName("user_bio")
  private String userBio = null;

  @SerializedName("picture_file")
  private FileSerializer pictureFile = null;

  @SerializedName("status")
  private String status = null;

  @SerializedName("phone_num")
  private String phoneNum = null;

  @SerializedName("first_name")
  private String firstName = null;

  @SerializedName("areas_of_study")
  private List<String> areasOfStudy = new ArrayList<String>();

  @SerializedName("is_online")
  private Boolean isOnline = null;

  @SerializedName("last_name")
  private String lastName = null;

  @SerializedName("university")
  private Integer university = null;

  public UserSerializer type(String type) {
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

  public UserSerializer department(Integer department) {
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

  public UserSerializer yearOfGraduation(Integer yearOfGraduation) {
    this.yearOfGraduation = yearOfGraduation;
    return this;
  }

   /**
   * 
   * @return yearOfGraduation
  **/
  @ApiModelProperty(value = "")
  public Integer getYearOfGraduation() {
    return yearOfGraduation;
  }

  public void setYearOfGraduation(Integer yearOfGraduation) {
    this.yearOfGraduation = yearOfGraduation;
  }

  public UserSerializer tags(List<TagSerializer> tags) {
    this.tags = tags;
    return this;
  }

  public UserSerializer addTagsItem(TagSerializer tagsItem) {
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

  public UserSerializer id(Integer id) {
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

  public UserSerializer email(String email) {
    this.email = email;
    return this;
  }

   /**
   * 
   * @return email
  **/
  @ApiModelProperty(value = "")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UserSerializer school(Integer school) {
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

  public UserSerializer userBio(String userBio) {
    this.userBio = userBio;
    return this;
  }

   /**
   * 
   * @return userBio
  **/
  @ApiModelProperty(value = "")
  public String getUserBio() {
    return userBio;
  }

  public void setUserBio(String userBio) {
    this.userBio = userBio;
  }

  public UserSerializer pictureFile(FileSerializer pictureFile) {
    this.pictureFile = pictureFile;
    return this;
  }

   /**
   * Get pictureFile
   * @return pictureFile
  **/
  @ApiModelProperty(value = "")
  public FileSerializer getPictureFile() {
    return pictureFile;
  }

  public void setPictureFile(FileSerializer pictureFile) {
    this.pictureFile = pictureFile;
  }

  public UserSerializer status(String status) {
    this.status = status;
    return this;
  }

   /**
   * 
   * @return status
  **/
  @ApiModelProperty(value = "")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public UserSerializer phoneNum(String phoneNum) {
    this.phoneNum = phoneNum;
    return this;
  }

   /**
   * 
   * @return phoneNum
  **/
  @ApiModelProperty(value = "")
  public String getPhoneNum() {
    return phoneNum;
  }

  public void setPhoneNum(String phoneNum) {
    this.phoneNum = phoneNum;
  }

  public UserSerializer firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

   /**
   * 
   * @return firstName
  **/
  @ApiModelProperty(value = "")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public UserSerializer areasOfStudy(List<String> areasOfStudy) {
    this.areasOfStudy = areasOfStudy;
    return this;
  }

  public UserSerializer addAreasOfStudyItem(String areasOfStudyItem) {
    this.areasOfStudy.add(areasOfStudyItem);
    return this;
  }

   /**
   * 
   * @return areasOfStudy
  **/
  @ApiModelProperty(value = "")
  public List<String> getAreasOfStudy() {
    return areasOfStudy;
  }

  public void setAreasOfStudy(List<String> areasOfStudy) {
    this.areasOfStudy = areasOfStudy;
  }

  public UserSerializer isOnline(Boolean isOnline) {
    this.isOnline = isOnline;
    return this;
  }

   /**
   * 
   * @return isOnline
  **/
  @ApiModelProperty(value = "")
  public Boolean getIsOnline() {
    return isOnline;
  }

  public void setIsOnline(Boolean isOnline) {
    this.isOnline = isOnline;
  }

  public UserSerializer lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

   /**
   * 
   * @return lastName
  **/
  @ApiModelProperty(value = "")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public UserSerializer university(Integer university) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserSerializer userSerializer = (UserSerializer) o;
    return Objects.equals(this.type, userSerializer.type) &&
        Objects.equals(this.department, userSerializer.department) &&
        Objects.equals(this.yearOfGraduation, userSerializer.yearOfGraduation) &&
        Objects.equals(this.tags, userSerializer.tags) &&
        Objects.equals(this.id, userSerializer.id) &&
        Objects.equals(this.email, userSerializer.email) &&
        Objects.equals(this.school, userSerializer.school) &&
        Objects.equals(this.userBio, userSerializer.userBio) &&
        Objects.equals(this.pictureFile, userSerializer.pictureFile) &&
        Objects.equals(this.status, userSerializer.status) &&
        Objects.equals(this.phoneNum, userSerializer.phoneNum) &&
        Objects.equals(this.firstName, userSerializer.firstName) &&
        Objects.equals(this.areasOfStudy, userSerializer.areasOfStudy) &&
        Objects.equals(this.isOnline, userSerializer.isOnline) &&
        Objects.equals(this.lastName, userSerializer.lastName) &&
        Objects.equals(this.university, userSerializer.university);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, department, yearOfGraduation, tags, id, email, school, userBio, pictureFile, status, phoneNum, firstName, areasOfStudy, isOnline, lastName, university);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserSerializer {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    department: ").append(toIndentedString(department)).append("\n");
    sb.append("    yearOfGraduation: ").append(toIndentedString(yearOfGraduation)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    school: ").append(toIndentedString(school)).append("\n");
    sb.append("    userBio: ").append(toIndentedString(userBio)).append("\n");
    sb.append("    pictureFile: ").append(toIndentedString(pictureFile)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    phoneNum: ").append(toIndentedString(phoneNum)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    areasOfStudy: ").append(toIndentedString(areasOfStudy)).append("\n");
    sb.append("    isOnline: ").append(toIndentedString(isOnline)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    university: ").append(toIndentedString(university)).append("\n");
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
     
    out.writeValue(type);

    out.writeValue(department);

    out.writeValue(yearOfGraduation);

    out.writeValue(tags);

    out.writeValue(id);

    out.writeValue(email);

    out.writeValue(school);

    out.writeValue(userBio);

    out.writeValue(pictureFile);

    out.writeValue(status);

    out.writeValue(phoneNum);

    out.writeValue(firstName);

    out.writeValue(areasOfStudy);

    out.writeValue(isOnline);

    out.writeValue(lastName);

    out.writeValue(university);
  }

  public UserSerializer() {
    super();
  }

  UserSerializer(Parcel in) {
    
    type = (String)in.readValue(null);
    department = (Integer)in.readValue(null);
    yearOfGraduation = (Integer)in.readValue(null);
    tags = (List<TagSerializer>)in.readValue(TagSerializer.class.getClassLoader());
    id = (Integer)in.readValue(null);
    email = (String)in.readValue(null);
    school = (Integer)in.readValue(null);
    userBio = (String)in.readValue(null);
    pictureFile = (FileSerializer)in.readValue(null);
    status = (String)in.readValue(null);
    phoneNum = (String)in.readValue(null);
    firstName = (String)in.readValue(null);
    areasOfStudy = (List<String>)in.readValue(null);
    isOnline = (Boolean)in.readValue(null);
    lastName = (String)in.readValue(null);
    university = (Integer)in.readValue(null);
  }
  
  public int describeContents() {
    return 0;
  }

  public static final Parcelable.Creator<UserSerializer> CREATOR = new Parcelable.Creator<UserSerializer>() {
    public UserSerializer createFromParcel(Parcel in) {
      return new UserSerializer(in);
    }
    public UserSerializer[] newArray(int size) {
      return new UserSerializer[size];
    }
  };
}

