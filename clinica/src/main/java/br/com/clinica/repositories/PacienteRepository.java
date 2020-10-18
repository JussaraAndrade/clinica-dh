package br.com.clinica.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.clinica.entities.Paciente;

public interface PacienteRepository extends CrudRepository <Paciente, Integer>{
	
	Paciente findOneByNome(String nome);
	Paciente findOneByCpf(String cpf);
}
