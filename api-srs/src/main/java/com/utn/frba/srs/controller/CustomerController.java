package com.utn.frba.srs.controller;

import com.utn.frba.srs.mapper.CustomerMapper;
import com.utn.frba.srs.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/srs/customers")
public class CustomerController {

    private final CustomerService customerService;

    private final CustomerMapper mapper;

    public CustomerController(CustomerService customerService, CustomerMapper mapper) {
        this.customerService = customerService;
        this.mapper = mapper;
    }

    @PostMapping
    Long create(@RequestBody CustomerDto request) {
        return customerService.create(mapper.toCustomer(request));

    }

    @PutMapping
    void update( @RequestBody CustomerDto request) {
        customerService.update(mapper.toCustomer(request));

    }

    @DeleteMapping("/{customerId}")
    void delete(@PathVariable("customerId") Long customerId) {
        customerService.delete(customerId);

    }

    @GetMapping("/all")
    public List<CustomerReduceDto> all() {
        return customerService.all().stream().map(mapper::toCustomerReduceDto).toList();

    }

    @GetMapping("/findById/{customerId}")
    CustomerReduceDto findById(@PathVariable("customerId") Long customerId) {
        return mapper.toCustomerReduceDto(customerService.findById(customerId));

    }

    @GetMapping("/findByDocument/{type}/{value}")
    CustomerReduceDto findByDocument(@PathVariable("type") String type, @PathVariable("value") String value) {
        return mapper.toCustomerReduceDto(customerService.findByDocument(type, value));

    }


    public record CustomerDto(
            Long securityCompanyId,
            String businessName,
            String documentType,
            String documentValue,
            String streetName,
            String streetNumber,
            String apartment,
            String flat,
            String city,
            String party,
            String province,
            String latitude,
            String longitude
    ) {
    }

    public record CustomerReduceDto(
            Long id,
            Long securityCompanyId,
            String businessName,
            String documentType,
            String documentValue,
            String streetName,
            String streetNumber,
            String apartment,
            String flat,
            String city,
            String party,
            String province,
            String latitude,
            String longitude
    ) {
    }
}
