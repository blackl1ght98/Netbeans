/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package superior;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author guillermo
 */
//Para que esta clase sea un manejador tenemos que hacer que herede con (extends) de DefaultHandler
public class VersionesHandler extends DefaultHandler{
//DefaultHandler dispone de una serie de metodos que nos van a permitir leer el xml.
    //Para acceder a los metodos que tiene DefaultHandler hacemos lo siguiente:
    //Clic derecho dentro de las llaves de la clase VersionesHandler
    //Una vez que le hemos dado clic derecho le damos a Insert Code...
    //Y Cuando le hemos dado a InsertCoder veremos un menu y le damos a Override Methods
    //Y dentro de esa ventana seleccionamos los metodos que vamos a sobreescribir
    //Para leer cualquier fichero xml siempre se necesitan estos tres metodos
   //Este metodo es para reconocer el texto
    private ArrayList<Version> versiones= new  ArrayList();
    //Creamo un metodo auxiliar para ir leyendo el xml y luego cargarlo en el array
    private Version version;
    //Esto lo usamos para leer los elemento simples el texto a modo de buffer en este caso lo que leeria es el nombre y api
    private StringBuilder buffer= new StringBuilder();

    public ArrayList<Version> getVersiones() {
        return versiones;
    }
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
       //Como lo que viene en el swith que esta en  startElement es texto lo ponemos aqui
       buffer.append(ch,start,length);
    }

//Este metodo detecta las etiquetas de apertura, si alguna etiqueta xml tiene atributos lo detecta con Attributes attributes
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
      // String qName contine el nombre de la etiqueta de apertura.
      //Aqui hemos creado un swith en el que ponemos todas las etiquetas de apertura
      switch(qName){
        
              //Aqui version tiene datos que nos interesa pues reservamos memoria para este elemento         
          case "version":
              version= new Version();
              versiones.add(version);
              //Como version tiene un atributo llamado numero que indica el numero de la version llamamos al metodo set creado para modificarlo.
              //Este numero es un atributo de la etiqueta para recuperarlo usamos la propiedad attributes junto a .getValue("nombreAtributo")
              //para recuperar su valor.
              //como attributes.getValue("numero") esto nos devuelve un string y nosotros lo hemos puesto como double
              //lo convertimos con Double.parseDouble().
              version.setNumero(Double.parseDouble(attributes.getValue("numero"))); 
              break;
          case "nombre":
              //Ahora limpiamos el stringBuilder para que no coja datos que no son.
              buffer.delete(0,buffer.length());
              
              break;
          case "api":
              //Volvemos a borrar el buffer para asegurarnos que los datos lleguen bien
              buffer.delete(0,buffer.length());
              break;
      }
    }
   //Este metodo detecta las etiquetas de cierre
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
  //Ahora nos encontramos con un endElement etiqueta de cierre veamos como tratarlo
        //Hacemos algo parecido a como hemos echo en startElement
        switch(qName){
            case "nombre":
               //Como aqui sabemos que ha terminado de leer la etiqueta recuperamos el nombre del
                //StringBuilder. que lo tenemos llamado como buffer
                //version.setNombre(buffer.toString()); asi obtenemos lo que hay almacenado en buffer y lo devuelve como cadena de texto
                version.setNombre(buffer.toString());
                break;
            case "api":
                //Pasa algo parecido a lo que ocurre con version pero aqui lo recuperamos del buffer
                version.setApi(Integer.parseInt(buffer.toString()));
                break;
           
           
        }
    }
    
    
    
}
