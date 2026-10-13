package com.nath.agendador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.nath.agendador.domain.Servico;
import com.nath.agendador.repository.ServicoRepository;

@Service
public class ServicoService {

    @Autowired
    public ServicoRepository servicoRepository;

    public Servico buscar(Integer id) {
        Optional<Servico> servico = servicoRepository.findById(id);
        return servico.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id não encontrado!"));
    }

    public List<Servico> buscarTodos() {
        return servicoRepository.findAll();
    }

    public Servico atualizar(Integer id, Servico dados) {
        Servico servico = servicoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "Serviço não encontrado!"));

        servico.setNome(dados.getNome() == null ? servico.getNome() : dados.getNome());
        servico.setDescricao(dados.getDescricao() == null ? servico.getDescricao() : dados.getDescricao());
        servico.setValor(dados.getValor() == null ? servico.getValor() : dados.getValor());

        return servicoRepository.save(servico);
    }

    public Servico inserir(Servico dados) {
        return servicoRepository.save(dados);
    }

    public Servico deletar(Integer id) {
        Servico servico = buscar(id);
        try {
            servicoRepository.delete(servico);
            return servico;
        } catch (DataIntegrityViolationException error) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Não é possível excluir um serviço que possui agendamentos.");
        }
        
    }
}
