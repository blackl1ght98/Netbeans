/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hilossicronizacion;

/**
 *
 * @author guillermo
 */
public class Entrada_Jardin extends Thread {

    private RecursoJardin jardin;

    public Entrada_Jardin(String nombre, RecursoJardin jardin) {
        this.setName(nombre);
        this.jardin = jardin;
    }

    @Override
    public void run() {
        jardin.incrementaCuenta();
    }
}
