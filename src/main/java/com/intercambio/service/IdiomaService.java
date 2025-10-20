package com.intercambio.service;

import com.intercambio.entity.Idioma;
import com.intercambio.repository.IdiomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IdiomaService {

    @Autowired
    private IdiomaRepository repository;

    public List<Idioma> listarTodos() {
        return repository.findAll();
    }

    public Optional<Idioma> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Idioma salvar(Idioma idioma) {
        return repository.save(idioma);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
