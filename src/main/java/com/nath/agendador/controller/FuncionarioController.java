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
import com.nath.agendador.domain.Funcionario;
import com.nath.agendador.service.FuncionarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/funcionario")
@Tag(name = "Funcionário", description = "Operações para gerenciamento de funcionários")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping("/{id}")
    @Operation(summary = "Buscar funcionario por ID", description = "Buscar um funcionário pelo identificador.")
    @ApiResponse(responseCode = "200", description = "Funcionário encontrado")
    public ResponseEntity<Funcionario> buscar(
            @Parameter(description = "Identificador de funcionario", example = "1") @PathVariable Integer id) {
        
        var funcionario = service.buscar(id);
        return ResponseEntity.ok().body(funcionario);
    }

    @GetMapping
    @Operation(summary = "Listar funcionários", description = "Retorna todos os funcionários cadastrados.")
    @ApiResponse(responseCode = "200", description = "Lista de funcionário retornada")
    public ResponseEntity<List<Funcionario>> buscarTodos() {
        
        var funcionario = service.buscarTodos();
        return ResponseEntity.ok().body(funcionario);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar funcionário por ID", description = "Atualiza os dados de um funcionário existente.")
    @ApiResponse(responseCode = "200", description = "Funcionário atualizado")
    public ResponseEntity<Funcionario> atualizar(
        @Parameter(description = "Identificador do funcionário", example = "1") @PathVariable Integer id,
        @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Dados atualizados do funcionário", required = true)
        @RequestBody Funcionario funcionario) {

        var atualizado = service.atualizar(id, funcionario);
        return ResponseEntity.ok().body(atualizado);
    }

    @PostMapping
    @Operation(summary = "Cadastrar funcionário", description = "Criar um novo funcionário.")
    @ApiResponse(responseCode = "201", description = "Funcionário criado")
    public ResponseEntity<Funcionario> inserir(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Dados de um novo funcionário", required = true) 
            @RequestBody Funcionario funcionario) {

        var novoCliente = service.inserir(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
    }

    @DeleteMapping("/{id}")
    @Operation (summary = "Excluir funcionário por ID", description = "Remove um funcionário pelo identificador.")
    @ApiResponse (responseCode = "204", description = "Funcionário excluído")
    public ResponseEntity<Void> deletar(
        @Parameter(description = "Identificador do funcionário", example = "1") @PathVariable Integer id) {

        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
