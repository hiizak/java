/**
 * Multithreading
 * 
 * Creador: Carlos Isaac Hernández Morfín - hi.izakc@gmail.com
 * Fecha: 22/03/18 
 */
import java.util.Random;

public class Producer implements Runnable {

	private final static Random generator = new Random();
	private final Buffer sharedLocation; // Referencia a objeto compartido.

	// Constructor.
	public Producer(Buffer shared) {
		sharedLocation = shared;
	}

	public void run(){
		int sum = 0;

		for(int count = 1; count <= 10; count++) {
			try{
				Thread.sleep(generator.nextInt(3000)); // Duerme tiempo random entre 0 - 3000 milsegundos.
				sharedLocation.set(count);
				sum += count;
				System.out.printf("\t%2d\n", sum);
			}
			catch (InterruptedException ex){
				ex.printStackTrace();
			}
		}

		System.out.println("Producer terminó de producir\nTerminando Producer");
	}
}
