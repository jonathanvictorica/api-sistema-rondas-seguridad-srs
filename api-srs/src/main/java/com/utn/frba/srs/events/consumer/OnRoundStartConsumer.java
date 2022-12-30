package com.utn.frba.srs.events.consumer;

import com.utn.frba.srs.constants.Constantes;
import com.utn.frba.srs.events.producer.CatalogEvents;
import com.utn.frba.srs.events.producer.RoundStartEvent;
import com.utn.frba.srs.model.RondaEjecucionEvento;
import com.utn.frba.srs.model.User;
import com.utn.frba.srs.repository.RondaEjecucionRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Component
public class OnRoundStartConsumer {

    private final RondaEjecucionRepository rondaEjecucionRepository;

    public OnRoundStartConsumer(RondaEjecucionRepository rondaEjecucionRepository) {
        this.rondaEjecucionRepository = rondaEjecucionRepository;
    }

    @KafkaListener(topics = CatalogEvents.RoundStartEvent,
            groupId = "group-id")
    public void execute(RoundStartEvent.Data data) {
        var rondaEjecucion = rondaEjecucionRepository.findById(data.getRoundExecuteId()).orElse(null);
        if (rondaEjecucion == null) {
            return;
        }
        if(!rondaEjecucion.getEstado().equals(Constantes.RONDA_EJECUCION_PENDIENTE)){
            return;
        }
        rondaEjecucion.setEventos(new ArrayList<>());
        rondaEjecucion.getEventos().add(RondaEjecucionEvento.builder()
                        .rondaEjecucion(rondaEjecucion)
                        .tipoEvento(Constantes.RONDA_EJECUCION_START)
                        .fechaHoraEvento(LocalDateTime.now())
                        .usuario(User.builder().id(data.getUserAgentId()).build())
                .build());
        rondaEjecucion.setEstado(Constantes.RONDA_EJECUCION_INPROGRESS);
        rondaEjecucionRepository.save(rondaEjecucion);
    }
}
