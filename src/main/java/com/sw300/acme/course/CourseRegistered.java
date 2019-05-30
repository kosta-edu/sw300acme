package com.sw300.acme.course;

import com.sw300.acme.clazz.ClassDayRegistered;
import com.sw300.acme.customer.Enrolled;

/**
 * Created by uengine on 2019. 5. 30..
 */
public class CourseRegistered extends ClassDayRegistered {
    public CourseRegistered(Course course) {
        setTitle(course.getTitle());
    }
}
