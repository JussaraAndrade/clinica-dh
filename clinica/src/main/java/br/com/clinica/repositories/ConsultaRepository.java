package br.com.clinica.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.clinica.entities.Consulta;

public interface ConsultaRepository extends CrudRepository<Consulta, Integer>{
	Consulta findOneByMedico(String medico);
	
	List<Consulta> findByMedicoAndDescricao(String medico, String descricao);
	
	List<Consulta> findByMedico(String medico);
	
	Consulta findOneByDescricao(String descricao);
	
	List<Consulta> findByDescricaoContaining(String descricao);
	
	String query = "SELECT descricao FROM consulta WHERE descricao LIKE %:descricao%";
	
	@Query(value = query, nativeQuery = true)
	List<Object[]> encontrarConsultaParecida(String descricao);
}
