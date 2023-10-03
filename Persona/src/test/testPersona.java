package test;
import java.time.LocalDate;
import modelo.*;
public class testPersona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Persona persona=new Persona("Pedro","Apellido", 412412, LocalDate.of(1999, 8, 15));
		try {
			System.out.println(persona.calcularEdad(persona.getFechaNacimiento()));

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}*/
		//LocalDate fecha=LocalDate.now();
		//System.out.println(fecha.lengthOfMonth());
		Persona empleado= new Empleado("Raul", "Lopez", 542145,LocalDate.of(1999, 8, 15), 42, 310000);
		try {
			System.out.println(empleado.calcularEdad(empleado.getFechaNacimiento()));

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		Empleado empleadoAux=(Empleado) empleado;
		System.out.println(empleadoAux.calcularSueldo(10));
	}

}
