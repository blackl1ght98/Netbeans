/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package multihilos;

/**
 *
 * @author guillermo numero veces mirado solucion 3
 */
public class Multihilos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Recurso recurso = new Recurso();
       HiloProducto1 productor_1 = new HiloProducto1(recurso, "Producto 1");
       HiloProducto2 productor_2 = new HiloProducto2(recurso, "Producto 2");
       HiloConsumidor consumidor= new HiloConsumidor(recurso, "Consumidor");
       productor_1.start();
       productor_2.start();
       consumidor.start();
       //Esperar a que todos terminen 
       try{
       productor_1.join();
       productor_2.join();
       consumidor.join();
       }catch(InterruptedException e){
       System.err.println("Error al parar los hilos");
       }
       System.out.println("El resultado es "+recurso.getSuma());
    }
    
}
