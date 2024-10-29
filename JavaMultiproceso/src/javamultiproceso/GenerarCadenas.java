/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javamultiproceso;

import java.util.Random;

/**
 *
 * @author guillermo
 */
public class GenerarCadenas {

    private final char[] alfabeto = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private Random rnd = new Random();
 private static final String[] SILABAS = {
        "ba", "be", "bi", "bo", "bu", "ca", "ce", "ci", "co", "cu",
        "da", "de", "di", "do", "du", "fa", "fe", "fi", "fo", "fu",
        "ga", "ge", "gi", "go", "gu", "la", "le", "li", "lo", "lu",
        "ma", "me", "mi", "mo", "mu", "na", "ne", "ni", "no", "nu",
        "pa", "pe", "pi", "po", "pu", "ra", "re", "ri", "ro", "ru",
        "sa", "se", "si", "so", "su", "ta", "te", "ti", "to", "tu",
        "va", "ve", "vi", "vo", "vu", "za", "ze", "zi", "zo", "zu"
    };
    public String Cadenas() {
        StringBuilder str = new StringBuilder();
        //Como el usuario tiene que dar un valor para que genera las cadenas hacemos lo siguiente


        int longitudMaxima = 10;

        for (int i = 0; i < longitudMaxima; i++) {
            char cadenaGenerada = alfabeto[rnd.nextInt(alfabeto.length)];
            str.append(cadenaGenerada);
           
        }
        return str.toString();

    }
     public String generarCadenasV2() {
        // StringBuilder se usa para construir y manipular strings
        StringBuilder cadenaGenerada = new StringBuilder();
        //variable que controla la cantidad de cadenas generadas
        int longitudActual = 0;
        int longitudMaxima=10;
        // Bucle que genera cadenas aleatorias sin superar el limite
        while (longitudActual < longitudMaxima) { 
            //Variable que almacena que silabas han sido escogidas aleatoriamente en base a una posicion aleatoria
            String silabaAleatoria = SILABAS[rnd.nextInt(SILABAS.length)];
            //Con el metodo  .append va creando poco a poco el string
            cadenaGenerada.append(silabaAleatoria);
            //Incrementa longitud actual cada vez que una silaba es agregada
            longitudActual += silabaAleatoria.length();
        }

        return cadenaGenerada.toString();
    }
}
