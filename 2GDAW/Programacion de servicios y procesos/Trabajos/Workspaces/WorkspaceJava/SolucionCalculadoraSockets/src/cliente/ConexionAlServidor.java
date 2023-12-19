package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConexionAlServidor {

	public static final int PUERTO = 2017;
	public static final String IP_SERVER = "localhost";
	
	/**
	 * Método que se conecta a un servidor en "localhost" por el puerto 2027
	 * Envia dos operandos y un código de operación para que sea procesado
	 * por el servidor
	 * @param op1 representa el primer operando
	 * @param op2 representa el segundo operando
	 * @param codigoOperacion, 1 en caso de SUMA, 2 en caso de RESTA, 3 en caso de
	 * MULTIPLICACION y 4 en caso de DIVISION
	 * @return el resultado de la operación
	 */
	public int enviarDatos(int op1, int op2, int codigoOperacion){

		InetSocketAddress direccionServidor = new InetSocketAddress(IP_SERVER, PUERTO);
		
		int iResultado = 0;
		
		try (Socket socketAlServidor = new Socket()){
					
			String mensaje = op1 + "-" + op2 + "-" + codigoOperacion;
			
			socketAlServidor.connect(direccionServidor);	
			
			PrintStream salida = new PrintStream(socketAlServidor.getOutputStream());
			salida.println(mensaje);
			
			InputStreamReader entrada = new InputStreamReader(socketAlServidor.getInputStream());
			BufferedReader bf = new BufferedReader(entrada);
			
			String sResultado = bf.readLine();
			iResultado = Integer.parseInt(sResultado);
			
		} catch (UnknownHostException e) {
			System.err.println("CLIENTE: No encuentro el servidor en la dirección" + IP_SERVER);
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("CLIENTE: Error de entrada/salida");
			e.printStackTrace();
		}catch (Exception e) {
			System.err.println("CLIENTE: Error -> " + e);
			e.printStackTrace();
		}
		
		return iResultado;
	}
}
