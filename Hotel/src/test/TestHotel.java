package test;

import java.time.LocalDate;
import java.time.LocalTime;
import modelo.*;
//import modelo.Sistema;

public class TestHotel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sistema sistema=new Sistema();
		System.out.println("1");
		//[Pasajero [idPasajero=1, dni=11111111, apellido=Romero, nombre=Sol],
		 //Pasajero [idPasajero=2, dni=22222222, apellido=Martinez, nombre=Julian]]
		
		try {
			sistema.agregarPasajero(11111111,"Romero","Sol");
			sistema.agregarPasajero(22222222,"Martinez","Julian");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		System.out.println(sistema.getPasajeros());
		System.out.println("2");
		try {
			sistema.agregarEstadia(LocalDate.of(2021, 4, 07),sistema.traerPasajero(22222222),LocalDate.of(2021, 4, 4), 3, 3);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		System.out.println(sistema.getVentas());
	System.out.println("3");
	//Estadia [idVenta=1, fechaVenta=2021-04-07, pasajero=Pasajero [idPasajero=2, dni=22222222,
	//apellido=Martinez, nombre=Julian], checkIn=2021-04-11, cantNoches=3, cantPlazas=3],
	
	//Spa [idVenta=2, fechaVenta=2021-04-07, pasajero=Pasajero [idPasajero=2, dni=22222222,
	//apellido=Martinez, nombre=Julian], fecha=2021-04-13, hora=16:10, minutos=90],
	
	//Estadia [idVenta=3, fechaVenta=2021-04-08, pasajero=Pasajero [idPasajero=1, dni=11111111,
	//apellido=Romero, nombre=Sol], checkIn=2021-04-12, cantNoches=4, cantPlazas=2],
	
	//Spa [idVenta=4, fechaVenta=2021-04-08, pasajero=Pasajero [idPasajero=1, dni=11111111,
	//apellido=Romero, nombre=Sol], fecha=2021-04-13, hora=15:30, minutos=45]]
	try {
	//agregarEstadia(LocalDate fechaVenta, Pasajero pasajero, LocalDate checkIn, int cantNoches, int cantPlazas)
	//agregarSpa(LocalDate fechaVenta, Pasajero pasajero, LocalDate fecha, LocalTime hora, int minutos)
		sistema.agregarEstadia(LocalDate.of(2021, 4, 7),sistema.traerPasajero(22222222),LocalDate.of(2021, 4, 11), 3, 3);
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e.getMessage()+"1");
	}
	try {
		sistema.agregarSpa(LocalDate.of(2021, 4,7),sistema.traerPasajero(22222222),LocalDate.of(2021,4, 13),LocalTime.of(16, 10),90);

	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e.getMessage()+"2");
	}
	try {
		sistema.agregarEstadia(LocalDate.of(2021, 4, 8),sistema.traerPasajero(11111111),LocalDate.of(2021, 4, 12), 4, 2);

	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e.getMessage()+"3");

	}
	try {
		sistema.agregarSpa(LocalDate.of(2021, 4, 8),sistema.traerPasajero(11111111),LocalDate.of(2021, 4, 13),LocalTime.of(15,30), 45);

	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e.getMessage()+"4");

	}
	System.out.println(sistema.getVentas());
	
	System.out.println("4");
	//4) Traer la estadia idVenta=2 (con todos los atributos) y la hora de salida del Spa
	System.out.println(sistema.traerVenta(2));
	Venta venta=sistema.traerVenta(2);
	if(venta instanceof Spa) {
		Spa spa=(Spa) venta;
		System.out.println(spa.salidaSpa());
	}
	System.out.println("5");
	//5) Traer los objetos Spa activos dia=2021-04-13, hora=16:10
	System.out.println(sistema.traerSpas(LocalDate.of(2021, 4, 13),LocalTime.of(16, 10)));
	}

}
