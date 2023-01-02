package com.utn.frba.srs.mapper;

import com.utn.frba.srs.controller.RoundController;
import com.utn.frba.srs.model.RoundRoute;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface RoundRouteMapper {


    @Mappings({
            @Mapping(source = "latitude", target = "ubiety.latitude"),
            @Mapping(source = "longitude", target = "ubiety.longitude"),
            @Mapping(source = "order", target = "ordenCaminoRuta")
    })
    RoundRoute toRoundRoute(RoundController.RoundRouteDto entity);

    @Mappings({
            @Mapping(target = "latitude", source = "ubiety.latitude"),
            @Mapping(target = "longitude", source = "ubiety.longitude"),
            @Mapping(target = "order", source = "ordenCaminoRuta")
    })
    RoundController.RoundRouteDto toRoundRutaDto(RoundRoute entity);
}
