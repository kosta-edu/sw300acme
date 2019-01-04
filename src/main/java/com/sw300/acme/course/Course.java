package com.sw300.acme.course;

import javax.persistence.*;
import java.util.List;

@Entity
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

    @ManyToMany
    private List<Discipline> disciplineList;

    //TODO 재귀관계를 어떻게 구현할 것인가

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMaxEnrollment() {
        return maxEnrollment;
    }

    public void setMaxEnrollment(int maxEnrollment) {
        this.maxEnrollment = maxEnrollment;
    }

    public int getMinEnrollment() {
        return minEnrollment;
    }

    public void setMinEnrollment(int minEnrollment) {
        this.minEnrollment = minEnrollment;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }
}
