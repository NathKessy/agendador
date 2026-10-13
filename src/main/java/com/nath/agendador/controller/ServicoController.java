package com.nath.agendador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nath.agendador.domain.Servico;
import com.nath.agendador.service.ServicoService;

@RestController
@RequestMapping(value = "/servico")
public class ServicoController {

    @Autowired
    private ServicoService service;

    @GetMapping("/{id}")
    public ResponseEntity<Servico> buscar(@PathVariable Integer id) {
        var servico = service.buscar(id);
        return ResponseEntity.ok().body(servico);
    }

    @GetMapping
    public ResponseEntity<List<Servico>> buscarTodos() {
        var servico = service.buscarTodos();
        return ResponseEntity.ok().body(servico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servico> atualizar(@PathVariable Integer id, @RequestBody Servico servico) {
        var atualizado = service.atualizar(id, servico);
        return ResponseEntity.ok(atualizado);
    }

    @PostMapping
    public ResponseEntity<Servico> inserir(@RequestBody Servico servico) {
        var novoServico = service.inserir(servico);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoServico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
