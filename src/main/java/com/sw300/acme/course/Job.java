package com.sw300.acme.course;

import javax.persistence.*;
import java.util.List;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String level;
    private String description;

    @ManyToMany
    private List<Practice> practiceList;

    @ManyToMany
    private  List<Theory> theoryList;

    @ManyToMany
    private List<LearningObject> learningObjectList;

    @ManyToMany
    private List<Industry> industryList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
