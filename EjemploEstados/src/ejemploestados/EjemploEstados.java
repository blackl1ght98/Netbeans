/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemploestados;

/**
 *
 * @author guillermo
 */
public class EjemploEstados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       HiloAuxiliar hilo1= new HiloAuxiliar();
       System.out.println("Hilo auxiliar nuevo: Estado=getState()" + hilo1.getState()+ " ¿Vivo? isAlive()="+ hilo1.isAlive());
       hilo1.start();
        System.out.println("Hilo auxiliar Iniciado: Estado=getState()" + hilo1.getState()+ " ¿Vivo? isAlive()="+ hilo1.isAlive());
     try{
           hilo1.join();
        }catch(InterruptedException e){
           System.out.println(e.getMessage());
        }
      System.out.println("Hilo Auxiliar Muerto: Estado="
             + hilo1.getState()
             + ",¿Vivo? isAlive()=" + 
             hilo1.isAlive() );
    }
    
}
