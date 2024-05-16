package com.booking.base.persistence.repositories;

import com.booking.base.persistence.model.PlaceTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceTypeRepository extends JpaRepository<PlaceTypeEntity, Long> {
    PlaceTypeEntity findByLabel(String label);
}
