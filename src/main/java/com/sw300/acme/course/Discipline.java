package com.sw300.acme.course;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;

    @ManyToMany
    private List<Course> courseList;

    @ManyToMany
    private List<Topic> topicList;

    public Discipline() {
    }

    public Discipline(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
