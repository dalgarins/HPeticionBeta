package com.dcore.write;

import com.dcore.request.DataPeticion;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PruebaCookie {

    @SuppressWarnings("empty-statement")
    public static void writeDataPeticion(String path) {
        XStream xstream = new XStream(new DomDriver());
        DataPeticion data = new DataPeticion();


     data.getHeader().getListHeader().put("Cookie", "Prueba");
        data.getHeader().getListHeader().put("Referer","Prueba");
        data.setUrl("http://www.prueba.com");
        data.getForm().getListForm().put("puntos", "2000");

        data.getSettings().getListConfig().put("timeRequest", "3600");
       


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

    @SuppressWarnings("empty-statement")
    public static void writeDataPeticion() {
        XStream xstream = new XStream(new DomDriver());
        DataPeticion data = new DataPeticion();

        data.getHeader().getListHeader().put("Cookie", "Prueba");
        data.getHeader().getListHeader().put("Referer","Prueba");
        data.setUrl("http://www.prueba.com");
        data.getForm().getListForm().put("puntos", "2000");

        data.getSettings().getListConfig().put("timeRequest", "3600");
       


        String xml = xstream.toXML(data);
        File f;
        f = new File("DataPeticion.xml");
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
}
