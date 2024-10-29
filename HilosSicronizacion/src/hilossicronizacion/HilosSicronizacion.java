/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hilossicronizacion;

/**
 *
 * @author guillermo
 */
public class HilosSicronizacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Al no controlar la condicion de carrera entre el hilo de Entrada_Jardin y Salida_Jardin los resultado son incorrectos
        //la condicion de carrera se da cuando 2 o mas hilos van a por un mismo recurso sin un control
       RecursoJardin jardin = new RecursoJardin();
       for(int i=1;i<=10;i++){
       (new Entrada_Jardin("Entra "+ i,jardin)).start();
       }//entrada de 10 hilos al jardin
        for(int i=1;i<=15;i++){
       (new Sale_Jardin("Sale "+ i,jardin)).start();
       }//salida de 15 hilos al jardin
    }
    
}
