package test;

import modelo.Medico;
import modelo.Paciente;

public class TestConsultorio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Paciente paciente=new Paciente("Pedro","Sanchez", 1.80f,80);
		System.out.println(paciente.toString());
		System.out.println(paciente.traerNombreCompleto());
		Medico medico = new Medico("Raul","Gutierrez","Ortopedia");
		System.out.println("IMC: "+medico.calcularIMC(paciente));
		paciente.setEstatura(1.78f);
		System.out.println("Nuevo IMC: "+medico.calcularIMC(paciente));
		Paciente paciente2=new Paciente("Jose","Manuel",1.90f, 80);
		System.out.println(paciente2.toString());
		System.out.println("Distintos espacio de mamoria: ? ");
		System.out.println(paciente==paciente2); // false porque ambos tienes distintos id de memoria
		
	}

}
