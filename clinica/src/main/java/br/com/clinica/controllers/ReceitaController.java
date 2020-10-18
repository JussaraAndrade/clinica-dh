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
import org.springframework.web.bind.annotation.RestController;

import br.com.clinica.entities.Receita;
import br.com.clinica.repositories.ReceitaRepository;

@RestController
@RequestMapping("receita")
public class ReceitaController {
	@Autowired
	private ReceitaRepository receitaRepository;
	
	@GetMapping
	public Iterable<Receita> Consultar(){
		return receitaRepository.findAll(); 
	}
	
	@GetMapping("/{id}")
	public Optional <Receita> ConsultaId(@PathVariable Integer id){
		return receitaRepository.findById(id);
	}

	@PostMapping
	public Receita Inserir(@RequestBody Receita receita) {
		receitaRepository.save(receita);
		return receita;
	}
	
	@DeleteMapping("/{id}")
	public void Deletar(@PathVariable int id) {
		receitaRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Receita Alterar(@PathVariable int id, @RequestBody Receita dadosReceita) throws Exception {
		Receita receitaDB = receitaRepository.findById(id).orElseThrow(()-> new IllegalAccessException());
		
		if(dadosReceita.getDescricao() != receitaDB.getDescricao()) {
			receitaDB.setDescricao(dadosReceita.getDescricao());
		}
		if(dadosReceita.getTempo() != receitaDB.getTempo()) {
			receitaDB.setTempo(dadosReceita.getTempo());
		}
		if(dadosReceita.getDosagem() != receitaDB.getDosagem()) {
			receitaDB.setDosagem(dadosReceita.getDosagem());
		}
		
		receitaRepository.save(receitaDB);
		
		return receitaDB;
	}

}