package br.com.tcc.sceh.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoFuncionario;
	private String matricula;
	private String nome;
	private LocalDate dataNascimento;
	private boolean status;

	@ManyToOne(cascade = CascadeType.ALL)
	private Cargo cargo;

	public Funcionario() {
	}

	public Funcionario(final Long codigoFuncionario, final String matricula, final String nome,
			final LocalDate dataNascimento, final boolean status, final Cargo cargo) {
		this.codigoFuncionario = codigoFuncionario;
		this.matricula = matricula;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.status = status;
		this.cargo = cargo;
	}

	public Long getCodigoFuncionario() {
		return codigoFuncionario;
	}

	public void setCodigoFuncionario(final Long codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(final String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(final LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(final boolean status) {
		this.status = status;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(final Cargo cargo) {
		this.cargo = cargo;
	}
}
