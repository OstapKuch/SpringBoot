package com.iot.repository;

import com.iot.model.Apartments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentsRepository extends JpaRepository<Apartments, Integer> {
}
