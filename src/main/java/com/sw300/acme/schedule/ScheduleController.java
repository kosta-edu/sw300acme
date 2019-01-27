package com.sw300.acme.schedule;

import com.sw300.acme.clazz.Clazz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/schedule-service")
public class ScheduleController {

    private ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService){
        this.scheduleService=scheduleService;
    }

    @RequestMapping(value = "/schedules", method = RequestMethod.GET)
    public String schedules(
            @RequestParam(value="courseId") Long courseId
    ) {
        final List<Clazz> clazzes = scheduleService.scheduledClasses(courseId);
        return "clazzes";
    }

    @RequestMapping(value = "/course-clazzes", method = RequestMethod.GET)
    public List<Clazz> clazzes(
            @RequestParam(value="courseId") Long courseId
    ) {
        final List<Clazz> classes = scheduleService.detailOfClassesForCourse(courseId);
        return classes;
    }

    @RequestMapping(value = "/clazzes-detail", method = RequestMethod.GET)
    public Clazz clazzeDetails(
            @RequestParam(value="clazzId") Long clazzId
    ) {
        final Clazz classDetails = scheduleService.detailOfClass(clazzId);
        return classDetails;
    }

    @RequestMapping(value = "/associate-instructor", method = RequestMethod.POST)
    public void associateInstructor(@RequestBody InstructorInfo instructorInfo
    ) {
        scheduleService.associateInstructorForClassDay(instructorInfo.getClassDayId(), instructorInfo.getInstructorId());
    }

    @RequestMapping(value = "/associate-venu", method = RequestMethod.POST)
    public void associateVenu(@RequestBody VenuInfo venuInfo
    ) {
        scheduleService.associateVenuForClassDay(venuInfo.getClassDayId(), venuInfo.getVenuId());
    }
}
