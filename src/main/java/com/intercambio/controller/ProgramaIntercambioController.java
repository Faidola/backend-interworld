package com.intercambio.controller;

import com.intercambio.entity.ProgramaIntercambio;
import com.intercambio.service.ProgramaIntercambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programas")
public class ProgramaIntercambioController {

    @Autowired
    private ProgramaIntercambioService service;

    @GetMapping
    public List<ProgramaIntercambio> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgramaIntercambio> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProgramaIntercambio criar(@RequestBody ProgramaIntercambio programa) {
        return service.salvar(programa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgramaIntercambio> atualizar(@PathVariable Long id, @RequestBody ProgramaIntercambio programa) {
        return service.buscarPorId(id)
                .map(p -> {
                    programa.setId(id);
                    return ResponseEntity.ok(service.salvar(programa));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (service.buscarPorId(id).isPresent()) {
            service.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
