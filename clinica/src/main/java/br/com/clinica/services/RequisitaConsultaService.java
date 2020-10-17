package br.com.clinica.services;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.clinica.entities.Paciente;

public class RequisitaConsultaService {
	
	@Autowired
	ConsultaRepository consultaRepository;
	
	
	public static void addConsulta(Paciente paciente, String medico) {
		LocalDateTime now = LocalDateTime.now(); 
		
		Consulta consulta = new Consulta(paciente.getNome(), now, 129.99, "Paciente com ebola", medico );
		
		consultaRepository.save(consulta);
		
		
	}
}
