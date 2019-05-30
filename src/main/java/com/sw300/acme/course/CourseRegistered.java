package com.sw300.acme.course;

import com.sw300.acme.clazz.ClassDayRegistered;
import com.sw300.acme.customer.Enrolled;

import java.util.Date;

/**
 * Created by uengine on 2019. 5. 30..
 */
public class CourseRegistered extends ClassDayRegistered {
    public CourseRegistered(Course course) {
        setDate(new Date());
        setTitle(course.getTitle());
    }
}
