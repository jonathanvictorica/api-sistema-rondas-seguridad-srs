package com.utn.frba.srs.mapper;

import com.utn.frba.srs.controller.RoundPlanningController;
import com.utn.frba.srs.model.RondaPlanificacion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RoundPlanningMapper {
    RoundPlanningMapper INSTANCE = Mappers.getMapper(RoundPlanningMapper.class);

    @Mappings({
            @Mapping(source="rondaId", target="ronda.id"),
            @Mapping(source="timeStart", target="horaInicio"),
            @Mapping(source="dayName", target="diaSemana")

    })
    RondaPlanificacion toRondaPlanificacion(RoundPlanningController.RoundPlanningDto entity);

    @Mappings({
            @Mapping(target="rondaId", source="ronda.id"),
            @Mapping(target="timeStart", source="horaInicio"),
            @Mapping(target="dayName", source="diaSemana")
    })
    RoundPlanningController.RoundPlanningReduceDto  toRoundPlanningDto(RondaPlanificacion entity);
}
