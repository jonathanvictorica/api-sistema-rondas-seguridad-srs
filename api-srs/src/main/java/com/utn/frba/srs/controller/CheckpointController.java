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


    public CheckpointController(CheckpointService checkpointService) {
        this.checkpointService = checkpointService;
    }

    @PostMapping
    public void create(@RequestBody CheckpointDto request) throws SRSException {
        checkpointService.create(CheckpointMapper.INSTANCE.toCheckpoint(request));
    }

    @PutMapping("/{checkpointId}")
    void update(@PathVariable("checkpointId") Long checkpointId, @RequestBody CheckpointDto request) throws SRSException {
checkpointService.update(CheckpointMapper.INSTANCE.toCheckpoint(request));
    }

    @DeleteMapping("/{nfcIdentify}")
    public void delete(String nfcIdentify) {
        checkpointService.delete(nfcIdentify);
    }

    @GetMapping("/findBySubsidiary/{subsidiaryId}")
    public List<CheckpointReduceDto> findBySubsidiary(Long subsidiaryId) {
        return checkpointService.findBySubsidiary(subsidiaryId).stream().map(CheckpointMapper.INSTANCE::toCheckpointReduceDto).toList();
    }


    public record CheckpointDto(
            String identificadorNFC,
            String latitud, String longitud, Long subsidiaryId
    ) {
    }

    public record CheckpointReduceDto(
            Long id,
            String identificadorNFC,
            String latitud, String longitud, Long subsidiaryId
    ) {
    }
}
