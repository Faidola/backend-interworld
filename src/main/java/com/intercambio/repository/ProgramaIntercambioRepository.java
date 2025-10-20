package com.intercambio.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intercambio.entity.ProgramaIntercambio;

@Repository
public interface ProgramaIntercambioRepository extends JpaRepository<ProgramaIntercambio, Long> {
	
}
