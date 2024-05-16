package com.booking.base.services;


import com.booking.base.persistence.repositories.ServiceRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceModelService {


    private final ServiceRepository serviceRepository;

    public ServiceModelService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }
}



