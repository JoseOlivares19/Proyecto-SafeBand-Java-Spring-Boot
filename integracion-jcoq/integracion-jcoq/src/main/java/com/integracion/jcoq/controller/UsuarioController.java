package com.integracion.jcoq.controller;

import com.integracion.jcoq.model.Usuario;
import com.integracion.jcoq.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService servicio;

    @GetMapping("/")
    public String listar(Model model) {
        List<Usuario> usuarios = servicio.listar();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("usuario", new Usuario());
        return "index";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Usuario usuario) {
        servicio.guardar(usuario);
        return "redirect:/";
    }

}
