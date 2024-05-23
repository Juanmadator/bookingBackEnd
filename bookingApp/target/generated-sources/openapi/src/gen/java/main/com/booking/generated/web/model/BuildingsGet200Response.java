package com.booking.generated.web.model;

import java.net.URI;
import java.util.Objects;
import com.booking.generated.web.model.Building;
import com.booking.generated.web.model.PaginationSummary;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
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
 * BuildingsGet200Response
 */

@JsonTypeName("_buildings_get_200_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-19T11:24:03.558366200+02:00[Europe/Madrid]", comments = "Generator version: 7.4.0")
public class BuildingsGet200Response {

  @Valid
  private List<@Valid Building> data = new ArrayList<>();

  private PaginationSummary pagination;

  public BuildingsGet200Response() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public BuildingsGet200Response(List<@Valid Building> data, PaginationSummary pagination) {
    this.data = data;
    this.pagination = pagination;
  }

  public BuildingsGet200Response data(List<@Valid Building> data) {
    this.data = data;
    return this;
  }

  public BuildingsGet200Response addDataItem(Building dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
   * Get data
   * @return data
  */
  @NotNull @Valid 
  @Schema(name = "data", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("data")
  public List<@Valid Building> getData() {
    return data;
  }

  public void setData(List<@Valid Building> data) {
    this.data = data;
  }

  public BuildingsGet200Response pagination(PaginationSummary pagination) {
    this.pagination = pagination;
    return this;
  }

  /**
   * Get pagination
   * @return pagination
  */
  @NotNull @Valid 
  @Schema(name = "pagination", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("pagination")
  public PaginationSummary getPagination() {
    return pagination;
  }

  public void setPagination(PaginationSummary pagination) {
    this.pagination = pagination;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BuildingsGet200Response buildingsGet200Response = (BuildingsGet200Response) o;
    return Objects.equals(this.data, buildingsGet200Response.data) &&
        Objects.equals(this.pagination, buildingsGet200Response.pagination);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, pagination);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BuildingsGet200Response {\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    pagination: ").append(toIndentedString(pagination)).append("\n");
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

