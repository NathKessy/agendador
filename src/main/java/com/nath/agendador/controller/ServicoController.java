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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/servico")
@Tag(name = " Serviços", description = "Operações para gerenciamento de serviços")
public class ServicoController {

    @Autowired
    private ServicoService service;

    @GetMapping("/{id}")
    @Operation(summary = "Buscar serviço por ID", description = "Busca um serviço pelo identificador.")
    @ApiResponse(responseCode = "200", description = "Serviço encontrado")
    public ResponseEntity<Servico> buscar(
            @Parameter(description = "Identificador de serviço", example = "1") @PathVariable Integer id) {
                
        var servico = service.buscar(id);
        return ResponseEntity.ok().body(servico);
    }

    @GetMapping
    @Operation(summary = "Listar serviço", description = "Retornar todos os serviços cadastrados.")
    @ApiResponse(responseCode = "200", description = "Lista de serviços retornado")
    public ResponseEntity<List<Servico>> buscarTodos() {

        var servico = service.buscarTodos();
        return ResponseEntity.ok().body(servico);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar serviço por ID", description = "Atualiza os dados de um serviço existente.")
    @ApiResponse(responseCode = "200", description = "Serviço atualizado")
    public ResponseEntity<Servico> atualizar(
            @Parameter(description = "Identificador de serviços", example = "1") @PathVariable Integer id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Dados atualizado do serviço", required = true) 
            @RequestBody Servico servico) {

        var atualizado = service.atualizar(id, servico);
        return ResponseEntity.ok(atualizado);
    }

    @PostMapping
    @Operation(summary = "Cadastrar serviço", description = "Criar um novo serviço.")
    @ApiResponse(responseCode = "201", description = "Serviço criado")
    public ResponseEntity<Servico> inserir(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Dados de um novo serviço", required = true) 
            @RequestBody Servico servico) {

        var novoServico = service.inserir(servico);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoServico);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir serviço por ID", description = "Remove um serviço por identificador.")
    @ApiResponse(responseCode = "204", description = "Serviço excluído")
    public ResponseEntity<Void> deletar(
            @Parameter(description = "Identificador do cliente", example = "1") @PathVariable Integer id) {

        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
