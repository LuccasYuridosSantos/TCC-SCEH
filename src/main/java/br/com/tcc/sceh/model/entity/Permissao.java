package br.com.tcc.sceh.model.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Permissao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoPermissao;
	private String nome;
	private String descricao;

	public Permissao() {
	}

	public Permissao(final Long codigoPermissao, final String nome, final String descricao) {
		this.codigoPermissao = codigoPermissao;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Long getCodigoPermissao() {
		return codigoPermissao;
	}

	public void setCodigoPermissao(final Long codigo_permissao) {
		this.codigoPermissao = codigo_permissao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		final Permissao permissao = (Permissao) o;

		return new EqualsBuilder().append(codigoPermissao, permissao.codigoPermissao).append(nome, permissao.nome)
				.append(descricao, permissao.descricao).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(codigoPermissao).append(nome).append(descricao).toHashCode();
	}

	@Override public String toString() {
		return new ToStringBuilder(this).append("codigo_permissao", codigoPermissao).append("nome", nome)
				.append("descricao", descricao).toString();
	}
}
