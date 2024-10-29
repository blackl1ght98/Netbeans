/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hiloextendido;

/**
 *
 * @author guillermo
 */
public class HiloExtendido {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Saludo hilo1 =new Saludo();
      System.out.println("Creando un nuevo hilo desde el hilo principal (main)");
      hilo1.start();
    }
    
}
