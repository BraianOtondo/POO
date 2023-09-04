package modelo;



public class Circulo {
	private Punto origen;
	private double radio;
	public Circulo(Punto origen, double radio) {
		super();
		this.origen = origen;
		this.radio = radio;
	}
	public Punto getOrigen() {
		return origen;
	}
	public void setOrigen(Punto origen) {
		this.origen = origen;
	}
	public double getRadio() {
		return radio;
	}
	public void setRadio(double radio) {
		this.radio = radio;
	}
	public void setRadio (Punto radio) {
		
	}
	@Override
	public String toString() {
		return "Circulo [origen=" + origen + ", radio=" + radio + "]";
	}

	
	public boolean equals(Circulo circulo) {
		
		return circulo.getOrigen().equals(this.getOrigen()) && circulo.getRadio()==this.getRadio();
	}
	//d=√((x_2-x_1)²+(y_2-y_1)²)-(r1+r2)
	public double calcularDistancia(Circulo circulo) {
		double distancia=this.origen.calcularDistancia(circulo.origen);
		
		return (distancia -(this.radio+circulo.radio));
	}
	public double calcularPerimetro() {
		return 2*Math.PI*this.radio;
	}
	public double calcularArea() {
		return Math.PI*this.radio*this.radio;
	}
	// el problema con esto es que si teniamos 2 circulos que comparten mismo origen el desplazamiento
	// afectaria a ambos circulos, cosa que no queremos 
	public void mover(double desplazamientoX,
			double desplazamientoY){
			// hacemos una copia del origen para no modificar el atributo de
			// la clase
			Punto nuevoOrigen = new Punto(origen.getX(),origen.getY());
			// asignamos el nuevo origen de este círculo
			origen = nuevoOrigen;
			// ahora sí, movemos el círculo
			origen.mover(desplazamientoX,desplazamientoY);
			}
}
