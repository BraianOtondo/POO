package modelo;

public class Auto extends Vehiculo{
	private int cantPuertas;
	public Auto(int idVehiculo, String marca, String modelo, int anio, int cantRuedas, double eficienciaMotor, int cantPuertas) throws Exception {
		super(idVehiculo, marca, modelo, anio, cantRuedas, eficienciaMotor);
		// TODO Auto-generated constructor stub
		this.cantPuertas=cantPuertas;
	}

	public int getCantPuertas() {
		return cantPuertas;
	}

	public void setCantPuertas(int cantPuertas) {
		this.cantPuertas = cantPuertas;
	}

	@Override
	public int aniosAntiguedad() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calcularConsumo(int km) {
		// TODO Auto-generated method stub
		
		return  km * this.eficienciaMotor;
	}

}
