package com.sw300.acme.schedule;

import com.sw300.acme.clazz.Clazz;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ScheduleService {
    public List<Clazz> scheduledClasses(Long courseId);
}
