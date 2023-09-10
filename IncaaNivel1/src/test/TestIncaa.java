package test;

import modelo.Incaa;

public class TestIncaa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Incaa incaa=new Incaa();
		incaa.agregarPelicula("Zoolander");
		incaa.agregarPelicula("El rey Leon");
		incaa.agregarPelicula("The Batman");
		incaa.agregarPelicula("Pinocho");
		System.out.println(incaa);
		incaa.eliminarPelicula(2);
		System.out.println(incaa);
		
	}
}