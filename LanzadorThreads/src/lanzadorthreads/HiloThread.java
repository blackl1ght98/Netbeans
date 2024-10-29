/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lanzadorthreads;

/**
 *
 * @author guillermo
 */
public class HiloThread extends Thread {
    private String nombre;

    public HiloThread(String nombre) {
        this.nombre = nombre;
    }

    public HiloThread() {
        this ("Hilo Thread");
    }

    @Override
    public void run() {
        for (int i=1; i<=20;i++){
        System.out.println(nombre);
        }
    }
    
}
