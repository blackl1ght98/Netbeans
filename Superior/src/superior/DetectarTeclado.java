/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package superior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author guillermo
 */
public class DetectarTeclado {
    public static void Teclado(){
    try{
        BufferedReader teclado = new BufferedReader (new InputStreamReader(System.in));
        System.out.println("Introduzca algo: ");
        String cadenaEscrita = teclado.readLine();
        
        System.out.println("Usuario introdujo: "+ cadenaEscrita);
    }catch(IOException ioe){
      System.out.print(ioe.getMessage());
    }
   }
}
