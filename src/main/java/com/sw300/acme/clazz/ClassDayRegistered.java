package com.sw300.acme.clazz;

import lombok.Data;

import java.util.Date;

/**
 * Created by uengine on 2019. 4. 19..
 */
@Data
public class ClassDayRegistered extends DomainEvent{

    public ClassDayRegistered(){} //for serialization

    public ClassDayRegistered(ClazzDay clazzDay) {

        super();

        if(getTitle()!=null)
            setTitle(getTitle());
        else if(clazzDay.getClazz()!=null)
            setTitle(clazzDay.getClazz().getCourse().getTitle());

        setDate(clazzDay.getDate());

    }

    Date date;
    String title;


}
