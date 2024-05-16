package com.booking.base.persistence.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "place_type")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PlaceTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String label;


//    @JsonIgnore
//    @OneToMany(mappedBy = "placeType")
//    private List<BuildingEntity> buildings;
}
