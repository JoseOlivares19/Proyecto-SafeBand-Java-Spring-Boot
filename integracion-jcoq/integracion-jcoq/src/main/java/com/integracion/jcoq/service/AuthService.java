package com.integracion.jcoq.service;

import com.integracion.jcoq.model.UsuarioLogin;
import com.integracion.jcoq.repository.AuthRepository;
import com.integracion.jcoq.entity.UsuarioLoginEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean registrar(UsuarioLogin usuarioLogin) {
        UsuarioLoginEntity entity = new UsuarioLoginEntity();
        entity.setNombreUsuario(usuarioLogin.getNombreUsuario());
        entity.setContrasena(passwordEncoder.encode(usuarioLogin.getContrasena()));
        authRepository.save(entity);
        return true;
    }

    public boolean login(String nombreUsuario, String contrasena) {
        return authRepository.findByNombreUsuario(nombreUsuario)
                .map(usuario -> passwordEncoder.matches(contrasena, usuario.getContrasena()))
                .orElse(false);
    }
}
