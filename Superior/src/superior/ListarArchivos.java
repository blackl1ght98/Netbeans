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
public class ListarArchivos {
    public static void ListarRaices(){
         File[] raices = File.listRoots();

        System.out.println("Raíces del sistema de archivos:");
        for (File raiz : raices) {
            System.out.println(raiz.getAbsolutePath());
    }
       
}
     public static void ListarContenidoDirecctorio(){
          File directorio = new File("C:\\Users\\guill\\OneDrive\\Escritorio\\blog");

        // Listar solo los nombres de archivos como Strings
        String[] archivos = directorio.list();
        System.out.println("Archivos en el directorio:");
        //Muestra los archivos que existan en ese directorio
        for (String archivo : archivos) {
            System.out.println(archivo);
        }

        // Listar los archivos como objetos File
        File[] archivosFile = directorio.listFiles();
        System.out.println("\nArchivos como objetos File:");
        //Muestra el nombre de los archivos como objeto file esto lo hace dacias a archivo.getName()
        for (File archivo : archivosFile) {
            System.out.println(archivo.getName());
        }
    }
}
