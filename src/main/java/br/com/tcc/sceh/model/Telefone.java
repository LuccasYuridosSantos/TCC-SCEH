package br.com.tcc.sceh.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Telefone {
	
	@Id
	private String codigoTelefone;
	private String ddd;
	private String numero;
	
	public Telefone() {
	}

	public Telefone(String codigoTelefone, String ddd, String numero) {
		this.codigoTelefone = codigoTelefone;
		this.ddd = ddd;
		this.numero = numero;
	}

	public String getCodigoTelefone() {
		return codigoTelefone;
	}

	public void setCodigoTelefone(String codigoTelefone) {
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
	
	
}
