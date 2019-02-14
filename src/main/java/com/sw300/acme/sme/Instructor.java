package com.sw300.acme.sme;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sw300.acme.clazz.ClazzDay;
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
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
    private ClazzDay clazzDay;

    public Instructor() {
    }
}
