/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.yakartabinding;


import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;

/**
 *
 * @author guillermo
 */
public class YakartaBinding {

    public static void main(String[] args) {
        try {
            Persona persona = new Persona("Juan", 30);

            // Crear un contexto JAXB
            JAXBContext context = JAXBContext.newInstance(Persona.class);

            // Crear un Marshaller para convertir el objeto en XML
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            File archivoXML=new File("persona.xml");
            // Imprimir el objeto Persona como XML en la consola
            marshaller.marshal(persona, System.out);
            marshaller.marshal(persona,archivoXML);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
      

    }
}
