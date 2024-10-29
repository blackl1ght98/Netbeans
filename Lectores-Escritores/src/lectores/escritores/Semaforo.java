/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lectores.escritores;

/**
 *
 * @author guillermo
 */
public class Semaforo {

    //Indica que no hay lectores leyendo, ni ningun escritor escribiendo.
    //En este estado pueden entrar lectores a leer, o un escritor a escribir
    public final static int LIBRE = 0;
    //contante que indica que hay lectores leyendo. Puede entrar un nuevo
    //lector a leer pero no puede entrar ningun escritor a escribir.
    public final static int CON_LECTORES = 1;
    //constante que indica que hay escritores escribiendo. En este estado, no
    //puede entrar ningun lector a leer, ni ningun escritor a escribir
    public final static int CON_ESCRITOR = 2;
    //estado del semaforo inicialmente libre
    private int estado = LIBRE;
    //Numero de lectores inicialmente ninguno
    private int tLectores = 0;

 //método sincronizado. Sólo un hilo lo usa a la vez
    public synchronized void accesoLeer() {
        //guarda el nombre del hilo que se hace con el método
        String nombre = Thread.currentThread().getName();
        //BD sin lectores ni escritores. Puede netrar a leer
        if (estado == LIBRE) {
             //mensaje para comprobar el funcionamiento
            System.out.println("BD:" + estado + " " + tLectores + "L " + nombre
                    + " entra a leer.");
          //cambia estado, yahay lector
            estado = CON_LECTORES;
            
        } else if (estado != CON_LECTORES) {
            //si no está libre, ni con lectores
            while (estado == CON_ESCRITOR) {
                try {
                    //mensaje para comprobar el funcionamiento
                    System.out.println("BD:" + estado + " " + tLectores + "L "
                            + nombre + " trata de leer.ESPERA");
                    //pone en espera al hilo que intenta leer datos
                    wait();
                    
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
             //mensaje para comprobar el funcionamiento
            System.out.println("BD:" + estado + " " + tLectores + "L "
                    + nombre + " entra a leer.");
           //cambia estado, ya hay lector
            estado = CON_LECTORES;
            
        } else {//en este punto el estado es CON_LECTORES
             //mensaje para comprobar funcionamiento
            System.out.println("BD:" + estado + " " + tLectores + "L "
                    + nombre + " entra a leer.");
           
        }
         //otro lector más
        tLectores++;     
        //mensaje para comprobar funcionamiento
        System.out.println("BD:" + estado + " " + tLectores + "L "
                + nombre + " Leyendo.....");
        
    }

    /**
     * ************************************************************************
     * método que da acceso para escribir datos si el estado de la BD lo permite
     */
    public synchronized void accesoEscribir() {
         //guarda el nombre del hilo que se hace con el método
        String nombre = Thread.currentThread().getName();
        //sin lectores ni escritores
        if (estado == LIBRE) {
           //mensaje para comprobar el funcionamiento
            System.out.println("BD:" + estado + " " + tLectores + "L "
                    + nombre + " entra a escribir.");
            //cambia estado
            estado = CON_ESCRITOR;
            
        } else {
                //si no está libre
            while (estado != LIBRE) {
                //miestras BD está ocupada con lectores, o con un escritor
                try {
                    //mensaje para comprobar funcionamiento
                    System.out.println("BD:" + estado + " " + tLectores + "L "
                            + nombre + " trata de escribir.ESPERA");
                   //pone en espera al hilo que intenta escribir datos 
                    wait();
                    
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }// el estado ahora es LIBRE
            //mensaje para comprobar el funcionamiento
            System.out.println("BD:" + estado + " " + tLectores + "L "
                    + nombre + " entra a escribir.");
             //cambia estado
            estado = CON_ESCRITOR;
           
        }
        //mensaje para comprobar el funcionamiento
        System.out.println("BD:" + estado + " " + tLectores + "L "
                + nombre + " Escribiendo..");
        
    }

    /**
     * ************************************************************************
     * método que invoca un HiloEscritor al terminar de escribir, para
     * actualizar el estado del semáforo y en su caso notificarlo a los hilos en
     * espera. Por supuesto, no se permite que dos hilos ejecuten estas
     * instrucciones a la vez
     */
    public synchronized void escrituraFinalizada() {
         //cambia estado
        estado = LIBRE;
       //mensaje para comprobar el funcionamiento
        System.out.println(Thread.currentThread().getName() + ": Ya ha escrito");
        //notifica a los hilos en espera que ya ha finalizado
        notify();
        
    }

    /**
     * ************************************************************************
     * método que que invoca un HiloLector cuando termina de escribir, para
     * actualizar el estado del semáforo y en su caso notificarlo a los hilos en
     * espera
     *
     * por supuesto, no se permite que dos hilos ejecuten estas instrucciones a
     * la vez
     */
    public synchronized void lecturaFinalizada() {
         //mensaje para comprobar el funcionamiento
        System.out.println(Thread.currentThread().getName() + ": Ya ha leido");
        //un lector menos leyendo
        tLectores--;
        //no hay lectores en la BD
        if (tLectores == 0) {
           //cambia el estado
            estado = LIBRE;
            //notifica a los hilos en espera que ya ha finalizado
            notify();
            
        }
    }
}
