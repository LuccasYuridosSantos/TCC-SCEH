package br.com.tcc.sceh.model.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FuncionarioLogin {

	private Long codigoFuncionario;
	private String nome;
	private String username;
	private String senha;
	private String nomeHospital;
	private String cnpj;
	private String token;
	private String permissao;

	public Long getCodigoFuncionario() {
		return codigoFuncionario;
	}

	public void setCodigoFuncionario(final Long codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
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

	public String getNomeHospital() {
		return nomeHospital;
	}

	public void setNomeHospital(final String nomeHospital) {
		this.nomeHospital = nomeHospital;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(final String cnpj) {
		this.cnpj = cnpj;
	}

	public String getToken() {
		return token;
	}

	public void setToken(final String token) {
		this.token = token;
	}

	public String getPermissao() {
		return permissao;
	}

	public void setPermissao(final String permissao) {
		this.permissao = permissao;
	}
}
