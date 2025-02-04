package it.ser.api.alumni.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import jakarta.annotation.Generated;

/**
 * AlumniRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.11.0")
public class AlumniRequest implements Serializable {

  private static final long serialVersionUID = 1L;

  private String name;

  @Valid
  private List<@Valid Address> addresses = new ArrayList<>();

  private Education education;

  public AlumniRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public AlumniRequest(String name, List<@Valid Address> addresses, Education education) {
    this.name = name;
    this.addresses = addresses;
    this.education = education;
  }

  public AlumniRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name
   * @return name
   */
  @NotNull @Size(min = 1, max = 100) 
  @Schema(name = "name", example = "Mario Rossi", description = "Name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AlumniRequest addresses(List<@Valid Address> addresses) {
    this.addresses = addresses;
    return this;
  }

  public AlumniRequest addAddressesItem(Address addressesItem) {
    if (this.addresses == null) {
      this.addresses = new ArrayList<>();
    }
    this.addresses.add(addressesItem);
    return this;
  }

  /**
   * List of addresses
   * @return addresses
   */
  @NotNull @Valid @Size(min = 1) 
  @Schema(name = "addresses", description = "List of addresses", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("addresses")
  public List<@Valid Address> getAddresses() {
    return addresses;
  }

  public void setAddresses(List<@Valid Address> addresses) {
    this.addresses = addresses;
  }

  public AlumniRequest education(Education education) {
    this.education = education;
    return this;
  }

  /**
   * Get education
   * @return education
   */
  @NotNull @Valid 
  @Schema(name = "education", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("education")
  public Education getEducation() {
    return education;
  }

  public void setEducation(Education education) {
    this.education = education;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AlumniRequest alumniRequest = (AlumniRequest) o;
    return Objects.equals(this.name, alumniRequest.name) &&
        Objects.equals(this.addresses, alumniRequest.addresses) &&
        Objects.equals(this.education, alumniRequest.education);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, addresses, education);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AlumniRequest {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    addresses: ").append(toIndentedString(addresses)).append("\n");
    sb.append("    education: ").append(toIndentedString(education)).append("\n");
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

