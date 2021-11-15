package br.com.tcc.sceh.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Telefone {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long codigoTelefone;
	private String ddd;
	private String numero;

	@ManyToOne
	private Hospital hospital;


	public Telefone() {
	}

	public Telefone(final Long codigoTelefone, final String ddd, final String numero, final Hospital hospital) {
		this.codigoTelefone = codigoTelefone;
		this.ddd = ddd;
		this.numero = numero;
		this.hospital = hospital;
	}

	public Long getCodigoTelefone() {
		return codigoTelefone;
	}

	public void setCodigoTelefone(final Long codigoTelefone) {
		this.codigoTelefone = codigoTelefone;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(final String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(final String numero) {
		this.numero = numero;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(final Hospital hospital) {
		this.hospital = hospital;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		final Telefone telefone = (Telefone) o;

		return new EqualsBuilder().append(codigoTelefone, telefone.codigoTelefone).append(ddd, telefone.ddd)
				.append(numero, telefone.numero).append(hospital, telefone.hospital).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(codigoTelefone).append(ddd)
				.append(numero).append(hospital).toHashCode();
	}
}
