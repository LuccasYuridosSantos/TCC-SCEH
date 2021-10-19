package br.com.tcc.sceh.model;

import java.time.LocalDate;

import javax.persistence.Id;

public class SolicitacaoRecurso {
	
	@Id
	private String codigoSolicitacao;
	private String solicitante;
	private String nome;
	private int quantidade;
	private LocalDate dataProgramada;
	private boolean urgente;
	private String observacao;
	
	public SolicitacaoRecurso() {
		
	}

	public SolicitacaoRecurso(String codigoSolicitacao, String solicitante, String nome, int quantidade,
			LocalDate dataProgramada, boolean urgente, String observacao) {
		super();
		this.codigoSolicitacao = codigoSolicitacao;
		this.solicitante = solicitante;
		this.nome = nome;
		this.quantidade = quantidade;
		this.dataProgramada = dataProgramada;
		this.urgente = urgente;
		this.observacao = observacao;
	}

	public String getCodigoSolicitacao() {
		return codigoSolicitacao;
	}

	public void setCodigoSolicitacao(String codigoSolicitacao) {
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
}
