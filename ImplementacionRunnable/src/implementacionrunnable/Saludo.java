/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementacionrunnable;

/**
 *
 * @author guillermo
 */
//Pasos para implementar Runnable:
/*
1.Creamos o declaramos una nueva clase.
2.Sobrescribir el metodo run(); que tiene la interfaz Runnable;
3.Implementar el codigo que se quiera que se ejecute dentro de el metodo run();

*/
public class Saludo implements Runnable{

    @Override
    public void run() {
        System.out.println("¡Saludo desde un hilo creado con Runnable!");
    }
    
}
