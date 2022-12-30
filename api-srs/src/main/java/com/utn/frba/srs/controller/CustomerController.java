package com.utn.frba.srs.controller;

import com.utn.frba.srs.mapper.CustomerMapper;
import com.utn.frba.srs.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/srs/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    Long create(@RequestBody CustomerDto request) {
        return customerService.create(CustomerMapper.INSTANCE.toClienteEmpresaSeguridad(request));

    }

    @PutMapping("/{customerId}")
    void update(@PathVariable("customerId") Long customerId, @RequestBody CustomerDto request) {
        customerService.update(CustomerMapper.INSTANCE.toClienteEmpresaSeguridad(request));

    }

    @DeleteMapping("/{customerId}")
    void delete(@PathVariable("customerId") Long customerId) {
        customerService.delete(customerId);

    }

    @GetMapping("/all")
    public List<CustomerReduceDto> all() {
        return customerService.all().stream().map(CustomerMapper.INSTANCE::toCustomerReduceDto).toList();

    }

    @GetMapping("/findById/{customerId}")
    CustomerReduceDto findById(@PathVariable("customerId") Long customerId) {
        return CustomerMapper.INSTANCE.toCustomerReduceDto(customerService.findById(customerId));

    }

    @GetMapping("/findByDocument/{type}/{value}")
    CustomerReduceDto findByDocument(@PathVariable("type") String type, @PathVariable("value") String value) {
        return CustomerMapper.INSTANCE.toCustomerReduceDto(customerService.findByDocument(type, value));

    }


    public record CustomerDto(
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

    public record CustomerReduceDto(
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
}
