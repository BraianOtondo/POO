package test;

import modelo.Medico;
import modelo.Paciente;

public class TestConsultorio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Paciente[] pacientes= {new Paciente("Pedro","Sanchez" ,1.80f ,60f ),new Paciente("Ramiro","Juanes", 1.58f, 63),new Paciente("Roberto","Carlos", 1.77f, 88),new Paciente("Roberto","Baggio", 1.78f, 83)};
		Medico medico= new Medico("Dr","Simi","odontologia", pacientes);
		System.out.println(medico);
		System.out.println("Paciente con menor IMC: ");
		System.out.println(medico.traerMenorIMC());
		System.out.println("Paciente con mayor estatura: ");
		System.out.println(medico.traerPacienteMayorEstatura());
	}

}
