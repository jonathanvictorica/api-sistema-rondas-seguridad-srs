package com.utn.frba.srs.mapper;

import com.utn.frba.srs.controller.contract.CustomerController;
import com.utn.frba.srs.model.ClienteEmpresaSeguridad;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);



    @Mappings({
            @Mapping(source="razonSocial", target="razonSocial"),
            @Mapping(source="tipoDocumento", target="tipoDocumento"),
            @Mapping(source="nroDocumento", target="nroDocumento"),
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
            @Mapping(source="empresaSeguridadId", target="empresaSeguridad.id")

    })
    ClienteEmpresaSeguridad toClienteEmpresaSeguridad(CustomerController.CustomerDto entity);


    @Mappings({
            @Mapping(source="razonSocial", target="razonSocial"),
            @Mapping(source="tipoDocumento", target="tipoDocumento"),
            @Mapping(source="nroDocumento", target="nroDocumento"),
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
            @Mapping(target="empresaSeguridadId", source="empresaSeguridad.id")

    })
    CustomerController.CustomerReduceDto toCustomerReduceDto(ClienteEmpresaSeguridad entity) ;
}
