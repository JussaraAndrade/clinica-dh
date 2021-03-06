package br.com.clinica.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.clinica.entities.Consulta;
import br.com.clinica.repositories.ConsultaRepository;

@RestController
@RequestMapping("consulta")
public class ConsultaController {

	@Autowired
	ConsultaRepository consultaRepository;

	@GetMapping
	public Iterable<Consulta> getConsultas() {
		return consultaRepository.findAll();
	}

	@PostMapping
	public Consulta inserirConsulta(@RequestBody Consulta consulta) {
		consultaRepository.save(consulta);
		return consulta;

	}

	@DeleteMapping("/{id}")
	public void deleteConsulta(@PathVariable int id) {
		consultaRepository.deleteById(id);
	}

	@PutMapping("/{id}")
	public Consulta updateConsulta(@PathVariable int id, @RequestBody Consulta consulta) throws Exception {
		Consulta consultaDB = consultaRepository.findById(id).orElseThrow(() -> new IllegalAccessException());

		if (consulta.getMedico() != consultaDB.getMedico()) {
			consultaDB.setMedico(consulta.getMedico());
		}
		if (consulta.getDescricao() != consultaDB.getDescricao()) {
			consultaDB.setDescricao(consulta.getDescricao());
		}
		consultaRepository.save(consultaDB);
		return consultaDB;
	}

}
