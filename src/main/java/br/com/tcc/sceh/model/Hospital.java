package br.com.tcc.sceh.model;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Hospital {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long codigoHospital;
	private String cnpj;
	private String razaoSocial;
	private String nomeFantasia;
	private String tipo;

	@ManyToOne
	private Telefone telefone;

	@ManyToOne
	private Endereco endereco;

	public Hospital() {
	}

	public Hospital(Long codigoHospital, String cnpj, String razaoSocial, String nomeFantasia, String tipo,
					Telefone telefone, Endereco endereco) {
		this.codigoHospital = codigoHospital;
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.tipo = tipo;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public Long getCodigoHospital() {
		return codigoHospital;
	}

	public void setCodigoHospital(Long codigoHospital) {
		this.codigoHospital = codigoHospital;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		Hospital hospital = (Hospital) o;

		return new EqualsBuilder().append(codigoHospital, hospital.codigoHospital).append(cnpj, hospital.cnpj)
				.append(razaoSocial, hospital.razaoSocial).append(nomeFantasia, hospital.nomeFantasia)
				.append(tipo, hospital.tipo).append(telefone, hospital.telefone).append(endereco, hospital.endereco)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(codigoHospital).append(cnpj)
				.append(razaoSocial).append(nomeFantasia).append(tipo).append(telefone).append(endereco).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("codigoHospital", codigoHospital)
				.append("cnpj", cnpj)
				.append("razaoSocial", razaoSocial)
				.append("nomeFantasia", nomeFantasia)
				.append("tipo", tipo)
				.append("telefone", telefone)
				.append("endereco", endereco)
				.toString();
	}
}
