package com.sw300.acme.clazz;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class ClassDay {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int number;
    private Date date;
    private Date startTime;
    private Date endTime;
    private int instructorPay;

    @ManyToOne
    private Clazz clazz;

    @ManyToOne
    private Venu venu;
}
