package com.nath.agendador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.nath.agendador.domain.Cliente;
import com.nath.agendador.repository.ClienteRepository;

@Service 
public class ClienteService {

    @Autowired 
    private ClienteRepository clienteRepository;

    public Cliente buscar(Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id não encontrado!"));
    }

    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente atualizar(Integer id, Cliente dados) {
        Cliente cliente = clienteRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
        
        cliente.setNome(dados.getNome() == null ? cliente.getNome() : dados.getNome());
        cliente.setTelefone(dados.getTelefone() == null ? cliente.getTelefone() : dados.getTelefone());

        return clienteRepository.save(cliente);
    }

    public Cliente inserir(Cliente dados) {
        return clienteRepository.save(dados);
    }

    public Cliente deletar(Integer id) {
        Cliente cliente = buscar(id);
        try {
            clienteRepository.delete(cliente);
            return cliente;
        } catch (DataIntegrityViolationException error) {
           throw new ResponseStatusException(HttpStatus.CONFLICT, "Não é possível excluir um cliente que possui agendamentos.");
        }
    }
    
    
}
