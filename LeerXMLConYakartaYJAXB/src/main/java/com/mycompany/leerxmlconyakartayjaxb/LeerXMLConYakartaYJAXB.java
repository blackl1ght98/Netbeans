/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.leerxmlconyakartayjaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;

/**
 *
 * @author guillermo
 */
public class LeerXMLConYakartaYJAXB {

    public static void main(String[] args) {
        try {
            // Crear un contexto JAXB para la clase 'pedido'
            JAXBContext context = JAXBContext.newInstance(Pedido.class);
            // Crear un Unmarshaller (deserialización del XML a objeto Java)
            Unmarshaller unmarshaller = context.createUnmarshaller();
            // Leer el archivo XML y convertirlo en objeto Java
            File xmlFile = new File("./albaran.xml");
            Pedido miPedido = (Pedido) unmarshaller.unmarshal(xmlFile);
            // Mostrar los objetos pedido
            System.out.println("Facturar a:  " + miPedido.getFacturarA());
            System.out.println("Comentario: " + miPedido.getComentario());
            System.out.println("Artículos: ");
            for (Pedido.Articulo articulo : miPedido.getArticulosWrapper().getListaArticulos()) {
                System.out.println("Codigo: " + articulo.getCodigo());
                System.out.println("Producto: " + articulo.getNombreProducto());
                System.out.println("Cantidad: " + articulo.getCantidad());
                System.out.println("Precio: " + articulo.getPrecio());
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
