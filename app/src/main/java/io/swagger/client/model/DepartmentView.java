package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.DepartmentSerializer;
import java.util.ArrayList;
import java.util.List;
import android.os.Parcelable;
import android.os.Parcel;

/**
 * DepartmentView
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-08-09T16:18:16.327Z")
public class DepartmentView implements Parcelable {
  @SerializedName("results")
  private List<DepartmentSerializer> results = new ArrayList<DepartmentSerializer>();

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

  public DepartmentView results(List<DepartmentSerializer> results) {
    this.results = results;
    return this;
  }

  public DepartmentView addResultsItem(DepartmentSerializer resultsItem) {
    this.results.add(resultsItem);
    return this;
  }

   /**
   * Get results
   * @return results
  **/
  @ApiModelProperty(value = "")
  public List<DepartmentSerializer> getResults() {
    return results;
  }

  public void setResults(List<DepartmentSerializer> results) {
    this.results = results;
  }

  public DepartmentView console(String console) {
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

  public DepartmentView alert(String alert) {
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

  public DepartmentView count(Integer count) {
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

  public DepartmentView next(String next) {
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

  public DepartmentView previous(String previous) {
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
    DepartmentView departmentView = (DepartmentView) o;
    return Objects.equals(this.results, departmentView.results) &&
        Objects.equals(this.console, departmentView.console) &&
        Objects.equals(this.alert, departmentView.alert) &&
        Objects.equals(this.count, departmentView.count) &&
        Objects.equals(this.next, departmentView.next) &&
        Objects.equals(this.previous, departmentView.previous);
  }

  @Override
  public int hashCode() {
    return Objects.hash(results, console, alert, count, next, previous);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DepartmentView {\n");
    
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

  public DepartmentView() {
    super();
  }

  DepartmentView(Parcel in) {
    
    results = (List<DepartmentSerializer>)in.readValue(DepartmentSerializer.class.getClassLoader());
    console = (String)in.readValue(null);
    alert = (String)in.readValue(null);
    count = (Integer)in.readValue(null);
    next = (String)in.readValue(null);
    previous = (String)in.readValue(null);
  }
  
  public int describeContents() {
    return 0;
  }

  public static final Parcelable.Creator<DepartmentView> CREATOR = new Parcelable.Creator<DepartmentView>() {
    public DepartmentView createFromParcel(Parcel in) {
      return new DepartmentView(in);
    }
    public DepartmentView[] newArray(int size) {
      return new DepartmentView[size];
    }
  };
}

