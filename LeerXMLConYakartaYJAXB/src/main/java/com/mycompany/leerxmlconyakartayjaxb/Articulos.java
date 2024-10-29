package com.mycompany.leerxmlconyakartayjaxb;

import com.mycompany.leerxmlconyakartayjaxb.Pedido.Articulo;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "articulos")
public class Articulos {
    private ArrayList<Articulo> articulos;

    public Articulos() {
        this.articulos = new ArrayList<>();
    }

   @XmlElement(name = "articulo")
public ArrayList<Articulo> getListaArticulos() {
    return articulos;
}

public void setListaArticulos(ArrayList<Articulo> articulos) {
    this.articulos = articulos;
}

}
