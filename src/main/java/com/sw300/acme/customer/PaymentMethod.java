package com.sw300.acme.customer;

import javax.persistence.*;
import java.util.List;

@Entity
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
