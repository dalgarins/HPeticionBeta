package com.noa.write;

import com.core.noa.request.DataRequest;
import com.core.noa.request.Opcion;
import com.core.noa.request.Request;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.extended.NamedMapConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Clase de Prueba para la creacion de un Archivo de configuracion .xml por default
 * @author NoaD
 */
public class PruebaCookie {

    /**
     * Crea un archivo de configuracion por default
     * @param path es el nombre del archivo
     */
    @SuppressWarnings("empty-statement")
    public static void writeDataPeticion(String path) {
        XStream xstream = new XStream(new DomDriver());
        DataRequest data = new DataRequest();
        data.getPublicHeaders().add(new Opcion("Cookie", "cookie"));

        Request request = new Request();
        request.getHeaders().add(new Opcion("Cookie", "cookie"));
        request.getRequestForm().add(new Opcion("Puntos", "1800"));
        request.getRequestForm().add(new Opcion("Conf", "conf"));
        request.getSettings().add(new Opcion("POC", "10"));

        data.getRequestList().put("main".toLowerCase(), request);
        data.getRequestList().put("2".toLowerCase(), new Request());

        xstream.processAnnotations(DataRequest.class);
        xstream.processAnnotations(Request.class);
        xstream.processAnnotations(Opcion.class);

        NamedMapConverter namedMapConverter = new NamedMapConverter(xstream.getMapper(), "NodeRequest", "ID", String.class, "Shema", String.class);
        xstream.registerConverter(namedMapConverter);

        String xml = xstream.toXML(data);
        File f;
        f = new File(path);
        //Escritura  
        try {
            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            wr.write(xml);
            //ahora cerramos los flujos de canales de datos, al cerrarlos el archivo quedará guardado con información escrita  
            //de no hacerlo no se escribirá nada en el archivo  
            wr.close();
            bw.close();
        } catch (IOException e) {
        };
    }

    /**
     * Crea un archivo de configuracion por default
     * y su nombre es DataPeticion.xml
     */
    @SuppressWarnings("empty-statement")
    public static void writeDataPeticion() {
        writeDataPeticion("DataPeticion.xml");
    }
}
