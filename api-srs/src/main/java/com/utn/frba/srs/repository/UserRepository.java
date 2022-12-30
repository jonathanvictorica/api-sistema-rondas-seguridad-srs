package com.utn.frba.srs.repository;

import com.utn.frba.srs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByEmpresaSeguridad_id(Long empresaId);

    List<User> findByRolPrincipal(String rol);

    User findTop1ByTipoDocumentoAndNroDocumento(String type, String value);
}