package br.com.tcc.sceh.model.requests;

public class SolicitacaoRequest {
	private Long codigoRecurso;
	private int quantidade;
	private String nome;
	private String marca;
	private String fabricante;
	private String descricao;
	private Boolean urgencia;
	private String observacao;
	private Boolean ativo;
	private Long codigoHospital;
	private Long codigoFuncionario;

	public SolicitacaoRequest(final Long codigoRecurso, final int quantidade, final String nome, final String marca,
			final String fabricante, final String descricao, final Boolean urgencia, final String observacao,
			final Boolean ativo, final Long codigoHospital, final long codigoFuncionario) {
		this.codigoRecurso = codigoRecurso;
		this.quantidade = quantidade;
		this.nome = nome;
		this.marca = marca;
		this.fabricante = fabricante;
		this.descricao = descricao;
		this.urgencia = urgencia;
		this.observacao = observacao;
		this.ativo = ativo;
		this.codigoHospital = codigoHospital;
		this.codigoFuncionario = codigoFuncionario;
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

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(final Boolean ativo) {
		this.ativo = ativo;
	}

	public Long getCodigoHospital() {
		return codigoHospital;
	}

	public void setCodigoHospital(final Long codigoHospital) {
		this.codigoHospital = codigoHospital;
	}

	public Long getCodigoFuncionario() {
		return codigoFuncionario;
	}

	public void setCodigoFuncionario(final Long codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}
}
