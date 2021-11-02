package br.com.tcc.sceh.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoEndereco;
	private String rua;
	private String numero;
	private String cidade;
	private String estado;
	private String cep;
	private String complemento;
	private String obversacao;

	@ManyToOne
	private Funcionario funcionario;

	@ManyToOne
	private Hospital hospital;

	public Endereco() {
	}

	public Endereco(final Long codigoEndereco, final String rua, final String numero, final String cidade,
			final String estado, final String cep, final String complemento, final String obversacao,
			final Funcionario funcionario, final Hospital hospital) {
		this.codigoEndereco = codigoEndereco;
		this.rua = rua;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.complemento = complemento;
		this.obversacao = obversacao;
		this.funcionario = funcionario;
		this.hospital = hospital;
	}

	public Long getCodigoEndereco() {
		return codigoEndereco;
	}

	public void setCodigoEndereco(final Long codigoEndereco) {
		this.codigoEndereco = codigoEndereco;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(final String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(final String numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(final String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(final String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(final String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(final String complemento) {
		this.complemento = complemento;
	}

	public String getObversacao() {
		return obversacao;
	}

	public void setObversacao(final String obversacao) {
		this.obversacao = obversacao;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(final Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(final Hospital hospital) {
		this.hospital = hospital;
	}
}
