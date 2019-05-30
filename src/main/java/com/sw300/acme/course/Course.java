package com.sw300.acme.course;

import com.sw300.acme.AcmeApplication;
import com.sw300.acme.EventProducer;
import com.sw300.acme.clazz.ClassDayRegistered;
import com.sw300.acme.clazz.Clazz;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private int duration;
    private String description;
    private int maxEnrollment;
    private int minEnrollment;
    private float unitPrice;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Clazz> clazzList;

    @ManyToMany
    private List<Discipline> disciplineList;

    public Course() {
    }

    public Course(String title, int duration, String description, int maxEnrollment,
                  int minEnrollment, float unitPrice) {
        this.title = title;
        this.duration = duration;
        this.description = description;
        this.maxEnrollment = maxEnrollment;
        this.minEnrollment = minEnrollment;
        this.unitPrice = unitPrice;
    }

    //TODO 재귀관계를 어떻게 구현할 것인가

    @PostPersist
    private void publishCourseRegisteredEvent(){

        EventProducer producer = AcmeApplication.getApplicationContext().getBean(EventProducer.class);
        producer.sendMessage(new CourseRegistered(this));

        System.out.println("Event published");

    }
}
