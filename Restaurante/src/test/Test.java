package test;

import java.time.LocalDate;




import modelo.SistemaRestaurante;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SistemaRestaurante sistema=new SistemaRestaurante();
		
		
		//AGREGACION DE LOS CLIENTES
		//1
		try {
			System.out.println(sistema.agregarCliente("Rodrigo","Sanchez", 32694053, "+541179456274"));
			System.out.println(sistema.agregarCliente("Adriana","Diaz", 31953256,"+541109462742"));
			System.out.println(sistema.agregarCliente("Marcos","Garcia", 34096528,"+541188345186"));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		//2
				try {
					System.out.println(sistema.agregarMesa(1, 2));
					System.out.println(sistema.agregarMesa(2, 2));
					System.out.println(sistema.agregarMesa(3, 4));
					System.out.println(sistema.agregarMesa(4, 6));
					System.out.println(sistema.agregarMesa(5, 4));
					System.out.println(sistema.agregarMesa(6, 2));

					
					
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
	//3
		try {
	//agregarReserva(Cliente cliente, LocalDate fechaReserva, Mesa mesa, int cantComensales)
			System.out.println(sistema.agregarReserva(sistema.traerCliente(32694053),LocalDate.of(2023, 8, 15),sistema.traerMesa(1), 2));
			System.out.println(sistema.agregarReserva(sistema.traerCliente(31953256),LocalDate.of(2023, 8, 15),sistema.traerMesa(4), 4));
			System.out.println(sistema.agregarReserva(sistema.traerCliente(34096528),LocalDate.of(2023, 8, 25) ,sistema.traerMesa(5), 4));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		//4
	
	
		System.out.println(sistema.traerReservasPorFecha(LocalDate.of(2023, 8, 15),LocalDate.of(2023, 8, 20)));
		//5
		
		//6
		try {
			System.out.println(sistema.agregarCliente("Adriana","Diaz", 31953256,"+541109462742"));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		//7
		try {
			System.out.println(sistema.agregarMesa(3, 4));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		//8
		try {
		//agregarReserva(Cliente cliente, LocalDate fechaReserva, Mesa mesa, int cantComensales)
			System.out.println(sistema.agregarReserva(sistema.traerCliente(32694053),LocalDate.of(2023, 8, 25),sistema.traerMesa(5), 4));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		//9
		try {
			System.out.println(sistema.agregarReserva(sistema.traerCliente(31953256),LocalDate.of(2023, 8, 17),sistema.traerMesa(6), 2));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
