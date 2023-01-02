package com.utn.frba.srs.service;

import com.utn.frba.srs.exception.CatalogErrors;
import com.utn.frba.srs.exception.SRSException;
import com.utn.frba.srs.model.Round;
import com.utn.frba.srs.model.RoundCheckpoint;
import com.utn.frba.srs.model.RoundRoute;
import com.utn.frba.srs.repository.RoundCheckpointRepository;
import com.utn.frba.srs.repository.RoundRepository;
import com.utn.frba.srs.repository.RoundRouteRepository;
import com.utn.frba.srs.repository.SubsidiaryRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class RoundService {

    private final RoundRepository roundRepository;
    private final RoundCheckpointRepository roundCheckpointRepository;
    private final RoundRouteRepository roundRouteRepository;

    private final SubsidiaryRepository subsidiaryRepository;

    public RoundService(RoundRepository roundRepository, RoundCheckpointRepository roundCheckpointRepository, RoundRouteRepository roundRouteRepository, SubsidiaryRepository subsidiaryRepository) {
        this.roundRepository = roundRepository;
        this.roundCheckpointRepository = roundCheckpointRepository;
        this.roundRouteRepository = roundRouteRepository;
        this.subsidiaryRepository = subsidiaryRepository;
    }

    public Long create(Round round) throws SRSException {
        saveOrUpdateRound(round);
        return round.getId();
    }

    private void saveOrUpdateRound(Round round) throws SRSException {
        preValidateRound(round);
        round.getCheckpoints().forEach(rondaCheckPoint -> rondaCheckPoint.setRound(round));
        round.getRoutes().forEach(rondaRuta -> rondaRuta.setRound(round));
        if (round.getId() != null) {
            roundRouteRepository.findByRound_Id(round.getId()).stream().map(RoundRoute::getId).forEach(roundRouteRepository::deleteById);
            roundCheckpointRepository.findByRound_Id(round.getId()).stream().map(RoundCheckpoint::getId).forEach(roundCheckpointRepository::deleteById);
        }
        roundRepository.save(round);
    }

    private void preValidateRound(Round round) throws SRSException {
        subsidiaryRepository.findById(round.getSubsidiary().getId()).orElseThrow(() -> new SRSException(CatalogErrors.SUBSIDIARY_NOT_FOUND));
        if (CollectionUtils.isEmpty(round.getCheckpoints())) {
            throw new SRSException(CatalogErrors.ROUND_WITHOUT_CHECKPOINTS);
        }
        if (CollectionUtils.isEmpty(round.getRoutes())) {
            throw new SRSException(CatalogErrors.ROUND_WITHOUT_ROUTES);
        }
    }

    public void update(Round round) throws SRSException {
        saveOrUpdateRound(round);
    }

    public void delete(Long roundId) {
        roundRepository.deleteById(roundId);
    }

    public List<Round> findBySubsidiary(Long subsidiaryId) {
        return roundRepository.findBySubsidiary_id(subsidiaryId);
    }

    public List<Round> findByCustomer(Long customerId) {
        return roundRepository.findBySubsidiary_customer_id(customerId);
    }

    public Round findById(Long roundId) {
        return roundRepository.findById(roundId).orElse(null);
    }
}
