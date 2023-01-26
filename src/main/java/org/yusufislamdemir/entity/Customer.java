package org.yusufislamdemir.entity;

import java.time.LocalDate;
import java.util.List;

public class Customer extends BaseEntity {
    private String surName;

    private LocalDate registerDate;


    public Customer(int id, String name, String surName) {
        super(id, name);
        this.surName = surName;
       this.registerDate=LocalDate.now();
    }

    public Customer(int id, String name, String surName, LocalDate registerDate) {
        super(id, name);
        this.surName = surName;
        this.registerDate = registerDate;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                 super.toString()+
                ", surName='" + surName + '\'' +
                ", registerDate=" + registerDate +
                '}';
    }
}
