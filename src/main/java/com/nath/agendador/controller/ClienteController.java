package com.nath.agendador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nath.agendador.domain.Cliente;
import com.nath.agendador.service.ClienteService;

@RestController 
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired 
    private ClienteService service;

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscar(@PathVariable Integer id) {
        var cliente = service.buscar(id);
        return ResponseEntity.ok().body(cliente);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> buscarTodos() {
        var clientes = service.buscarTodos();
        return ResponseEntity.ok().body(clientes);
    }

    



}
