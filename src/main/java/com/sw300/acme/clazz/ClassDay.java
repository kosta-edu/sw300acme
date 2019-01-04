package com.sw300.acme.clazz;

import com.sw300.acme.sme.Instructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @OneToMany(mappedBy = "classDay", cascade = CascadeType.ALL)
    private List<Instructor> instructorList;
}
