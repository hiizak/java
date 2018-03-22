/**
 * Multithreading
 * 
 * Creador: Carlos Isaac Hernández Morfín - hi.izakc@gmail.com
 * Fecha: 22/03/18 
 */
public class UnsynchronizedBuffer implements Buffer {

	private int buffer = 1; // Compartido por Producer y Concumer hilos.

	public void set(int value) throws InterruptedException {
		System.out.printf("Producer escribe\t%2d", value);
		buffer = value;
	}

	public int get() throws InterruptedException {
		System.out.printf("Consumer lee\t%2d", buffer);
		return buffer;
	}
}
