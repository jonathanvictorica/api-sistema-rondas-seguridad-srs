package com.utn.frba.srs.repository;

import com.utn.frba.srs.model.Subsidiary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SubsidiaryRepository extends JpaRepository<Subsidiary, Long> {
    List<Subsidiary> findByCustomer_id(Long customerId);
}