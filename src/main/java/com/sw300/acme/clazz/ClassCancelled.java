package com.sw300.acme.clazz;

import com.sw300.acme.customer.Enrolled;
import lombok.Data;

/**
 * Created by uengine on 2019. 4. 19..
 */
@Data
public class ClassCancelled extends DomainEvent{

    public ClassCancelled(){}

    public ClassCancelled(Clazz clazz) {
        super();

        setTitle(clazz.getCourse().getTitle());
    }

    String title;

}
