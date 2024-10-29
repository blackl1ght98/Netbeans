/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciopropuesto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author guillermo
 */
public class programaC {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line = br.readLine();
            String[] numerosTexto = line.split(",");
            int[] numeros = new int[numerosTexto.length];
            for (int i = 0; i < numerosTexto.length; i++) {
                numeros[i] = Integer.parseInt(numerosTexto[i].trim());
            }

            int mayoresQue20 = 0;
            int mayoresQue30 = 0;
            for (int numero : numeros) {
                if (numero > 20) {
                    mayoresQue20++;
                }
                if (numero > 30) {
                    mayoresQue30++;
                }
            }

            // Enviar el conteo de números mayores que 20 y 30
            System.out.println(mayoresQue20 + " " + mayoresQue30);

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
    }

