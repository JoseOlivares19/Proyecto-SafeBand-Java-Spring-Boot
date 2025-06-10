package com.integracion.jcoq.controller;

import com.integracion.jcoq.model.UsuarioLogin;
import com.integracion.jcoq.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String nombreUsuario, @RequestParam String contrasena) {
        boolean success = authService.login(nombreUsuario, contrasena);
        return success ? "redirect:/" : "redirect:/login?error=true";
    }

    @GetMapping("/register")
    public String registerForm() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UsuarioLogin usuarioLogin) {
        authService.registrar(usuarioLogin);
        return "redirect:/login";
    }
}
