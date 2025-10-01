package com.intercambio.service;

import com.intercambio.dto.SenhorioDTO;
import com.intercambio.entity.Senhorio;
import com.intercambio.entity.Usuario;
import com.intercambio.repository.SenhorioRepository;
import com.intercambio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SenhorioService {
    
    @Autowired
    private SenhorioRepository senhorioRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public List<Senhorio> findAll() {
        return senhorioRepository.findAll();
    }
    
    public List<Senhorio> findByStatus(String status) {
        return senhorioRepository.findByStatusSenhorio(status);
    }
    
    public List<Senhorio> findByPais(String pais) {
        return senhorioRepository.findByPaisAndStatusSenhorio(pais, "ATIVO");
    }
    
    public Optional<Senhorio> findById(Integer id) {
        return senhorioRepository.findById(id);
    }
    
    public Senhorio save(SenhorioDTO senhorioDTO) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(senhorioDTO.getUsuarioId());
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            Senhorio senhorio = new Senhorio(
                senhorioDTO.getNome(),
                senhorioDTO.getDescricao(),
                senhorioDTO.getPais(),
                senhorioDTO.getLocalSenhorio(),
                senhorioDTO.getTelefone(),
                usuario
            );
            return senhorioRepository.save(senhorio);
        }
        return null;
    }
    
    public Senhorio update(Integer id, SenhorioDTO senhorioDTO) {
        Optional<Senhorio> optionalSenhorio = senhorioRepository.findById(id);
        if (optionalSenhorio.isPresent()) {
            Senhorio senhorio = optionalSenhorio.get();
            senhorio.setNome(senhorioDTO.getNome());
            senhorio.setDescricao(senhorioDTO.getDescricao());
            senhorio.setPais(senhorioDTO.getPais());
            senhorio.setLocalSenhorio(senhorioDTO.getLocalSenhorio());
            senhorio.setTelefone(senhorioDTO.getTelefone());
            if (senhorioDTO.getStatusSenhorio() != null) {
                senhorio.setStatusSenhorio(senhorioDTO.getStatusSenhorio());
            }
            return senhorioRepository.save(senhorio);
        }
        return null;
    }
    
    public boolean delete(Integer id) {
        if (senhorioRepository.existsById(id)) {
            senhorioRepository.deleteById(id);
            return true;
        }
        return false;
    }
} 