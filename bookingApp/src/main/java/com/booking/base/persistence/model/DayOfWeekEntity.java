package com.booking.base.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Table;

import java.time.LocalTime;

@Entity
@Table(name = "day_of_week")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DayOfWeekEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String day;

    private Boolean isClosed;

    private LocalTime openingTime;

    private LocalTime closingTime;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "building_id")
    private BuildingEntity building;
}
