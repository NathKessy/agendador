package com.nath.agendador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nath.agendador.domain.Funcionario;
import com.nath.agendador.repository.FuncionarioRepository;

@Service 
public class FuncionarioService {

    @Autowired 
    public FuncionarioRepository funcionarioRepository;

    public Funcionario buscar(Integer id) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        return funcionario.orElseThrow(() -> new RuntimeException());
    }

    public List<Funcionario> buscarTodos() {
        return funcionarioRepository.findAll();
    }

}
