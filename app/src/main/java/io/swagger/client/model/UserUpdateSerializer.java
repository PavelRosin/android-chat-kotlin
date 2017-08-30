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
 * UserUpdateSerializer
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-08-09T16:18:16.327Z")
public class UserUpdateSerializer implements Parcelable {
  @SerializedName("first_name")
  private String firstName = null;

  @SerializedName("last_name")
  private String lastName = null;

  @SerializedName("year_of_graduation")
  private Integer yearOfGraduation = null;

  @SerializedName("picture_file")
  private Integer pictureFile = null;

  @SerializedName("areas_of_study")
  private List<String> areasOfStudy = new ArrayList<String>();

  @SerializedName("type")
  private String type = null;

  @SerializedName("school")
  private Integer school = null;

  @SerializedName("department")
  private Integer department = null;

  @SerializedName("phone_num")
  private String phoneNum = null;

  @SerializedName("user_bio")
  private String userBio = null;

  public UserUpdateSerializer firstName(String firstName) {
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

  public UserUpdateSerializer lastName(String lastName) {
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

  public UserUpdateSerializer yearOfGraduation(Integer yearOfGraduation) {
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

  public UserUpdateSerializer pictureFile(Integer pictureFile) {
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

  public UserUpdateSerializer areasOfStudy(List<String> areasOfStudy) {
    this.areasOfStudy = areasOfStudy;
    return this;
  }

  public UserUpdateSerializer addAreasOfStudyItem(String areasOfStudyItem) {
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

  public UserUpdateSerializer type(String type) {
    this.type = type;
    return this;
  }

   /**
   * STUDENT = 's', PROFESSOR = 'p', ADMIN = 'a', BOT = 'b', OTHER = 'o'
   * @return type
  **/
  @ApiModelProperty(value = "STUDENT = 's', PROFESSOR = 'p', ADMIN = 'a', BOT = 'b', OTHER = 'o'")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public UserUpdateSerializer school(Integer school) {
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

  public UserUpdateSerializer department(Integer department) {
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

  public UserUpdateSerializer phoneNum(String phoneNum) {
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

  public UserUpdateSerializer userBio(String userBio) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserUpdateSerializer userUpdateSerializer = (UserUpdateSerializer) o;
    return Objects.equals(this.firstName, userUpdateSerializer.firstName) &&
        Objects.equals(this.lastName, userUpdateSerializer.lastName) &&
        Objects.equals(this.yearOfGraduation, userUpdateSerializer.yearOfGraduation) &&
        Objects.equals(this.pictureFile, userUpdateSerializer.pictureFile) &&
        Objects.equals(this.areasOfStudy, userUpdateSerializer.areasOfStudy) &&
        Objects.equals(this.type, userUpdateSerializer.type) &&
        Objects.equals(this.school, userUpdateSerializer.school) &&
        Objects.equals(this.department, userUpdateSerializer.department) &&
        Objects.equals(this.phoneNum, userUpdateSerializer.phoneNum) &&
        Objects.equals(this.userBio, userUpdateSerializer.userBio);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, yearOfGraduation, pictureFile, areasOfStudy, type, school, department, phoneNum, userBio);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserUpdateSerializer {\n");
    
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    yearOfGraduation: ").append(toIndentedString(yearOfGraduation)).append("\n");
    sb.append("    pictureFile: ").append(toIndentedString(pictureFile)).append("\n");
    sb.append("    areasOfStudy: ").append(toIndentedString(areasOfStudy)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    school: ").append(toIndentedString(school)).append("\n");
    sb.append("    department: ").append(toIndentedString(department)).append("\n");
    sb.append("    phoneNum: ").append(toIndentedString(phoneNum)).append("\n");
    sb.append("    userBio: ").append(toIndentedString(userBio)).append("\n");
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
     
    out.writeValue(firstName);

    out.writeValue(lastName);

    out.writeValue(yearOfGraduation);

    out.writeValue(pictureFile);

    out.writeValue(areasOfStudy);

    out.writeValue(type);

    out.writeValue(school);

    out.writeValue(department);

    out.writeValue(phoneNum);

    out.writeValue(userBio);
  }

  public UserUpdateSerializer() {
    super();
  }

  UserUpdateSerializer(Parcel in) {
    
    firstName = (String)in.readValue(null);
    lastName = (String)in.readValue(null);
    yearOfGraduation = (Integer)in.readValue(null);
    pictureFile = (Integer)in.readValue(null);
    areasOfStudy = (List<String>)in.readValue(null);
    type = (String)in.readValue(null);
    school = (Integer)in.readValue(null);
    department = (Integer)in.readValue(null);
    phoneNum = (String)in.readValue(null);
    userBio = (String)in.readValue(null);
  }
  
  public int describeContents() {
    return 0;
  }

  public static final Parcelable.Creator<UserUpdateSerializer> CREATOR = new Parcelable.Creator<UserUpdateSerializer>() {
    public UserUpdateSerializer createFromParcel(Parcel in) {
      return new UserUpdateSerializer(in);
    }
    public UserUpdateSerializer[] newArray(int size) {
      return new UserUpdateSerializer[size];
    }
  };
}

