/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multihilo;

/**
 *
 * @author guillermo
 */
public class Pingpong {
    
    public static class CD_PingThread extends Thread {
        private volatile boolean running = true;
        
        public void run() {
            int count = 0; // Contador para limitar las impresiones
            while (running && count < 10) { // Terminar después de 10 impresiones
                System.out.print("ping ");
                count++;
                try {
                    Thread.sleep(500); // Espera 500 milisegundos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        
        public void stopThread() {
            running = false; // Detener el hilo de manera segura
        }
    }

    public static class CD_PongThread extends Thread {
        private volatile boolean running = true;
        
        public void run() {
            int count = 0; // Contador para limitar las impresiones
            while (running && count < 10) { // Terminar después de 10 impresiones
                System.out.print("PONG ");
                count++;
                try {
                    Thread.sleep(500); // Espera 500 milisegundos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        
        public void stopThread() {
            running = false; // Detener el hilo de manera segura
        }
    }}
