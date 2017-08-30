package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import android.os.Parcelable;
import android.os.Parcel;

/**
 * ChatUserPromotionSerializer
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-08-09T16:18:16.327Z")
public class ChatUserPromotionSerializer implements Parcelable {
  @SerializedName("is_admin")
  private Boolean isAdmin = null;

  @SerializedName("is_ta")
  private Boolean isTa = null;

  @SerializedName("is_muted")
  private Boolean isMuted = null;

  public ChatUserPromotionSerializer isAdmin(Boolean isAdmin) {
    this.isAdmin = isAdmin;
    return this;
  }

   /**
   * 
   * @return isAdmin
  **/
  @ApiModelProperty(value = "")
  public Boolean getIsAdmin() {
    return isAdmin;
  }

  public void setIsAdmin(Boolean isAdmin) {
    this.isAdmin = isAdmin;
  }

  public ChatUserPromotionSerializer isTa(Boolean isTa) {
    this.isTa = isTa;
    return this;
  }

   /**
   * 
   * @return isTa
  **/
  @ApiModelProperty(value = "")
  public Boolean getIsTa() {
    return isTa;
  }

  public void setIsTa(Boolean isTa) {
    this.isTa = isTa;
  }

  public ChatUserPromotionSerializer isMuted(Boolean isMuted) {
    this.isMuted = isMuted;
    return this;
  }

   /**
   * 
   * @return isMuted
  **/
  @ApiModelProperty(value = "")
  public Boolean getIsMuted() {
    return isMuted;
  }

  public void setIsMuted(Boolean isMuted) {
    this.isMuted = isMuted;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChatUserPromotionSerializer chatUserPromotionSerializer = (ChatUserPromotionSerializer) o;
    return Objects.equals(this.isAdmin, chatUserPromotionSerializer.isAdmin) &&
        Objects.equals(this.isTa, chatUserPromotionSerializer.isTa) &&
        Objects.equals(this.isMuted, chatUserPromotionSerializer.isMuted);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isAdmin, isTa, isMuted);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChatUserPromotionSerializer {\n");
    
    sb.append("    isAdmin: ").append(toIndentedString(isAdmin)).append("\n");
    sb.append("    isTa: ").append(toIndentedString(isTa)).append("\n");
    sb.append("    isMuted: ").append(toIndentedString(isMuted)).append("\n");
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
     
    out.writeValue(isAdmin);

    out.writeValue(isTa);

    out.writeValue(isMuted);
  }

  public ChatUserPromotionSerializer() {
    super();
  }

  ChatUserPromotionSerializer(Parcel in) {
    
    isAdmin = (Boolean)in.readValue(null);
    isTa = (Boolean)in.readValue(null);
    isMuted = (Boolean)in.readValue(null);
  }
  
  public int describeContents() {
    return 0;
  }

  public static final Parcelable.Creator<ChatUserPromotionSerializer> CREATOR = new Parcelable.Creator<ChatUserPromotionSerializer>() {
    public ChatUserPromotionSerializer createFromParcel(Parcel in) {
      return new ChatUserPromotionSerializer(in);
    }
    public ChatUserPromotionSerializer[] newArray(int size) {
      return new ChatUserPromotionSerializer[size];
    }
  };
}

