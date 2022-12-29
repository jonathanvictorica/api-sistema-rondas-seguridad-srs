package com.utn.frba.srs.service;

import com.utn.frba.srs.model.EmpresaSeguridad;
import com.utn.frba.srs.repository.EmpresaSeguridadRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CompanySecurityService {

    private final EmpresaSeguridadRepository empresaSeguridadRepository;

    public CompanySecurityService(EmpresaSeguridadRepository empresaSeguridadRepository) {
        this.empresaSeguridadRepository = empresaSeguridadRepository;
    }

    public Long create(EmpresaSeguridad empresaSeguridad) {
        empresaSeguridadRepository.save(empresaSeguridad);
        return empresaSeguridad.getId();
    }

    public void update(EmpresaSeguridad empresaSeguridad) {
        empresaSeguridadRepository.save(empresaSeguridad);
    }

    public void delete(Long companySecurityId) {
        empresaSeguridadRepository.deleteById(companySecurityId);
    }

    public List<EmpresaSeguridad> all() {
        return empresaSeguridadRepository.findAll();
    }

    public EmpresaSeguridad findById(Long companySecurityId) {
        return empresaSeguridadRepository.findById(companySecurityId).orElse(null);
    }

    public EmpresaSeguridad findByDocument(String type, String value) {
        return empresaSeguridadRepository.findTop1ByTipoDocumentoAndNroDocumento(type,value);
    }
}
