package com.utn.frba.srs.events.consumer;

import com.utn.frba.srs.constants.Constantes;
import com.utn.frba.srs.events.producer.CatalogEvents;
import com.utn.frba.srs.events.producer.RoundNotifyUbicationAgentEvent;
import com.utn.frba.srs.model.RoundExecuteEvent;
import com.utn.frba.srs.model.Ubiety;
import com.utn.frba.srs.model.User;
import com.utn.frba.srs.repository.RoundExecuteEventRepository;
import com.utn.frba.srs.repository.RoundExecuteRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class OnRoundNotifyUbicationAgentConsumer {

    private final RoundExecuteRepository roundExecuteRepository;

    private final RoundExecuteEventRepository roundExecuteEventRepository;


    public OnRoundNotifyUbicationAgentConsumer(RoundExecuteRepository roundExecuteRepository, RoundExecuteEventRepository roundExecuteEventRepository) {
        this.roundExecuteRepository = roundExecuteRepository;
        this.roundExecuteEventRepository = roundExecuteEventRepository;
    }

    @KafkaListener(topics = CatalogEvents.ROUND_NOTIFY_UBICATION_AGENT_EVENT,
            groupId = "group-id")
    public void execute(RoundNotifyUbicationAgentEvent.Data data) {
        var rondaEjecucion = roundExecuteRepository.findById(data.getRoundExecuteId()).orElse(null);
        if (rondaEjecucion == null) {
            return;
        }
        if (!rondaEjecucion.getState().equals(Constantes.RONDA_EJECUCION_INPROGRESS)) {
            return;
        }
        var rondaEjecucionEvento = roundExecuteEventRepository.findByRoundExecute_IdAndEventType(data.getRoundExecuteId(), Constantes.RONDA_EJECUCION_UBICACION_AGENT);
        roundExecuteEventRepository.save(RoundExecuteEvent.builder()
                .roundExecute(rondaEjecucion)
                .id(rondaEjecucionEvento != null ? rondaEjecucionEvento.getId() : null)
                .eventType(Constantes.RONDA_EJECUCION_UBICACION_AGENT)
                .ubiety(Ubiety.builder().latitude(data.getLatitude()).longitude(data.getLongitude()).build())
                .dateTimeEvent(LocalDateTime.now())
                .user(User.builder().id(data.getUserAgentId()).build())
                .build());
    }
}
