package com.dcore.request;

import java.util.LinkedHashMap;

/**
 *
 * @author DCore
 */

/**
 Contiene el cuerpo de la peticion es decir los parametros que se mandan por post
 */

public class Form implements Opcionable {

    private LinkedHashMap<String,String> listForm;

    public Form() {
        listForm = new LinkedHashMap<String,String>();
    }

    public LinkedHashMap<String,String> getListForm() {
        return listForm;
    }

    public void setListForm(LinkedHashMap<String,String> listForm) {
        this.listForm = listForm;
    }

    @Override
    public String getValue(String key) {
       return listForm.get(key);
    }
}
