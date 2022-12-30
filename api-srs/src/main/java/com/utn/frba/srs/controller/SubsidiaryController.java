package com.utn.frba.srs.controller;

import com.utn.frba.srs.mapper.SubsidiaryMapper;
import com.utn.frba.srs.service.SubsidiaryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/srs/subsidiary")
public class SubsidiaryController {

    private final SubsidiaryService subsidiaryService;

    public SubsidiaryController(SubsidiaryService subsidiaryService) {
        this.subsidiaryService = subsidiaryService;
    }

    @PostMapping
    Long create(@RequestBody SubsidiaryDto request) {
        return subsidiaryService.create(SubsidiaryMapper.INSTANCE.toSucursalCliente(request));
    }

    @PutMapping("/{subsidiaryId}")
    void update(@PathVariable("subsidiaryId") Long subsidiaryId, @RequestBody SubsidiaryDto request) {
        subsidiaryService.update(SubsidiaryMapper.INSTANCE.toSucursalCliente(request));
    }

    @DeleteMapping("/{subsidiaryId}")
    void delete(@PathVariable("subsidiaryId") Long subsidiaryId) {
        subsidiaryService.delete(subsidiaryId);
    }

    @GetMapping("/findByCustomer/{customerId}")
    List<SubsidiaryReduceDto> findByCustomer(@PathVariable("customerId") Long customerId) {
        return subsidiaryService.findByCustomer(customerId).stream().map(SubsidiaryMapper.INSTANCE::toSubsidiaryReduceDto).toList();
    }

    @GetMapping("/findById/{subsidiaryId}")
    SubsidiaryReduceDto findById(@PathVariable("subsidiaryId") Long subsidiaryId) {
        return SubsidiaryMapper.INSTANCE.toSubsidiaryReduceDto(subsidiaryService.findById(subsidiaryId));
    }

    public  record SubsidiaryDto(
            String nombre,
            String descripcion,
            String nombreCalle,
            String altura,
            String departamento,
            String piso,
            String ciudad,
            String partido,
            String provincia,
            String pais ,
            String latitud,
            String longitud,
            Long clienteSeguridadId

    ) {
    }

    public    record SubsidiaryReduceDto(
            Long id,
            String nombre,
            String descripcion,
            String nombreCalle,
            String altura,
            String departamento,
            String piso,
            String ciudad,
            String partido,
            String provincia,
            String pais ,
            String latitud,
            String longitud,
            Long clienteSeguridadId

    ) {
    }
}
