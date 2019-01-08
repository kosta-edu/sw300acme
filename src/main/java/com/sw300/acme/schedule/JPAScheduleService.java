package com.sw300.acme.schedule;

import com.sw300.acme.clazz.Clazz;
import com.sw300.acme.clazz.ClazzRepository;
import com.sw300.acme.clazz.VenuRepository;
import com.sw300.acme.course.Course;
import com.sw300.acme.course.CourseRepository;
import com.sw300.acme.sme.InstructorRepository;
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
    @Autowired
    private InstructorRepository instructorRepo;

    @Override
    public List<Clazz> scheduledClasses(Long courseId) {
        final Optional<Course> course = courseRepo.findById(courseId);
        if(course.isPresent()){
//            final Course course1 = course.get();
//            course1.getClazzList();
//            course1.getDescription();
        }
        return null;
    }

    @Override
    public void associateVenuForClassDay(Long classDayId, Long venuId) {

    }

    @Override
    public void associateInstructorForClassDay(Long classDayId, Long instructorId) {

    }

    @Override
    public void detailOfClassesForCourse(Long courseId) {

    }

    @Override
    public void detailOfClass(Long clazzId) {

    }
}
