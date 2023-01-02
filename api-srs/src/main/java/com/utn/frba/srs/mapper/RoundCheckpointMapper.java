package com.utn.frba.srs.mapper;

import com.utn.frba.srs.controller.RoundController;
import com.utn.frba.srs.model.RoundCheckpoint;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface RoundCheckpointMapper {


    @Mappings({
            @Mapping(source="nfcCode", target="checkpoint.nfcCode"),
            @Mapping(source="executionOrder", target="executionOrder")
    })
    RoundCheckpoint toRondaCheckPoint(RoundController.RoundCheckPointDto entity);

    @Mappings({
            @Mapping(target="nfcCode", source="checkpoint.nfcCode"),
            @Mapping(target="executionOrder", source="executionOrder")
    })
    RoundController.RoundCheckPointDto toRoundCheckPointDto(RoundCheckpoint entity);
}
