package com.sw300.acme.customer;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String type;
    private String account;

    @OneToOne
    private Customer customer;

    @OneToMany(mappedBy = "paymentMethod", cascade = CascadeType.ALL)
    private List<Payment> paymentList;
}
