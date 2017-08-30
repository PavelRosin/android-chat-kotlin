package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.UserPreferenceSerializer;
import android.os.Parcelable;
import android.os.Parcel;

/**
 * UserPreferencesRetreiveView
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-08-09T16:18:16.327Z")
public class UserPreferencesRetreiveView implements Parcelable {
  @SerializedName("results")
  private UserPreferenceSerializer results = null;

  @SerializedName("console")
  private String console = null;

  @SerializedName("alert")
  private String alert = null;

  public UserPreferencesRetreiveView results(UserPreferenceSerializer results) {
    this.results = results;
    return this;
  }

   /**
   * Get results
   * @return results
  **/
  @ApiModelProperty(value = "")
  public UserPreferenceSerializer getResults() {
    return results;
  }

  public void setResults(UserPreferenceSerializer results) {
    this.results = results;
  }

  public UserPreferencesRetreiveView console(String console) {
    this.console = console;
    return this;
  }

   /**
   * This is an error for the dev
   * @return console
  **/
  @ApiModelProperty(value = "This is an error for the dev")
  public String getConsole() {
    return console;
  }

  public void setConsole(String console) {
    this.console = console;
  }

  public UserPreferencesRetreiveView alert(String alert) {
    this.alert = alert;
    return this;
  }

   /**
   * Show this error to the user
   * @return alert
  **/
  @ApiModelProperty(value = "Show this error to the user")
  public String getAlert() {
    return alert;
  }

  public void setAlert(String alert) {
    this.alert = alert;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserPreferencesRetreiveView userPreferencesRetreiveView = (UserPreferencesRetreiveView) o;
    return Objects.equals(this.results, userPreferencesRetreiveView.results) &&
        Objects.equals(this.console, userPreferencesRetreiveView.console) &&
        Objects.equals(this.alert, userPreferencesRetreiveView.alert);
  }

  @Override
  public int hashCode() {
    return Objects.hash(results, console, alert);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserPreferencesRetreiveView {\n");
    
    sb.append("    results: ").append(toIndentedString(results)).append("\n");
    sb.append("    console: ").append(toIndentedString(console)).append("\n");
    sb.append("    alert: ").append(toIndentedString(alert)).append("\n");
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
     
    out.writeValue(results);

    out.writeValue(console);

    out.writeValue(alert);
  }

  public UserPreferencesRetreiveView() {
    super();
  }

  UserPreferencesRetreiveView(Parcel in) {
    
    results = (UserPreferenceSerializer)in.readValue(null);
    console = (String)in.readValue(null);
    alert = (String)in.readValue(null);
  }
  
  public int describeContents() {
    return 0;
  }

  public static final Parcelable.Creator<UserPreferencesRetreiveView> CREATOR = new Parcelable.Creator<UserPreferencesRetreiveView>() {
    public UserPreferencesRetreiveView createFromParcel(Parcel in) {
      return new UserPreferencesRetreiveView(in);
    }
    public UserPreferencesRetreiveView[] newArray(int size) {
      return new UserPreferencesRetreiveView[size];
    }
  };
}

