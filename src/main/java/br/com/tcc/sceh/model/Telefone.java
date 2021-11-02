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
	private Funcionario funcionario;

	@ManyToOne
	private Hospital hospital;


	public Telefone() {
	}

	public Telefone(final Long codigoTelefone, final String ddd, final String numero,
			final Funcionario funcionario, final Hospital hospital) {
		this.codigoTelefone = codigoTelefone;
		this.ddd = ddd;
		this.numero = numero;
		this.funcionario = funcionario;
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
