package com.utn.frba.srs.repository;

import com.utn.frba.srs.model.ClienteEmpresaSeguridad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteEmpresaSeguridadRepository extends JpaRepository<ClienteEmpresaSeguridad, Long> {
    ClienteEmpresaSeguridad findTop1ByTipoDocumentoAndNroDocumento(String type, String value);
}