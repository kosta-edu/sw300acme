package com.sw300.acme.customer;

import com.sw300.acme.AcmeApplication;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
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


}
