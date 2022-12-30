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

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    Long create(@RequestBody UsuarioDto request) {
        return userService.create(UserMapper.INSTANCE.toUser(request));
    }

    @PutMapping("/{userId}")
    void update(@PathVariable("userId") Long userId, @RequestBody UsuarioDto request) {
        userService.update(UserMapper.INSTANCE.toUser(request));
    }

    @DeleteMapping("/{userId}")
    void delete(@PathVariable("userId") Long userId) {
        userService.delete(userId);
    }

    @GetMapping("/findByEmpresa/{empresaId}")
    List<UsuarioReduceDto> findByEmpresa(@PathVariable("empresaId") Long empresaId) {
        return userService.findByEmpresa(empresaId).stream().map(UserMapper.INSTANCE::toUsuarioReduceDto).collect(Collectors.toList());
    }

    @GetMapping("/findByRol/{rol}")
    List<UsuarioReduceDto> findByRol(@PathVariable("rol") String rol) {
        return userService.findByRol(rol).stream().map(UserMapper.INSTANCE::toUsuarioReduceDto).collect(Collectors.toList());
    }

    @GetMapping("/findById/{userId}")
    UsuarioReduceDto findById(@PathVariable("userId") Long userId) {
        return UserMapper.INSTANCE.toUsuarioReduceDto(userService.findById(userId));
    }

    @GetMapping("/findByDocument/{type}/{value}")
    UsuarioReduceDto findByDocument(@PathVariable("type") String type, @PathVariable("value") String value) {
        return UserMapper.INSTANCE.toUsuarioReduceDto(userService.findByDocument(type, value));
    }

    @GetMapping("/roles")
    public List<String> roles() {
        return Arrays.asList(Constantes.ROL_ADMIN, Constantes.ROL_VIGILANTE, Constantes.ROL_SUPERVISOR);
    }


   public record UsuarioDto(
            Long empresaSeguridadId,
            String nombre,
            String apellido,
            String tipoDocumento,
            String nroDocumento,
            String mail ,
            String rolPrincipal,
            Boolean usuarioActivo
    ) {
    }


    public record UsuarioReduceDto(
            Long id,
            Long empresaSeguridadId,
            String nombre,
            String apellido,
            String tipoDocumento,
            String nroDocumento,
            String mail ,
            String rolPrincipal,
            Boolean usuarioActivo
    ) {
    }
}
