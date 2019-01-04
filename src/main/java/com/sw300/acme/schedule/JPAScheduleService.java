package com.sw300.acme.schedule;

import com.sw300.acme.clazz.Clazz;
import com.sw300.acme.clazz.ClazzRepository;
import com.sw300.acme.clazz.VenuRepository;
import com.sw300.acme.course.Course;
import com.sw300.acme.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JPAScheduleService implements ScheduleService{
    @Autowired
    private ClazzRepository clazzRepo;
    @Autowired
    private CourseRepository courseRepo;
    @Autowired
    private VenuRepository venuRepo;


    @Override
    public List<Clazz> scheduledClasses(Long courseId) {
        final Optional<Course> course = courseRepo.findById(courseId);
        if(course.isPresent())  return course.get().getClazzList();
        return null;
    }
}
