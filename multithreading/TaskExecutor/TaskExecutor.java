/**
 * Multithreading
 * 
 * Creador: Carlos Isaac Hernández Morfín - hi.izakc@gmail.com
 * Fecha: 22/03/18 
 */
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class TaskExecutor {

 	public static void main(String[] args) {

		// Creamos y nombramos cada Runnable.
 		PrintTask task1 = new PrintTask("task1");
 		PrintTask task2 = new PrintTask("task2");
 		PrintTask task3 = new PrintTask("task3");

 		System.out.println("Iniciando Executor");

 		// Creamos un ExecutorService para manejar los hilos.
 		ExecutorService threadExecutor = Executors.newCachedThreadPool();

 		// Iniciamos los hilos.
 		threadExecutor.execute(task1);
 		threadExecutor.execute(task2);
 		threadExecutor.execute(task3); 		

 		// Finalizamos el ExecutorService cuando las tareas esten completas.
 		threadExecutor.shutdown();

 		System.out.println("Tareas iniciadas, main finalizado.\n");
 	}
 }
 