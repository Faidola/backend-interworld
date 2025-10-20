package com.intercambio.controller;

import com.intercambio.entity.Idioma;
import com.intercambio.service.IdiomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/idiomas")
public class IdiomaController {

    @Autowired
    private IdiomaService service;

    @GetMapping
    public List<Idioma> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Idioma> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Idioma criar(@RequestBody Idioma idioma) {
        return service.salvar(idioma);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Idioma> atualizar(@PathVariable Long id, @RequestBody Idioma idioma) {
        return service.buscarPorId(id)
                .map(i -> {
                    idioma.setId(id);
                    return ResponseEntity.ok(service.salvar(idioma));
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
