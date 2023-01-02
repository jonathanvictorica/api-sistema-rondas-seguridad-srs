package com.utn.frba.srs.events.producer;

import org.springframework.kafka.core.KafkaTemplate;

public abstract class EventProducer<D> {


    private final KafkaTemplate<Object, Object> template;

    protected EventProducer(KafkaTemplate<Object, Object> template) {
        this.template = template;
    }

    public void publishEvent(D eventData) {
        template.send(topic(), eventData);
    }

    protected abstract String topic();


}
