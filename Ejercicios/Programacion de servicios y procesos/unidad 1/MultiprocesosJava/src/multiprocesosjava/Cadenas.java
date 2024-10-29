/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multiprocesosjava;

import java.util.Random;

/**
 *
 * @author guillermo
 */
public class Cadenas {

    //Para tratar caracteres por separado como es la generacion de cadenas de forma aleatoria usando el alfabeto..
    private final char[] alfabeto = "abcdefghijklmnorstuvwxyz".toCharArray();
    //Para tratar algo aleatorio usamos....
    Random random = new Random();
    //La otra parte del ejercicio dice generar cadenas parecidad al español para esto vamos a emplear este array
    private final String[] SILABAS = {
    "ba", "be", "bi", "bo", "bu", 
    "ca", "ce", "ci", "co", "cu", 
    "da", "de", "di", "do", "du", 
    "fa", "fe", "fi", "fo", "fu", 
    "ga", "ge", "gi", "go", "gu", 
    "ha", "he", "hi", "ho", "hu", 
    "ja", "je", "ji", "jo", "ju", 
    "ka", "ke", "ki", "ko", "ku", 
    "la", "le", "li", "lo", "lu", 
    "ma", "me", "mi", "mo", "mu", 
    "na", "ne", "ni", "no", "nu", 
    "pa", "pe", "pi", "po", "pu", 
    "qa", "qe", "qi", "qo", "qu", 
    "ra", "re", "ri", "ro", "ru", 
    "sa", "se", "si", "so", "su", 
    "ta", "te", "ti", "to", "tu", 
    "va", "ve", "vi", "vo", "vu", 
    "wa", "we", "wi", "wo", "wu", 
    "xa", "xe", "xi", "xo", "xu", 
    "ya", "ye", "yi", "yo", "yu", 
    "za", "ze", "zi", "zo", "zu"
};

    //Crear metodo que genere las cadenas en base al array alfabeto
    public String generarCadenas() {
        //Como necesitamos construir un string usamos...
        StringBuilder str = new StringBuilder();
        int longitudActual = 0;
        int longitudMaxima = 10;
        //El ejercicio nos pide que genere tantas cadenas como el usuario proporcione sin pasarse de 10 caracteres de longitud
        while (longitudActual < longitudMaxima) {
            //Esto es lo que realmente genera la letra aleatoria
            char letraAleatoria = alfabeto[random.nextInt(alfabeto.length)];
            str.append(letraAleatoria);
            longitudActual++;
        }

        return str.toString();
    }
    //Copiamos y pegamos el metodo anterior y lo modificamos
     public String generarCadenasv2() {
        //Como necesitamos construir un string usamos...
        StringBuilder str = new StringBuilder();
        int longitudActual = 0;
        int longitudMaxima = 10;
        //El ejercicio nos pide que genere tantas cadenas como el usuario proporcione sin pasarse de 10 caracteres de longitud
        while (longitudActual < longitudMaxima) {
            //Esto es lo que realmente genera la letra aleatoria
            String letraAleatoria = SILABAS[random.nextInt(SILABAS.length)];
            str.append(letraAleatoria);
              longitudActual += letraAleatoria.length();
        }

        return str.toString();
    }
}
