/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javamultihilo;

/**
 *
 * @author guillermo
 */
public class JavaMultihilo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Recurso recurso = new Recurso();
       HiloProductor1 produce = new HiloProductor1( recurso, "Producto 1");
       HiloProductor2 produces = new HiloProductor2(recurso,"Producto 2");
       HiloConsumidor consume = new HiloConsumidor(recurso, "Consumir");
       produce.start();
       produces.start();
       consume.start();
       try{
       produce.join();
       produces.join();
       consume.join();
       System.out.println("La suma es: " + recurso.getSuma());
       }catch(InterruptedException e){
       System.out.println("Error al interrumpir");
       }
      
    }
    
}
