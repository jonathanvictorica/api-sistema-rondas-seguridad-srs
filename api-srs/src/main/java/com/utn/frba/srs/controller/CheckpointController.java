package com.utn.frba.srs.controller;

import com.utn.frba.srs.exception.SRSException;
import com.utn.frba.srs.mapper.CheckpointMapper;
import com.utn.frba.srs.service.CheckpointService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/srs/checkpoint")
public class CheckpointController {
    private final CheckpointService checkpointService;

    private final CheckpointMapper mapper;


    public CheckpointController(CheckpointService checkpointService, CheckpointMapper mapper) {
        this.checkpointService = checkpointService;
        this.mapper = mapper;
    }

    @PostMapping
    public void create(@RequestBody CheckpointDto request) throws SRSException {
        checkpointService.create(mapper.toCheckpoint(request));
    }

    @PutMapping
    void update(@RequestBody CheckpointDto request) throws SRSException {
        checkpointService.update(mapper.toCheckpoint(request));
    }

    @DeleteMapping("/{nfcIdentify}")
    public void delete(@PathVariable String nfcIdentify) {
        checkpointService.delete(nfcIdentify);
    }

    @GetMapping("/findBySubsidiary/{subsidiaryId}")
    public CheckpointReduceListDto findBySubsidiary(@PathVariable Long subsidiaryId) {
        return new CheckpointReduceListDto(checkpointService.findBySubsidiary(subsidiaryId).stream().map(mapper::toCheckpointReduceDto).toList());
    }

    @GetMapping("/findById/{checkpointNfc}")
    public CheckpointReduceDto findById(@PathVariable String checkpointNfc) {
        return mapper.toCheckpointReduceDto(checkpointService.findById(checkpointNfc));
    }


    public record CheckpointDto(
            String nfcCode,
            String latitude, String longitude, Long subsidiaryId
    ) {
    }

    public record CheckpointReduceDto(
            String nfcCode,
            String latitude, String longitude, Long subsidiaryId
    ) {
    }

    public record CheckpointReduceListDto(
            List<CheckpointReduceDto> checkpoints
    ) {
    }
}
