package com.booking.generated.web.model;

import java.net.URI;
import java.util.Objects;
import com.booking.generated.web.model.Bookable;
import com.booking.generated.web.model.DayOfWeek;
import com.booking.generated.web.model.Location;
import com.booking.generated.web.model.PlaceType;
import com.booking.generated.web.model.Service;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Building
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-19T11:24:03.558366200+02:00[Europe/Madrid]", comments = "Generator version: 7.4.0")
public class Building {

  private String name;

  private Location location;

  private PlaceType placeType;

  @Valid
  private List<@Valid Service> services;

  private String description;

  @Valid
  private List<@Valid Bookable> bookables;

  @Valid
  private List<@Valid DayOfWeek> daysOfWeek;

  private String photo;

  public Building() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Building(String name, PlaceType placeType) {
    this.name = name;
    this.placeType = placeType;
  }

  public Building name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @NotNull 
  @Schema(name = "name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Building location(Location location) {
    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
  */
  @Valid 
  @Schema(name = "location", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("location")
  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public Building placeType(PlaceType placeType) {
    this.placeType = placeType;
    return this;
  }

  /**
   * Get placeType
   * @return placeType
  */
  @NotNull @Valid 
  @Schema(name = "placeType", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("placeType")
  public PlaceType getPlaceType() {
    return placeType;
  }

  public void setPlaceType(PlaceType placeType) {
    this.placeType = placeType;
  }

  public Building services(List<@Valid Service> services) {
    this.services = services;
    return this;
  }

  public Building addServicesItem(Service servicesItem) {
    if (this.services == null) {
      this.services = new ArrayList<>();
    }
    this.services.add(servicesItem);
    return this;
  }

  /**
   * Get services
   * @return services
  */
  @Valid 
  @Schema(name = "services", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("services")
  public List<@Valid Service> getServices() {
    return services;
  }

  public void setServices(List<@Valid Service> services) {
    this.services = services;
  }

  public Building description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  */
  
  @Schema(name = "description", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Building bookables(List<@Valid Bookable> bookables) {
    this.bookables = bookables;
    return this;
  }

  public Building addBookablesItem(Bookable bookablesItem) {
    if (this.bookables == null) {
      this.bookables = new ArrayList<>();
    }
    this.bookables.add(bookablesItem);
    return this;
  }

  /**
   * Get bookables
   * @return bookables
  */
  @Valid 
  @Schema(name = "bookables", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("bookables")
  public List<@Valid Bookable> getBookables() {
    return bookables;
  }

  public void setBookables(List<@Valid Bookable> bookables) {
    this.bookables = bookables;
  }

  public Building daysOfWeek(List<@Valid DayOfWeek> daysOfWeek) {
    this.daysOfWeek = daysOfWeek;
    return this;
  }

  public Building addDaysOfWeekItem(DayOfWeek daysOfWeekItem) {
    if (this.daysOfWeek == null) {
      this.daysOfWeek = new ArrayList<>();
    }
    this.daysOfWeek.add(daysOfWeekItem);
    return this;
  }

  /**
   * Get daysOfWeek
   * @return daysOfWeek
  */
  @Valid 
  @Schema(name = "daysOfWeek", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("daysOfWeek")
  public List<@Valid DayOfWeek> getDaysOfWeek() {
    return daysOfWeek;
  }

  public void setDaysOfWeek(List<@Valid DayOfWeek> daysOfWeek) {
    this.daysOfWeek = daysOfWeek;
  }

  public Building photo(String photo) {
    this.photo = photo;
    return this;
  }

  /**
   * Get photo
   * @return photo
  */
  
  @Schema(name = "photo", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("photo")
  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Building building = (Building) o;
    return Objects.equals(this.name, building.name) &&
        Objects.equals(this.location, building.location) &&
        Objects.equals(this.placeType, building.placeType) &&
        Objects.equals(this.services, building.services) &&
        Objects.equals(this.description, building.description) &&
        Objects.equals(this.bookables, building.bookables) &&
        Objects.equals(this.daysOfWeek, building.daysOfWeek) &&
        Objects.equals(this.photo, building.photo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, location, placeType, services, description, bookables, daysOfWeek, photo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Building {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    placeType: ").append(toIndentedString(placeType)).append("\n");
    sb.append("    services: ").append(toIndentedString(services)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    bookables: ").append(toIndentedString(bookables)).append("\n");
    sb.append("    daysOfWeek: ").append(toIndentedString(daysOfWeek)).append("\n");
    sb.append("    photo: ").append(toIndentedString(photo)).append("\n");
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

