package test;

import modelo.Incaa;

public class TestIncaa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Incaa incaa=new Incaa();
		// Test de Agregar
		try {
			System.out.println(incaa.agregarPelicula("Zoolander"));
			System.out.println(incaa.agregarPelicula("El rey Leon"));
			System.out.println(incaa.agregarPelicula("The Batman"));
			System.out.println(incaa.agregarPelicula("Pinocho"));
			System.out.println(incaa.agregarPelicula("Pinocho"));
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		// Test Modificar
		try {
			System.out.println(incaa.modificarPelicula(2,"El Rey Leon 2"));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		//Test eliminar
		try {
			System.out.println(incaa.eliminarPelicula(1));
			System.out.println(incaa.eliminarPelicula(2));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		System.out.println(incaa);
		
	}
}