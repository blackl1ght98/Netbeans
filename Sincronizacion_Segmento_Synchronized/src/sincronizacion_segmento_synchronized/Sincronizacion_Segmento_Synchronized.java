/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sincronizacion_segmento_synchronized;

/**
 *
 * @author guillermo
 */
public class Sincronizacion_Segmento_Synchronized {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           RecursoJardin jardin = new RecursoJardin();
        //crea un objeto RecursoJardín

        for (int i = 1; i <= 10; i++) {
            (new Entrada_Jardin("Entra" + i, jardin)).start();
        }//crea e inicia 10 hilos que simulan entrada al jardín

        for (int i = 1; i <= 15; i++) {
            (new Sale_Jardin("Sale" + i, jardin)).start();
        }//crea e inicia 15 hilos que simulan salida del jardín
    }
    
}
