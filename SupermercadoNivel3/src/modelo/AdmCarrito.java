package modelo;

import java.util.ArrayList;
import java.util.List;

public class AdmCarrito {
	private List<Carrito> lstCarrito;

	public AdmCarrito() {
		super();
		this.lstCarrito = new ArrayList<Carrito>();
	}

	public List<Carrito> getLstCarrito() {
		return lstCarrito;
	}

	public void setLstCarrito(List<Carrito> lstCarrito) {
		this.lstCarrito = lstCarrito;
	}

	@Override
	public String toString() {
		return "AdmCarrito [lstCarrito=" + lstCarrito + "]";
	}
	
}
