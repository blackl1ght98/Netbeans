/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad_1_multiprocesos_generarcadenas;


import java.util.Scanner;

/**
 *
 * @author guillermo
 */
public class Cadenas_Main {

    /**
     * @param args sirve para pasar argumentos en el cmd
     */
   public static void main(String[] args) {
    Cadenas cadenas = new Cadenas();
    int numeroDeCadenas = 0; 
    //Verifica si el usuario a pasado argumentos
    if (args.length > 0) {
        try {
            //El numero que ponga el usuario como primer argumento lo convierte de string a int 
            numeroDeCadenas = Integer.parseInt(args[0]);
            //Esta conversion genera la siguiente excepcion...
        } catch (NumberFormatException e) {
            System.out.println("El argumento debe ser un número entero.");
            return;
        }
    } else {
        // Si el usuario no proporciona argumentos lo recoge haciendo uso de la clase scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Cuántas cadenas quieres generar? (máximo 10)");
        //scanner.nextInt();-->metodo de la clase scanner que converte el numero a entero
        numeroDeCadenas = scanner.nextInt();
    }
    // Verificar que no se pasa de la longitud permitida
    if (numeroDeCadenas > 10) {
        System.out.println("No se pueden generar más de 10 cadenas.");
        return;
    }
    //Bucle que genera tantas cadenas como el numero que ponga el usuario
    for (int i = 0; i < numeroDeCadenas; i++) {
        //Llamada al metodo que genera las cadenas
        String cadenaGenerada = cadenas.generarCadenasV2();
       // String cadenaGenerada = cadenas.generarCadenas();
        System.out.println( cadenaGenerada);
    }
}

}

