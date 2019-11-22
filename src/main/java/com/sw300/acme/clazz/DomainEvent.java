package com.sw300.acme.clazz;



/**
 * Created by uengine on 2019. 4. 19..
 */

public class DomainEvent {

    public DomainEvent(){
        setType(getClass().getName());
    }

    String type;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
