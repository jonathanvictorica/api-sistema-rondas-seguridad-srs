package com.utn.frba.srs.events.producer;

import lombok.Getter;
import lombok.Setter;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component
public class RoundStartEvent  extends EventProducer<RoundStartEvent.Data> {

    protected RoundStartEvent(KafkaTemplate<Object, Object> template) {
        super(template);
    }

    @Override
    protected String topic() {
        return CatalogEvents.ROUND_START_EVENT;
    }

    @Getter
    @Setter
    public static class Data implements Serializable {
        private Long roundExecuteId;
        private Long userAgentId;
    }
}
