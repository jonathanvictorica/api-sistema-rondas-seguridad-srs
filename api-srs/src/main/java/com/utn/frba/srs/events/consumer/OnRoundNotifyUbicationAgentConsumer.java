package com.utn.frba.srs.events.consumer;

import com.utn.frba.srs.constants.Constantes;
import com.utn.frba.srs.events.producer.CatalogEvents;
import com.utn.frba.srs.events.producer.RoundNotifyUbicationAgentEvent;
import com.utn.frba.srs.model.RondaEjecucionEvento;
import com.utn.frba.srs.model.Ubicacion;
import com.utn.frba.srs.model.User;
import com.utn.frba.srs.repository.RondaEjecucionEventoRepository;
import com.utn.frba.srs.repository.RondaEjecucionRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class OnRoundNotifyUbicationAgentConsumer {

    private final RondaEjecucionRepository rondaEjecucionRepository;

    private final RondaEjecucionEventoRepository rondaEjecucionEventoRepository;


    public OnRoundNotifyUbicationAgentConsumer(RondaEjecucionRepository rondaEjecucionRepository, RondaEjecucionEventoRepository rondaEjecucionEventoRepository) {
        this.rondaEjecucionRepository = rondaEjecucionRepository;
        this.rondaEjecucionEventoRepository = rondaEjecucionEventoRepository;
    }

    @KafkaListener(topics = CatalogEvents.RoundNotifyUbicationAgentEvent,
            groupId = "group-id")
    public void execute(RoundNotifyUbicationAgentEvent.Data data) {
        var rondaEjecucion = rondaEjecucionRepository.findById(data.getRoundExecuteId()).orElse(null);
        if (rondaEjecucion == null) {
            return;
        }
        if (!rondaEjecucion.getEstado().equals(Constantes.RONDA_EJECUCION_INPROGRESS)) {
            return;
        }
        var rondaEjecucionEvento = rondaEjecucionEventoRepository.findByRondaEjecucion_IdAndTipoEvento(data.getRoundExecuteId(), Constantes.RONDA_EJECUCION_UBICACION_AGENT);
        rondaEjecucionEventoRepository.save(RondaEjecucionEvento.builder()
                .rondaEjecucion(rondaEjecucion)
                .id(rondaEjecucionEvento != null ? rondaEjecucionEvento.getId() : null)
                .tipoEvento(Constantes.RONDA_EJECUCION_UBICACION_AGENT)
                .ubicacion(Ubicacion.builder().latitud(data.getLatitud()).longitud(data.getLongitud()).build())
                .fechaHoraEvento(LocalDateTime.now())
                .usuario(User.builder().id(data.getUserAgentId()).build())
                .build());
    }
}
