package com.sw300.acme.course;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private int level;
    private String description;

    @ManyToMany
    private List<Practice> practiceList;

    @ManyToMany
    private  List<Theory> theoryList;

    @ManyToMany
    private List<LearningObject> learningObjectList;

    @ManyToMany
    private List<Industry> industryList;

    public Job() {
    }

    public Job(String title, int level, String description) {
        this.title = title;
        this.level = level;
        this.description = description;
    }
}
