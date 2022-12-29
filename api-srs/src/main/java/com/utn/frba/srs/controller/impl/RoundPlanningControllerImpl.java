package com.utn.frba.srs.controller.impl;

import com.utn.frba.srs.controller.contract.RoundPlanningController;
import com.utn.frba.srs.mapper. RoundPlanningMapper;
import com.utn.frba.srs.service.RoundPlanningService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoundPlanningControllerImpl implements RoundPlanningController {

    private final RoundPlanningService roundPlanningService;

    public RoundPlanningControllerImpl(RoundPlanningService roundPlanningService) {
        this.roundPlanningService = roundPlanningService;
    }

    @Override
    public Long create(RoundPlanningDto request) {
        return roundPlanningService.create( RoundPlanningMapper.INSTANCE.toRondaPlanificacion(request));
    }

    @Override
    public void update(Long roundPlanningId, RoundPlanningDto request) {
        roundPlanningService.update( RoundPlanningMapper.INSTANCE.toRondaPlanificacion(request));
    }

    @Override
    public void delete(Long roundPlanningId) {
        roundPlanningService.delete(roundPlanningId);
    }

    @Override
    public RoundPlanningReduceDto findById(Long roundPlanningId) {
        return  RoundPlanningMapper.INSTANCE.toRoundPlanningDto(roundPlanningService.findById(roundPlanningId));

    }

    @Override
    public List<RoundPlanningReduceDto> findByRoundId(Long roundId) {
        return roundPlanningService.findByRoundId(roundId).stream().map( RoundPlanningMapper.INSTANCE::toRoundPlanningDto).toList();

    }
}
