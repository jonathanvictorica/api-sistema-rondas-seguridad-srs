package com.utn.frba.srs.controller.contract;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/api/v1/srs/customers")
public interface CustomerController {
	record CustomerDto(
			String empresaSeguridadId,
			String razonSocial,
			String tipoDocumento,
			String nroDocumento,
			String nombreCalle,
			String altura,
			String departamento,
			String piso,
			String ciudad,
			String partido,
			String provincia,
			String pais,
			String latitud,
			String longitud
	) {
	}

	record CustomerReduceDto(
			Long id,
			String empresaSeguridadId,
			String razonSocial,
			String tipoDocumento,
			String nroDocumento,
			String nombreCalle,
			String altura,
			String departamento,
			String piso,
			String ciudad,
			String partido,
			String provincia,
			String pais,
			String latitud,
			String longitud
	) {
	}

	@PostMapping
	Long create(@RequestBody CustomerController.CustomerDto request);

	@PutMapping("/{customerId}")
	void update(@PathVariable("customerId") Long customerId, @RequestBody CustomerController.CustomerDto request);

	@DeleteMapping("/{customerId}")
	void delete(@PathVariable("customerId") Long customerId);

	@GetMapping("/all")
	List<CustomerController.CustomerReduceDto> all();

	@GetMapping("/findById/{customerId}")
	CustomerController.CustomerReduceDto findById(@PathVariable("customerId") Long customerId);

	@GetMapping("/findByDocument/{type}/{value}")
	CustomerController.CustomerReduceDto findByDocument(@PathVariable("type") String type, @PathVariable("value") String value);

}
