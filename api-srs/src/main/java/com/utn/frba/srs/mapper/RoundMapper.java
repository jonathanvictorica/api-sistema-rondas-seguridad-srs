package com.utn.frba.srs.mapper;

import com.utn.frba.srs.controller.RoundController;
import com.utn.frba.srs.model.Round;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", uses = {RoundCheckpointMapper.class, RoundRouteMapper.class})
@Component
public interface RoundMapper {


    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "subsidiaryId", target = "subsidiary.id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "checkpoints", target = "checkpoints"),
            @Mapping(source = "routes", target = "routes")
    })
    Round toRound(RoundController.RoundDto entity);

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "subsidiaryId", source = "subsidiary.id"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "description", source = "description"),
            @Mapping(target = "checkpoints", source = "checkpoints"),
            @Mapping(target = "routes", source = "routes")
    })
    RoundController.RoundReduceDto toRoundReduceDto(Round entity);
}
