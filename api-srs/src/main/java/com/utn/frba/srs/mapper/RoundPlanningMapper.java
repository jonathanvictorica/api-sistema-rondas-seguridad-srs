package com.utn.frba.srs.mapper;

import com.utn.frba.srs.controller.RoundPlanningController;
import com.utn.frba.srs.model.RoundPlanning;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface RoundPlanningMapper {


    @Mappings({
            @Mapping(source="rondaId", target="round.id"),
            @Mapping(source="timeStart", target="horaInicio"),
            @Mapping(source="dayName", target="diaSemana")

    })
    RoundPlanning toRoundPlanning(RoundPlanningController.RoundPlanningDto entity);

    @Mappings({
            @Mapping(target="rondaId", source= "round.id"),
            @Mapping(target="timeStart", source="horaInicio"),
            @Mapping(target="dayName", source="diaSemana")
    })
    RoundPlanningController.RoundPlanningReduceDto  toRoundPlanningDto(RoundPlanning entity);
}
