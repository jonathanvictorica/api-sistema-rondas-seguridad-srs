package com.utn.frba.srs.controller.impl;

import com.utn.frba.srs.controller.contract.CustomerController;
import com.utn.frba.srs.mapper.CompanySecurityMapper;
import com.utn.frba.srs.mapper.CustomerMapper;
import com.utn.frba.srs.service.CustomerService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerControllerImpl implements CustomerController {

    private final CustomerService customerService;

    public CustomerControllerImpl(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public Long create(CustomerDto request) {
        return customerService.create(CustomerMapper.INSTANCE.toClienteEmpresaSeguridad(request));

    }

    @Override
    public void update(Long customerId, CustomerDto request) {
        customerService.update(CustomerMapper.INSTANCE.toClienteEmpresaSeguridad(request));

    }

    @Override
    public void delete(Long customerId) {
        customerService.delete(customerId);

    }

    @Override
    public List<CustomerReduceDto> all() {
        return customerService.all().stream().map(CustomerMapper.INSTANCE::toCustomerReduceDto).toList();

    }

    @Override
    public CustomerReduceDto findById(Long customerId) {
        return CustomerMapper.INSTANCE.toCustomerReduceDto(customerService.findById(customerId));

    }

    @Override
    public CustomerReduceDto findByDocument(String type, String value) {
        return CustomerMapper.INSTANCE.toCustomerReduceDto(customerService.findByDocument(type, value));

    }
}
