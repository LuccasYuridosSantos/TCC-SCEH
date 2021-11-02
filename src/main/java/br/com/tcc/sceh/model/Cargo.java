package br.com.tcc.sceh.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Cargo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoCargo;
	private String nomeCargo;
	private String descricao;
	
	public Cargo() {
	}

	public Cargo(final Long codigoCargo, final String nomeCargo, final String descricao) {
		this.codigoCargo = codigoCargo;
		this.nomeCargo = nomeCargo;
		this.descricao = descricao;
	}

	public Long getCodigoCargo() {
		return codigoCargo;
	}

	public void setCodigoCargo(final Long codigoCargo) {
		this.codigoCargo = codigoCargo;
	}

	public String getNomeCargo() {
		return nomeCargo;
	}

	public void setNomeCargo(final String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}
}
