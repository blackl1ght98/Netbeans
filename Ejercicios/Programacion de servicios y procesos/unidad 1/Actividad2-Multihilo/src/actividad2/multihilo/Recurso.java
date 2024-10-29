/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad2.multihilo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Recurso {
    /*Los hilos productores se encargarán de almacenar valores numéricos en un array, mientras que el hilo consumidor sacará elementos del array de uno en uno para ir sumándolos en una variable 
    a la que llamaremos 'Suma'. El array tendrá una capacidad para almacenar 10 valores. Los valores introducidos por los productores serán valores aleatorios entre 0 y 10. 
    1º Crear un array que almacene 10 valores
    2º Crear variable suma
    Como es un array podemos declarar una variable que sirva como un "marcador" para indicar que ha terminado
    3º Declara una varible bool en falso.
    Si tiene que sacar valores tendremos que contarlo de alguna manera
    4º Declara una variable que cuente esos valores
    */
    /*Se debe de impedir la superposición de operaciones sobre secciones críticas. Esto con otras palabras es que si no hay elementos producidos no se puede consumir
    y si se llega al limite de valores permitidos no se puede producir.    
    */
    /* Para poder manipular un array y que realmente este vacio podemos usar el metodo Arrys.fill()*/
    /* Se registrara en un archivo*/
    //-----------------------------------------------------------------------------------------------
    private int[] valores = new int[10]; // Almacena 10 valores
    private int cuenta = 0; // Cantidad de elementos en el array
    private int suma = 0;
    public boolean terminado = false; // Flag para indicar que el proceso ha terminado
    private FileWriter writer;

    public Recurso() {
       
        try {
            // Abrimos el archivo donde se registrarán las acciones
            writer = new FileWriter("registro_acciones.txt");
        } catch (IOException e) {
            System.err.println("Error al abrir el archivo: " + e.getMessage());
        }
    }

    public synchronized void producir(int valor, String nombreHilo) {
        //Si cuenta es igual a la logitud del array y terminado es true entonces entra en espera esto significa que el array esta lleno
        while (cuenta == valores.length && !terminado) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.print(e);
            }
        }
        if (terminado) {
            return;
        }
        // Asigna el valor generado a la posición actual del array 'valores' (índice indicado por 'cuenta'). 
        // Ejemplo: Si 'cuenta' es 2 y el hilo productor ha generado el número 5, se inserta el valor 5 en la posición 2 del array 'valores'
        // La variable 'cuenta' controla la posición actual dentro del array 'valores'.
        // La sintaxis básica para asignar un valor en una posición específica del array es: array[indice] = valor;
        // Donde 'indice' es la posición en el array y 'valor' es el valor que deseas almacenar en esa posición.
        valores[cuenta] = valor;
        //Incrementa cuenta para cambiar a la siguiente posicion
        cuenta++;
        // Crear un StringBuilder para mostrar el array
        StringBuilder arrayString = new StringBuilder();
        for (int i = 0; i < cuenta; i++) {
        if (i > 0) arrayString.append(" - ");
        arrayString.append(valores[i]);
        }
        System.out.println(nombreHilo + " introduce el valor " + valor + " en la posición " + cuenta);
        //Arrays.toString(valores)-->este metodo muestra el array valores como una cadena de texto
        System.out.println("Array: " + arrayString.toString() + ", Suma = " + suma);
        //registra en el fichero la accion de consumir
        registrarEnArchivo(nombreHilo + "Introduce el valor " + valor + " en la posicion " + cuenta + ", Array = " + arrayString.toString() + ", Suma = " + suma);
        notifyAll(); //Notifica al hilo consumidor que hay productos para consumir
    }

    public synchronized int consumir(String nombreHilo) {
        //Si el array esta vacio espera a que se llene
        while (cuenta == 0 && !terminado) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        if (terminado) {
            return -1;
        }
        int valor = valores[cuenta - 1];
        valores[cuenta - 1] = -1;
        cuenta--;
        suma += valor;
       
        StringBuilder arrayString = new StringBuilder();
       
        for (int i = 0; i < cuenta; i++) {
        if (i > 0) arrayString.append(" - ");
        arrayString.append(valores[i]);
        }
        System.out.println(nombreHilo + " saca el valor " + valor + " de la posición " + (cuenta + 1));
        System.out.println("Array: " + arrayString.toString() + ", Suma = " + suma);
        registrarEnArchivo(nombreHilo + " saca el valor " + valor + " de la posición " + (cuenta + 1)
                + ", Array = " + arrayString.toString() + ", Suma = " + suma);
        if (suma >= 100) {
            terminado = true;
            registrarEnArchivo("Resultado final: " + suma);
            notifyAll();
        }
        notifyAll();
        return valor;
    }

    private void registrarEnArchivo(String mensaje) {
        try {
            writer.write(mensaje + "\n"); // Escribir la acción en el archivo
            writer.flush(); // Asegurarse de que el mensaje se escribe de inmediato
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public int getSuma() {
        return suma;
    }

    // Cerrar el archivo cuando se termine el proceso
    public void cerrarArchivo() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            System.err.println("Error al cerrar el archivo: " + e.getMessage());
        }
    }
}
