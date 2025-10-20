package com.intercambio.service;

import com.intercambio.entity.ProgramaIntercambio;
import com.intercambio.repository.ProgramaIntercambioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramaIntercambioService {

    @Autowired
    private ProgramaIntercambioRepository repository;

    public List<ProgramaIntercambio> listarTodos() {
        return repository.findAll();
    }

    public Optional<ProgramaIntercambio> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public ProgramaIntercambio salvar(ProgramaIntercambio programa) {
        return repository.save(programa);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
