/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lectores.escritores;

/**
 *
 * @author guillermo
 */
public class LectoresEscritores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Semaforo smfro = new Semaforo();
        //semáforo de control

        //pone 5 lectores a leer y 2 escritores a escribir, controlados por
        //el mismo semáforo
        for (int i = 1; i <= 5; i++) {
            new HiloLector("Lector" + i, smfro).start();
        }

        for (int i = 1; i <= 2; i++) {
            new HiloEscritor("Escritor" + i, smfro).start();
        }
    }
    
}
