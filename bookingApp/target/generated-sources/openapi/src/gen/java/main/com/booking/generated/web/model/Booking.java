package com.booking.generated.web.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Booking
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-19T11:24:03.558366200+02:00[Europe/Madrid]", comments = "Generator version: 7.4.0")
public class Booking {

  private String nameBuilding;

  private String nameBookable;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate dayOfMonth;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime startHour;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime finishHour;

  private String duration;

  private BigDecimal reservingSlots;

  public Booking nameBuilding(String nameBuilding) {
    this.nameBuilding = nameBuilding;
    return this;
  }

  /**
   * Get nameBuilding
   * @return nameBuilding
  */
  
  @Schema(name = "nameBuilding", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nameBuilding")
  public String getNameBuilding() {
    return nameBuilding;
  }

  public void setNameBuilding(String nameBuilding) {
    this.nameBuilding = nameBuilding;
  }

  public Booking nameBookable(String nameBookable) {
    this.nameBookable = nameBookable;
    return this;
  }

  /**
   * Get nameBookable
   * @return nameBookable
  */
  
  @Schema(name = "nameBookable", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nameBookable")
  public String getNameBookable() {
    return nameBookable;
  }

  public void setNameBookable(String nameBookable) {
    this.nameBookable = nameBookable;
  }

  public Booking dayOfMonth(LocalDate dayOfMonth) {
    this.dayOfMonth = dayOfMonth;
    return this;
  }

  /**
   * Get dayOfMonth
   * @return dayOfMonth
  */
  @Valid 
  @Schema(name = "dayOfMonth", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dayOfMonth")
  public LocalDate getDayOfMonth() {
    return dayOfMonth;
  }

  public void setDayOfMonth(LocalDate dayOfMonth) {
    this.dayOfMonth = dayOfMonth;
  }

  public Booking startHour(OffsetDateTime startHour) {
    this.startHour = startHour;
    return this;
  }

  /**
   * Get startHour
   * @return startHour
  */
  @Valid 
  @Schema(name = "startHour", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("startHour")
  public OffsetDateTime getStartHour() {
    return startHour;
  }

  public void setStartHour(OffsetDateTime startHour) {
    this.startHour = startHour;
  }

  public Booking finishHour(OffsetDateTime finishHour) {
    this.finishHour = finishHour;
    return this;
  }

  /**
   * Get finishHour
   * @return finishHour
  */
  @Valid 
  @Schema(name = "finishHour", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("finishHour")
  public OffsetDateTime getFinishHour() {
    return finishHour;
  }

  public void setFinishHour(OffsetDateTime finishHour) {
    this.finishHour = finishHour;
  }

  public Booking duration(String duration) {
    this.duration = duration;
    return this;
  }

  /**
   * Get duration
   * @return duration
  */
  
  @Schema(name = "duration", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("duration")
  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public Booking reservingSlots(BigDecimal reservingSlots) {
    this.reservingSlots = reservingSlots;
    return this;
  }

  /**
   * Get reservingSlots
   * @return reservingSlots
  */
  @Valid 
  @Schema(name = "reservingSlots", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("reservingSlots")
  public BigDecimal getReservingSlots() {
    return reservingSlots;
  }

  public void setReservingSlots(BigDecimal reservingSlots) {
    this.reservingSlots = reservingSlots;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Booking booking = (Booking) o;
    return Objects.equals(this.nameBuilding, booking.nameBuilding) &&
        Objects.equals(this.nameBookable, booking.nameBookable) &&
        Objects.equals(this.dayOfMonth, booking.dayOfMonth) &&
        Objects.equals(this.startHour, booking.startHour) &&
        Objects.equals(this.finishHour, booking.finishHour) &&
        Objects.equals(this.duration, booking.duration) &&
        Objects.equals(this.reservingSlots, booking.reservingSlots);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nameBuilding, nameBookable, dayOfMonth, startHour, finishHour, duration, reservingSlots);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Booking {\n");
    sb.append("    nameBuilding: ").append(toIndentedString(nameBuilding)).append("\n");
    sb.append("    nameBookable: ").append(toIndentedString(nameBookable)).append("\n");
    sb.append("    dayOfMonth: ").append(toIndentedString(dayOfMonth)).append("\n");
    sb.append("    startHour: ").append(toIndentedString(startHour)).append("\n");
    sb.append("    finishHour: ").append(toIndentedString(finishHour)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    reservingSlots: ").append(toIndentedString(reservingSlots)).append("\n");
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

