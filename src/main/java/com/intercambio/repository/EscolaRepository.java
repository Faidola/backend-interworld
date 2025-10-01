package com.intercambio.repository;

import com.intercambio.entity.Escola;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EscolaRepository extends JpaRepository<Escola, Integer> {
    
    List<Escola> findByStatusEscola(String statusEscola);
    
    List<Escola> findByPaisAndStatusEscola(String pais, String statusEscola);
    
    List<Escola> findByUsuarioIdAndStatusEscola(Integer usuarioId, String statusEscola);
} 