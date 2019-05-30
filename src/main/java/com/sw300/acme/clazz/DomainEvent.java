package com.sw300.acme.clazz;

import lombok.Data;

/**
 * Created by uengine on 2019. 4. 19..
 */

@Data
public class DomainEvent {

    public DomainEvent(){
        setType(getClass().getName());
    }

    String type;
}
