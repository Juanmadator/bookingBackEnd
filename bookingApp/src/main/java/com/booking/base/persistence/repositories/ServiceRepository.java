package com.booking.base.persistence.repositories;

import com.booking.base.persistence.model.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ServiceRepository extends JpaRepository<ServiceEntity,Long> {

    ServiceEntity findByLabelAndBuildingId (@Param("label") String label, @Param("id") Long id);


    List<ServiceEntity> findByBuildingId(Long id);
}
