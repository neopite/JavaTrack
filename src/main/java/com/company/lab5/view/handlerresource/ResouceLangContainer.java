package com.company.lab5.view.handlerresource;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResouceLangContainer {
    private Locale locale ;
    private ResourceBundle resourceBundle ;
    public  ResouceLangContainer(){
        locale = Locale.getDefault();
        resourceBundle = ResourceBundle.getBundle("text",locale);
    }
    public void changeLocaleAndBundle(Locale locale){
        this.locale=locale;
        resourceBundle = ResourceBundle.getBundle("text",this.locale);
    }
    public String getValueByKey(String key){
        return resourceBundle.getString(key);
    }
}
