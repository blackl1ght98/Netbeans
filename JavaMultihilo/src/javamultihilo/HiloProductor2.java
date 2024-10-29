/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javamultihilo;

import java.util.Random;

/**
 *
 * @author guillermo
 */
public class HiloProductor2 extends Thread {

    Recurso recurso = new Recurso();
    Random rnd = new Random();

    public HiloProductor2(Recurso recurso, String nombre) {
        super(nombre);
        this.recurso = recurso;
    }

    @Override
    public void run() {
        while (!recurso.terminado) {
            try {
                int valor = rnd.nextInt(11);
                recurso.producir(valor, getName());
                sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Se produjo un error al producir");
            }
        }
    }

}
