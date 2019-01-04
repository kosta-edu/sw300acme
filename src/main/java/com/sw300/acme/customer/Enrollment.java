package com.sw300.acme.customer;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Enrollment {
    @Id
    private EnrollmentPK pk;

    private String status;
    private Date date;
    private int grade;

    public Enrollment() {
    }
}
