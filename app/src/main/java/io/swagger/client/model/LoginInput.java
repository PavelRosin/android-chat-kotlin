package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import android.os.Parcelable;
import android.os.Parcel;

/**
 * LoginInput
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-08-09T16:18:16.327Z")
public class LoginInput implements Parcelable {
  @SerializedName("username")
  private String username = null;

  @SerializedName("password")
  private String password = null;

  @SerializedName("platform")
  private String platform = null;

  @SerializedName("push_token")
  private String pushToken = null;

  public LoginInput username(String username) {
    this.username = username;
    return this;
  }

   /**
   * 
   * @return username
  **/
  @ApiModelProperty(value = "")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public LoginInput password(String password) {
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

  public LoginInput platform(String platform) {
    this.platform = platform;
    return this;
  }

   /**
   * iOS, android, or web.
   * @return platform
  **/
  @ApiModelProperty(value = "iOS, android, or web.")
  public String getPlatform() {
    return platform;
  }

  public void setPlatform(String platform) {
    this.platform = platform;
  }

  public LoginInput pushToken(String pushToken) {
    this.pushToken = pushToken;
    return this;
  }

   /**
   * 
   * @return pushToken
  **/
  @ApiModelProperty(value = "")
  public String getPushToken() {
    return pushToken;
  }

  public void setPushToken(String pushToken) {
    this.pushToken = pushToken;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LoginInput loginInput = (LoginInput) o;
    return Objects.equals(this.username, loginInput.username) &&
        Objects.equals(this.password, loginInput.password) &&
        Objects.equals(this.platform, loginInput.platform) &&
        Objects.equals(this.pushToken, loginInput.pushToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, password, platform, pushToken);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LoginInput {\n");
    
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    platform: ").append(toIndentedString(platform)).append("\n");
    sb.append("    pushToken: ").append(toIndentedString(pushToken)).append("\n");
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
     
    out.writeValue(username);

    out.writeValue(password);

    out.writeValue(platform);

    out.writeValue(pushToken);
  }

  public LoginInput() {
    super();
  }

  LoginInput(Parcel in) {
    
    username = (String)in.readValue(null);
    password = (String)in.readValue(null);
    platform = (String)in.readValue(null);
    pushToken = (String)in.readValue(null);
  }
  
  public int describeContents() {
    return 0;
  }

  public static final Parcelable.Creator<LoginInput> CREATOR = new Parcelable.Creator<LoginInput>() {
    public LoginInput createFromParcel(Parcel in) {
      return new LoginInput(in);
    }
    public LoginInput[] newArray(int size) {
      return new LoginInput[size];
    }
  };
}

