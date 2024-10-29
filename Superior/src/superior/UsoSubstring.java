/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package superior;

import java.util.Scanner;

/**
 *
 * @author guillermo
 */
public class UsoSubstring {

    public void Ejecutar() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca una cadena:  ");
        String linea = sc.nextLine();
        System.out.println("La cantidad de caracteres es: "+ linea.length());

      
        System.out.println("¿Que parte de la cadena deseas obtener? desde");
          int desde= sc.nextInt();
         System.out.println("¿Que parte de la cadena deseas obtener? hasta");
        int hasta= sc.nextInt();
         String sub= linea.substring(desde, hasta);
         System.out.println("El resultado es "+ sub);
    }

}
