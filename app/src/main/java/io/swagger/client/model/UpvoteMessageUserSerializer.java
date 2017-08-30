package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import android.os.Parcelable;
import android.os.Parcel;

/**
 * UpvoteMessageUserSerializer
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-08-09T16:18:16.327Z")
public class UpvoteMessageUserSerializer implements Parcelable {
  @SerializedName("message")
  private Integer message = null;

  @SerializedName("user")
  private Integer user = null;

  public UpvoteMessageUserSerializer message(Integer message) {
    this.message = message;
    return this;
  }

   /**
   * 
   * @return message
  **/
  @ApiModelProperty(value = "")
  public Integer getMessage() {
    return message;
  }

  public void setMessage(Integer message) {
    this.message = message;
  }

  public UpvoteMessageUserSerializer user(Integer user) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpvoteMessageUserSerializer upvoteMessageUserSerializer = (UpvoteMessageUserSerializer) o;
    return Objects.equals(this.message, upvoteMessageUserSerializer.message) &&
        Objects.equals(this.user, upvoteMessageUserSerializer.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, user);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpvoteMessageUserSerializer {\n");
    
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
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
     
    out.writeValue(message);

    out.writeValue(user);
  }

  public UpvoteMessageUserSerializer() {
    super();
  }

  UpvoteMessageUserSerializer(Parcel in) {
    
    message = (Integer)in.readValue(null);
    user = (Integer)in.readValue(null);
  }
  
  public int describeContents() {
    return 0;
  }

  public static final Parcelable.Creator<UpvoteMessageUserSerializer> CREATOR = new Parcelable.Creator<UpvoteMessageUserSerializer>() {
    public UpvoteMessageUserSerializer createFromParcel(Parcel in) {
      return new UpvoteMessageUserSerializer(in);
    }
    public UpvoteMessageUserSerializer[] newArray(int size) {
      return new UpvoteMessageUserSerializer[size];
    }
  };
}

