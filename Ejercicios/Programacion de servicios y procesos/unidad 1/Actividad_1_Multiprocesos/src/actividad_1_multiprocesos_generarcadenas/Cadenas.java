/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad_1_multiprocesos_generarcadenas;

import java.util.Random;

/**
 *
 * @author guillermo
 */
public class Cadenas {

    private static final char[] alfabeto = "abcdefghijklmnopqrstuvwxyz".toCharArray();
  
    private static final String[] SILABAS = {
        "ba", "be", "bi", "bo", "bu", "ca", "ce", "ci", "co", "cu",
        "da", "de", "di", "do", "du", "fa", "fe", "fi", "fo", "fu",
        "ga", "ge", "gi", "go", "gu", "la", "le", "li", "lo", "lu",
        "ma", "me", "mi", "mo", "mu", "na", "ne", "ni", "no", "nu",
        "pa", "pe", "pi", "po", "pu", "ra", "re", "ri", "ro", "ru",
        "sa", "se", "si", "so", "su", "ta", "te", "ti", "to", "tu",
        "va", "ve", "vi", "vo", "vu", "za", "ze", "zi", "zo", "zu"
    };
    private Random random = new Random();

    public String generarCadenas() {
       // StringBuilder se usa para construir y manipular strings
        StringBuilder cadenaGenerada = new StringBuilder();
        //variable que controla la cantidad de cadenas generadas
        int longitudActual = 0;
        int longitudMaxima=10;
        // Bucle que genera cadenas aleatorias sin superar el limite
        while (longitudActual < longitudMaxima) { 
            //Variable que almacena que silabas han sido escogidas aleatoriamente en base a una posicion aleatoria
            char letraAleatoria = alfabeto[random.nextInt(alfabeto.length)];
            //Con el metodo  .append va creando poco a poco el string
            cadenaGenerada.append(letraAleatoria);
            //Incrementa longitud actual cada vez que una silaba es agregada
            longitudActual++;

    }
        return cadenaGenerada.toString();
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
            String silabaAleatoria = SILABAS[random.nextInt(SILABAS.length)];
            //Con el metodo  .append va creando poco a poco el string
            cadenaGenerada.append(silabaAleatoria);
            //Incrementa longitud actual cada vez que una silaba es agregada
            longitudActual += silabaAleatoria.length();
        }

        return cadenaGenerada.toString();
    }

}
