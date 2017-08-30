package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import android.os.Parcelable;
import android.os.Parcel;

/**
 * PasswordReset
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-08-09T16:18:16.327Z")
public class PasswordReset implements Parcelable {
  @SerializedName("password")
  private String password = null;

  @SerializedName("key")
  private String key = null;

  public PasswordReset password(String password) {
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

  public PasswordReset key(String key) {
    this.key = key;
    return this;
  }

   /**
   * 
   * @return key
  **/
  @ApiModelProperty(value = "")
  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PasswordReset passwordReset = (PasswordReset) o;
    return Objects.equals(this.password, passwordReset.password) &&
        Objects.equals(this.key, passwordReset.key);
  }

  @Override
  public int hashCode() {
    return Objects.hash(password, key);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PasswordReset {\n");
    
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
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
     
    out.writeValue(password);

    out.writeValue(key);
  }

  public PasswordReset() {
    super();
  }

  PasswordReset(Parcel in) {
    
    password = (String)in.readValue(null);
    key = (String)in.readValue(null);
  }
  
  public int describeContents() {
    return 0;
  }

  public static final Parcelable.Creator<PasswordReset> CREATOR = new Parcelable.Creator<PasswordReset>() {
    public PasswordReset createFromParcel(Parcel in) {
      return new PasswordReset(in);
    }
    public PasswordReset[] newArray(int size) {
      return new PasswordReset[size];
    }
  };
}

