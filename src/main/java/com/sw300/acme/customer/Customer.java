package com.sw300.acme.customer;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;

    //TODO 관계로 전환할지 확인필요
    private String job;
    private String industry;

    private String email;
    private String phone;
    private boolean membership;

    @OneToOne
    private PaymentMethod paymentMethod;

    public Customer() {
    }


}
