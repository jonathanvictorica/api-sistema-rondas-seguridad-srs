package com.utn.frba.srs.controller;

import com.utn.frba.srs.mapper.RoundExecuteMapper;
import com.utn.frba.srs.service.RoundExecuteQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/api/v1/srs/round-execute")
@RestController
public class RoundExecuteQueryController {

    private final RoundExecuteQueryService roundExecuteQueryService;

    private final RoundExecuteMapper mapper;

    public RoundExecuteQueryController(RoundExecuteQueryService roundExecuteQueryService, RoundExecuteMapper mapper) {
        this.roundExecuteQueryService = roundExecuteQueryService;
        this.mapper = mapper;
    }


    @GetMapping("/findOnlineById/{roundExecuteId}")
    RoundExecuteQueryController.RoundExecuteDto findOnlineById(@PathVariable Long roundExecuteId) {
        return mapper.toRoundExecuteDto(roundExecuteQueryService.findOnlineById(roundExecuteId));
    }

    @GetMapping("/findRoundPendingBySubsidiary/{subsidiaryId}")
    RoundExecuteReduceListDto findRoundPendingBySubsidiary(@PathVariable Long subsidiaryId) {
        return new RoundExecuteReduceListDto(roundExecuteQueryService.findRoundPendingBySubsidiary(subsidiaryId).stream().map(mapper::toRoundExecuteReduceDto).toList());
    }

    @GetMapping("/findByStateRevision")
    RoundExecuteReduceListDto findByStateRevision() {
        return new RoundExecuteReduceListDto(roundExecuteQueryService.findByStateRevision().stream().map(mapper::toRoundExecuteReduceDto).toList());
    }

    public record RoundExecuteDto(
            Long id,
            RoundController.RoundDto round,
            LocalDateTime dateTimeInit,
            String state,
            List<RoundExecuteEventDto> roundEvents
    ) {

    }

    public record RoundExecuteEventDto(
            Long id,
            LocalDateTime dateTimeEvent,
            String eventType,
            String nfcCode,
            String latitude,
            String longitude,
            String userName,
            String userLastname,
            String userDocumentType,
            String userDocumentNumber
    ) {
    }


    public record RoundExecuteReduceDto(
            Long roundExecuteId,
            Long roundId
    ) {
    }

    public record RoundExecuteReduceListDto(List<RoundExecuteReduceDto> roundExecutes) {

    }
}
