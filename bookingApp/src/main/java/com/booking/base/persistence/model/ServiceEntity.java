package com.booking.base.persistence.model;


import jakarta.persistence.*;
import lombok.*;

import jakarta.persistence.Table;

@Entity
@Table(name = "service")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String label;


    @ManyToOne
    @JoinColumn(name = "building_id")
    private BuildingEntity building;

    @Override
    public String toString() {
        return "ServiceEntity{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", building=" + building +
                '}';
    }
}
