package it.ser.api.alumni.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Error
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.11.0")
public class Error implements Serializable {

  private static final long serialVersionUID = 1L;

  private Optional<String> code = Optional.empty();

  private Optional<String> message = Optional.empty();

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Optional<OffsetDateTime> timestamp = Optional.empty();

  public Error code(String code) {
    this.code = Optional.of(code);
    return this;
  }

  /**
   * Error code
   * @return code
   */
  
  @Schema(name = "code", example = "INVALID_REQUEST", description = "Error code", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("code")
  public Optional<String> getCode() {
    return code;
  }

  public void setCode(Optional<String> code) {
    this.code = code;
  }

  public Error message(String message) {
    this.message = Optional.of(message);
    return this;
  }

  /**
   * Error description
   * @return message
   */
  
  @Schema(name = "message", example = "The name field is required", description = "Error description", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("message")
  public Optional<String> getMessage() {
    return message;
  }

  public void setMessage(Optional<String> message) {
    this.message = message;
  }

  public Error timestamp(OffsetDateTime timestamp) {
    this.timestamp = Optional.of(timestamp);
    return this;
  }

  /**
   * Error timestamp
   * @return timestamp
   */
  @Valid 
  @Schema(name = "timestamp", example = "2024-02-02T10:30Z", description = "Error timestamp", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("timestamp")
  public Optional<OffsetDateTime> getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Optional<OffsetDateTime> timestamp) {
    this.timestamp = timestamp;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return Objects.equals(this.code, error.code) &&
        Objects.equals(this.message, error.message) &&
        Objects.equals(this.timestamp, error.timestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message, timestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
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

