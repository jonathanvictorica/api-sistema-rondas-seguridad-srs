package com.utn.frba.srs.events.producer;

import lombok.Getter;
import lombok.Setter;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component
public class RoundNotifyUbicationAgentEvent  extends EventProducer<RoundNotifyUbicationAgentEvent.Data> {

    protected RoundNotifyUbicationAgentEvent(KafkaTemplate<Object, Object> template) {
        super(template);
    }

    @Override
    protected String topic() {
        return CatalogEvents.RoundNotifyUbicationAgentEvent;
    }

    @Getter
    @Setter
    public static class Data implements Serializable {
        private Long roundExecuteId;
        private Long userAgentId;
        private String latitud;
        private String longitud;
    }
}