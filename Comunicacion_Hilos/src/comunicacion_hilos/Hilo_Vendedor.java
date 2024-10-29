/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comunicacion_hilos;

/**
 *
 * @author guillermo
 */
public class Hilo_Vendedor extends Thread {

    private AlmacenCuadros almacen;
//constructor

    public Hilo_Vendedor(AlmacenCuadros a) {
        almacen = a;
    }

    public void run() {
        for (int i = 1; i < 30; i++) {
            almacen.sacar();
        }
//vende (saca) del almacén 30 cuadros(vende de 1 en 1)
    }
}
