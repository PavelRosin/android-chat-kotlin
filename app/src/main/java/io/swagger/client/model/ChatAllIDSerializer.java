package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import android.os.Parcelable;
import android.os.Parcel;

/**
 * ChatAllIDSerializer
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-08-09T16:18:16.327Z")
public class ChatAllIDSerializer implements Parcelable {
  @SerializedName("id")
  private Integer id = null;

  public ChatAllIDSerializer id(Integer id) {
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
    ChatAllIDSerializer chatAllIDSerializer = (ChatAllIDSerializer) o;
    return Objects.equals(this.id, chatAllIDSerializer.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChatAllIDSerializer {\n");
    
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
     
    out.writeValue(id);
  }

  public ChatAllIDSerializer() {
    super();
  }

  ChatAllIDSerializer(Parcel in) {
    
    id = (Integer)in.readValue(null);
  }
  
  public int describeContents() {
    return 0;
  }

  public static final Parcelable.Creator<ChatAllIDSerializer> CREATOR = new Parcelable.Creator<ChatAllIDSerializer>() {
    public ChatAllIDSerializer createFromParcel(Parcel in) {
      return new ChatAllIDSerializer(in);
    }
    public ChatAllIDSerializer[] newArray(int size) {
      return new ChatAllIDSerializer[size];
    }
  };
}

