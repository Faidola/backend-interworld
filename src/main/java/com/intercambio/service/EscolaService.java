package com.intercambio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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



}
