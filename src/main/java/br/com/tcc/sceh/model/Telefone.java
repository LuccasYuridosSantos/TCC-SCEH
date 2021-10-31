package br.com.tcc.sceh.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Telefone {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long codigoTelefone;
	private String ddd;
	private String numero;

	public Telefone() {
	}

	public Telefone(Long codigoTelefone, String ddd, String numero) {
		this.codigoTelefone = codigoTelefone;
		this.ddd = ddd;
		this.numero = numero;
	}

	public Long getCodigoTelefone() {
		return codigoTelefone;
	}

	public void setCodigoTelefone(Long codigoTelefone) {
		this.codigoTelefone = codigoTelefone;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		Telefone telefone = (Telefone) o;

		return new EqualsBuilder().append(codigoTelefone, telefone.codigoTelefone).append(ddd, telefone.ddd)
				.append(numero, telefone.numero).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(codigoTelefone).append(ddd)
				.append(numero).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("codigoTelefone", codigoTelefone)
				.append("ddd", ddd)
				.append("numero", numero)
				.toString();
	}
}
