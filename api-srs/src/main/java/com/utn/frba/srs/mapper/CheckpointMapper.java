package com.utn.frba.srs.mapper;

import com.utn.frba.srs.controller.contract.CheckpointController;
import com.utn.frba.srs.model.CheckPoint;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CheckpointMapper {

    CheckpointMapper INSTANCE = Mappers.getMapper(CheckpointMapper.class);


    @Mappings({
            @Mapping(source="latitud", target="ubicacion.latitud"),
            @Mapping(source="longitud", target="ubicacion.longitud"),
            @Mapping(source="subsidiaryId", target="sucursalCliente.id")
    })
    CheckPoint toCheckpoint(CheckpointController.CheckpointDto entity);


    @Mappings({
            @Mapping(target="latitud", source="ubicacion.latitud"),
            @Mapping(target="longitud", source="ubicacion.longitud"),
            @Mapping(target="subsidiaryId", source="sucursalCliente.id")
    })
    CheckpointController.CheckpointReduceDto toCheckpointReduceDto(CheckPoint entity) ;
}
