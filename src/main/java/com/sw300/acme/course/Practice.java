package com.sw300.acme.course;

import javax.persistence.*;
import java.util.List;

@Entity
public class Practice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;

    @ManyToMany
    private List<LearningObject> learningObjectList;

    @ManyToMany
    private List<Job> jobList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
