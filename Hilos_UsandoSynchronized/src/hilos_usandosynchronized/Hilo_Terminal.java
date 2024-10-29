/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hilos_usandosynchronized;

/**
 *
 * @author guillermo
 */
public class Hilo_Terminal extends Thread{
     private ServidorWeb servidor;
    public Hilo_Terminal(ServidorWeb s) {
        this.servidor = s;
    }
    @Override
    public void run() {
        //método que incrementa la cuenta de accesos
        for (int i = 1; i <= 10; i++) //se simulan 10 accesos
        {
                servidor.incrementaCuenta();
                Thread.yield();

         }
        }
}
