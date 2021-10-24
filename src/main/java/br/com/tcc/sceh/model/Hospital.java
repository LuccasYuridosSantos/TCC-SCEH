package br.com.tcc.sceh.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hospital {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long codigoHospital;
	private String cnpj;
	private String razaoSocial;
	private String nomeFantasia;
	private String tipo;

	public Hospital() {

	}

	public Hospital(Long codigoHospital, String cnpj, String razaoSocial, String nomeFantasia, String tipo) {
		this.codigoHospital = codigoHospital;
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.tipo = tipo;
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

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Hospital{");
		sb.append("codigoHospital=").append(codigoHospital);
		sb.append(", cnpj='").append(cnpj).append('\'');
		sb.append(", razaoSocial='").append(razaoSocial).append('\'');
		sb.append(", nomeFantasia='").append(nomeFantasia).append('\'');
		sb.append(", tipo='").append(tipo).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
