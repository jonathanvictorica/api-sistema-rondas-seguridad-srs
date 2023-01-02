package com.utn.frba.srs.mapper;

import com.utn.frba.srs.controller.UserController;
import com.utn.frba.srs.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper {


    @Mappings({
            @Mapping(source="securityCompanyId", target="securityCompany.id")
    })
    User toUser(UserController.UsuarioDto entity);

    @Mappings({
            @Mapping(target="securityCompanyId", source= "securityCompany.id")
    })
    UserController.UsuarioReduceDto toUsuarioReduceDto(User entity) ;
}
