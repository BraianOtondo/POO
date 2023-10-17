package modelo;

import java.util.Objects;

public class Producto {
private int idProducto;
private String codigo;
private String nombre;
private double precio;
public Producto(int idProducto, String codigo, String nombre, double precio) throws Exception{
	super();
	this.idProducto = idProducto;
	this.setCodigo(codigo);
	this.nombre = nombre;
	this.precio = precio;
}
public int getIdProducto() {
	return idProducto;
}
public void setIdProducto(int idProducto) {
	this.idProducto = idProducto;
}
public String getCodigo() {
	return codigo;
}
// Lanza Excepcion de producto invalido si el codigo no tenga longitud de  10 caracteres
public void setCodigo(String codigo) throws Exception{
	if(this.validarCodigo(codigo)==true) {
		this.codigo=codigo;
	}
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public double getPrecio() {
	return precio;
}
public void setPrecio(double precio) {
	this.precio = precio;
}

public boolean equals(Producto producto) {
	return producto.getCodigo().equals(this.codigo) && producto.getNombre().equals(this.nombre);
}
@Override
public String toString() {
	return "Producto [idProducto=" + idProducto + ", codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio
			+ "]";
}
private boolean validarCodigo(String codigo) {
	boolean valido=false;
	if(codigo.length()==10) {
		valido=true;
	}
	return valido;
}
}
