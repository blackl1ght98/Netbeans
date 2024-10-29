/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package superior;

import java.io.File;

/**
 *
 * @author guillermo
 */
public class BorrarArchivo {
    public static void Borrar(){
        File archivo = new File("C:\\Users\\guill\\OneDrive\\Escritorio\\blog\\nuevoDirectorio\\archivo.txt");
        if(archivo.exists()){
              boolean borrado = archivo.delete();
               System.out.println("Archivo borrado: " + borrado);
        }else{
        System.out.println("archivo no encontrado");
        }
               
    }
    public static void borrarDirectorio(File directorio) {
        // Verifica si el directorio existe
        if (directorio.exists()) {
            // Si es un directorio, recorre su contenido
            if (directorio.isDirectory()) {
                File[] archivos = directorio.listFiles();
                if (archivos != null) {
                    for (File archivo : archivos) {
                        // Llama recursivamente a la función para borrar el contenido
                        borrarDirectorio(archivo);
                    }
                }
            }
            // Finalmente, elimina el directorio o archivo
            boolean eliminado = directorio.delete();
            System.out.println("Se ha eliminado: " + directorio.getAbsolutePath() + " - " + eliminado);
        } else {
            System.out.println("El directorio no existe: " + directorio.getAbsolutePath());
        }
    }
}
