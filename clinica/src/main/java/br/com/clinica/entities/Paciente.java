package br.com.clinica.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_paciente;
	private String nome;
	private String endereco;
	private String data_nascimento;
	private String telefone;
	private String data_primeira_consulta;
	private String email;
	private Double peso;
	private Double altura;
	private String cpf;
	
	@OneToMany(mappedBy = "paciente")
	private Set<Consulta> consultas;
	
	public Paciente() {}

	public Paciente(String nome, String endereco, String data_nascimento, String telefone,
			String data_primeira_consulta, String email, Double peso, Double altura, String cpf) {
		this.nome = nome;
		this.endereco = endereco;
		this.data_nascimento = data_nascimento;
		this.telefone = telefone;
		this.data_primeira_consulta = data_primeira_consulta;
		this.email = email;
		this.peso = peso;
		this.altura = altura;
		this.cpf = cpf;
	}

	public Integer getId_paciente() {
		return id_paciente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getData_primeira_consulta() {
		return data_primeira_consulta;
	}

	public void setData_primeira_consulta(String data_primeira_consulta) {
		this.data_primeira_consulta = data_primeira_consulta;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
	
}
