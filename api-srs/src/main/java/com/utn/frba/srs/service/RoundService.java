package com.utn.frba.srs.service;

import com.utn.frba.srs.model.Ronda;
import com.utn.frba.srs.repository.RondaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoundService {

    private final RondaRepository rondaRepository;

    public RoundService(RondaRepository rondaRepository) {
        this.rondaRepository = rondaRepository;
    }

    public Long create(Ronda ronda) {
        rondaRepository.save(ronda);
        return ronda.getId();
    }

    public void update(Ronda ronda) {
        rondaRepository.save(ronda);
    }

    public void delete(Long roundId) {
        rondaRepository.deleteById(roundId);
    }

    public List<Ronda> findBySubsidiary(Long subsidiaryId) {
        return rondaRepository.findBySucursalCliente_id(subsidiaryId);
    }

    public List<Ronda> findByCustomer(Long customerId) {
        return rondaRepository.findBySucursalCliente_clienteEmpresaSeguridad_id(customerId);
    }

    public Ronda findById(Long roundId) {
        return rondaRepository.findById(roundId).orElse(null);
    }
}
