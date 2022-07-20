package com.expenses.manager.model;

import java.util.Date;

public class Expense {
    private Integer id;
    private Long amount;
    private String description;
    private Date timestamp;

    public Expense() {

    }

    public Expense(Integer id, Long amount, String description, Date timestamp) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.timestamp = timestamp;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Expense [amount=" + amount + ", description=" + description + ", id=" + id + ", timestamp=" + timestamp
                + "]";
    }

}
