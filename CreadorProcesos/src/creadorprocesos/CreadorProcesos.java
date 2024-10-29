/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package creadorprocesos;

import java.awt.EventQueue;

/**
 *
 * @author guillermo
 */
public class CreadorProcesos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*java.awt.EventQueue.invokeLater:
     Este método se utiliza para colocar un Runnable en la cola de eventos de AWT (Abstract Window Toolkit). Esto asegura que el código 
     dentro del Runnable se ejecute en el hilo de despacho de eventos (Event Dispatch Thread), que es el hilo responsable de manejar 
     la interfaz gráfica de usuario (GUI) en Java. Esto es importante para mantener la GUI reactiva y evitar problemas de concurrencia.      
         */
 /*Runnable:
     Runnable es una interfaz funcional en Java que solo tiene un método: run(). Un Runnable representa una tarea que puede ser ejecutada 
     por un hilo. En este caso, el Runnable contiene el código que se ejecutará en el hilo de despacho de eventos.
    
    
         */

//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Procesos().setVisible(true);
//            }
//        });
        EventQueue.invokeLater(() -> {
            new Procesos().setVisible(true);
        });

    }

}
