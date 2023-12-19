package servidor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	
	public static void main(String[] args) throws InterruptedException {
		//Creamos los inputs y la salida
		InputStreamReader entrada = null;
		PrintStream salida = null;
		
		//Creamos el socket
		Socket socketCliente = null;
	
		//Creamos el puerto
		InetSocketAddress direccion = new InetSocketAddress(4545);
		
		try (ServerSocket serverSocket = new ServerSocket()) {
			
			serverSocket.bind(direccion);
			
			int peticion = 0;
			
			while (true) {
				//Espera aqui hasta que un cliente envie la peticion
				socketCliente = serverSocket.accept();				
				
				//Leemos lo enviado por el cliente
				entrada = new InputStreamReader(socketCliente.getInputStream());
				BufferedReader bf = new BufferedReader(entrada);
				String stringRecibido = bf.readLine();
				
				String[] recibido = stringRecibido.split(",");
				
				switch (recibido[0]) {
					case"sumar": {
						salida = new PrintStream(socketCliente.getOutputStream());
						salida.println(Integer.parseInt(recibido[1]) + Integer.parseInt(recibido[2]));
						break;
					}
					
					case"restar": {
						salida = new PrintStream(socketCliente.getOutputStream());
						salida.println(Integer.parseInt(recibido[1]) - Integer.parseInt(recibido[2]));
						break;
					}
					
					case"multiplicar": {
						salida = new PrintStream(socketCliente.getOutputStream());
						salida.println(Integer.parseInt(recibido[1]) * Integer.parseInt(recibido[2]));
						break;
					}
					
					case"dividir": {
						salida = new PrintStream(socketCliente.getOutputStream());
						salida.println(Integer.parseInt(recibido[1]) / Integer.parseInt(recibido[2]));
						break;
					}
					
					default:
						throw new IllegalArgumentException("Unexpected value: " + Integer.parseInt(stringRecibido));
				}
				
				
			}
			
		} catch (Exception e) {
			
		}
	}
	
}
