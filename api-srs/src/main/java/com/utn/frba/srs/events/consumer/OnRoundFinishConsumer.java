package com.utn.frba.srs.events.consumer;

import com.utn.frba.srs.constants.Constants;
import com.utn.frba.srs.events.producer.CatalogEvents;
import com.utn.frba.srs.events.producer.RoundFinishEvent;
import com.utn.frba.srs.model.RoundExecuteEvent;
import com.utn.frba.srs.model.User;
import com.utn.frba.srs.repository.RoundExecuteRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class OnRoundFinishConsumer {
    private final RoundExecuteRepository roundExecuteRepository;

    public OnRoundFinishConsumer(RoundExecuteRepository roundExecuteRepository) {
        this.roundExecuteRepository = roundExecuteRepository;
    }

    @KafkaListener(topics = CatalogEvents.ROUND_FINISH_EVENT,
            groupId = "group-id")
    public void execute(RoundFinishEvent.Data data) {
        var rondaEjecucion = roundExecuteRepository.findById(data.getRoundExecuteId()).orElse(null);
        if (rondaEjecucion == null) {
            return;
        }
        if (!rondaEjecucion.getState().equals(Constants.ROUND_EXECUTE_IN_PROGRESS)) {
            return;
        }
        rondaEjecucion.getEvents().add(RoundExecuteEvent.builder()
                .roundExecute(rondaEjecucion)
                .eventType(Constants.ROUND_EXECUTE_FINISH)
                .dateTimeEvent(LocalDateTime.now())
                .user(User.builder().id(data.getUserAgentId()).build())
                .build());
        rondaEjecucion.setState(Constants.ROUND_EXECUTE_FINISH);
        roundExecuteRepository.save(rondaEjecucion);
    }
}
