package com.utn.frba.srs.controller;

import com.utn.frba.srs.mapper.CompanySecurityMapper;
import com.utn.frba.srs.service.CompanySecurityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/srs/company-security")
public class CompanySecurityController {
    private final CompanySecurityService companySecurityService;
    private final CompanySecurityMapper mapper;

    public CompanySecurityController(CompanySecurityService companySecurityService, CompanySecurityMapper mapper) {
        this.companySecurityService = companySecurityService;
        this.mapper = mapper;
    }

    @PostMapping
    public Long create(@RequestBody CompanySecurityDto request) {
        return companySecurityService.create(mapper.toSecurityCompany(request));
    }

    @PutMapping("/{companySecurityId}")
    void update(@PathVariable("companySecurityId") Long companySecurityId, @RequestBody CompanySecurityDto request) {
        companySecurityService.update(mapper.toSecurityCompany(request));
    }

    @DeleteMapping("/{companySecurityId}")
    void delete(@PathVariable("companySecurityId") Long companySecurityId) {
        companySecurityService.delete(companySecurityId);
    }

    @GetMapping("/all")
    List<CompanySecurityReduceDto> all() {
        return companySecurityService.all().stream().map(mapper::toCompanySecurityReduceDto).toList();
    }

    @GetMapping("/findById/{companySecurityId}")
    CompanySecurityReduceDto findById(@PathVariable("companySecurityId") Long companySecurityId) {
        return mapper.toCompanySecurityReduceDto(companySecurityService.findById(companySecurityId));
    }

    @GetMapping("/findByDocument/{type}/{value}")
    CompanySecurityReduceDto findByDocument(@PathVariable("type") String type, @PathVariable("value") String value) {
        return mapper.toCompanySecurityReduceDto(companySecurityService.findByDocument(type, value));
    }


    public record CompanySecurityDto(
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

    public record CompanySecurityReduceDto(
            Long id,
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
