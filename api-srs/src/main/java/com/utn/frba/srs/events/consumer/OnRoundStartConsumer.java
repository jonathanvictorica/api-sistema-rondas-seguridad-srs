package com.utn.frba.srs.events.consumer;

import com.utn.frba.srs.constants.Constants;
import com.utn.frba.srs.events.producer.CatalogEvents;
import com.utn.frba.srs.events.producer.RoundStartEvent;
import com.utn.frba.srs.model.RoundExecuteEvent;
import com.utn.frba.srs.model.User;
import com.utn.frba.srs.repository.RoundExecuteRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Component
public class OnRoundStartConsumer {

    private final RoundExecuteRepository roundExecuteRepository;

    public OnRoundStartConsumer(RoundExecuteRepository roundExecuteRepository) {
        this.roundExecuteRepository = roundExecuteRepository;
    }

    @KafkaListener(topics = CatalogEvents.ROUND_START_EVENT,
            groupId = "group-id")
    public void execute(RoundStartEvent.Data data) {
        var rondaEjecucion = roundExecuteRepository.findById(data.getRoundExecuteId()).orElse(null);
        if (rondaEjecucion == null) {
            return;
        }
        if (!rondaEjecucion.getState().equals(Constants.ROUND_EXECUTE_PENDING)) {
            return;
        }
        rondaEjecucion.setEvents(new ArrayList<>());
        rondaEjecucion.getEvents().add(RoundExecuteEvent.builder()
                .roundExecute(rondaEjecucion)
                .eventType(Constants.ROUND_EXECUTE_START)
                .dateTimeEvent(LocalDateTime.now())
                .user(User.builder().id(data.getUserAgentId()).build())
                .build());
        rondaEjecucion.setState(Constants.ROUND_EXECUTE_IN_PROGRESS);
        roundExecuteRepository.save(rondaEjecucion);
    }
}
