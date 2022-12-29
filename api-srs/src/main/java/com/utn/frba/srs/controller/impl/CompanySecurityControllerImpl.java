package com.utn.frba.srs.controller.impl;

import com.utn.frba.srs.controller.contract.CompanySecurityController;
import com.utn.frba.srs.mapper.CompanySecurityMapper;
import com.utn.frba.srs.service.CompanySecurityService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanySecurityControllerImpl implements CompanySecurityController {
    private final CompanySecurityService companySecurityService;

    public CompanySecurityControllerImpl(CompanySecurityService companySecurityService) {
        this.companySecurityService = companySecurityService;
    }

    @Override
    public Long create(CompanySecurityDto request) {
        return companySecurityService.create(CompanySecurityMapper.INSTANCE.toEmpresaSeguridad(request));
    }

    @Override
    public void update(Long companySecurityId, CompanySecurityDto request) {
        companySecurityService.update(CompanySecurityMapper.INSTANCE.toEmpresaSeguridad(request));
    }

    @Override
    public void delete(Long companySecurityId) {
        companySecurityService.delete(companySecurityId);
    }

    @Override
    public List<CompanySecurityReduceDto> all() {
        return companySecurityService.all().stream().map(CompanySecurityMapper.INSTANCE::toCompanySecurityReduceDto).toList();
    }

    @Override
    public CompanySecurityReduceDto findById(Long companySecurityId) {
        return CompanySecurityMapper.INSTANCE.toCompanySecurityReduceDto(companySecurityService.findById(companySecurityId));
    }

    @Override
    public CompanySecurityReduceDto findByDocument(String type, String value) {
        return CompanySecurityMapper.INSTANCE.toCompanySecurityReduceDto(companySecurityService.findByDocument(type, value));
    }
}
