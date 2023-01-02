package com.utn.frba.srs.events.consumer;

import com.utn.frba.srs.constants.Constants;
import com.utn.frba.srs.events.producer.CatalogEvents;
import com.utn.frba.srs.events.producer.PlanningRoundEvent;
import com.utn.frba.srs.model.RoundExecute;
import com.utn.frba.srs.repository.RoundExecuteRepository;
import com.utn.frba.srs.repository.RoundPlanningRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.MINUTES;

@Component
public class OnPlanningRoundConsumer {

    private final RoundPlanningRepository roundPlanningRepository;
    private final RoundExecuteRepository roundExecuteRepository;

    public OnPlanningRoundConsumer(RoundPlanningRepository roundPlanningRepository, RoundExecuteRepository roundExecuteRepository) {
        this.roundPlanningRepository = roundPlanningRepository;
        this.roundExecuteRepository = roundExecuteRepository;
    }

    @KafkaListener(topics = CatalogEvents.PLANNING_ROUND_EVENT,
            groupId = "group-id")
    public void execute(PlanningRoundEvent.Data data) {
        var plannings = roundPlanningRepository.findByDiaSemanaAndHoraInicioBetween(data.getStartPlanning().getDayOfWeek().name(), data.getStartPlanning().toLocalTime(), data.getStartPlanning().plus(data.getMinutesPlanning(), MINUTES).toLocalTime());
        plannings.forEach(rondaPlanificacion ->
        {
            var result = roundExecuteRepository.findByRound_IdAndDateTimeStartBetween(rondaPlanificacion.getRound().getId(), data.getStartPlanning().plus(-1 * data.getMinutesPlanning(), MINUTES), data.getStartPlanning().plus(data.getMinutesPlanning(), MINUTES));
            if (result.isEmpty()) {
                RoundExecute.RoundExecuteBuilder rondaEjecucion = RoundExecute.builder();
                rondaEjecucion.round(rondaPlanificacion.getRound());
                rondaEjecucion.state(Constants.ROUND_EXECUTE_PENDING);
                rondaEjecucion.dateTimeStart(LocalDateTime.of(LocalDate.now(), rondaPlanificacion.getHoraInicio()));
                roundExecuteRepository.save(rondaEjecucion.build());
            }
        });
    }
}
