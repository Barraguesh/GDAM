package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorCalculadora {
	
	public static final int PUERTO = 2017;
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("      APLICACIÓN CALCULADORA DE SERVIDOR      ");
		System.out.println("----------------------------------------------");
		
		InputStreamReader entrada = null;
		PrintStream salida = null;
		
		Socket socketAlCliente = null;
		
		InetSocketAddress direccion = new InetSocketAddress(PUERTO);
		
		Calculadora cal = new Calculadora();
		
		try (ServerSocket serverSocket = new ServerSocket()){			

			serverSocket.bind(direccion);

			while(true){		
				socketAlCliente = serverSocket.accept();
				
				entrada = new InputStreamReader(socketAlCliente.getInputStream());
				BufferedReader bf = new BufferedReader(entrada);
									
				String stringRecibido = bf.readLine();//3-4

				System.out.println("SERVIDOR: Me ha llegado del cliente: " + stringRecibido);

				String[] operadores = stringRecibido.split("-");
				int n1 = Integer.parseInt(operadores[0]);
				int n2 = Integer.parseInt(operadores[1]);
				int op = Integer.parseInt(operadores[2]);//El código de operación que me envia
				
				int resultado = 0;
				
				if(op == 1) {
					resultado = cal.sumar(n1, n2);
				}else if(op == 2) {
					resultado = cal.restar(n1, n2);
				}else if(op == 3) {
					resultado = cal.multiplicar(n1, n2);
				}else if(op == 4) {
					resultado = cal.dividir(n1, n2);
				}
						
				salida = new PrintStream(socketAlCliente.getOutputStream());
				salida.println(resultado);	
				
				socketAlCliente.close();
			}
		} catch (IOException e) {
			System.err.println("SERVIDOR: Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("SERVIDOR: Error -> " + e);
			e.printStackTrace();
		}
	}//FIN DEL PROGRAMA
}
