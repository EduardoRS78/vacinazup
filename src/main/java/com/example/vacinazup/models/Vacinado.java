package com.example.vacinazup.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Vacinado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cod;
	
	@NotEmpty
	@CPF
	private String cpf;
	
	@NotEmpty
	private String nome;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	private String dataNasc;
	
	@NotEmpty
	private String dataVacinacao;
	
	@ManyToOne
	private Vacina vacina;
	
	

	public long getCod() {
		return cod;
	}

	public void setCod(long cod) {
		this.cod = cod;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getDataVacinacao() {
		return dataVacinacao;
	}

	public void setDataVacinacao(String dataVacinacao) {
		this.dataVacinacao = dataVacinacao;
	}

	public Vacina getVacina() {
		return vacina;
	}

	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}
	
	
	
	
	

}
