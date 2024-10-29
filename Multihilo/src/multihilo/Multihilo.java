/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package multihilo;

import multihilo.Pingpong.CD_PingThread;
import multihilo.Pingpong.CD_PongThread;

/**
 *
 * @author guillermo
 */
public class Multihilo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         CD_PingThread pingThread = new CD_PingThread();
        CD_PongThread pongThread = new CD_PongThread();
        
        pingThread.start(); // Inicia el hilo de ping
        pongThread.start(); // Inicia el hilo de pong
        
        try {
            pingThread.join(); // Espera a que termine el hilo de ping
            pongThread.join(); // Espera a que termine el hilo de pong
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nHilos terminados.");
    }
    
}
