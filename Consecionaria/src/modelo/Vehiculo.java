package modelo;

import java.time.LocalDate;

public abstract class Vehiculo {
	protected int idVehiculo;
	protected String marca;
	protected String modelo;
	protected int anio;
	protected int cantRuedas;
	protected double eficienciaMotor;
	public Vehiculo(int idVehiculo, String marca, String modelo, int anio, int cantRuedas, double eficienciaMotor) throws Exception{
		super();
		this.idVehiculo = idVehiculo;
		this.marca = marca;
		this.modelo = modelo;
		this.anio = anio;
		this.cantRuedas = cantRuedas;
		this.setEficienciaMotor(eficienciaMotor);
		
	}
	public abstract double calcularConsumo(int km);// es abstracto porque es distinto a motos y autos
	public int getIdVehiculo() {
		return idVehiculo;
	}
	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public int getCantRuedas() {
		return cantRuedas;
	}
	public void setCantRuedas(int cantRuedas) {
		this.cantRuedas = cantRuedas;
	}
	public double getEficienciaMotor() {
		return eficienciaMotor;
	}
	//El atributo eficienciaMotor de la clase Veh�culo tendr� un valor entre 0.1 y 0.9 (Pueden agregar validaci�n y excepci�n para controlar ese dato). El valor 0.1 indica que tiene menor consumo por km, por lo tanto es 
	//mas eficiente, y el valor 0.9 indica un mayor consumo, por lo cual es mas ineficiente.
	public void setEficienciaMotor(double eficienciaMotor) throws Exception{
		if(!(0.1<=eficienciaMotor && 0.9>=eficienciaMotor)) {
			throw new Exception("El valor es invalido");
		}
		this.eficienciaMotor = eficienciaMotor;
	}

	public boolean equals(Vehiculo vehiculo) {
		return idVehiculo == vehiculo.getIdVehiculo();
	}
	@Override
	public String toString() {
		return "Vehiculo [idVehiculo=" + idVehiculo + ", marca=" + marca + ", modelo=" + modelo + ", anio=" + anio
				+ ", cantRuedas=" + cantRuedas + ", eficienciaMotor=" + eficienciaMotor + "]";
	}
	
	public int aniosAntiguedad() {
		return LocalDate.now().getYear()-this.anio;
	}
	
}
