package test;

import java.time.LocalDate;
import java.time.LocalTime;

import modelo.Supermercado;

public class TestSupermercado1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Supermercado supermercado=new Supermercado();
		// PRODUCTOS
		try {
			System.out.println(supermercado.agregarProducto("Arroz Gallo", 200));//1
			System.out.println(supermercado.agregarProducto("Manteca Cream", 300));//2
			System.out.println(supermercado.agregarProducto("Dulce de leche Sancor", 700));//3
			System.out.println(supermercado.agregarProducto("Milanesa", 1200));//4
			System.out.println(supermercado.agregarProducto("Leche La Chelita", 400));//5
			System.out.println(supermercado.agregarProducto("Arroz Gallo", 300));//6
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(supermercado.modificarProducto(4,"Milanesa de Pollo", 1500));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(supermercado.eliminarProducto(5));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		System.out.println(supermercado.getGondola());
		//CLIENTES
		try {
			System.out.println(supermercado.agregarCliente("Raul",412515,"Rosas 123")+" sdfasfd");
			System.out.println(supermercado.agregarCliente("Roman Riquelme", 541251,"Ruizzz 415")+"gfasdg");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		System.out.println("CLIENTES: ");
		System.out.println(supermercado.getLstCliente());
		
		
		//CARRITOS
		try {
			System.out.println(supermercado.agregarCarrito(LocalDate.of(2023, 9, 10),LocalTime.of(10, 40),supermercado.getLstCliente().get(0)));
			System.out.println(supermercado.agregarCarrito(LocalDate.of(2023, 5, 10),LocalTime.of(20, 00),supermercado.getLstCliente().get(0)));
			System.out.println(supermercado.agregarCarrito(LocalDate.of(2023, 10, 20),LocalTime.of(17,30),supermercado.getLstCliente().get(1)));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(supermercado.eliminarCarrito(3));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		//AGREGAR ITEMS
		try {
			//CARRITO 1
			System.out.println(supermercado.getLstCarrito().get(0).agregarItem(supermercado.traerProducto(1), 3));
			System.out.println(supermercado.getLstCarrito().get(0).agregarItem(supermercado.traerProducto(3), 1));
			
			//CARRITO 2
			System.out.println(supermercado.getLstCarrito().get(1).agregarItem(supermercado.traerProducto(1), 2));
			System.out.println(supermercado.getLstCarrito().get(1).agregarItem(supermercado.traerProducto(2), 2));
			System.out.println(supermercado.getLstCarrito().get(1).agregarItem(supermercado.traerProducto(4), 5));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		System.out.println(supermercado.getLstCarrito());
		//ELIMINAR ITEMS
		try {
			System.out.println(supermercado.getLstCarrito().get(1).eliminarItem(supermercado.traerProducto(1), 2));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		System.out.println(supermercado.getLstCarrito());
		System.out.println("SUBTOTAL DE ITEM DE CARRITO 1");
		//CARRITO 1 ITEM 1
		System.out.println(supermercado.getLstCarrito().get(0).getLstItem().get(0).calcularSubTotal());
		//CARRITO 1 ITEM 2
		System.out.println(supermercado.getLstCarrito().get(0).getLstItem().get(1).calcularSubTotal());
		//TOTAL DE CARRITO 1
		System.out.println(supermercado.getLstCarrito().get(0).calcularTotal());
	}

}
