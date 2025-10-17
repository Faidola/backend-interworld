package com.intercambio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.intercambio.entity.Estudante;
import com.intercambio.entity.Usuario;
import com.intercambio.repository.EstudanteRepository;
import com.intercambio.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class EstudanteService {

	@Autowired
	private EstudanteRepository estudanteRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Transactional
	public Estudante saveEstudante(Estudante estudante) {

		estudante.setStatusEstudante("ATIVO");

		return estudanteRepository.save(estudante);
	}

    public List<Estudante> findAll() {
        return estudanteRepository.findAll();
    }
    
    public Optional<Estudante> findById(Integer id) {
        return estudanteRepository.findById(id);
    
    }
    
    @Transactional
    public Estudante atualizar(MultipartFile file, Integer id, Estudante estudante) {
        Optional<Estudante> optionalEstudante = estudanteRepository.findById(id);
        if (optionalEstudante.isPresent()) {
        	Estudante _estudante = optionalEstudante.get();
            _estudante.setNome(estudante.getNome());
            _estudante.setTelefone(estudante.getTelefone());
            _estudante.setCpf(estudante.getCpf());
            _estudante.setCep(estudante.getCep());
            
            return estudanteRepository.save(estudante);
        }
        return null;
    }
    
    @Transactional
    public Estudante update(Integer id, Estudante estudante) {
        Optional<Estudante> optionalEstudante = estudanteRepository.findById(id);
        if (optionalEstudante.isPresent()) {
            Estudante _estudante = optionalEstudante.get();
            _estudante.setNome(estudante.getNome());
            _estudante.setTelefone(estudante.getTelefone());
            _estudante.setCpf(estudante.getCpf());
            _estudante.setCep(estudante.getCep());
            
            return estudanteRepository.save(estudante);
        }
        return null;
    }
    
    
    @Transactional
    public Estudante inativar(Integer id) {
        Optional<Estudante> optionalEstudante = estudanteRepository.findById(id);
        if (optionalEstudante.isPresent()) {
        	Optional<Usuario> _usuario = usuarioRepository.findById(optionalEstudante.get().getUsuario().getId());
            Estudante estudante = optionalEstudante.get();
            estudante.setStatusEstudante("INATIVO");
            
            Estudante e = estudanteRepository.save(estudante);
            
            Usuario usuario = _usuario.get();
            usuario.setStatusUsuario("INATIVO");     
            System.out.println(usuarioRepository.save(usuario));
            return e;
        }
        return null;
    }
    
    @Transactional
    public Estudante ativar(Integer id) {
        Optional<Estudante> optionalEstudante = estudanteRepository.findById(id);
        if (optionalEstudante.isPresent()) {
        	Optional<Usuario> _usuario = usuarioRepository.findById(optionalEstudante.get().getUsuario().getId());
            Estudante estudante = optionalEstudante.get();
            estudante.setStatusEstudante("ATIVO");
            
            Estudante e = estudanteRepository.save(estudante);
            
            Usuario usuario = _usuario.get();
            usuario.setStatusUsuario("ATIVO");     
            usuarioRepository.save(usuario);
            return e;
        }
        return null;
    }

	public boolean existsById(Integer id) {
		return estudanteRepository.existsById(id);
	}

	public void deleteById(Integer id) {
		estudanteRepository.deleteById(id);		
	}
    

}
