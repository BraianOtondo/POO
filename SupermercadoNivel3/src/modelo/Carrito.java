package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
	private int idCarrito;
	private LocalDate fecha;
	private LocalTime hora;
	private List<ItemCarrito> lstItem;
	private Cliente cliente;
	public Carrito(int idCarrito, LocalDate fecha, LocalTime hora, Cliente cliente) {
		super();
		this.idCarrito = idCarrito;
		this.fecha = fecha;
		this.hora = hora;
		this.lstItem=new ArrayList<ItemCarrito>();
		this.cliente = cliente;
	}
	public int getIdCarrito() {
		return idCarrito;
	}
	public void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	public List<ItemCarrito> getLstItem() {
		return lstItem;
	}
	public void setLstItem(List<ItemCarrito> lstItem) {
		this.lstItem = lstItem;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public boolean equals(Carrito carrito) {

		return idCarrito == carrito.getIdCarrito();
	}
	@Override
	public String toString() {
		return "Carrito [idCarrito=" + idCarrito + ", fecha=" + fecha + ", hora=" + hora + ", lstItem=" + lstItem
				+ ", cliente=" + cliente + "]";
	}
	
	
}
