/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad2.multihilo;

/**
 *
 * @author guillermo
 */
public class Actividad2Multihilo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Recurso recurso = new Recurso();
        Thread productor1 = new HiloProductor_1(recurso, "Producto 1");
        Thread productor2 = new HiloProductor_2(recurso, "Producto 2");
        Thread consumidor = new HiloConsumidor(recurso, "Consumidor");

        productor1.start();
        productor2.start();
        consumidor.start();

        // Esperar a que los hilos terminen
        productor1.join();
        productor2.join();
        consumidor.join();

        System.out.println("Resultado final: " + recurso.getSuma());
    }
    
}
