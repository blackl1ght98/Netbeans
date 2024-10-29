/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sincronizacion_segmento_synchronized;

/**
 *
 * @author guillermo
 */
public class RecursoJardin {
   //Clase que simula las entradas y salidas al Jardín
   private int cuenta;//Para contar las entradas y salidas del jardin

    public RecursoJardin() {
        cuenta=100;//Inicialmente hay 100 personas en el jardin
    }
    //Metodo que incrementa en 1 la variable cuenta.
    
   public  void incrementaCuenta(){
       //Muestra el hilo que entra en el metodo
       System.out.println("hilo " + Thread.currentThread().getName()+ "------Entrada en el jardin");
       //incrementa en 1
       cuenta++;
       //cuenta cada acceso al jardin y muestra el numero de accesos.
       System.out.println(cuenta + " en jardin");
   }
   public  void decrementaCuenta(){
    //Muestra el hilo que entra en el metodo
       System.out.println("hilo " + Thread.currentThread().getName()+ " ------Sale del jardin");
       //decrementa en 1
       cuenta--;
       //cuenta cada acceso al jardin y muestra el numero de accesos.
       System.out.println(cuenta + " en jardin");
   }
}
