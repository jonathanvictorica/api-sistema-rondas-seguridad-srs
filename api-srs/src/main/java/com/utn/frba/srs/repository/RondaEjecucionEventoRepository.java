package com.utn.frba.srs.repository;

import com.utn.frba.srs.model.RondaEjecucionEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RondaEjecucionEventoRepository extends JpaRepository<RondaEjecucionEvento, Long> {
    RondaEjecucionEvento findByRondaEjecucion_IdAndTipoEvento(Long roundExecuteId, String evento);
}