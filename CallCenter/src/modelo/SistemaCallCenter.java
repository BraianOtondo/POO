package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class SistemaCallCenter {
	private List<Llamada> lstLlamadas;
	private List<Persona> lstPersonas;
	public SistemaCallCenter() {
		super();
		this.lstLlamadas = new ArrayList<Llamada>();
		this.lstPersonas = new ArrayList<Persona>();
		
	}
	public List<Llamada> getLstLlamadas() {
		return lstLlamadas;
	}
	public void setLstLlamadas(List<Llamada> lstLlamadas) {
		this.lstLlamadas = lstLlamadas;
	}
	public List<Persona> getLstPersonas() {
		return lstPersonas;
	}
	public void setLstPersonas(List<Persona> lstPersonas) {
		this.lstPersonas = lstPersonas;
	}
	@Override
	public String toString() {
		return "SistemaCallCenter [lstLlamadas=" + lstLlamadas + ", lstPersonas=" + lstPersonas + "]";
	}
	public  Persona traerPersona(long dni) {
		Persona encontrado=null;
		int i=0;
		while(i<this.lstPersonas.size() && encontrado==null) {
			if(this.lstPersonas.get(i).getDni()==dni) {
				encontrado=this.lstPersonas.get(i);
			}
			i++;
		}
		
		return encontrado;
	}
	private int traerUltimoIdPersona() {
		int id=0;
		if(this.lstPersonas.size()!=0) {
			id=this.lstPersonas.get(this.lstPersonas.size()-1).getIdPersona();
		}
		return id;
	}
	public boolean agregarCliente(String nombre,String apellido, long dni, LocalDate fechaDeAlta, boolean activo) throws Exception {
		Cliente objeto=(Cliente) this.traerPersona(dni);
		if(objeto!=null) {
			throw new Exception ("Este cliente ya existe");
		}
		objeto= new Cliente(this.traerUltimoIdPersona()+1, nombre, dni, fechaDeAlta, activo);
		return this.lstPersonas.add(objeto);
	}
	public boolean agregarEmpleado(String nombre, String apellido, long dni, LocalDate fechaDeAlta, int sueldoBase) throws Exception {
		Empleado objeto=(Empleado) this.traerPersona(dni);
		if(objeto!=null) {
			throw new Exception("Este Empleado ya existe");
		}
		objeto= new Empleado(this.traerUltimoIdPersona()+1, nombre, dni, fechaDeAlta, sueldoBase);
		return this.lstPersonas.add(objeto);
		
	}
	private int traerUltimoIdLlamada() {
		int id=0;
		if(this.lstLlamadas.size()!=0) {
			id=this.lstLlamadas.get(this.lstLlamadas.size()-1).getIdLlamada();
		}
		return id;
	}
	//lanzar excepcion si llamada tiene valor 
	public boolean agregarLlamada(LocalDate fecha, LocalTime hora, Cliente cliente, Empleado empleado, int nivelDeSatisfaccion) throws Exception {
		Llamada llamada= new Llamada(this.traerUltimoIdLlamada()+1, fecha, hora, cliente, empleado, nivelDeSatisfaccion);
		return this.lstLlamadas.add(llamada);
	}
	public List<Cliente> traerClientes(boolean estadoCliente){
		List<Cliente> lista= new ArrayList<Cliente>();
		for(int i=0;i<this.lstPersonas.size();i++) {
			Persona persona=this.lstPersonas.get(i);
			if(persona instanceof Cliente) {
				Cliente cliente= (Cliente) persona;
				if(estadoCliente== cliente.isActivo()) {
					lista.add(cliente);
				}
			}
		}
		return lista;
	}
public List<Persona> traerPersonasAntiguedad(int mayorIgualA){
		List<Persona> lista=new ArrayList<Persona>();
		
		for(int i=0;i<this.lstPersonas.size();i++) {
			Persona persona=this.lstPersonas.get(i);
			if(persona instanceof Cliente) {
				Cliente cliente=(Cliente) persona;
				if(cliente.antiguedadEnAnios()>=mayorIgualA) {
					lista.add(persona);
				}
			}
			else if(persona instanceof Empleado){
				Empleado empleado=(Empleado) persona;
				if(empleado.antiguedadEnAnios()>=mayorIgualA) {
					lista.add(persona);
				}
			}
		}
		return lista;
		
	}
public boolean validarHora(LocalTime hora,LocalTime horaDesde,LocalTime horaHasta) {
	return ((!hora.isBefore(horaDesde) && !hora.isAfter(horaHasta) || hora.equals(horaDesde) || hora.equals(horaHasta)));
}

	public List<Llamada> traerLlamadas(LocalDate fecha, LocalTime horaDesde, LocalTime horaHasta){
		List<Llamada> lista=new ArrayList<Llamada>();
		for(int i=0;i<this.lstLlamadas.size();i++) {
			Llamada llamada=this.lstLlamadas.get(i);
			if(this.lstLlamadas.get(i).getFecha().isEqual(fecha) && this.validarHora(llamada.getHora(), horaDesde, horaHasta)){
				 lista.add(llamada);				
			}

		}
		return lista;
	}
	
}
