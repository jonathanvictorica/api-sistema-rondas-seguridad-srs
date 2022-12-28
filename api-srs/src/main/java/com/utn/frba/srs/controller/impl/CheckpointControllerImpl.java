package com.utn.frba.srs.controller.impl;

import com.utn.frba.srs.controller.contract.CheckpointController;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CheckpointControllerImpl implements CheckpointController {
    @Override
    public Long create(CheckpointDto request) {
        return null;
    }

    @Override
    public void update(Long checkpointId, CheckpointDto request) {

    }

    @Override
    public void delete(Long checkpointId) {

    }

    @Override
    public List<CheckpointReduceDto> findBySubsidiary(Long subsidiaryId) {
        return null;
    }
}
