/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sincronizacion_segmento_synchronized;

/**
 *
 * @author guillermo
 */
//Hilo que accedera a RecursoJardin
public class Sale_Jardin extends Thread {

    private RecursoJardin jardin;

    public Sale_Jardin(String nombre, RecursoJardin jardin) {
        this.setName(nombre);
        this.jardin = jardin;
    }

    @Override
    public void run() {

        synchronized (jardin) {
            jardin.decrementaCuenta();
        }

    }
}
