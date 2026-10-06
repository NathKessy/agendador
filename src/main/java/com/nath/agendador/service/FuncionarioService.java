package com.nath.agendador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public Funcionario atualizar(Integer id, Funcionario dados ) {
        Funcionario funcionario = funcionarioRepository.findById(id)
            .orElseThrow(() ->  new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionário não encontrado!"));
        
        funcionario.setNome(dados.getNome() == null ? funcionario.getNome() : dados.getNome());
        funcionario.setNumero(dados.getNumero() == null ? funcionario.getNumero() : dados.getNumero());
        funcionario.setEmail(dados.getEmail() == null ? funcionario.getEmail() : dados.getEmail());
        funcionario.setIdade(dados.getIdade() == null ? funcionario.getIdade() : dados.getIdade());


        return funcionarioRepository.save(funcionario);
    }

    public Funcionario inserir(Funcionario dados) {
        return funcionarioRepository.save(dados);
    }

    public Funcionario deletar(Integer id) {
        Funcionario funcionario = buscar(id);
        try {
            funcionarioRepository.delete(funcionario);
            return funcionario;
        } catch (DataIntegrityViolationException error) {
           throw new ResponseStatusException(HttpStatus.CONFLICT, "Não é possível excluir um funcionário que possui agendamentos.");
        }
    }

}
