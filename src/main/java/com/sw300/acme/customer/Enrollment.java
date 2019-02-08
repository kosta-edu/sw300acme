package com.sw300.acme.customer;

import com.sw300.acme.clazz.Clazz;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
//@Data
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

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }
}
