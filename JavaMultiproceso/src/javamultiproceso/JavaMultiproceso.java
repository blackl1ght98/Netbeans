/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javamultiproceso;

import java.util.Scanner;

/**
 *
 * @author guillermo
 */
public class JavaMultiproceso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GenerarCadenas cadenas = new GenerarCadenas();
        int numeroCadenas = 0;
        if (args.length > 0) {
            try {
                numeroCadenas = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("El argumento debe ser un número entero.");
                return;
            }
        } else {
            Scanner scan = new Scanner(System.in);
            System.out.println("¿Cuantas cadenas quieres generar");
            numeroCadenas = scan.nextInt();         
        }
         if (numeroCadenas > 10) {
                System.out.println("La longitud no puede pasar de 10");
                return;
            }
            for (int i = 0; i < numeroCadenas; i++) {
                String cadenaGenerada = cadenas.generarCadenasV2();
                System.out.println(cadenaGenerada);
            }
    }

}
