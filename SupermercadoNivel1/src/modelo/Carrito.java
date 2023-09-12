package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
	private int idCarrito;
	private LocalDate fecha;
	private LocalTime hora;
	private List<ItemCarrito> lstItem=new ArrayList<ItemCarrito>();
	public Carrito(int idCarrito, LocalDate fecha, LocalTime hora) {
		super();
		this.idCarrito = idCarrito;
		this.fecha = fecha;
		this.hora = hora;
	}
	public int getIdCarrito() {
		return idCarrito;
	}
	public void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
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
	public List<ItemCarrito> getLstItem() {
		return lstItem;
	}
	public void setLstItem(List<ItemCarrito> lstItem) {
		this.lstItem = lstItem;
	}

	public boolean equals(Carrito carrito) {
	
		return idCarrito == carrito.getIdCarrito();
	}
	private int ultimoId() {
		int id=0;
		if(this.lstItem.size()!=0) {
			id=this.lstItem.get(this.lstItem.size()-1).getIdItem();
		}
		return id;
	}
	public ItemCarrito traerProducto(Producto producto) {
		ItemCarrito encontrado=null;
		int i=0;
		while(i<this.lstItem.size() && encontrado==null) {
			if(producto.equals(this.lstItem.get(i).getProducto())) {
				encontrado=this.lstItem.get(i);
			}
			i++;
		}
		return encontrado;
	}
	//Cuando se agrega un producto al carrito si producto existe en algún item solo se incrementará la
	//cantidad de lo contrario se agregará el item.
	public boolean agregarItem(Producto producto, int cantidad) {
		ItemCarrito objeto=this.traerProducto(producto);
		if(objeto!=null) {
			objeto.setCantidad(objeto.getCantidad()+cantidad);
		}else {
			objeto= new ItemCarrito(this.ultimoId()+1, producto, cantidad);
			this.lstItem.add(objeto);
		}
		return true;
	}
	//En el caso de eliminar un producto del carrito si la cantidad es la misma se eliminará el item, si es
	//menor se decrecerá la cantidad y de lo contrario, si no existe el ítem que contenga el producto lanzará una excepción.
	public boolean eliminarItem (Producto producto, int cantidad) throws Exception{
		ItemCarrito objeto=this.traerProducto(producto);
		if(objeto==null) {
			throw new Exception("El producto: "+producto.getProducto()+" no existe en el carrito");
		}
		boolean retorno=false;
		if(cantidad== objeto.getCantidad()) {
			this.lstItem.remove(objeto);
			retorno=true;
		}else if(cantidad<objeto.getCantidad()) {
			objeto.setCantidad(objeto.getCantidad()-cantidad);
		}
		return retorno;
	}

	public float calcularTotal() {
		float total=0;
		for(int i=0;i<this.lstItem.size();i++) {
			total=total+this.lstItem.get(i).calcularSubTotal();
		}
		return total;
	}
	@Override
	public String toString() {
		return "Carrito [idCarrito=" + idCarrito + ", fecha=" + fecha + ", hora=" + hora + ", lstItem=" + lstItem + "]";
	}
	
}
