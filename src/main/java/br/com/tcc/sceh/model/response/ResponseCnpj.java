package br.com.tcc.sceh.model.response;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ResponseCnpj {

	private String nomeFantasia;
	private String razaoSocial;
	private String cnpj;
	private String cnaePrincipalDescricao;
	private String cnaePrincipalCodigo;
	private String cep;
	private String dataAbertura;
	private String ddd;
	private String telefone;
	private String email;
	private String tipoLogradouro;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String municipio;
	private String uf;

	public ResponseCnpj() {
	}
	public ResponseCnpj(final String nomeFantasia, final String razaoSocial, final String cnpj,
			final String cnaePrincipalDescricao, final String cnaePrincipalCodigo, final String cep,
			final String dataAbertura, final String ddd, final String telefone, final String email,
			final String tipoLogradouro, final String logradouro, final String numero, final String complemento,
			final String bairro, final String municipio, final String uf) {
		this.nomeFantasia = nomeFantasia;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.cnaePrincipalDescricao = cnaePrincipalDescricao;
		this.cnaePrincipalCodigo = cnaePrincipalCodigo;
		this.cep = cep;
		this.dataAbertura = dataAbertura;
		this.ddd = ddd;
		this.telefone = telefone;
		this.email = email;
		this.tipoLogradouro = tipoLogradouro;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.municipio = municipio;
		this.uf = uf;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(final String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(final String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(final String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCnaePrincipalDescricao() {
		return cnaePrincipalDescricao;
	}

	public void setCnaePrincipalDescricao(final String cnaePrincipalDescricao) {
		this.cnaePrincipalDescricao = cnaePrincipalDescricao;
	}

	public String getCnaePrincipalCodigo() {
		return cnaePrincipalCodigo;
	}

	public void setCnaePrincipalCodigo(final String cnaePrincipalCodigo) {
		this.cnaePrincipalCodigo = cnaePrincipalCodigo;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(final String cep) {
		this.cep = cep;
	}

	public String getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(final String dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(final String ddd) {
		this.ddd = ddd;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(final String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(final String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(final String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(final String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(final String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(final String bairro) {
		this.bairro = bairro;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(final String municipio) {
		this.municipio = municipio;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(final String uf) {
		this.uf = uf;
	}

	@Override public String toString() {
		return new ToStringBuilder(this).append("nomeFantasia", nomeFantasia).append("razaoSocial", razaoSocial)
				.append("cnpj", cnpj).append("cnaePrincipalDescricao", cnaePrincipalDescricao)
				.append("cnaePrincipalCodigo", cnaePrincipalCodigo).append("cep", cep)
				.append("dataAbertura", dataAbertura).append("ddd", ddd).append("telefone", telefone)
				.append("email", email).append("tipoLogradouro", tipoLogradouro).append("logradouro", logradouro)
				.append("numero", numero).append("complemento", complemento).append("bairro", bairro)
				.append("municipio", municipio).append("uf", uf).toString();
	}
}
