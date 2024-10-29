/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hilos_usandosynchronized;

/**
 *
 * @author guillermo
 */
public class Hilos_UsandoSynchronized {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      ServidorWeb servidor = new ServidorWeb();
      Hilo_Terminal hterminal1=new Hilo_Terminal(servidor);
      Hilo_Terminal hterminal2=new Hilo_Terminal(servidor);
      Hilo_Terminal hterminal3=new Hilo_Terminal(servidor);
      Hilo_Terminal hterminal4=new Hilo_Terminal(servidor);
      
      hterminal1.start();
      hterminal2.start();
      hterminal3.start();
      hterminal4.start();
    }
    
}
