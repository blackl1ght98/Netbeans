/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hilossicronizacion;

/**
 *
 * @author guillermo
 */
//Hilo que accedera a RecursoJardin
public class Sale_Jardin extends Thread {
    private RecursoJardin jardin;

    public Sale_Jardin(String nombre,RecursoJardin jardin) {
        this.setName(nombre);
        this.jardin = jardin;
    }

    @Override
    public void run() {
       jardin.decrementaCuenta();
    }
    
}
