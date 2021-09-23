package br.com.tcc.sceh.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity()
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long codigoUsuario;

	private String userName;

	private String email;

	private String permissao;

	private String statusUsuario;

	private String senha;

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

	public String getPermissao() {
		return permissao;
	}

	public void setPermissao(String permissao) {
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

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Usuario usuario = (Usuario) o;
		return Objects.equals(codigoUsuario, usuario.codigoUsuario) && Objects.equals(userName, usuario.userName) && Objects.equals(email, usuario.email) && Objects.equals(permissao, usuario.permissao) && Objects.equals(
				statusUsuario, usuario.statusUsuario) && Objects.equals(senha, usuario.senha);
	}

	@Override public int hashCode() {
		return Objects.hash(codigoUsuario, userName, email, permissao, statusUsuario, senha);
	}

	@Override public String toString() {
		final StringBuilder sb = new StringBuilder("Usuario{");
		sb.append("codigoUsuario=").append(codigoUsuario);
		sb.append(", userName='").append(userName).append('\'');
		sb.append(", email='").append(email).append('\'');
		sb.append(", permissao='").append(permissao).append('\'');
		sb.append(", statusUsuario='").append(statusUsuario).append('\'');
		sb.append(", senha='").append(senha).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
