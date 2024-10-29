/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lectores.escritores;

/**
 *
 * @author guillermo
 */
public class HiloEscritor extends Thread {
private Semaforo semaforo;

    public HiloEscritor(String nombre,Semaforo semaforo) {
        this.setName(nombre);
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
       System.out.println(getName()+ ":Intentando escribir");
        //mensaje para la Salida y comprobar funcionamiento
        semaforo.accesoEscribir();
        //el hilo ha escrito
        try {
            sleep((int) (Math.random()) * 50);
            //duerme el hilo un tiempo aleatorio antes de comunicar el fin de
            //la lectura, para dar ocasión de que los demás hilos hagan
            //intentos fallidos de lectura/escritura y comprobar funcionamiento
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        semaforo.escrituraFinalizada();
        //comunica al semáforo la finalización de la escritura
    }
    
}
