package com.utn.frba.srs.controller;

import com.utn.frba.srs.mapper.SubsidiaryMapper;
import com.utn.frba.srs.service.SubsidiaryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/srs/subsidiaries")
public class SubsidiaryController {

    private final SubsidiaryService subsidiaryService;
    private final SubsidiaryMapper mapper;

    public SubsidiaryController(SubsidiaryService subsidiaryService, SubsidiaryMapper mapper) {
        this.subsidiaryService = subsidiaryService;
        this.mapper = mapper;
    }

    @PostMapping
    Long create(@RequestBody SubsidiaryDto request) {
        return subsidiaryService.create(mapper.toSubsidiary(request));
    }

    @PutMapping("/{subsidiaryId}")
    void update(@PathVariable("subsidiaryId") Long subsidiaryId, @RequestBody SubsidiaryDto request) {
        subsidiaryService.update(mapper.toSubsidiary(request));
    }

    @DeleteMapping("/{subsidiaryId}")
    void delete(@PathVariable("subsidiaryId") Long subsidiaryId) {
        subsidiaryService.delete(subsidiaryId);
    }

    @GetMapping("/findByCustomer/{customerId}")
    List<SubsidiaryReduceDto> findByCustomer(@PathVariable("customerId") Long customerId) {
        return subsidiaryService.findByCustomer(customerId).stream().map(mapper::toSubsidiaryReduceDto).toList();
    }

    @GetMapping("/findById/{subsidiaryId}")
    SubsidiaryReduceDto findById(@PathVariable("subsidiaryId") Long subsidiaryId) {
        return mapper.toSubsidiaryReduceDto(subsidiaryService.findById(subsidiaryId));
    }

    public  record SubsidiaryDto(
            Long id,
            String name,
            String description,
            String streetName,
            String streetNumber,
            String apartment,
            String flat,
            String city,
            String party,
            String province,
            String latitude,
            String longitude,
            Long customerId

    ) {
    }

    public    record SubsidiaryReduceDto(
            Long id,
             String name,
             String description,
             String streetName,
             String streetNumber,
             String apartment,
             String flat,
             String city,
             String party,
             String province,
             String latitude,
             String longitude,
             Long customerId

    ) {
    }
}
