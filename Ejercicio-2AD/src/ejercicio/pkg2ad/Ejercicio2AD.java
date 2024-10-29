package ejercicio.pkg2ad;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Programa que lee el fichero datosContacto.dat, muestra su contenido por pantalla
 * de forma secuencial y cuenta el número de registros.
 * Un registro se considera cada tres líneas que contienen los campos: nombre, apellidos y email.
 */
public class Ejercicio2AD {

    public static void main(String[] args) throws FileNotFoundException {
        // Ruta del fichero
        String filePath = "./datosContacto.dat";
        int registros = 0; // Contador de registros
        FileReader reader = new FileReader(filePath); 
        BufferedReader bufferedReader = new BufferedReader(reader);
        // Lectura del archivo
        try  {

            String linea;

            // Bucle while que lee línea por línea
            while ((linea = bufferedReader.readLine()) != null) {
                // Separar la línea en campos utilizando el delimitador "$"
                String[] datos = linea.split("\\$");

                // Verificar que hay al menos tres campos (nombre, apellidos, email)
                if (datos.length == 3) {
                    String nombre = datos[0];
                    String apellidos = datos[1];
                    String email = datos[2];

                    // Imprimir los tres campos
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Apellidos: " + apellidos);
                    System.out.println("Email: " + email);

                    // Incrementar el contador de registros válidos
                    registros++;
                } else {
                    System.err.println("Registro con formato incorrecto: " + linea);
                }
            }

            // Mostrar el número total de registros válidos
            System.out.println("Total de registros: " + registros);

        } catch (IOException e) {
            // Captura de excepciones relacionadas con la lectura del fichero
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
