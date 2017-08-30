package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import android.os.Parcelable;
import android.os.Parcel;

/**
 * RequestPassword
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-08-09T16:18:16.327Z")
public class RequestPassword implements Parcelable {
  @SerializedName("email")
  private String email = null;

  public RequestPassword email(String email) {
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
    RequestPassword requestPassword = (RequestPassword) o;
    return Objects.equals(this.email, requestPassword.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequestPassword {\n");
    
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
     
    out.writeValue(email);
  }

  public RequestPassword() {
    super();
  }

  RequestPassword(Parcel in) {
    
    email = (String)in.readValue(null);
  }
  
  public int describeContents() {
    return 0;
  }

  public static final Parcelable.Creator<RequestPassword> CREATOR = new Parcelable.Creator<RequestPassword>() {
    public RequestPassword createFromParcel(Parcel in) {
      return new RequestPassword(in);
    }
    public RequestPassword[] newArray(int size) {
      return new RequestPassword[size];
    }
  };
}

