package com.booking.base.persistence.repositories;

import com.booking.base.persistence.model.BuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<BuildingEntity,Long> {


    //select the building with name = x
   // @Query("SELECT b FROM BuildingEntity b where b.name = :name")
    boolean existsByName(String name);
}
