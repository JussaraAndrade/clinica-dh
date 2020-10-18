package br.com.clinica.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.clinica.entities.Paciente;
import br.com.clinica.repositories.PacienteRepository;
import br.com.clinica.services.RequisitaConsultaService;

@RestController
@RequestMapping("paciente")
public class PacienteController {

	@Autowired
	PacienteRepository pacienteRepository;

	RequisitaConsultaService requisitaConsulta;

	@GetMapping
	public Iterable<Paciente> getPacientes() {
		return pacienteRepository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Paciente> getById(@PathVariable Integer id) {
		return pacienteRepository.findById(id);
	}

	@PostMapping("/requisita/{medico}")
	public void requesitaConsulta(@PathVariable String medico, @RequestBody Paciente paciente) {
		System.out.println(medico);
		requisitaConsulta.addConsulta(paciente, medico);
	}

	@PostMapping
	public void addPaciente(@RequestBody Paciente paciente) {
		pacienteRepository.save(paciente);
	}

	@DeleteMapping("/{id}")
	public void deletaPaciente(@PathVariable Integer id) {
		pacienteRepository.deleteById(id);
	}

	@PutMapping("/{idPaciente}")
	public Paciente updatePaciente(@PathVariable int idPaciente, @RequestBody Paciente dadosPaciente) throws Exception {
		Paciente pacienteDB = pacienteRepository.findById(idPaciente).orElseThrow(() -> new IllegalAccessException());
		if (dadosPaciente.getNome() != null)
			pacienteDB.setNome(dadosPaciente.getNome());
		if (dadosPaciente.getCpf() != null)
			pacienteDB.setCpf(dadosPaciente.getCpf());
		if (dadosPaciente.getPeso() != null)
			pacienteDB.setPeso(dadosPaciente.getPeso());
		if (dadosPaciente.getEmail() != null)
			pacienteDB.setEmail(dadosPaciente.getEmail());
		if (dadosPaciente.getData_nascimento() != null)
			pacienteDB.setData_nascimento(dadosPaciente.getData_nascimento());
		if (dadosPaciente.getTelefone() != null)
			pacienteDB.setTelefone(dadosPaciente.getTelefone());
		if (dadosPaciente.getAltura() != null)
			pacienteDB.setAltura(dadosPaciente.getAltura());
		if (dadosPaciente.getData_primeira_consulta() != null)
			pacienteDB.setData_primeira_consulta(dadosPaciente.getData_primeira_consulta());
		if (dadosPaciente.getEndereco() != null)
			pacienteDB.setEndereco(dadosPaciente.getEndereco());

		return pacienteRepository.save(pacienteDB);
	}
}
