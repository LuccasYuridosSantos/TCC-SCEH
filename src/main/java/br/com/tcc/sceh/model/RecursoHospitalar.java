package br.com.tcc.sceh.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RecursoHospitalar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoRecurso;
	private int quantidade;
	private String nome;
	private String marca;
	private String fabricante;
	private String descricao;
	private LocalDate dataFabricacao;
	private LocalDate dataValidade;
	private String lote;
	
	public RecursoHospitalar() {
		
	}

	public RecursoHospitalar(Long codigoRecurso, int quantidade, String nome, String marca, String fabricante,
							 String descricao, LocalDate dataFabricacao, LocalDate dataValidade, String lote) {
		this.codigoRecurso = codigoRecurso;
		this.quantidade = quantidade;
		this.nome = nome;
		this.marca = marca;
		this.fabricante = fabricante;
		this.descricao = descricao;
		this.dataFabricacao = dataFabricacao;
		this.dataValidade = dataValidade;
		this.lote = lote;
	}

	public Long getCodigoRecurso() {
		return codigoRecurso;
	}

	public void setCodigoRecurso(Long codigoRecurso) {
		this.codigoRecurso = codigoRecurso;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(LocalDate dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		RecursoHospitalar that = (RecursoHospitalar) o;

		return new EqualsBuilder().append(quantidade, that.quantidade).append(codigoRecurso,
				that.codigoRecurso).append(nome, that.nome).append(marca, that.marca).append(fabricante,
				that.fabricante).append(descricao, that.descricao).append(dataFabricacao,
				that.dataFabricacao).append(dataValidade, that.dataValidade).append(lote, that.lote).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(codigoRecurso).append(quantidade)
				.append(nome).append(marca).append(fabricante).append(descricao).append(dataFabricacao)
				.append(dataValidade).append(lote).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("codigoRecurso", codigoRecurso)
				.append("quantidade", quantidade)
				.append("nome", nome)
				.append("marca", marca)
				.append("fabricante", fabricante)
				.append("descricao", descricao)
				.append("dataFabricacao", dataFabricacao)
				.append("dataValidade", dataValidade)
				.append("lote", lote)
				.toString();
	}
}
