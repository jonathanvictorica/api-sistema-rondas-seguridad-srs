package com.utn.frba.srs.mapper;

import com.utn.frba.srs.controller.RoundController;
import com.utn.frba.srs.model.RondaRuta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RoundRutasMapper {

    RoundRutasMapper INSTANCE = Mappers.getMapper(RoundRutasMapper.class);

    @Mappings({
            @Mapping(source="latitud", target="ubicacion.latitud"),
            @Mapping(source="longitud", target="ubicacion.longitud"),
            @Mapping(source="order", target="ordenCaminoRuta")
    })
    RondaRuta toRoundRutas(RoundController.RoundRutaDto entity);

    @Mappings({
            @Mapping(target="latitud", source="ubicacion.latitud"),
            @Mapping(target="longitud", source="ubicacion.longitud"),
            @Mapping(target="order", source="ordenCaminoRuta")
    })
    RoundController.RoundRutaDto toRoundRutaDto(RondaRuta entity);
}
