package com.intercambio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intercambio.entity.Escola;
import com.intercambio.entity.Usuario;
import com.intercambio.repository.EscolaRepository;
import com.intercambio.repository.UsuarioRepository;
import com.intercambio.service.EscolaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/escolas")
public class EscolaController {
	
	@Autowired
	private EscolaService escolaService;
    
    @Autowired
    private EscolaRepository escolaRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @GetMapping
    public ResponseEntity<List<Escola>> findAll() {
        List<Escola> escolas = escolaRepository.findAll();
        return ResponseEntity.ok(escolas);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Escola> findById(@PathVariable Integer id) {
        Optional<Escola> escola = escolaRepository.findById(id);
        return escola.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<Escola> create(@RequestBody EscolaRequest request) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(request.getUsuarioId());
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            Escola escola = new Escola(usuario);
            escola = escolaRepository.save(escola);
            return ResponseEntity.status(HttpStatus.CREATED).body(escola);
        }
        return ResponseEntity.badRequest().build();
    }
    
    @PostMapping("/novo-escola")
    public ResponseEntity<Escola> createNovo(@Valid @RequestBody Escola escola) {
    	Escola _escola = escolaService.saveEscola(escola);
        return ResponseEntity.status(HttpStatus.CREATED).body(_escola);
    }
    
    
    
    
    @PutMapping("/{id}")
    public ResponseEntity<Escola> update(@PathVariable Integer id, @RequestBody EscolaRequest request) {
        Optional<Escola> optionalEscola = escolaRepository.findById(id);
        if (optionalEscola.isPresent()) {
            Escola escola = optionalEscola.get();
            // Atualizar campos específicos do escola se necessário
            escola = escolaRepository.save(escola);
            return ResponseEntity.ok(escola);
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (escolaRepository.existsById(id)) {
            escolaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    // Classe interna para requisições
    public static class EscolaRequest {
        private Integer usuarioId;
        
        public Integer getUsuarioId() {
            return usuarioId;
        }
        
        public void setUsuarioId(Integer usuarioId) {
            this.usuarioId = usuarioId;
        }
    }
} 