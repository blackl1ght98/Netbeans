/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multiprocesosjava;

/**
 *
 * @author guillermo
 */
public class Frecuencia {

    private final char[] vocales = {'a', 'e', 'i', 'o', 'u'};

    //Crear metodo que reciba la cadena generada por cadenas y cuente sus vocales
    public int[] frecuencias(String cadena) {
        //el motivo por el que la variable esta se declara es para que devuelva 5 numeros
        int[] frecuencia = new int[5];
        //Para averiguar cuantas vocales hay en la cadena recibida por parametro primero hay que iterar toda esa cadena con un bucle
        for (char c : cadena.toCharArray()) {
            for (int i = 0; i < vocales.length; i++) {
                if (c == vocales[i]) {
                    frecuencia[i]++;
                }

            }
        }
        return frecuencia;
    }

}
