package com.sw300.acme.clazz;

import com.sw300.acme.course.Course;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Clazz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String status;
    private double evaluationRate;

    @OneToMany(mappedBy = "clazz", cascade = CascadeType.ALL)
    private List<ClassDay> classDayList;

    @OneToMany(mappedBy = "clazz", cascade = CascadeType.ALL)
    private List<Course> courseList;

    public Clazz() {
    }
}
