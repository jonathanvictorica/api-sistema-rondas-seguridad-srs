package com.utn.frba.srs.events.producer;

import lombok.Getter;
import lombok.Setter;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component
public class RoundMarkCheckpointEvent  extends EventProducer<RoundMarkCheckpointEvent.Data> {

    protected RoundMarkCheckpointEvent(KafkaTemplate<Object, Object> template) {
        super(template);
    }

    @Override
    protected String topic() {
        return CatalogEvents.ROUND_MARK_CHECKPOINT_EVENT;
    }

    @Getter
    @Setter
    public static class Data implements Serializable {
        private Long roundExecuteId;
        private Long userAgentId;
        private String latitude;
        private String longitude;
        private String nfcCode;

    }
}