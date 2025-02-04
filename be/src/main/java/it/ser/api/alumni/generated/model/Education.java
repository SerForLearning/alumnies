package it.ser.api.alumni.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Education
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.11.0")
public class Education implements Serializable {

  private static final long serialVersionUID = 1L;

  private Optional<Degree> master = Optional.empty();

  private Optional<Degree> phd = Optional.empty();

  public Education master(Degree master) {
    this.master = Optional.of(master);
    return this;
  }

  /**
   * Get master
   * @return master
   */
  @Valid 
  @Schema(name = "master", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("master")
  public Optional<Degree> getMaster() {
    return master;
  }

  public void setMaster(Optional<Degree> master) {
    this.master = master;
  }

  public Education phd(Degree phd) {
    this.phd = Optional.of(phd);
    return this;
  }

  /**
   * Get phd
   * @return phd
   */
  @Valid 
  @Schema(name = "phd", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("phd")
  public Optional<Degree> getPhd() {
    return phd;
  }

  public void setPhd(Optional<Degree> phd) {
    this.phd = phd;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Education education = (Education) o;
    return Objects.equals(this.master, education.master) &&
        Objects.equals(this.phd, education.phd);
  }

  @Override
  public int hashCode() {
    return Objects.hash(master, phd);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Education {\n");
    sb.append("    master: ").append(toIndentedString(master)).append("\n");
    sb.append("    phd: ").append(toIndentedString(phd)).append("\n");
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

