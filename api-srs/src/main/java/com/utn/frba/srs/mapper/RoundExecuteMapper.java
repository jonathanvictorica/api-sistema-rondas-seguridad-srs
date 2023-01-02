package com.utn.frba.srs.mapper;


import com.utn.frba.srs.controller.RoundExecuteQueryController;
import com.utn.frba.srs.model.RoundExecute;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", uses = {RoundMapper.class, RoundExecuteEventMapper.class})
@Component
public interface RoundExecuteMapper {


    @Mappings({
            @Mapping(source = "events", target = "roundEvents"),
    })
    RoundExecuteQueryController.RoundExecuteDto toRoundExecuteDto(RoundExecute entity);

    @Mappings({
            @Mapping(source = "id", target = "roundExecuteId"),
            @Mapping(source = "round.id", target = "roundId")
    })
    RoundExecuteQueryController.RoundExecuteReduceDto toRoundExecuteReduceDto(RoundExecute entity);
}
