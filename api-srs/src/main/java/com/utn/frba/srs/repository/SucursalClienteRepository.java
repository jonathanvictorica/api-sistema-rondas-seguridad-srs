package com.utn.frba.srs.repository;

import com.utn.frba.srs.model.SucursalCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SucursalClienteRepository extends JpaRepository<SucursalCliente, Long> {
    List<SucursalCliente> findByClienteEmpresaSeguridad_id(Long customerId);
}