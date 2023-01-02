package com.utn.frba.srs.controller;

import com.utn.frba.srs.exception.SRSException;
import com.utn.frba.srs.mapper.RoundMapper;
import com.utn.frba.srs.service.RoundService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/srs/round")
public class RoundController {

    private final RoundService roundService;
    private final RoundMapper mapper;


    public RoundController(RoundService roundService, RoundMapper mapper) {
        this.roundService = roundService;
        this.mapper = mapper;
    }

    @PostMapping
    Long create(@RequestBody RoundDto request) throws SRSException {
        return roundService.create(mapper.toRound(request));

    }

    @PutMapping
    void update(@RequestBody RoundDto request) throws SRSException {
        roundService.update(mapper.toRound(request));

    }

    @DeleteMapping("/{roundId}")
    void delete(@PathVariable("roundId") Long roundId) {
        roundService.delete(roundId);
    }

    @GetMapping("/findBySubsidiary/{subsidiaryId}")
    List<RoundReduceDto> findBySubsidiary(@PathVariable("subsidiaryId") Long subsidiaryId) {
        return roundService.findBySubsidiary(subsidiaryId).stream().map(mapper::toRoundReduceDto).toList();

    }

    @GetMapping("/findByCustomer/{customerId}")
    List<RoundReduceDto> findByCustomer(@PathVariable("customerId") Long customerId) {
        return roundService.findByCustomer(customerId).stream().map(mapper::toRoundReduceDto).toList();

    }

    @GetMapping("/findById/{roundId}")
    RoundReduceDto findById(@PathVariable("roundId") Long roundId) {
        return mapper.toRoundReduceDto(roundService.findById(roundId));

    }

    public record RoundCheckPointDto(
            String nfcCode,
            Integer executionOrder
    ) {
    }

    public record RoundRouteDto(
            Integer order,
            String latitude,
            String longitude
    ) {
    }

    public record RoundDto(
            Long id,
            Long subsidiaryId,
            String name,
            String description,
            List<RoundCheckPointDto> checkpoints,
            List<RoundRouteDto> routes
    ) {
    }


    public record RoundReduceDto(
            Long id,
            Long subsidiaryId,
            String name,
            String description,
            List<RoundCheckPointDto> checkpoints,
            List<RoundRouteDto> routes
    ) {
    }
}
