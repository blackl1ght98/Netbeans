/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad2.multihilo;

import java.util.Random;

/**
 *
 * @author guillermo
 */
public class HiloProductor_2 extends Thread {
    private Recurso recurso;
    private Random random = new Random();

    public HiloProductor_2(Recurso recurso, String nombre) {
        super(nombre);
        this.recurso = recurso;
    }

    public void run() {
        while (!recurso.terminado) {
            try {
                //Con esta linea generas un valor aleatorio de 0 a 10
                int valor = random.nextInt(11);
                //getName()-->obtiene el nombre del hilo actual
                recurso.producir(valor, getName());
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}