package br.com.tcc.sceh.model;

import java.time.LocalDate;

public class Reserva {

	private String codigoReserva;
	private int quantidade;
	private LocalDate dataReserva;
	private LocalDate dataRetirada;
	private String solicitante;
	private String entregador;
	
	public Reserva() {
		
	}

	public Reserva(String codigoReserva, int quantidade, LocalDate dataReserva, LocalDate dataRetirada,
			String solicitante, String entregador) {
		super();
		this.codigoReserva = codigoReserva;
		this.quantidade = quantidade;
		this.dataReserva = dataReserva;
		this.dataRetirada = dataRetirada;
		this.solicitante = solicitante;
		this.entregador = entregador;
	}

	public String getCodigoReserva() {
		return codigoReserva;
	}

	public void setCodigoReserva(String codigoReserva) {
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
	
}
