package com.utn.frba.srs.repository;

import com.utn.frba.srs.model.RoundRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoundRouteRepository extends JpaRepository<RoundRoute, Long> {
    @Query("select r from RoundRoute r where r.round.id = ?1")
    List<RoundRoute> findByRound_Id(Long id);


}