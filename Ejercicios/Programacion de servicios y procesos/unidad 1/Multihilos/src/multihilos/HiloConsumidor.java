/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multihilos;

/**
 *
 * @author guillermo
 */
public class HiloConsumidor extends Thread{
    private Recurso recurso;

    public HiloConsumidor(Recurso recurso, String nombre) {
        super(nombre);
        this.recurso=recurso;
    }

    @Override
    public void run() {
        while(!recurso.terminado){
        try{
            recurso.consumir(getName());
            Thread.sleep(100);
        }catch(InterruptedException e){}
        }
    }
    
    
}
