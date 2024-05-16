
package com.booking.base.persistence.model;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import lombok.*;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "booking")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameBuilding;

    private String nameBooking;

    private LocalDate dayOfMonth;

    private LocalTime startHour;

    private LocalTime finishHour;

    private int duration;

    private int reservedSlots;
}
