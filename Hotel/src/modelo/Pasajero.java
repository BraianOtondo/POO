package modelo;

public class Pasajero {
	private int idPasajero;
	private String apellido;
	private String nombre;
	private int dni;
	public Pasajero(int idPasajero, String apellido, String nombre, int dni) {
		super();
		this.idPasajero = idPasajero;
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
	}
	public int getIdPasajero() {
		return idPasajero;
	}
	public void setIdPasajero(int idPasajero) {
		this.idPasajero = idPasajero;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public boolean equals(Pasajero pasajero) {
		return dni == pasajero.getDni();
	}
	@Override
	public String toString() {
		return "Pasajero [idPasajero=" + idPasajero + ", apellido=" + apellido + ", nombre=" + nombre + ", dni=" + dni
				+ "]";
	}

	
}
