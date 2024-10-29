/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multihilos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author guillermo
 */
public class Recurso {

    //Tanto los 2 hilos productores como consumidores asignaran o sacaran valores aleatorios de este array
    public int[] valores = new int[10];
    //En el ejercicio no se dice pero se necesita llevar como una cuenta de los valores que se meten y sacan
    public int cuenta = 0;
    //Esta variable sumara los valores consumidos
    public int suma = 0;
    //Como hay que repetir la ejecucion esta variable la usamos para parar el bucle
    public boolean terminado = false;
    //Como el ejercicio dice registrarlo en un fichero necesitamos usar esto
    public FileWriter writer;

    public Recurso() {
        //Inicializamos el array en -1 para que las cuentas salgan bien ya que un array empieza en 0
        Arrays.fill(valores, -1);
        //Si no ponemos esto con un try-catch nos da error porque genera una excepcion no controlada
        try {
            writer = new FileWriter("sin-mirar.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void producir(int valor, String nombreHilo) {
        //Esta condicion controla si el array valores esta lleno
        while (cuenta == valores.length && !terminado) {
            //como se tiene que parar si el array esta lleno la instruccion wait genera una xcepcion y si no se controla devuelve un error
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Error al interruptir los hilos productores");
            }
        }
        //Si por ejemplo entran 2 hilos al mismo tiempo y el primero pasa la condicion anterior pero el segundo no cumple hay que echarlo de algun modo
        if (terminado) {
            return;
        }
        valores[cuenta] = valor;
        cuenta++;
        System.out.println(nombreHilo + "introduce valor " + valor + "en la posicion " + cuenta);
        System.out.println("Array " + Arrays.toString(valores) + " Suma=" + suma);
        registrarEnArchivo(nombreHilo + "introduce valor " + valor + "en la posicion " + cuenta + "Array " + Arrays.toString(valores) + " Suma=" + suma);
        notifyAll();
    }

    public synchronized int consumir(String nombreHilo) {
        while (cuenta == 0 && !terminado) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Se ha producido un error en el hilo consumidor");
            }
        }
        if(terminado){
        return -1;
        }
        int valor=valores[cuenta-1];
        valores[cuenta]=-1;
        cuenta--;
        suma+=valor;
        System.out.println(nombreHilo + "saca valor " + valor + "en la posicion " + (cuenta-1));
        System.out.println("Array " + Arrays.toString(valores) + " Suma=" + suma);
        registrarEnArchivo(nombreHilo + "saca valor " + valor + "en la posicion " + (cuenta-1)+"Array " + Arrays.toString(valores) + " Suma=" + suma);
        if(suma>100){
        terminado=true;
        registrarEnArchivo("Suma total: "+suma);
        notifyAll();
        }
        return valor;
    }

    //Creamos ya el metodo para registrar en el fichero
    public void registrarEnArchivo(String mensaje) {
        //Nos pasa lo mismo como no controlamos la excepcion da error hacemos lo mismo lo controlamos con un try-catch
        try {
            writer.write(mensaje + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getSuma() {
        return suma;
    }

}
