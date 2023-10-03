package modelo;

import java.time.LocalDate;

public class Reserva {
	private int idReserva;
	private Cliente cliente;
	private LocalDate fechaReserva;
	private Mesa mesa;
	private int cantComensales;
	public Reserva(int idReserva, Cliente cliente, LocalDate fechaReserva, Mesa mesa, int cantComensales) throws Exception {
		super();
		this.idReserva = idReserva;
		this.cliente = cliente;
		this.fechaReserva = fechaReserva;
		this.mesa = mesa;
		this.setCantComensales(cantComensales);
	}
	public int getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public LocalDate getFechaReserva() {
		return fechaReserva;
	}
	public void setFechaReserva(LocalDate fechaReserva) {
		this.fechaReserva = fechaReserva;
	}
	public Mesa getMesa() {
		return mesa;
	}
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	public int getCantComensales() {
		return cantComensales;
	}
	public void setCantComensales(int cantComensales) throws Exception {
		if(this.validarComensales(cantComensales)) {
			this.cantComensales = cantComensales;

		}
	}

	public boolean equals(Reserva reserva) {

		return idReserva == reserva.getIdReserva();
	}
	@Override
	public String toString() {
		return "Reserva [idReserva=" + idReserva + ", cliente=" + cliente + ", fechaReserva=" + fechaReserva + ", mesa="
				+ mesa + ", cantComensales=" + cantComensales + "]";
	}
	public boolean validarComensales(int cantComensales)throws Exception{
		if(this.mesa.getCapacidad()<cantComensales) {
			throw new Exception("La cantidad de Comensales es mayor a la Capacidad");
		}
		return true;//true para decir que esta todo bien que si ha capacidad
	}
	
}
