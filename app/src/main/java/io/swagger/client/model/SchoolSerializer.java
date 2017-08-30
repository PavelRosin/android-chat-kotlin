package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.FileSerializer;
import io.swagger.client.model.UniversitySerializer;
import android.os.Parcelable;
import android.os.Parcel;

/**
 * SchoolSerializer
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-08-09T16:18:16.327Z")
public class SchoolSerializer implements Parcelable {
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

  @SerializedName("university")
  private UniversitySerializer university = null;

  @SerializedName("fb_link")
  private String fbLink = null;

  @SerializedName("twitter_link")
  private String twitterLink = null;

  @SerializedName("founded")
  private String founded = null;

  public SchoolSerializer id(Integer id) {
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

  public SchoolSerializer name(String name) {
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

  public SchoolSerializer websiteUrl(String websiteUrl) {
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

  public SchoolSerializer desc(String desc) {
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

  public SchoolSerializer pictureFile(FileSerializer pictureFile) {
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

  public SchoolSerializer location(String location) {
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

  public SchoolSerializer university(UniversitySerializer university) {
    this.university = university;
    return this;
  }

   /**
   * Get university
   * @return university
  **/
  @ApiModelProperty(value = "")
  public UniversitySerializer getUniversity() {
    return university;
  }

  public void setUniversity(UniversitySerializer university) {
    this.university = university;
  }

  public SchoolSerializer fbLink(String fbLink) {
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

  public SchoolSerializer twitterLink(String twitterLink) {
    this.twitterLink = twitterLink;
    return this;
  }

   /**
   * 
   * @return twitterLink
  **/
  @ApiModelProperty(value = "")
  public String getTwitterLink() {
    return twitterLink;
  }

  public void setTwitterLink(String twitterLink) {
    this.twitterLink = twitterLink;
  }

  public SchoolSerializer founded(String founded) {
    this.founded = founded;
    return this;
  }

   /**
   * 
   * @return founded
  **/
  @ApiModelProperty(value = "")
  public String getFounded() {
    return founded;
  }

  public void setFounded(String founded) {
    this.founded = founded;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SchoolSerializer schoolSerializer = (SchoolSerializer) o;
    return Objects.equals(this.id, schoolSerializer.id) &&
        Objects.equals(this.name, schoolSerializer.name) &&
        Objects.equals(this.websiteUrl, schoolSerializer.websiteUrl) &&
        Objects.equals(this.desc, schoolSerializer.desc) &&
        Objects.equals(this.pictureFile, schoolSerializer.pictureFile) &&
        Objects.equals(this.location, schoolSerializer.location) &&
        Objects.equals(this.university, schoolSerializer.university) &&
        Objects.equals(this.fbLink, schoolSerializer.fbLink) &&
        Objects.equals(this.twitterLink, schoolSerializer.twitterLink) &&
        Objects.equals(this.founded, schoolSerializer.founded);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, websiteUrl, desc, pictureFile, location, university, fbLink, twitterLink, founded);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SchoolSerializer {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    websiteUrl: ").append(toIndentedString(websiteUrl)).append("\n");
    sb.append("    desc: ").append(toIndentedString(desc)).append("\n");
    sb.append("    pictureFile: ").append(toIndentedString(pictureFile)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    university: ").append(toIndentedString(university)).append("\n");
    sb.append("    fbLink: ").append(toIndentedString(fbLink)).append("\n");
    sb.append("    twitterLink: ").append(toIndentedString(twitterLink)).append("\n");
    sb.append("    founded: ").append(toIndentedString(founded)).append("\n");
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

    out.writeValue(university);

    out.writeValue(fbLink);

    out.writeValue(twitterLink);

    out.writeValue(founded);
  }

  public SchoolSerializer() {
    super();
  }

  SchoolSerializer(Parcel in) {
    
    id = (Integer)in.readValue(null);
    name = (String)in.readValue(null);
    websiteUrl = (String)in.readValue(null);
    desc = (String)in.readValue(null);
    pictureFile = (FileSerializer)in.readValue(null);
    location = (String)in.readValue(null);
    university = (UniversitySerializer)in.readValue(null);
    fbLink = (String)in.readValue(null);
    twitterLink = (String)in.readValue(null);
    founded = (String)in.readValue(null);
  }
  
  public int describeContents() {
    return 0;
  }

  public static final Parcelable.Creator<SchoolSerializer> CREATOR = new Parcelable.Creator<SchoolSerializer>() {
    public SchoolSerializer createFromParcel(Parcel in) {
      return new SchoolSerializer(in);
    }
    public SchoolSerializer[] newArray(int size) {
      return new SchoolSerializer[size];
    }
  };
}

