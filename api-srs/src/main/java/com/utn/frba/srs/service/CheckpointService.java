package com.utn.frba.srs.service;

import com.utn.frba.srs.exception.CatalogErrors;
import com.utn.frba.srs.exception.SRSException;
import com.utn.frba.srs.model.Checkpoint;
import com.utn.frba.srs.repository.CheckpointRepository;
import com.utn.frba.srs.repository.SubsidiaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckpointService {

    private final CheckpointRepository checkPointRepository;
    private final SubsidiaryRepository subsidiaryRepository;

    public CheckpointService(CheckpointRepository checkPointRepository, SubsidiaryRepository subsidiaryRepository) {
        this.checkPointRepository = checkPointRepository;
        this.subsidiaryRepository = subsidiaryRepository;
    }

    public List<Checkpoint> findBySubsidiary(Long subsidiaryId) {
        return checkPointRepository.findBySubsidiary_id(subsidiaryId);
    }

    public void create(Checkpoint checkPoint) throws SRSException {
        createOrUpdate(checkPoint);
    }

    private void createOrUpdate(Checkpoint checkPoint) throws SRSException {
        subsidiaryRepository.findById(checkPoint.getSubsidiary().getId()).orElseThrow(() -> new SRSException(CatalogErrors.SUBSIDIARY_NOT_FOUND));
        checkPointRepository.save(checkPoint);
    }

    public void update(Checkpoint checkPoint) throws SRSException {
        createOrUpdate(checkPoint);
    }

    public void delete(String nfcIdentify) {
        checkPointRepository.deleteById(nfcIdentify);
    }

    public Checkpoint findById(String checkpointId) {
        return checkPointRepository.findById(checkpointId).orElse(null);
    }
}
