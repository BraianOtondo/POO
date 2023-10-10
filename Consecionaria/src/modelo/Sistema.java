package modelo;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Vehiculo> lstVehiculo;

	public Sistema() {
		super();
		this.lstVehiculo = new ArrayList<Vehiculo>();
		
	}

	public List<Vehiculo> getLstVehiculo() {
		return lstVehiculo;
	}

	public void setLstVehiculo(List<Vehiculo> lstVehiculo) {
		this.lstVehiculo = lstVehiculo;
	}
	
	@Override
	public String toString() {
		return "Sistema [lstVehiculo=" + lstVehiculo + "]";
	}
	
	public Vehiculo traerVehiculo(String marca, String modelo){
		Vehiculo encontrado=null;
		int i=0;
		while(i<this.lstVehiculo.size() && encontrado==null) {
			if(this.lstVehiculo.get(i).getMarca().equals(marca)&& this.lstVehiculo.get(i).getModelo().equals(modelo)) {
				encontrado=this.lstVehiculo.get(i);
			}
			i++;
		}
		return encontrado;
	}
	private int  traerUltimoId() {
		int id=0;
		if(this.lstVehiculo.size()!=0) {
			id=this.lstVehiculo.get(this.lstVehiculo.size()-1).getIdVehiculo();
		}
		return id;
	}
	public boolean agregarAuto(String marca, String modelo, int anio, int cantRuedas, double eficienciaMotor,int cantPuertas)throws Exception {
		Auto objeto=(Auto) this.traerVehiculo(marca, modelo);
		if(objeto!=null) {
			throw new Exception("El auto con marca: "+marca+" y modelo: "+modelo+" ya existe");
		}
		objeto=new Auto(this.traerUltimoId()+1, marca, modelo, anio, cantRuedas, eficienciaMotor, cantPuertas);
		return this.lstVehiculo.add(objeto);
	}
	public boolean agregarMoto(String marca, String modelo, int anio, int cantRuedas, double eficienciaMotor,boolean incluyeCaja,boolean disenioAerodinamico)throws Exception {
		Moto objeto=(Moto) this.traerVehiculo(marca, modelo);
		if(objeto!=null) {
			throw new Exception("La moto con marca: "+marca+" y modelo: "+modelo+" ya existe");
		}
		objeto=new Moto(this.traerUltimoId()+1, marca, modelo, anio, cantRuedas, eficienciaMotor, incluyeCaja, disenioAerodinamico);
		return this.lstVehiculo.add(objeto);
	}
	//Se consideran vehículos de transporte a todos los Autos y a las Motos que incluyen caja.

	public List<Vehiculo> traerVehiculosDeTransporte(){
		List<Vehiculo> lista=new ArrayList<Vehiculo>();
		for(int i=0;i<this.lstVehiculo.size();i++) {
			Vehiculo vehiculo=this.lstVehiculo.get(i);
			if(vehiculo instanceof Auto){
			
				lista.add(vehiculo);
			}else if(vehiculo instanceof Moto){
				Moto moto=(Moto) vehiculo;
				if(moto.isIncluyeCaja()==true) {
					lista.add(vehiculo);
				}
			}
		}
		return lista;
	}
	//Al traer los vehículos por consumo, se deben traer todos aquellos vehículos de la lista de vehículos que al calcular 
	//el consumo para cada uno, el resultado quede por debajo del topeConsumo.
	public List<Vehiculo> traerVehiculosPorConsumo(int km, double topeConsumo){
	List<Vehiculo> lista=new ArrayList<Vehiculo>();
	for(int i=0;i<this.lstVehiculo.size();i++) {
		Vehiculo vehiculo=this.lstVehiculo.get(i);
		if(vehiculo.calcularConsumo(km)<topeConsumo) {
			lista.add(vehiculo);
		}
	}
	return lista;
	}
}
