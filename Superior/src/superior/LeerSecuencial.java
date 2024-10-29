/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package superior;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author guillermo
 */
public class LeerSecuencial {
    public void Secuencial(){
    String texto = "" ;

        try {
            // Crear el flujo de salida
            FileReader fichero = null;

            // Ruta y nombre del fichero
            fichero = new FileReader("C:\\Users\\guill\\OneDrive\\Escritorio\\blog\\formulario.dat");

            // Montar un buffer sobre ese flujo
            BufferedReader buffer = new BufferedReader(fichero);

            // Escribimos el texto usando el metodo readLine()
            while ((texto = buffer.readLine()) != null) { 
                    System.out.println(texto);
            }

            // Cerrar fichero
            fichero.close();
        } catch (IOException e) {
            // Escribir el error en la consola
            System.err.println("Error: " + e);
              }
    
    }
}
