/**
 * Multithreading
 * 
 * Creador: Carlos Isaac Hernández Morfín - hi.izakc@gmail.com
 * Fecha: 22/03/18 
 */
import java.util.Random;

public class PrintTask implements Runnable {

	private final int sleepTime;	// Tiempo random de sueño por hilo.
	private final String taskName;	// Nombre del hilo.
	private final static Random generator = new Random();

	public PrintTask(String name) {
		taskName = name;
		sleepTime = generator.nextInt(5000); // Milisegundo.
	}

	public void run() {

		try { // Ponemos a dormir el hilo
			System.out.printf("%s a dormir por %d milisegundos.\n", taskName, sleepTime);
			Thread.sleep(sleepTime); // Ponemos el hilo a dormir.
		}
		catch (InterruptedException exception) {
			System.out.printf("%s %s\n", taskName, "terminado prematuramente");
		}

		System.out.printf("%s despierta\n", taskName);
	}
}
