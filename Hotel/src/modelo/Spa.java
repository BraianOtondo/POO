package modelo;
import modelo.Venta;
import java.time.LocalDate;
import java.time.LocalTime;

public class Spa extends Venta{
private LocalDate fecha;
private LocalTime hora;
private int minutos;
public Spa(int idVenta, Pasajero pasajero, LocalDate fecha, LocalDate fechaEntrada, LocalTime hora, int minutos) {
	super(idVenta, pasajero, fecha);
	this.fecha = fechaEntrada;
	this.hora = hora;
	this.minutos = minutos;
}
public LocalDate getFecha() {
	return fecha;
}
public void setFecha(LocalDate fecha) {
	this.fecha = fecha;
}
public LocalTime getHora() {
	return hora;
}
public void setHora(LocalTime hora) {
	this.hora = hora;
}
public int getMinutos() {
	return minutos;
}
public void setMinutos(int minutos) {
	this.minutos = minutos;
}
@Override
public String toString() {
	return "Spa ["+super.toString()+", fecha=" + fecha + ", hora=" + hora + ", minutos=" + minutos + "]";
}
//salidaSpa():LocalTime //retorna la hora de salida del spa según la hora de entrada y los minutos
//que permanece del objeto.
public LocalTime salidaSpa() {
	return this.getHora().plusMinutes(this.getMinutos());
}

}
