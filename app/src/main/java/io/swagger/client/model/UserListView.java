package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.UserSerializer;
import java.util.ArrayList;
import java.util.List;
import android.os.Parcelable;
import android.os.Parcel;

/**
 * UserListView
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-08-09T16:18:16.327Z")
public class UserListView implements Parcelable {
  @SerializedName("results")
  private List<UserSerializer> results = new ArrayList<UserSerializer>();

  @SerializedName("console")
  private String console = null;

  @SerializedName("alert")
  private String alert = null;

  @SerializedName("count")
  private Integer count = null;

  @SerializedName("next")
  private String next = null;

  @SerializedName("previous")
  private String previous = null;

  public UserListView results(List<UserSerializer> results) {
    this.results = results;
    return this;
  }

  public UserListView addResultsItem(UserSerializer resultsItem) {
    this.results.add(resultsItem);
    return this;
  }

   /**
   * Get results
   * @return results
  **/
  @ApiModelProperty(value = "")
  public List<UserSerializer> getResults() {
    return results;
  }

  public void setResults(List<UserSerializer> results) {
    this.results = results;
  }

  public UserListView console(String console) {
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

  public UserListView alert(String alert) {
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

  public UserListView count(Integer count) {
    this.count = count;
    return this;
  }

   /**
   * Get count
   * @return count
  **/
  @ApiModelProperty(value = "")
  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public UserListView next(String next) {
    this.next = next;
    return this;
  }

   /**
   * Get next
   * @return next
  **/
  @ApiModelProperty(value = "")
  public String getNext() {
    return next;
  }

  public void setNext(String next) {
    this.next = next;
  }

  public UserListView previous(String previous) {
    this.previous = previous;
    return this;
  }

   /**
   * Get previous
   * @return previous
  **/
  @ApiModelProperty(value = "")
  public String getPrevious() {
    return previous;
  }

  public void setPrevious(String previous) {
    this.previous = previous;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserListView userListView = (UserListView) o;
    return Objects.equals(this.results, userListView.results) &&
        Objects.equals(this.console, userListView.console) &&
        Objects.equals(this.alert, userListView.alert) &&
        Objects.equals(this.count, userListView.count) &&
        Objects.equals(this.next, userListView.next) &&
        Objects.equals(this.previous, userListView.previous);
  }

  @Override
  public int hashCode() {
    return Objects.hash(results, console, alert, count, next, previous);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserListView {\n");
    
    sb.append("    results: ").append(toIndentedString(results)).append("\n");
    sb.append("    console: ").append(toIndentedString(console)).append("\n");
    sb.append("    alert: ").append(toIndentedString(alert)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    next: ").append(toIndentedString(next)).append("\n");
    sb.append("    previous: ").append(toIndentedString(previous)).append("\n");
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

    out.writeValue(count);

    out.writeValue(next);

    out.writeValue(previous);
  }

  public UserListView() {
    super();
  }

  UserListView(Parcel in) {
    
    results = (List<UserSerializer>)in.readValue(UserSerializer.class.getClassLoader());
    console = (String)in.readValue(null);
    alert = (String)in.readValue(null);
    count = (Integer)in.readValue(null);
    next = (String)in.readValue(null);
    previous = (String)in.readValue(null);
  }
  
  public int describeContents() {
    return 0;
  }

  public static final Parcelable.Creator<UserListView> CREATOR = new Parcelable.Creator<UserListView>() {
    public UserListView createFromParcel(Parcel in) {
      return new UserListView(in);
    }
    public UserListView[] newArray(int size) {
      return new UserListView[size];
    }
  };
}

