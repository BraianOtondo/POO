package modelo;

import java.time.LocalDate;
import java.time.Period;
// debe ser abstracta osea que solo podamos crear Empleado o Cliente
// y no Persona como tal

public abstract class Persona {
	private String nombre;
	private String apellido;
	private long dni;
	private LocalDate fechaNacimiento;
	public Persona(String nombre, String apellido, long dni, LocalDate fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public long getDni() {
		return dni;
	}
	public void setDni(long dni) {
		this.dni = dni;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public boolean equals(Persona persona) {

		return dni == persona.getDni();
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", fechaNacimiento="
				+ fechaNacimiento + "]";
	}
	
	public int calcularEdad(LocalDate fecha) throws Exception {
		int edad=0;
		if(this.validarEdad(fecha)==true) {
			Period periodo;
			periodo=Period.between(fecha, LocalDate.now());
			edad=periodo.getYears();
		}
		
		return edad;
	}
	private boolean validarEdad(LocalDate fecha)throws Exception{
		if(!fecha.isBefore(LocalDate.now()) ){
			throw new Exception("La fecha no es valida porque es mayor a la actual ");
		}
		return true;
	}
	public abstract String hablar();
}
