/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciopropuesto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author guillermo
 */
public class programaB {

    public static void main(String[] args) {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line = br.readLine();
            String[] numerosTexto = line.split(",");
            int[] numeros = new int[numerosTexto.length];
            for (int i = 0; i < numerosTexto.length; i++) {
                numeros[i] = Integer.parseInt(numerosTexto[i].trim());
            }

            // Llamar a programaC
            ProcessBuilder pb = new ProcessBuilder("java", "D:\\JavaProyectos\\EjercicioPropuesto\\src\\ejerciciopropuesto\\programaC.java");
            Process process = pb.start();

            // Comunicar datos a programaC
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            writer.write(line);  // Pasar el mismo array
            writer.newLine();
            writer.flush();
            writer.close();

            // Capturar salida de programaC
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String resultado = reader.readLine();  // Mensaje desde programaC
            
            // Separar los conteos
            String[] conteos = resultado.split(" ");
            int cantidadMayoresQue20 = Integer.parseInt(conteos[0]);
            int cantidadMayoresQue30 = Integer.parseInt(conteos[1]);

            // Mostrar resultado final
            System.out.println("Hay " + cantidadMayoresQue20 + " números mayores que 20 y " + cantidadMayoresQue30 + " números mayores que 30.");

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
    }
    

