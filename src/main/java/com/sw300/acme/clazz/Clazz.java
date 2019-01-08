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

    @Enumerated(EnumType.STRING)
    private ClazzStatus status;
    private double evaluationRate;

    @ManyToOne
    private Course course;

    @OneToMany(mappedBy = "clazz", cascade = CascadeType.ALL)
    private List<ClassDay> classDayList;

    public Clazz() {
    }

    public Clazz(ClazzStatus status, double evaluationRate) {
        this.status = status;
        this.evaluationRate = evaluationRate;
    }
}
