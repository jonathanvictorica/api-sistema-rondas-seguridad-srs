package com.utn.frba.srs.controller;

import com.utn.frba.srs.mapper.RoundMapper;
import com.utn.frba.srs.service.RoundService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/srs/round")
public class RoundController {

    private final RoundService roundService;

    public RoundController(RoundService roundService) {
        this.roundService = roundService;
    }

    @PostMapping
    Long create(@RequestBody RoundDto request) {
        return roundService.create(RoundMapper.INSTANCE.toRonda(request));

    }

    @PutMapping("/{roundId}")
    void update(@PathVariable("roundId") Long roundId, @RequestBody RoundDto request) {
        roundService.update(RoundMapper.INSTANCE.toRonda(request));

    }

    @DeleteMapping("/{roundId}")
    void delete(@PathVariable("roundId") Long roundId) {
        roundService.delete(roundId);
    }

    @GetMapping("/findBySubsidiary/{subsidiaryId}")
    List<RoundReduceDto> findBySubsidiary(@PathVariable("subsidiaryId") Long subsidiaryId) {
        return roundService.findBySubsidiary(subsidiaryId).stream().map(RoundMapper.INSTANCE::toRoundReduceDto).toList();

    }

    @GetMapping("/findByCustomer/{customerId}")
    List<RoundReduceDto> findByCustomer(@PathVariable("customerId") Long customerId) {
        return roundService.findByCustomer(customerId).stream().map(RoundMapper.INSTANCE::toRoundReduceDto).toList();

    }

    @GetMapping("/findById/{roundId}")
    RoundReduceDto findById(@PathVariable("roundId") Long roundId) {
        return RoundMapper.INSTANCE.toRoundReduceDto(roundService.findById(roundId));

    }

    public record RoundCheckPointDto(
            String identificadorNFC,
            Integer order
    ){}

    public   record RoundRutaDto(
            Integer order,
            String latitud,
            String longitud
    ){}
    public  record RoundDto(
            Long sucursalClienteId,
            String nombre,
            String descripcion,
            String latitudCentral,
            String longitudCentral,
            String ubicacionZoom,
            List<RoundCheckPointDto> checkpoints,
            List<RoundRutaDto> rutas
    ) {
    }


    public   record RoundReduceDto(
            Long roundId,
            Long sucursalClienteId,
            String nombre,
            String descripcion,
            String latitudCentral,
            String longitudCentral,
            String ubicacionZoom,
            List<RoundCheckPointDto> checkpoints,
            List<RoundRutaDto> rutas
    ) {
    }
}
