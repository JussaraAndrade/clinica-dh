package br.com.clinica.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.clinica.entities.Receita;

public interface ReceitaRepository extends CrudRepository<Receita, Integer> {
	
	
	Receita findOneByDescricao(String descricao);
	
	Receita findOneByTempo(int tempo);
	
	Receita findOneByDosagem(String dosagem);

	
}