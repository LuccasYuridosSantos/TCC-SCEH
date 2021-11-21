package br.com.tcc.sceh.model.entity;

import br.com.tcc.sceh.model.entity.Funcionario;
import br.com.tcc.sceh.model.entity.Hospital;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
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
	private Boolean solicitacao;
	private LocalDate dataProgramada;
	private Boolean urgencia;
	private String observacao;
	private Boolean ativo;

	@ManyToOne
	private Funcionario funcionario;

	@ManyToOne(cascade = CascadeType.ALL)
	private Hospital hospital;

	public RecursoHospitalar() {
	}

	public RecursoHospitalar(final Long codigoRecurso, final int quantidade, final String nome, final String marca,
			final String fabricante, final String descricao, final LocalDate dataFabricacao,
			final LocalDate dataValidade, final String lote, final Boolean solicitacao, final LocalDate dataProgramada,
			final Boolean urgencia, final String observacao, final Funcionario funcionario, final Hospital hospital,
			final Boolean ativo) {
		this.codigoRecurso = codigoRecurso;
		this.quantidade = quantidade;
		this.nome = nome;
		this.marca = marca;
		this.fabricante = fabricante;
		this.descricao = descricao;
		this.dataFabricacao = dataFabricacao;
		this.dataValidade = dataValidade;
		this.lote = lote;
		this.solicitacao = solicitacao;
		this.dataProgramada = dataProgramada;
		this.urgencia = urgencia;
		this.observacao = observacao;
		this.funcionario = funcionario;
		this.hospital = hospital;
		this.ativo = ativo;
	}

	public Long getCodigoRecurso() {
		return codigoRecurso;
	}

	public void setCodigoRecurso(final Long codigoRecurso) {
		this.codigoRecurso = codigoRecurso;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(final int quantidade) {
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(final String marca) {
		this.marca = marca;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(final String fabricante) {
		this.fabricante = fabricante;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(final LocalDate dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(final LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(final String lote) {
		this.lote = lote;
	}

	public Boolean getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(final Boolean solicitacao) {
		this.solicitacao = solicitacao;
	}

	public LocalDate getDataProgramada() {
		return dataProgramada;
	}

	public void setDataProgramada(final LocalDate dataProgramada) {
		this.dataProgramada = dataProgramada;
	}

	public Boolean getUrgencia() {
		return urgencia;
	}

	public void setUrgencia(final Boolean urgencia) {
		this.urgencia = urgencia;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(final String observacao) {
		this.observacao = observacao;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(final Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(final Hospital hospital) {
		this.hospital = hospital;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(final Boolean ativo) {
		this.ativo = ativo;
	}
}
