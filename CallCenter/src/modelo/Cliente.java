package modelo;

import java.time.LocalDate;

public class Cliente extends Persona{
private boolean activo;

public Cliente(int idPersona, String nombre, long dni, LocalDate fechaDeAlta, boolean activo) {
	super(idPersona, nombre, dni, fechaDeAlta);
	this.activo = activo;
}

public boolean isActivo() {
	return activo;
}

public void setActivo(boolean activo) {
	this.activo = activo;
}

@Override
public String toString() {
	return "Cliente ["+super.toString()+ ", activo=" + activo + "]";
}

@Override
public int antiguedadEnAnios() {
	int antiguedad=0;
	if(this.activo==true) {
		antiguedad=LocalDate.now().getYear()-this.antiguedadEnAnios();
	}
	return antiguedad;
}

}
