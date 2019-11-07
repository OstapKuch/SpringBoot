package com.iot.repository;

import com.iot.model.Buyers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyersRepository extends JpaRepository<Buyers, Integer> {
}
