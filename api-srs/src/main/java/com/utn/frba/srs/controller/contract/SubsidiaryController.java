package com.utn.frba.srs.controller.contract;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/api/v1/srs/subsidiary")
public interface SubsidiaryController {

	record SubsidiaryDto(
			 String nombre,
			 String descripcion,
			 String nombreCalle,
			 String altura,
			 String departamento,
			 String piso,
			 String ciudad,
			 String partido,
			 String provincia,
			 String pais ,
			 String latitud,
			 String longitud,
			Long clienteSeguridadId

	) {
	}

	record SubsidiaryReduceDto(
			Long id,
			String nombre,
			String descripcion,
			String nombreCalle,
			String altura,
			String departamento,
			String piso,
			String ciudad,
			String partido,
			String provincia,
			String pais ,
			String latitud,
			String longitud,
			Long clienteSeguridadId

	) {
	}

	@PostMapping
	Long create(@RequestBody SubsidiaryController.SubsidiaryDto request);

	@PutMapping("/{subsidiaryId}")
	void update(@PathVariable("subsidiaryId") Long subsidiaryId, @RequestBody SubsidiaryController.SubsidiaryDto request);

	@DeleteMapping("/{subsidiaryId}")
	void delete(@PathVariable("subsidiaryId") Long subsidiaryId);

	@GetMapping("/findByCustomer/{customerId}")
	List<SubsidiaryController.SubsidiaryReduceDto> findByCustomer(@PathVariable("customerId") Long customerId);

	@GetMapping("/findById/{subsidiaryId}")
	SubsidiaryController.SubsidiaryReduceDto findById(@PathVariable("subsidiaryId") Long subsidiaryId);


}
