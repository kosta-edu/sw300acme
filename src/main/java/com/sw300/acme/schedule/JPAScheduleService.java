package com.sw300.acme.schedule;

import com.sw300.acme.clazz.*;
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
    private ClassDayRepository classDayRepo;
    @Autowired
    private CourseRepository courseRepo;
    @Autowired
    private VenuRepository venuRepo;
    @Autowired
    private InstructorRepository instructorRepo;

    @Override
    public List<Clazz> scheduledClasses(Long courseId) {
        final Optional<Course> course = courseRepo.findById(courseId);
        return (course.isPresent()) ? course.get().getClazzList() : null;
    }

    @Override
    public void associateVenuForClassDay(Long classDayId, Long venuId) {
        final Optional<ClassDay> classDay = classDayRepo.findById(classDayId);
        final Optional<Venu> venu = venuRepo.findById(venuId);
        if(venu.isPresent() && classDay.isPresent()){
            final ClassDay classDay1 = classDay.get();
            classDay1.setVenu(venu.get());
        }
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
