public class calcularPrimos extends Thread {
    
    private Integer numero_calcular;

    public calcularPrimos(Integer numero) {
        this.numero_calcular = numero;
    }

    public void run() {

        System.out.println("Arrancando hilo");

        for (int i = 2; i < numero_calcular; i++) {
            if (numero_calcular % i == 0) {
            	System.out.println("El número: " + numero_calcular + " NO es primo.");
            	return;
            }                
        }
    
        System.out.println(Thread.currentThread().getName() + " El número: " + numero_calcular + " ES primo.");

    }
    
}
