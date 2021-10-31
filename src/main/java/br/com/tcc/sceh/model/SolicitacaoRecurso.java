package br.com.tcc.sceh.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SolicitacaoRecurso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoSolicitacao;
	private String solicitante;
	private String nome;
	private int quantidade;
	private LocalDate dataProgramada;
	private boolean urgente;
	private String observacao;

	@ManyToOne
	private Hospital hospital;

	public SolicitacaoRecurso() {
	}

	public SolicitacaoRecurso(Long codigoSolicitacao, String solicitante, String nome, int quantidade,
							  LocalDate dataProgramada, boolean urgente, String observacao) {
		this.codigoSolicitacao = codigoSolicitacao;
		this.solicitante = solicitante;
		this.nome = nome;
		this.quantidade = quantidade;
		this.dataProgramada = dataProgramada;
		this.urgente = urgente;
		this.observacao = observacao;
	}

	public Long getCodigoSolicitacao() {
		return codigoSolicitacao;
	}

	public void setCodigoSolicitacao(Long codigoSolicitacao) {
		this.codigoSolicitacao = codigoSolicitacao;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public LocalDate getDataProgramada() {
		return dataProgramada;
	}

	public void setDataProgramada(LocalDate dataProgramada) {
		this.dataProgramada = dataProgramada;
	}

	public boolean isUrgente() {
		return urgente;
	}

	public void setUrgente(boolean urgente) {
		this.urgente = urgente;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		SolicitacaoRecurso that = (SolicitacaoRecurso) o;

		return new EqualsBuilder().append(quantidade, that.quantidade).append(urgente,
				that.urgente).append(codigoSolicitacao, that.codigoSolicitacao).append(solicitante,
				that.solicitante).append(nome, that.nome).append(dataProgramada, that.dataProgramada).append(observacao,
				that.observacao).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(codigoSolicitacao).append(solicitante)
				.append(nome).append(quantidade).append(dataProgramada).append(urgente).append(observacao).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("codigoSolicitacao", codigoSolicitacao)
				.append("solicitante", solicitante)
				.append("nome", nome)
				.append("quantidade", quantidade)
				.append("dataProgramada", dataProgramada)
				.append("urgente", urgente)
				.append("observacao", observacao)
				.toString();
	}
}
