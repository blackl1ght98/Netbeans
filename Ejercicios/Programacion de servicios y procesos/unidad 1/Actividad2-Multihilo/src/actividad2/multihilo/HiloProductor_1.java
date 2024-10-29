/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad2.multihilo;

import java.io.IOException;
import java.util.Random;

/**
 *
 * @author guillermo
 */
public class HiloProductor_1 extends Thread {

    private Recurso recurso;
    private Random random = new Random();

    public HiloProductor_1(Recurso recurso, String nombre) {
        super(nombre);
        this.recurso = recurso;
    }
   @Override
   public void run() {
        while (!recurso.terminado) {
            try {
                int valor = random.nextInt(11);
                recurso.producir(valor, getName());
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
