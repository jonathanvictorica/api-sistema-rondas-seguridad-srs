package com.utn.frba.srs.repository;

import com.utn.frba.srs.model.RoundPlanning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalTime;
import java.util.List;

public interface RoundPlanningRepository extends JpaRepository<RoundPlanning, Long> {
    @Query("select r from RoundPlanning r where r.diaSemana = ?1 and r.horaInicio between ?2 and ?3")
    List<RoundPlanning> findByDiaSemanaAndHoraInicioBetween(String diaSemana, LocalTime horaInicioStart, LocalTime horaInicioEnd);

    List<RoundPlanning> findByRound_id(Long roundId);
}