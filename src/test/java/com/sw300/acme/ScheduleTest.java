package com.sw300.acme;

import com.sw300.acme.schedule.ScheduleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AcmeApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ScheduleTest {
    @Autowired
    private ScheduleService scheduleService;

    @Test
    public void scheduledClasses(){
        //given
        //when
        scheduleService.scheduledClasses(1l);
    }

}
