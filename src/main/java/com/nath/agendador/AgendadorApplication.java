package com.nath.agendador;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nath.agendador.domain.Agenda;
import com.nath.agendador.domain.Cliente;
import com.nath.agendador.domain.Funcionario;
import com.nath.agendador.domain.Servico;
import com.nath.agendador.repository.AgendaRepository;
import com.nath.agendador.repository.ClienteRepository;
import com.nath.agendador.repository.FuncionarioRepository;
import com.nath.agendador.repository.ServicoRepository;

@SpringBootApplication
public class AgendadorApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired 
	private FuncionarioRepository funcionarioRepository;

	@Autowired 
	private AgendaRepository agendaRepository;

	@Autowired 
	private ServicoRepository servicoRepository;

	public static void main(String[] args) {
		SpringApplication.run(AgendadorApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Cliente cliente1 = new Cliente(
				"Nathalie Kessy", 
				"11 91313-2222");

		var cliente2 = new Cliente(
				"Gustavo Alves", 
				"11 94889-8486");

		clienteRepository.saveAll(List.of(cliente1, cliente2));

		Funcionario funcionario1 = new Funcionario(
				"Liguidinha",
				"11 91234-5678",
				"412.582.638.23",
				"liguidinha@gmail.com",
				"21");

		Funcionario funcionario2 = new Funcionario(
				"Simba",
				"11 97894-5632",
				"455.927.528.90",
				"simba@gmail.com",
				"19");

		Funcionario funcionario3 = new Funcionario(
				"Lucy Fubanga",
				"12 94563-9872",
				"568.987.412.56",
				"lfubanga@gmail.com",
				"18");

		funcionarioRepository.saveAll(List.of(funcionario1, funcionario2, funcionario3));

		Agenda agenda1 = new  Agenda(LocalDateTime.now(), LocalDateTime.of(2026, 10, 3, 15, 0), "É MT BOM");
		Agenda agenda2 = new Agenda(LocalDateTime.now(), LocalDateTime.now());

		agendaRepository.saveAll(List.of(agenda1, agenda2));

		Servico servico = new Servico("Tosar a Fubanga", "Gato com muito pelo que precisa ser podado", 500);

		servicoRepository.save(servico);
	}

}
