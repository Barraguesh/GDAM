import java.util.Date;
import java.util.concurrent.TimeUnit;

public class calcularPrimos extends Thread {
    
    private double numero_calcular;

    public calcularPrimos(double numero) {
        this.numero_calcular = numero;
    }

    public void run() {
    	
    	Date inicio = new Date();

        System.out.println("Arrancando hilo");
        
        for (int i = 2; i < numero_calcular; i++) {       	
            if (numero_calcular % i == 0) {
            	Date fin = new Date();
                long diferencia = fin.getTime() - inicio.getTime();
                TimeUnit time = TimeUnit.SECONDS;
                long diferencia_segundos = time.convert(diferencia, TimeUnit.MILLISECONDS);
            	
            	System.out.println(Thread.currentThread().getName() + " Ha tardado: " + diferencia_segundos + " segundos. El número: " + numero_calcular + " NO es primo.");
            	return;
            }                
        }
        
        Date fin = new Date();
        long diferencia = fin.getTime() - inicio.getTime();
        TimeUnit time = TimeUnit.SECONDS;
        long diferencia_segundos = time.convert(diferencia, TimeUnit.MILLISECONDS);
    
        System.out.println(Thread.currentThread().getName() + " Ha tardado: " + diferencia_segundos + " segundos. El número: " + numero_calcular + " ES primo.");

    }
    
}
