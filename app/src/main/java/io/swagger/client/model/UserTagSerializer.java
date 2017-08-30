package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import android.os.Parcelable;
import android.os.Parcel;

/**
 * UserTagSerializer
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-08-09T16:18:16.327Z")
public class UserTagSerializer implements Parcelable {
  @SerializedName("user")
  private Integer user = null;

  @SerializedName("tag_str")
  private String tagStr = null;

  public UserTagSerializer user(Integer user) {
    this.user = user;
    return this;
  }

   /**
   * 
   * @return user
  **/
  @ApiModelProperty(value = "")
  public Integer getUser() {
    return user;
  }

  public void setUser(Integer user) {
    this.user = user;
  }

  public UserTagSerializer tagStr(String tagStr) {
    this.tagStr = tagStr;
    return this;
  }

   /**
   * 
   * @return tagStr
  **/
  @ApiModelProperty(value = "")
  public String getTagStr() {
    return tagStr;
  }

  public void setTagStr(String tagStr) {
    this.tagStr = tagStr;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserTagSerializer userTagSerializer = (UserTagSerializer) o;
    return Objects.equals(this.user, userTagSerializer.user) &&
        Objects.equals(this.tagStr, userTagSerializer.tagStr);
  }

  @Override
  public int hashCode() {
    return Objects.hash(user, tagStr);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserTagSerializer {\n");
    
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    tagStr: ").append(toIndentedString(tagStr)).append("\n");
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
     
    out.writeValue(user);

    out.writeValue(tagStr);
  }

  public UserTagSerializer() {
    super();
  }

  UserTagSerializer(Parcel in) {
    
    user = (Integer)in.readValue(null);
    tagStr = (String)in.readValue(null);
  }
  
  public int describeContents() {
    return 0;
  }

  public static final Parcelable.Creator<UserTagSerializer> CREATOR = new Parcelable.Creator<UserTagSerializer>() {
    public UserTagSerializer createFromParcel(Parcel in) {
      return new UserTagSerializer(in);
    }
    public UserTagSerializer[] newArray(int size) {
      return new UserTagSerializer[size];
    }
  };
}

