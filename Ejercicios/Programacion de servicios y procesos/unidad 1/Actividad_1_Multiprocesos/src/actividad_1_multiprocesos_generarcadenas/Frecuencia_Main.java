/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad_1_multiprocesos_generarcadenas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 *
 * @author guillermo
 */
public class Frecuencia_Main {

  public static void main(String[] args) throws IOException {
      //BufferedReader--> Clase de java que toma la salida de un programa como entrada de otro programa
      //Ejemplo--> lo que devuelve cadenas este programa lo toma para operar con el
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Declaracion de variable para leer linea a linea
        String linea;

        // Crear un objeto de Frecuencia
        Frecuencia frecuencia = new Frecuencia();

        // Leer cada línea de la entrada estándar hasta que no haya más
        /* PRIORIZACION DE EJECUCION EN BUCLE WHILE:
        Cuando queremos que en un bucle while en java se ejecute algo primero eso que queremos que se haga primero se pone entre parentesis en este caso queremos que lo primero que
        haga es (linea = br.readLine()) leer la linea antes de comprobar si es null y ademas es distinto de vacio
        while ((linea = br.readLine()) != null && !linea.isEmpty()){}
        
        */
        while ((linea = br.readLine()) != null && !linea.isEmpty()) {
            // Contar las vocales en la cadena leída
            int[] frecuencias = frecuencia.frecuencia(linea);

            // Imprimir en el formato requerido
            System.out.print("Cadena: " + linea + " --> ");
            for (int i = 0; i < frecuencias.length; i++) {
                //Operador ternario que agrega un espacio entre los numeros excepcto cuando termina
                System.out.print(frecuencias[i] + (i < frecuencias.length - 1 ? " " : ""));
                
            }
            System.out.println();
        }
    }
}
