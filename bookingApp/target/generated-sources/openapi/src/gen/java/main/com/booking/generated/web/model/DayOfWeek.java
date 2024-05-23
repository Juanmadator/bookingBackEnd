package com.booking.generated.web.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * DayOfWeek
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-19T11:24:03.558366200+02:00[Europe/Madrid]", comments = "Generator version: 7.4.0")
public class DayOfWeek {

  private String day;

  private Boolean isClosed;

  private String openingTime;

  private String closingTime;

  public DayOfWeek day(String day) {
    this.day = day;
    return this;
  }

  /**
   * Get day
   * @return day
  */
  
  @Schema(name = "day", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("day")
  public String getDay() {
    return day;
  }

  public void setDay(String day) {
    this.day = day;
  }

  public DayOfWeek isClosed(Boolean isClosed) {
    this.isClosed = isClosed;
    return this;
  }

  /**
   * Get isClosed
   * @return isClosed
  */
  
  @Schema(name = "isClosed", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("isClosed")
  public Boolean getIsClosed() {
    return isClosed;
  }

  public void setIsClosed(Boolean isClosed) {
    this.isClosed = isClosed;
  }

  public DayOfWeek openingTime(String openingTime) {
    this.openingTime = openingTime;
    return this;
  }

  /**
   * Get openingTime
   * @return openingTime
  */
  
  @Schema(name = "openingTime", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("openingTime")
  public String getOpeningTime() {
    return openingTime;
  }

  public void setOpeningTime(String openingTime) {
    this.openingTime = openingTime;
  }

  public DayOfWeek closingTime(String closingTime) {
    this.closingTime = closingTime;
    return this;
  }

  /**
   * Get closingTime
   * @return closingTime
  */
  
  @Schema(name = "closingTime", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("closingTime")
  public String getClosingTime() {
    return closingTime;
  }

  public void setClosingTime(String closingTime) {
    this.closingTime = closingTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DayOfWeek dayOfWeek = (DayOfWeek) o;
    return Objects.equals(this.day, dayOfWeek.day) &&
        Objects.equals(this.isClosed, dayOfWeek.isClosed) &&
        Objects.equals(this.openingTime, dayOfWeek.openingTime) &&
        Objects.equals(this.closingTime, dayOfWeek.closingTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(day, isClosed, openingTime, closingTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DayOfWeek {\n");
    sb.append("    day: ").append(toIndentedString(day)).append("\n");
    sb.append("    isClosed: ").append(toIndentedString(isClosed)).append("\n");
    sb.append("    openingTime: ").append(toIndentedString(openingTime)).append("\n");
    sb.append("    closingTime: ").append(toIndentedString(closingTime)).append("\n");
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

