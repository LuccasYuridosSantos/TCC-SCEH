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

	public Funcionario(Long codigoFuncionario, String matricula, String nome, LocalDate dataNascimento,
					   boolean status, Cargo cargo) {
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

	public void setCodigoFuncionario(Long codigoFuncionario) {
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

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		Funcionario that = (Funcionario) o;

		return new EqualsBuilder().append(status, that.status).append(codigoFuncionario, that.codigoFuncionario)
				.append(matricula, that.matricula).append(nome, that.nome).append(dataNascimento, that.dataNascimento)
				.append(cargo, that.cargo).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(codigoFuncionario).append(matricula).append(nome).append(dataNascimento).append(status)
				.append(cargo).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("codigoFuncionario", codigoFuncionario)
				.append("matricula", matricula)
				.append("nome", nome)
				.append("dataNascimento", dataNascimento)
				.append("status", status)
				.append("cargo", cargo)
				.toString();
	}
}
