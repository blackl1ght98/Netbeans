/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lanzadorthreads;

/**
 *
 * @author guillermo
 */
public class LanzadorThreads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Thread hilo1=new HiloThread("Hilo1");
       Thread hilo2= new HiloThread();
       /*
       Esta es una forma de iniciar un hilo usando la interfaz Runnable
        // Creación de un objeto de tipo Saludo (implementa Runnable)
        Saludo miRunnable = new Saludo();
        
        // Creación de un objeto Thread, pasando el objeto Runnable
        Thread hilo1 = new Thread(miRunnable);
       hilo1.start();
       */
       //Otra manera de iniciar un Runnable
       Thread hilo3=new Thread(new HiloRunnable());
       hilo1.start();
       hilo2.start();
       hilo3.start();
       
    }
    
}
