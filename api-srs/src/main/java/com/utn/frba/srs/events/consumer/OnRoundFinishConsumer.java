package com.utn.frba.srs.events.consumer;

import com.utn.frba.srs.constants.Constantes;
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
        if (!rondaEjecucion.getState().equals(Constantes.RONDA_EJECUCION_INPROGRESS)) {
            return;
        }
        rondaEjecucion.getEvents().add(RoundExecuteEvent.builder()
                .roundExecute(rondaEjecucion)
                .eventType(Constantes.RONDA_EJECUCION_FINISH)
                .dateTimeEvent(LocalDateTime.now())
                .user(User.builder().id(data.getUserAgentId()).build())
                .build());
        rondaEjecucion.setState(Constantes.RONDA_EJECUCION_FINISH);
        roundExecuteRepository.save(rondaEjecucion);
    }
}
