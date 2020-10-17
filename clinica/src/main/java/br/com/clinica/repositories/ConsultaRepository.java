package br.com.clinica.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.clinica.entities.Consulta;
import br.com.clinica.entities.Paciente;

public interface ConsultaRepository extends CrudRepository<Consulta, Integer>{
	
	Consulta findOneByPaciente(Paciente paciente);
	Consulta findOneByMedico(String medico);	
	Consulta findOneByDescricao(String descricao);
}
