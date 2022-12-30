package com.utn.frba.srs.events.consumer;

import com.utn.frba.srs.constants.Constantes;
import com.utn.frba.srs.events.producer.CatalogEvents;
import com.utn.frba.srs.events.producer.RoundMarkCheckpointEvent;
import com.utn.frba.srs.model.RondaEjecucionEvento;
import com.utn.frba.srs.model.Ubicacion;
import com.utn.frba.srs.model.User;
import com.utn.frba.srs.repository.RondaEjecucionRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class OnRoundMarkCheckpointConsumer {
    private final RondaEjecucionRepository rondaEjecucionRepository;

    public OnRoundMarkCheckpointConsumer(RondaEjecucionRepository rondaEjecucionRepository) {
        this.rondaEjecucionRepository = rondaEjecucionRepository;
    }

    @KafkaListener(topics = CatalogEvents.RoundMarkCheckpointEvent,
            groupId = "group-id")
    public void execute(RoundMarkCheckpointEvent.Data data) {
        var rondaEjecucion = rondaEjecucionRepository.findById(data.getRoundExecuteId()).orElse(null);
        if (rondaEjecucion == null) {
            return;
        }
        if (!rondaEjecucion.getEstado().equals(Constantes.RONDA_EJECUCION_INPROGRESS)) {
            return;
        }
        rondaEjecucion.getEventos().add(RondaEjecucionEvento.builder()
                .rondaEjecucion(rondaEjecucion)
                .tipoEvento(Constantes.RONDA_EJECUCION_MARK_CHECKPOINT)
                .checkpointIdentificadorNFC(data.getNfcIdentificador())
                .ubicacion(Ubicacion.builder().latitud(data.getLatitud()).longitud(data.getLongitud()).build())
                .fechaHoraEvento(LocalDateTime.now())
                .usuario(User.builder().id(data.getUserAgentId()).build())
                .build());
        rondaEjecucionRepository.save(rondaEjecucion);
    }
}
