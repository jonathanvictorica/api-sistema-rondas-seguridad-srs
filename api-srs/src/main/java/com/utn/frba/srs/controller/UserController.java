package com.utn.frba.srs.controller;

import com.utn.frba.srs.constants.Constantes;
import com.utn.frba.srs.mapper.UserMapper;
import com.utn.frba.srs.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    private final UserService userService;
    private final UserMapper mapper;

    public UserController(UserService userService, UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @PostMapping
    Long create(@RequestBody UsuarioDto request) {
        return userService.create(mapper.toUser(request));
    }

    @PutMapping("/{userId}")
    void update(@PathVariable("userId") Long userId, @RequestBody UsuarioDto request) {
        userService.update(mapper.toUser(request));
    }

    @DeleteMapping("/{userId}")
    void delete(@PathVariable("userId") Long userId) {
        userService.delete(userId);
    }

    @GetMapping("/findByEmpresa/{empresaId}")
    List<UsuarioReduceDto> findByEmpresa(@PathVariable("empresaId") Long empresaId) {
        return userService.findByEmpresa(empresaId).stream().map(mapper::toUsuarioReduceDto).collect(Collectors.toList());
    }

    @GetMapping("/findByRol/{rol}")
    List<UsuarioReduceDto> findByRol(@PathVariable("rol") String rol) {
        return userService.findByRol(rol).stream().map(mapper::toUsuarioReduceDto).collect(Collectors.toList());
    }

    @GetMapping("/findById/{userId}")
    UsuarioReduceDto findById(@PathVariable("userId") Long userId) {
        return mapper.toUsuarioReduceDto(userService.findById(userId));
    }

    @GetMapping("/findByDocument/{type}/{value}")
    UsuarioReduceDto findByDocument(@PathVariable("type") String type, @PathVariable("value") String value) {
        return mapper.toUsuarioReduceDto(userService.findByDocument(type, value));
    }

    @GetMapping("/roles")
    public List<String> roles() {
        return Arrays.asList(Constantes.ROL_ADMIN, Constantes.ROL_VIGILANTE, Constantes.ROL_SUPERVISOR);
    }


   public record UsuarioDto(
            Long securityCompanyId,
            String name,
            String lastname,
            String documentType,
            String documentValue,
            String mail ,
            String rol,
            Boolean active
    ) {
    }


    public record UsuarioReduceDto(
            Long id,
            Long securityCompanyId,
            String name,
            String lastname,
            String documentType,
            String documentValue,
            String mail ,
            String rol,
            Boolean active
    ) {
    }
}
