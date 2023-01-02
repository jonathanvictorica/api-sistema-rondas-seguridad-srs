package com.utn.frba.srs.repository;

import com.utn.frba.srs.model.Checkpoint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CheckpointRepository extends JpaRepository<Checkpoint, String> {
    List<Checkpoint> findBySubsidiary_id(Long subsidiaryId);
}