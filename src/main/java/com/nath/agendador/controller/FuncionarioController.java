package com.nath.agendador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nath.agendador.domain.Funcionario;
import com.nath.agendador.service.FuncionarioService;

@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscar(@PathVariable Integer id) {
        var funcionario = service.buscar(id);
        return ResponseEntity.ok().body(funcionario);
    }

    @GetMapping 
    public ResponseEntity<List<Funcionario>> buscarTodos() {
        var funcionario = service.buscarTodos();
        return ResponseEntity.ok().body(funcionario);
    }
}
