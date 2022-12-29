package com.utn.frba.srs.service;


import com.utn.frba.srs.model.SucursalCliente;
import com.utn.frba.srs.repository.SucursalClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubsidiaryService {
    private final SucursalClienteRepository sucursalClienteRepository;

    public SubsidiaryService(SucursalClienteRepository sucursalClienteRepository) {
        this.sucursalClienteRepository = sucursalClienteRepository;
    }

    public Long create(SucursalCliente sucursalCliente) {
        sucursalClienteRepository.save(sucursalCliente);
        return sucursalCliente.getId();
    }

    public void update(SucursalCliente sucursalCliente) {
        sucursalClienteRepository.save(sucursalCliente);
    }

    public void delete(Long sucursalClienteId) {
        sucursalClienteRepository.deleteById(sucursalClienteId);
    }

    public List<SucursalCliente> findByCustomer(Long customerId) {
        return sucursalClienteRepository.findByClienteEmpresaSeguridad_id(customerId);
    }

    public  SucursalCliente  findById(Long sucursalClienteId) {
        return sucursalClienteRepository.findById(sucursalClienteId).orElse(null);
    }
}
