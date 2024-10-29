/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package comunicacion_hilos;

/**
 *
 * @author guillermo
 */
public class Comunicacion_Hilos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        AlmacenCuadros almacen = new AlmacenCuadros();
        //recurso compartido por los hilos, el almacén
        Hilo_Pintor pintor = new Hilo_Pintor(almacen);
        Hilo_Vendedor vendedor = new Hilo_Vendedor(almacen);
         //se crean los hilos
        pintor.start();
        vendedor.start();
       //se inician los hilos
       /*Flujo ejecucion: Hilo_Pintor, Hilo_Vendedor comparten el mismo recurso almacen
        Pintado cuadro: 1 aqui lo vemos mejor en el almacen no hay nada pues el pintor pinta un cudro y lo mete en el almacen.
        Vendido cuadro: 0 aqui el pintor espera a que el vendedor venda el cuadro cuando lo venda y vendedor notifica al pintor
        Pintado cuadro: 1
        Vendido cuadro: 0
        Pintado cuadro: 1
        Vendido cuadro: 0
        Pintado cuadro: 1
        Vendido cuadro: 0
        Pintado cuadro: 1
        Vendido cuadro: 0
        Pintado cuadro: 1
       
       
       */
    }
}


