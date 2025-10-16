package com.intercambio.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.intercambio.entity.Escola;
import com.intercambio.repository.EscolaRepository;

import jakarta.transaction.Transactional;

@Service
public class EscolaService {

	@Autowired
	private EscolaRepository escolaRepository;

	@Transactional
	public Escola saveEscola(Escola escola) {

		escola.setStatusEscola("ATIVO");

		return escolaRepository.save(escola);
	}

    public List<Escola> findAll() {
        return escolaRepository.findAll();
    }
    
    public Optional<Escola> findById(Integer id) {
        return escolaRepository.findById(id);
    
    }
    
    @Transactional
    public Escola atualizar(MultipartFile file, Integer id, Escola escola) {
        Optional<Escola> optionalEscola = escolaRepository.findById(id);
        if (optionalEscola.isPresent()) {
            Escola _escola = optionalEscola.get();
            _escola.setNome(escola.getNome());
            _escola.setDescricao(escola.getDescricao());
            _escola.setTelefone(escola.getTelefone());
            _escola.setWebsite(escola.getWebsite());
            
        	if (file != null && file.getSize() > 0) {
				try {
					_escola.setFoto(file.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}
			} 

            _escola.setIdentificacaoEscola(escola.getIdentificacaoEscola());
            _escola.setEnderecoCompleto(escola.getEnderecoCompleto());
            
            return escolaRepository.save(escola);
        }
        return null;
    }
    
    @Transactional
    public Escola update(Integer id, Escola escola) {
        Optional<Escola> optionalEscola = escolaRepository.findById(id);
        if (optionalEscola.isPresent()) {
            Escola _escola = optionalEscola.get();
            _escola.setNome(escola.getNome());
            _escola.setDescricao(escola.getDescricao());
            _escola.setTelefone(escola.getTelefone());
            _escola.setWebsite(escola.getWebsite());
            _escola.setIdentificacaoEscola(escola.getIdentificacaoEscola());
            _escola.setEnderecoCompleto(escola.getEnderecoCompleto());
            
            return escolaRepository.save(escola);
        }
        return null;
    }
    
    @Transactional
    public Escola inativar(Integer id) {
        Optional<Escola> optionalEscola = escolaRepository.findById(id);
        if (optionalEscola.isPresent()) {
            Escola escola = optionalEscola.get();
            escola.setStatusEscola("INATIVO");
            return escolaRepository.save(escola);
        }
        return null;
    }

	public boolean existsById(Integer id) {
		return escolaRepository.existsById(id);
	}

	public void deleteById(Integer id) {
		escolaRepository.deleteById(id);		
	}
    

}
