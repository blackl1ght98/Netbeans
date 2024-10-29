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
public class Recursov4 {

    public int[] valores = new int[10];
    //Variable para contar los valores del array  
    public int cuenta = 0;
    public int suma = 0;
    public FileWriter writer;
    public boolean terminado = false;

    public Recursov4() {
        //Inicializar el array para indicar posicio vacia para ello java dispone de 
        Arrays.fill(valores, 0);
        //Crear fichero si no existe
        try {
            writer = new FileWriter("sin_mirar_v2.txt");

        } catch (IOException e) {
            System.out.println("se produjo un error al crear el fichero");
        }
    }

    public synchronized void producir(int valor, String nombreHilo) {
        //Comprobar si el array esta lleno
        while (cuenta == valores.length && !terminado) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Hubo un error al intentar interrupir el hilo productor");
            }
        }
        //Evitar que hilo entre si llega al limete
        if (terminado) {
            return;
        }
        //Asignar valor al array
        valores[cuenta] = valor;
        //Incrementa cuenta
        cuenta++;
        System.out.println(nombreHilo + " introduce valor  " + valor + " en la posición " + cuenta);
        //Mostrar array
        System.out.println("Array: " + Arrays.toString(valores) + ", Suma = " + suma);
        //registrar en fichero
        registrarEnArchivo(nombreHilo + " introduce valor  " + valor + " en la posición " + cuenta + " Array: " + Arrays.toString(valores) + ", Suma = " + suma);
        notifyAll();
    }

    public synchronized int consumir(String nombreHilo) {
        while (cuenta == 0 && !terminado) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Hubo un error al intentar interrupir el hilo productor");
            }

        }
        //Parar el metodo para que no consuma mas de lo debido
        if(terminado){
        return -1;
        }
        //Consumir valor array
        int valor= valores[cuenta -1];
        //1 fallo sin mirar
        valores[cuenta-1]=-1;
        //Decrementa cuenta para mostrar que se a consumido
        cuenta--;
        //Agregar valor consumido a suma
        suma+=valor;
        //Mostrar info
        System.out.println(nombreHilo + " saca valor " + valor + " de la posición " + (cuenta-1));
        //Mostrar array
        System.out.println("Array: " + Arrays.toString(valores) + ", Suma = " + suma);
        registrarEnArchivo(nombreHilo + " saca valor " + valor + " de la posición " + (cuenta-1)+" Array: " + Arrays.toString(valores) + ", Suma = " + suma);
        if(suma>=100){
        terminado=true;
        registrarEnArchivo("Resultado final: "+ suma);
        notifyAll();
        }
        notifyAll();
        return valor;
    }

    public int getSuma() {
        return suma;
    }

    public void registrarEnArchivo(String mensaje) {
        try {
            writer.write(mensaje + "\n");
            writer.flush();
        } catch (IOException e) {
            System.out.println("se produjo un error al escribir en el fichero");
        }
    }
}
