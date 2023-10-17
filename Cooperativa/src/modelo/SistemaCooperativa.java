package modelo;

import java.util.ArrayList;
import java.util.List;

public class SistemaCooperativa {
private List<Stock> stocks;
private List<Producto> productos;
public SistemaCooperativa() {
	super();
	this.stocks = new ArrayList<Stock>();
	this.productos = new ArrayList<Producto>();
}
public List<Stock> getStocks() {
	return stocks;
}
public void setStocks(List<Stock> stocks) {
	this.stocks = stocks;
}
public List<Producto> getProductos() {
	return productos;
}
public void setProductos(List<Producto> productos) {
	this.productos = productos;
}
public Producto traerProducto(String codigo, String nombre) {
	Producto objeto=null;
	int i=0;
	while(i<this.productos.size() && objeto==null) {
		if(this.productos.get(i).getCodigo().equals(codigo) && this.productos.get(i).getNombre().equals(nombre)) {
			objeto=this.productos.get(i);
		}
		i++;
	}
	return objeto;
}
private int traerUltidmoIdProducto() {
	int id=0;
	if(this.productos.size()!=0) {
		id=this.productos.get(this.productos.size()-1).getIdProducto();
	}
	return id;
}
//Lanza una excepción si el producto es inválido
//Calcular el id de forma autoincremental
public boolean agregarProducto(String codigo, String nombre, double precio) throws Exception{
	Producto objeto=this.traerProducto(codigo, nombre);
	if(objeto!=null) {
		throw new Exception("El producto ya existe");
	}
	objeto=new Producto(this.traerUltidmoIdProducto()+1, codigo, nombre, precio);
return this.productos.add(objeto);
}
//3) 
public Producto traerProducto(String codigo) {
	Producto encontrado=null;
	int i=0;
	while(i<this.productos.size() &&  encontrado==null) {
		if(this.productos.get(i).getCodigo().equals(codigo)){
			encontrado=this.productos.get(i);
		}
		i++;
	}
	return encontrado;
}
public Producto traerProducto(Producto producto) {
	Producto encontrado=null;
	int i=0;
	while(i<this.productos.size() && encontrado==null) {
		if(this.productos.get(i).equals(producto)) {
			encontrado=this.productos.get(i);
		}
	}
	return encontrado;
}
//agregarPedido(Producto producto): boolean
//Calcular el id de forma autoincremental

//Lanza una excepción si el producto es inválido
//Calcular el id de forma autoincremental


}
