/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package multiprocesosjava;

import java.util.Scanner;

/**
 *
 * @author guillermo
 */
public class MultiprocesosJava {

    /**
     * @param args the command line arguments, cantidad de veces mirada la
     * solucion 2
     */
    public static void main(String[] args) {
        //Pasar argumentos en la terminal
        int cantidadCadenas = 0;
        if (args.length > 0) {
            //Convertimos el argumento puesto por el usuario a entero
            cantidadCadenas = Integer.parseInt(args[0]);

        } else {
            //En caso de que no sea por terminal lo controlamos con la clase Scanner
            Scanner scanner = new Scanner(System.in);
            System.out.println("¿Cuantas cadenas desea generar?");
            cantidadCadenas = scanner.nextInt();
        }
        //Instanciamos la clase cadenas
        Cadenas cadena = new Cadenas();
        //Bucle para generar esas cadenas
        for(int i =0; i<cantidadCadenas;i++){
        String cadenaGenerada = cadena.generarCadenasv2();
        System.out.println(cadenaGenerada);
        
        }
        System.out.println();
    }

}
