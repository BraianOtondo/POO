package modelo;

public class Medico {
	private String nombre;
	private String apellido;
	private String especialidad;
	public Medico(String nombre, String apellido, String especialidad) {
	
		this.nombre = nombre;
		this.apellido = apellido;
		this.especialidad = especialidad;
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
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	public boolean equals(Medico medico) {
	return medico.getNombre().equals(this.getNombre())&& medico.getApellido().equals(this.getApellido());
	}
	public float calcularIMC(Paciente paciente ) {
		//imc = peso/estatura2
	return (float) (paciente.getPeso()/Math.pow(paciente.getEstatura(),2));
	}
	
	
}	
