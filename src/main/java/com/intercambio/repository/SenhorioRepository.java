package com.intercambio.repository;

import com.intercambio.entity.Senhorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SenhorioRepository extends JpaRepository<Senhorio, Integer> {
    
    List<Senhorio> findByStatusSenhorio(String statusSenhorio);
    
    List<Senhorio> findByPaisAndStatusSenhorio(String pais, String statusSenhorio);
    
    List<Senhorio> findByUsuarioIdAndStatusSenhorio(Integer usuarioId, String statusSenhorio);
} 