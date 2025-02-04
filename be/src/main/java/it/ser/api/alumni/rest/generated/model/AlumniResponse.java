package it.ser.api.alumni.rest.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * AlumniResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.11.0")
public class AlumniResponse implements Serializable {

  private static final long serialVersionUID = 1L;

  private Optional<Long> id = Optional.empty();

  private Optional<String> name = Optional.empty();

  @Valid
  private List<@Valid Address> addresses = new ArrayList<>();

  private Optional<Education> education = Optional.empty();

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Optional<OffsetDateTime> createdAt = Optional.empty();

  public AlumniResponse id(Long id) {
    this.id = Optional.of(id);
    return this;
  }

  /**
   * Unique identifier of alumna/alumnus
   * @return id
   */
  
  @Schema(name = "id", example = "1", description = "Unique identifier of alumna/alumnus", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Optional<Long> getId() {
    return id;
  }

  public void setId(Optional<Long> id) {
    this.id = id;
  }

  public AlumniResponse name(String name) {
    this.name = Optional.of(name);
    return this;
  }

  /**
   * Name of alumna/alumnus
   * @return name
   */
  
  @Schema(name = "name", example = "Mario Rossi", description = "Name of alumna/alumnus", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public Optional<String> getName() {
    return name;
  }

  public void setName(Optional<String> name) {
    this.name = name;
  }

  public AlumniResponse addresses(List<@Valid Address> addresses) {
    this.addresses = addresses;
    return this;
  }

  public AlumniResponse addAddressesItem(Address addressesItem) {
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
  @Valid 
  @Schema(name = "addresses", description = "List of addresses", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("addresses")
  public List<@Valid Address> getAddresses() {
    return addresses;
  }

  public void setAddresses(List<@Valid Address> addresses) {
    this.addresses = addresses;
  }

  public AlumniResponse education(Education education) {
    this.education = Optional.of(education);
    return this;
  }

  /**
   * Get education
   * @return education
   */
  @Valid 
  @Schema(name = "education", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("education")
  public Optional<Education> getEducation() {
    return education;
  }

  public void setEducation(Optional<Education> education) {
    this.education = education;
  }

  public AlumniResponse createdAt(OffsetDateTime createdAt) {
    this.createdAt = Optional.of(createdAt);
    return this;
  }

  /**
   * Timestamp of record creation
   * @return createdAt
   */
  @Valid 
  @Schema(name = "createdAt", example = "2024-02-02T10:30Z", description = "Timestamp of record creation", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("createdAt")
  public Optional<OffsetDateTime> getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Optional<OffsetDateTime> createdAt) {
    this.createdAt = createdAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AlumniResponse alumniResponse = (AlumniResponse) o;
    return Objects.equals(this.id, alumniResponse.id) &&
        Objects.equals(this.name, alumniResponse.name) &&
        Objects.equals(this.addresses, alumniResponse.addresses) &&
        Objects.equals(this.education, alumniResponse.education) &&
        Objects.equals(this.createdAt, alumniResponse.createdAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, addresses, education, createdAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AlumniResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    addresses: ").append(toIndentedString(addresses)).append("\n");
    sb.append("    education: ").append(toIndentedString(education)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
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

