package com.booking.base.persistence.repositories;

import com.booking.base.persistence.model.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookingRepository extends JpaRepository<BookingEntity,Long> {


}
