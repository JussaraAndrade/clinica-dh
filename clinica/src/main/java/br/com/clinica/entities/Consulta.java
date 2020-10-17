package br.com.clinica.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_consulta;
	@Column(name="dataConsulta")
	private Date data_consulta;
	@Column
	private float valor;
	@Column
	private String descricao;
	@Column
	private String medico;
	
	@JoinColumn(name = "fk_id_cliente")
	private Paciente paciente;

	public Consulta(Date data_consulta, float valor, String descricao, String medico,
			Paciente paciente) {
		this.data_consulta = data_consulta;
		this.valor = valor;
		this.descricao = descricao;
		this.medico = medico;
		this.paciente = paciente;
	}

	public int getId_consulta() {
		return id_consulta;
	}

	public void setId_consulta(int id_consulta) {
		this.id_consulta = id_consulta;
	}

	public Date getData_consulta() {
		return data_consulta;
	}

	public void setData_consulta(Date data_consulta) {
		this.data_consulta = data_consulta;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMedico() {
		return medico;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
}
