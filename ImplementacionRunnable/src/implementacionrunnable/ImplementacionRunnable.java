/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package implementacionrunnable;

/**
 *
 * @author guillermo
 */
public class ImplementacionRunnable {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
/*
1. Instanciamos la clase que hemos creado, que en este caso es `Saludo`. 
   Esta clase implementa la interfaz `Runnable`, por lo que el objeto 
   que creamos puede considerarse un `Runnable`.

2. La instancia que hemos creado (`miRunnable`) es de tipo `Runnable` porque 
   la clase `Saludo` implementa la interfaz `Runnable`. Esto significa que 
   tiene el método `run()` que será ejecutado en un hilo.

3. Para manejar la ejecución del hilo, necesitamos crear un objeto de la clase 
   `Thread`. La clase `Thread` tiene varios constructores, y uno de esos 
   constructores acepta un objeto de tipo `Runnable`. Entonces, pasamos 
   `miRunnable` como argumento al constructor de `Thread`, de esta forma:
   `Thread hilo1 = new Thread(miRunnable);`.

4. Finalmente, para iniciar el hilo, llamamos al método `start()` en el 
   objeto `hilo1`, lo que ejecutará el método `run()` del objeto `miRunnable`.
*/
        // Creación de un objeto de tipo Saludo (implementa Runnable)
        Saludo miRunnable = new Saludo();
        
        // Creación de un objeto Thread, pasando el objeto Runnable
        Thread hilo1 = new Thread(miRunnable);
        
        System.out.println("Creando un nuevo hilo desde el hilo principal (main).");
        
        // Iniciamos el hilo llamando al método start()
        hilo1.start();
    }

    
}
