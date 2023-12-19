package cliente;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	
	private static boolean ejecutar = true;

	public static void main(String[] args) {		
		try (Scanner scanner = new Scanner(System.in)) {			
			//Ejecutamos las operaciones
			while (ejecutar) {
				System.out.println("Introduce lo que quieras realizar: \n 1.Sumar \n 2.Restar \n 3.Multiplicar \n 4.Dividir \n 5.Salir" );
				String opcion = scanner.nextLine();
				String numeros = null;
				
				switch (Integer.parseInt(opcion)) {
					case 1: {
						System.out.println("Has elegido sumar, indica los dos numeros separados por comas.");
						
						numeros = scanner.nextLine();
						opcion = "sumar";
						break;
					}
					
					case 2: {
						System.out.println("Has elegido restar, indica los dos numeros separados por comas.");
						
						numeros = scanner.nextLine();
						opcion = "restar";
						break;
					}
					
					case 3: {
						System.out.println("Has elegido multiplicar, indica los dos numeros separados por comas.");
						
						numeros = scanner.nextLine();
						opcion = "multiplicar";
						break;
					}
					
					case 4: {
						System.out.println("Has elegido dividir, indica los dos numeros separados por comas.");
						
						numeros = scanner.nextLine();
						opcion = "dividir";
						break;
					}
					
					case 5: {
						System.out.println("Has elegido salir. Adios!");
						
						ejecutar = false;
						
					}
				}
				
				//Nos conectamos al servidor
				Socket socketServidor = new Socket();
				InetSocketAddress direccionServidor = new InetSocketAddress("127.0.0.1", 4545);
				socketServidor.connect(direccionServidor);
				
				PrintStream salida = new PrintStream(socketServidor.getOutputStream());
				
				//Mandamos la informacion al servidor
				salida.println(opcion + "," + numeros);
				
				//Recogemos la respuesta del servidor
				InputStreamReader entrada = new InputStreamReader(socketServidor.getInputStream());
				BufferedReader bf = new BufferedReader(entrada);
				System.out.println(bf.readLine());				
			}		
		} catch (Exception e ) {
			System.out.println("Error: " + e);
		}
	}
	
}
