package com.intercambio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intercambio.entity.Estudante;
import com.intercambio.repository.EstudanteRepository;

import jakarta.transaction.Transactional;

@Service
public class EstudanteService {

	@Autowired
	private EstudanteRepository estudanteRepository;

	@Transactional
	public Estudante saveEstudante(Estudante estudante) {

		
		estudante.setStatusEstudante("ATIVO");

		return estudanteRepository.save(estudante);
	}

}
