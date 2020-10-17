package br.com.clinica.consulta;

import java.util.Date;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.clinica.models.entities.Consulta;
import br.com.clinica.models.repositories.ConsultaRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ConsultaRepositoryTest {
	@Autowired
	ConsultaRepository consultaRepository;
	
	@Test
	public void verificaIdConsultaNull() {
		Date data = new Date();
		Paciente paciente = new Paciente("Sr. Marcelo");
		
		Consulta consulta = new Consulta(data, 150.4f, "Consulta com o otorrino", "Dr. Paulo", paciente);
		
		this.consultaRepository.save(consulta);
		
		Consulta consultaDb = this.consultaRepository.findOneByMedico("Luciano");
		
		Assertions.assertThat(consultaDb.getId_consulta()).isNotNull();
	}
	
	@Test
	public void verificaMedico() {
		Date data = new Date();
		Paciente paciente = new Paciente("Sr. Marcelo");
		
		Consulta consulta = new Consulta(data, 150.4f, "Consulta com o otorrino", "Dr. Paulo", paciente);
		
		this.consultaRepository.save(consulta);
		
		Consulta consultaDb = this.consultaRepository.findOneByDescricao(consulta.getDescricao());
		
		Assertions.assertThat(consultaDb.getMedico()).isNotNull();
	}
	
	@Test
	public void verificaConsultaDeletada() {
		Date data = new Date();
		Paciente paciente = new Paciente("Sr. Marcelo");
		
		Consulta consulta = new Consulta(data, 150.4f, "Consulta com o otorrino", "Dr. Paulo", paciente);
		
		this.consultaRepository.save(consulta);
		
		this.consultaRepository.delete(consulta);
		
		Assertions.assertThat(this.consultaRepository.findOneByDescricao(consulta.getDescricao())).isNull();
	}
	
	@Test
	public void verificaConsultaAtualizada() {
		Date data = new Date();
		Paciente paciente = new Paciente("Sr. Marcelo");
		
		Consulta consulta = new Consulta(data, 150.4f, "Consulta com o otorrino", "Dr. Paulo", paciente);
		
		this.consultaRepository.save(consulta);
		
		consulta.setValor(200.56f);
		consulta.setDescricao("Consulta com o pediatra");
		
		Consulta consultaAtualizada = this.consultaRepository.findOneByDescricao(consulta.getDescricao());
		
		Assertions.assertThat(consultaAtualizada.getDescricao()).isEqualTo(consulta.getDescricao());
	}
}
