package com.intercambio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.intercambio.entity.Estudante;
import com.intercambio.entity.Usuario;
import com.intercambio.repository.UsuarioRepository;
import com.intercambio.service.EstudanteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/estudantes")
public class EstudanteController {
	
	@Autowired
	private EstudanteService estudanteService;
    

    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @GetMapping
    public ResponseEntity<List<Estudante>> findAll() {
        List<Estudante> estudantes = estudanteService.findAll();
        return ResponseEntity.ok(estudantes);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Estudante> findById(@PathVariable Integer id) {
        Optional<Estudante> estudante = estudanteService.findById(id);
        return estudante.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<Estudante> create(@RequestBody EstudanteRequest request) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(request.getUsuarioId());
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            Estudante estudante = new Estudante(usuario);
            estudante = estudanteService.saveEstudante(estudante);
            return ResponseEntity.status(HttpStatus.CREATED).body(estudante);
        }
        return ResponseEntity.badRequest().build();
    }
    
    @PostMapping("/novo-estudante")
    public ResponseEntity<Estudante> createNovo(@Valid @RequestBody Estudante estudante) {
    	Estudante _estudante = estudanteService.saveEstudante(estudante);
        return ResponseEntity.status(HttpStatus.CREATED).body(_estudante);
    }
    
    
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<?> alterar(@PathVariable Integer id,
			@RequestParam(required = false) MultipartFile file,
			@ModelAttribute Estudante estudante) {

		estudanteService.atualizar(file, id, estudante);

		return ResponseEntity.ok()
				.body("Estudante alterado com sucesso!");
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id,
			@ModelAttribute Estudante estudante) {

		estudanteService.update(id, estudante);

		return ResponseEntity.ok()
				.body("Estudante alterado com sucesso!");
	}

	@PutMapping("/inativar/{id}")
	public ResponseEntity<?> inativar(@PathVariable Integer id) {

		estudanteService.inativar(id);

		return ResponseEntity.ok()
				.body("Estudante inativada com sucesso!");
	}
	
	@PutMapping("/ativar/{id}")
	public ResponseEntity<?> ativar(@PathVariable Integer id) {

		estudanteService.ativar(id);

		return ResponseEntity.ok()
				.body("Estudante ativada com sucesso!");
	}
    
	/*
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Estudante> atualizar(@PathVariable Integer id, @RequestBody EstudanteRequest request) {
        Optional<Estudante> optionalEstudante = estudanteService.findById(id);
        if (optionalEstudante.isPresent()) {
            Estudante estudante = optionalEstudante.get();
            // Atualizar campos específicos do estudante se necessário
            estudante = estudanteService.saveEstudante(estudante);
            return ResponseEntity.ok(estudante);
        }
        return ResponseEntity.notFound().build();
    }
    
    */
    @PutMapping("/{id}")
    public ResponseEntity<Estudante> update(@PathVariable Integer id, @RequestBody EstudanteRequest request) {
        Optional<Estudante> optionalEstudante = estudanteService.findById(id);
        if (optionalEstudante.isPresent()) {
            Estudante estudante = optionalEstudante.get();
            // Atualizar campos específicos do estudante se necessário
            estudante = estudanteService.saveEstudante(estudante);
            return ResponseEntity.ok(estudante);
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (estudanteService.existsById(id)) {
        	estudanteService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    // Classe interna para requisições
    public static class EstudanteRequest {
        private Integer usuarioId;
        
        public Integer getUsuarioId() {
            return usuarioId;
        }
        
        public void setUsuarioId(Integer usuarioId) {
            this.usuarioId = usuarioId;
        }
    }
} 