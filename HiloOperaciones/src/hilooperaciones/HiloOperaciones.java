/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hilooperaciones;

/**
 *
 * @author guillermo
 */
public class HiloOperaciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Operaciones suma = new Operaciones(1);
        Operaciones resta = new Operaciones(2);
        Operaciones mult = new Operaciones(3);
        Thread hilo1 = new Thread(suma);
        
          Thread hilo2 = new Thread(resta);
           Thread hilo3 = new Thread(mult);
           hilo1.start();
           hilo2.start();
           hilo3.start();
    }
    
}
