package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import android.os.Parcelable;
import android.os.Parcel;

/**
 * ColorSerializer
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-08-09T16:18:16.327Z")
public class ColorSerializer implements Parcelable {
  @SerializedName("id")
  private Integer id = null;

  @SerializedName("hexcode")
  private String hexcode = null;

  public ColorSerializer id(Integer id) {
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

  public ColorSerializer hexcode(String hexcode) {
    this.hexcode = hexcode;
    return this;
  }

   /**
   * 
   * @return hexcode
  **/
  @ApiModelProperty(value = "")
  public String getHexcode() {
    return hexcode;
  }

  public void setHexcode(String hexcode) {
    this.hexcode = hexcode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ColorSerializer colorSerializer = (ColorSerializer) o;
    return Objects.equals(this.id, colorSerializer.id) &&
        Objects.equals(this.hexcode, colorSerializer.hexcode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, hexcode);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ColorSerializer {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    hexcode: ").append(toIndentedString(hexcode)).append("\n");
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

    out.writeValue(hexcode);
  }

  public ColorSerializer() {
    super();
  }

  ColorSerializer(Parcel in) {
    
    id = (Integer)in.readValue(null);
    hexcode = (String)in.readValue(null);
  }
  
  public int describeContents() {
    return 0;
  }

  public static final Parcelable.Creator<ColorSerializer> CREATOR = new Parcelable.Creator<ColorSerializer>() {
    public ColorSerializer createFromParcel(Parcel in) {
      return new ColorSerializer(in);
    }
    public ColorSerializer[] newArray(int size) {
      return new ColorSerializer[size];
    }
  };
}

