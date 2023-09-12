package modelo;

public class Supermercado {
	private AdmCarrito admCarrito;
	private AdmCliente admCliente;
	private AdmProducto admProducto;
	public Supermercado() {
		super();
		this.admCarrito=new AdmCarrito();
		this.admCliente=new AdmCliente();
		this.admProducto=new AdmProducto();
	}
	public AdmCarrito getAdmCarrito() {
		return admCarrito;
	}
	public void setAdmCarrito(AdmCarrito admCarrito) {
		this.admCarrito = admCarrito;
	}
	public AdmCliente getAdmCliente() {
		return admCliente;
	}
	public void setAdmCliente(AdmCliente admCliente) {
		this.admCliente = admCliente;
	}
	public AdmProducto getAdmProducto() {
		return admProducto;
	}
	public void setAdmProducto(AdmProducto admProducto) {
		this.admProducto = admProducto;
	}
	@Override
	public String toString() {
		return "Supermercado [admCarrito=" + admCarrito + ", admCliente=" + admCliente + ", admProducto=" + admProducto
				+ "]";
	}
	
}
