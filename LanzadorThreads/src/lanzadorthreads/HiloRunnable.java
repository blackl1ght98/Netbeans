/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lanzadorthreads;

/**
 *
 * @author guillermo
 */
public class HiloRunnable implements Runnable {

    @Override
    public void run() {
      for (int i = 1; i <= 20; i++) {
            System.out.println("Hilo Runnable");
        }  
    }
    
}
