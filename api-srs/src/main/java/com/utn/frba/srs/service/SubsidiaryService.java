package com.utn.frba.srs.service;


import com.utn.frba.srs.model.Subsidiary;
import com.utn.frba.srs.repository.SubsidiaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubsidiaryService {
    private final SubsidiaryRepository subsidiaryRepository;

    public SubsidiaryService(SubsidiaryRepository subsidiaryRepository) {
        this.subsidiaryRepository = subsidiaryRepository;
    }

    public Long create(Subsidiary subsidiary) {
        subsidiaryRepository.save(subsidiary);
        return subsidiary.getId();
    }

    public void update(Subsidiary subsidiary) {
        subsidiaryRepository.save(subsidiary);
    }

    public void delete(Long sucursalClienteId) {
        subsidiaryRepository.deleteById(sucursalClienteId);
    }

    public List<Subsidiary> findByCustomer(Long customerId) {
        return subsidiaryRepository.findByCustomer_id(customerId);
    }

    public Subsidiary findById(Long sucursalClienteId) {
        return subsidiaryRepository.findById(sucursalClienteId).orElse(null);
    }
}
