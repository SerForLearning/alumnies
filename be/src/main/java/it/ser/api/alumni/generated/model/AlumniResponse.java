package it.ser.api.alumni.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import java.io.Serializable;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.media.Schema;


import jakarta.annotation.Generated;

/**
 * AlumniResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.11.0")
public class AlumniResponse implements Serializable {

  private static final long serialVersionUID = 1L;

  private @Nullable Long id;

  private @Nullable String name;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime createdAt;

  public AlumniResponse id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of alumna/alumnus
   * @return id
   */
  
  @Schema(name = "id", example = "1", description = "Unique identifier of alumna/alumnus", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public AlumniResponse name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of alumna/alumnus
   * @return name
   */
  
  @Schema(name = "name", example = "Mario Rossi", description = "Name of alumna/alumnus", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AlumniResponse createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Timestamp of record creation
   * @return createdAt
   */
  @Valid 
  @Schema(name = "createdAt", example = "2024-02-02T10:30Z", description = "Timestamp of record creation", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("createdAt")
  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
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
        Objects.equals(this.createdAt, alumniResponse.createdAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, createdAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AlumniResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

