/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javamultiproceso;

/**
 *
 * @author guillermo
 */
public class Frecuencia {

    private char[] vocales = {'a', 'e', 'i', 'o', 'u'};

    //Como tiene que devolver cuantas veces aparece una vocal hacemos lo siguiente
    public int[] Frecuencia(String cadena) {
        int[] numeroVocales = new int[5];
        for (char c : cadena.toCharArray()) {
            for (int i = 0; i < vocales.length; i++) {
                if(c==vocales[i]){
                numeroVocales[i]++;
                }
            }
        }
        return numeroVocales;
    }
}
