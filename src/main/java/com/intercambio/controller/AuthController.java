package com.intercambio.controller;

import com.intercambio.dto.LoginDTO;
import com.intercambio.entity.Usuario;
import com.intercambio.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        try {
            Optional<Usuario> usuario = usuarioService.findByEmail(loginDTO.getEmail());
            
            if (usuario.isPresent() && passwordEncoder.matches(loginDTO.getSenha(), usuario.get().getSenha())) {
                Usuario user = usuario.get();
                
                Map<String, Object> response = new HashMap<>();
                response.put("id", user.getId());
                response.put("nome", user.getNome());
                response.put("email", user.getEmail());
                response.put("nivelAcesso", user.getNivelAcesso());
                response.put("statusUsuario", user.getStatusUsuario());
                
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.badRequest().body("Email ou senha inválidos");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro no login: " + e.getMessage());
        }
    }
} 