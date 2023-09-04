package modelo;


public class Punto {
	private double x;
	private double y;
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public Punto(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Punto [x=" + x + ", y=" + y + "]";
	}

	public boolean equals(Punto punto) {
	return punto.getX()==this.x && punto.getY()==this.y;
	}
	// no reemplaza directo, lo que hace es moverse una posicion hacia la que indique punto. Afectando al punto 
	public void mover(double desplazamientoX, double desplazamientoY){
		this.x = this.x + desplazamientoX;
		this.y = this.y + desplazamientoY;
		}
	
	public double calcularDistancia(Punto punto) {
		double distancia= Math.pow(punto.getX()-this.getX(),2) + Math.pow(punto.getY()-this.getY(), 2);
		
		return Math.sqrt(distancia);
	}
	//d=√((x_2-x_1)²+(y_2-y_1)²)
}
