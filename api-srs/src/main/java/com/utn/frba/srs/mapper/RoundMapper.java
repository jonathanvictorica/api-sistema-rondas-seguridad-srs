package com.utn.frba.srs.mapper;

import com.utn.frba.srs.controller.RoundController;
import com.utn.frba.srs.model.Ronda;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",uses = {RoundCheckpointMapper.class,RoundRutasMapper.class})
public interface RoundMapper {

    RoundMapper INSTANCE = Mappers.getMapper(RoundMapper.class);


    @Mappings({
            @Mapping(source="sucursalClienteId", target="sucursalCliente.id"),
            @Mapping(source="nombre", target="nombre"),
            @Mapping(source="descripcion", target="descripcion"),
            @Mapping(source="latitudCentral", target="ubicacionCentral.latitud"),
            @Mapping(source="longitudCentral", target="ubicacionCentral.longitud"),
            @Mapping(source="ubicacionZoom", target="ubicacionZoom"),
            @Mapping(source="checkpoints", target="checkpoints"),
            @Mapping(source="rutas", target="rutas")
    })
    Ronda toRonda(RoundController.RoundDto entity);

    @Mappings({
            @Mapping(target="sucursalClienteId", source="sucursalCliente.id"),
            @Mapping(target="nombre", source="nombre"),
            @Mapping(target="descripcion", source="descripcion"),
            @Mapping(target="latitudCentral", source="ubicacionCentral.latitud"),
            @Mapping(target="longitudCentral", source="ubicacionCentral.longitud"),
            @Mapping(target="ubicacionZoom", source="ubicacionZoom"),
            @Mapping(target="checkpoints", source="checkpoints"),
            @Mapping(source="rutas", target="rutas")
    })
    RoundController.RoundReduceDto toRoundReduceDto(Ronda entity);
}
