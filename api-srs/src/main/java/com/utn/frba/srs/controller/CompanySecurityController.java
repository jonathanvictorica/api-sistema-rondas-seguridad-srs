package com.utn.frba.srs.controller;

import com.utn.frba.srs.mapper.CompanySecurityMapper;
import com.utn.frba.srs.service.CompanySecurityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/srs/company-security")
public class CompanySecurityController {
    private final CompanySecurityService companySecurityService;

    public CompanySecurityController(CompanySecurityService companySecurityService) {
        this.companySecurityService = companySecurityService;
    }

    @PostMapping
    public Long create(@RequestBody CompanySecurityDto request) {
        return companySecurityService.create(CompanySecurityMapper.INSTANCE.toEmpresaSeguridad(request));
    }

    @PutMapping("/{companySecurityId}")
    void update(@PathVariable("companySecurityId") Long companySecurityId, @RequestBody CompanySecurityDto request){
        companySecurityService.update(CompanySecurityMapper.INSTANCE.toEmpresaSeguridad(request));
    }

    @DeleteMapping("/{companySecurityId}")
    void delete(@PathVariable("companySecurityId") Long companySecurityId) {
        companySecurityService.delete(companySecurityId);
    }

    @GetMapping("/all")
    List<CompanySecurityReduceDto> all() {
        return companySecurityService.all().stream().map(CompanySecurityMapper.INSTANCE::toCompanySecurityReduceDto).toList();
    }

    @GetMapping("/findById/{companySecurityId}")
    CompanySecurityReduceDto findById(@PathVariable("companySecurityId") Long companySecurityId) {
        return CompanySecurityMapper.INSTANCE.toCompanySecurityReduceDto(companySecurityService.findById(companySecurityId));
    }

    @GetMapping("/findByDocument/{type}/{value}")
    CompanySecurityReduceDto findByDocument(@PathVariable("type") String type, @PathVariable("value") String value) {
        return CompanySecurityMapper.INSTANCE.toCompanySecurityReduceDto(companySecurityService.findByDocument(type, value));
    }


    public   record CompanySecurityDto(
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
            String pais ,
            String latitud,
            String longitud

    ) {
    }

    public   record CompanySecurityReduceDto(
            Long id,
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
            String pais ,
            String latitud,
            String longitud
    ) {
    }
}
