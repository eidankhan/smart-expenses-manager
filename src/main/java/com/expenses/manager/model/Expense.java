package com.expenses.manager.model;

import java.util.Date;

public class Expense {
    private Integer id;
    private Date entryDate;
    private Long amount;
    private String description;

    public Expense() {

    }

    public Expense(Integer id, Date entryDate, Long amount, String description) {
        this.id = id;
        this.entryDate = entryDate;
        this.amount = amount;
        this.description = description;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
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

    @Override
    public String toString() {
        return "Expense [amount=" + amount + ", description=" + description + ", entryDate=" + entryDate + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
