package com.integracion.jcoq.service;

import com.integracion.jcoq.model.Usuario;
import com.integracion.jcoq.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UsuarioService {



    @Autowired
    private UsuarioRepository repo;

    public void guardar(Usuario usuario) {
        repo.insertar(usuario);
    }

    public List<Usuario> listar() {
        return repo.listar();
    }


}
