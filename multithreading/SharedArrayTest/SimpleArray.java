/**
 * Multithreading
 * 
 * Creador: Carlos Isaac Hernández Morfín - hi.izakc@gmail.com
 * Fecha: 22/03/18 
 */
import java.util.Arrays;
import java.util.Random;

public class SimpleArray {

	private final int[] array; 	// El array compartido.
	private int writeIndex = 0;	// Index del siguiente elemento a escribir.
	private final static Random generator = new Random();

	// Constructor.
	public SimpleArray(int size) {
		array = new int[size];
	}

	public synchronized void add(int value) {

		int position = writeIndex;

		try {
			// Ponemos el hilo a dormir.
			Thread.sleep(generator.nextInt(500));
		}
		catch (InterruptedException ex) {
			ex.printStackTrace();
		}

		array[position] = value;
		System.out.printf("%s escribe %2d al elemento %d.\n", Thread.currentThread().getName(), value, position);
		++writeIndex; // Incrementamos el index del elemento a escribir en la siguiente.
		System.out.printf("Siguiente index: %d\n", writeIndex);
	}

	public String toString() {
		return "\nContenido de SimpleArray:\n" + Arrays.toString(array);
	}
}
