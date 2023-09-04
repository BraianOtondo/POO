package test;

import modelo.Circulo;
import modelo.Punto;

public class TestGeometria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Punto punto1=new Punto(0, 0);
		Punto punto2=new Punto(8, 0);
		Circulo circulo1=new Circulo(punto1, 5);
		Circulo circulo2=new Circulo(punto2, 4);
		System.out.println(punto1.calcularDistancia(punto2));
		System.out.println("CIRCULO");
		System.out.println(circulo1.calcularDistancia(circulo2));
	
	}

}
