package com.integracion.jcoq.repository;

import com.integracion.jcoq.entity.UsuarioLoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<UsuarioLoginEntity, Long> {
    Optional<UsuarioLoginEntity> findByNombreUsuario(String nombreUsuario);
}
