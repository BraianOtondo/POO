package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Llamada {
	private int idLlamada;
	private LocalDate fecha;
	private LocalTime hora;
	private Cliente cliente;
	private Empleado empleado;
	private int nivelDeSatisfaccion;
	public Llamada(int idLlamada, LocalDate fecha, LocalTime hora, Cliente cliente, Empleado empleado,
			int nivelDeSatisfaccion) throws Exception {
		super();
		this.idLlamada = idLlamada;
		this.fecha = fecha;
		this.hora = hora;
		this.cliente = cliente;
		this.empleado = empleado;
		this.setNivelDeSatisfaccion(nivelDeSatisfaccion);
	}
	public int getIdLlamada() {
		return idLlamada;
	}
	public void setIdLlamada(int idLlamada) {
		this.idLlamada = idLlamada;
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
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public int getNivelDeSatisfaccion() {
		return nivelDeSatisfaccion;
	}
	public void setNivelDeSatisfaccion(int nivelDeSatisfaccion) throws Exception {
		if(this.esNivelDeSatisfaccionValido(nivelDeSatisfaccion)==false) {
			throw new Exception("El nivel no es el correcto");
		}
		this.nivelDeSatisfaccion = nivelDeSatisfaccion;
	}
	

	public boolean equals(Llamada llamada) {
	
		return idLlamada == llamada.getIdLlamada();
	}
	@Override
	public String toString() {
		return "Llamada [idLlamada=" + idLlamada + ", fecha=" + fecha + ", hora=" + hora + ", cliente=" + cliente
				+ ", empleado=" + empleado + ", nivelDeSatisfaccion=" + nivelDeSatisfaccion + "]";
	}
	// el parametro sera correcto si es mayor a 0 y menor que 6
	public boolean esNivelDeSatisfaccionValido(int nivelDeSatisfaccion) {
		boolean valido=false;
		if(0<nivelDeSatisfaccion && nivelDeSatisfaccion<6) {
			valido=true;
		}
		return valido;
	}
	
}
