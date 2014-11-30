package com.dcore.request;

import java.util.LinkedHashMap;

/**
 *
 * @author DCore
 */
public class Config implements Opcionable {

    LinkedHashMap<String, String> listConfig;

    public Config() {
        listConfig = new LinkedHashMap<String, String>();
    }

    public LinkedHashMap<String, String> getListConfig() {
        return listConfig;
    }

    public void setListConfig(LinkedHashMap<String, String> listConfig) {
        this.listConfig = listConfig;
    }

    @Override
    public String getValue(String key) {
        return listConfig.get(key);
    }
}
