package com.intercambio.repository;

import com.intercambio.entity.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Integer> {
    
    List<Estudante> findByStatusEstudante(String statusEstudante);
    
    Optional<Estudante> findByUsuarioId(Integer usuarioId);
    
    List<Estudante> findByUsuarioIdAndStatusEstudante(Integer usuarioId, String statusEstudante);
} 