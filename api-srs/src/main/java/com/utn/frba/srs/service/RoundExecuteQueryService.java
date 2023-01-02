package com.utn.frba.srs.service;

import com.utn.frba.srs.constants.Constantes;
import com.utn.frba.srs.model.RoundExecute;
import com.utn.frba.srs.repository.RoundExecuteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoundExecuteQueryService {

    private final RoundExecuteRepository roundExecuteRepository;

    public RoundExecuteQueryService(RoundExecuteRepository roundExecuteRepository) {
        this.roundExecuteRepository = roundExecuteRepository;
    }

    public RoundExecute findOnlineById(Long roundExecuteId) {
        return roundExecuteRepository.findById(roundExecuteId).orElse(null);
    }

    public List<RoundExecute> findRoundPendingBySubsidiary(Long subsidiaryId) {
        return roundExecuteRepository.findByRound_subsidiary_IdAndState(subsidiaryId, Constantes.RONDA_EJECUCION_PENDIENTE);
    }

    public List<RoundExecute> findByStateRevision() {
        return roundExecuteRepository.findByState(Constantes.RONDA_EJECUCION_REVISION);
    }
}
