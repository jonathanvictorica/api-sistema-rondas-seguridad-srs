package com.utn.frba.srs.service;

import com.utn.frba.srs.model.ClienteEmpresaSeguridad;
import com.utn.frba.srs.repository.ClienteEmpresaSeguridadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final ClienteEmpresaSeguridadRepository clienteEmpresaSeguridadRepository;

    public CustomerService(ClienteEmpresaSeguridadRepository clienteEmpresaSeguridadRepository) {
        this.clienteEmpresaSeguridadRepository = clienteEmpresaSeguridadRepository;
    }

    public Long create(ClienteEmpresaSeguridad clienteEmpresaSeguridad) {

        clienteEmpresaSeguridadRepository.save(clienteEmpresaSeguridad);
        return clienteEmpresaSeguridad.getId();
    }

    public void update(ClienteEmpresaSeguridad clienteEmpresaSeguridad) {
        clienteEmpresaSeguridadRepository.save(clienteEmpresaSeguridad);
    }

    public void delete(Long customerId) {
        clienteEmpresaSeguridadRepository.deleteById(customerId);
    }

    public List<ClienteEmpresaSeguridad> all() {
        return clienteEmpresaSeguridadRepository.findAll();
    }

    public ClienteEmpresaSeguridad findById(Long customerId) {
        return clienteEmpresaSeguridadRepository.findById(customerId).orElse(null);
    }

    public ClienteEmpresaSeguridad findByDocument(String type, String value) {
        return clienteEmpresaSeguridadRepository.findTop1ByTipoDocumentoAndNroDocumento(type,value);
    }
}
