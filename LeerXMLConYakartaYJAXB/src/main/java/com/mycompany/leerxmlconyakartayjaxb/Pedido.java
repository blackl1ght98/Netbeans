package com.mycompany.leerxmlconyakartayjaxb;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
/*
<?xml version="1.0" encoding="UTF-8"?>
<pedido xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="albaran.xsd">
    <facturarA>
        <nombre>Farmacia Gil</nombre>
        <calle>Mayor 102</calle>
        <ciudad>Madrid</ciudad>
        <provincia>Madrid</provincia>
        <codigoPostal>20080</codigoPostal>
    </facturarA>
    <comentario>Lineas de pedido</comentario>
    <articulos>
        <articulo codigo="872-AA">
            <nombreProducto>Aspirina</nombreProducto>
            <cantidad>1</cantidad>
            <precio>3.60</precio>
            <comentario>Para el dolor de cabeza</comentario>
            <fechaEnvio>2010-10-18</fechaEnvio>
        </articulo>
        <articulo codigo="926-BC">
            <nombreProducto>Gelocatil</nombreProducto>
            <cantidad>2</cantidad>
            <precio>7.20</precio>
            
            <fechaEnvio>2010-09-15</fechaEnvio>
        </articulo>
    </articulos>
</pedido>
*/
@XmlRootElement
public class Pedido  {
    /*Paso a paso de como leer un xml:
    1.Analizar detenidamente la estructura del xml, esto es debido a que hay que replicar esa estructura en java.
    2.Una vez analizada creamos la clase que va a encapsular a las demas, vamos al archivo XML y ¿cual es la primera etiqueta que encontramos?
    la primera etiqueta se llama "pedido" pues asi se llamara nuestra clase.
    3.Vemos dentro de la etiqueta pedido que otras etiquetas tiene:
        - La siguiente que encontrarmos es "facturarA" que esta etiqueta contiene la dirección en este caso de una farmacia, y dentro de esta etiqueta
         ¿hay etiquetas dentro? si las hay pues como hay etiquetas en java para hacer esta estructura creamos un objeto que contenga esas propiedades 
         en este caso se ha decidido nombrar a ese objeto "Direccion", porque si analizamos el objeto es obvio que se llame asi porque las etiquetas 
         que contiene "facturarA" son: nombre, calle, ciudad provincia y codigo postal.
    4.Vamos a la siguiente etiqueta que se llama "comentario", y hacemos lo mismo de antes ¿tiene alguna etiqueta dentro? no en este caso comentario
    es una etiqueta sola pues se declara como una propiedad dentro de la clase pedido, se declara como una variable.
    5.Vamos a la siguiente etiqueta que es "articulos" hacemos la misma pregunta ¿tiene etiquetas dentro? si tiene pero las etiquetas que contiene
    es una colección de datos que en este caso son los articulos y cada vez que se pone la etiqueta "articulo" representa a un articulo como tenemos 
    2 articulos en el XML. Pues esto en java se trata de una manera especial cuando se trata de una coleccion de datos:
        - Creamos un objeto "Articulos" este objeto devolvera un objeto de tipo Articulos que dentro de este objeto tiene sus propiedades para
        acceder a cada "articulo" del XML.
        - Veamos a continuación como se lee cada articulo:
            - En programación cuando es una coleccion de datos o conjunto de ellos se almacena en un array  private ArrayList<Articulo> articulos;
             este array almacena cada articulo que hay en el objeto Articulos que a su vez es cada articulo del xml.
            - Y para poder ver cada valor de cada articulo tiene un getter y setter:
                public ArrayList<Articulo> getListaArticulos() {
                 return articulos;
                  }
                public void setListaArticulos(ArrayList<Articulo> articulos) {
                this.articulos = articulos;
            - Aqui vemos que lo que devoveria son todos los articulos y para editar uno ¿como lo hariamos? pues  public static class Articulo creando una
             clase que contiene las propiedades de un articulo y asi lo podriamos editar
}           - ¿como consultamos el objeto Articulos? pues creamos una variable  private Articulos articulos; que apunte a dicho objeto y creamos 
              su getter y setter.
            - Como el objeto Articulos es un objeto que necesitamos inicializar lo ponemos en el contructor al igual que el objeto Direccion
              el motivo por el que se inicializa es para poder operar con el.
            - ¿El get y set de Articulos que tenemos aqui devuelven todos los articulos? no, para ser precisos devuelve un objeto Articulos con el
             cual operamos mas adelante para cada articulo. 
            - ¿Cual es esa operacion?
             Es una operacion de consulta que tenemos:
                for (Pedido.Articulo articulo : miPedido.getArticulosWrapper().getListaArticulos()) {
                System.out.println("Codigo: " + articulo.getCodigo());
                System.out.println("Producto: " + articulo.getNombreProducto());
                System.out.println("Cantidad: " + articulo.getCantidad());
                System.out.println("Precio: " + articulo.getPrecio());
            }
           Esta consulta en la clase principal se dirige primero a la clase Pedido y dice: "Necesito que me des información de los artículos". 
           La clase Pedido responde: "Aquí tienes esto: getArticulosWrapper()". Pero, en realidad, lo que se está entregando no es la lista de artículos 
           directamente, sino un objeto de tipo Articulos.
           NOTA ADICIONAL: En c# se hace asi:
           [XmlRoot("pedido")]
           public class PedidoType
           {
            [XmlElement("facturarA")]
            public Direccion FacturarA { get; set; }

            [XmlElement("comentario")]
            public string Comentario { get; set; }

            [XmlArray("articulos")]
            [XmlArrayItem("articulo")]
            public List<Articulo> Articulos { get; set; }
        }
        debido a como se maneja los get y set en java la anotacion @XmlElement(name = "articulos") se pone sobre los get o set y no las 
        propiedades esto se hace asi para que no exista duplicidad por si en otra clase estan los mismo nombres
    */
    private Articulos articulos;
    private String comentario;
    private Direccion facturarA;

    // Constructor
public Pedido() {
    this.articulos = new Articulos();
    this.facturarA = new Direccion();
}


public void setArticulosWrapper(Articulos articulos) {
    this.articulos = articulos;
}

    public  Articulos getArticulosWrapper() {
        return articulos;
    }


    @XmlElement(name = "comentario")
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @XmlElement(name = "facturarA")
    public Direccion getFacturarA() {
        return facturarA;
    }

    public void setFacturarA(Direccion facturarA) {
        this.facturarA = facturarA;
    }

     public static class Direccion {
        private String calle;
        private String ciudad;
        private String codigoPostal;
        private String nombre;
        private String provincia;

        @XmlElement(name = "calle")
        public String getCalle() {
            return calle;
        }

        public void setCalle(String calle) {
            this.calle = calle;
        }

        @XmlElement(name = "ciudad")
        public String getCiudad() {
            return ciudad;
        }

        public void setCiudad(String ciudad) {
            this.ciudad = ciudad;
        }

        @XmlElement(name = "codigoPostal")
        public String getCodigoPostal() {
            return codigoPostal;
        }

        public void setCodigoPostal(String codigoPostal) {
            this.codigoPostal = codigoPostal;
        }

        @XmlElement(name = "nombre")
        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        @XmlElement(name = "provincia")
        public String getProvincia() {
            return provincia;
        }

        public void setProvincia(String provincia) {
            this.provincia = provincia;
        }
    }

    public static class Articulo {
        private String codigo;
        private String nombreProducto;
        private double precio;
        private int cantidad;
        private String comentario;
        private String fechaEnvio;

        @XmlAttribute(name = "codigo")
        public String getCodigo() {
            return codigo;
        }

        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }

        @XmlElement(name = "nombreProducto")
        public String getNombreProducto() {
            return nombreProducto;
        }

        public void setNombreProducto(String nombreProducto) {
            this.nombreProducto = nombreProducto;
        }

        @XmlElement(name = "precio")
        public double getPrecio() {
            return precio;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }

        @XmlElement(name = "cantidad")
        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }

        @XmlElement(name = "comentario")
        public String getComentario() {
            return comentario;
        }

        public void setComentario(String comentario) {
            this.comentario = comentario;
        }

        @XmlElement(name = "fechaEnvio")
        public String getFechaEnvio() {
            return fechaEnvio;
        }

        public void setFechaEnvio(String fechaEnvio) {
            this.fechaEnvio = fechaEnvio;
        }
    }
}
