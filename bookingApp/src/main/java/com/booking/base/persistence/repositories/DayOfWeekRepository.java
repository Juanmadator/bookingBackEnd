package com.booking.base.persistence.repositories;

import com.booking.base.persistence.model.DayOfWeekEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;


@Repository
public interface DayOfWeekRepository extends JpaRepository<DayOfWeekEntity,Long> {

    List<DayOfWeekEntity> findByBuildingId(Long id);
    DayOfWeekEntity findByDayAndOpeningTimeAndClosingTimeAndIsClosedAndBuildingId(
            @Param("day") String day,
            @Param("openingTime") LocalTime openTime,
            @Param("closingTime") LocalTime closingTime,
            @Param("isClosed") boolean isClosed,
            @Param("id") Long id
            );

//    @Transactional
//    @Modifying
//    @Query("DELETE FROM  DayOfWeekEntity d WHERE d.building = :id")
//    void deleteDayOfWeekByBuildingId(@Param("id") Long id);

//    @Query("SELECT d FROM DayOfWeek d where d.building.id = : id")
//    DayOfWeek getDayOfWeekByBuildingId(@Param("id") Long id);
}
