package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import android.os.Parcelable;
import android.os.Parcel;

/**
 * TagSerializer
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-08-09T16:18:16.327Z")
public class TagSerializer implements Parcelable {
  @SerializedName("id")
  private Integer id = null;

  @SerializedName("tag")
  private String tag = null;

  public TagSerializer id(Integer id) {
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

  public TagSerializer tag(String tag) {
    this.tag = tag;
    return this;
  }

   /**
   * 
   * @return tag
  **/
  @ApiModelProperty(value = "")
  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TagSerializer tagSerializer = (TagSerializer) o;
    return Objects.equals(this.id, tagSerializer.id) &&
        Objects.equals(this.tag, tagSerializer.tag);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, tag);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TagSerializer {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    tag: ").append(toIndentedString(tag)).append("\n");
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

    out.writeValue(tag);
  }

  public TagSerializer() {
    super();
  }

  TagSerializer(Parcel in) {
    
    id = (Integer)in.readValue(null);
    tag = (String)in.readValue(null);
  }
  
  public int describeContents() {
    return 0;
  }

  public static final Parcelable.Creator<TagSerializer> CREATOR = new Parcelable.Creator<TagSerializer>() {
    public TagSerializer createFromParcel(Parcel in) {
      return new TagSerializer(in);
    }
    public TagSerializer[] newArray(int size) {
      return new TagSerializer[size];
    }
  };
}

