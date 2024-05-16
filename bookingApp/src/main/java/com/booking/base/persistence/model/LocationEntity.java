package com.booking.base.persistence.model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "location")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    private BigDecimal latitude;

    private BigDecimal longitude;

//    @JsonIgnore
//    @OneToMany(mappedBy = "location")
//    private List<BuildingEntity> buildings;

}
