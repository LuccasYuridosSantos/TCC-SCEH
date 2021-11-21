package br.com.tcc.sceh.model.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoReserva;
	private int quantidade;
	private LocalDate dataReserva;
	private LocalDate dataRetirada;
	private String localEntrega;
	private String entregador;
	private String solicitante;
	private LocalDate dataEntrega;
	@ManyToOne
	private Hospital hospital;

	@ManyToOne
	private RecursoHospitalar recursoHospitalar;

	public Reserva() {
	}

	public Reserva(final Long codigoReserva, final int quantidade, final LocalDate dataReserva,
			final LocalDate dataRetirada, final String localEntrega, final String entregador, final String solicitante,
			final LocalDate dataEntrega, final Hospital hospital, final RecursoHospitalar recursoHospitalar) {
		this.codigoReserva = codigoReserva;
		this.quantidade = quantidade;
		this.dataReserva = dataReserva;
		this.dataRetirada = dataRetirada;
		this.localEntrega = localEntrega;
		this.entregador = entregador;
		this.solicitante = solicitante;
		this.dataEntrega = dataEntrega;
		this.hospital = hospital;
		this.recursoHospitalar = recursoHospitalar;
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

	public String getLocalEntrega() {
		return localEntrega;
	}

	public void setLocalEntrega(final String localEntrega) {
		this.localEntrega = localEntrega;
	}

	public String getEntregador() {
		return entregador;
	}

	public void setEntregador(final String entregador) {
		this.entregador = entregador;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(final String solicitante) {
		this.solicitante = solicitante;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(final LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(final Hospital hospital) {
		this.hospital = hospital;
	}

	public RecursoHospitalar getRecursoHospitalar() {
		return recursoHospitalar;
	}

	public void setRecursoHospitalar(final RecursoHospitalar recursoHospitalar) {
		this.recursoHospitalar = recursoHospitalar;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		final Reserva reserva = (Reserva) o;

		return new EqualsBuilder().append(quantidade, reserva.quantidade).append(codigoReserva, reserva.codigoReserva)
				.append(dataReserva, reserva.dataReserva).append(dataRetirada, reserva.dataRetirada)
				.append(localEntrega, reserva.localEntrega).append(entregador, reserva.entregador)
				.append(solicitante, reserva.solicitante).append(dataEntrega, reserva.dataEntrega)
				.append(hospital, reserva.hospital).append(recursoHospitalar, reserva.recursoHospitalar).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(codigoReserva).append(quantidade).append(dataReserva)
				.append(dataRetirada).append(localEntrega).append(entregador).append(solicitante).append(dataEntrega)
				.append(hospital).append(recursoHospitalar).toHashCode();
	}
}
