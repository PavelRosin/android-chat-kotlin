package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import android.os.Parcelable;
import android.os.Parcel;

/**
 * UserPreferenceSerializer
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-08-09T16:18:16.327Z")
public class UserPreferenceSerializer implements Parcelable {
  @SerializedName("should_send_email")
  private Boolean shouldSendEmail = null;

  @SerializedName("should_send_desktop")
  private Boolean shouldSendDesktop = null;

  @SerializedName("id")
  private Integer id = null;

  public UserPreferenceSerializer shouldSendEmail(Boolean shouldSendEmail) {
    this.shouldSendEmail = shouldSendEmail;
    return this;
  }

   /**
   * 
   * @return shouldSendEmail
  **/
  @ApiModelProperty(value = "")
  public Boolean getShouldSendEmail() {
    return shouldSendEmail;
  }

  public void setShouldSendEmail(Boolean shouldSendEmail) {
    this.shouldSendEmail = shouldSendEmail;
  }

  public UserPreferenceSerializer shouldSendDesktop(Boolean shouldSendDesktop) {
    this.shouldSendDesktop = shouldSendDesktop;
    return this;
  }

   /**
   * 
   * @return shouldSendDesktop
  **/
  @ApiModelProperty(value = "")
  public Boolean getShouldSendDesktop() {
    return shouldSendDesktop;
  }

  public void setShouldSendDesktop(Boolean shouldSendDesktop) {
    this.shouldSendDesktop = shouldSendDesktop;
  }

  public UserPreferenceSerializer id(Integer id) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserPreferenceSerializer userPreferenceSerializer = (UserPreferenceSerializer) o;
    return Objects.equals(this.shouldSendEmail, userPreferenceSerializer.shouldSendEmail) &&
        Objects.equals(this.shouldSendDesktop, userPreferenceSerializer.shouldSendDesktop) &&
        Objects.equals(this.id, userPreferenceSerializer.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(shouldSendEmail, shouldSendDesktop, id);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserPreferenceSerializer {\n");
    
    sb.append("    shouldSendEmail: ").append(toIndentedString(shouldSendEmail)).append("\n");
    sb.append("    shouldSendDesktop: ").append(toIndentedString(shouldSendDesktop)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
     
    out.writeValue(shouldSendEmail);

    out.writeValue(shouldSendDesktop);

    out.writeValue(id);
  }

  public UserPreferenceSerializer() {
    super();
  }

  UserPreferenceSerializer(Parcel in) {
    
    shouldSendEmail = (Boolean)in.readValue(null);
    shouldSendDesktop = (Boolean)in.readValue(null);
    id = (Integer)in.readValue(null);
  }
  
  public int describeContents() {
    return 0;
  }

  public static final Parcelable.Creator<UserPreferenceSerializer> CREATOR = new Parcelable.Creator<UserPreferenceSerializer>() {
    public UserPreferenceSerializer createFromParcel(Parcel in) {
      return new UserPreferenceSerializer(in);
    }
    public UserPreferenceSerializer[] newArray(int size) {
      return new UserPreferenceSerializer[size];
    }
  };
}

