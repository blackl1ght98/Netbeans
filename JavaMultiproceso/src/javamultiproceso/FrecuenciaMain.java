/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javamultiproceso;

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
        Frecuencia frecuencia = new Frecuencia();
        try {
            while ((linea = br.readLine()) != null && !linea.isEmpty()) {
                //Como el metodo devuelve un array de enteros ponemos esto
                int[] frecuencias = frecuencia.Frecuencia(linea);
                System.out.print("Cadena: " + linea+"-->");
                for(int i =0; i<frecuencias.length;i++){
                System.out.print(frecuencias[i]+(i<frecuencias.length -1? " ":""));
                }
                System.out.println();
            }
        }catch(IOException e){
        }
    }
}
