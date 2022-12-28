package com.utn.frba.srs.controller.contract;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/srs/users")
interface UserController {

	record UsuarioDto() {
	}


	record UsuarioReduceDto() {
	}

	@PostMapping
	Long create(@RequestBody UserController.UsuarioDto request);

	@PutMapping("/{userId}")
	void update(@PathVariable("userId") Long userId, @RequestBody UserController.UsuarioDto request);

	@DeleteMapping("/{userId}")
	void delete(@PathVariable("userId") Long userId);

	@GetMapping("/findByEmpresa/{empresaId}")
	List<UserController.UsuarioReduceDto> findByEmpresa(@PathVariable("empresaId") Long empresaId);

	@GetMapping("/findById/{userId}")
	UserController.UsuarioReduceDto findById(@PathVariable("userId") Long userId);

	@GetMapping("/findByDocument/{type}/{value}")
	UserController.UsuarioReduceDto findByDocument(@PathVariable("type") String type, @PathVariable("value") String value);

	@GetMapping("/findByRol/{rol}")
	List<UserController.UsuarioReduceDto> findByRol(@PathVariable("rol") String rol);

	@GetMapping("/roles")
	List<String> roles();


	@GetMapping("/findLockUsers")
	List<UserController.UsuarioReduceDto> findLockUsers();

}
