package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Supermercado {
	private List<Producto> gondola;
	private List<Carrito> lstCarrito;
	public Supermercado() {
		gondola=new ArrayList<Producto>();
		lstCarrito=new ArrayList<Carrito>();
	}
	public List<Producto> getGondola() {
		return gondola;
	}
	public void setGondola(List<Producto> lstProducto) {
		this.gondola = lstProducto;
	}
	public List<Carrito> getLstCarrito() {
		return lstCarrito;
	}
	public void setlstCarrito(List<Carrito> lstCarrito) {
		this.lstCarrito = lstCarrito;
	}
	@Override
	public String toString() {
		return "Supermercado [gondola=" + gondola + ", lstCarrito=" + lstCarrito + "]";
	}
	public Producto traerProducto(int idProducto) {
		Producto producto=null;
		int i=0;
		while(i<this.gondola.size() && producto==null) {
			if(idProducto==this.gondola.get(i).getIdProducto()) {
				producto=this.gondola.get(i);
			}
			i++;
		}
		return producto;
	}
	public Producto traerProducto(String producto) {
		Producto encontrado=null;
		int i=0;
		while(i<this.gondola.size() && encontrado==null) {
			if(this.gondola.get(i).getProducto().equals(producto)) {
				encontrado=this.gondola.get(i);
			}
			i++;
		}
		return encontrado;
	}
	private int traerUltimoId() {
		int id=0;
		if(this.gondola.size()!=0) {
			id=this.gondola.get(this.gondola.size()-1).getIdProducto();
		}
		return id;
	}
	public boolean agregarProducto(String producto, float precio)throws Exception {
		Producto aux=this.traerProducto(producto);
		if(aux!=null) {
			throw new Exception("El producto: "+producto+" ya existe");
		}
		return this.gondola.add(new Producto(this.traerUltimoId()+1, producto, precio));
	}
	public boolean modificarProducto(int idProducto, String producto, double precio)throws Exception{
		Producto aux=this.traerProducto(idProducto);
		if(aux==null) {
			throw new Exception("El producto con Id: "+idProducto+" no existe");
		}
		aux.setProducto(producto);
		aux.setPrecio((float)precio);
		return true;
	}
	//Eliminar producto: traer producto por id, si no existe el objeto o existe en algún carrito levantar la
	//excepción, de lo contrario eliminar el objeto (remove).
	public boolean eliminarProducto(int idProducto)throws Exception{
		Producto aux=this.traerProducto(idProducto);
		if(aux==null) {
			throw new Exception("EL producto con Id: "+idProducto+" no existe");
		}
		Carrito carrito=this.traerCarrito(aux);
		if(carrito!=null) {
			throw new Exception("El producto: "+aux.getProducto()+" existe en algun carrito");
		}
		
		return this.gondola.remove(aux);
	}
	public Carrito traerCarrito(Producto producto) {
		Carrito carrito=null;
		int i=0;
		while(i<this.lstCarrito.size() && carrito==null) {
			if(this.lstCarrito.get(i).traerProducto(producto) !=null){
				carrito=this.lstCarrito.get(i);
			}
			i++;
		}
		return carrito;
	}
	public Carrito traerCarrito(int idCarrito) {
		Carrito carrito=null;
		int i=0;
		while(i<this.lstCarrito.size() && carrito==null) {
			if(this.lstCarrito.get(i).getIdCarrito()==idCarrito){
				carrito=this.lstCarrito.get(i);
			}
			i++;
		}
		return carrito;
	}
	public Carrito traerCarrito(LocalDate fecha, LocalTime hora) {
		Carrito carrito=null;
		int i=0;
		while(i<this.lstCarrito.size() && carrito==null) {
			if(this.lstCarrito.get(i).getFecha().equals(fecha) && this.lstCarrito.get(i).getHora().equals(hora)){
				carrito=this.lstCarrito.get(i);
			}
			i++;
		}
		return carrito;
	}
	//Si el carrito existe en la lista levantar una excepción.
	public boolean agregarCarrito(LocalDate fecha, LocalTime hora)throws Exception{
		Carrito objeto=this.traerCarrito(fecha, hora);
		if(objeto!=null) {
			throw new Exception("El carrito ya existe");
		}
		objeto=new Carrito(this.traerUltimoIDCarrito()+1, fecha, hora);
	return this.lstCarrito.add(objeto);
	}
	private int traerUltimoIDCarrito(){
		int id=0;
		if(this.lstCarrito.size()!=0) {
			id=this.lstCarrito.get(this.lstCarrito.size()-1).getIdCarrito();
		}
		return id;
	}
	//Si el carrito no existe en la lista levantar una excepción.
	public boolean eliminarCarrito(int idCarrito)throws Exception {
		Carrito carrito=this.traerCarrito(idCarrito);
		if(carrito==null) {
			throw new Exception("El Carrito con ID: "+idCarrito+" no existe");
		}
		return this.lstCarrito.remove(carrito);
	}
	
	
}
