package it.ser.api.alumni.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import jakarta.annotation.Generated;

/**
 * Degree
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.11.0")
public class Degree implements Serializable {

  private static final long serialVersionUID = 1L;

  private String university;

  private Integer year;

  public Degree() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Degree(String university, Integer year) {
    this.university = university;
    this.year = year;
  }

  public Degree university(String university) {
    this.university = university;
    return this;
  }

  /**
   * University name
   * @return university
   */
  @NotNull 
  @Schema(name = "university", example = "Politecnico Milano", description = "University name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("university")
  public String getUniversity() {
    return university;
  }

  public void setUniversity(String university) {
    this.university = university;
  }

  public Degree year(Integer year) {
    this.year = year;
    return this;
  }

  /**
   * Year of completion
   * @return year
   */
  @NotNull 
  @Schema(name = "year", example = "2004", description = "Year of completion", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("year")
  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Degree degree = (Degree) o;
    return Objects.equals(this.university, degree.university) &&
        Objects.equals(this.year, degree.year);
  }

  @Override
  public int hashCode() {
    return Objects.hash(university, year);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Degree {\n");
    sb.append("    university: ").append(toIndentedString(university)).append("\n");
    sb.append("    year: ").append(toIndentedString(year)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

