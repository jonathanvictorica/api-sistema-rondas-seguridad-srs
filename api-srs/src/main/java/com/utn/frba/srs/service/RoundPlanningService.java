package com.utn.frba.srs.service;

import com.utn.frba.srs.model.RoundPlanning;
import com.utn.frba.srs.repository.RoundPlanningRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoundPlanningService {

    private final RoundPlanningRepository roundPlanningRepository;

    public RoundPlanningService(RoundPlanningRepository roundPlanningRepository) {
        this.roundPlanningRepository = roundPlanningRepository;
    }

    public List<RoundPlanning> findByRoundId(Long roundId) {
        return roundPlanningRepository.findByRound_id(roundId);
    }

    public RoundPlanning findById(Long roundPlanningId) {
        return roundPlanningRepository.findById(roundPlanningId).orElse(null);
    }

    public void delete(Long roundPlanningId) {
        roundPlanningRepository.deleteById(roundPlanningId);
    }

    public Long create(RoundPlanning roundPlanning) {
        roundPlanningRepository.save(roundPlanning);
        return roundPlanning.getId();
    }

    public void update(RoundPlanning roundPlanning) {
        roundPlanningRepository.save(roundPlanning);
    }
}
