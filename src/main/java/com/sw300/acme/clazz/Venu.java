package com.sw300.acme.clazz;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Venu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String address;
    private int capacity;
    private String map;

    @JsonIgnore
    @OneToMany(mappedBy = "venu", cascade = CascadeType.ALL)
    private List<ClassDay> classDayList;
}
