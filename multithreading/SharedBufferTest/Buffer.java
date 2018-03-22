/**
 * Multithreading
 * 
 * Creador: Carlos Isaac Hernández Morfín - hi.izakc@gmail.com
 * Fecha: 22/03/18 
 */
public interface Buffer {

	// Colocamos el valor entero en el buffer.
	public void set(int value) throws InterruptedException;
	// Retorna el valor entero del buffer.
	public int get() throws InterruptedException;
}
