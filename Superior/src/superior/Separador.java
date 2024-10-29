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
public class Separador {
    public static String separador(String ruta){
    String separador ="\\\\";
    try{
    if(File.separator.equals(separador)){
        separador="/";
    }
    return ruta.replaceAll(separador, File.separator);
    }catch(Exception ex){
    return ruta.replaceAll(separador + separador, File.separator);
    }
  }
}
