/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package superior;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author guillermo
 */
public class Copiar {
     public void copiarArchivo(String rutaOrigen, String rutaDestino) {
        FileInputStream fuente = null;
        FileOutputStream destino = null;

        try {
            // Abrir el archivo de origen
            fuente = new FileInputStream(rutaOrigen);
            // Abrir el archivo de destino en modo append (puedes cambiar a false si deseas sobrescribir)
            destino = new FileOutputStream(rutaDestino, true);

            int i;
            // Leer y escribir byte por byte
            while ((i = fuente.read()) != -1) {
                destino.write(i);
            }
            System.out.println("Copia completada con éxito.");
        } catch (IOException ioe) {
            System.out.println("Error en operaciones de ficheros: " + ioe.getMessage());
        } finally {
            // Cerrar los flujos de entrada y salida
            try {
                if (fuente != null) fuente.close();
                if (destino != null) destino.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar los archivos: " + e.getMessage());
            }
        }
    }
}
