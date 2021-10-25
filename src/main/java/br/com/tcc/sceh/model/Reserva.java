package br.com.tcc.sceh.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

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
	
	public Reserva() {
		
	}

	public Reserva(Long codigoReserva, int quantidade, LocalDate dataReserva, LocalDate dataRetirada,
				   String solicitante, String entregador) {
		this.codigoReserva = codigoReserva;
		this.quantidade = quantidade;
		this.dataReserva = dataReserva;
		this.dataRetirada = dataRetirada;
		this.solicitante = solicitante;
		this.entregador = entregador;
	}

	public Long getCodigoReserva() {
		return codigoReserva;
	}

	public void setCodigoReserva(Long codigoReserva) {
		this.codigoReserva = codigoReserva;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public LocalDate getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(LocalDate dataReserva) {
		this.dataReserva = dataReserva;
	}

	public LocalDate getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(LocalDate dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public String getEntregador() {
		return entregador;
	}

	public void setEntregador(String entregador) {
		this.entregador = entregador;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		Reserva reserva = (Reserva) o;

		return new EqualsBuilder().append(quantidade, reserva.quantidade).append(codigoReserva,
				reserva.codigoReserva).append(dataReserva, reserva.dataReserva).append(dataRetirada,
				reserva.dataRetirada).append(solicitante, reserva.solicitante).append(entregador,
				reserva.entregador).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(codigoReserva).append(quantidade)
				.append(dataReserva).append(dataRetirada).append(solicitante).append(entregador).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("codigoReserva", codigoReserva)
				.append("quantidade", quantidade)
				.append("dataReserva", dataReserva)
				.append("dataRetirada", dataRetirada)
				.append("solicitante", solicitante)
				.append("entregador", entregador)
				.toString();
	}
}
