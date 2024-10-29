/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package superior;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;


/**
 *
 * @author guillermo
 */
public class Superior {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
      //  CreacionArchivoYDirectorio.crearArchivo("C:\\Users\\guill\\OneDrive\\Escritorio\\blog\\nuevoDirectorio7");
        // CreacionArchivoYDirectorio.crearDirectorio("C:\\Users\\guill\\OneDrive\\Escritorio\\blog\\nuevoDirectorio1");
         //ListarArchivos.ListarContenidoDirecctorio();
         //DetectarTeclado.Teclado();
        //        Copiar copia = new Copiar();
        //        String rutaOrigen = "C:\\Users\\guill\\OneDrive\\Escritorio\\blog\\formulario.dat";
        //        String rutaDestino = "C:\\Users\\guill\\OneDrive\\Escritorio\\blog\\nuevoDirectorio1\\formulario.dat";
        //        copia.copiarArchivo(rutaOrigen, rutaDestino);
        //LeerSecuencial secuencial = new LeerSecuencial();
        //secuencial.Secuencial();
        //Para que java pueda leer un fichero xml usamos SAXParserFactory junto a otras instancias necesarias
//        SAXParserFactory saxParserFactory= SAXParserFactory.newInstance();
//        SAXParser saxParser = saxParserFactory.newSAXParser();
        //saxParser tiene un metodo parse que se le puede pasar multiples parametros en este caso como el fichero
        //xml esta en nuestro equipo pues necesitamos decirle donde esta y seguidamente necesitamos un manejador o
        //handler que lo que le decimos al handler es decir donde estan las etiquetas de inicio, de cierre entre otras cosas
        //Para pasar nuestro fichero xml lo referenciamos con File:
        //File file = new File("versiones.xml");
        //Ahora tenemos que hacer el manejador es un poco mas complicado porque hay que decirle como es
        //el xml
//        VersionesHandler handler= new VersionesHandler();
//        saxParser.parse(file, handler);
//        ArrayList<Version> versiones = handler.getVersiones();
//        for (Version v: versiones){
//        System.out.println(v);
       // Suma.Operaciones();
       UsoSubstring sub = new UsoSubstring();
       sub.Ejecutar();
        }
    }
    

