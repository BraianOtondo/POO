package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Pasajero> pasajeros;
	private List<Venta> ventas;
	public Sistema() {
		super();
		this.pasajeros = new ArrayList<Pasajero>();
		this.ventas = new ArrayList<Venta>();
	}
	public List<Pasajero> getPasajeros() {
		return pasajeros;
	}
	public void setPasajeros(List<Pasajero> pasajeros) {
		this.pasajeros = pasajeros;
	}
	public List<Venta> getVentas() {
		return ventas;
	}
	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}
	@Override
	public String toString() {
		return "Sistema [pasajeros=" + pasajeros + ", ventas=" + ventas + "]";
	}
	//+ agregarPasajero(long dni, String apellido, String nombre) : boolean
	public Pasajero traerPasajero(long dni) {
		Pasajero encontrado=null;
		int i=0;
		while(i<this.pasajeros.size() && encontrado==null ) {
			if(this.pasajeros.get(i).getDni()==dni) {
				encontrado=this.pasajeros.get(i);
			}
			i++;
		}
		return encontrado;
	}
	private int traerUltimoIdPasajeros() {
		int id=0;
		if(this.pasajeros.size()!=0) {
			id=this.pasajeros.get(this.pasajeros.size()-1).getIdPasajero();
		}
		return id;
	}
	public boolean agregarPasajero(long dni, String apellido, String nombre) throws Exception {
		Pasajero objeto=this.traerPasajero(dni);
		if(objeto!=null) {
			throw new Exception("El pasajero ya existe");
		}
		objeto=new Pasajero(this.traerUltimoIdPasajeros()+1, apellido, nombre,(int) dni);
		return this.pasajeros.add(objeto);
	}
	/* public Estadia traerEstadia(int idVenta) {
		Estadia encontrado=null;
		int i=0;
		while(i<this.ventas.size() && encontrado==null) {
			Venta venta=this.ventas.get(i);
			if(venta instanceof Estadia && venta.getIdVenta()==idVenta) {
				encontrado=(Estadia)this.ventas.get(i);
			}
			i++;
		}
		return encontrado;
	} */
	//GENERAL
	//suponiendo que solo puede comprar 1 vez por dia un pasajero no dos veces 
	/*public Venta traerVenta(LocalDate fechaVenta, Pasajero pasajero) {
		Venta encontrado=null;
		int i=0;
		while(i<this.ventas.size() && encontrado==null) {
			if((fechaVenta.isEqual(this.ventas.get(i).getFecha() ) && pasajero.equals(this.ventas.get(i).getPasajero() ))) {
				encontrado=this.ventas.get(i);
			}
			i++;
		}
		return encontrado;
	}*/
	private int traerUltimoIdVenta() {
		int id=0;
		if(this.ventas.size()!=0) {
			id=this.ventas.get(this.ventas.size()-1).getIdVenta();
		}
		return id;
	}
	//sacamos throws a ambos
	public boolean agregarEstadia(LocalDate fechaVenta, Pasajero pasajero, LocalDate checkIn, int cantNoches, int cantPlazas) throws Exception {
			

			Estadia estadia= new Estadia(this.traerUltimoIdVenta()+1, pasajero, fechaVenta, checkIn, cantNoches, cantPlazas);
		return this.ventas.add(estadia);
	}
	//Solo se puede rentar 1 Spa por dia
	public boolean agregarSpa(LocalDate fechaVenta, Pasajero pasajero, LocalDate fecha, LocalTime hora, int minutos) {
		Spa objeto= new Spa(this.traerUltimoIdVenta()+1, pasajero, fechaVenta, fecha, hora, minutos);
		return this.ventas.add(objeto);
	}
	public Venta traerVenta(int idVenta) {
		Venta encontrado=null;
		int i=0;
		while(i<this.ventas.size() && encontrado==null) {
			if(this.ventas.get(i).getIdVenta()==idVenta) {
				encontrado=this.ventas.get(i);
			}
			i++;
		}
		return encontrado;
	}
	public boolean validarHora(LocalTime hora,LocalTime horaDesde,LocalTime horaHasta) {
		return ((!hora.isBefore(horaDesde) && !hora.isAfter(horaHasta) || hora.equals(horaDesde) || hora.equals(horaHasta)));
	}
	// trae todos los objetos Spa que se
	//encuentran activas (se encuentran en el Spa) para ese día y la hora se encuentra entre hora
	//entrada y salida al spa inclusive
	public List<Spa> traerSpas(LocalDate dia, LocalTime hora){
		List<Spa> lista=new ArrayList<Spa>();
		for(int i=0;i<this.ventas.size();i++) {
			Venta venta=this.ventas.get(i);
			if(venta instanceof Spa) {
				Spa spa=(Spa) venta;
				LocalTime horaSalida=spa.salidaSpa();
				if(spa.getFecha().isEqual(dia) && this.validarHora(hora,spa.getHora(),horaSalida)) {
					lista.add(spa);
				}
			}
		}
		return lista;
	} 
	
}
