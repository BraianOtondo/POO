package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class SistemaRestaurante {
	private List<Cliente> lstClientes;
	private List<Mesa> lstMesas;
	private List<Reserva> lstReservas;
	public SistemaRestaurante() {
		super();
		this.lstClientes = new ArrayList<Cliente>();
		this.lstMesas = new ArrayList<Mesa>();
		this.lstReservas = new ArrayList<Reserva>();
	}
	public List<Cliente> getLstClientes() {
		return lstClientes;
	}
	public void setLstClientes(List<Cliente> lstClientes) {
		this.lstClientes = lstClientes;
	}
	public List<Mesa> getLstMesas() {
		return lstMesas;
	}
	public void setLstMesas(List<Mesa> lstMesas) {
		this.lstMesas = lstMesas;
	}
	public List<Reserva> getLstReservas() {
		return lstReservas;
	}
	public void setLstReservas(List<Reserva> lstReservas) {
		this.lstReservas = lstReservas;
	}
	@Override
	public String toString() {
		return "SistemaRestaurante [lstClientes=" + lstClientes + ", lstMesas=" + lstMesas + ", lstReservas="
				+ lstReservas + "]";
	}
	public Cliente traerCliente(long dni){
		Cliente encontrado=null;
		int i=0;
		while(i<this.lstClientes.size() && encontrado==null) {
			if(dni==this.lstClientes.get(i).getDni()) {
				encontrado=this.lstClientes.get(i);
			}
			i++;
		}
		return encontrado;
	}
	private int traerUltimoIdCliente() {
		int id=0;
		if(this.lstClientes.size()!=0) {
			id=this.lstClientes.get(this.lstClientes.size()-1).getIdCliente();
		}
		return id;
	}
	public boolean agregarCliente(String nombre,String apellido,long dni,String telefono)throws Exception{
		Cliente objeto=this.traerCliente(dni);
		if(objeto!=null) {
			throw new Exception(" El cliente con Dni: "+dni+" ya existe");
		}
		objeto= new Cliente(this.traerUltimoIdCliente()+1, nombre, apellido, dni, telefono);
		return this.lstClientes.add(objeto);
	}
	private int traerUltimoNroMesa() {
		int nro=0;
		if(this.lstMesas.size()!=0) {
			nro=this.lstMesas.get(this.lstMesas.size()-1).getNumeroMesa();
		}
		return nro;
	}
	public Mesa traerMesa(int numeroMesa) {
		Mesa encontrado=null;
		int i=0;
		while(i<this.lstMesas.size() && encontrado==null) {
			if(numeroMesa==this.lstMesas.get(i).getNumeroMesa()) {
				encontrado=this.lstMesas.get(i);
			}
			i++;
		}
		return encontrado;
	}
	public boolean agregarMesa(int numeroMesa, int capacidad)throws Exception {
		Mesa objeto=this.traerMesa(numeroMesa);
		if(objeto!=null) {
			throw new Exception("la mesa: "+numeroMesa+" ya existe");
		}
		objeto= new Mesa(this.traerUltimoNroMesa()+1, numeroMesa, capacidad);
		return this.lstMesas.add(objeto);
	}
	public Reserva traerReserva(int numeroMesa,LocalDate fechaReserva) {
		Reserva encontrado=null;
		int i=0;
		while(i<this.lstReservas.size() && encontrado==null) {
			if(this.lstReservas.get(i).getMesa().getNumeroMesa()==numeroMesa && this.lstReservas.get(i).getFechaReserva().isEqual(fechaReserva)) {
				encontrado=this.lstReservas.get(i);
			}
			i++;
		}
		return encontrado;
	}
	private int traerUltimoIdReserva() {
		int id=0;
		if(this.lstReservas.size()!=0) {
			id=this.lstReservas.get(this.lstReservas.size()-1).getIdReserva();
		}
		return id;
	}
	public boolean agregarReserva(Cliente cliente, LocalDate fechaReserva, Mesa mesa, int cantComensales) throws Exception{
		Reserva objeto=this.traerReserva(mesa.getNumeroMesa(), fechaReserva);
		if(objeto!=null) {
			throw new Exception("la mesa ya esta reservada");
		}
		objeto=new Reserva(this.traerUltimoIdReserva()+1, cliente, fechaReserva, mesa, cantComensales);
		
		return this.lstReservas.add(objeto);// arreglado
		
	}
	public List<Reserva> traerReservasPorFecha(LocalDate fechaDesde,LocalDate fechaHasta){
		List<Reserva> lista=new ArrayList<Reserva>();
		for(int i=0;i<this.lstReservas.size();i++) {
			LocalDate fecha=this.lstReservas.get(i).getFechaReserva();
			if(validarFecha(fecha, fechaDesde, fechaHasta)) {
				lista.add(this.lstReservas.get(i));
			}
		}
		return lista;
	}
	public boolean validarFecha(LocalDate fecha,LocalDate fechaInicio,LocalDate fechaFin) {
		return (fecha.isEqual(fechaInicio) || fecha.isEqual(fechaFin) ||
	            (fecha.isAfter(fechaInicio) && fecha.isBefore(fechaFin)));
	}
}
