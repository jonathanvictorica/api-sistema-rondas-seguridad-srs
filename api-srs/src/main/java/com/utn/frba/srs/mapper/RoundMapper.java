package com.utn.frba.srs.mapper;

import com.utn.frba.srs.controller.contract.RoundController;
import com.utn.frba.srs.model.Ronda;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RoundMapper {

    RoundMapper INSTANCE = Mappers.getMapper(RoundMapper.class);


    @Mappings({
            @Mapping(source="sucursalClienteId", target="sucursalCliente.id"),
            @Mapping(source="nombre", target="nombre"),
            @Mapping(source="descripcion", target="descripcion"),
            @Mapping(source="latitudCentral", target="ubicacionCentral.latitud"),
            @Mapping(source="longitudCentral", target="ubicacionCentral.longitud"),
            @Mapping(source="ubicacionZoom", target="ubicacionZoom"),
            @Mapping(source="checkpoints.identificadorNFC", target="checkpoints.checkPoint.identificadorNFC"),
            @Mapping(source="checkpoints.order", target="checkpoints.ordenEjecucion"),
            @Mapping(source="rutas.latitud", target="rutas.ubicacion.latitud"),
            @Mapping(source="rutas.longitud", target="rutas.ubicacion.longitud"),
            @Mapping(source="rutas.order", target="rutas.ordenCaminoRuta")
    })
    Ronda toRonda(RoundController.RoundDto entity);

    @Mappings({
            @Mapping(target="sucursalClienteId", source="sucursalCliente.id"),
            @Mapping(target="nombre", source="nombre"),
            @Mapping(target="descripcion", source="descripcion"),
            @Mapping(target="latitudCentral", source="ubicacionCentral.latitud"),
            @Mapping(target="longitudCentral", source="ubicacionCentral.longitud"),
            @Mapping(target="ubicacionZoom", source="ubicacionZoom"),
            @Mapping(target="checkpoints.identificadorNFC", source="checkpoints.checkPoint.identificadorNFC"),
            @Mapping(target="checkpoints.order", source="checkpoints.ordenEjecucion"),
            @Mapping(target="rutas.latitud", source="rutas.ubicacion.latitud"),
            @Mapping(target="rutas.longitud", source="rutas.ubicacion.longitud"),
            @Mapping(target="rutas.order", source="rutas.ordenCaminoRuta")
    })
    RoundController.RoundReduceDto toRoundReduceDto(Ronda entity);
}
