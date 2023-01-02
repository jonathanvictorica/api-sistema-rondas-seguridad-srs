package com.utn.frba.srs.repository;

import com.utn.frba.srs.model.RoundCheckpoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoundCheckpointRepository extends JpaRepository<RoundCheckpoint, Long> {
    @Query("select r from RoundCheckpoint r where r.round.id = ?1")
    List<RoundCheckpoint> findByRound_Id(Long id);


}