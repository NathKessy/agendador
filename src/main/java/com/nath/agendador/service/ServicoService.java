package com.nath.agendador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nath.agendador.domain.Servico;
import com.nath.agendador.repository.ServicoRepository;

@Service 
public class ServicoService {

    @Autowired 
    public ServicoRepository servicoRepository;

    public Servico buscar(Integer id) {
        Optional<Servico> servico = servicoRepository.findById(id);
        return servico.orElseThrow(() -> new RuntimeException());
    }

    public List<Servico> buscarTodos() {
        return servicoRepository.findAll();
    }

}
