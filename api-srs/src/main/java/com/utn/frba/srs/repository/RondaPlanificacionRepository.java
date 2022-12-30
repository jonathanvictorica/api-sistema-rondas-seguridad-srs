package com.utn.frba.srs.repository;

import com.utn.frba.srs.model.RondaPlanificacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RondaPlanificacionRepository extends JpaRepository<RondaPlanificacion, Long> {
    List<RondaPlanificacion> findByRonda_id(Long roundId);
}