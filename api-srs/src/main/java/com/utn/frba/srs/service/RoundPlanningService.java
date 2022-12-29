package com.utn.frba.srs.service;

import com.utn.frba.srs.model.RondaPlanificacion;
import com.utn.frba.srs.repository.RondaPlanificacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoundPlanningService {

    private final RondaPlanificacionRepository rondaPlanificacionRepository;

    public RoundPlanningService(RondaPlanificacionRepository rondaPlanificacionRepository) {
        this.rondaPlanificacionRepository = rondaPlanificacionRepository;
    }

    public List<RondaPlanificacion> findByRoundId(Long roundId) {
        return rondaPlanificacionRepository.findByRound_id(roundId);
    }

    public RondaPlanificacion findById(Long roundPlanningId) {
        return rondaPlanificacionRepository.findById(roundPlanningId).orElse(null);
    }

    public void delete(Long roundPlanningId) {
        rondaPlanificacionRepository.deleteById(roundPlanningId);
    }

    public Long create(RondaPlanificacion roundPlanning) {
        rondaPlanificacionRepository.save(roundPlanning);
        return roundPlanning.getId();
    }

    public void update(RondaPlanificacion roundPlanning) {
        rondaPlanificacionRepository.save(roundPlanning);
    }
}
