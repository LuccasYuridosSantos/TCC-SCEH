package br.com.tcc.sceh.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cargo {
	
	@Id
	private String codigoCargo;
	private String nomeCargo;
	
	public Cargo() {
	}

	public Cargo(String codigoCargo, String nomeCargo) {
		this.codigoCargo = codigoCargo;
		this.nomeCargo = nomeCargo;
	}

	public String getCodigoCargo() {
		return codigoCargo;
	}

	public void setCodigoCargo(String codigoCargo) {
		this.codigoCargo = codigoCargo;
	}

	public String getNomeCargo() {
		return nomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}
	
	
}
