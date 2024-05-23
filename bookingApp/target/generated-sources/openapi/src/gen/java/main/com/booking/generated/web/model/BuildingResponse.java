package com.booking.generated.web.model;

import java.net.URI;
import java.util.Objects;
import com.booking.generated.web.model.Location;
import com.booking.generated.web.model.PlaceType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * BuildingResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-19T11:24:03.558366200+02:00[Europe/Madrid]", comments = "Generator version: 7.4.0")
public class BuildingResponse {

  private Object id = null;

  private Object name = null;

  private Location location;

  private PlaceType placeType;

  private Object services = null;

  private Object description = null;

  private Object bookables = null;

  private Object daysOfWeek = null;

  private Object photo = null;

  public BuildingResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public BuildingResponse(Object name, PlaceType placeType) {
    this.name = name;
    this.placeType = placeType;
  }

  public BuildingResponse id(Object id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Object getId() {
    return id;
  }

  public void setId(Object id) {
    this.id = id;
  }

  public BuildingResponse name(Object name) {
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
  public Object getName() {
    return name;
  }

  public void setName(Object name) {
    this.name = name;
  }

  public BuildingResponse location(Location location) {
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

  public BuildingResponse placeType(PlaceType placeType) {
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

  public BuildingResponse services(Object services) {
    this.services = services;
    return this;
  }

  /**
   * Get services
   * @return services
  */
  
  @Schema(name = "services", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("services")
  public Object getServices() {
    return services;
  }

  public void setServices(Object services) {
    this.services = services;
  }

  public BuildingResponse description(Object description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  */
  
  @Schema(name = "description", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public Object getDescription() {
    return description;
  }

  public void setDescription(Object description) {
    this.description = description;
  }

  public BuildingResponse bookables(Object bookables) {
    this.bookables = bookables;
    return this;
  }

  /**
   * Get bookables
   * @return bookables
  */
  
  @Schema(name = "bookables", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("bookables")
  public Object getBookables() {
    return bookables;
  }

  public void setBookables(Object bookables) {
    this.bookables = bookables;
  }

  public BuildingResponse daysOfWeek(Object daysOfWeek) {
    this.daysOfWeek = daysOfWeek;
    return this;
  }

  /**
   * Get daysOfWeek
   * @return daysOfWeek
  */
  
  @Schema(name = "daysOfWeek", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("daysOfWeek")
  public Object getDaysOfWeek() {
    return daysOfWeek;
  }

  public void setDaysOfWeek(Object daysOfWeek) {
    this.daysOfWeek = daysOfWeek;
  }

  public BuildingResponse photo(Object photo) {
    this.photo = photo;
    return this;
  }

  /**
   * Get photo
   * @return photo
  */
  
  @Schema(name = "photo", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("photo")
  public Object getPhoto() {
    return photo;
  }

  public void setPhoto(Object photo) {
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
    BuildingResponse buildingResponse = (BuildingResponse) o;
    return Objects.equals(this.id, buildingResponse.id) &&
        Objects.equals(this.name, buildingResponse.name) &&
        Objects.equals(this.location, buildingResponse.location) &&
        Objects.equals(this.placeType, buildingResponse.placeType) &&
        Objects.equals(this.services, buildingResponse.services) &&
        Objects.equals(this.description, buildingResponse.description) &&
        Objects.equals(this.bookables, buildingResponse.bookables) &&
        Objects.equals(this.daysOfWeek, buildingResponse.daysOfWeek) &&
        Objects.equals(this.photo, buildingResponse.photo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, location, placeType, services, description, bookables, daysOfWeek, photo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BuildingResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

