package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import android.os.Parcelable;
import android.os.Parcel;

/**
 * FileSerializer
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-08-09T16:18:16.327Z")
public class FileSerializer implements Parcelable {
  @SerializedName("id")
  private Integer id = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("source")
  private String source = null;

  @SerializedName("url")
  private String url = null;

  @SerializedName("size")
  private Integer size = null;

  public FileSerializer id(Integer id) {
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

  public FileSerializer name(String name) {
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

  public FileSerializer source(String source) {
    this.source = source;
    return this;
  }

   /**
   * 
   * @return source
  **/
  @ApiModelProperty(value = "")
  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public FileSerializer url(String url) {
    this.url = url;
    return this;
  }

   /**
   * 
   * @return url
  **/
  @ApiModelProperty(value = "")
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public FileSerializer size(Integer size) {
    this.size = size;
    return this;
  }

   /**
   * 
   * @return size
  **/
  @ApiModelProperty(value = "")
  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FileSerializer fileSerializer = (FileSerializer) o;
    return Objects.equals(this.id, fileSerializer.id) &&
        Objects.equals(this.name, fileSerializer.name) &&
        Objects.equals(this.source, fileSerializer.source) &&
        Objects.equals(this.url, fileSerializer.url) &&
        Objects.equals(this.size, fileSerializer.size);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, source, url, size);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FileSerializer {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
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

    out.writeValue(source);

    out.writeValue(url);

    out.writeValue(size);
  }

  public FileSerializer() {
    super();
  }

  FileSerializer(Parcel in) {
    
    id = (Integer)in.readValue(null);
    name = (String)in.readValue(null);
    source = (String)in.readValue(null);
    url = (String)in.readValue(null);
    size = (Integer)in.readValue(null);
  }
  
  public int describeContents() {
    return 0;
  }

  public static final Parcelable.Creator<FileSerializer> CREATOR = new Parcelable.Creator<FileSerializer>() {
    public FileSerializer createFromParcel(Parcel in) {
      return new FileSerializer(in);
    }
    public FileSerializer[] newArray(int size) {
      return new FileSerializer[size];
    }
  };
}

