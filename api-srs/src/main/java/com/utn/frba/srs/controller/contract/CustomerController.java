package com.utn.frba.srs.controller.contract;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/api/v1/srs/customers")
interface CustomerController {
	record CustomerDto() {
	}

	record CustomerReduceDto() {
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
