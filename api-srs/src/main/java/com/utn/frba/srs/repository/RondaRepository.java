package com.utn.frba.srs.repository;

import com.utn.frba.srs.model.Ronda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RondaRepository extends JpaRepository<Ronda, Long> {
    List<Ronda> findBySucursalCliente_id(Long subsidiaryId);

    List<Ronda> findBySucursalCliente_clienteEmpresaSeguridad_id(Long customerId);
}