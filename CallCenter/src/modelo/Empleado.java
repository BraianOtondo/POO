package modelo;

import java.time.LocalDate;
import java.time.Period;

public class Empleado extends Persona{
	private int sueldoBase;

	public Empleado(int idPersona, String nombre, long dni, LocalDate fechaDeAlta, int sueldoBase) {
		super(idPersona, nombre, dni, fechaDeAlta);
		this.sueldoBase = sueldoBase;
	}

	public int getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(int sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	@Override
	public String toString() {
		return "Empleado ["+super.toString()+", sueldoBase=" + sueldoBase + "]";
	}
	public LocalDate traerFechaDiaHabilPrimeraDelMesSiguiente() {
		LocalDate fechaHabil=LocalDate.now().plusMonths(1).withDayOfMonth(1);
		while(Empleado.esDiaHabil(fechaHabil)==false) {
			fechaHabil=fechaHabil.plusDays(1);
		}
		
		return fechaHabil;
	}
	public LocalDate traerFechaDiaHabilPrimeraDisponible(LocalDate fecha) {
		LocalDate fechaHabil=fecha;
		while(Empleado.esDiaHabil(fechaHabil)==false) {
			fechaHabil=fechaHabil.plusDays(1);
		}
		
		return fechaHabil;
	}
	public static boolean esDiaHabil(LocalDate fecha) {
		int d = fecha.getDayOfWeek().getValue();
		return ((d >= 1) && (d <= 5));
	}
	@Override
	public int antiguedadEnAnios() {
		//		return Period.between(this.fechaDeAlta,LocalDate.now().plusMonths(1).withDayOfMonth(1)).getYears();
		return Period.between(this.fechaDeAlta,this.traerFechaDiaHabilPrimeraDisponible(LocalDate.now().plusMonths(1).withDayOfMonth(1))).getYears();
	}
	
}
