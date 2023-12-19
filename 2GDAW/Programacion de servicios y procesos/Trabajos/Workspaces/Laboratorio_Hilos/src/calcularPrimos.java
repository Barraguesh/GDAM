import java.math.BigInteger;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class calcularPrimos extends Thread {
    
    private BigInteger numero_calcular;

    public calcularPrimos(BigInteger numero) {
        this.numero_calcular = numero;
    }

    public void run() {
    	
    	Date inicio = new Date();

        System.out.println("Arrancando hilo");
        
        if ( numero_calcular.isProbablePrime(100)) {
        	Date fin = new Date();
            long diferencia = fin.getTime() - inicio.getTime();
            TimeUnit time = TimeUnit.SECONDS;
            long diferencia_segundos = time.convert(diferencia, TimeUnit.MILLISECONDS);
        	
        	System.out.println(Thread.currentThread().getName() + " Ha tardado: " + diferencia_segundos + " segundos. El número: " + numero_calcular + " NO es primo.");
        } else {
        	Date fin = new Date();
            long diferencia = fin.getTime() - inicio.getTime();
            TimeUnit time = TimeUnit.SECONDS;
            long diferencia_segundos = time.convert(diferencia, TimeUnit.MILLISECONDS);
        
            System.out.println(Thread.currentThread().getName() + " Ha tardado: " + diferencia_segundos + " segundos. El número: " + numero_calcular + " ES primo.");

		}            
        
        
    }
    
}
