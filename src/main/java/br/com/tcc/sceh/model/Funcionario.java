package br.com.tcc.sceh.model;

import br.com.tcc.sceh.model.Permissao;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoFuncionario;
	private String matricula;
	private String nome;
	private boolean status;
	private String username;
	private String senha;

	@ManyToOne
	private Hospital hospital;

	@ManyToOne
	private Permissao permissao;

	public Funcionario() {
	}

	public Funcionario(final Long codigoFuncionario, final String matricula, final String nome, final boolean status,
			final String username, final String senha, final Hospital hospital, final Permissao permissao) {
		this.codigoFuncionario = codigoFuncionario;
		this.matricula = matricula;
		this.nome = nome;
		this.status = status;
		this.username = username;
		this.senha = senha;
		this.hospital = hospital;
		this.permissao = permissao;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(final boolean status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(final String senha) {
		this.senha = senha;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(final Hospital hospital) {
		this.hospital = hospital;
	}

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(final Permissao permissao) {
		this.permissao = permissao;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		final Funcionario that = (Funcionario) o;

		return new EqualsBuilder().append(status, that.status).append(codigoFuncionario, that.codigoFuncionario)
				.append(matricula, that.matricula).append(nome, that.nome).append(username, that.username)
				.append(senha, that.senha).append(hospital, that.hospital).append(permissao, that.permissao).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(codigoFuncionario).append(matricula).append(nome).append(status)
				.append(username).append(senha).append(hospital).append(permissao).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("codigoFuncionario", codigoFuncionario).append("matricula", matricula)
				.append("nome", nome).append("status", status).append("username", username).append("senha", senha)
				.append("hospital", hospital).append("permissao", permissao).toString();
	}
}
