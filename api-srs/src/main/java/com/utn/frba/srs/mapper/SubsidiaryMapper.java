package com.utn.frba.srs.mapper;

import com.utn.frba.srs.controller.contract.CheckpointController;
import com.utn.frba.srs.controller.contract.SubsidiaryController;
import com.utn.frba.srs.model.CheckPoint;
import com.utn.frba.srs.model.SucursalCliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SubsidiaryMapper {

    SubsidiaryMapper INSTANCE = Mappers.getMapper(SubsidiaryMapper.class);


    @Mappings({
            @Mapping(source="nombre", target="nombre"),
            @Mapping(source="descripcion", target="descripcion"),
            @Mapping(source="nombreCalle", target="domicilio.nombreCalle"),
            @Mapping(source="altura", target="domicilio.altura"),
            @Mapping(source="departamento", target="domicilio.departamento"),
            @Mapping(source="piso", target="domicilio.piso"),
            @Mapping(source="ciudad", target="domicilio.ciudad"),
            @Mapping(source="partido", target="domicilio.partido"),
            @Mapping(source="provincia", target="domicilio.provincia"),
            @Mapping(source="pais", target="domicilio.pais"),
            @Mapping(source="latitud", target="domicilio.ubicacion.latitud"),
            @Mapping(source="longitud", target="domicilio.ubicacion.longitud"),
            @Mapping(source="clienteSeguridadId", target="clienteEmpresaSeguridad.id")

    })
    SucursalCliente toSucursalCliente(SubsidiaryController.SubsidiaryDto entity);


    @Mappings({
            @Mapping(target="nombre", source="nombre"),
            @Mapping(target="descripcion", source="descripcion"),
            @Mapping(target="nombreCalle", source="domicilio.nombreCalle"),
            @Mapping(target="altura", source="domicilio.altura"),
            @Mapping(target="departamento", source="domicilio.departamento"),
            @Mapping(target="piso", source="domicilio.piso"),
            @Mapping(target="ciudad", source="domicilio.ciudad"),
            @Mapping(target="partido", source="domicilio.partido"),
            @Mapping(target="provincia", source="domicilio.provincia"),
            @Mapping(target="pais", source="domicilio.pais"),
            @Mapping(target="latitud", source="domicilio.ubicacion.latitud"),
            @Mapping(target="longitud", source="domicilio.ubicacion.longitud"),
            @Mapping(target="clienteSeguridadId", source="clienteEmpresaSeguridad.id")

    })
    SubsidiaryController.SubsidiaryReduceDto toSubsidiaryReduceDto(SucursalCliente entity) ;
}
