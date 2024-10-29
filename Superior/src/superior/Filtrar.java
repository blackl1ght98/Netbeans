/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package superior;



/**
 *
 * @author guillermo
 */
import java.io.File;
import java.io.FilenameFilter;
//Esta clase de java es un poco mas compleja aquí implements FilenameFilter se usa para que implemente unos metodos que vamos a usar esto 
//en un inicio puede que de error hasta que no se nombre al metodo que tiene la clase FilenameFilter y asi no de fallo
public class Filtrar implements FilenameFilter {
    //Al igual que en c# todo lo que se ponga fuera del construcctor son propiedades de la clase que luego es necesario
    //ponerlo en el constructor.
    String extension;

    // Constructor
    public Filtrar(String extension) {
        this.extension = extension;
    }
//@Override esto es una anotacion necesaria para poder usar el metodo accept que lo que hace es detectar cual es la extension de los archivos que existan
    //en el directorio.
    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(extension);
    }

    // Método para listar archivos .txt
    public void listarArchivosTxt() {
        try {
            // Establecemos la ruta del directorio a filtrar
            File directorio = new File("C:\\Users\\guill\\OneDrive\\Escritorio\\blog\\nuevoDirectorio\\.");
            
            // Filtramos por los archivos con extensión .txt
            String[] listaArchivos = directorio.list(new Filtrar(".txt"));

            // Comprobamos el número de archivos en el listado
            if (listaArchivos != null && listaArchivos.length > 0) {
                for (String archivo : listaArchivos) {
                    System.out.println("Los archivos son:");
                    System.out.println(archivo);
                }
            } else {
                System.out.println("No hay archivos que listar");
            }
        } catch (Exception ex) {
            System.out.println("Error al buscar en la ruta indicada: " + ex.getMessage());
        }
    }

   
}

