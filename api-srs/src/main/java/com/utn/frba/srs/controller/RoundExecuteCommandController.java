package com.utn.frba.srs.controller;

import com.utn.frba.srs.events.producer.RoundFinishEvent;
import com.utn.frba.srs.events.producer.RoundMarkCheckpointEvent;
import com.utn.frba.srs.events.producer.RoundNotifyUbicationAgentEvent;
import com.utn.frba.srs.events.producer.RoundStartEvent;
import com.utn.frba.srs.mapper.EventMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/srs/round-execute")
public class RoundExecuteCommandController {

    private final RoundFinishEvent roundFinishEvent;
    private final RoundMarkCheckpointEvent roundMarkCheckpointEvent;
    private final RoundNotifyUbicationAgentEvent roundNotifyUbicationAgentEvent;
    private final RoundStartEvent roundStartEvent;

    public RoundExecuteCommandController(RoundFinishEvent roundFinishEvent, RoundMarkCheckpointEvent roundMarkCheckpointEvent, RoundNotifyUbicationAgentEvent roundNotifyUbicationAgentEvent, RoundStartEvent roundStartEvent) {
        this.roundFinishEvent = roundFinishEvent;
        this.roundMarkCheckpointEvent = roundMarkCheckpointEvent;
        this.roundNotifyUbicationAgentEvent = roundNotifyUbicationAgentEvent;
        this.roundStartEvent = roundStartEvent;
    }

    @PostMapping("/startRound")
    void startRound(StartRoundDto request) {
        roundStartEvent.publishEvent(EventMapper.INSTANCE.toRoundStartEvent(request));
    }

    @PostMapping("/markCheckpoint")
    void markCheckpoint(MarkCheckpointDto request) {
        roundMarkCheckpointEvent.publishEvent(EventMapper.INSTANCE.toRoundMarkCheckpointEvent(request));
    }

    @PostMapping("/finishRound")
    void finishRound(FinishRoundDto request) {
        roundFinishEvent.publishEvent(EventMapper.INSTANCE.toRoundFinishEvent(request));
    }



    @PostMapping("/notifyLocationAgentOnline")
    void notifyLocationAgentOnline(NotifyLocationAgentOnlineDto request) {
        roundNotifyUbicationAgentEvent.publishEvent(EventMapper.INSTANCE.toRoundNotifyUbicationAgentEvent(request));
    }


    public record StartRoundDto(

            Long roundExecuteId,
            Long userAgentId
    ) {

    }

    public record MarkCheckpointDto(
            Long roundExecuteId,
            Long userAgentId,
            String latitud,
            String longitud,
            String nfcIdentificador

    ) {

    }

    public	record FinishRoundDto(
            Long roundExecuteId,
            Long userAgentId

    ) {

    }

    public record NotifyLocationAgentOnlineDto(
            Long roundExecuteId,
            Long userAgentId,
            String latitud,
            String longitud
    ) {

    }
}
