package com.iot.repository;

import com.iot.model.Billings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingsRepository extends JpaRepository<Billings, Integer> {
}
