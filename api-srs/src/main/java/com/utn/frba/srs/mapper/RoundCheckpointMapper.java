package com.utn.frba.srs.mapper;

import com.utn.frba.srs.controller.RoundController;
import com.utn.frba.srs.model.RondaCheckPoint;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RoundCheckpointMapper {

    RoundCheckpointMapper INSTANCE = Mappers.getMapper(RoundCheckpointMapper.class);

    @Mappings({
            @Mapping(source="identificadorNFC", target="checkPoint.identificadorNFC"),
            @Mapping(source="order", target="ordenEjecucion")
    })
    RondaCheckPoint toRondaCheckPoint(RoundController.RoundCheckPointDto entity);

    @Mappings({
            @Mapping(target="identificadorNFC", source="checkPoint.identificadorNFC"),
            @Mapping(target="order", source="ordenEjecucion")
    })
    RoundController.RoundCheckPointDto toRoundCheckPointDto(RondaCheckPoint entity);
}
