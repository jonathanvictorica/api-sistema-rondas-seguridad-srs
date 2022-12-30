package com.utn.frba.srs.repository;

import com.utn.frba.srs.model.RondaEjecucion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RondaEjecucionRepository extends JpaRepository<RondaEjecucion, Long> {
}