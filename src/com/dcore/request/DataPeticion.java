package com.dcore.request;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author DCore
 */
public class DataPeticion {

    private String url;
    private Header header;
    private Form form;
    private Config settings;

    public Config getSettings() {
        return settings;
    }

    public void setSettings(Config settings) {
        this.settings = settings;
    }

    public DataPeticion() {
        header = new Header();
        form = new Form();
        settings = new Config();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public DataPeticion read(String path) {
        XStream xstream = new XStream(new DomDriver());
        File f = new File(path);
        BufferedReader entrada;
        DataPeticion data = new DataPeticion();
        try {
            entrada = new BufferedReader(new FileReader(f));
            if (entrada.ready()) {
                data = (DataPeticion) xstream.fromXML(entrada);
            }
        } catch (IOException e) {
        }
        return data;
    }

    
}
