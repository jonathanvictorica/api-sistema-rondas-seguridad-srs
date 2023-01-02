package com.utn.frba.srs.repository;

import com.utn.frba.srs.model.Round;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RoundRepository extends JpaRepository<Round, Long> {
    List<Round> findBySubsidiary_id(Long subsidiaryId);

    List<Round> findBySubsidiary_customer_id(Long customerId);
}