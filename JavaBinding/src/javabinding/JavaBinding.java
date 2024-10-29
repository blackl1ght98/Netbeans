/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javabinding;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author guillermo
 */
public class JavaBinding {


    public static void main(String[] args) {
   try {
        /**
     * Crear una instancia "JAXBContext jaxbContext = JAXBContext.newInstance("javabinding");" para manipular las clases generadas a partir de un archivo .xsd, 
     * que están en el paquete 'javabinding'.
     * 
     * Para hacer este binding:
     * 1. Haz clic derecho sobre el nombre del proyecto → New → Other → JAX-Binding.
     * 2. En la ventana emergente, selecciona el archivo .xsd.
     * 3. En el campo 'Package Name', ingresa 'javabinding', que será el nombre del paquete donde 
     *    se generarán las clases.
     */
        //JAXBContext-->Es una clase necesaria para poder usar Unmarshaller y Marshaller.
       JAXBContext jaxbContext = JAXBContext.newInstance("javabinding");
       //Unmarshaller--> Acción por la cual transformas un archivo xml en un objeto java.
       //jaxbContext.createUnmarshaller();-->Haciendo uso de la instacia creada "jaxbContext" llamamos al metodo encargado de dicha transformacion "createUnmarshaller();"
       Unmarshaller XmlToJava = jaxbContext.createUnmarshaller();
       //JAXBElement-->Es usado para representar un elemento del archivo xml.
       //(JAXBElement) u.unmarshal(new FileInputStream("./albaran.xml"));-->lo que devuelve "u.unmarshal(new FileInputStream("./albaran.xml"));" lo convertimos de forma
       //implicita ha algo de tipo "JAXBElement". 
       //u.unmarshal(new FileInputStream("./albaran.xml"));-->Como en la linea anterior hemos creado el unmarshaller pues lo llamamos dentro de este unmarshaller tiene un
       //metodo llamado unmarshal que recibe la ruta del archivo xml a tratar "new FileInputStream("./albaran.xml")"
       JAXBElement jaxbElement = (JAXBElement) XmlToJava.unmarshal(new FileInputStream("./albaran.xml"));
       //Creamos una instancia de pedidoType y de esta instancia queremos el nombre de todos los elementos del xml que correspondan al pedido estos elementos los sacamos
       //gracias a "jaxbElement.getValue();" recordemos que JAXBElement extrae un elemento pues al ponerlo de esta manera con el getValue(); conseguimos que nos devuelva todos
       //los elementos que corresponden al pedido o dicho de otra forma obtiene las etiquetas del xml referentes a pedido.
       PedidoType pedidoType = (PedidoType) jaxbElement.getValue();

       // Agregar nuevos artículos a la lista de artículos del pedido.
       //Para conseguir agregar articulos lo primero que hacemos es crear una instancia de "Articulos", y esta instancia la obtenemos asi:
       //Articulos articulosExistentes = pedidoType.getArticulos();--> lo que hacemos es mirar "dentro del pedido" y obtener el metodo que obtiene los articulos en este caso
       //getArticulos(); que esto devuelve todos los articulos.
       Articulos articulosExistentes = pedidoType.getArticulos();
       //Como articulos es una lista miramos si esta vacia si....
       if (articulosExistentes == null) {
           //creamos una instancia de Articulos para agregar el articulo
           articulosExistentes = new Articulos();
           pedidoType.setArticulos(articulosExistentes); 
       }

       // Para crear un articulo instanciamos  Articulos.Articulo articulo1 = new Articulos.Articulo(); y aqui lo que instanciamos es la lista dentro de 
       //Articulos de esta forma nos permite modificar cada una de sus propiedades y este codigo se repite para tantos articulos como se quiera agregar.
       Articulos.Articulo articulo1 = new Articulos.Articulo();
       articulo1.setNombreProducto("Producto 1");
       articulo1.setCantidad(5);
       articulo1.setPrecio(new BigDecimal("10.00"));
       articulo1.setCodigo("PER001");

       Articulos.Articulo articulo2 = new Articulos.Articulo();
       articulo2.setNombreProducto("Producto 2");
       articulo2.setCantidad(3);
       articulo2.setPrecio(new BigDecimal("20.00"));
       articulo2.setCodigo("PER002");

       //Obtenemos y agregamos los articulos a la lista
       articulosExistentes.getArticulo().add(articulo1);
       articulosExistentes.getArticulo().add(articulo2);

       // Mostrar los artículos agregados
       for (Articulos.Articulo articulo : articulosExistentes.getArticulo()) {
           System.out.println("Nombre: " + articulo.getNombreProducto());
           System.out.println("Cantidad: " + articulo.getCantidad());
           System.out.println("Precio: " + articulo.getPrecio());
           System.out.println("Código: " + articulo.getCodigo());
           System.out.println("-----");
       }

       // Creamos una instancia de Direccion de esta manera  Direccion direccion = pedidoType.getFacturarA(); al ver otra vez "pedidoType.getFacturarA();"
       //podemos afirmar que pedidoType es la clase central donde todo esta conectado y para modificar algo de otra clase hay que pasar por pedidoType
       Direccion direccion = pedidoType.getFacturarA();
       direccion.setNombre("Joselito Javier");
       direccion.setCalle("Zafiro 3");
       direccion.setCiudad("Molina");
       direccion.setProvincia("Murcia");
       direccion.setCodigoPostal(new BigDecimal("30500"));

       // Marshall para escribir el objeto de vuelta en el XML
       //Marshall--> accion que convierte un objeto java a xml
       Marshaller JavaToXML = jaxbContext.createMarshaller();
       //Esto corrige los problemas de formato
       JavaToXML.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

       // Imprimir el XML modificado a la consola y guardarlo en un archivo
       JavaToXML.marshal(jaxbElement, System.out);
       JavaToXML.marshal(jaxbElement, new FileOutputStream("./albaran_modificado.xml"));

   } catch (JAXBException je) {
       System.out.println(je.getCause());
   } catch (IOException ioe) {
       System.out.println(ioe.getMessage());
   }
}

}
