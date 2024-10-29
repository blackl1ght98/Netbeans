/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciopropuesto;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author guillermo
 */
public class EjercicioPropuesto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] numeros = {5, 10, 15, 20, 25, 30, 35, 40, 45, 50};

        // Construir la cadena de números
        StringBuilder sb = new StringBuilder();
        for (int numero : numeros) {
            sb.append(numero).append(",");
        }

        // Ejecutar programaB y pasarle la cadena
        try {
            ProcessBuilder pb = new ProcessBuilder("java", "D:\\JavaProyectos\\EjercicioPropuesto\\src\\ejerciciopropuesto\\programaB.java");
            Process processB = pb.start();

            // Pasar la cadena de números a programaB
            try (var writer = new OutputStreamWriter(processB.getOutputStream())) {
                writer.write(sb.toString());
                writer.flush();
            }

            // Leer la salida de programaB
            try (var reader = new BufferedReader(new InputStreamReader(processB.getInputStream()))) {
                String resultadoB = reader.readLine();
                System.out.println("El resultado es: " + resultadoB);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
