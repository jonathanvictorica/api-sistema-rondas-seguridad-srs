package com.utn.frba.srs.repository;

import com.utn.frba.srs.model.RoundExecuteEvent;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoundExecuteEventRepository extends JpaRepository<RoundExecuteEvent, Long> {
    RoundExecuteEvent findByRoundExecute_IdAndEventType(Long roundExecuteId, String evento);
}