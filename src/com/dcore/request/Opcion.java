package com.dcore.request;

/**
 *
 * @author DCore
 */

/*
 Esta Clase Maneja todo lo que tenga que ver con las claves  y valores de las peticiones
 
 */


public class Opcion {
    
    
    
    
   private String key;
   private String value;

    public Opcion(String key) {
        this.key = key;
    }

    public Opcion() {
    }

    public Opcion(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    
}
