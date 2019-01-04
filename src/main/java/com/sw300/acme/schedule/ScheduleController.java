package com.sw300.acme.schedule;

import com.sw300.acme.clazz.Clazz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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
}
