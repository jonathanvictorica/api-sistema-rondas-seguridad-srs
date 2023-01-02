package com.utn.frba.srs.events.producer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.kafka.core.KafkaTemplate;

import java.io.Serializable;
import java.time.LocalDateTime;

public class PlanningRoundEvent extends EventProducer<PlanningRoundEvent.Data> {


    protected PlanningRoundEvent(KafkaTemplate<Object, Object> template) {
        super(template);
    }

    @Override
    protected String topic() {
        return CatalogEvents.PLANNING_ROUND_EVENT;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Data implements Serializable {
        private LocalDateTime startPlanning;
        private Integer minutesPlanning;

    }

}
