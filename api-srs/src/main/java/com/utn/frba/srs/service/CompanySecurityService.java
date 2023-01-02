package com.utn.frba.srs.service;

import com.utn.frba.srs.model.SecurityCompany;
import com.utn.frba.srs.repository.SecurityCompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CompanySecurityService {

    private final SecurityCompanyRepository securityCompanyRepository;

    public CompanySecurityService(SecurityCompanyRepository securityCompanyRepository) {
        this.securityCompanyRepository = securityCompanyRepository;
    }

    public Long create(SecurityCompany empresaSeguridad) {
        securityCompanyRepository.save(empresaSeguridad);
        return empresaSeguridad.getId();
    }

    public void update(SecurityCompany empresaSeguridad) {
        securityCompanyRepository.save(empresaSeguridad);
    }

    public void delete(Long companySecurityId) {
        securityCompanyRepository.deleteById(companySecurityId);
    }

    public List<SecurityCompany> all() {
        return securityCompanyRepository.findAll();
    }

    public SecurityCompany findById(Long companySecurityId) {
        return securityCompanyRepository.findById(companySecurityId).orElse(null);
    }

    public SecurityCompany findByDocument(String type, String value) {
        return securityCompanyRepository.findTop1ByDocumentTypeAndDocumentValue(type, value);
    }
}
