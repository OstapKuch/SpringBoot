package com.iot.repository;

import com.iot.model.ApartmentsHasReservations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentsHasReservationsRepository extends JpaRepository<ApartmentsHasReservations, Integer> {
}
