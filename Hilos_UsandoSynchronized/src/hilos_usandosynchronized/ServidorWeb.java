/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hilos_usandosynchronized;

/**
 *
 * @author guillermo
 */
public class ServidorWeb {
    private int cuenta;

    public ServidorWeb() {
        cuenta=0;
    }
    public synchronized void incrementaCuenta(){
    System.out.println("Hilo "+ Thread.currentThread().getName()+ " ----Entrada en metodo");
    cuenta++;
    System.out.println(cuenta+ " accesos");
    }
     public synchronized void decrementaCuenta(){
    System.out.println("Hilo "+ Thread.currentThread().getName()+ " ----Salida en metodo");
    cuenta--;
    System.out.println(cuenta+ " accesos");
    }
}
