/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lectores.escritores;

/**
 *
 * @author guillermo
 */
public class HiloLector extends Thread {
      private Semaforo semaforo;
    //semaforo de control de acceso recibido por el constructor. Le proporciona
    //al hilo el método de lectura de los datos, así como el método para
    //actualizar el estado cuando finaliza esa lectura

    /**************************************************************************
     * constructor: se le pasa el nombre y el semáforo de control */
    public HiloLector(String nombre, Semaforo s) {
        this.setName(nombre);
        this.semaforo = s;
    }
    /**************************************************************************
     * el método run() del hilo que lee los datos */
    @Override
    public void run() {
        System.out.println(getName() + ": Intentando leer");
        //mensaje de salida para comprobar el funcionamiento
        semaforo.accesoLeer();
        //el hilo ha leido
        try {
            sleep((int) (Math.random()) * 50);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        //duerme al hilo antes de que éste comunique que ha finalizado, para
        //poder ver accesos fallidos, con fines de comprobar funcionamiento
        semaforo.lecturaFinalizada();
        //comunica al semáforo la finalización de la lectura
    }
}
