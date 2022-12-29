package com.utn.frba.srs.controller.impl;

import com.utn.frba.srs.controller.contract.RoundController;
import com.utn.frba.srs.mapper.RoundMapper;
import com.utn.frba.srs.service.RoundService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoundControllerImpl implements RoundController {

    private final RoundService roundService;

    public RoundControllerImpl(RoundService roundService) {
        this.roundService = roundService;
    }

    @Override
    public Long create(RoundDto request) {
        return roundService.create(RoundMapper.INSTANCE.toRonda(request));

    }

    @Override
    public void update(Long roundId, RoundDto request) {
        roundService.update(RoundMapper.INSTANCE.toRonda(request));

    }

    @Override
    public void delete(Long roundId) {
        roundService.delete(roundId);
    }

    @Override
    public List<RoundReduceDto> findBySubsidiary(Long subsidiaryId) {
        return roundService.findBySubsidiary(subsidiaryId).stream().map(RoundMapper.INSTANCE::toRoundReduceDto).toList();

    }

    @Override
    public List<RoundReduceDto> findByCustomer(Long customerId) {
        return roundService.findByCustomer(customerId).stream().map(RoundMapper.INSTANCE::toRoundReduceDto).toList();

    }

    @Override
    public RoundReduceDto findById(Long roundId) {
        return RoundMapper.INSTANCE.toRoundReduceDto(roundService.findById(roundId));

    }
}
