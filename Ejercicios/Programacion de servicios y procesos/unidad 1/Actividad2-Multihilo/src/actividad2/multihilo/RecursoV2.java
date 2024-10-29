/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad2.multihilo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author guillermo
 */
public class RecursoV2 {

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
    public int[] valores = new int[10];
    public int suma = 0;
    public int cuenta = 0;
    public boolean terminado = false;
    public FileWriter writer;

    public RecursoV2() {
        //Inicializar el array con -1 para marcar que esta vacil
        Arrays.fill(valores, -1);
        try {
            writer = new FileWriter("sin_mirar.txt");
        } catch (IOException e) {
            System.out.println("Se ha producido una excepcion al crear el archivo");
        }
    }

    //Evitar que un metodo pise a otro
    //El metodo producir solo produce no devuelve nada cuando te dicen haz un metodo que produzca pero no especifican que devuelva pues siempre es void
    public synchronized void producir(int valor, String nombreHilo) {
        while (cuenta == valores.length && !terminado) {
            try {

                wait();
            } catch (InterruptedException e) {
                System.out.println("Se produjo un error al parar el hilo");
            }
           
            
        }
         if(terminado){
            return;
            }
            valores[cuenta]=valor;
            cuenta++;
            System.out.println(nombreHilo + " introduce el valor " + valor + " en la posición " + cuenta);
        //Arrays.toString(valores)-->este metodo muestra el array valores como una cadena de texto
        System.out.println("Array: " + Arrays.toString(valores) + ", Suma = " + suma);
        //registra en el fichero la accion de consumir
        escribirArchivo(nombreHilo + "Introduce el valor " + valor + " en la posicion " + cuenta + ", Array = " + Arrays.toString(valores) + ", Suma = " + suma);
        notifyAll(); //Notifica al hilo consumidor que hay productos para consumir
    }
    //y cuando te digan un valor tiene que consumir siempre devolvera un valor si se quiere saber el numero siempre int 
    public synchronized int consumir( String nombreHilo) {
        //No se puede consumir si el array esta vacio
        while (cuenta == 0 && !terminado) {
            try {

                wait();
            } catch (InterruptedException e) {
                System.out.println("Se produjo un error al parar el hilo");
            }
           
            
        }
        //si llega al limite evita que entre otro hilo 
         if(terminado){
            return -1;
            }
         // La linea 90 y 91 son necesarias para evitar que se salga de lo establecido por el array
         int valor= valores[cuenta-1];
            valores[cuenta-1]=-1;
            cuenta--;
            suma+=valor;
     System.out.println(nombreHilo + " saca el valor " + valor + " de la posición " + (cuenta + 1));
            System.out.println("Array: " + Arrays.toString(valores) + ", Suma = " + suma);
            escribirArchivo(nombreHilo + " saca el valor " + valor + " de la posición " + (cuenta + 1)
                    + ", Array = " + Arrays.toString(valores) + ", Suma = " + suma);
     System.out.println(nombreHilo + " saca el valor " + valor + " de la posición " + (cuenta + 1));
        //Si suma llega a 100 se para el programa
        if(suma>=100){
        terminado=true;
        escribirArchivo("Resultado final"+suma);
        notifyAll();
        
        }
        notifyAll(); //Notifica al hilo consumidor que hay productos para consumir
        return valor;
    }
    public void escribirArchivo(String mensaje) {
        try {
            writer.write(mensaje + "\n");
            writer.flush();
        } catch (IOException e) {
            System.out.println("Se produjo un error al escribir en el fichero");
        }
    }

    public int getSuma() {
        return suma;
    }

}
