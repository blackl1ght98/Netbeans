/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad_1_multiprocesos_generarcadenas;

/**
 *
 * @author guillermo
 */
public class Frecuencia {

    public static final char[] vocales = {'a', 'e', 'i', 'o', 'u'};

    public int[] frecuencia(String cadena) {
        //El primer paso es simple declarar un array con el numero de vocales existentes
        int[] frecuencias = new int[5];
        //Hacer un foreach sobre el parametro en este caso cadena, recordemos un un string es un array de char y es por ello que un string es iterable aunque no se ponga como array
        for (char c : cadena.toCharArray()) {
            //De cada iteracion comprueba cada letra si esta dentro del array vocales
            for (int i = 0; i < vocales.length; i++) {
                //Si es asi incrementa frecuencias en 1 y vuelve a iterar
                if (c == vocales[i]) {
                    frecuencias[i]++;
                }
            }

        }
        return frecuencias;
    }
}
