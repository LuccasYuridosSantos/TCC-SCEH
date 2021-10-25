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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

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

	@OneToMany(cascade = CascadeType.ALL)
	private List<Telefone> telefones;

	@OneToOne
	private Endereco endereco;

	public Hospital() {
	}

	public Hospital(Long codigoHospital, String cnpj, String razaoSocial, String nomeFantasia, String tipo, List<Telefone> telefones, Endereco endereco) {
		this.codigoHospital = codigoHospital;
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.tipo = tipo;
		this.telefones = telefones;
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

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
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

		return new EqualsBuilder().append(codigoHospital, hospital.codigoHospital).append(cnpj,
				hospital.cnpj).append(razaoSocial, hospital.razaoSocial).append(nomeFantasia,
				hospital.nomeFantasia).append(tipo, hospital.tipo).append(telefones,
				hospital.telefones).append(endereco, hospital.endereco).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(codigoHospital).append(cnpj)
				.append(razaoSocial).append(nomeFantasia).append(tipo).append(telefones).append(endereco).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("codigoHospital", codigoHospital)
				.append("cnpj", cnpj)
				.append("razaoSocial", razaoSocial)
				.append("nomeFantasia", nomeFantasia)
				.append("tipo", tipo)
				.append("telefones", telefones)
				.append("endereco", endereco)
				.toString();
	}
}
