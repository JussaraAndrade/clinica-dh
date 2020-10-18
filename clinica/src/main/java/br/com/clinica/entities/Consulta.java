package br.com.clinica.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_consulta;
	private Date data_consulta;
	private Double valor;
	private String descricao;
	private String medico;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_paciente")
	@JsonIgnoreProperties("consultas")
	private Paciente paciente;

	public Consulta() {}
	
	public Consulta(Date data_consulta, Double valor, String descricao, String medico,
			Paciente paciente) {
		this.data_consulta = data_consulta;
		this.valor = valor;
		this.descricao = descricao;
		this.medico = medico;
		this.paciente = paciente;
	}

	public Integer getId_consulta() {
		return id_consulta;
	}

	public void setId_consulta(Integer id_consulta) {
		this.id_consulta = id_consulta;
	}

	public Date getData_consulta() {
		return data_consulta;
	}

	public void setData_consulta(Date data_consulta) {
		this.data_consulta = data_consulta;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
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
