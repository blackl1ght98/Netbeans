/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package superior;
//Esta dependencia permite manipular archivos en java
import java.io.File;
import java.io.IOException;
/**
 *
 * @author guillermo
 */
public class CreacionArchivoYDirectorio {
     // Método para crear un directorio
    public static void crearDirectorio(String ruta) {
        File directorio = new File(ruta);

        // Crear un solo directorio
        boolean creado = directorio.mkdir();
        System.out.println("Directorio creado: " + creado);

       
    }
   public static void crearArchivo(String ruta) {
        try {
            //Este metodo crea un archivo
            File fichero = new File(ruta);
            //Llama al metodo que crea el archivo y si se ejecuto correctamente muestra el mensaje
            if (fichero.createNewFile()) { 
                System.out.println("El fichero se ha creado con éxito");
            } else {
                System.out.println("No ha podido ser creado el fichero");
            }
            //Aqui vemos algo nuevo como createNewFile() puede generar multiples excepciones es necesario controlarlas
        } catch (IOException e) {
            // Maneja excepciones relacionadas con la entrada/salida
            System.out.println("Error de entrada/salida: " + e.getMessage());
        } catch (SecurityException e) {
            // Maneja excepciones de seguridad
            System.out.println("No se tiene permiso para crear el fichero: " + e.getMessage());
        }
    }
   public static void crearVariosDirectorios(String ruta) {
       
        File directorio = new File(ruta);

        // Crear un solo directorio
        boolean creado = directorio.mkdirs();
        System.out.println("Directorio creado: " + creado);

        
    }
}
