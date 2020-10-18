package br.com.clinica.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import br.com.clinica.entities.Consulta;
import br.com.clinica.entities.Paciente;
import br.com.clinica.repositories.ConsultaRepository;

public class RequisitaConsultaService {
	
	@Autowired
	ConsultaRepository consultaRepository;
	
	public void addConsulta(Paciente paciente, String medico) {
		
		Consulta consulta = new Consulta(new Date(), 129.99, "Paciente com ebola", medico, paciente);
		
		this.consultaRepository.save(consulta);
		
	}
}