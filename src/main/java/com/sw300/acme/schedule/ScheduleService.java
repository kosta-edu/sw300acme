package com.sw300.acme.schedule;

import com.sw300.acme.clazz.Clazz;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ScheduleService {
    List<Clazz> scheduledClasses(Long courseId);
    void associateVenuForClassDay(Long classDayId,Long venuId);
    void associateInstructorForClassDay(Long classDayId,Long instructorId);
    List<Clazz> detailOfClassesForCourse(Long courseId);
    Clazz detailOfClass(Long clazzId);
}
