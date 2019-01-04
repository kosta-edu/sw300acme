package com.sw300.acme.customer;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Enrollment {
    @Id
    private EnrollmentPK pk;

    private String status;
    private Date date;
    private int grade;

    public Enrollment() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
