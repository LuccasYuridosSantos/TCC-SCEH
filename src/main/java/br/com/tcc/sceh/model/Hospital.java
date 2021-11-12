package br.com.tcc.sceh.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Hospital {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long codigoHospital;
	private String cnpj;
	private String razaoSocial;
	private String nomeFantasia;
	private String tipo;

	public Hospital() {
	}

	public Hospital(final Long codigoHospital, final String cnpj, final String razaoSocial,
			final String nomeFantasia, final String tipo) {
		this.codigoHospital = codigoHospital;
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.tipo = tipo;
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

	@Override public String toString() {
		return new ToStringBuilder(this).append("codigoHospital", codigoHospital).append("cnpj", cnpj).append("razaoSocial", razaoSocial).append("nomeFantasia", nomeFantasia).append("tipo", tipo).toString();
	}
}
