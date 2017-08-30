package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.UserSerializer;
import android.os.Parcelable;
import android.os.Parcel;

/**
 * LoginOutput
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-08-09T16:18:16.327Z")
public class LoginOutput implements Parcelable {
  @SerializedName("user")
  private UserSerializer user = null;

  @SerializedName("token")
  private String token = null;

  public LoginOutput user(UserSerializer user) {
    this.user = user;
    return this;
  }

   /**
   * Get user
   * @return user
  **/
  @ApiModelProperty(value = "")
  public UserSerializer getUser() {
    return user;
  }

  public void setUser(UserSerializer user) {
    this.user = user;
  }

  public LoginOutput token(String token) {
    this.token = token;
    return this;
  }

   /**
   * 
   * @return token
  **/
  @ApiModelProperty(value = "")
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LoginOutput loginOutput = (LoginOutput) o;
    return Objects.equals(this.user, loginOutput.user) &&
        Objects.equals(this.token, loginOutput.token);
  }

  @Override
  public int hashCode() {
    return Objects.hash(user, token);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LoginOutput {\n");
    
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
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

    out.writeValue(token);
  }

  public LoginOutput() {
    super();
  }

  LoginOutput(Parcel in) {
    
    user = (UserSerializer)in.readValue(null);
    token = (String)in.readValue(null);
  }
  
  public int describeContents() {
    return 0;
  }

  public static final Parcelable.Creator<LoginOutput> CREATOR = new Parcelable.Creator<LoginOutput>() {
    public LoginOutput createFromParcel(Parcel in) {
      return new LoginOutput(in);
    }
    public LoginOutput[] newArray(int size) {
      return new LoginOutput[size];
    }
  };
}

