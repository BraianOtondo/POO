package test;

import modelo.Genero;
import modelo.Incaa;

public class TestIncaa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Genero genero1=new  Genero(0,"Terror");
		Genero genero2=new Genero(2,"Ciencia Ficcion");
		Genero genero3=new Genero(3,"Accion");
		Genero genero4= new Genero(4,"Comedia");
		
		Incaa incaa=new Incaa();
		try {
			System.out.println(incaa.agregarPelicula("La Momia", genero3));
			System.out.println(incaa.agregarPelicula("MAD", genero4));
			System.out.println(incaa.agregarPelicula("La bruja de Blair", genero1));
			System.out.println(incaa.agregarPelicula("RocaLoca", genero2));
			System.out.println(incaa.agregarPelicula("La Monja", genero1));
			System.out.println(incaa.agregarPelicula("Jeff the Killer", genero1));
			System.out.println(incaa.agregarPelicula("RocaLoca", genero4));

			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println(incaa.modificarPelicula(4,"Jumanji"));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		System.out.println(incaa);
		
		//System.out.println(incaa.eliminarPelicula(3));
		
		System.out.println("Nuevas Peliculas: ");
		try {
			System.out.println(incaa.eliminarPelicula(4));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		System.out.println(incaa);
		//LISTA
		System.out.println("Lista de un genero: ");
		
		System.out.println(incaa.traerPelicula(genero1));
	}

}
