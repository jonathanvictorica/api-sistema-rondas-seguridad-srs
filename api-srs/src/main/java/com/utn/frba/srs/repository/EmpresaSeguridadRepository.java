package com.utn.frba.srs.repository;

import com.utn.frba.srs.model.EmpresaSeguridad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaSeguridadRepository extends JpaRepository<EmpresaSeguridad, Long> {
    EmpresaSeguridad findTop1ByTipoDocumentoAndNroDocumento(String type, String value);
}