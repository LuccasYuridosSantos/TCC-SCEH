package br.com.tcc.sceh.model.requests;

public class HospitalRequest {

	private String cnpj;
	private String observacao;
	private String tipo;
	private String ddd;
	private String telefone;

	public HospitalRequest(final String cnpj, final String observacao, final String tipo, final String ddd,
			final String telefone) {
		this.cnpj = cnpj;
		this.observacao = observacao;
		this.tipo = tipo;
		this.ddd = ddd;
		this.telefone = telefone;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(final String cnpj) {
		this.cnpj = cnpj;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(final String observacao) {
		this.observacao = observacao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(final String tipo) {
		this.tipo = tipo;
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
}
