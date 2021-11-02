package br.com.tcc.sceh.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.List;

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

	@ManyToOne(cascade = CascadeType.ALL)
	private Hospital hospital;

	@ManyToMany(mappedBy = "recursoHospitalars",cascade = CascadeType.ALL)
	@JsonIgnoreProperties("recursoHospitalars")
	private List<Reserva> reservas;

	public RecursoHospitalar() {
	}

	public RecursoHospitalar(final Long codigoRecurso, final int quantidade, final String nome, final String marca, final String fabricante, final String descricao, final LocalDate dataFabricacao,
			final LocalDate dataValidade, final String lote, final Hospital hospital, final List<Reserva> reservas) {
		this.codigoRecurso = codigoRecurso;
		this.quantidade = quantidade;
		this.nome = nome;
		this.marca = marca;
		this.fabricante = fabricante;
		this.descricao = descricao;
		this.dataFabricacao = dataFabricacao;
		this.dataValidade = dataValidade;
		this.lote = lote;
		this.hospital = hospital;
		this.reservas = reservas;
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

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(final Hospital hospital) {
		this.hospital = hospital;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(final List<Reserva> reservas) {
		this.reservas = reservas;
	}
}
