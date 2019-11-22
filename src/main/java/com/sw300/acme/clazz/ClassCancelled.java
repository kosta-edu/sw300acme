package com.sw300.acme.clazz;

import com.sw300.acme.customer.Enrolled;

/**
 * Created by uengine on 2019. 4. 19..
 */
public class ClassCancelled extends DomainEvent{

    public ClassCancelled(){}

    public ClassCancelled(Clazz clazz) {
        super();

        setTitle(clazz.getCourse().getTitle());
    }

    String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
