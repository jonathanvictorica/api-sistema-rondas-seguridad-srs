package com.utn.frba.srs.repository;

import com.utn.frba.srs.model.RoundExecute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;


public interface RoundExecuteRepository extends JpaRepository<RoundExecute, Long> {
    List<RoundExecute> findByRound_subsidiary_IdAndState(Long subsidiaryId, String state);

    List<RoundExecute> findByState(String state);

    @Query("select r from RoundExecute r where r.round.id = ?1 and r.dateTimeStart between ?2 and ?3")
    List<RoundExecute> findByRound_IdAndDateTimeStartBetween(Long id, LocalDateTime start, LocalDateTime end);
}