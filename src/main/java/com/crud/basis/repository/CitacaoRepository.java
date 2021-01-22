package com.crud.basis.repository;

import com.crud.basis.dominio.Citacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitacaoRepository extends JpaRepository<Citacao, Long> {
}
