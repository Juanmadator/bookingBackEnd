package com.booking.base.persistence.repositories;

import com.booking.base.persistence.model.BookableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookableRepository extends JpaRepository<BookableEntity,Long> {

   List<BookableEntity> findByBuildingId(Long id);
    BookableEntity findByLabelAndBuildingId(@Param("label") String label,@Param("id") Long id);

}
