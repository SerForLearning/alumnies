package it.ser.api.alumni.generated.model;


import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import jakarta.annotation.Generated;

/**
 * Address
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.11.0")
public class Address implements Serializable {

  private static final long serialVersionUID = 1L;

  private String street;

  private String number;

  private String country;

  public Address() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Address(String street, String number, String country) {
    this.street = street;
    this.number = number;
    this.country = country;
  }

  public Address street(String street) {
    this.street = street;
    return this;
  }

  /**
   * Street name
   * @return street
   */
  @NotNull 
  @Schema(name = "street", example = "streetname", description = "Street name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("street")
  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public Address number(String number) {
    this.number = number;
    return this;
  }

  /**
   * Street number
   * @return number
   */
  @NotNull 
  @Schema(name = "number", example = "22", description = "Street number", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("number")
  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public Address country(String country) {
    this.country = country;
    return this;
  }

  /**
   * Country name
   * @return country
   */
  @NotNull 
  @Schema(name = "country", example = "country", description = "Country name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("country")
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Address address = (Address) o;
    return Objects.equals(this.street, address.street) &&
        Objects.equals(this.number, address.number) &&
        Objects.equals(this.country, address.country);
  }

  @Override
  public int hashCode() {
    return Objects.hash(street, number, country);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Address {\n");
    sb.append("    street: ").append(toIndentedString(street)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
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

