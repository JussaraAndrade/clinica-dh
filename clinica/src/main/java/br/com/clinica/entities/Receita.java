package br.com.clinica.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Receita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_receita;
	private String descricao;
	private int tempo;
	private String dosagem;
	
	public Receita() {}
	
	public Receita(String descricao, int tempo, String dosagem) {
		this.descricao = descricao;
		this.tempo = tempo;
		this.dosagem = dosagem;
	}
	
	public int getId() {
		return id_receita;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public String getDosagem() {
		return dosagem;
	}

	public void setDosagem(String dosagem) {
		this.dosagem = dosagem;
	}
	
}
