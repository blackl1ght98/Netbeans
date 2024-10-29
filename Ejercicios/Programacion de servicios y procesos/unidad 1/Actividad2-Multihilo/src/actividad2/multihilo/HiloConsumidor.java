/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad2.multihilo;

import java.io.IOException;

/**
 *
 * @author guillermo
 */
public class HiloConsumidor extends Thread {
    private Recurso recurso;

    public HiloConsumidor(Recurso recurso, String nombre) {
        super(nombre);
        this.recurso = recurso;
    }
    @Override
    public void run() {
        while (!recurso.terminado) {
            try {
                recurso.consumir(getName());
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
