package com.intercambio.controller;

import com.intercambio.dto.UsuarioDTO;
import com.intercambio.entity.Usuario;
import com.intercambio.service.EstudanteService;
import com.intercambio.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> usuarios = usuarioService.findAll();
        return ResponseEntity.ok(usuarios);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Integer id) {
        Optional<Usuario> usuario = usuarioService.findById(id);
        return usuario.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/findAll")
    public ResponseEntity<List<Usuario>> findAll(@PathVariable Integer id) {
    	List<Usuario> usuarios = usuarioService.findAll();
    	 return ResponseEntity.ok(usuarios);
    }
    
    @GetMapping("/email/{email}")
    public ResponseEntity<Usuario> findByEmail(@PathVariable String email) {
        Optional<Usuario> usuario = usuarioService.findByEmail(email);
        return usuario.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping("/create")
    public ResponseEntity<Usuario> create(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        if (usuarioService.existsByEmail(usuarioDTO.getEmail())) {
            return ResponseEntity.badRequest().build();
        }
        Usuario usuario = usuarioService.save(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }
    
    @PostMapping("/novo-estudante")
    public ResponseEntity<Usuario> createNovo(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        if (usuarioService.existsByEmail(usuarioDTO.getEmail())) {
            return ResponseEntity.badRequest().build();
        }
        Usuario usuario = usuarioService.saveEstudante(usuarioDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Integer id, @Valid @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioService.update(id, usuarioDTO);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (usuarioService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
} 