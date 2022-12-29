package com.utn.frba.srs.controller.impl;

import com.utn.frba.srs.controller.contract.CheckpointController;
import com.utn.frba.srs.exception.SRSException;
import com.utn.frba.srs.mapper.CheckpointMapper;
import com.utn.frba.srs.service.CheckpointService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CheckpointControllerImpl implements CheckpointController {
    private final CheckpointService checkpointService;


    public CheckpointControllerImpl(CheckpointService checkpointService) {
        this.checkpointService = checkpointService;
    }

    @Override
    public void create(CheckpointDto request) throws SRSException {
        checkpointService.create(CheckpointMapper.INSTANCE.toCheckpoint(request));
    }

    @Override
    public void update(Long checkpointId, CheckpointDto request) throws SRSException {
        checkpointService.update(CheckpointMapper.INSTANCE.toCheckpoint(request));
    }

    @Override
    public void delete(String nfcIdentify) {
        checkpointService.delete(nfcIdentify);
    }

    @Override
    public List<CheckpointReduceDto> findBySubsidiary(Long subsidiaryId) {
        return checkpointService.findBySubsidiary(subsidiaryId).stream().map(CheckpointMapper.INSTANCE::toCheckpointReduceDto).toList();
    }
}
