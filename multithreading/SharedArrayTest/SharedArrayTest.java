/**
 * Multithreading
 * 
 * Creador: Carlos Isaac Hernández Morfín - hi.izakc@gmail.com
 * Fecha: 22/03/18 
 */
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class SharedArrayTest {
	public static void main(String[] args) {
		
		// Instanciamos el objeto compartido.
		SimpleArray sharedSimpleArray = new SimpleArray(6);

		// Creamos 2 tareas a escribir en el SimpleArray compartido.
		ArrayWriter witer1 = new ArrayWriter(1, sharedSimpleArray);
		ArrayWriter witer2 = new ArrayWriter(11, sharedSimpleArray);

		// Ejecutamos las tareas con el ExecutorService.
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.execute(witer1);
		executor.execute(witer2);
		executor.shutdown();

		try {
			// Esperamos 1 minuto a que el par de witers teminen de ejecutarce.
			boolean taskEnded = executor.awaitTermination(1, TimeUnit.MINUTES);

			if(taskEnded)
				System.out.println(sharedSimpleArray); // Imprimimos el contenido.
			else
				System.out.println("Se produjo un time out esperando a que las tareas finalizaran.");
		}
		catch(InterruptedException ex) {
			System.out.println("Se ha interrumpido mientras esperaba que las tareas finalizaran." );
		}
	}
}
