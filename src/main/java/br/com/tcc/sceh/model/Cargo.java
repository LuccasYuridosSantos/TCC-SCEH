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

	public Cargo(Long codigoCargo, String nomeCargo, String descricao) {
		this.codigoCargo = codigoCargo;
		this.nomeCargo = nomeCargo;
		this.descricao = descricao;
	}

	public Long getCodigoCargo() {
		return codigoCargo;
	}

	public void setCodigoCargo(Long codigoCargo) {
		this.codigoCargo = codigoCargo;
	}

	public String getNomeCargo() {
		return nomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Cargo cargo = (Cargo) o;
		return Objects.equals(codigoCargo, cargo.codigoCargo) && Objects.equals(nomeCargo, cargo.nomeCargo) && Objects.equals(descricao, cargo.descricao);
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoCargo, nomeCargo, descricao);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("codigoCargo", codigoCargo)
				.append("nomeCargo", nomeCargo)
				.append("descricao", descricao)
				.toString();
	}
}
