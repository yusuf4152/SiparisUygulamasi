package org.yusufislamdemir.entity;

import java.time.LocalDateTime;

public class InVoice extends BaseEntity {
    private int amount;
    public static int numberOfInvoice = 0;
    private Order order;

    private Company company;

    private LocalDateTime dateTime=LocalDateTime.now();

    public InVoice(int id, String name, int amount, Order order, Company company) {
        super(id, name);
        this.amount = amount;
        this.order = order;
        this.company = company;
        numberOfInvoice++;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "InVoice{" +
                super.toString() +
                ", amount=" + amount +
                ", order=" + order +
                ", company=" + company +
                '}';
    }
}
