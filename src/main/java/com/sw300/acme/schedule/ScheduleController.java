package com.sw300.acme.schedule;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleController {
    @RequestMapping(value = "/coursesdddd", method = RequestMethod.GET)
    public String courses() {
        return "courses";
    }

    @RequestMapping(value = "/coursedddd", method = RequestMethod.GET)
    public String course(
            @RequestParam(value="id") int id){
        return "course";
    }
}
