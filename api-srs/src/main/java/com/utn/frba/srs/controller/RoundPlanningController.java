package com.utn.frba.srs.controller;

import com.utn.frba.srs.mapper.RoundPlanningMapper;
import com.utn.frba.srs.service.RoundPlanningService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/srs/round-planning")
public class RoundPlanningController {

    private final RoundPlanningService roundPlanningService;
    private final RoundPlanningMapper mapper;

    public RoundPlanningController(RoundPlanningService roundPlanningService, RoundPlanningMapper mapper) {
        this.roundPlanningService = roundPlanningService;
        this.mapper = mapper;
    }

    @PostMapping
    Long create(@RequestBody RoundPlanningDto request) {
        return roundPlanningService.create(mapper.toRoundPlanning(request));
    }

    @PutMapping
    void update(@RequestBody RoundPlanningDto request) {
        roundPlanningService.update(mapper.toRoundPlanning(request));
    }

    @DeleteMapping("/{roundPlanningId}")
    void delete(@PathVariable("roundPlanningId") Long roundPlanningId) {
        roundPlanningService.delete(roundPlanningId);
    }

    @GetMapping("/findById/{roundPlanningId}")
    RoundPlanningReduceDto findById(@PathVariable("roundPlanningId") Long roundPlanningId) {
        return mapper.toRoundPlanningDto(roundPlanningService.findById(roundPlanningId));

    }

    @GetMapping("/findByRoundId/{roundId}")
    RoundPlanningListDto findByRoundId(@PathVariable("roundId") Long roundId) {
        return new RoundPlanningListDto(roundPlanningService.findByRoundId(roundId).stream().map(mapper::toRoundPlanningDto).toList());

    }

    public record RoundPlanningDto(
            Long rondaId,
            String dayName,
            LocalTime timeStart
    ) {
    }

    public record RoundPlanningReduceDto(
            Long id,
            Long rondaId,
            String dayName,
            LocalTime timeStart
    ) {
    }

    public record RoundPlanningListDto(
            List<RoundPlanningReduceDto> plannings
    ) {

    }

}
