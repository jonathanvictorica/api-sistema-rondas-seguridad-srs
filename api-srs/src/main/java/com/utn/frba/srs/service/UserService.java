package com.utn.frba.srs.service;

import com.utn.frba.srs.model.User;
import com.utn.frba.srs.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long create(User user) {
        userRepository.save(user);
        return user.getId();
    }

    public void update(User user) {
        userRepository.save(user);
    }

    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }

    public List<User> findByEmpresa(Long empresaId) {
        return userRepository.findByEmpresaSeguridad_id(empresaId);
    }

    public List<User> findByRol(String rol) {
        return userRepository.findByRolPrincipal(rol);
    }

    public User findById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User findByDocument(String type, String value) {
        return userRepository.findTop1ByTipoDocumentoAndNroDocumento(type,value);
    }
}
