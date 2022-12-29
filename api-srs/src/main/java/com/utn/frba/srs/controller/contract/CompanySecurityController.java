package com.utn.frba.srs.controller.contract;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/srs/company-security")
public interface CompanySecurityController {
	record CompanySecurityDto(
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
			String pais ,
			String latitud,
			String longitud

	) {
	}

	record CompanySecurityReduceDto(
			Long id,
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
			String pais ,
			String latitud,
			String longitud
	) {
	}

	@PostMapping
	Long create(@RequestBody CompanySecurityController.CompanySecurityDto request);

	@PutMapping("/{companySecurityId}")
	void update(@PathVariable("companySecurityId") Long companySecurityId, @RequestBody CompanySecurityController.CompanySecurityDto request);

	@DeleteMapping("/{companySecurityId}")
	void delete(@PathVariable("companySecurityId") Long companySecurityId);

	@GetMapping("/all")
	List<CompanySecurityController.CompanySecurityReduceDto> all();

	@GetMapping("/findById/{companySecurityId}")
	CompanySecurityController.CompanySecurityReduceDto findById(@PathVariable("companySecurityId") Long companySecurityId);

	@GetMapping("/findByDocument/{type}/{value}")
	CompanySecurityController.CompanySecurityReduceDto findByDocument(@PathVariable("type") String type, @PathVariable("value") String value);
}
