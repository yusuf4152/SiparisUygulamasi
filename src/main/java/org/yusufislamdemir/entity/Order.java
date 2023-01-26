package org.yusufislamdemir.entity;

import java.time.LocalDateTime;


public class Order extends BaseEntity {
    private final LocalDateTime localDateTime = LocalDateTime.now();
    private Customer customer;

    private int amount;
    private Company company;

    public Order(int id, String name, Customer customer,int amount,Company company) {
        super(id, name);
        this.customer = customer;
        this.amount=amount;
        this.company= company;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
    @Override
    public String toString() {
        return "Order{" +
                 super.toString() +
                ", localDateTime=" + localDateTime +
                ", customer=" + customer +
                '}';
    }
}
