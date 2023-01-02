package com.utn.frba.srs.job;

import com.utn.frba.srs.events.producer.PlanningRoundEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@EnableAsync
public class PlanningRoundScheduler {

    private final PlanningRoundEvent planningRoundEvent;

    public PlanningRoundScheduler(PlanningRoundEvent planningRoundEvent) {
        this.planningRoundEvent = planningRoundEvent;
    }

    @Async
    @Scheduled(fixedRate = 60000, initialDelay = 30000)
    public void scheduleRoundExecute() {
        planningRoundEvent.publishEvent(new PlanningRoundEvent.Data(LocalDateTime.now(), 5));
    }
}
