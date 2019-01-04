package com.sw300.acme.clazz;

import javax.persistence.*;
import java.util.List;

@Entity
public class Clazz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String status;
    private double evaluationRate;

    @OneToMany(mappedBy = "clazz", cascade = CascadeType.ALL)
    private List<ClassDay> classDayList;

    public Clazz() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getEvaluationRate() {
        return evaluationRate;
    }

    public void setEvaluationRate(double evaluationRate) {
        this.evaluationRate = evaluationRate;
    }
}
