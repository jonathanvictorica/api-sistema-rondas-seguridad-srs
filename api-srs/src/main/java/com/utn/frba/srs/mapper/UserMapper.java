package com.utn.frba.srs.mapper;

import com.utn.frba.srs.controller.UserController;
import com.utn.frba.srs.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    @Mappings({
            @Mapping(source="empresaSeguridadId", target="empresaSeguridad.id")
    })
    User toUser(UserController.UsuarioDto entity);

    @Mappings({
            @Mapping(target="empresaSeguridadId", source="empresaSeguridad.id")
    })
    UserController.UsuarioReduceDto toUsuarioReduceDto(User entity) ;
}
