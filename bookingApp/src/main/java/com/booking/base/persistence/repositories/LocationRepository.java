package com.booking.base.persistence.repositories;

import com.booking.base.persistence.model.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;


@Repository
public interface LocationRepository extends JpaRepository<LocationEntity,Long> {

    LocationEntity findByAddressAndLatitudeAndLongitude(String address,
                                                    BigDecimal latitude,
                                                    BigDecimal longitude);
}
