package com.booking.base.persistence.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "building")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BuildingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String photo;


    @ManyToOne
    private PlaceTypeEntity placeType;

    @ManyToOne
    private LocationEntity location;

    @OneToMany(mappedBy = "building")
    private List<BookableEntity> bookables;

    @OneToMany(mappedBy = "building")
    private List<ServiceEntity> services;

    @OneToMany(mappedBy = "building")
    private List<DayOfWeekEntity> daysOfWeek;

    @Override
    public String toString() {
        return "BuildingEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", photo='" + photo + '\'' +
                ", placeType=" + placeType +
                ", location=" + location +
                ", bookables=" + bookables +
                ", services=" + services +
                ", daysOfWeek=" + daysOfWeek +
                '}';
    }
}
