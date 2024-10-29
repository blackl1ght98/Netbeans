/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javamultihilo;

import static java.lang.Thread.sleep;
import java.util.Random;

/**
 *
 * @author guillermo
 */
public class HiloConsumidor extends Thread {
     Recurso recurso = new Recurso();
  

    public HiloConsumidor(Recurso recurso, String nombre) {
        super(nombre);
        this.recurso = recurso;
    }

    @Override
    public void run() {
        while (!recurso.terminado) {
            try {
               
                recurso.consumir( getName());
                sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Se produjo un error al producir");
            }
        }
    }
}
