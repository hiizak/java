/**
 * Multithreading
 * 
 * Creador: Carlos Isaac Hernández Morfín - hi.izakc@gmail.com
 * Fecha: 22/03/18 
 */
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class SharedBufferTest {
	public static void main(String[] args) {
		ExecutorService application = Executors.newCachedThreadPool();

		// Crearmos UnsynchronizedBuffer para almacenar enteros.
		Buffer sharedLocation = new UnsynchronizedBuffer();

		System.out.println("Acción\t\tValor\tSum de Producer\tSum de consumer");
		System.out.println("------\t\t-----\t---------------\t---------------");

		application.execute(new Producer(sharedLocation));
		application.execute(new Consumer(sharedLocation));

		application.shutdown();
	}
}
