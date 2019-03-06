package com.sw300.acme.customer;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;

    private String job;
    private String industry;

    private String email;
    private String phone;
    private boolean membership;

    @OneToOne
    private PaymentMethod paymentMethod;

    public Customer() {
    }

    @Builder
    public Customer(String firstName, String lastName, String job, String industry,  String email, String phone, Boolean membership) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.job = job;
        this.industry = industry;
        this.email = email;
        this.phone = phone;
        this.membership = membership;
    }
}
