package com.nath.agendador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nath.agendador.domain.Agenda;

@Repository 
public interface AgendaRepository extends JpaRepository <Agenda, Integer> { }
