package br.com.tcc.sceh.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Endereco {

	@Id
	private String codigoEndereco;
	private String rua;
	private String numero;
	private String cidade;
	private String estado;
	private String cep;
	private String complemento;
	private String obversacao;

	public Endereco() {
	}

	public Endereco(String codigoEndereco, String rua, String numero, String cidade, String estado, String cep,
			String complemento, String obversacao) {
		super();
		this.codigoEndereco = codigoEndereco;
		this.rua = rua;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.complemento = complemento;
		this.obversacao = obversacao;
	}

	public String getCodigoEndereco() {
		return codigoEndereco;
	}

	public void setCodigoEndereco(String codigoEndereco) {
		this.codigoEndereco = codigoEndereco;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getObversacao() {
		return obversacao;
	}

	public void setObversacao(String obversacao) {
		this.obversacao = obversacao;
	}

}
