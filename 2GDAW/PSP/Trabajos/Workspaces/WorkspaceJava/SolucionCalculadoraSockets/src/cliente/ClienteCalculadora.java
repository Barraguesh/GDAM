package cliente;

import java.util.Scanner;

public class ClienteCalculadora {
	
	private static Scanner sc;
	
	public static void main(String[] args) {
		System.out.println("        APLICACION CALCULADORA CLIENTE         ");
		System.out.println("-----------------------------------------------");
		
		sc = new Scanner(System.in);
		ConexionAlServidor cas = new ConexionAlServidor();
		
		int opcion = 0;
		int resultado = 0;
		do {
			opcion = mostrarMenu();
		
			if(opcion >=1 && opcion <=4 ) {				
				System.out.println("Introduzca los números para operar:");
				int numero1 = sc.nextInt();
				int numero2 = sc.nextInt();
				
				resultado = cas.enviarDatos(numero1, numero2, opcion);
				System.out.println("El resultado es: " + resultado);
			}
		}while(opcion != 5);
		
		System.out.println("CALCULADORA CLIENTE: Fin del programa");
		sc.close();
	}

	private static int mostrarMenu() {
		System.out.println("ESCOJA UNA DE LAS SIGUIENTES OPERACIONES(1-5):");
		System.out.println("----------------------------------------------");
		System.out.println("1. Sumar");
		System.out.println("2. Restar");
		System.out.println("3. Multiplicar");
		System.out.println("4. Dividir");
		System.out.println("5. Salir");
		
		int opcion = sc.nextInt();
		sc.nextLine();
		
		return opcion;
	}	

}
