/**
 * Multithreading
 * 
 * Creador: Carlos Isaac Hernández Morfín - hi.izakc@gmail.com
 * Fecha: 22/03/18 
 */
import java.util.Random;

public class Consumer implements Runnable {

	private final static Random generator = new Random();
	private final Buffer sharedLocation;

	// Constructor.
	public Consumer(Buffer Buffer) {
		sharedLocation = Buffer;
	}

	public void run() {
		int sum = 0;
		for (int count = 1; count <= 10; count++) {
			try {
				Thread.sleep(generator.nextInt(3000));
				sum += sharedLocation.get();
				System.out.printf("\t\t\t%2d\n", sum);
			}
			catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		}

		System.out.printf("\n%s %d\n%s\n", "Consumer total de valores leidos", sum, "Terminando Consumer");
	}
}
