/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pipes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author guillermo
 */
public class Pipes {

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//       Scanner scanner = new Scanner(System.in);
//     
//        String linea = "";
//
//        System.out.println("Vamos a saludar ('Fin' para terminar)");
//          System.out.println("Introduca su nombre: ");
//        linea = scanner.nextLine();
//        
//        while (linea != null && !linea.equalsIgnoreCase("Fin")) {
//           
//            System.out.println("Hola " + linea);
//             System.out.println("Introduca su nombre: ");
//            linea = scanner.nextLine();
//        }
//        scanner.close();
//    }
//}
     public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader bf = new BufferedReader(isr);
    String linea = "";
    try{
        System.out.println("Vamos a saludar ('Fin' para terminar)");
         System.out.println("Introduca su nombre: ");
        linea=bf.readLine();
        while(linea!=null && linea.compareTo("Fin")!=0){
            System.out.println("Hola "+linea);
            System.out.println("Introduca su nombre: ");
            linea=bf.readLine();
        }
    }catch(IOException ex){
        System.err.println("Se ha producido un error en E/S");
    }
    }
    
}

