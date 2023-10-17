package modelo;

public class Moto extends Vehiculo{
	private boolean incluyeCaja;
	private boolean disenioAerodinamico;
	

	public Moto(int idVehiculo, String marca, String modelo, int anio, int cantRuedas, double eficienciaMotor,
			boolean incluyeCaja, boolean disenioAerodinamico) throws Exception {
		super(idVehiculo, marca, modelo, anio, cantRuedas, eficienciaMotor);
		this.incluyeCaja = incluyeCaja;
		this.disenioAerodinamico = disenioAerodinamico;
	}
	
	public boolean isIncluyeCaja() {
		return incluyeCaja;
	}

	public void setIncluyeCaja(boolean incluyeCaja) {
		this.incluyeCaja = incluyeCaja;
	}

	public boolean isDisenioAerodinamico() {
		return disenioAerodinamico;
	}

	public void setDisenioAerodinamico(boolean disenioAerodinamico) {
		this.disenioAerodinamico = disenioAerodinamico;
	}

	@Override
	public int aniosAntiguedad() {
		// TODO Auto-generated method stub
		return 0;
	}
// las Motos, que si tienen caja se debe contemplar un aumento de 0.03 a la eficienciaMotor
//(sin modificar el valor del atributo, solo para el calculo del consumo) y si tiene un disenioAerodinamico se contempla 0.05 menos a la eficienciaMotor.
//El resultado de esa eficienciaMotor ajustada se multiplica por la cantidad de km para calcular el consumo.
//Tener en cuenta que la misma moto puede tener un dise�oAerodinamico y tener caja, en ese caso se aumenta 0.03 y se disminuye 0.05. 
	@Override
	public double calcularConsumo(int km) {
		
		// TODO Auto-generated method stub
		double aumento=this.eficienciaMotor;
		if(this.incluyeCaja==true){
			aumento=aumento+0.03;
		}
		if(this.disenioAerodinamico==true){
			aumento=aumento-0.05;
		}
		return km*aumento;
	}

	@Override
	public String toString() {
		return "Moto ["+super.toString()+", incluyeCaja=" + incluyeCaja + ", disenioAerodinamico=" + disenioAerodinamico + "]";
	}

}
