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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoReserva;
	private int quantidade;
	private LocalDate dataReserva;
	private LocalDate dataRetirada;
	private String solicitante;
	private String entregador;

	@ManyToOne(cascade = CascadeType.ALL)
	private Hospital hospital;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "reserva_recurso",
			joinColumns = @JoinColumn(name = "codigo_reserva"),
			inverseJoinColumns = @JoinColumn(name = "codigo_recurso"))
	@JsonIgnoreProperties("reservas")
	private List<RecursoHospitalar> recursoHospitalars;

	public Reserva() {
	}

	public Reserva(final Long codigoReserva, final int quantidade, final LocalDate dataReserva, final LocalDate dataRetirada, final String solicitante, final String entregador,
			final List<RecursoHospitalar> recursoHospitalars) {
		this.codigoReserva = codigoReserva;
		this.quantidade = quantidade;
		this.dataReserva = dataReserva;
		this.dataRetirada = dataRetirada;
		this.solicitante = solicitante;
		this.entregador = entregador;
		this.recursoHospitalars = recursoHospitalars;
	}

	public Long getCodigoReserva() {
		return codigoReserva;
	}

	public void setCodigoReserva(final Long codigoReserva) {
		this.codigoReserva = codigoReserva;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(final int quantidade) {
		this.quantidade = quantidade;
	}

	public LocalDate getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(final LocalDate dataReserva) {
		this.dataReserva = dataReserva;
	}

	public LocalDate getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(final LocalDate dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(final String solicitante) {
		this.solicitante = solicitante;
	}

	public String getEntregador() {
		return entregador;
	}

	public void setEntregador(final String entregador) {
		this.entregador = entregador;
	}

	public List<RecursoHospitalar> getRecursoHospitalars() {
		return recursoHospitalars;
	}

	public void setRecursoHospitalars(final List<RecursoHospitalar> recursoHospitalars) {
		this.recursoHospitalars = recursoHospitalars;
	}
}
