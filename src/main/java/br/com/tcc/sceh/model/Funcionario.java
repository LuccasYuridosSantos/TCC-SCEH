package br.com.tcc.sceh.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

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

	@OneToMany(cascade = CascadeType.ALL)
	private List<Telefone> telefone;

	@ManyToOne(cascade = CascadeType.ALL)
	private Cargo cargo;

	public Funcionario() {
	}

	public Funcionario(Long codigoFuncionario, String matricula, String nome, LocalDate dataNascimento, boolean status, List<Telefone> telefone, Cargo cargo) {
		this.codigoFuncionario = codigoFuncionario;
		this.matricula = matricula;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.status = status;
		this.telefone = telefone;
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

	public List<Telefone> getTelefone() {
		return telefone;
	}

	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
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
		return status == that.status && Objects.equals(codigoFuncionario, that.codigoFuncionario) && Objects.equals(matricula, that.matricula) && Objects.equals(nome, that.nome) && Objects.equals(dataNascimento, that.dataNascimento) && Objects.equals(telefone, that.telefone) && Objects.equals(cargo, that.cargo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoFuncionario, matricula, nome, dataNascimento, status, telefone, cargo);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("codigoFuncionario", codigoFuncionario)
				.append("matricula", matricula)
				.append("nome", nome)
				.append("dataNascimento", dataNascimento)
				.append("status", status)
				.append("telefone", telefone)
				.append("cargo", cargo)
				.toString();
	}
}
