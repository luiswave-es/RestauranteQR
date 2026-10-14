package com.gestionqr.backend.controller;

import com.gestionqr.backend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/me")
    public ResponseEntity<?> me(Authentication authentication) {
        try {
            return ResponseEntity.ok(authService.obtenerEmpleadoAutenticado(authentication.getName()));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}