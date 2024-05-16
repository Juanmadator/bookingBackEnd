package com.booking.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
public class BookingAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingAppApplication.class, args);
    }

}
