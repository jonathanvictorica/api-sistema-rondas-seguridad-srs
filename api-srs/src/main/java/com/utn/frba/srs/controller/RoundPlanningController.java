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

    public RoundPlanningController(RoundPlanningService roundPlanningService) {
        this.roundPlanningService = roundPlanningService;
    }

    @PostMapping
    Long create(@RequestBody RoundPlanningDto request) {
        return roundPlanningService.create( RoundPlanningMapper.INSTANCE.toRondaPlanificacion(request));
    }

    @PutMapping("/{roundPlanningId}")
    void update(@PathVariable("roundPlanningId") Long roundPlanningId, @RequestBody RoundPlanningDto request) {
        roundPlanningService.update( RoundPlanningMapper.INSTANCE.toRondaPlanificacion(request));
    }

    @DeleteMapping("/{roundPlanningId}")
    void delete(@PathVariable("roundPlanningId") Long roundPlanningId) {
        roundPlanningService.delete(roundPlanningId);
    }

    @GetMapping("/findById/{roundPlanningId}")
    RoundPlanningReduceDto findById(@PathVariable("roundPlanningId") Long roundPlanningId) {
        return  RoundPlanningMapper.INSTANCE.toRoundPlanningDto(roundPlanningService.findById(roundPlanningId));

    }

    @GetMapping("/findByRoundId/{roundId}")
    List<RoundPlanningReduceDto> findByRoundId(@PathVariable("roundId") Long roundId) {
        return roundPlanningService.findByRoundId(roundId).stream().map( RoundPlanningMapper.INSTANCE::toRoundPlanningDto).toList();

    }

    public record RoundPlanningDto(
            Long rondaId,
            String dayName,
            LocalTime timeStart
    ) {
    }

    public   record RoundPlanningReduceDto(
            Long id,
            Long rondaId,
            String dayName,
            LocalTime timeStart
    ) {
    }

}
