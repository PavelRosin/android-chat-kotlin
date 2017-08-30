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
 * APIViewUserSerializer
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-08-09T16:18:16.327Z")
public class APIViewUserSerializer implements Parcelable {
  @SerializedName("first_name")
  private String firstName = null;

  @SerializedName("last_name")
  private String lastName = null;

  @SerializedName("email")
  private String email = null;

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

  @SerializedName("password")
  private String password = null;

  @SerializedName("university")
  private Integer university = null;

  public APIViewUserSerializer firstName(String firstName) {
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

  public APIViewUserSerializer lastName(String lastName) {
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

  public APIViewUserSerializer email(String email) {
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

  public APIViewUserSerializer yearOfGraduation(Integer yearOfGraduation) {
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

  public APIViewUserSerializer pictureFile(Integer pictureFile) {
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

  public APIViewUserSerializer areasOfStudy(List<String> areasOfStudy) {
    this.areasOfStudy = areasOfStudy;
    return this;
  }

  public APIViewUserSerializer addAreasOfStudyItem(String areasOfStudyItem) {
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

  public APIViewUserSerializer type(String type) {
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

  public APIViewUserSerializer school(Integer school) {
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

  public APIViewUserSerializer department(Integer department) {
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

  public APIViewUserSerializer phoneNum(String phoneNum) {
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

  public APIViewUserSerializer userBio(String userBio) {
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

  public APIViewUserSerializer password(String password) {
    this.password = password;
    return this;
  }

   /**
   * 
   * @return password
  **/
  @ApiModelProperty(value = "")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public APIViewUserSerializer university(Integer university) {
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
    APIViewUserSerializer apIViewUserSerializer = (APIViewUserSerializer) o;
    return Objects.equals(this.firstName, apIViewUserSerializer.firstName) &&
        Objects.equals(this.lastName, apIViewUserSerializer.lastName) &&
        Objects.equals(this.email, apIViewUserSerializer.email) &&
        Objects.equals(this.yearOfGraduation, apIViewUserSerializer.yearOfGraduation) &&
        Objects.equals(this.pictureFile, apIViewUserSerializer.pictureFile) &&
        Objects.equals(this.areasOfStudy, apIViewUserSerializer.areasOfStudy) &&
        Objects.equals(this.type, apIViewUserSerializer.type) &&
        Objects.equals(this.school, apIViewUserSerializer.school) &&
        Objects.equals(this.department, apIViewUserSerializer.department) &&
        Objects.equals(this.phoneNum, apIViewUserSerializer.phoneNum) &&
        Objects.equals(this.userBio, apIViewUserSerializer.userBio) &&
        Objects.equals(this.password, apIViewUserSerializer.password) &&
        Objects.equals(this.university, apIViewUserSerializer.university);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, email, yearOfGraduation, pictureFile, areasOfStudy, type, school, department, phoneNum, userBio, password, university);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class APIViewUserSerializer {\n");
    
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    yearOfGraduation: ").append(toIndentedString(yearOfGraduation)).append("\n");
    sb.append("    pictureFile: ").append(toIndentedString(pictureFile)).append("\n");
    sb.append("    areasOfStudy: ").append(toIndentedString(areasOfStudy)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    school: ").append(toIndentedString(school)).append("\n");
    sb.append("    department: ").append(toIndentedString(department)).append("\n");
    sb.append("    phoneNum: ").append(toIndentedString(phoneNum)).append("\n");
    sb.append("    userBio: ").append(toIndentedString(userBio)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
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
     
    out.writeValue(firstName);

    out.writeValue(lastName);

    out.writeValue(email);

    out.writeValue(yearOfGraduation);

    out.writeValue(pictureFile);

    out.writeValue(areasOfStudy);

    out.writeValue(type);

    out.writeValue(school);

    out.writeValue(department);

    out.writeValue(phoneNum);

    out.writeValue(userBio);

    out.writeValue(password);

    out.writeValue(university);
  }

  public APIViewUserSerializer() {
    super();
  }

  APIViewUserSerializer(Parcel in) {
    
    firstName = (String)in.readValue(null);
    lastName = (String)in.readValue(null);
    email = (String)in.readValue(null);
    yearOfGraduation = (Integer)in.readValue(null);
    pictureFile = (Integer)in.readValue(null);
    areasOfStudy = (List<String>)in.readValue(null);
    type = (String)in.readValue(null);
    school = (Integer)in.readValue(null);
    department = (Integer)in.readValue(null);
    phoneNum = (String)in.readValue(null);
    userBio = (String)in.readValue(null);
    password = (String)in.readValue(null);
    university = (Integer)in.readValue(null);
  }
  
  public int describeContents() {
    return 0;
  }

  public static final Parcelable.Creator<APIViewUserSerializer> CREATOR = new Parcelable.Creator<APIViewUserSerializer>() {
    public APIViewUserSerializer createFromParcel(Parcel in) {
      return new APIViewUserSerializer(in);
    }
    public APIViewUserSerializer[] newArray(int size) {
      return new APIViewUserSerializer[size];
    }
  };
}

