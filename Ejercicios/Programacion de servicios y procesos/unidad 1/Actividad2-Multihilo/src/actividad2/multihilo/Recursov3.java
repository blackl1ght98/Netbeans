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
public class Recursov3 {

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
    public int[] valoresAlmacenados = new int[10];
    public int cuenta = 0;
    public int suma = 0;
    public FileWriter writer;
    public boolean terminado = false;

    public Recursov3() {
        //Inicializar array en -1 para indicar vacio -1
        Arrays.fill(valoresAlmacenados, -1);
        try {
            writer = new FileWriter("sin_mirar_segundoIntento.txt");
        } catch (IOException e) {
            System.out.println("Error al crear el archivo ocurrio una excepcion");
        }
    }

    public synchronized void producir(int valor, String nombreHilo) {
        while (cuenta == valoresAlmacenados.length && !terminado) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Ocurrio un error al interrumpir el proceso producir");
            }
        }
        if (terminado) {
            return;
        }
        //Contar valores array
        valoresAlmacenados[cuenta] = valor;
        cuenta++;
        System.out.println(nombreHilo + " introduce valor " + valor + " en la posicion " + cuenta);
        System.out.println("Array: " + Arrays.toString(valoresAlmacenados) + ", Suma =" + suma);
        registrarEnArchivo(nombreHilo + " introduce valor " + valor + " en la posicion " + cuenta + " Array: " + Arrays.toString(valoresAlmacenados) + ", Suma =" + suma);
        //Notificar a los hilos
        notifyAll();
    }

    public synchronized int consumir(String nombreHilo) {
        while (cuenta == 0 && !terminado) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Ocurrio un error al interrunpir en consumir");
            }
        }
        //Evitar que entre un hilo de mas
        if(terminado){
        return -1;
        }
        //Obtener valor a quitar
        int valor = valoresAlmacenados[cuenta-1];
       //Quitar valor
       valoresAlmacenados[cuenta -1]=-1;
       cuenta--;
       //Sumar el valor quitado
       suma+=valor;
       System.out.println(nombreHilo +" saca valor "+ valor +" de la posicion"+ (cuenta+1) );
       System.out.println("Array: " +Arrays.toString(valoresAlmacenados)+ ", Suma = "+suma);
       registrarEnArchivo(nombreHilo +" saca valor "+ valor +" de la posicion"+ (cuenta+1)+"Array: " +Arrays.toString(valoresAlmacenados)+ ", Suma = "+suma);
       if(suma>100){
       
       terminado=true;
        registrarEnArchivo("Resultado final: " + suma);
       notifyAll();
       }
       notifyAll();
       
       
       return valor;
    }

    public void registrarEnArchivo(String mensaje) {
        try {
            writer.write(mensaje + "\n");
            writer.flush();

        } catch (IOException e) {
            System.out.println("Ocurrio una excepcion al escribir en el archivo");
        }
    }

    public int getSuma() {
        return suma;
    }
}
