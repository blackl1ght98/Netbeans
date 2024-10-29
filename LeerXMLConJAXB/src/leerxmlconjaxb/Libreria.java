/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leerxmlconjaxb;

import java.util.ArrayList;

/**
 *
 * @author guillermo
 */

public class Libreria {
    //Esta es otra manera de hacer uso de JAXB pero en vez de ser automatico es manual, como lo estamos haciendo manual vamos a respetar la estructura del xml
    private String nombre;
    //Aqui declaramos un array porque este array almacena los libros con sus respectivas propiedades
    private ArrayList<Libro> libros =new ArrayList();

    public Libreria() {
        
    }
    //Como estamos siguiendo la estructura del xml le tenemos que decir a java esa estructura y para ello tiene unas anotaciones que se ponen con el simbolo "@"
    //Si una etiqueta de xml envuelve a otra esto se llama "Wrapper"
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }
    
}
