package br.com.clinica.paciente;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.clinica.entities.Paciente;
import br.com.clinica.repositories.PacienteRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PacienteRepositoryTest {
		
	@Autowired
	PacienteRepository pacienteRepository;
	//@Autowired
	//ConsultaRepository consultaRepository;
	
	@Test
	public void verificaIdPacienteNull() {
		Paciente paciente = new Paciente("Luan","Av. Paulista","1998-07-30", "11 979585859","2020-07-30","luan@example.com", 68.00, 2.00, "48546254889");
	
		this.pacienteRepository.save(paciente);
		
		Paciente pacienteDB = this.pacienteRepository.findOneByNome(paciente.getNome());
		
		Assertions.assertThat(pacienteDB.getId_paciente()).isNotNull();
	}
	
	@Test
	public void verificaPacienteDeletado() {
		Paciente paciente = new Paciente("Lucas","Av. Paulista","1998-07-30", "11 979605859","2020-07-30","lucas@example.com", 68.00, 2.00, "48546524889");
		
		this.pacienteRepository.save(paciente);
		
		this.pacienteRepository.delete(paciente);
		
		Assertions.assertThat(pacienteRepository.findOneByNome(paciente.getNome())).isNull();	
	}
	
	@Test
	public void verificaPacienteAlterado() {
		Paciente paciente = new Paciente("Julia","Av. Paulista","1998-07-30", "11 979605459","2020-07-30","julia@example.com", 68.00, 2.00, "48546545289");
		
		this.pacienteRepository.save(paciente);
		
		paciente.setNome("Gabriela");
		
		this.pacienteRepository.save(paciente);
		
		Paciente pacienteDB = this.pacienteRepository.findOneByNome(paciente.getNome());
		
		Assertions.assertThat(paciente.getNome()).isEqualTo(pacienteDB.getNome());
	}
	
	/*
	@Test
	public void verificaConsultaRequesitada() {
		Paciente paciente = new Paciente("Caique","Av. Kubitschek","1988-07-30", "11 970875459","2020-07-30","caique@example.com", 75.00, 2.00, "48245685789");
		
		RequesitaConsultaService requesita = new RequesitaConsultaService();
		
		requesita.addConsulta(paciente, "Dr. Valerio");
		
		Consulta consultaDB = this.consultaRepository.findOneByPaciente(paciente.getNome());
		
		Assertions.assertThat(paciente.getNome()).isEqualTo(consultaDB.getPaciente());
	
	}*/
	
	
	
}
