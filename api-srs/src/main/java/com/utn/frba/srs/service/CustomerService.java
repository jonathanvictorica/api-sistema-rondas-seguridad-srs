package com.utn.frba.srs.service;

import com.utn.frba.srs.model.Customer;
import com.utn.frba.srs.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Long create(Customer clienteEmpresaSeguridad) {

        customerRepository.save(clienteEmpresaSeguridad);
        return clienteEmpresaSeguridad.getId();
    }

    public void update(Customer clienteEmpresaSeguridad) {
        customerRepository.save(clienteEmpresaSeguridad);
    }

    public void delete(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    public List<Customer> all() {
        return customerRepository.findAll();
    }

    public Customer findById(Long customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    public Customer findByDocument(String type, String value) {
        return customerRepository.findTop1ByDocumentTypeAndDocumentValue(type,value);
    }
}
