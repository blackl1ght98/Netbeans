/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multihilos;

import java.util.Random;

/**
 *
 * @author guillermo
 */
public class HiloProducto2 extends Thread {

    private Recurso recurso;
//Para generar valores aleatorios
    private Random random = new Random();

    public HiloProducto2(Recurso recurso, String nombre) {
        super(nombre);
        this.recurso=recurso;
    }

    @Override
    public void run() {
        while (!recurso.terminado) {
            try {
                int valor = random.nextInt(11);
                recurso.producir(valor, getName());
                Thread.sleep(150);
            } catch (InterruptedException e) {
                System.err.println("Se produjo un error al producir");
            }
        }
    }

}
