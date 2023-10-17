import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Introduce el primer numero: ");
		Integer primer_numero = input.nextInt();

		System.out.println("Introduce el segundo numero: ");
		Integer segundo_numero = input.nextInt();

		System.out.println("Introduce el tercer numero: ");
		Integer tercer_numero = input.nextInt();

		System.out.println("Los numeros introducidos son: " + primer_numero + " " + segundo_numero + " " + tercer_numero);
		
		calcularPrimos hilo1_calcular = new calcularPrimos(primer_numero);
		hilo1_calcular.setName("Hilo para el primer número.");

		calcularPrimos hilo2_calcular = new calcularPrimos(segundo_numero);
		hilo2_calcular.setName("Hilo para el segundo número.");

		calcularPrimos hilo3_calcular = new calcularPrimos(tercer_numero);
		hilo3_calcular.setName("Hilo para el tercer número.");
		
		hilo1_calcular.start();
		hilo2_calcular.start();
		hilo3_calcular.start();

	}
	
}
