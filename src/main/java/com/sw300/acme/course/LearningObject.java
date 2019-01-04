package com.sw300.acme.course;

import javax.persistence.*;
import java.util.List;

@Entity
public class LearningObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;

    @ManyToMany
    private List<Topic> topicList;

    @ManyToMany
    private List<Practice> practiceList;

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
