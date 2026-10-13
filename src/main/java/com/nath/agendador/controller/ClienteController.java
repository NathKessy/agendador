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

import com.nath.agendador.domain.Cliente;
import com.nath.agendador.service.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/cliente")
@Tag(name = "Clientes", description = "Operações para gerenciamento de clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping("/{id}")
        @Operation(summary = "Buscar cliente por ID", description = "Busca um cliente pelo identificador.")
        @ApiResponse(responseCode = "200", description = "Cliente encontrado")
        public ResponseEntity<Cliente> buscar(
            @Parameter(description = "Identificador do cliente", example = "1")
            @PathVariable Integer id) {
        var cliente = service.buscar(id);
        return ResponseEntity.ok().body(cliente);
    }

    @GetMapping
        @Operation(summary = "Listar clientes por ID", description = "Retorna todos os clientes cadastrados.")
        @ApiResponse(responseCode = "200", description = "Lista de clientes retornada")
    public ResponseEntity<List<Cliente>> buscarTodos() {
        var clientes = service.buscarTodos();
        return ResponseEntity.ok().body(clientes);
    }

    @PutMapping("/{id}")
        @Operation(summary = "Atualizar cliente por ID", description = "Atualiza os dados de um cliente existente.")
        @ApiResponse(responseCode = "200", description = "Cliente atualizado")
        public ResponseEntity<Cliente> atualizar(
            @Parameter(description = "Identificador do cliente", example = "1")
            @PathVariable Integer id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "Dados atualizados do cliente",
                required = true)
            @RequestBody Cliente cliente) {
        var atualizado = service.atualizar(id, cliente);
        return ResponseEntity.ok(atualizado);
    }

    @PostMapping
        @Operation(summary = "Cadastrar cliente", description = "Cria um novo cliente.")
        @ApiResponse(responseCode = "201", description = "Cliente criado")
        public ResponseEntity<Cliente> inserir(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "Dados do novo cliente",
                required = true)
            @RequestBody Cliente cliente) {
        var novoCliente = service.inserir(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
    }

    @DeleteMapping("/{id}")
        @Operation(summary = "Excluir cliente", description = "Remove um cliente pelo identificador.")
        @ApiResponse(responseCode = "204", description = "Cliente excluído")
        public ResponseEntity<Void> deletar(
            @Parameter(description = "Identificador do cliente", example = "1")
            @PathVariable Integer id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
