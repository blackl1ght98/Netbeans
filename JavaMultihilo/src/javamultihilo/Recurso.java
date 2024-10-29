/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javamultihilo;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author guillermo
 */
public class Recurso {

    private final int[] valores = new int[10];
    private int cuenta = 0;
    private int suma = 0;
     boolean terminado = false;
    private FileWriter writer;

    public Recurso() {
        try {
            writer = new FileWriter("archivoSuma.txt");
        } catch (IOException e) {
            System.out.println("El fichero no se creo correctamente");
        }
    }

    public synchronized void producir(int valor, String nombreHilo) {
        //Comprobar si el array esta lleno
        while (cuenta == valores.length && !terminado) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Hubo un error al interrumpir el proceso de produccion");
            }
        }
        //Si un proceso entra y ha superado el limite lo saca fuera
        if (terminado) {
            return;
        }
        //LLenar el array
        valores[cuenta] = valor;
        cuenta++;
        //Dar formato al array como string
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < cuenta; i++) {
            if (i > 0) {
                str.append(" - ");
            }
            str.append(valores[i]);
        }
        System.out.println(nombreHilo + "introduce el valor: " + valor + " en la posicion: " + cuenta);
        System.out.println("Array: " + str.toString() + ", Suma =" + suma);
        registrarEnArchivo(nombreHilo + "introduce el valor: " + valor + " en la posicion: " + cuenta+"Array: " + str.toString() + ", Suma =" + suma);
        notifyAll();
    }
    public synchronized int consumir(String nombreHilo){
    //Aquí hacemos lo contrario a lo que hemos hecho en el primero podriamos copiar y pegar y cambiar
      while (cuenta == 0 && !terminado) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Hubo un error al interrumpir el proceso de produccion");
            }
        }
        //Si un proceso entra y ha superado el limite lo saca fuera
        if (terminado) {
            return -1;
        }
        //vacia el array
        int valor = valores[cuenta -1] ;
        valores[cuenta -1]=-1;
        cuenta--;
        suma+=valor;
        //Dar formato al array como string
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < cuenta; i++) {
            if (i > 0) {
                str.append(" - ");
            }
            str.append(valores[i]);
        }
        System.out.println(nombreHilo + "introduce el valor: " + valor + " en la posicion: " + cuenta);
        System.out.println("Array: " + str.toString() + ", Suma =" + suma);
        registrarEnArchivo(nombreHilo + "introduce el valor: " + valor + " en la posicion: " + cuenta+"Array: " + str.toString() + ", Suma =" + suma);
        if(suma>=100){
        terminado=true;
        registrarEnArchivo("Resultado total: "+ suma);
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
            System.out.println("Error al escribir en fichero");
        }
    }

}
