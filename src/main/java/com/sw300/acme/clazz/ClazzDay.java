package com.sw300.acme.clazz;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sw300.acme.sme.Instructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class ClazzDay {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int number;
    private Date date;
    private Date startTime;
    private Date endTime;
    private int instructorPay;

    @ManyToOne
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
    private Clazz clazz;

    @ManyToOne
    private Venu venu;

    @OneToMany(mappedBy = "clazzDay", cascade = CascadeType.ALL)
    private List<Instructor> instructorList;

    public ClazzDay(){}

    public ClazzDay(int number, Date date, Date startTime, Date endTime, int instructorPay) {
        this.number = number;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.instructorPay = instructorPay;
    }
}
