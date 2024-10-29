/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciopropuesto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author guillermo
 */
public class programaD {

    public static void main(String[] args) {
         try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line = br.readLine();
            String[] numerosTexto = line.split(",");
            int[] numeros = new int[numerosTexto.length];

            for (int i = 0; i < numerosTexto.length; i++) {
                numeros[i] = Integer.parseInt(numerosTexto[i].trim());
            }

            int menoresQue30 = 0;
            for (int numero : numeros) {
                if (numero < 30) {
                    menoresQue30++;
                }
            }

            System.out.println("Hay " + menoresQue30 + " números menores que 30");
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
