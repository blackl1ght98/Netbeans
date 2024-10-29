/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package superior;

import java.io.File;
//Aquí llamamos a otro paquete de java que permite modificar la fecha del archivo
import java.util.Date;
/**
 *
 * @author guillermo
 */
public class ModificarFechaArchivo {
   public static void modificarFecha() {
       //Este metodo modifica la fecha de un archivo
        File archivo = new File("C:\\Users\\guill\\OneDrive\\Escritorio\\blog\\nuevoDirectorio\\archivo.txt");

        // Verificar si el archivo existe
        if (archivo.exists()) {
            // Establece la fecha y hora actual como última modificación
            boolean modificado = archivo.setLastModified(new Date().getTime());
            System.out.println("Fecha de modificación cambiada: " + modificado);
        } else {
            System.out.println("El archivo no existe: " + archivo.getAbsolutePath());
        }
    }
}
