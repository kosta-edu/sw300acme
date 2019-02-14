package com.sw300.acme.schedule;

import com.sw300.acme.clazz.*;
import com.sw300.acme.course.Course;
import com.sw300.acme.course.CourseRepository;
import com.sw300.acme.sme.Instructor;
import com.sw300.acme.sme.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JPAScheduleService implements ScheduleService{
    @Autowired
    private ClazzDayRepository classDayRepo;
    @Autowired
    private CourseRepository courseRepo;
    @Autowired
    private VenuRepository venuRepo;
    @Autowired
    private InstructorRepository instructorRepo;
    @Autowired
    private ClazzRepository clazzRepo;

    @Override
    public List<Clazz> scheduledClasses(Long courseId) {
        final Optional<Course> courseResult = courseRepo.findById(courseId);
        return (courseResult.isPresent()) ? courseResult.get().getClazzList() : null;
    }

    @Override
    public void associateVenuForClassDay(Long classDayId, Long venuId) {
        final Optional<ClazzDay> classDayResult = classDayRepo.findById(classDayId);
        final Optional<Venu> venu = venuRepo.findById(venuId);
        if(venu.isPresent() && classDayResult.isPresent()){
            final ClazzDay clazzDay = classDayResult.get();
            clazzDay.setVenu(venu.get());
            classDayRepo.save(clazzDay);
        }
    }

    @Override
    public void associateInstructorForClassDay(Long classDayId, Long instructorId) {
        final Optional<ClazzDay> classDayResult = classDayRepo.findById(classDayId);
        final Optional<Instructor> instructorResult = instructorRepo.findById(instructorId);
        if(classDayResult.isPresent() && instructorResult.isPresent()){
            final Instructor instructor = instructorResult.get();
            instructor.setClazzDay(classDayResult.get());
            instructorRepo.save(instructor);
        }
    }

    @Override
    public List<Clazz> detailOfClassesForCourse(Long courseId) {
        final Optional<Course> courseResult = courseRepo.findById(courseId);
        return !courseResult.isPresent() ? null : courseResult.get().getClazzList();
    }

    @Override
    public Clazz detailOfClass(Long clazzId) {
        final Optional<Clazz> clazzResult = clazzRepo.findById(clazzId);
        return clazzResult.isPresent() ? clazzResult.get() : null;
    }
}
