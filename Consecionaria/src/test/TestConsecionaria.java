package test;

import modelo.*;

public class TestConsecionaria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sistema s= new Sistema();
		//String marca, String modelo, int anio, int cantRuedas, double eficienciaMotor,int cantPuertas
			//El atributo eficienciaMotor de la clase Veh�culo tendr� un valor entre 0.1 y 0.9 
				//agragacion
				try {
					s.agregarAuto("Riot","Safiro", 2021, 4, 0.1, 3);//0
					s.agregarAuto("Romm","Safiro", 2000, 3, 0.4, 4);//1
					s.agregarAuto("Riot","Alas", 2023, 4, 0.7, 2);//2
					s.agregarMoto("Riot","Pep", 2000, 2, 0.4, false, false);//3
					s.agregarMoto("Gtx","Heso", 2020, 3, 0.9, true, false);//4
					s.agregarMoto("Romm", "Piposs", 2010, 3, 0.1, true, true);//5
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				//System.out.println(s.getLstVehiculo());
				//System.out.println(s.getLstVehiculo().get(0).aniosAntiguedad());//funciona
				//System.out.println(s.getLstVehiculo().get(0).calcularConsumo(2));
				//System.out.println(s.getLstVehiculo().get(3).aniosAntiguedad());
				System.out.println(s.getLstVehiculo().get(3).calcularConsumo(10));//Funciona no hace cambio
				//System.out.println(s.getLstVehiculo().get(4).calcularConsumo(10));
				System.out.println(s.getLstVehiculo().get(5).calcularConsumo(10));//funciona
				System.out.println(s.traerVehiculosDeTransporte());// funciona
				System.out.println(s.traerVehiculosPorConsumo(10, 2));
				System.out.println("Funciona?");
				System.out.println((Moto)s.traerVehiculo("Gtx","Heso"));
	}

}
