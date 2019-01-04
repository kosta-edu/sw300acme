package com.sw300.acme.customer;

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

    @ManyToOne
    private PaymentMethod paymentMethod;

    public Payment() {
    }
}
