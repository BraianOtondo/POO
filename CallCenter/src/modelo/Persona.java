package modelo;

import java.time.LocalDate;

public abstract class Persona {
	protected int idPersona;
	protected String nombre;
	protected long dni;
	protected LocalDate fechaDeAlta;
	public Persona(int idPersona, String nombre, long dni, LocalDate fechaDeAlta) {
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.dni = dni;
		this.fechaDeAlta = fechaDeAlta;
	}
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public long getDni() {
		return dni;
	}
	public void setDni(long dni) {
		this.dni = dni;
	}
	public LocalDate getFechaDeAlta() {
		return fechaDeAlta;
	}
	public void setFechaDeAlta(LocalDate fechaDeAlta) {
		this.fechaDeAlta = fechaDeAlta;
	}
	public boolean equals(Persona persona) {

		return dni == persona.getDni();
	}
	@Override
	public String toString() {
		return "idPersona=" + idPersona + ", nombre=" + nombre + ", dni=" + dni + ", fechaDeAlta="
				+ fechaDeAlta;
	}
	public abstract int antiguedadEnAnios();
	
	
}
