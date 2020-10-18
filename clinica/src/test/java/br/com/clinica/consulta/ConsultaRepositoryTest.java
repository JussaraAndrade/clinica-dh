package br.com.clinica.consulta;

import java.util.Date;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.clinica.entities.Consulta;
import br.com.clinica.entities.Paciente;
import br.com.clinica.repositories.ConsultaRepository;
import br.com.clinica.repositories.PacienteRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ConsultaRepositoryTest {
	@Autowired
	ConsultaRepository consultaRepository;
	@Autowired
	PacienteRepository pacienteRepository;
	
	@Test
	public void verificaIdConsultaNull() {
		Paciente paciente = new Paciente("Roberto", "Av. Ipiranga", "1990-08-23", "11 923907654", "2020-09-12", "roberto@email.com", 75.0, 1.75, "46397830154");
		this.pacienteRepository.save(paciente);
		
		Consulta consulta = new Consulta(new Date(), 150.4, "Consulta com o otorrino", "Dr. Paulo", paciente);
		this.consultaRepository.save(consulta);
		
		Consulta consultaDb = this.consultaRepository.findOneByDescricao(consulta.getDescricao());
		
		Assertions.assertThat(consultaDb.getId_consulta()).isNotNull();
	}
	
	@Test
	public void verificaMedico() {
		Paciente paciente = new Paciente("Olivia", "Avenida Ipiranga", "1990-02-15", "11 980345621", "2020-05-18", "olivia@email.com", 78.4, 1.74, "14285692103");
		this.pacienteRepository.save(paciente);
		
		Consulta consulta = new Consulta(new Date(), 150.4, "Consulta com o otorrino", "Dr. Paulo", paciente);
		this.consultaRepository.save(consulta);
		
		Consulta consultaDb = this.consultaRepository.findOneByMedico(consulta.getMedico());
		
		Assertions.assertThat(consultaDb.getMedico()).isNotNull();
	}
	
	@Test
	public void verificaConsultaDeletada() {
		Paciente paciente = new Paciente("Bruna", "Av. Ipiranga", "1990-08-23", "11 923907654", "2020-09-12", "bruna@email.com", 75.0, 1.75, "46397830154");
		this.pacienteRepository.save(paciente);
		
		Consulta consulta = new Consulta(new Date(), 150.4, "Consulta com o otorrino", "Dr. Paulo", paciente);
		
		this.consultaRepository.save(consulta);
		this.consultaRepository.delete(consulta);
		
		Assertions.assertThat(this.consultaRepository.findOneByDescricao(consulta.getDescricao())).isNull();
	}
	
	@Test
	public void verificaConsultaAtualizada() {
		Paciente paciente = new Paciente("Joana", "Av. Ipiranga", "1990-08-23", "11 923907654", "2020-09-12", "joana@email.com", 75.0, 1.75, "46397830154");
		this.pacienteRepository.save(paciente);
		
		Consulta consulta = new Consulta(new Date(), 150.4, "Consulta com o otorrino", "Dr. Paulo", paciente);
		this.consultaRepository.save(consulta);
		
		consulta.setDescricao("Consulta com o pediatra");
		this.consultaRepository.save(consulta);
		
		Consulta consultaAtualizada = this.consultaRepository.findOneByDescricao(consulta.getDescricao());
		
		Assertions.assertThat(consultaAtualizada.getDescricao()).isEqualTo(consulta.getDescricao());
	}
}
