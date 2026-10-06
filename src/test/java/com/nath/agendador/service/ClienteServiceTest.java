package com.nath.agendador.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.nath.agendador.domain.Cliente;
import com.nath.agendador.repository.ClienteRepository;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @Test
    void deveSalvarClienteQuandoDadosForemValidos() {
        Cliente cliente = new Cliente("Ana", "11999999999");
        when(clienteRepository.save(cliente)).thenReturn(cliente);

        Cliente salvo = clienteService.inserir(cliente);

        assertEquals("Ana", salvo.getNome());
        assertEquals("11999999999", salvo.getTelefone());
        verify(clienteRepository).save(cliente);
    }
}
