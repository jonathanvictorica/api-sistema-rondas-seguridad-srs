package com.utn.frba.srs.events.consumer;

import com.utn.frba.srs.constants.Constantes;
import com.utn.frba.srs.events.producer.CatalogEvents;
import com.utn.frba.srs.events.producer.RoundFinishEvent;
import com.utn.frba.srs.model.RondaEjecucionEvento;
import com.utn.frba.srs.model.User;
import com.utn.frba.srs.repository.RondaEjecucionRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class OnRoundFinishConsumer {
    private final RondaEjecucionRepository rondaEjecucionRepository;

    public OnRoundFinishConsumer(RondaEjecucionRepository rondaEjecucionRepository) {
        this.rondaEjecucionRepository = rondaEjecucionRepository;
    }

    @KafkaListener(topics = CatalogEvents.RoundFinishEvent,
            groupId = "group-id")
    public void execute(RoundFinishEvent.Data data) {
        var rondaEjecucion = rondaEjecucionRepository.findById(data.getRoundExecuteId()).orElse(null);
        if (rondaEjecucion == null) {
            return;
        }
        if (!rondaEjecucion.getEstado().equals(Constantes.RONDA_EJECUCION_INPROGRESS)) {
            return;
        }
        rondaEjecucion.getEventos().add(RondaEjecucionEvento.builder()
                .rondaEjecucion(rondaEjecucion)
                .tipoEvento(Constantes.RONDA_EJECUCION_FINISH)
                .fechaHoraEvento(LocalDateTime.now())
                .usuario(User.builder().id(data.getUserAgentId()).build())
                .build());
        rondaEjecucion.setEstado(Constantes.RONDA_EJECUCION_FINISH);
        rondaEjecucionRepository.save(rondaEjecucion);
    }
}
