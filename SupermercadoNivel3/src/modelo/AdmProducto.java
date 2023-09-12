package modelo;

import java.util.ArrayList;
import java.util.List;

public class AdmProducto {
	private List<Producto> lstProducto;

	public AdmProducto() {
		super();
		this.lstProducto =new ArrayList<Producto>();
	}

	public List<Producto> getLstProducto() {
		return lstProducto;
	}

	public void setLstProducto(List<Producto> lstProducto) {
		this.lstProducto = lstProducto;
	}

	@Override
	public String toString() {
		return "AdmProducto [lstProducto=" + lstProducto + "]";
	}
	//+ agregarProducto(String producto, float precio) : boolean
	//2) + traerProducto(int idProducto) : Producto
	//3) + eliminarProducto(int idProducto) : boolean
	 private Producto traerProducto(int idProducto) {
		 Producto producto=null;
		 int i=0;
		 while(i<this.lstProducto.size() && producto==null) {
			 if(idProducto==this.lstProducto.get(i).getIdProducto()) {
				 producto=this.lstProducto.get(i);
			 }
			 i++;
		 }
		 return producto;
	 }
	 private Producto traerProducto(String producto) {
		 Producto encontrado=null;
		 int i=0;
		 while(i<this.lstProducto.size() && encontrado==null) {
			 if(this.lstProducto.get(i).getProducto().equals(producto)) {
				 encontrado=this.lstProducto.get(i);
			 }
			 i++;
		 }
		 return encontrado;
	 }
	 private int traerUltimoIdProducto() {
		 int id=0;
		 if(this.lstProducto.size()!=0) {
			 id=this.lstProducto.get(this.lstProducto.size()-1).getIdProducto();
		 }
		 return id;
	 }
	 public boolean agregarProducto(String producto, float precio) throws Exception{
		 Producto objeto=this.traerProducto(producto);
		 if(objeto!=null) {
			throw new Exception("El Producto: "+producto+" ya existe"); 
		 }
		 objeto= new Producto(this.traerUltimoIdProducto()+1, producto, precio);
		 return this.lstProducto.add(objeto);
	 }
}
