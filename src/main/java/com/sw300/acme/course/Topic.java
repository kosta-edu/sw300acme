package com.sw300.acme.course;

import javax.persistence.*;
import java.util.List;

@Entity

public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;

    @ManyToMany
    private List<LearningObject> learningObjectList;

    @ManyToMany
    private List<Discipline> disciplineList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<LearningObject> getLearningObjectList() {
        return learningObjectList;
    }

    public void setLearningObjectList(List<LearningObject> learningObjectList) {
        this.learningObjectList = learningObjectList;
    }

    public List<Discipline> getDisciplineList() {
        return disciplineList;
    }

    public void setDisciplineList(List<Discipline> disciplineList) {
        this.disciplineList = disciplineList;
    }
}
