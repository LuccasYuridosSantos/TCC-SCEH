package br.com.tcc.sceh.model;

import br.com.tcc.sceh.enums.Permissao;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.lang.Nullable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigoUsuario;

	private String userName;

	private String email;

	private Permissao permissao;

	private String statusUsuario;

	private String senha;

	@ManyToOne
	private Hospital hospital;

	@ManyToOne(cascade = CascadeType.ALL)
	private Funcionario funcionario;

	public Usuario() {
	}

	public Usuario(Long codigoUsuario, String userName, String email, Permissao permissao, String statusUsuario,
				   String senha, Hospital hospital, Funcionario funcionario) {
		this.codigoUsuario = codigoUsuario;
		this.userName = userName;
		this.email = email;
		this.permissao = permissao;
		this.statusUsuario = statusUsuario;
		this.senha = senha;
		this.hospital = hospital;
		this.funcionario = funcionario;
	}

	public Long getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(Long codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}

	public String getStatusUsuario() {
		return statusUsuario;
	}

	public void setStatusUsuario(String statusUsuario) {
		this.statusUsuario = statusUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		Usuario usuario = (Usuario) o;

		return new EqualsBuilder().append(codigoUsuario, usuario.codigoUsuario).append(userName, usuario.userName).append(email, usuario.email).append(permissao, usuario.permissao).append(statusUsuario, usuario.statusUsuario).append(senha, usuario.senha).append(hospital, usuario.hospital).append(funcionario, usuario.funcionario).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(codigoUsuario).append(userName).append(email).append(permissao).append(statusUsuario).append(senha).append(hospital).append(funcionario).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("codigoUsuario", codigoUsuario)
				.append("userName", userName)
				.append("email", email)
				.append("permissao", permissao)
				.append("statusUsuario", statusUsuario)
				.append("senha", senha)
				.append("hospital", hospital)
				.append("funcionario", funcionario)
				.toString();
	}
}
