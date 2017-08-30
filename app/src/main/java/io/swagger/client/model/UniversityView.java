package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.UniversitySerializer;
import java.util.ArrayList;
import java.util.List;
import android.os.Parcelable;
import android.os.Parcel;

/**
 * UniversityView
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-08-09T16:18:16.327Z")
public class UniversityView implements Parcelable {
  @SerializedName("results")
  private List<UniversitySerializer> results = new ArrayList<UniversitySerializer>();

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

  public UniversityView results(List<UniversitySerializer> results) {
    this.results = results;
    return this;
  }

  public UniversityView addResultsItem(UniversitySerializer resultsItem) {
    this.results.add(resultsItem);
    return this;
  }

   /**
   * Get results
   * @return results
  **/
  @ApiModelProperty(value = "")
  public List<UniversitySerializer> getResults() {
    return results;
  }

  public void setResults(List<UniversitySerializer> results) {
    this.results = results;
  }

  public UniversityView console(String console) {
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

  public UniversityView alert(String alert) {
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

  public UniversityView count(Integer count) {
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

  public UniversityView next(String next) {
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

  public UniversityView previous(String previous) {
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
    UniversityView universityView = (UniversityView) o;
    return Objects.equals(this.results, universityView.results) &&
        Objects.equals(this.console, universityView.console) &&
        Objects.equals(this.alert, universityView.alert) &&
        Objects.equals(this.count, universityView.count) &&
        Objects.equals(this.next, universityView.next) &&
        Objects.equals(this.previous, universityView.previous);
  }

  @Override
  public int hashCode() {
    return Objects.hash(results, console, alert, count, next, previous);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UniversityView {\n");
    
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

  public UniversityView() {
    super();
  }

  UniversityView(Parcel in) {
    
    results = (List<UniversitySerializer>)in.readValue(UniversitySerializer.class.getClassLoader());
    console = (String)in.readValue(null);
    alert = (String)in.readValue(null);
    count = (Integer)in.readValue(null);
    next = (String)in.readValue(null);
    previous = (String)in.readValue(null);
  }
  
  public int describeContents() {
    return 0;
  }

  public static final Parcelable.Creator<UniversityView> CREATOR = new Parcelable.Creator<UniversityView>() {
    public UniversityView createFromParcel(Parcel in) {
      return new UniversityView(in);
    }
    public UniversityView[] newArray(int size) {
      return new UniversityView[size];
    }
  };
}

