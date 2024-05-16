package com.booking.base.persistence.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "bookable")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BookableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String label;

    private Long slots;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "building_id")
    private BuildingEntity building;
}
