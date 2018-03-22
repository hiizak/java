/**
 * Multithreading
 * 
 * Creador: Carlos Isaac Hernández Morfín - hi.izakc@gmail.com
 * Fecha: 22/03/18 
 */
 public class ArrayWriter implements Runnable {

 	private final SimpleArray sharedSimpleArray;
 	private final int startValue;

 	// Constructor.
 	public ArrayWriter(int value, SimpleArray array) {
 		startValue = value;
 		sharedSimpleArray = array;
 	}

 	public void run() {
 		for (int i = startValue; i < startValue + 3; i++) {
 			sharedSimpleArray.add(i); // Agrega el elemento al array compartido.
 		}
 	}
 }
