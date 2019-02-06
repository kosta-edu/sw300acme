package com.sw300.acme.customer;

import com.sw300.acme.clazz.Clazz;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
public class Enrollment {
    @Id @GeneratedValue
    private Long id;

    private String status;
    private Date date;
    private int grade;

    @ManyToOne @JoinColumn(name="clazzId")
    Clazz clazz;

    @ManyToOne @JoinColumn(name="customerId")
    Customer customer;

    public Enrollment() {
    }

    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "enrollment")
    Set<Payment> payments;


}
