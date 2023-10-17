package modelo;
import modelo.Venta;
import java.time.LocalDate;

public class Estadia extends Venta{
	private LocalDate checkIn;
	private int cantNoche;
	private int cantDePlazas;
	public Estadia(int idVenta, Pasajero pasajero, LocalDate fecha, LocalDate checkIn, int cantNoche,
			int cantDePlazas) throws Exception {
		super(idVenta, pasajero, fecha);
		this.setCheckIn(checkIn);
		this.cantNoche = cantNoche;
		this.cantDePlazas = cantDePlazas;
	}
	public LocalDate getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(LocalDate checkIn) throws Exception {
		if(this.validarCheckIn(checkIn)==false) {
			throw new Exception("Es invalida fecha de CheckIn");
		}
		this.checkIn = checkIn;
	}
	public int getCantNoche() {
		return cantNoche;
	}
	public void setCantNoche(int cantNoche) {
		this.cantNoche = cantNoche;
	}
	public int getCantDePlazas() {
		return cantDePlazas;
	}
	public void setCantDePlazas(int cantDePlazas) {
		this.cantDePlazas = cantDePlazas;
	}
	@Override
	public String toString() {
		return "Estadia ["+super.toString() +", checkIn=" + checkIn + ", cantNoche=" + cantNoche + ", cantDePlazas=" + cantDePlazas + "]";
	}
	//setCheckIn(LocalDate checkIn) //retorna una excepción si la fecha de chek-in es anterior a la
	//fecha de venta
	private boolean validarCheckIn(LocalDate checkIn) {
		boolean valido=false;
		if(checkIn.isAfter(this.getFecha()) || checkIn.isEqual(this.getFecha())) {
			valido=true;
		}
		return valido;
	}
}
