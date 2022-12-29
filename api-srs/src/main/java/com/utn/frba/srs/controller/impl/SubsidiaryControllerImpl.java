package com.utn.frba.srs.controller.impl;

import com.utn.frba.srs.controller.contract.SubsidiaryController;
import com.utn.frba.srs.mapper.SubsidiaryMapper;
import com.utn.frba.srs.service.SubsidiaryService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SubsidiaryControllerImpl implements SubsidiaryController {

    private final SubsidiaryService subsidiaryService;

    public SubsidiaryControllerImpl(SubsidiaryService subsidiaryService) {
        this.subsidiaryService = subsidiaryService;
    }

    @Override
    public Long create(SubsidiaryDto request) {
        return subsidiaryService.create(SubsidiaryMapper.INSTANCE.toSucursalCliente(request));
    }

    @Override
    public void update(Long subsidiaryId, SubsidiaryDto request) {
        subsidiaryService.update(SubsidiaryMapper.INSTANCE.toSucursalCliente(request));
    }

    @Override
    public void delete(Long subsidiaryId) {
        subsidiaryService.delete(subsidiaryId);
    }

    @Override
    public List<SubsidiaryReduceDto> findByCustomer(Long customerId) {
        return subsidiaryService.findByCustomer(customerId).stream().map(SubsidiaryMapper.INSTANCE::toSubsidiaryReduceDto).toList();
    }

    @Override
    public SubsidiaryReduceDto findById(Long subsidiaryId) {
        return SubsidiaryMapper.INSTANCE.toSubsidiaryReduceDto(subsidiaryService.findById(subsidiaryId));
    }
}
