package br.com.clinica.receita;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.clinica.entities.Receita;
import br.com.clinica.repositories.ReceitaRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ReceitaRepositoryTest {

	@Autowired
	ReceitaRepository receitaRepository;

	@Test
	public void verificaIdReceitaNull() {
		Receita receita = new Receita("Soro", 6, "3");

		this.receitaRepository.save(receita);

		Receita receitaDb = this.receitaRepository.findOneByDescricao(receita.getDescricao());

		Assertions.assertThat(receitaDb.getId()).isNotNull();

	}

	@Test
	public void verificaDescricaoReceitaNull() {
		Receita receita = new Receita("Vitamina", 2, "9");

		this.receitaRepository.save(receita);

		Receita receitaDb = this.receitaRepository.findOneByDescricao(receita.getDescricao());

		Assertions.assertThat(receitaDb.getDescricao()).isNotNull();
	}

	@Test
	public void verificaTempoReceitaNull() {
		Receita receita = new Receita("Sufato", 5, "7");

		this.receitaRepository.save(receita);

		Receita receitaDb = this.receitaRepository.findOneByTempo(receita.getTempo());

		Assertions.assertThat(receitaDb.getTempo()).isNotNull();

	}

	@Test
	public void verificaDosagemReceitaNull() {
		Receita receita = new Receita("Biotonico", 2, "2");

		this.receitaRepository.save(receita);

		Receita receitaDb = this.receitaRepository.findOneByDosagem(receita.getDosagem());

		Assertions.assertThat(receitaDb.getDosagem()).isNotNull();
	}

	@Test
	public void verificaReceitaAtualizado() {
		Receita receita = new Receita("Dipirona", 9, "8");

		this.receitaRepository.save(receita);

		receita.setDescricao("Divertil");
		receita.setTempo(4);
		receita.setDosagem("10");

		Receita receitaAtualizado = this.receitaRepository.findOneByDescricao(receita.getDescricao());

		Assertions.assertThat(receitaAtualizado.getDescricao()).isEqualTo(receita.getDescricao());

	}

	@Test
	public void verificaReceitaDeletado() {
		Receita receita = new Receita("Semancol", 10, "9");

		this.receitaRepository.save(receita);

		this.receitaRepository.delete(receita);

		Assertions.assertThat(this.receitaRepository.findOneByDescricao(receita.getDescricao())).isNull();

	}

}
