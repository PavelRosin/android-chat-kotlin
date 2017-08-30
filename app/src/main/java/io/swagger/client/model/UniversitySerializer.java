package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.FileSerializer;
import android.os.Parcelable;
import android.os.Parcel;

/**
 * UniversitySerializer
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-08-09T16:18:16.327Z")
public class UniversitySerializer implements Parcelable {
  @SerializedName("id")
  private Integer id = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("website_url")
  private String websiteUrl = null;

  @SerializedName("desc")
  private String desc = null;

  @SerializedName("picture_file")
  private FileSerializer pictureFile = null;

  @SerializedName("location")
  private String location = null;

  @SerializedName("fb_link")
  private String fbLink = null;

  @SerializedName("email")
  private String email = null;

  public UniversitySerializer id(Integer id) {
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

  public UniversitySerializer name(String name) {
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

  public UniversitySerializer websiteUrl(String websiteUrl) {
    this.websiteUrl = websiteUrl;
    return this;
  }

   /**
   * 
   * @return websiteUrl
  **/
  @ApiModelProperty(value = "")
  public String getWebsiteUrl() {
    return websiteUrl;
  }

  public void setWebsiteUrl(String websiteUrl) {
    this.websiteUrl = websiteUrl;
  }

  public UniversitySerializer desc(String desc) {
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

  public UniversitySerializer pictureFile(FileSerializer pictureFile) {
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

  public UniversitySerializer location(String location) {
    this.location = location;
    return this;
  }

   /**
   * 
   * @return location
  **/
  @ApiModelProperty(value = "")
  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public UniversitySerializer fbLink(String fbLink) {
    this.fbLink = fbLink;
    return this;
  }

   /**
   * 
   * @return fbLink
  **/
  @ApiModelProperty(value = "")
  public String getFbLink() {
    return fbLink;
  }

  public void setFbLink(String fbLink) {
    this.fbLink = fbLink;
  }

  public UniversitySerializer email(String email) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UniversitySerializer universitySerializer = (UniversitySerializer) o;
    return Objects.equals(this.id, universitySerializer.id) &&
        Objects.equals(this.name, universitySerializer.name) &&
        Objects.equals(this.websiteUrl, universitySerializer.websiteUrl) &&
        Objects.equals(this.desc, universitySerializer.desc) &&
        Objects.equals(this.pictureFile, universitySerializer.pictureFile) &&
        Objects.equals(this.location, universitySerializer.location) &&
        Objects.equals(this.fbLink, universitySerializer.fbLink) &&
        Objects.equals(this.email, universitySerializer.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, websiteUrl, desc, pictureFile, location, fbLink, email);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UniversitySerializer {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    websiteUrl: ").append(toIndentedString(websiteUrl)).append("\n");
    sb.append("    desc: ").append(toIndentedString(desc)).append("\n");
    sb.append("    pictureFile: ").append(toIndentedString(pictureFile)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    fbLink: ").append(toIndentedString(fbLink)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
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
     
    out.writeValue(id);

    out.writeValue(name);

    out.writeValue(websiteUrl);

    out.writeValue(desc);

    out.writeValue(pictureFile);

    out.writeValue(location);

    out.writeValue(fbLink);

    out.writeValue(email);
  }

  public UniversitySerializer() {
    super();
  }

  UniversitySerializer(Parcel in) {
    
    id = (Integer)in.readValue(null);
    name = (String)in.readValue(null);
    websiteUrl = (String)in.readValue(null);
    desc = (String)in.readValue(null);
    pictureFile = (FileSerializer)in.readValue(null);
    location = (String)in.readValue(null);
    fbLink = (String)in.readValue(null);
    email = (String)in.readValue(null);
  }
  
  public int describeContents() {
    return 0;
  }

  public static final Parcelable.Creator<UniversitySerializer> CREATOR = new Parcelable.Creator<UniversitySerializer>() {
    public UniversitySerializer createFromParcel(Parcel in) {
      return new UniversitySerializer(in);
    }
    public UniversitySerializer[] newArray(int size) {
      return new UniversitySerializer[size];
    }
  };
}

