package com.nath.agendador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nath.agendador.domain.Cliente;
import com.nath.agendador.repository.ClienteRepository;

@Service 
public class ClienteService {

    @Autowired 
    private ClienteRepository clienteRepository;

    public Cliente buscar(Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElseThrow(() -> new RuntimeException());
    }

    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }
    
    
}
