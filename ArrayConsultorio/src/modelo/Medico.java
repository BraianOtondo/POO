package modelo;

import java.util.Arrays;

public class Medico {
	private String nombre;
	private String apellido;
	private String especialidad;
	private Paciente[] pacientesfrecuentes;
	public Medico(String nombre, String apellido, String especialidad, Paciente[] pacientesfrecuentes) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.especialidad = especialidad;
		this.pacientesfrecuentes = pacientesfrecuentes;
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
	public Paciente[] getPacientesfrecuentes() {
		return pacientesfrecuentes;
	}
	public void setPacientesfrecuentes(Paciente[] pacientesfrecuentes) {
		this.pacientesfrecuentes = pacientesfrecuentes;
	}

	public boolean equals(Medico medico) {
	
		return this.nombre.equals(medico.getNombre()) && this.apellido.equals(medico.getApellido());
	}
	
	
	@Override
	public String toString() {
		return "Medico [nombre=" + nombre + ", apellido=" + apellido + ", especialidad=" + especialidad
				+ ", pacientesfrecuentes=" + Arrays.toString(pacientesfrecuentes) + "]";
	}
	public double calcularIMC(Paciente paciente) {
			//imc = peso/estatura2
		return (float) (paciente.getPeso()/Math.pow(paciente.getEstatura(),2));
		
	}
	public double traerPromedioPeso() {
		double total=0;
		for(int i=0;i<this.pacientesfrecuentes.length;i++){
			total=total+pacientesfrecuentes[i].getPeso();
		}
		return total/pacientesfrecuentes.length;
	}
	public Paciente traerPacienteMayorEstatura() {
		Paciente paciente=this.pacientesfrecuentes[0];
		float mayor=this.pacientesfrecuentes[0].getEstatura();
		for(int i=1;i<this.pacientesfrecuentes.length;i++) {
			if(mayor<this.pacientesfrecuentes[i].getEstatura()) {
				mayor=pacientesfrecuentes[i].getEstatura();
				paciente=pacientesfrecuentes[i];
			}
		}
		
		return paciente;
	}
	
	public Paciente traerMenorIMC(){
		Paciente paciente=this.pacientesfrecuentes[0];
		double menor=this.calcularIMC(pacientesfrecuentes[0]);
		for(int i=1;i<this.pacientesfrecuentes.length;i++) {
			if(menor>this.calcularIMC(pacientesfrecuentes[i])) {
				menor=this.calcularIMC(pacientesfrecuentes[i]);
				paciente=this.pacientesfrecuentes[i];
			}
		}
		return paciente;
	}
}
