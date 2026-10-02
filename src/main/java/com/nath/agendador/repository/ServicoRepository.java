package com.nath.agendador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nath.agendador.domain.Servico;

@Repository 
public interface ServicoRepository extends JpaRepository <Servico, Integer> { }
