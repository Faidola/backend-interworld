package com.intercambio.controller;

import com.intercambio.dto.SenhorioDTO;
import com.intercambio.entity.Senhorio;
import com.intercambio.service.SenhorioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/senhorios")
public class SenhorioController {
    
    @Autowired
    private SenhorioService senhorioService;
    
    @GetMapping
    public ResponseEntity<List<Senhorio>> findAll() {
        List<Senhorio> senhorios = senhorioService.findAll();
        return ResponseEntity.ok(senhorios);
    }
    
    @GetMapping("/ativos")
    public ResponseEntity<List<Senhorio>> findAtivos() {
        List<Senhorio> senhorios = senhorioService.findByStatus("ATIVO");
        return ResponseEntity.ok(senhorios);
    }
    
    @GetMapping("/pais/{pais}")
    public ResponseEntity<List<Senhorio>> findByPais(@PathVariable String pais) {
        List<Senhorio> senhorios = senhorioService.findByPais(pais);
        return ResponseEntity.ok(senhorios);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Senhorio> findById(@PathVariable Integer id) {
        Optional<Senhorio> senhorio = senhorioService.findById(id);
        return senhorio.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<Senhorio> create(@Valid @RequestBody SenhorioDTO senhorioDTO) {
        Senhorio senhorio = senhorioService.save(senhorioDTO);
        if (senhorio != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(senhorio);
        }
        return ResponseEntity.badRequest().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Senhorio> update(@PathVariable Integer id, @Valid @RequestBody SenhorioDTO senhorioDTO) {
        Senhorio senhorio = senhorioService.update(id, senhorioDTO);
        if (senhorio != null) {
            return ResponseEntity.ok(senhorio);
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (senhorioService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
} 