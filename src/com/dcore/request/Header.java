package com.dcore.request;

import java.util.LinkedHashMap;

/**
 *
 * @author DCore
 */

/**
 Contiene una Lista de Opciones en las cuales se agregan los datos de la peticion como la cookie, referer etc
 */

public class Header implements Opcionable{

    private LinkedHashMap<String,String> listHeader;

    public Header() {
        listHeader = new LinkedHashMap<String,String>();
    }

    public LinkedHashMap<String,String> getListHeader() {
        return listHeader;
    }

    public void setListHeader(LinkedHashMap<String,String> listHeader) {
        this.listHeader = listHeader;
    }

    @Override
    public String getValue(String key) {
        return listHeader.get(key);
    }
}
