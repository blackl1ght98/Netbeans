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
public class Suma {
    public static void Suma(){
    Scanner scanner = new Scanner(System.in);
    System.out.print("Ingresa el primer numero: ");
    int num1 = scanner.nextInt();
    
    System.out.print("Ingresa el segundo numero: ");
    int num2 = scanner.nextInt();
    System.out.println("La suma es: "+(num1+num2));
    }
    
    public static void SumaV2(){
    Scanner scanner = new Scanner(System.in);
    int num1=0;
    int num2=0;
    while(true){
        System.out.print("Ingresa el primer numero: ");
        try{
            num1=scanner.nextInt();
            break;
    }catch (Exception ex){
        System.out.println("Por favor ingresa un numero valido");
        scanner.next();
    }
  }
    while(true){
    System.out.print("Ingresa el segundo numero:" );
    try{
        num2=scanner.nextInt();
        break;
    }catch(Exception e){
        System.out.println("Por favor ingresa un numero valido: ");
        scanner.next();
        
    }
 }
         System.out.println("La suma es: "+ (num1+num2));
    }
    public static void Operaciones() {
        Scanner scanner = new Scanner(System.in);
        String opcion;  // No hace falta inicializar la variable aquí con "".

        do {
            System.out.println("Elija una opción: ");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicación");
            System.out.println("4. División");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextLine();  // Capturar la opción del usuario

            int num1 = 0;
            int num2 = 0;

            switch (opcion) {
                case "1":
                    System.out.print("Ingrese un número: ");
                    num1 = scanner.nextInt();
                    System.out.print("Ingrese el segundo número: ");
                    num2 = scanner.nextInt();
                    System.out.println("La suma es: " + (num1 + num2));
                    break;

                case "2":
                    System.out.print("Ingrese un número: ");
                    num1 = scanner.nextInt();
                    System.out.print("Ingrese el segundo número: ");
                    num2 = scanner.nextInt();
                    System.out.println("La resta es: " + (num1 - num2));
                    break;

                case "3":
                    System.out.print("Ingrese un número: ");
                    num1 = scanner.nextInt();
                    System.out.print("Ingrese el segundo número: ");
                    num2 = scanner.nextInt();
                    System.out.println("La multiplicación es: " + (num1 * num2));
                    break;

                case "4":
                    System.out.print("Ingrese un número: ");
                    num1 = scanner.nextInt();
                    System.out.print("Ingrese el segundo número: ");
                    num2 = scanner.nextInt();
                    if (num2 != 0) {
                        System.out.println("La división es: " + (num1 / num2));
                    } else {
                        System.out.println("No se puede dividir por cero.");
                    }
                    break;

                case "5":
                    System.out.println("Saliendo del programa.");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }

            // Limpiar el buffer después de leer un número entero
            scanner.nextLine(); 

        } while (!opcion.equals("5"));  // El bucle se repite hasta que se elija "5"
    }
}
