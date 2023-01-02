package com.utn.frba.srs.mapper;

import com.utn.frba.srs.controller.RoundExecuteQueryController;
import com.utn.frba.srs.model.RoundExecuteEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface RoundExecuteEventMapper {


    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nfcCode", target = "nfcCode"),
            @Mapping(source = "dateTimeEvent", target = "dateTimeEvent"),
            @Mapping(source = "eventType", target = "eventType"),
            @Mapping(source = "ubiety.latitude", target = "latitude"),
            @Mapping(source = "ubiety.longitude", target = "longitude"),
            @Mapping(source = "user.documentType", target = "userDocumentType"),
            @Mapping(source = "user.documentValue", target = "userDocumentNumber"),
            @Mapping(source = "user.name", target = "userName"),
            @Mapping(source = "user.lastname", target = "userLastname")
    })
    RoundExecuteQueryController.RoundExecuteEventDto toRoundExecuteEventDto(RoundExecuteEvent entity);
}
