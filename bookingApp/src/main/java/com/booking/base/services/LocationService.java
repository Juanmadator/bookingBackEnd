package com.booking.base.services;

import com.booking.base.persistence.repositories.LocationRepository;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
 private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }



}
