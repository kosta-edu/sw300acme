package com.sw300.acme.schedule;

import com.sw300.acme.clazz.ClazzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JPAScheduleService implements ScheduleService{
    @Autowired
    private ClazzRepository clazzRepository;


    @Override
    public void schedule() {
    }
}
