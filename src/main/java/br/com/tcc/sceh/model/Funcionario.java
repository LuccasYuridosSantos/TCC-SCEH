package br.com.tcc.sceh.model;

import java.time.LocalDate;

public class Funcionario {
	private String codigoFuncionario;
	private String matricula;
	private String nome;
	private LocalDate dataNascimento;
	private boolean status;
	
	public Funcionario() {
		
	}

	public Funcionario(String codigoFuncionario, String matricula, String nome, LocalDate dataNascimento,
			boolean status) {
		super();
		this.codigoFuncionario = codigoFuncionario;
		this.matricula = matricula;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.status = status;
	}

	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}

	public void setCodigoFuncionario(String codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
