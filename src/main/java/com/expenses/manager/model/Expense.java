package com.expenses.manager.model;

public class Expense {
    private Integer id;
    private String entryDate;
    private Long amount;
    private String description;

    public Expense() {

    }

    public Expense(Integer id, String entryDate, Long amount, String description) {
        this.id = id;
        this.entryDate = entryDate;
        this.amount = amount;
        this.description = description;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
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
