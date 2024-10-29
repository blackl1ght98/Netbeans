/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multiprocesosjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author guillermo
 */
public class FrecuenciaMain {
    
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String linea;
        try {
            Frecuencia frecuencia = new Frecuencia();
            while ((linea = br.readLine()) != null && !linea.isEmpty()) {
                int[] vocales = frecuencia.frecuencias(linea);
                System.out.print("Cadena: "+linea+"-->");
                for (int i = 0; i < vocales.length; i++) {
                    System.out.print(vocales[i] + (i < vocales.length - 1 ? " " : ""));
                }
                System.out.println();
            }
        } catch (IOException e) {
        }
    }
}
