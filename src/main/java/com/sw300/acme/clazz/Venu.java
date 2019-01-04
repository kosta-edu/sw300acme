package com.sw300.acme.clazz;

import javax.persistence.*;
import java.util.List;

@Entity
public class Venu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String address;
    private int capacity;
    private String map;

    @OneToMany(mappedBy = "venu", cascade = CascadeType.ALL)
    private List<ClassDay> classDayList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }
}
