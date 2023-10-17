package test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

import modelo.Funciones;

public class TestFunciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Period.between(LocalDate.of(2022, 10, 15),LocalDate.now());
		Funciones f=new Funciones(LocalDate.now(),LocalTime.now());
		System.out.println(Period.between(LocalDate.of(2022,10, 16),LocalDate.now()).plusMonths(1).toTotalMonths());
		System.out.println(f.traerFechaDiaHabilPrimeraDelMesSiguiente());
		System.out.println(f.traerFechaDiaHabilPrimeraDisponible(LocalDate.of(2024, 6, 1)));
		System.out.println(f.traerPeriodoHoraEnMinutos(LocalTime.of(17, 18), LocalTime.of(17, 28)));
		System.out.println("Prueba");
	
		System.out.println(	LocalDate.now().isBefore(LocalDate.of(2023, 10, 16)));
		System.out.println(f.validarHoraMenora(LocalTime.of(15, 0)));
		//IGUAL
	}

}
