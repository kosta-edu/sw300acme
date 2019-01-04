package com.sw300.acme.sme;

import com.sw300.acme.clazz.ClassDay;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String highestEducation;
    private String bankAccount;

    @ManyToOne
    private ClassDay classDay;

    public Instructor() {
    }
}
