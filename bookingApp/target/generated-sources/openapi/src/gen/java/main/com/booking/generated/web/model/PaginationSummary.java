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
 * PaginationSummary
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-19T11:24:03.558366200+02:00[Europe/Madrid]", comments = "Generator version: 7.4.0")
public class PaginationSummary {

  private Integer currentPage;

  private Integer totalPages;

  private Integer pageSize;

  private Integer totalCount;

  public PaginationSummary() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PaginationSummary(Integer currentPage, Integer totalPages, Integer pageSize, Integer totalCount) {
    this.currentPage = currentPage;
    this.totalPages = totalPages;
    this.pageSize = pageSize;
    this.totalCount = totalCount;
  }

  public PaginationSummary currentPage(Integer currentPage) {
    this.currentPage = currentPage;
    return this;
  }

  /**
   * Current page
   * @return currentPage
  */
  @NotNull 
  @Schema(name = "currentPage", description = "Current page", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("currentPage")
  public Integer getCurrentPage() {
    return currentPage;
  }

  public void setCurrentPage(Integer currentPage) {
    this.currentPage = currentPage;
  }

  public PaginationSummary totalPages(Integer totalPages) {
    this.totalPages = totalPages;
    return this;
  }

  /**
   * Total number of pages
   * @return totalPages
  */
  @NotNull 
  @Schema(name = "totalPages", description = "Total number of pages", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("totalPages")
  public Integer getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }

  public PaginationSummary pageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return this;
  }

  /**
   * Number of items per each page
   * @return pageSize
  */
  @NotNull 
  @Schema(name = "pageSize", description = "Number of items per each page", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("pageSize")
  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public PaginationSummary totalCount(Integer totalCount) {
    this.totalCount = totalCount;
    return this;
  }

  /**
   * Total count of buildings that currently exists
   * @return totalCount
  */
  @NotNull 
  @Schema(name = "totalCount", description = "Total count of buildings that currently exists", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("totalCount")
  public Integer getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(Integer totalCount) {
    this.totalCount = totalCount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaginationSummary paginationSummary = (PaginationSummary) o;
    return Objects.equals(this.currentPage, paginationSummary.currentPage) &&
        Objects.equals(this.totalPages, paginationSummary.totalPages) &&
        Objects.equals(this.pageSize, paginationSummary.pageSize) &&
        Objects.equals(this.totalCount, paginationSummary.totalCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currentPage, totalPages, pageSize, totalCount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaginationSummary {\n");
    sb.append("    currentPage: ").append(toIndentedString(currentPage)).append("\n");
    sb.append("    totalPages: ").append(toIndentedString(totalPages)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    totalCount: ").append(toIndentedString(totalCount)).append("\n");
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

