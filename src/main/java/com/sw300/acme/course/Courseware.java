package com.sw300.acme.course;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Courseware {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private CoursewareType type;
    private String title;
    private String authorType;

    public Courseware() {
    }

    public Courseware(CoursewareType type, String title, String authorType) {
        this.type = type;
        this.title = title;
        this.authorType = authorType;
    }
}
