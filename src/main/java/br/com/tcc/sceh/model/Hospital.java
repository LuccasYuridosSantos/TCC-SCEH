package br.com.tcc.sceh.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity @JsonInclude(JsonInclude.Include.NON_NULL)
public class Hospital {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoHospital;
	private String cnpj;
	private String razaoSocial;
	private String nomeFantasia;
	private String tipo;
	private String rua;
	private int numero;
	private String cidade;
	private String estado;
	private String cep;
	private String complemento;
	private String observacao;

	public Hospital() {
	}

	public Hospital(final Long codigoHospital, final String cnpj, final String razaoSocial, final String nomeFantasia,
			final String tipo, final String rua, final int numero, final String cidade, final String estado,
			final String cep, final String complemento, final String observacao) {
		this.codigoHospital = codigoHospital;
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.tipo = tipo;
		this.rua = rua;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.complemento = complemento;
		this.observacao = observacao;
	}

	public Long getCodigoHospital() {
		return codigoHospital;
	}

	public void setCodigoHospital(final Long codigoHospital) {
		this.codigoHospital = codigoHospital;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(final String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(final String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(final String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(final String tipo) {
		this.tipo = tipo;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(final String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(final int numero) {
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

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(final String observacao) {
		this.observacao = observacao;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		final Hospital hospital = (Hospital) o;

		return new EqualsBuilder().append(numero, hospital.numero).append(codigoHospital, hospital.codigoHospital)
				.append(cnpj, hospital.cnpj).append(razaoSocial, hospital.razaoSocial)
				.append(nomeFantasia, hospital.nomeFantasia).append(tipo, hospital.tipo).append(rua, hospital.rua)
				.append(cidade, hospital.cidade).append(estado, hospital.estado).append(cep, hospital.cep)
				.append(complemento, hospital.complemento).append(observacao, hospital.observacao).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(codigoHospital).append(cnpj).append(razaoSocial).append(nomeFantasia)
				.append(tipo).append(rua).append(numero).append(cidade).append(estado).append(cep).append(complemento)
				.append(observacao).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("codigoHospital", codigoHospital).append("cnpj", cnpj)
				.append("razaoSocial", razaoSocial).append("nomeFantasia", nomeFantasia).append("tipo", tipo)
				.append("rua", rua).append("numero", numero).append("cidade", cidade).append("estado", estado)
				.append("cep", cep).append("complemento", complemento).append("observacao", observacao).toString();
	}
}
