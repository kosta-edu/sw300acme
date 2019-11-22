package com.sw300.acme.customer;

import com.sw300.acme.AcmeApplication;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date date;
    private int amount;

    @ManyToOne @JoinColumn(name="enrollmentId")
    private Enrollment enrollment;

    @ManyToOne
    private PaymentMethod paymentMethod;

    @PostPersist
    public void checkPaymentAllDone(){

        float price = getEnrollment().getClazz().getPrice();

        float amount = 0;
        for(Payment payment : getEnrollment().getPayments()){
            amount += payment.getAmount();
        }

        if(amount >= price){
            getEnrollment().setStatus("PAYED");
        }else{
            getEnrollment().setStatus("UNPAYED");
        }


        EnrollmentRepository enrollmentRepository = AcmeApplication.getApplicationContext().getBean(EnrollmentRepository.class);
        enrollmentRepository.save(getEnrollment());

    }

    public Payment() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Enrollment getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
